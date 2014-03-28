package com.rc.project.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import oracle.sql.DATE;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ibatis.sqlmap.engine.transaction.TransactionManager;
import com.rc.base.dao.EmpDAO;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngEmp;
import com.rc.base.vo.MngUnitDepart;
import com.rc.project.dao.RpReportBeginDAO;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectDeclareService;
import com.rc.project.vo.RpReportBegin;
import com.rc.util.DateUtils;

public class ProjectDeclareServiceImpl implements ProjectDeclareService {

	private RpReportBeginDAO rpReportBeginDAO;
	private String filepath; // 文档路径
	private String filename; // 文档名称
	private EmpDAO empDAO; // 员工表
	private UnitDepartDAO unitDepartDAO; // 院系表
	private MngUnitDepartForm udform = new MngUnitDepartForm();
	private MngEmpForm empform = new MngEmpForm();
	private RpReportBeginForm form = new RpReportBeginForm();
	private List<RpReportBeginForm> forms = new ArrayList<RpReportBeginForm>(0);
	private final String ERROR = "error";
	private String msg = "";
	
	private DataSourceTransactionManager transactionManager;

	private List<String> errList = new ArrayList<String>(0);

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}
	
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取错误列表
	 * 
	 * @return
	 */
	public List<String> getErrList() {
		return errList;
	}

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO)  {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	@Override
	public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) throws Exception {
		return this.rpReportBeginDAO.selectByPage(pForm);
	}

	@Override
	public int findSize(RpReportBeginForm pForm) throws Exception {
		return this.rpReportBeginDAO.selectSize(pForm);
	}

	@Override
	public int importData(RpReportBeginForm pForm) throws Exception {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try{
			checkExcl(pForm.getFilePath(), pForm.getRPB_SREPLYBY());
			transactionManager.commit(status);
		}catch (Exception e){
			forms.clear();
			transactionManager.rollback(status);
			throw new Exception(e);
		}
		return forms.size();
	}

	private void checkExcl(String filename, String curname) throws Exception {
		// 获取excel文件
		final String path = filename;
		Workbook book = Workbook.getWorkbook(new File(path));
		Sheet sheet = book.getSheet(1);
		String pName = ""; // 项目名称
		String e = ""; // 负责人名称
		String ud = ""; // 院系名称
		String sno = ""; // 项目负责人编号
		String udno = ""; // 院系编号
		int rows = sheet.getRows();
		int nnum = 1;
		this.errList.clear();
		this.forms.clear();
		if (sheet.getCell(1, 1).getContents() != null && sheet.getCell(1, 0).getContents().equalsIgnoreCase("院系")) {
			for (int row = 1; row < rows; row++) {
				form = new RpReportBeginForm();
				// 编号
				form.setRPB_SNO(this.buildSNO());
				// 序号
				form.setRPB_NNUM(new BigDecimal(nnum));
				// 院系
				ud = sheet.getCell(1, row).getContents();
				if (ud.trim().equalsIgnoreCase(""))
					continue;
				nnum++;
				udno = this.findUDSno(ud);
				if (udno.equalsIgnoreCase(ERROR)) {
					// 测试环境下，如果有错
					throw new IllegalStateException(this.errList.toString());
				}
				form.setUD_SNO1(udno);
				// 学校
				form.setUD_SNO(form.getUD_SNO1().substring(0, 3));
				// 申报部门名称
				form.setRPB_SREPORTUNITNAME(ud);
				// 项目负责人编号
				e = sheet.getCell(3, row).getContents();
				sno = this.findEMPSno(e, form.getUD_SNO1());
				if (sno.equalsIgnoreCase(ERROR)) {
					throw new IllegalStateException(this.errList.toString());
				}
				form.setEMP_SNO(sno);
				// 项目负责人名称
				form.setRPB_SPERSON(e);
				// 项目名称
				pName = sheet.getCell(2, row).getContents();
				if(!this.checkProject(pName, form.getUD_SNO1(),form.getEMP_SNO())){
					this.errList.add(pName + " 已经存在!"); //项目重名
					throw new IllegalStateException(this.errList.toString());
				}
				form.setRPB_SPROJECTNAME(pName);
				// 项目类别
				form.setRPB_SPROTYPE("0");
				if (form.getRPB_SPROJECTNAME().split("—").length > 0 && form.getRPB_SPROJECTNAME().split("—")[0].equalsIgnoreCase("设备购置")) {
					form.setRPB_SPROTYPE("1");
				}
				// 年度
				form.setRPB_SYEAR(DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4));
				// 申请金额（万元）
				form.setRPB_SREPORTTOTAL(new BigDecimal(sheet.getCell(4, row).getContents().trim()));
				// 项目重要性 0 非常必要 1 必要 2 一般 3 不必要 （5678）
				form.setRPB_SLEVEL("2");   //默认为一般
				if (!sheet.getCell(5, row).getContents().trim().equalsIgnoreCase("")) {
					form.setRPB_SLEVEL("0");
				}
				if (!sheet.getCell(6, row).getContents().trim().equalsIgnoreCase("")) {
					form.setRPB_SLEVEL("1");
				}
				if (!sheet.getCell(7, row).getContents().trim().equalsIgnoreCase("")) {
					form.setRPB_SLEVEL("2");
				}
				if (!sheet.getCell(8, row).getContents().trim().equalsIgnoreCase("")) {
					form.setRPB_SLEVEL("3");
				}
				// 建议金额（万元）
				String num = sheet.getCell(9, row).getContents().trim();
				form.setRPB_SSUGGESTTOTAL(new BigDecimal((num.equals("")) ? "0" : num));

				// 专家意见
				form.setRPB_SMEM((sheet.getCell(10, row).getContents()!=null)?sheet.getCell(10, row).getContents().trim():"");
				// 是否删除
				form.setRPB_SISDEL("0");
				// 是否有效
				form.setRPB_SISVALID("0");
				// 创建人
				form.setRPB_SREPLYBY(curname);
				// 创建时间
				form.setRPB_SREPLYDATE(new Date(System.currentTimeMillis()));
				this.forms.add(form);
				this.rpReportBeginDAO.insertSelective(form);
			}
		}else {
			throw new IllegalStateException("不是一个合法的初申报文档");
		}
	}

	/**
	 * 检查同人，同年，同部门是否有重名项目
	 * 
	 * @param projectname
	 * @return
	 */
	private boolean checkProject(String projectname, String udsno, String empsno) {
		form.setEMP_SNO(empsno);
		form.setUD_SNO1(udsno);
		form.setRPB_SPROJECTNAME(projectname);
		int count = this.rpReportBeginDAO.selectSize(form);
		return (count < 1) ? true : false;
	}

	/**
	 * 通过院系名称得到院系编码
	 * 
	 * @param name
	 *            院系名称
	 * @return
	 */
	private String findUDSno(String name) {
		@SuppressWarnings("unchecked")
		List<MngUnitDepart> list = this.unitDepartDAO.findBySSname(name);

		if (list.size() != 1) {
			this.errList.add(name + " 找到 " + list.size() + " 个院系编号");
			return ERROR;
		}

		return ((MngUnitDepart) list.get(0)).getUd_sno();
	}

	/**
	 * 通过项目负责人来查询项目负责人编号，需要匹配所在院系
	 * 
	 * @param name
	 * @return
	 */
	private String findEMPSno(String name, String udson1) {
		empform.setEmp_sname(name);
		empform.setUd_sno("");
		empform.setUd_sno1("");
		empform.setUd_sno2("");
		if(udson1.length() == 3){
			empform.setUd_sno(udson1);
		}
		if(udson1.length() == 5){
			empform.setUd_sno1(udson1);
		}
		if(udson1.length() == 7){
			empform.setUd_sno2(udson1);
		}
		List list = this.empDAO.findbyNameAndSno1(empform);
		// 找到多个 或者 一个没有找到
		if (list.size() != 1) {
			this.errList.add(name + " 找到 " + list.size() + " 个员工编号");
			return ERROR;
		}
		return ((MngEmp) list.get(0)).getEmp_sno();
	}

	/**
	 * 生成项目编号 前缀(CSB)+二位年+加六位流水号
	 * 
	 * @return
	 */
	private String buildSNO() {
		return "CSB" + DateUtils.getDate(new Date(System.currentTimeMillis())).substring(3, 4) + UUID.randomUUID().toString().substring(0, 5);
	}


	@Override
	public String toString() {
		return "ProjectDeclareServiceImpl [rpReportBeginDAO=" + rpReportBeginDAO + ", filepath=" + filepath + ", filename=" + filename + ", empDAO=" + empDAO + ", unitDepartDAO=" + unitDepartDAO
				+ ", udform=" + udform + ", empform=" + empform + ", form=" + form + ", forms=" + forms + ", ERROR=" + ERROR + ", errList=" + errList + "]";
	}
	
	/**
	 * 对初申报的表头做校验,需要载入模板来做检查
	 */
	private void checkSheetheard(Sheet sheet) throws Exception{
		//序号	院系	项目名称	项目负责人	申请金额（万元）	项目重要性				建议金额（万元）	专家意见
		//非常必要	必要	一般	不必要		
        //载入初申报模板
		//扫描表头并且比对
		//sheet.getCell(0, 0).getContents() != null && sheet.getCell(1, 0).getContents().equalsIgnoreCase("序号");
	}

}
