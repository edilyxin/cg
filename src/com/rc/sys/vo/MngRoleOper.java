package com.rc.sys.vo;
/**
 * 
 * 此类描述的是：操作权限
 * @author: hc
 * @version: 2013-5-30下午02:46:34
 */
public class MngRoleOper {
	private String role_sno;
	private String oper_sno;
	private String right_sno;
	private String rro_sdef1;//系统编号
	
	public String getRro_sdef1() {
		return rro_sdef1;
	}
	public void setRro_sdef1(String rro_sdef1) {
		this.rro_sdef1 = rro_sdef1;
	}
	public String getRole_sno() {
		return role_sno;
	}
	public void setRole_sno(String role_sno) {
		this.role_sno = role_sno;
	}
	public String getOper_sno() {
		return oper_sno;
	}
	public void setOper_sno(String oper_sno) {
		this.oper_sno = oper_sno;
	}
	public String getRight_sno() {
		return right_sno;
	}
	public void setRight_sno(String right_sno) {
		this.right_sno = right_sno;
	} 
	
}
