package com.rc.sys.form;

import java.math.BigDecimal;

public class MngOperForm {
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String searchA;//查询条件A
	private String searchB;//查询条件B
	private String searchC;//查询条件C
	private String searchD;//查询条件D
	private String searchE;//查询条件E
	private String oper_sno;//操作编号
	private String sysint_sno;//系统编号
	private String right_sno;//功能编号
	private String oper_sname;//操作名称
	private String oper_sdesc;//操作描述
//	private Long oper_norder;//排序顺序
	private String oper_stype;//操作类型(从数据字典取 新增 修改 删除 导入 导出 有效/无效等)
	private String oper_sisuse;//是否可用:0.可用 ,1.不可用
	private Long oper_nmorb;//是否按钮：0是，1不是
	private String oper_simg;//图标地址
	private String oper_sisdel;//是否删除：0。未删；1。删除
	private String oper_sisvalid;//是否有效：0-有效；1-无效
	private String oper_sreplyby;//创建人
	private String oper_dreplydate;//创建时间
	private String oper_salterby;//修改人
	private String oper_dalterdate;//修改时间
	private String oper_sdef1;
	private String oper_sdef2;
	private String oper_sdef3;
	private String oper_sdef4;
	private String oper_sdef5;
	private String oper_sdef6;
	private String oper_sdef7;
	private String oper_sdef8;
	private String oper_sdef9;
	private String oper_sdef10;
	private String oper_sdef11;
	private String oper_sdef12;
	private String oper_sdef13;
	private String oper_sdef14;
	private String oper_sdef15;
	private String oper_sdef16;
	private String oper_sdef17;
	private String oper_sdef18;
	private String oper_sdef19;
	private String oper_sdef20;
	private String oper_ddef1;
	private String oper_ddef2;
	private String oper_ddef3;
	private String oper_ddef4;
	private String oper_ddef5;
	private String oper_ddef6;
	private String oper_ddef7;
	private String oper_ddef8;
	private String oper_ddef9;
	private String oper_ddef10;
	private BigDecimal oper_ndef1;//排序顺序
	private BigDecimal oper_ndef2;
	private BigDecimal oper_ndef3;
	private BigDecimal oper_ndef4;
	private BigDecimal oper_ndef5;
	private BigDecimal oper_ndef6;
	private BigDecimal oper_ndef7;
	private BigDecimal oper_ndef8;
	private BigDecimal oper_ndef9;
	private BigDecimal oper_ndef10;
	private String right_sname;//功能名称
	private String sysint_sname;//系统名称
	 
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
	public String getOper_sno() {
		return oper_sno;
	}
	public void setOper_sno(String oper_sno) {
		this.oper_sno = oper_sno;
	}
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
	public String getOper_sname() {
		return oper_sname;
	}
	public void setOper_sname(String oper_sname) {
		this.oper_sname = oper_sname;
	}
	public String getOper_sdesc() {
		return oper_sdesc;
	}
	public void setOper_sdesc(String oper_sdesc) {
		this.oper_sdesc = oper_sdesc;
	}
	public String getOper_stype() {
		return oper_stype;
	}
	public void setOper_stype(String oper_stype) {
		this.oper_stype = oper_stype;
	}
	public String getOper_sisuse() {
		return oper_sisuse;
	}
	public void setOper_sisuse(String oper_sisuse) {
		this.oper_sisuse = oper_sisuse;
	}
	public Long getOper_nmorb() {
		return oper_nmorb;
	}
	public void setOper_nmorb(Long oper_nmorb) {
		this.oper_nmorb = oper_nmorb;
	}
	public String getOper_simg() {
		return oper_simg;
	}
	public void setOper_simg(String oper_simg) {
		this.oper_simg = oper_simg;
	}
	public String getOper_sisdel() {
		return oper_sisdel;
	}
	public void setOper_sisdel(String oper_sisdel) {
		this.oper_sisdel = oper_sisdel;
	}
	public String getOper_sisvalid() {
		return oper_sisvalid;
	}
	public void setOper_sisvalid(String oper_sisvalid) {
		this.oper_sisvalid = oper_sisvalid;
	}
	public String getOper_sreplyby() {
		return oper_sreplyby;
	}
	public void setOper_sreplyby(String oper_sreplyby) {
		this.oper_sreplyby = oper_sreplyby;
	}
	public String getOper_dreplydate() {
		return oper_dreplydate;
	}
	public void setOper_dreplydate(String oper_dreplydate) {
		this.oper_dreplydate = oper_dreplydate;
	}
	public String getOper_salterby() {
		return oper_salterby;
	}
	public void setOper_salterby(String oper_salterby) {
		this.oper_salterby = oper_salterby;
	}
	public String getOper_dalterdate() {
		return oper_dalterdate;
	}
	public void setOper_dalterdate(String oper_dalterdate) {
		this.oper_dalterdate = oper_dalterdate;
	}
	public String getOper_sdef1() {
		return oper_sdef1;
	}
	public void setOper_sdef1(String oper_sdef1) {
		this.oper_sdef1 = oper_sdef1;
	}
	public String getOper_sdef2() {
		return oper_sdef2;
	}
	public void setOper_sdef2(String oper_sdef2) {
		this.oper_sdef2 = oper_sdef2;
	}
	public String getOper_sdef3() {
		return oper_sdef3;
	}
	public void setOper_sdef3(String oper_sdef3) {
		this.oper_sdef3 = oper_sdef3;
	}
	public String getOper_sdef4() {
		return oper_sdef4;
	}
	public void setOper_sdef4(String oper_sdef4) {
		this.oper_sdef4 = oper_sdef4;
	}
	public String getOper_sdef5() {
		return oper_sdef5;
	}
	public void setOper_sdef5(String oper_sdef5) {
		this.oper_sdef5 = oper_sdef5;
	}
	public String getOper_sdef6() {
		return oper_sdef6;
	}
	public void setOper_sdef6(String oper_sdef6) {
		this.oper_sdef6 = oper_sdef6;
	}
	public String getOper_sdef7() {
		return oper_sdef7;
	}
	public void setOper_sdef7(String oper_sdef7) {
		this.oper_sdef7 = oper_sdef7;
	}
	public String getOper_sdef8() {
		return oper_sdef8;
	}
	public void setOper_sdef8(String oper_sdef8) {
		this.oper_sdef8 = oper_sdef8;
	}
	public String getOper_sdef9() {
		return oper_sdef9;
	}
	public void setOper_sdef9(String oper_sdef9) {
		this.oper_sdef9 = oper_sdef9;
	}
	public String getOper_sdef10() {
		return oper_sdef10;
	}
	public void setOper_sdef10(String oper_sdef10) {
		this.oper_sdef10 = oper_sdef10;
	}
	public String getOper_sdef11() {
		return oper_sdef11;
	}
	public void setOper_sdef11(String oper_sdef11) {
		this.oper_sdef11 = oper_sdef11;
	}
	public String getOper_sdef12() {
		return oper_sdef12;
	}
	public void setOper_sdef12(String oper_sdef12) {
		this.oper_sdef12 = oper_sdef12;
	}
	public String getOper_sdef13() {
		return oper_sdef13;
	}
	public void setOper_sdef13(String oper_sdef13) {
		this.oper_sdef13 = oper_sdef13;
	}
	public String getOper_sdef14() {
		return oper_sdef14;
	}
	public void setOper_sdef14(String oper_sdef14) {
		this.oper_sdef14 = oper_sdef14;
	}
	public String getOper_sdef15() {
		return oper_sdef15;
	}
	public void setOper_sdef15(String oper_sdef15) {
		this.oper_sdef15 = oper_sdef15;
	}
	public String getOper_sdef16() {
		return oper_sdef16;
	}
	public void setOper_sdef16(String oper_sdef16) {
		this.oper_sdef16 = oper_sdef16;
	}
	public String getOper_sdef17() {
		return oper_sdef17;
	}
	public void setOper_sdef17(String oper_sdef17) {
		this.oper_sdef17 = oper_sdef17;
	}
	public String getOper_sdef18() {
		return oper_sdef18;
	}
	public void setOper_sdef18(String oper_sdef18) {
		this.oper_sdef18 = oper_sdef18;
	}
	public String getOper_sdef19() {
		return oper_sdef19;
	}
	public void setOper_sdef19(String oper_sdef19) {
		this.oper_sdef19 = oper_sdef19;
	}
	public String getOper_sdef20() {
		return oper_sdef20;
	}
	public void setOper_sdef20(String oper_sdef20) {
		this.oper_sdef20 = oper_sdef20;
	}
	public String getOper_ddef1() {
		return oper_ddef1;
	}
	public void setOper_ddef1(String oper_ddef1) {
		this.oper_ddef1 = oper_ddef1;
	}
	public String getOper_ddef2() {
		return oper_ddef2;
	}
	public void setOper_ddef2(String oper_ddef2) {
		this.oper_ddef2 = oper_ddef2;
	}
	public String getOper_ddef3() {
		return oper_ddef3;
	}
	public void setOper_ddef3(String oper_ddef3) {
		this.oper_ddef3 = oper_ddef3;
	}
	public String getOper_ddef4() {
		return oper_ddef4;
	}
	public void setOper_ddef4(String oper_ddef4) {
		this.oper_ddef4 = oper_ddef4;
	}
	public String getOper_ddef5() {
		return oper_ddef5;
	}
	public void setOper_ddef5(String oper_ddef5) {
		this.oper_ddef5 = oper_ddef5;
	}
	public String getOper_ddef6() {
		return oper_ddef6;
	}
	public void setOper_ddef6(String oper_ddef6) {
		this.oper_ddef6 = oper_ddef6;
	}
	public String getOper_ddef7() {
		return oper_ddef7;
	}
	public void setOper_ddef7(String oper_ddef7) {
		this.oper_ddef7 = oper_ddef7;
	}
	public String getOper_ddef8() {
		return oper_ddef8;
	}
	public void setOper_ddef8(String oper_ddef8) {
		this.oper_ddef8 = oper_ddef8;
	}
	public String getOper_ddef9() {
		return oper_ddef9;
	}
	public void setOper_ddef9(String oper_ddef9) {
		this.oper_ddef9 = oper_ddef9;
	}
	public String getOper_ddef10() {
		return oper_ddef10;
	}
	public void setOper_ddef10(String oper_ddef10) {
		this.oper_ddef10 = oper_ddef10;
	}
	public BigDecimal getOper_ndef1() {
		return oper_ndef1;
	}
	public void setOper_ndef1(BigDecimal oper_ndef1) {
		this.oper_ndef1 = oper_ndef1;
	}
	public BigDecimal getOper_ndef2() {
		return oper_ndef2;
	}
	public void setOper_ndef2(BigDecimal oper_ndef2) {
		this.oper_ndef2 = oper_ndef2;
	}
	public BigDecimal getOper_ndef3() {
		return oper_ndef3;
	}
	public void setOper_ndef3(BigDecimal oper_ndef3) {
		this.oper_ndef3 = oper_ndef3;
	}
	public BigDecimal getOper_ndef4() {
		return oper_ndef4;
	}
	public void setOper_ndef4(BigDecimal oper_ndef4) {
		this.oper_ndef4 = oper_ndef4;
	}
	public BigDecimal getOper_ndef5() {
		return oper_ndef5;
	}
	public void setOper_ndef5(BigDecimal oper_ndef5) {
		this.oper_ndef5 = oper_ndef5;
	}
	public BigDecimal getOper_ndef6() {
		return oper_ndef6;
	}
	public void setOper_ndef6(BigDecimal oper_ndef6) {
		this.oper_ndef6 = oper_ndef6;
	}
	public BigDecimal getOper_ndef7() {
		return oper_ndef7;
	}
	public void setOper_ndef7(BigDecimal oper_ndef7) {
		this.oper_ndef7 = oper_ndef7;
	}
	public BigDecimal getOper_ndef8() {
		return oper_ndef8;
	}
	public void setOper_ndef8(BigDecimal oper_ndef8) {
		this.oper_ndef8 = oper_ndef8;
	}
	public BigDecimal getOper_ndef9() {
		return oper_ndef9;
	}
	public void setOper_ndef9(BigDecimal oper_ndef9) {
		this.oper_ndef9 = oper_ndef9;
	}
	public BigDecimal getOper_ndef10() {
		return oper_ndef10;
	}
	public void setOper_ndef10(BigDecimal oper_ndef10) {
		this.oper_ndef10 = oper_ndef10;
	}
	public String getRight_sname() {
		return right_sname;
	}
	public void setRight_sname(String right_sname) {
		this.right_sname = right_sname;
	}
	public String getSysint_sname() {
		return sysint_sname;
	}
	public void setSysint_sname(String sysint_sname) {
		this.sysint_sname = sysint_sname;
	}
	
	
}
