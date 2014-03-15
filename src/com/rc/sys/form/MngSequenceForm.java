package com.rc.sys.form;

import java.math.BigDecimal;

public class MngSequenceForm {
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String searchA;//查询条件A
	private String searchB;//查询条件B
	private String searchC;//查询条件C
	private String searchD;//查询条件D
	private String searchE;//查询条件E
	private String seq_nid;//编码id,自增序列
	private String sysint_sno;//系统编号(可为空)
	private String seq_sname;//访问名称(英文名)
	private String seq_sdisname;//显示名称（中文名）
	private String seq_stype;//编码类型:0主键1编码2代码
	private String seq_ntotallength;//总长度
	private String seq_scurvalue;//当前值
	private String seq_sprefix;//前缀
	private String seq_ssuffix;//后缀
	private String seq_nlength;//流水号长度
	private String seq_nvalue;//流水号
	private String seq_nstep;//步长：1,2,3,4,5
	private String seq_ntype;//编码方式:2.二进制 3. 3进制…36.36进制
	private String seq_nyear;//年份显示方式（0.不显示，2.两位年份 4.四位年份）
	private String seq_nmonth;//月份显示方式（0.不显示，2.两位月份 ）
	private String seq_nday;//日期显示方式（0.不显示，2.两位日期 ）
	private String seq_sdesc;//描述
	private String seq_sisdel;//是否删除：0。未删；1。删除
	private String seq_sisvalid;//是否有效：0-有效；1-无效
	private String seq_sreplyby;//创建人
	private String seq_dreplydate;//创建时间
	private String seq_salterby;//修改人
	private String seq_dalterdate;//修改时间
	private String seq_sdef1;
	private String seq_sdef2;
	private String seq_sdef3;
	private String seq_sdef4;
	private String seq_sdef5;
	private String seq_sdef6;
	private String seq_sdef7;
	private String seq_sdef8;
	private String seq_sdef9;
	private String seq_sdef10;
	private String seq_sdef11;
	private String seq_sdef12;
	private String seq_sdef13;
	private String seq_sdef14;
	private String seq_sdef15;
	private String seq_sdef16;
	private String seq_sdef17;
	private String seq_sdef18;
	private String seq_sdef19;
	private String seq_sdef20;
	private String seq_ddef1;
	private String seq_ddef2;
	private String seq_ddef3;
	private String seq_ddef4;
	private String seq_ddef5;
	private String seq_ddef6;
	private String seq_ddef7;
	private String seq_ddef8;
	private String seq_ddef9;
	private String seq_ddef10;
	private String seq_ndef1;
	private String seq_ndef2;
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
	public String getSeq_nid() {
		return seq_nid;
	}
	public void setSeq_nid(String seq_nid) {
		this.seq_nid = seq_nid;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getSeq_sname() {
		return seq_sname;
	}
	public void setSeq_sname(String seq_sname) {
		this.seq_sname = seq_sname;
	}
	public String getSeq_sdisname() {
		return seq_sdisname;
	}
	public void setSeq_sdisname(String seq_sdisname) {
		this.seq_sdisname = seq_sdisname;
	}
	public String getSeq_stype() {
		return seq_stype;
	}
	public void setSeq_stype(String seq_stype) {
		this.seq_stype = seq_stype;
	}
	public String getSeq_ntotallength() {
		return seq_ntotallength;
	}
	public void setSeq_ntotallength(String seq_ntotallength) {
		this.seq_ntotallength = seq_ntotallength;
	}
	public String getSeq_scurvalue() {
		return seq_scurvalue;
	}
	public void setSeq_scurvalue(String seq_scurvalue) {
		this.seq_scurvalue = seq_scurvalue;
	}
	public String getSeq_sprefix() {
		return seq_sprefix;
	}
	public void setSeq_sprefix(String seq_sprefix) {
		this.seq_sprefix = seq_sprefix;
	}
	public String getSeq_ssuffix() {
		return seq_ssuffix;
	}
	public void setSeq_ssuffix(String seq_ssuffix) {
		this.seq_ssuffix = seq_ssuffix;
	}
	public String getSeq_nlength() {
		return seq_nlength;
	}
	public void setSeq_nlength(String seq_nlength) {
		this.seq_nlength = seq_nlength;
	}
	public String getSeq_nvalue() {
		return seq_nvalue;
	}
	public void setSeq_nvalue(String seq_nvalue) {
		this.seq_nvalue = seq_nvalue;
	}
	public String getSeq_nstep() {
		return seq_nstep;
	}
	public void setSeq_nstep(String seq_nstep) {
		this.seq_nstep = seq_nstep;
	}
	public String getSeq_ntype() {
		return seq_ntype;
	}
	public void setSeq_ntype(String seq_ntype) {
		this.seq_ntype = seq_ntype;
	}
	public String getSeq_nyear() {
		return seq_nyear;
	}
	public void setSeq_nyear(String seq_nyear) {
		this.seq_nyear = seq_nyear;
	}
	public String getSeq_nmonth() {
		return seq_nmonth;
	}
	public void setSeq_nmonth(String seq_nmonth) {
		this.seq_nmonth = seq_nmonth;
	}
	public String getSeq_nday() {
		return seq_nday;
	}
	public void setSeq_nday(String seq_nday) {
		this.seq_nday = seq_nday;
	}
	public String getSeq_sdesc() {
		return seq_sdesc;
	}
	public void setSeq_sdesc(String seq_sdesc) {
		this.seq_sdesc = seq_sdesc;
	}
	public String getSeq_sisdel() {
		return seq_sisdel;
	}
	public void setSeq_sisdel(String seq_sisdel) {
		this.seq_sisdel = seq_sisdel;
	}
	public String getSeq_sisvalid() {
		return seq_sisvalid;
	}
	public void setSeq_sisvalid(String seq_sisvalid) {
		this.seq_sisvalid = seq_sisvalid;
	}
	public String getSeq_sreplyby() {
		return seq_sreplyby;
	}
	public void setSeq_sreplyby(String seq_sreplyby) {
		this.seq_sreplyby = seq_sreplyby;
	}
	public String getSeq_dreplydate() {
		return seq_dreplydate;
	}
	public void setSeq_dreplydate(String seq_dreplydate) {
		this.seq_dreplydate = seq_dreplydate;
	}
	public String getSeq_salterby() {
		return seq_salterby;
	}
	public void setSeq_salterby(String seq_salterby) {
		this.seq_salterby = seq_salterby;
	}
	public String getSeq_dalterdate() {
		return seq_dalterdate;
	}
	public void setSeq_dalterdate(String seq_dalterdate) {
		this.seq_dalterdate = seq_dalterdate;
	}
	public String getSeq_sdef1() {
		return seq_sdef1;
	}
	public void setSeq_sdef1(String seq_sdef1) {
		this.seq_sdef1 = seq_sdef1;
	}
	public String getSeq_sdef2() {
		return seq_sdef2;
	}
	public void setSeq_sdef2(String seq_sdef2) {
		this.seq_sdef2 = seq_sdef2;
	}
	public String getSeq_sdef3() {
		return seq_sdef3;
	}
	public void setSeq_sdef3(String seq_sdef3) {
		this.seq_sdef3 = seq_sdef3;
	}
	public String getSeq_sdef4() {
		return seq_sdef4;
	}
	public void setSeq_sdef4(String seq_sdef4) {
		this.seq_sdef4 = seq_sdef4;
	}
	public String getSeq_sdef5() {
		return seq_sdef5;
	}
	public void setSeq_sdef5(String seq_sdef5) {
		this.seq_sdef5 = seq_sdef5;
	}
	public String getSeq_sdef6() {
		return seq_sdef6;
	}
	public void setSeq_sdef6(String seq_sdef6) {
		this.seq_sdef6 = seq_sdef6;
	}
	public String getSeq_sdef7() {
		return seq_sdef7;
	}
	public void setSeq_sdef7(String seq_sdef7) {
		this.seq_sdef7 = seq_sdef7;
	}
	public String getSeq_sdef8() {
		return seq_sdef8;
	}
	public void setSeq_sdef8(String seq_sdef8) {
		this.seq_sdef8 = seq_sdef8;
	}
	public String getSeq_sdef9() {
		return seq_sdef9;
	}
	public void setSeq_sdef9(String seq_sdef9) {
		this.seq_sdef9 = seq_sdef9;
	}
	public String getSeq_sdef10() {
		return seq_sdef10;
	}
	public void setSeq_sdef10(String seq_sdef10) {
		this.seq_sdef10 = seq_sdef10;
	}
	public String getSeq_sdef11() {
		return seq_sdef11;
	}
	public void setSeq_sdef11(String seq_sdef11) {
		this.seq_sdef11 = seq_sdef11;
	}
	public String getSeq_sdef12() {
		return seq_sdef12;
	}
	public void setSeq_sdef12(String seq_sdef12) {
		this.seq_sdef12 = seq_sdef12;
	}
	public String getSeq_sdef13() {
		return seq_sdef13;
	}
	public void setSeq_sdef13(String seq_sdef13) {
		this.seq_sdef13 = seq_sdef13;
	}
	public String getSeq_sdef14() {
		return seq_sdef14;
	}
	public void setSeq_sdef14(String seq_sdef14) {
		this.seq_sdef14 = seq_sdef14;
	}
	public String getSeq_sdef15() {
		return seq_sdef15;
	}
	public void setSeq_sdef15(String seq_sdef15) {
		this.seq_sdef15 = seq_sdef15;
	}
	public String getSeq_sdef16() {
		return seq_sdef16;
	}
	public void setSeq_sdef16(String seq_sdef16) {
		this.seq_sdef16 = seq_sdef16;
	}
	public String getSeq_sdef17() {
		return seq_sdef17;
	}
	public void setSeq_sdef17(String seq_sdef17) {
		this.seq_sdef17 = seq_sdef17;
	}
	public String getSeq_sdef18() {
		return seq_sdef18;
	}
	public void setSeq_sdef18(String seq_sdef18) {
		this.seq_sdef18 = seq_sdef18;
	}
	public String getSeq_sdef19() {
		return seq_sdef19;
	}
	public void setSeq_sdef19(String seq_sdef19) {
		this.seq_sdef19 = seq_sdef19;
	}
	public String getSeq_sdef20() {
		return seq_sdef20;
	}
	public void setSeq_sdef20(String seq_sdef20) {
		this.seq_sdef20 = seq_sdef20;
	}
	public String getSeq_ddef1() {
		return seq_ddef1;
	}
	public void setSeq_ddef1(String seq_ddef1) {
		this.seq_ddef1 = seq_ddef1;
	}
	public String getSeq_ddef2() {
		return seq_ddef2;
	}
	public void setSeq_ddef2(String seq_ddef2) {
		this.seq_ddef2 = seq_ddef2;
	}
	public String getSeq_ddef3() {
		return seq_ddef3;
	}
	public void setSeq_ddef3(String seq_ddef3) {
		this.seq_ddef3 = seq_ddef3;
	}
	public String getSeq_ddef4() {
		return seq_ddef4;
	}
	public void setSeq_ddef4(String seq_ddef4) {
		this.seq_ddef4 = seq_ddef4;
	}
	public String getSeq_ddef5() {
		return seq_ddef5;
	}
	public void setSeq_ddef5(String seq_ddef5) {
		this.seq_ddef5 = seq_ddef5;
	}
	public String getSeq_ddef6() {
		return seq_ddef6;
	}
	public void setSeq_ddef6(String seq_ddef6) {
		this.seq_ddef6 = seq_ddef6;
	}
	public String getSeq_ddef7() {
		return seq_ddef7;
	}
	public void setSeq_ddef7(String seq_ddef7) {
		this.seq_ddef7 = seq_ddef7;
	}
	public String getSeq_ddef8() {
		return seq_ddef8;
	}
	public void setSeq_ddef8(String seq_ddef8) {
		this.seq_ddef8 = seq_ddef8;
	}
	public String getSeq_ddef9() {
		return seq_ddef9;
	}
	public void setSeq_ddef9(String seq_ddef9) {
		this.seq_ddef9 = seq_ddef9;
	}
	public String getSeq_ddef10() {
		return seq_ddef10;
	}
	public void setSeq_ddef10(String seq_ddef10) {
		this.seq_ddef10 = seq_ddef10;
	}
	public String getSeq_ndef1() {
		return seq_ndef1;
	}
	public void setSeq_ndef1(String seq_ndef1) {
		this.seq_ndef1 = seq_ndef1;
	}
	public String getSeq_ndef2() {
		return seq_ndef2;
	}
	public void setSeq_ndef2(String seq_ndef2) {
		this.seq_ndef2 = seq_ndef2;
	}
	
	
}
