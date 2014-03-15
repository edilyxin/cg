package com.rc.sys.form;

import java.math.BigDecimal;

public class MngRoleForm {
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String searchA;//查询条件A
	private String searchB;//查询条件B
	private String searchC;//查询条件C
	private String searchD;//查询条件D
	private String searchE;//查询条件E
	private String role_sno;//角色编号
	private String sysint_sno;//系统编号:公共角色时，则为空，否则不能为空
	private String role_stype;//角色类别:0公共角色(所有系统共用)，1系统角色
	private String role_sname;//角色名称
	private String role_sdesc;//角色描述
	private String role_sisdefault;//是否缺省角色:公共的不能作为缺省，每个系统只能有一个缺省,0是，1否
	private String role_sisdel;//是否删除：0。未删；1。删除
	private String role_sisvalid;//是否有效：0-有效；1-无效
	private String role_sreplyby;//创建人
	private String role_dreplydate;//创建时间
	private String role_salterby;//修改人
	private String role_dalterdate;//修改时间
	private String rro_sdef1;//
	private String role_sdef1;
	private String role_sdef2;
	private String role_sdef3;
	private String role_sdef4;
	private String role_sdef5;
	private String role_sdef6;
	private String role_sdef7;
	private String role_sdef8;
	private String role_sdef9;
	private String role_sdef10;
	private String role_sdef11;
	private String role_sdef12;
	private String role_sdef13;
	private String role_sdef14;
	private String role_sdef15;
	private String role_sdef16;
	private String role_sdef17;
	private String role_sdef18;
	private String role_sdef19;
	private String role_sdef20;
	private String role_ddef1;
	private String role_ddef2;
	private String role_ddef3;
	private String role_ddef4;
	private String role_ddef5;
	private String role_ddef6;
	private String role_ddef7;
	private String role_ddef8;
	private String role_ddef9;
	private String role_ddef10;
	private BigDecimal role_ndef1;
	private BigDecimal role_ndef2;
	private BigDecimal role_ndef3;
	private BigDecimal role_ndef4;
	private BigDecimal role_ndef5;
	private BigDecimal role_ndef6;
	private BigDecimal role_ndef7;
	private BigDecimal role_ndef8;
	private BigDecimal role_ndef9;
	private BigDecimal role_ndef10;
	
	public String getRro_sdef1() {
		return rro_sdef1;
	}
	public void setRro_sdef1(String rro_sdef1) {
		this.rro_sdef1 = rro_sdef1;
	}
	public String toString() {
		return role_sname+"--"+role_sdesc;
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
	public String getRole_sno() {
		return role_sno;
	}
	public void setRole_sno(String role_sno) {
		this.role_sno = role_sno;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getRole_stype() {
		return role_stype;
	}
	public void setRole_stype(String role_stype) {
		this.role_stype = role_stype;
	}
	public String getRole_sname() {
		return role_sname;
	}
	public void setRole_sname(String role_sname) {
		this.role_sname = role_sname;
	}
	public String getRole_sdesc() {
		return role_sdesc;
	}
	public void setRole_sdesc(String role_sdesc) {
		this.role_sdesc = role_sdesc;
	}
	public String getRole_sisdefault() {
		return role_sisdefault;
	}
	public void setRole_sisdefault(String role_sisdefault) {
		this.role_sisdefault = role_sisdefault;
	}
	public String getRole_sisdel() {
		return role_sisdel;
	}
	public void setRole_sisdel(String role_sisdel) {
		this.role_sisdel = role_sisdel;
	}
	public String getRole_sisvalid() {
		return role_sisvalid;
	}
	public void setRole_sisvalid(String role_sisvalid) {
		this.role_sisvalid = role_sisvalid;
	}
	public String getRole_sreplyby() {
		return role_sreplyby;
	}
	public void setRole_sreplyby(String role_sreplyby) {
		this.role_sreplyby = role_sreplyby;
	}
	public String getRole_dreplydate() {
		return role_dreplydate;
	}
	public void setRole_dreplydate(String role_dreplydate) {
		this.role_dreplydate = role_dreplydate;
	}
	public String getRole_salterby() {
		return role_salterby;
	}
	public void setRole_salterby(String role_salterby) {
		this.role_salterby = role_salterby;
	}
	public String getRole_dalterdate() {
		return role_dalterdate;
	}
	public void setRole_dalterdate(String role_dalterdate) {
		this.role_dalterdate = role_dalterdate;
	}
	public String getRole_sdef1() {
		return role_sdef1;
	}
	public void setRole_sdef1(String role_sdef1) {
		this.role_sdef1 = role_sdef1;
	}
	public String getRole_sdef2() {
		return role_sdef2;
	}
	public void setRole_sdef2(String role_sdef2) {
		this.role_sdef2 = role_sdef2;
	}
	public String getRole_sdef3() {
		return role_sdef3;
	}
	public void setRole_sdef3(String role_sdef3) {
		this.role_sdef3 = role_sdef3;
	}
	public String getRole_sdef4() {
		return role_sdef4;
	}
	public void setRole_sdef4(String role_sdef4) {
		this.role_sdef4 = role_sdef4;
	}
	public String getRole_sdef5() {
		return role_sdef5;
	}
	public void setRole_sdef5(String role_sdef5) {
		this.role_sdef5 = role_sdef5;
	}
	public String getRole_sdef6() {
		return role_sdef6;
	}
	public void setRole_sdef6(String role_sdef6) {
		this.role_sdef6 = role_sdef6;
	}
	public String getRole_sdef7() {
		return role_sdef7;
	}
	public void setRole_sdef7(String role_sdef7) {
		this.role_sdef7 = role_sdef7;
	}
	public String getRole_sdef8() {
		return role_sdef8;
	}
	public void setRole_sdef8(String role_sdef8) {
		this.role_sdef8 = role_sdef8;
	}
	public String getRole_sdef9() {
		return role_sdef9;
	}
	public void setRole_sdef9(String role_sdef9) {
		this.role_sdef9 = role_sdef9;
	}
	public String getRole_sdef10() {
		return role_sdef10;
	}
	public void setRole_sdef10(String role_sdef10) {
		this.role_sdef10 = role_sdef10;
	}
	public String getRole_sdef11() {
		return role_sdef11;
	}
	public void setRole_sdef11(String role_sdef11) {
		this.role_sdef11 = role_sdef11;
	}
	public String getRole_sdef12() {
		return role_sdef12;
	}
	public void setRole_sdef12(String role_sdef12) {
		this.role_sdef12 = role_sdef12;
	}
	public String getRole_sdef13() {
		return role_sdef13;
	}
	public void setRole_sdef13(String role_sdef13) {
		this.role_sdef13 = role_sdef13;
	}
	public String getRole_sdef14() {
		return role_sdef14;
	}
	public void setRole_sdef14(String role_sdef14) {
		this.role_sdef14 = role_sdef14;
	}
	public String getRole_sdef15() {
		return role_sdef15;
	}
	public void setRole_sdef15(String role_sdef15) {
		this.role_sdef15 = role_sdef15;
	}
	public String getRole_sdef16() {
		return role_sdef16;
	}
	public void setRole_sdef16(String role_sdef16) {
		this.role_sdef16 = role_sdef16;
	}
	public String getRole_sdef17() {
		return role_sdef17;
	}
	public void setRole_sdef17(String role_sdef17) {
		this.role_sdef17 = role_sdef17;
	}
	public String getRole_sdef18() {
		return role_sdef18;
	}
	public void setRole_sdef18(String role_sdef18) {
		this.role_sdef18 = role_sdef18;
	}
	public String getRole_sdef19() {
		return role_sdef19;
	}
	public void setRole_sdef19(String role_sdef19) {
		this.role_sdef19 = role_sdef19;
	}
	public String getRole_sdef20() {
		return role_sdef20;
	}
	public void setRole_sdef20(String role_sdef20) {
		this.role_sdef20 = role_sdef20;
	}
	public String getRole_ddef1() {
		return role_ddef1;
	}
	public void setRole_ddef1(String role_ddef1) {
		this.role_ddef1 = role_ddef1;
	}
	public String getRole_ddef2() {
		return role_ddef2;
	}
	public void setRole_ddef2(String role_ddef2) {
		this.role_ddef2 = role_ddef2;
	}
	public String getRole_ddef3() {
		return role_ddef3;
	}
	public void setRole_ddef3(String role_ddef3) {
		this.role_ddef3 = role_ddef3;
	}
	public String getRole_ddef4() {
		return role_ddef4;
	}
	public void setRole_ddef4(String role_ddef4) {
		this.role_ddef4 = role_ddef4;
	}
	public String getRole_ddef5() {
		return role_ddef5;
	}
	public void setRole_ddef5(String role_ddef5) {
		this.role_ddef5 = role_ddef5;
	}
	public String getRole_ddef6() {
		return role_ddef6;
	}
	public void setRole_ddef6(String role_ddef6) {
		this.role_ddef6 = role_ddef6;
	}
	public String getRole_ddef7() {
		return role_ddef7;
	}
	public void setRole_ddef7(String role_ddef7) {
		this.role_ddef7 = role_ddef7;
	}
	public String getRole_ddef8() {
		return role_ddef8;
	}
	public void setRole_ddef8(String role_ddef8) {
		this.role_ddef8 = role_ddef8;
	}
	public String getRole_ddef9() {
		return role_ddef9;
	}
	public void setRole_ddef9(String role_ddef9) {
		this.role_ddef9 = role_ddef9;
	}
	public String getRole_ddef10() {
		return role_ddef10;
	}
	public void setRole_ddef10(String role_ddef10) {
		this.role_ddef10 = role_ddef10;
	}
	public BigDecimal getRole_ndef1() {
		return role_ndef1;
	}
	public void setRole_ndef1(BigDecimal role_ndef1) {
		this.role_ndef1 = role_ndef1;
	}
	public BigDecimal getRole_ndef2() {
		return role_ndef2;
	}
	public void setRole_ndef2(BigDecimal role_ndef2) {
		this.role_ndef2 = role_ndef2;
	}
	public BigDecimal getRole_ndef3() {
		return role_ndef3;
	}
	public void setRole_ndef3(BigDecimal role_ndef3) {
		this.role_ndef3 = role_ndef3;
	}
	public BigDecimal getRole_ndef4() {
		return role_ndef4;
	}
	public void setRole_ndef4(BigDecimal role_ndef4) {
		this.role_ndef4 = role_ndef4;
	}
	public BigDecimal getRole_ndef5() {
		return role_ndef5;
	}
	public void setRole_ndef5(BigDecimal role_ndef5) {
		this.role_ndef5 = role_ndef5;
	}
	public BigDecimal getRole_ndef6() {
		return role_ndef6;
	}
	public void setRole_ndef6(BigDecimal role_ndef6) {
		this.role_ndef6 = role_ndef6;
	}
	public BigDecimal getRole_ndef7() {
		return role_ndef7;
	}
	public void setRole_ndef7(BigDecimal role_ndef7) {
		this.role_ndef7 = role_ndef7;
	}
	public BigDecimal getRole_ndef8() {
		return role_ndef8;
	}
	public void setRole_ndef8(BigDecimal role_ndef8) {
		this.role_ndef8 = role_ndef8;
	}
	public BigDecimal getRole_ndef9() {
		return role_ndef9;
	}
	public void setRole_ndef9(BigDecimal role_ndef9) {
		this.role_ndef9 = role_ndef9;
	}
	public BigDecimal getRole_ndef10() {
		return role_ndef10;
	}
	public void setRole_ndef10(BigDecimal role_ndef10) {
		this.role_ndef10 = role_ndef10;
	}
	
}
