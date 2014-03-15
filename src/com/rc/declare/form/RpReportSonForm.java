package com.rc.declare.form;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 *  @Project       : CG
 *  @Program Name  : com.rc.declare.form.RpReportSonForm.java
 *  @Class Name    : RpReportSonForm
 *  @Description   : 申报子表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-8下午03:48:25
 */
public class RpReportSonForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private Integer rpson_nid;//	主键	bigint 
	private String Rpson_nids;//
	private String rp_sid;//	对应项目表主键	varchar
	private String rpson_sname;//	项目名称	varchar
	private String rpson_sperson;//	负责人	varchar
	private String rpson_syear;//	年度	varchar
	private BigDecimal rpson_nmoney;//	下拨经费	decimal
	private String rpson_sremark;//	备注	varchar
	private BigDecimal rpson_nfinance;//	财政拨款	decimal
	private BigDecimal rpson_nfithisyear;//	其中申请当年财政预算	decimal
	private BigDecimal rpson_nout;//	预算外资金	decimal
	private BigDecimal rpson_nother;//	其他资金	decimal
	private BigDecimal rpson_ntotal;//	合计	decimal
	private String rpson_sexplain;//	测算依据及说明	text
	private String rpson_sreplyby;//	创建人	varchar
	private String rpson_dreplydate;//	创建时间	datetime
	private String rpson_salterby;//	修改人	varchar
	private String rpson_dalterdate;//	修改时间	datetime
	private String rpson_sdef1;//	表头	varchar
	private String rpson_sdef2;//	负责人编号	varchar
	private String rpson_sdef3;//	状态	varchar
	private String rpson_sdef4;//		varchar
	private String rpson_sdef5	;//	varchar
	private String rpson_sdef6	;//	varchar
	private String rpson_sdef7;//		varchar
	private String rpson_sdef8;//		varchar
	private String rpson_sdef9	;//	varchar
	private String rpson_sdef10;//		varchar
	private String rpson_ddef1;//		datetime
	private String rpson_ddef2;//		datetime
	private String rpson_ddef3	;//	datetime
	private String rpson_ddef4;//		datetime
	private String rpson_ddef5;//		datetime
	private BigDecimal rpson_ndef1;//	合计（详细中的）	decimal
	private BigDecimal rpson_ndef2;//		decimal
	private BigDecimal rpson_ndef3;//		decimal
	private BigDecimal rpson_ndef4	;//	decimal
	private BigDecimal rpson_ndef5;//		decimal
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
	public Integer getRpson_nid() {
		return rpson_nid;
	}
	public void setRpson_nid(Integer rpson_nid) {
		this.rpson_nid = rpson_nid;
	}
	public String getRp_sid() {
		return rp_sid;
	}
	public void setRp_sid(String rp_sid) {
		this.rp_sid = rp_sid;
	}
	public String getRpson_sname() {
		return rpson_sname;
	}
	public void setRpson_sname(String rpson_sname) {
		this.rpson_sname = rpson_sname;
	}
	public String getRpson_sperson() {
		return rpson_sperson;
	}
	public void setRpson_sperson(String rpson_sperson) {
		this.rpson_sperson = rpson_sperson;
	}
	public String getRpson_syear() {
		return rpson_syear;
	}
	public void setRpson_syear(String rpson_syear) {
		this.rpson_syear = rpson_syear;
	}
	public BigDecimal getRpson_nmoney() {
		return rpson_nmoney;
	}
	public void setRpson_nmoney(BigDecimal rpson_nmoney) {
		this.rpson_nmoney = rpson_nmoney;
	}
	public String getRpson_sremark() {
		return rpson_sremark;
	}
	
	public String getRpson_nids() {
		return Rpson_nids;
	}
	public void setRpson_nids(String rpson_nids) {
		Rpson_nids = rpson_nids;
	}
	public void setRpson_sremark(String rpson_sremark) {
		this.rpson_sremark = rpson_sremark;
	}
	public BigDecimal getRpson_nfinance() {
		return rpson_nfinance;
	}
	public void setRpson_nfinance(BigDecimal rpson_nfinance) {
		this.rpson_nfinance = rpson_nfinance;
	}
	public BigDecimal getRpson_nfithisyear() {
		return rpson_nfithisyear;
	}
	public void setRpson_nfithisyear(BigDecimal rpson_nfithisyear) {
		this.rpson_nfithisyear = rpson_nfithisyear;
	}
	public BigDecimal getRpson_nout() {
		return rpson_nout;
	}
	public void setRpson_nout(BigDecimal rpson_nout) {
		this.rpson_nout = rpson_nout;
	}
	public BigDecimal getRpson_nother() {
		return rpson_nother;
	}
	public void setRpson_nother(BigDecimal rpson_nother) {
		this.rpson_nother = rpson_nother;
	}
	public BigDecimal getRpson_ntotal() {
		return rpson_ntotal;
	}
	public void setRpson_ntotal(BigDecimal rpson_ntotal) {
		this.rpson_ntotal = rpson_ntotal;
	}
	public String getRpson_sexplain() {
		return rpson_sexplain;
	}
	public void setRpson_sexplain(String rpson_sexplain) {
		this.rpson_sexplain = rpson_sexplain;
	}
	public String getRpson_sreplyby() {
		return rpson_sreplyby;
	}
	public void setRpson_sreplyby(String rpson_sreplyby) {
		this.rpson_sreplyby = rpson_sreplyby;
	}
	public String getRpson_dreplydate() {
		return rpson_dreplydate;
	}
	public void setRpson_dreplydate(String rpson_dreplydate) {
		this.rpson_dreplydate = rpson_dreplydate;
	}
	public String getRpson_salterby() {
		return rpson_salterby;
	}
	public void setRpson_salterby(String rpson_salterby) {
		this.rpson_salterby = rpson_salterby;
	}
	public String getRpson_dalterdate() {
		return rpson_dalterdate;
	}
	public void setRpson_dalterdate(String rpson_dalterdate) {
		this.rpson_dalterdate = rpson_dalterdate;
	}
	public String getRpson_sdef1() {
		return rpson_sdef1;
	}
	public void setRpson_sdef1(String rpson_sdef1) {
		this.rpson_sdef1 = rpson_sdef1;
	}
	public String getRpson_sdef2() {
		return rpson_sdef2;
	}
	public void setRpson_sdef2(String rpson_sdef2) {
		this.rpson_sdef2 = rpson_sdef2;
	}
	public String getRpson_sdef3() {
		return rpson_sdef3;
	}
	public void setRpson_sdef3(String rpson_sdef3) {
		this.rpson_sdef3 = rpson_sdef3;
	}
	public String getRpson_sdef4() {
		return rpson_sdef4;
	}
	public void setRpson_sdef4(String rpson_sdef4) {
		this.rpson_sdef4 = rpson_sdef4;
	}
	public String getRpson_sdef5() {
		return rpson_sdef5;
	}
	public void setRpson_sdef5(String rpson_sdef5) {
		this.rpson_sdef5 = rpson_sdef5;
	}
	public String getRpson_sdef6() {
		return rpson_sdef6;
	}
	public void setRpson_sdef6(String rpson_sdef6) {
		this.rpson_sdef6 = rpson_sdef6;
	}
	public String getRpson_sdef7() {
		return rpson_sdef7;
	}
	public void setRpson_sdef7(String rpson_sdef7) {
		this.rpson_sdef7 = rpson_sdef7;
	}
	public String getRpson_sdef8() {
		return rpson_sdef8;
	}
	public void setRpson_sdef8(String rpson_sdef8) {
		this.rpson_sdef8 = rpson_sdef8;
	}
	public String getRpson_sdef9() {
		return rpson_sdef9;
	}
	public void setRpson_sdef9(String rpson_sdef9) {
		this.rpson_sdef9 = rpson_sdef9;
	}
	public String getRpson_sdef10() {
		return rpson_sdef10;
	}
	public void setRpson_sdef10(String rpson_sdef10) {
		this.rpson_sdef10 = rpson_sdef10;
	}
	public String getRpson_ddef1() {
		return rpson_ddef1;
	}
	public void setRpson_ddef1(String rpson_ddef1) {
		this.rpson_ddef1 = rpson_ddef1;
	}
	public String getRpson_ddef2() {
		return rpson_ddef2;
	}
	public void setRpson_ddef2(String rpson_ddef2) {
		this.rpson_ddef2 = rpson_ddef2;
	}
	public String getRpson_ddef3() {
		return rpson_ddef3;
	}
	public void setRpson_ddef3(String rpson_ddef3) {
		this.rpson_ddef3 = rpson_ddef3;
	}
	public String getRpson_ddef4() {
		return rpson_ddef4;
	}
	public void setRpson_ddef4(String rpson_ddef4) {
		this.rpson_ddef4 = rpson_ddef4;
	}
	public String getRpson_ddef5() {
		return rpson_ddef5;
	}
	public void setRpson_ddef5(String rpson_ddef5) {
		this.rpson_ddef5 = rpson_ddef5;
	}
	public BigDecimal getRpson_ndef1() {
		return rpson_ndef1;
	}
	public void setRpson_ndef1(BigDecimal rpson_ndef1) {
		this.rpson_ndef1 = rpson_ndef1;
	}
	public BigDecimal getRpson_ndef2() {
		return rpson_ndef2;
	}
	public void setRpson_ndef2(BigDecimal rpson_ndef2) {
		this.rpson_ndef2 = rpson_ndef2;
	}
	public BigDecimal getRpson_ndef3() {
		return rpson_ndef3;
	}
	public void setRpson_ndef3(BigDecimal rpson_ndef3) {
		this.rpson_ndef3 = rpson_ndef3;
	}
	public BigDecimal getRpson_ndef4() {
		return rpson_ndef4;
	}
	public void setRpson_ndef4(BigDecimal rpson_ndef4) {
		this.rpson_ndef4 = rpson_ndef4;
	}
	public BigDecimal getRpson_ndef5() {
		return rpson_ndef5;
	}
	public void setRpson_ndef5(BigDecimal rpson_ndef5) {
		this.rpson_ndef5 = rpson_ndef5;
	}
	

	

}
