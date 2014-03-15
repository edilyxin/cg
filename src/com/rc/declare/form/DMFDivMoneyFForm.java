package com.rc.declare.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.DMFDivMoneyFForm.java
 *  @Class Name    : DMFDivMoneyFForm
 *  @Description   : 金额分配子表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class DMFDivMoneyFForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String dmz_sid;//	外键	
	private String dmf_sid;//	主键	varchar
	private String dmf_stype;//	类型	
	private String ud_sno;//	单位编码（主键）	
	private String dmf_sdivmoneys;//	分配金额	decimal
	private String dmf_sreplyby;//	分配人	varchar
	private String dmf_dreplydate;//	分配时间	datetime
	private String dmf_salterby;//	修改人	varchar
	private String dmf_dalterdate;//	修改时间	datetime
	private String dmf_sdef1;//	项目编号	varchar
	private String dmf_sdef2;//		varchar
	private String dmf_sdef3;//		varchar
	private String dmf_sdef4;//		varchar
	private String dmf_sdef5	;//	varchar
	private String dmf_sdef6;//		varchar
	private String dmf_sdef7;//		varchar
	private String dmf_sdef8;//		varchar
	private String dmf_sdef9;//		varchar
	private String dmf_sdef10;//		varchar
	private String dmf_ddef1;//		datetime
	private String dmf_ddef2;//		datetime
	private String dmf_ddef3;//		datetime
	private String dmf_ddef4;//		datetime
	private String dmf_ddef5;//		datetime
	private BigDecimal dmf_ndef1;//		decimal
	private BigDecimal dmf_ndef2;//		decimal
	private BigDecimal dmf_ndef3;//		decimal
	private BigDecimal dmf_ndef4;//		decimal
	private BigDecimal dmf_ndef5;//		decimal
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
	public String getDmf_sid() {
		return dmf_sid;
	}
	public void setDmf_sid(String dmf_sid) {
		this.dmf_sid = dmf_sid;
	}
	public String getDmf_stype() {
		return dmf_stype;
	}
	public void setDmf_stype(String dmf_stype) {
		this.dmf_stype = dmf_stype;
	}
	public String getUd_sno() {
		return ud_sno;
	}
	public void setUd_sno(String ud_sno) {
		this.ud_sno = ud_sno;
	}
	public String getDmf_sdivmoneys() {
		return dmf_sdivmoneys;
	}
	public void setDmf_sdivmoneys(String dmf_sdivmoneys) {
		this.dmf_sdivmoneys = dmf_sdivmoneys;
	}
	public String getDmf_sreplyby() {
		return dmf_sreplyby;
	}
	public void setDmf_sreplyby(String dmf_sreplyby) {
		this.dmf_sreplyby = dmf_sreplyby;
	}
	public String getDmf_dreplydate() {
		return dmf_dreplydate;
	}
	public void setDmf_dreplydate(String dmf_dreplydate) {
		this.dmf_dreplydate = dmf_dreplydate;
	}
	public String getDmf_salterby() {
		return dmf_salterby;
	}
	public void setDmf_salterby(String dmf_salterby) {
		this.dmf_salterby = dmf_salterby;
	}
	public String getDmf_dalterdate() {
		return dmf_dalterdate;
	}
	public void setDmf_dalterdate(String dmf_dalterdate) {
		this.dmf_dalterdate = dmf_dalterdate;
	}
	public String getDmf_sdef1() {
		return dmf_sdef1;
	}
	public void setDmf_sdef1(String dmf_sdef1) {
		this.dmf_sdef1 = dmf_sdef1;
	}
	public String getDmf_sdef2() {
		return dmf_sdef2;
	}
	public void setDmf_sdef2(String dmf_sdef2) {
		this.dmf_sdef2 = dmf_sdef2;
	}
	public String getDmf_sdef3() {
		return dmf_sdef3;
	}
	public void setDmf_sdef3(String dmf_sdef3) {
		this.dmf_sdef3 = dmf_sdef3;
	}
	public String getDmf_sdef4() {
		return dmf_sdef4;
	}
	public void setDmf_sdef4(String dmf_sdef4) {
		this.dmf_sdef4 = dmf_sdef4;
	}
	public String getDmf_sdef5() {
		return dmf_sdef5;
	}
	public void setDmf_sdef5(String dmf_sdef5) {
		this.dmf_sdef5 = dmf_sdef5;
	}
	public String getDmf_sdef6() {
		return dmf_sdef6;
	}
	public void setDmf_sdef6(String dmf_sdef6) {
		this.dmf_sdef6 = dmf_sdef6;
	}
	public String getDmf_sdef7() {
		return dmf_sdef7;
	}
	public void setDmf_sdef7(String dmf_sdef7) {
		this.dmf_sdef7 = dmf_sdef7;
	}
	public String getDmf_sdef8() {
		return dmf_sdef8;
	}
	public void setDmf_sdef8(String dmf_sdef8) {
		this.dmf_sdef8 = dmf_sdef8;
	}
	public String getDmf_sdef9() {
		return dmf_sdef9;
	}
	public void setDmf_sdef9(String dmf_sdef9) {
		this.dmf_sdef9 = dmf_sdef9;
	}
	public String getDmf_sdef10() {
		return dmf_sdef10;
	}
	public void setDmf_sdef10(String dmf_sdef10) {
		this.dmf_sdef10 = dmf_sdef10;
	}
	public String getDmf_ddef1() {
		return dmf_ddef1;
	}
	public void setDmf_ddef1(String dmf_ddef1) {
		this.dmf_ddef1 = dmf_ddef1;
	}
	public String getDmf_ddef2() {
		return dmf_ddef2;
	}
	public void setDmf_ddef2(String dmf_ddef2) {
		this.dmf_ddef2 = dmf_ddef2;
	}
	public String getDmf_ddef3() {
		return dmf_ddef3;
	}
	public void setDmf_ddef3(String dmf_ddef3) {
		this.dmf_ddef3 = dmf_ddef3;
	}
	public String getDmf_ddef4() {
		return dmf_ddef4;
	}
	public void setDmf_ddef4(String dmf_ddef4) {
		this.dmf_ddef4 = dmf_ddef4;
	}
	public String getDmf_ddef5() {
		return dmf_ddef5;
	}
	public void setDmf_ddef5(String dmf_ddef5) {
		this.dmf_ddef5 = dmf_ddef5;
	}
	public BigDecimal getDmf_ndef1() {
		return dmf_ndef1;
	}
	public void setDmf_ndef1(BigDecimal dmf_ndef1) {
		this.dmf_ndef1 = dmf_ndef1;
	}
	public BigDecimal getDmf_ndef2() {
		return dmf_ndef2;
	}
	public void setDmf_ndef2(BigDecimal dmf_ndef2) {
		this.dmf_ndef2 = dmf_ndef2;
	}
	public BigDecimal getDmf_ndef3() {
		return dmf_ndef3;
	}
	public void setDmf_ndef3(BigDecimal dmf_ndef3) {
		this.dmf_ndef3 = dmf_ndef3;
	}
	public BigDecimal getDmf_ndef4() {
		return dmf_ndef4;
	}
	public void setDmf_ndef4(BigDecimal dmf_ndef4) {
		this.dmf_ndef4 = dmf_ndef4;
	}
	public BigDecimal getDmf_ndef5() {
		return dmf_ndef5;
	}
	public void setDmf_ndef5(BigDecimal dmf_ndef5) {
		this.dmf_ndef5 = dmf_ndef5;
	}
	

}
