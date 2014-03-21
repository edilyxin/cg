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

import oracle.sql.DATE;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.rc.base.dao.EmpDAO;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngEmp;
import com.rc.base.vo.MngUnitDepart;
import com.rc.project.dao.RpReportBeginDAO;
import com.rc.project.form.PojectDeclareForm;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectDeclareService;
import com.rc.project.vo.RpReportBegin;
import com.rc.project.vo.RpReportBeginExample;
import com.rc.util.DateUtils;

public class ProjectDeclareServiceImpl implements ProjectDeclareService {

	private RpReportBeginDAO rpReportBeginDAO;
	private RpReportBeginExample example;
	private String filepath;    //文档路径
	private String filename;    //文档名称
	private EmpDAO empDAO;      //员工表
	private UnitDepartDAO unitDepartDAO;    //院系表
	private MngUnitDepartForm udform = new MngUnitDepartForm();
	private MngEmpForm empform = new MngEmpForm();
	private RpReportBeginForm form = new RpReportBeginForm();
	private List<RpReportBeginForm> forms = new ArrayList<RpReportBeginForm>(0);
	private final String ERROR = "error"; 
	
	private List<String> errList = new ArrayList<String>(0);

	
	
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}

	/**
	 * 获取错误列表
	 * @return
	 */
	public List<String> getErrList() {
		return errList;
	}

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO) {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	@Override
	public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectByPage(pForm);
	}

	@Override
	public int findSize(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectSize(pForm);
	}

	@Override
	public int importData(RpReportBeginForm pForm) {
		checkExcl(pForm.getFilePath() + pForm.getFileName(),pForm.getRPB_SALTERBY());
		for(int i = 0 ; i< forms.size();i++){
			this.rpReportBeginDAO.insertSelective(forms.get(i));
		}
		return 0;
	}
	
	
	
	private boolean checkExcl(String filename,String curname){
		//获取excel文件
		final String path = "D:\\workspace-ee\\cg\\WebRoot\\WEB-INF\\classes\\import\\20140318000001\\1234.xls";
		
				
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			
			Sheet sheet = book.getSheet(1);
			
			String pName = "";   //项目名称
			String e = "";    //负责人名称
			String ud = "";   //院系名称
			String sno = "";  //项目负责人编号
			String udno = ""; //院系编号
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			int nnum = 1;
			for (int row = 1 ; row < rows ; row++){
				/*for(int col = 1 ; col < cols ; col++){
					sheet.get
				}*/
				form = new RpReportBeginForm();
				//编号
				form.setRPB_SNO(this.buildSNO());
				//序号
				form.setRPB_NNUM(new BigDecimal(nnum));
				//院系	
				ud = sheet.getCell(1,row).getContents();
				if(ud.trim().equalsIgnoreCase(""))
					continue;
				nnum++;
				udno = this.findUDSno(ud);
				if(udno.equalsIgnoreCase(ERROR)){
					//测试环境下，如果有错
					udno = "D0101";
				    /*forms.clear();
					return false;  //错误院系编号    //TODO 要验证
*/				}
				form.setUD_SNO1(udno);
				//学校
				form.setUD_SNO(form.getUD_SNO1().substring(0,2));
				//申报部门名称
				form.setRPB_SREPORTUNITNAME(ud);
				//项目负责人编号
				e = sheet.getCell(3,row).getContents();
				sno = this.findEMPSno(e, form.getUD_SNO1());
				if(sno.equalsIgnoreCase(ERROR)){
				    /*forms.clear();
					return  false;  //错误的负责人名称*/	 //TODO 要验证
					sno = "E130016";
			    }
				form.setEMP_SNO(sno);
				//项目负责人名称
				form.setRPB_SPERSON(e);
				//项目名称	
				pName = sheet.getCell(2,row).getContents();
				/*if(!this.checkProject(pName, form.getUD_SNO1(), form.getEMP_SNO())){
				 * forms.clear();
					return false; //项目重名   //TODO 要验证
				}*/
				form.setRPB_SPROJECTNAME(pName);
				//项目类别
				form.setRPB_SPROTYPE("0");
				if(form.getRPB_SPROJECTNAME().split("—").length > 0 && form.getRPB_SPROJECTNAME().split("—")[0].equalsIgnoreCase("设备购置")){
					form.setRPB_SPROTYPE("1");
				}
				//年度
				form.setRPB_SYEAR(DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0,4));
				//申请金额（万元）
				form.setRPB_SREPORTTOTAL(new BigDecimal(sheet.getCell(4,row).getContents().trim()));
				//项目重要性   0 非常必要 1 必要 2 一般 3 不必要	（5678）
				if(!sheet.getCell(5,row).getContents().trim().equalsIgnoreCase("")){
					form.setRPB_SLEVEL("0");
				}
				if(!sheet.getCell(6,row).getContents().trim().equalsIgnoreCase("")){
					form.setRPB_SLEVEL("1");
				}
				if(!sheet.getCell(7,row).getContents().trim().equalsIgnoreCase("")){
					form.setRPB_SLEVEL("2");
				}
				if(!sheet.getCell(8,row).getContents().trim().equalsIgnoreCase("")){
					form.setRPB_SLEVEL("3");
				}
                //建议金额（万元）
				String num = sheet.getCell(9,row).getContents().trim();
				form.setRPB_SSUGGESTTOTAL(new BigDecimal((num.equals(""))? "0" : num));
				
				//专家意见
				form.setRPB_SMEM(sheet.getCell(10,row).getContents().trim());
				//是否删除
				form.setRPB_SISDEL("1");
				//是否有效
				form.setRPB_SISVALID("1");
				//创建人
				form.setRPB_SREPLYBY(curname);
				//创建时间
				form.setRPB_SREPLYDATE(new Date(System.currentTimeMillis()));
				System.out.println(form.toString());
				forms.add(form);
			}
			System.out.println("rows : " +rows + " cols:" + cols);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//按照模板匹配文件
		
		return true;
	}
	
	/**
	 * 检查同人，同年，同部门是否有重名项目
	 * @param projectname
	 * @return
	 */
	private boolean checkProject(String projectname,String udsno,String empsno){
		form.setEMP_SNO(empsno);
		form.setUD_SNO1(udsno);
		form.setRPB_SPROJECTNAME(projectname);
		int count = this.rpReportBeginDAO.selectSize(form);
		return (count < 1) ? true : false;
	}
	
	/**
	 * 通过院系名称得到院系编码
	 * @param name 院系名称
	 * @return
	 */
	private String findUDSno(String name){
		List list = this.unitDepartDAO.findBySSname(name);
		
		if(list.size() != 1){
			this.errList.add(name + " 找到 "+ list.size() +" 个院系编号");
			return ERROR;
		}
		
		return ((MngUnitDepart)list.get(0)).getUd_sno1();
	}
	
	/**
	 * 通过项目负责人来查询项目负责人编号，需要匹配所在院系
	 * @param name
	 * @return
	 */
	private String findEMPSno(String name,String udson1){
		empform.setEmp_sname(name);
		empform.setUd_sno1(udson1);
		List list = this.empDAO.findbyNameAndSno1(empform);
		// 找到多个 或者 一个没有找到
		if(list.size() != 1 ){
			this.errList.add(name + " 找到 " + list.size() +" 个员工编号");
			return ERROR;
		}
		return ((MngEmp)list.get(0)).getEmp_sno();
	}
	
	/**
	 * 生成项目编号
	 * 前缀(CSB)+二位年+加六位流水号
	 * @return
	 */
	private String buildSNO(){
		return "CSB" + DateUtils.getDate(new Date(System.currentTimeMillis())).substring(3,4) + UUID.randomUUID().toString().substring(0, 5);
	}
	
	
	public static void main(String[] args){
		ProjectDeclareServiceImpl p = new ProjectDeclareServiceImpl();
		p.importData(null);
	}
	
	

	@Override
	public String toString() {
		return "ProjectDeclareServiceImpl [rpReportBeginDAO=" + rpReportBeginDAO + ", example=" + example + ", filepath=" + filepath + ", filename=" + filename + ", empDAO=" + empDAO
				+ ", unitDepartDAO=" + unitDepartDAO + ", udform=" + udform + ", empform=" + empform + ", form=" + form + ", forms=" + forms + ", ERROR=" + ERROR + ", errList=" + errList + "]";
	}
	
	
}
