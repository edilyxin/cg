package com.rc.util;


public class UserInfo {

	private Long userid;//用户编号
	private String sysint_sno;//系统编号
	private String screenname;//账号
	private String username;//姓名
	private String ip;//用户IP
	private String emp_sno;//员工编号
	private String emp_sname;//员工姓名
	private String ud_sno;//二级公司编号
	private String ud_stopname;//一级单位名称
	
	
	public String getEmp_sname() {
		return emp_sname;
	}
	public void setEmp_sname(String emp_sname) {
		this.emp_sname = emp_sname;
	}
	public String getEmp_sno() {
		return emp_sno;
	}
	public void setEmp_sno(String emp_sno) {
		this.emp_sno = emp_sno;
	}
	public String getUd_sno() {
		return ud_sno;
	}
	public void setUd_sno(String ud_sno) {
		this.ud_sno = ud_sno;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUd_stopname() {
		return ud_stopname;
	}
	public void setUd_stopname(String ud_stopname) {
		this.ud_stopname = ud_stopname;
	}

}
