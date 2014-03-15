package com.rc.declare.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.FbFeasibilityForm.java
 *  @Class Name    : FbFeasibilityForm
 *  @Description   : 项目可行性附表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class FbFeasibilityForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String fb_sid;//	id	varchar
	private String org_sno;//	所属单位	varchar
	private String rp_sprojectno;//	项目编码	varchar
	private String fb_stype;//	类别	varchar
	private String fb_snumber;//	序号	varchar
	private String fb_stitleno;//	标题级别编号	varchar
	private String fb_stitle;//	标题	text
	private String fb_sexplain;//	标题说明	text
	private String fb_scontent;//	具体内容	text
	private String fb_sisdel;//	是否删除	varchar
	private String fb_sisvalid;//	是否有效	varchar
	private String fb_sreplyby;//	创建人	varchar
	private String fb_sreplydate;//	填写日期	datetime
	private String fb_salterby	;//修改人	varchar
	private String fb_salterdate;//	修改日期	datetime
	private String fb_sdef1;//		varchar
	private String fb_sdef2;//		varchar
	private String fb_sdef3;//		varchar
	private String fb_sdef4;//		varchar
	private String fb_sdef5;//		varchar
	private String fb_sdef6;//		varchar
	private String fb_sdef7;//		varchar
	private String fb_sdef8;//		varchar
	private String fb_sdef9	;//	varchar
	private String fb_sdef10;//		varchar
	private String fb_sdef11;//		varchar
	private String fb_sdef12;//		varchar
	private String fb_sdef13;//		varchar
	private String fb_sdef14;//		varchar
	private String fb_sdef15;//		varchar
	private String fb_sdef16;//		datetime
	private String fb_sdef17;//		datetime
	private String fb_sdef18;//		datetime
	private String fb_sdef19;//		datetime
	private String fb_sdef20;//		datetime
	private BigDecimal fb_ndef1;//		decimal
	private BigDecimal fb_ndef2;//		decimal
	private BigDecimal fb_ndef3;//		decimal
	private BigDecimal fb_ndef4;//		decimal
	private BigDecimal fb_ndef5;//		decimal
	private BigDecimal fb_ndef6;//		decimal
	private BigDecimal fb_ndef7;//		decimal
	private BigDecimal fb_ndef8;//		decimal
	private BigDecimal fb_ndef9;//		decimal
	private BigDecimal fb_ndef10;//		decimal
	private BigDecimal fb_ndef11;//		decimal
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
	public String getFb_sid() {
		return fb_sid;
	}
	public void setFb_sid(String fb_sid) {
		this.fb_sid = fb_sid;
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
	public String getFb_stype() {
		return fb_stype;
	}
	public void setFb_stype(String fb_stype) {
		this.fb_stype = fb_stype;
	}
	public String getFb_snumber() {
		return fb_snumber;
	}
	public void setFb_snumber(String fb_snumber) {
		this.fb_snumber = fb_snumber;
	}
	public String getFb_stitleno() {
		return fb_stitleno;
	}
	public void setFb_stitleno(String fb_stitleno) {
		this.fb_stitleno = fb_stitleno;
	}
	public String getFb_stitle() {
		return fb_stitle;
	}
	public void setFb_stitle(String fb_stitle) {
		this.fb_stitle = fb_stitle;
	}
	public String getFb_sexplain() {
		return fb_sexplain;
	}
	public void setFb_sexplain(String fb_sexplain) {
		this.fb_sexplain = fb_sexplain;
	}
	public String getFb_scontent() {
		return fb_scontent;
	}
	public void setFb_scontent(String fb_scontent) {
		this.fb_scontent = fb_scontent;
	}
	public String getFb_sisdel() {
		return fb_sisdel;
	}
	public void setFb_sisdel(String fb_sisdel) {
		this.fb_sisdel = fb_sisdel;
	}
	public String getFb_sisvalid() {
		return fb_sisvalid;
	}
	public void setFb_sisvalid(String fb_sisvalid) {
		this.fb_sisvalid = fb_sisvalid;
	}
	public String getFb_sreplyby() {
		return fb_sreplyby;
	}
	public void setFb_sreplyby(String fb_sreplyby) {
		this.fb_sreplyby = fb_sreplyby;
	}
	public String getFb_sreplydate() {
		return fb_sreplydate;
	}
	public void setFb_sreplydate(String fb_sreplydate) {
		this.fb_sreplydate = fb_sreplydate;
	}
	public String getFb_salterby() {
		return fb_salterby;
	}
	public void setFb_salterby(String fb_salterby) {
		this.fb_salterby = fb_salterby;
	}
	public String getFb_salterdate() {
		return fb_salterdate;
	}
	public void setFb_salterdate(String fb_salterdate) {
		this.fb_salterdate = fb_salterdate;
	}
	public String getFb_sdef1() {
		return fb_sdef1;
	}
	public void setFb_sdef1(String fb_sdef1) {
		this.fb_sdef1 = fb_sdef1;
	}
	public String getFb_sdef2() {
		return fb_sdef2;
	}
	public void setFb_sdef2(String fb_sdef2) {
		this.fb_sdef2 = fb_sdef2;
	}
	public String getFb_sdef3() {
		return fb_sdef3;
	}
	public void setFb_sdef3(String fb_sdef3) {
		this.fb_sdef3 = fb_sdef3;
	}
	public String getFb_sdef4() {
		return fb_sdef4;
	}
	public void setFb_sdef4(String fb_sdef4) {
		this.fb_sdef4 = fb_sdef4;
	}
	public String getFb_sdef5() {
		return fb_sdef5;
	}
	public void setFb_sdef5(String fb_sdef5) {
		this.fb_sdef5 = fb_sdef5;
	}
	public String getFb_sdef6() {
		return fb_sdef6;
	}
	public void setFb_sdef6(String fb_sdef6) {
		this.fb_sdef6 = fb_sdef6;
	}
	public String getFb_sdef7() {
		return fb_sdef7;
	}
	public void setFb_sdef7(String fb_sdef7) {
		this.fb_sdef7 = fb_sdef7;
	}
	public String getFb_sdef8() {
		return fb_sdef8;
	}
	public void setFb_sdef8(String fb_sdef8) {
		this.fb_sdef8 = fb_sdef8;
	}
	public String getFb_sdef9() {
		return fb_sdef9;
	}
	public void setFb_sdef9(String fb_sdef9) {
		this.fb_sdef9 = fb_sdef9;
	}
	public String getFb_sdef10() {
		return fb_sdef10;
	}
	public void setFb_sdef10(String fb_sdef10) {
		this.fb_sdef10 = fb_sdef10;
	}
	public String getFb_sdef11() {
		return fb_sdef11;
	}
	public void setFb_sdef11(String fb_sdef11) {
		this.fb_sdef11 = fb_sdef11;
	}
	public String getFb_sdef12() {
		return fb_sdef12;
	}
	public void setFb_sdef12(String fb_sdef12) {
		this.fb_sdef12 = fb_sdef12;
	}
	public String getFb_sdef13() {
		return fb_sdef13;
	}
	public void setFb_sdef13(String fb_sdef13) {
		this.fb_sdef13 = fb_sdef13;
	}
	public String getFb_sdef14() {
		return fb_sdef14;
	}
	public void setFb_sdef14(String fb_sdef14) {
		this.fb_sdef14 = fb_sdef14;
	}
	public String getFb_sdef15() {
		return fb_sdef15;
	}
	public void setFb_sdef15(String fb_sdef15) {
		this.fb_sdef15 = fb_sdef15;
	}
	public String getFb_sdef16() {
		return fb_sdef16;
	}
	public void setFb_sdef16(String fb_sdef16) {
		this.fb_sdef16 = fb_sdef16;
	}
	public String getFb_sdef17() {
		return fb_sdef17;
	}
	public void setFb_sdef17(String fb_sdef17) {
		this.fb_sdef17 = fb_sdef17;
	}
	public String getFb_sdef18() {
		return fb_sdef18;
	}
	public void setFb_sdef18(String fb_sdef18) {
		this.fb_sdef18 = fb_sdef18;
	}
	public String getFb_sdef19() {
		return fb_sdef19;
	}
	public void setFb_sdef19(String fb_sdef19) {
		this.fb_sdef19 = fb_sdef19;
	}
	public String getFb_sdef20() {
		return fb_sdef20;
	}
	public void setFb_sdef20(String fb_sdef20) {
		this.fb_sdef20 = fb_sdef20;
	}
	public BigDecimal getFb_ndef1() {
		return fb_ndef1;
	}
	public void setFb_ndef1(BigDecimal fb_ndef1) {
		this.fb_ndef1 = fb_ndef1;
	}
	public BigDecimal getFb_ndef2() {
		return fb_ndef2;
	}
	public void setFb_ndef2(BigDecimal fb_ndef2) {
		this.fb_ndef2 = fb_ndef2;
	}
	public BigDecimal getFb_ndef3() {
		return fb_ndef3;
	}
	public void setFb_ndef3(BigDecimal fb_ndef3) {
		this.fb_ndef3 = fb_ndef3;
	}
	public BigDecimal getFb_ndef4() {
		return fb_ndef4;
	}
	public void setFb_ndef4(BigDecimal fb_ndef4) {
		this.fb_ndef4 = fb_ndef4;
	}
	public BigDecimal getFb_ndef5() {
		return fb_ndef5;
	}
	public void setFb_ndef5(BigDecimal fb_ndef5) {
		this.fb_ndef5 = fb_ndef5;
	}
	public BigDecimal getFb_ndef6() {
		return fb_ndef6;
	}
	public void setFb_ndef6(BigDecimal fb_ndef6) {
		this.fb_ndef6 = fb_ndef6;
	}
	public BigDecimal getFb_ndef7() {
		return fb_ndef7;
	}
	public void setFb_ndef7(BigDecimal fb_ndef7) {
		this.fb_ndef7 = fb_ndef7;
	}
	public BigDecimal getFb_ndef8() {
		return fb_ndef8;
	}
	public void setFb_ndef8(BigDecimal fb_ndef8) {
		this.fb_ndef8 = fb_ndef8;
	}
	public BigDecimal getFb_ndef9() {
		return fb_ndef9;
	}
	public void setFb_ndef9(BigDecimal fb_ndef9) {
		this.fb_ndef9 = fb_ndef9;
	}
	public BigDecimal getFb_ndef10() {
		return fb_ndef10;
	}
	public void setFb_ndef10(BigDecimal fb_ndef10) {
		this.fb_ndef10 = fb_ndef10;
	}
	public BigDecimal getFb_ndef11() {
		return fb_ndef11;
	}
	public void setFb_ndef11(BigDecimal fb_ndef11) {
		this.fb_ndef11 = fb_ndef11;
	}
	
	

}
