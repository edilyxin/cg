package com.rc.declare.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.DMZDivMoneyZForm.java
 *  @Class Name    : DMZDivMoneyZForm
 *  @Description   : 金额分配主表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class DMZDivMoneyZForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String dmz_sid;//	主键	varchar
	private String dmz_syear;//	年份	varchar
	private String dmz_speriod;//	批次	varchar
	private String dmz_stype;//	分配类型	varchar
	private String dmz_sisdiv;//	是否分配	varchar
	private String dmz_snodiv;//	已分配	decimal
	private String dmz_sdiving;//	未分配	decimal
	private String dmz_scompel;//	是否完成	varchar
	private String dmz_sreplyby;//	分配人	varchar
	private String dmz_dreplydate;//	分配时间	datetime
	private String dmz_salterby;//	修改人	varchar
	private String dmz_dalterdate;//	修改时间	datetime
	private String dmz_sdef1;//		varchar
	private String dmz_sdef2	;//	varchar
	private String dmz_sdef3;//		varchar
	private String dmz_sdef4;//		varchar
	private String dmz_sdef5;//		varchar
	private String dmz_sdef6;//		varchar
	private String dmz_sdef7;//		varchar
	private String dmz_sdef8;//		varchar
	private String dmz_sdef9;//		varchar
	private String dmz_sdef10;//		varchar
	private String dmz_ddef1;//		datetime
	private String dmz_ddef2;//		datetime
	private String dmz_ddef3;//		datetime
	private String dmz_ddef4;//		datetime
	private String dmz_ddef5;//		datetime
	private String dmz_ndef1;//	总金额	decimal
	private BigDecimal dmz_ndef2;//		decimal
	private BigDecimal dmz_ndef3;//		decimal
	private BigDecimal dmz_ndef4;//		decimal
	private BigDecimal dmz_ndef5;//		decimal
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
	public String getDmz_sid() {
		return dmz_sid;
	}
	public void setDmz_sid(String dmz_sid) {
		this.dmz_sid = dmz_sid;
	}
	public String getDmz_syear() {
		return dmz_syear;
	}
	public void setDmz_syear(String dmz_syear) {
		this.dmz_syear = dmz_syear;
	}
	public String getDmz_speriod() {
		return dmz_speriod;
	}
	public void setDmz_speriod(String dmz_speriod) {
		this.dmz_speriod = dmz_speriod;
	}
	public String getDmz_stype() {
		return dmz_stype;
	}
	public void setDmz_stype(String dmz_stype) {
		this.dmz_stype = dmz_stype;
	}
	public String getDmz_sisdiv() {
		return dmz_sisdiv;
	}
	public void setDmz_sisdiv(String dmz_sisdiv) {
		this.dmz_sisdiv = dmz_sisdiv;
	}
	public String getDmz_snodiv() {
		return dmz_snodiv;
	}
	public void setDmz_snodiv(String dmz_snodiv) {
		this.dmz_snodiv = dmz_snodiv;
	}
	public String getDmz_sdiving() {
		return dmz_sdiving;
	}
	public void setDmz_sdiving(String dmz_sdiving) {
		this.dmz_sdiving = dmz_sdiving;
	}
	public String getDmz_scompel() {
		return dmz_scompel;
	}
	public void setDmz_scompel(String dmz_scompel) {
		this.dmz_scompel = dmz_scompel;
	}
	public String getDmz_sreplyby() {
		return dmz_sreplyby;
	}
	public void setDmz_sreplyby(String dmz_sreplyby) {
		this.dmz_sreplyby = dmz_sreplyby;
	}
	public String getDmz_dreplydate() {
		return dmz_dreplydate;
	}
	public void setDmz_dreplydate(String dmz_dreplydate) {
		this.dmz_dreplydate = dmz_dreplydate;
	}
	public String getDmz_salterby() {
		return dmz_salterby;
	}
	public void setDmz_salterby(String dmz_salterby) {
		this.dmz_salterby = dmz_salterby;
	}
	public String getDmz_dalterdate() {
		return dmz_dalterdate;
	}
	public void setDmz_dalterdate(String dmz_dalterdate) {
		this.dmz_dalterdate = dmz_dalterdate;
	}
	public String getDmz_sdef1() {
		return dmz_sdef1;
	}
	public void setDmz_sdef1(String dmz_sdef1) {
		this.dmz_sdef1 = dmz_sdef1;
	}
	public String getDmz_sdef2() {
		return dmz_sdef2;
	}
	public void setDmz_sdef2(String dmz_sdef2) {
		this.dmz_sdef2 = dmz_sdef2;
	}
	public String getDmz_sdef3() {
		return dmz_sdef3;
	}
	public void setDmz_sdef3(String dmz_sdef3) {
		this.dmz_sdef3 = dmz_sdef3;
	}
	public String getDmz_sdef4() {
		return dmz_sdef4;
	}
	public void setDmz_sdef4(String dmz_sdef4) {
		this.dmz_sdef4 = dmz_sdef4;
	}
	public String getDmz_sdef5() {
		return dmz_sdef5;
	}
	public void setDmz_sdef5(String dmz_sdef5) {
		this.dmz_sdef5 = dmz_sdef5;
	}
	public String getDmz_sdef6() {
		return dmz_sdef6;
	}
	public void setDmz_sdef6(String dmz_sdef6) {
		this.dmz_sdef6 = dmz_sdef6;
	}
	public String getDmz_sdef7() {
		return dmz_sdef7;
	}
	public void setDmz_sdef7(String dmz_sdef7) {
		this.dmz_sdef7 = dmz_sdef7;
	}
	public String getDmz_sdef8() {
		return dmz_sdef8;
	}
	public void setDmz_sdef8(String dmz_sdef8) {
		this.dmz_sdef8 = dmz_sdef8;
	}
	public String getDmz_sdef9() {
		return dmz_sdef9;
	}
	public void setDmz_sdef9(String dmz_sdef9) {
		this.dmz_sdef9 = dmz_sdef9;
	}
	public String getDmz_sdef10() {
		return dmz_sdef10;
	}
	public void setDmz_sdef10(String dmz_sdef10) {
		this.dmz_sdef10 = dmz_sdef10;
	}
	public String getDmz_ddef1() {
		return dmz_ddef1;
	}
	public void setDmz_ddef1(String dmz_ddef1) {
		this.dmz_ddef1 = dmz_ddef1;
	}
	public String getDmz_ddef2() {
		return dmz_ddef2;
	}
	public void setDmz_ddef2(String dmz_ddef2) {
		this.dmz_ddef2 = dmz_ddef2;
	}
	public String getDmz_ddef3() {
		return dmz_ddef3;
	}
	public void setDmz_ddef3(String dmz_ddef3) {
		this.dmz_ddef3 = dmz_ddef3;
	}
	public String getDmz_ddef4() {
		return dmz_ddef4;
	}
	public void setDmz_ddef4(String dmz_ddef4) {
		this.dmz_ddef4 = dmz_ddef4;
	}
	public String getDmz_ddef5() {
		return dmz_ddef5;
	}
	public void setDmz_ddef5(String dmz_ddef5) {
		this.dmz_ddef5 = dmz_ddef5;
	}
	
	public String getDmz_ndef1() {
		return dmz_ndef1;
	}
	public void setDmz_ndef1(String dmz_ndef1) {
		this.dmz_ndef1 = dmz_ndef1;
	}
	public BigDecimal getDmz_ndef2() {
		return dmz_ndef2;
	}
	public void setDmz_ndef2(BigDecimal dmz_ndef2) {
		this.dmz_ndef2 = dmz_ndef2;
	}
	public BigDecimal getDmz_ndef3() {
		return dmz_ndef3;
	}
	public void setDmz_ndef3(BigDecimal dmz_ndef3) {
		this.dmz_ndef3 = dmz_ndef3;
	}
	public BigDecimal getDmz_ndef4() {
		return dmz_ndef4;
	}
	public void setDmz_ndef4(BigDecimal dmz_ndef4) {
		this.dmz_ndef4 = dmz_ndef4;
	}
	public BigDecimal getDmz_ndef5() {
		return dmz_ndef5;
	}
	public void setDmz_ndef5(BigDecimal dmz_ndef5) {
		this.dmz_ndef5 = dmz_ndef5;
	}
	


}
