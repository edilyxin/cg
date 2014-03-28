package com.rc.project.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jxl.Sheet;
import jxl.Workbook;

import com.rc.base.dao.EmpDAO;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.base.form.MngEmpForm;
import com.rc.base.vo.MngEmp;
import com.rc.base.vo.MngUnitDepart;
import com.rc.project.dao.RpMiddleDAO;
import com.rc.project.dao.RpReportBeginDAO;
import com.rc.project.dao.RpReportDAO;
import com.rc.project.form.RpMiddleForm;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.form.RpReportForm;
import com.rc.project.service.ProjectReportService;
import com.rc.project.vo.RpReportBegin;
import com.rc.util.DateUtils;
import com.rc.util.StringUtil;

public class ProjectReportServiceImpl implements ProjectReportService {

	private RpReportDAO rpReportDAO;
	private RpReportForm form;
	private UnitDepartDAO unitDepartDAO;
	private RpReportBeginDAO rpReportBeginDAO;
	private EmpDAO empDAO; // 员工表
	private RpMiddleDAO rpMiddleDAO; // 项目初申报 项目申报关联表

	private DataSourceTransactionManager transactionManager;

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public List findPage(RpReportForm form) {
		// TODO Auto-generated method stub
		return this.rpReportDAO.selectByPage(form);
	}

	@Override
	public void importData(RpReportForm form1) throws Exception {
		if (form1 == null || StringUtils.isEmpty(form1.getFilePath())) {
			throw new IllegalStateException("上传文件不能为空");
		}
		final String path = form1.getFilePath();
		Workbook book = Workbook.getWorkbook(new File(path));
		Sheet sheet = book.getSheet(0);
		int type = 0;
		String rpbson = "";
		RpMiddleForm f;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			if (StringUtils.isNotEmpty(sheet.getCell(0, 2).getContents()) && StringUtils.isNotEmpty(sheet.getCell(1, 2).getContents())
					&& sheet.getCell(0, 2).getContents().trim().equalsIgnoreCase("序号") && sheet.getCell(1, 2).getContents().trim().equalsIgnoreCase("项目所在单位")) {
				for (int i = 3; i < sheet.getRows() - 1; i++) {
					form = new RpReportForm();
					// 编号
					form.setRP_SNO(this.buildRPSNO());
					MngUnitDepart m = this.findUDSNO1(sheet.getCell(1, i).getContents().trim());
					// 所属单位
					form.setUD_SNO(m.getUd_sno().substring(0, 3));
					// 申报单位
					form.setUD_SNO1(m.getUd_sno());
					// 申报单位名称
					form.setRP_SREPORTUNITNAME(sheet.getCell(1, i).getContents().trim());
					// 项目名称
					form.setRP_SPROJECTNAME(sheet.getCell(2, i).getContents().trim());
					// 年度
					form.setRP_SYEAR(DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4));
					// 项目负责人员工编号
					form.setEMP_SNO(findEMPSNO(sheet.getCell(3, i).getContents().trim(), m.getUd_sno1()));
					// 项目负责人
					form.setRP_SPERSON(sheet.getCell(3, i).getContents().trim());
					// 项目负责人所属单位
					form.setUD_SNO2(m.getUd_sno());
					// 项目负责人所属单位名称
					form.setRP_SPERDEPARTNAME(m.getUd_sname());
					// TODO 检查重复
					this.checkExistProject(form.getRP_SPROJECTNAME(), form.getUD_SNO1(), form.getEMP_SNO());
					// 类别

					form.setRP_SPROTYPE((sheet.getCell(2, i).getContents().trim().split("-")[0].equalsIgnoreCase("实验室建设")) ? "1" : "0");
					// 申报金额（万元） //TODO 金额，要是为空就挂了！
					if (StringUtils.isNotEmpty(sheet.getCell(4, i).getContents().trim())) {
						form.setRP_SREPORTTOTAL(new BigDecimal(sheet.getCell(4, i).getContents().trim()));
					} else {
						form.setRP_SREPORTTOTAL(new BigDecimal(0));
					}
					// 批复金额（万元）
					if (StringUtils.isNotEmpty(sheet.getCell(5, i).getContents().trim())) {
						form.setRP_STOTAL(new BigDecimal(sheet.getCell(5, i).getContents().trim()));
					}
					// 项目类型 自主/指定 0/1
					form.setRP_STYPE(sheet.getCell(6, i).getContents().trim().equalsIgnoreCase("自主") ? "1" : "0");
					// 是否删除
					form.setRP_SISDEL("0");
					// 是否有效
					form.setRP_SISVALID("0");
					// 创建人
					form.setRP_SREPLYBY(form1.getRP_SREPLYBY());
					// 填写日期
					form.setRP_SREPLYDATE(new Date(System.currentTimeMillis()));
					// 修改人
					// 修改日期
					// 初申报编号
					rpbson = findCSBSNO(form.getRP_SPERDEPARTNAME(), form.getRP_SPERSON());
					if (StringUtils.isNotEmpty(rpbson)) {
						form.setRPB_SNO(rpbson);
						// TODO 这里需要修改
						f = new RpMiddleForm();
						f.setRP_SNO(rpbson);
						f.setRPB_SNO(form.getRPB_SNO());
						this.rpMiddleDAO.insertSelective(f);
					}
					this.rpReportDAO.insertSelective(form);
				}
			} else {
				throw new IllegalStateException("上传文件不是项目汇总文件");
			}
            this.transactionManager.commit(status);
		} catch (Exception e) {
            this.transactionManager.rollback(status);
            throw e;
		}
	}

	private String buildRPSNO() {
		return "SB" + DateUtils.getDate(new Date(System.currentTimeMillis())).substring(2, 4) + UUID.randomUUID().toString().substring(0, 3);
	}

	private MngUnitDepart findUDSNO1(String ssname) throws Exception {
		List list = this.unitDepartDAO.findBySSname(ssname);
		if (list.size() != 1) {
			throw new IllegalStateException("单位 " + ssname + " 未找到唯一的单位记录");
		}
		return ((MngUnitDepart) list.get(0));
	}

	private String findEMPSNO(String name, String sno) {
		MngEmpForm form = new MngEmpForm();
		form.setEmp_sname(name);
		form.setUd_sno1(sno);
		List list = this.empDAO.findbyNameAndSno1(form);
		if (list.size() != 1) {
			throw new IllegalStateException("申请人 " + name + ",院系编号" + sno + " 未找到唯一的员工编号");
		}
		return ((MngEmp) (this.empDAO.findbyNameAndSno1(form)).get(0)).getEmp_sno();
	}

	/**
	 * 通过项目名称和申报人名称去关联初申报的编号
	 * 
	 * @param pname
	 * @param sbrname
	 * @return
	 */
	private String findCSBSNO(String pname, String sbrname) {
		RpReportBeginForm form = new RpReportBeginForm();
		form.setRPB_SPROJECTNAME(pname);
		form.setRPB_SPERSON(sbrname);
		List list = this.rpReportBeginDAO.selectByPage(form);
		return (list.size() == 1) ? ((RpReportBegin) list.get(0)).getRPB_SNO() : "";
	}

	/**
	 * 检查是否有重复的项目
	 * 
	 * @param pname
	 * @param usno
	 * @param esno
	 */
	private void checkExistProject(String pname, String usno, String esno) throws Exception {
        RpReportForm record = new RpReportForm();
        record.setUD_SNO1(usno.trim());
        record.setEMP_SNO(esno.trim());
        record.setRP_SPROJECTNAME(pname.trim());
		if(this.rpReportDAO.selectByCount(record) > 0 ){
			throw new IllegalStateException("项目： " + pname + "在部门" + usno + " 的员工 "+ esno +" 头上已经申报过");
		}
	}
	
	/**
	 * 检查导入的文档类型
	 * @param sheet
	 * @throws Exception
	 */
	private void checkImportTemplate(Sheet sheet) throws Exception{
		// TODO XXXX
	}

	public RpReportDAO getRpReportDAO() {
		return rpReportDAO;
	}

	public void setRpReportDAO(RpReportDAO rpReportDAO) {
		this.rpReportDAO = rpReportDAO;
	}

	public RpReportForm getForm() {
		return form;
	}

	public void setForm(RpReportForm form) {
		this.form = form;
	}

	public UnitDepartDAO getUnitDepartDAO() {
		return unitDepartDAO;
	}

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}

	public EmpDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public RpReportBeginDAO getRpReportBeginDAO() {
		return rpReportBeginDAO;
	}

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO) {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	public RpMiddleDAO getRpMiddleDAO() {
		return rpMiddleDAO;
	}

	public void setRpMiddleDAO(RpMiddleDAO rpMiddleDAO) {
		this.rpMiddleDAO = rpMiddleDAO;
	}

	@Override
	public int findSize(RpReportForm form) throws Exception {
		return this.rpReportDAO.selectByCount(form);
	}

}
