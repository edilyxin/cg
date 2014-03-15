package com.rc.sys.form;

public class MngUserForm {
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String searchA;//查询条件A
	private String searchB;//查询条件B
	private String searchC;//查询条件C
	private String searchD;//查询条件D
	private String searchE;//查询条件E
	private String userid;//主键 自增序列
	private String screenname;//帐号:唯一键
	private String password;//密码
	private String email;//邮箱
	private String firstname;//第一个名字
	private String lastname;//最后一个名字
	private Long status;//状态：0-有效；1-无效
	private String emp_snoby;//被代理员工
	private String emp_sno;//代理员工编号
	private String updatePwd;//修改密码
	private String confirmPwd;//确认密码
	private String right_sparentno;
	private String sysint_sno;//系统编号
	private String right_sno;//权限编号
	
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getRight_sno() {
		return right_sno;
	}
	public void setRight_sno(String right_sno) {
		this.right_sno = right_sno;
	}
	public String getRight_sparentno() {
		return right_sparentno;
	}
	public void setRight_sparentno(String right_sparentno) {
		this.right_sparentno = right_sparentno;
	}
	public String getEmp_snoby() {
		return emp_snoby;
	}
	public void setEmp_snoby(String emp_snoby) {
		this.emp_snoby = emp_snoby;
	}
	public String getEmp_sno() {
		return emp_sno;
	}
	public void setEmp_sno(String emp_sno) {
		this.emp_sno = emp_sno;
	}
	public String getUpdatePwd() {
		return updatePwd;
	}
	public void setUpdatePwd(String updatePwd) {
		this.updatePwd = updatePwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getSearchA() {
		return searchA;
	}
	public void setSearchA(String searchA) {
		this.searchA = searchA;
	}
	public String getSearchB() {
		return searchB;
	}
	public void setSearchB(String searchB) {
		this.searchB = searchB;
	}
	public String getSearchC() {
		return searchC;
	}
	public void setSearchC(String searchC) {
		this.searchC = searchC;
	}
	public String getSearchD() {
		return searchD;
	}
	public void setSearchD(String searchD) {
		this.searchD = searchD;
	}
	public String getSearchE() {
		return searchE;
	}
	public void setSearchE(String searchE) {
		this.searchE = searchE;
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
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}
