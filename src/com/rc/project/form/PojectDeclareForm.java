package com.rc.project.form;

import java.util.Date;

public class PojectDeclareForm {
	
	
	/**
	 * 年份
	 */
	private String rpbSyear;
	//学校
	private String udSno;
	//院系
	private String udSno1;
	//项目名称
	private String rpbSprojectname;
	//项目负责人
	private String empSno;
	//导入时间开始
	private Date rpbSreplyDateStart; 
	//导入时间结束
	private Date rpbSreplyDateEnd; 
	
	private String pageSQLA;//分页前段
	
	private String pageSQLB;//分页后段
	
	public String getRpbSyear() {
		return rpbSyear;
	}



	public void setRpbSyear(String rpbSyear) {
		this.rpbSyear = rpbSyear;
	}



	public String getUdSno() {
		return udSno;
	}



	public void setUdSno(String udSno) {
		this.udSno = udSno;
	}



	public String getUdSno1() {
		return udSno1;
	}



	public void setUdSno1(String udSno1) {
		this.udSno1 = udSno1;
	}



	public String getRpbSprojectname() {
		return rpbSprojectname;
	}



	public void setRpbSprojectname(String rpbSprojectname) {
		this.rpbSprojectname = rpbSprojectname;
	}



	public String getEmpSno() {
		return empSno;
	}



	public void setEmpSno(String empSno) {
		this.empSno = empSno;
	}



	public Date getRpbSreplyDateStart() {
		return rpbSreplyDateStart;
	}



	public void setRpbSreplyDateStart(Date rpbSreplyDateStart) {
		this.rpbSreplyDateStart = rpbSreplyDateStart;
	}



	public Date getRpbSreplyDateEnd() {
		return rpbSreplyDateEnd;
	}



	public void setRpbSreplyDateEnd(Date rpbSreplyDateEnd) {
		this.rpbSreplyDateEnd = rpbSreplyDateEnd;
	}



	public String getPageSQLA() {
		return pageSQLA;
	}



	public void setPageSQLA(String pageSQLA) {
		this.pageSQLA = pageSQLA;
	}



	public String getPageSQLB() {
		return pageSQLB;
	}



	public void setPageSQLB(String pageSQLB) {
		this.pageSQLB = pageSQLB;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
