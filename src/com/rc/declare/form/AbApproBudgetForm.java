package com.rc.declare.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.AbApproBudget.java
 *  @Class Name    : AbApproBudget
 *  @Description   : 项目申请支出预算
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class AbApproBudgetForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String ab_sid;//	id	
	private String org_sno;//	所属单位	varchar
	private String rp_sprojectno;//	项目编码	varchar
	private String ab_ssort;//	类别	varchar
	private String ab_ssource;//	资金来源项目	varchar
	private String ab_snumber;//	序号	varchar
	private String ab_sitems	;//预算项	varchar
	private BigDecimal ab_smoney;//	金额	decimal
	private String ab_sisdel;//	是否删除	varchar
	private String ab_sisvalid;//	是否有效	varchar
	private String ab_sreplyby;//	创建人	varchar
	private String ab_sreplydate;//	填写日期	datetime
	private String ab_salterby;//	修改人	varchar
	private String ab_salterdate;//	修改日期	datetime
	private String ab_sdef1;//		varchar
	private String ab_sdef2;//		varchar
	private String ab_sdef3;//		varchar
	private String ab_sdef4;//		varchar
	private String ab_sdef5;//		varchar
	private String ab_sdef6;//		varchar
	private String ab_sdef7;//		varchar
	private String ab_sdef8;//		varchar
	private String ab_sdef9;//		varchar
	private String ab_sdef10;//		varchar
	private String ab_sdef11;//		varchar
	private String ab_sdef12;//		varchar
	private String ab_sdef13;//		varchar
	private String ab_sdef14;//		varchar
	private String ab_sdef15;//	支出明细类别	varchar
	private String ab_ddef16;//		datetime
	private String ab_ddef17;//		datetime
	private String ab_ddef18;//		datetime
	private String ab_ddef19;//		datetime
	private String ab_ddef20;//		datetime
	private BigDecimal ab_ndef1;//		decimal
	private BigDecimal ab_ndef2;//		decimal
	private BigDecimal ab_ndef3;//		decimal
	private BigDecimal ab_ndef4;//		decimal
	private BigDecimal ab_ndef5;//		decimal
	private BigDecimal ab_ndef6;//		decimal
	private BigDecimal ab_ndef7;//		decimal
	private BigDecimal ab_ndef8;//		decimal
	private BigDecimal ab_ndef9;//		decimal
	private BigDecimal ab_ndef10;//		decimal
	private BigDecimal ab_ndef11;//		decimal
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
	public String getAb_sid() {
		return ab_sid;
	}
	public void setAb_sid(String ab_sid) {
		this.ab_sid = ab_sid;
	}
	public String getOrg_sno() {
		return org_sno;
	}
	public void setOrg_sno(String org_sno) {
		this.org_sno = org_sno;
	}
	public String getRp_sprojectno() {
		return rp_sprojectno;
	}
	public void setRp_sprojectno(String rp_sprojectno) {
		this.rp_sprojectno = rp_sprojectno;
	}
	public String getAb_ssort() {
		return ab_ssort;
	}
	public void setAb_ssort(String ab_ssort) {
		this.ab_ssort = ab_ssort;
	}
	public String getAb_ssource() {
		return ab_ssource;
	}
	public void setAb_ssource(String ab_ssource) {
		this.ab_ssource = ab_ssource;
	}
	public String getAb_snumber() {
		return ab_snumber;
	}
	public void setAb_snumber(String ab_snumber) {
		this.ab_snumber = ab_snumber;
	}
	public String getAb_sitems() {
		return ab_sitems;
	}
	public void setAb_sitems(String ab_sitems) {
		this.ab_sitems = ab_sitems;
	}
	
	public BigDecimal getAb_smoney() {
		return ab_smoney;
	}
	public void setAb_smoney(BigDecimal ab_smoney) {
		this.ab_smoney = ab_smoney;
	}
	public String getAb_sisdel() {
		return ab_sisdel;
	}
	public void setAb_sisdel(String ab_sisdel) {
		this.ab_sisdel = ab_sisdel;
	}
	public String getAb_sisvalid() {
		return ab_sisvalid;
	}
	public void setAb_sisvalid(String ab_sisvalid) {
		this.ab_sisvalid = ab_sisvalid;
	}
	public String getAb_sreplyby() {
		return ab_sreplyby;
	}
	public void setAb_sreplyby(String ab_sreplyby) {
		this.ab_sreplyby = ab_sreplyby;
	}
	public String getAb_sreplydate() {
		return ab_sreplydate;
	}
	public void setAb_sreplydate(String ab_sreplydate) {
		this.ab_sreplydate = ab_sreplydate;
	}
	public String getAb_salterby() {
		return ab_salterby;
	}
	public void setAb_salterby(String ab_salterby) {
		this.ab_salterby = ab_salterby;
	}
	public String getAb_salterdate() {
		return ab_salterdate;
	}
	public void setAb_salterdate(String ab_salterdate) {
		this.ab_salterdate = ab_salterdate;
	}
	public String getAb_sdef1() {
		return ab_sdef1;
	}
	public void setAb_sdef1(String ab_sdef1) {
		this.ab_sdef1 = ab_sdef1;
	}
	public String getAb_sdef2() {
		return ab_sdef2;
	}
	public void setAb_sdef2(String ab_sdef2) {
		this.ab_sdef2 = ab_sdef2;
	}
	public String getAb_sdef3() {
		return ab_sdef3;
	}
	public void setAb_sdef3(String ab_sdef3) {
		this.ab_sdef3 = ab_sdef3;
	}
	public String getAb_sdef4() {
		return ab_sdef4;
	}
	public void setAb_sdef4(String ab_sdef4) {
		this.ab_sdef4 = ab_sdef4;
	}
	public String getAb_sdef5() {
		return ab_sdef5;
	}
	public void setAb_sdef5(String ab_sdef5) {
		this.ab_sdef5 = ab_sdef5;
	}
	public String getAb_sdef6() {
		return ab_sdef6;
	}
	public void setAb_sdef6(String ab_sdef6) {
		this.ab_sdef6 = ab_sdef6;
	}
	public String getAb_sdef7() {
		return ab_sdef7;
	}
	public void setAb_sdef7(String ab_sdef7) {
		this.ab_sdef7 = ab_sdef7;
	}
	public String getAb_sdef8() {
		return ab_sdef8;
	}
	public void setAb_sdef8(String ab_sdef8) {
		this.ab_sdef8 = ab_sdef8;
	}
	public String getAb_sdef9() {
		return ab_sdef9;
	}
	public void setAb_sdef9(String ab_sdef9) {
		this.ab_sdef9 = ab_sdef9;
	}
	public String getAb_sdef10() {
		return ab_sdef10;
	}
	public void setAb_sdef10(String ab_sdef10) {
		this.ab_sdef10 = ab_sdef10;
	}
	public String getAb_sdef11() {
		return ab_sdef11;
	}
	public void setAb_sdef11(String ab_sdef11) {
		this.ab_sdef11 = ab_sdef11;
	}
	public String getAb_sdef12() {
		return ab_sdef12;
	}
	public void setAb_sdef12(String ab_sdef12) {
		this.ab_sdef12 = ab_sdef12;
	}
	public String getAb_sdef13() {
		return ab_sdef13;
	}
	public void setAb_sdef13(String ab_sdef13) {
		this.ab_sdef13 = ab_sdef13;
	}
	public String getAb_sdef14() {
		return ab_sdef14;
	}
	public void setAb_sdef14(String ab_sdef14) {
		this.ab_sdef14 = ab_sdef14;
	}
	public String getAb_sdef15() {
		return ab_sdef15;
	}
	public void setAb_sdef15(String ab_sdef15) {
		this.ab_sdef15 = ab_sdef15;
	}
	public String getAb_ddef16() {
		return ab_ddef16;
	}
	public void setAb_ddef16(String ab_ddef16) {
		this.ab_ddef16 = ab_ddef16;
	}
	public String getAb_ddef17() {
		return ab_ddef17;
	}
	public void setAb_ddef17(String ab_ddef17) {
		this.ab_ddef17 = ab_ddef17;
	}
	public String getAb_ddef18() {
		return ab_ddef18;
	}
	public void setAb_ddef18(String ab_ddef18) {
		this.ab_ddef18 = ab_ddef18;
	}
	public String getAb_ddef19() {
		return ab_ddef19;
	}
	public void setAb_ddef19(String ab_ddef19) {
		this.ab_ddef19 = ab_ddef19;
	}
	public String getAb_ddef20() {
		return ab_ddef20;
	}
	public void setAb_ddef20(String ab_ddef20) {
		this.ab_ddef20 = ab_ddef20;
	}
	public BigDecimal getAb_ndef1() {
		return ab_ndef1;
	}
	public void setAb_ndef1(BigDecimal ab_ndef1) {
		this.ab_ndef1 = ab_ndef1;
	}
	public BigDecimal getAb_ndef2() {
		return ab_ndef2;
	}
	public void setAb_ndef2(BigDecimal ab_ndef2) {
		this.ab_ndef2 = ab_ndef2;
	}
	public BigDecimal getAb_ndef3() {
		return ab_ndef3;
	}
	public void setAb_ndef3(BigDecimal ab_ndef3) {
		this.ab_ndef3 = ab_ndef3;
	}
	public BigDecimal getAb_ndef4() {
		return ab_ndef4;
	}
	public void setAb_ndef4(BigDecimal ab_ndef4) {
		this.ab_ndef4 = ab_ndef4;
	}
	public BigDecimal getAb_ndef5() {
		return ab_ndef5;
	}
	public void setAb_ndef5(BigDecimal ab_ndef5) {
		this.ab_ndef5 = ab_ndef5;
	}
	public BigDecimal getAb_ndef6() {
		return ab_ndef6;
	}
	public void setAb_ndef6(BigDecimal ab_ndef6) {
		this.ab_ndef6 = ab_ndef6;
	}
	public BigDecimal getAb_ndef7() {
		return ab_ndef7;
	}
	public void setAb_ndef7(BigDecimal ab_ndef7) {
		this.ab_ndef7 = ab_ndef7;
	}
	public BigDecimal getAb_ndef8() {
		return ab_ndef8;
	}
	public void setAb_ndef8(BigDecimal ab_ndef8) {
		this.ab_ndef8 = ab_ndef8;
	}
	public BigDecimal getAb_ndef9() {
		return ab_ndef9;
	}
	public void setAb_ndef9(BigDecimal ab_ndef9) {
		this.ab_ndef9 = ab_ndef9;
	}
	public BigDecimal getAb_ndef10() {
		return ab_ndef10;
	}
	public void setAb_ndef10(BigDecimal ab_ndef10) {
		this.ab_ndef10 = ab_ndef10;
	}
	public BigDecimal getAb_ndef11() {
		return ab_ndef11;
	}
	public void setAb_ndef11(BigDecimal ab_ndef11) {
		this.ab_ndef11 = ab_ndef11;
	}
	
	

}
