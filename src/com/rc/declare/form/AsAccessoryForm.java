package com.rc.declare.form;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.AsAccessoryForm.java
 *  @Class Name    : AsAccessoryForm
 *  @Description   : 附件表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class AsAccessoryForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String as_sid;//	编号	varchar
	private String ep_sid;//	项目编号	varchar
	private String org_sno;//	单位编码	varchar
	private String as_sno;//	包编号	varchar
	private String as_ntype;//	类型	varchar
	private String as_sname;//	名称	varchar
	private String as_surl;//	路径	varchar
	private String as_sperson;//	上传人	varchar
	private String as_dtime;//	上传时间	datetime
	private String as_sfiletype;//	附件类型（备用18）	varchar
	private String as_scontrtype;//	合同类型（备用19，协议中1协议，2结算）	varchar
	private String as_sisdel;//	是否删除	varchar
	private String as_sisvalid;//	是否有效	varchar
	private String as_sreplyby;//	创建人	varchar
	private String as_sreplydate;//	填写日期	datetime
	private String as_salterby;//	修改人	varchar
	private String as_salterdate;//	修改日期	datetime
	private String as_sdef1;//		varchar
	private String as_sdef2;//		varchar
	private String as_sdef3;//		varchar
	private String as_sdef4;//		varchar
	private String as_sdef5;//		varchar
	private String as_sdef6;//		varchar
	private String as_sdef7;//		varchar
	private String as_sdef8;//		varchar
	private String as_sdef9;//		varchar
	private String as_sdef10;//		varchar
	private String as_sdef11;//		varchar
	private String as_sdef12;//		varchar
	private String as_sdef13;//		varchar
	private String as_sdef14;//		varchar
	private String as_sdef15;//		varchar
	private String as_sdef16;//		varchar
	private String as_sdef17;//		varchar
	private String as_sdef18;//		varchar
	private String as_sdef19;//		varchar
	private String as_sdef20;//		varchar
	private BigDecimal as_ndef1;//		decimal
	private BigDecimal as_ndef2;//		decimal
	private BigDecimal as_ndef3;//		decimal
	private BigDecimal as_ndef4;//		decimal
	private BigDecimal as_ndef5;//		decimal
	private BigDecimal as_ndef6;//		decimal
	private BigDecimal as_ndef7;//		decimal
	private BigDecimal as_ndef8;//		decimal
	private BigDecimal as_ndef9;//		decimal
	private BigDecimal as_ndef10;//		decimal
	private BigDecimal as_ndef11;//		decimal
	private File[] myFile;
	
	public File[] getMyFile() {
		return myFile;
	}
	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
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
	public String getAs_sid() {
		return as_sid;
	}
	public void setAs_sid(String as_sid) {
		this.as_sid = as_sid;
	}
	public String getEp_sid() {
		return ep_sid;
	}
	public void setEp_sid(String ep_sid) {
		this.ep_sid = ep_sid;
	}
	public String getOrg_sno() {
		return org_sno;
	}
	public void setOrg_sno(String org_sno) {
		this.org_sno = org_sno;
	}
	public String getAs_sno() {
		return as_sno;
	}
	public void setAs_sno(String as_sno) {
		this.as_sno = as_sno;
	}
	public String getAs_ntype() {
		return as_ntype;
	}
	public void setAs_ntype(String as_ntype) {
		this.as_ntype = as_ntype;
	}
	public String getAs_sname() {
		return as_sname;
	}
	public void setAs_sname(String as_sname) {
		this.as_sname = as_sname;
	}
	public String getAs_surl() {
		return as_surl;
	}
	public void setAs_surl(String as_surl) {
		this.as_surl = as_surl;
	}
	public String getAs_sperson() {
		return as_sperson;
	}
	public void setAs_sperson(String as_sperson) {
		this.as_sperson = as_sperson;
	}
	public String getAs_dtime() {
		return as_dtime;
	}
	public void setAs_dtime(String as_dtime) {
		this.as_dtime = as_dtime;
	}
	public String getAs_sfiletype() {
		return as_sfiletype;
	}
	public void setAs_sfiletype(String as_sfiletype) {
		this.as_sfiletype = as_sfiletype;
	}
	public String getAs_scontrtype() {
		return as_scontrtype;
	}
	public void setAs_scontrtype(String as_scontrtype) {
		this.as_scontrtype = as_scontrtype;
	}
	public String getAs_sisdel() {
		return as_sisdel;
	}
	public void setAs_sisdel(String as_sisdel) {
		this.as_sisdel = as_sisdel;
	}
	public String getAs_sisvalid() {
		return as_sisvalid;
	}
	public void setAs_sisvalid(String as_sisvalid) {
		this.as_sisvalid = as_sisvalid;
	}
	public String getAs_sreplyby() {
		return as_sreplyby;
	}
	public void setAs_sreplyby(String as_sreplyby) {
		this.as_sreplyby = as_sreplyby;
	}
	public String getAs_sreplydate() {
		return as_sreplydate;
	}
	public void setAs_sreplydate(String as_sreplydate) {
		this.as_sreplydate = as_sreplydate;
	}
	public String getAs_salterby() {
		return as_salterby;
	}
	public void setAs_salterby(String as_salterby) {
		this.as_salterby = as_salterby;
	}
	public String getAs_salterdate() {
		return as_salterdate;
	}
	public void setAs_salterdate(String as_salterdate) {
		this.as_salterdate = as_salterdate;
	}
	public String getAs_sdef1() {
		return as_sdef1;
	}
	public void setAs_sdef1(String as_sdef1) {
		this.as_sdef1 = as_sdef1;
	}
	public String getAs_sdef2() {
		return as_sdef2;
	}
	public void setAs_sdef2(String as_sdef2) {
		this.as_sdef2 = as_sdef2;
	}
	public String getAs_sdef3() {
		return as_sdef3;
	}
	public void setAs_sdef3(String as_sdef3) {
		this.as_sdef3 = as_sdef3;
	}
	public String getAs_sdef4() {
		return as_sdef4;
	}
	public void setAs_sdef4(String as_sdef4) {
		this.as_sdef4 = as_sdef4;
	}
	public String getAs_sdef5() {
		return as_sdef5;
	}
	public void setAs_sdef5(String as_sdef5) {
		this.as_sdef5 = as_sdef5;
	}
	public String getAs_sdef6() {
		return as_sdef6;
	}
	public void setAs_sdef6(String as_sdef6) {
		this.as_sdef6 = as_sdef6;
	}
	public String getAs_sdef7() {
		return as_sdef7;
	}
	public void setAs_sdef7(String as_sdef7) {
		this.as_sdef7 = as_sdef7;
	}
	public String getAs_sdef8() {
		return as_sdef8;
	}
	public void setAs_sdef8(String as_sdef8) {
		this.as_sdef8 = as_sdef8;
	}
	public String getAs_sdef9() {
		return as_sdef9;
	}
	public void setAs_sdef9(String as_sdef9) {
		this.as_sdef9 = as_sdef9;
	}
	public String getAs_sdef10() {
		return as_sdef10;
	}
	public void setAs_sdef10(String as_sdef10) {
		this.as_sdef10 = as_sdef10;
	}
	public String getAs_sdef11() {
		return as_sdef11;
	}
	public void setAs_sdef11(String as_sdef11) {
		this.as_sdef11 = as_sdef11;
	}
	public String getAs_sdef12() {
		return as_sdef12;
	}
	public void setAs_sdef12(String as_sdef12) {
		this.as_sdef12 = as_sdef12;
	}
	public String getAs_sdef13() {
		return as_sdef13;
	}
	public void setAs_sdef13(String as_sdef13) {
		this.as_sdef13 = as_sdef13;
	}
	public String getAs_sdef14() {
		return as_sdef14;
	}
	public void setAs_sdef14(String as_sdef14) {
		this.as_sdef14 = as_sdef14;
	}
	public String getAs_sdef15() {
		return as_sdef15;
	}
	public void setAs_sdef15(String as_sdef15) {
		this.as_sdef15 = as_sdef15;
	}
	public String getAs_sdef16() {
		return as_sdef16;
	}
	public void setAs_sdef16(String as_sdef16) {
		this.as_sdef16 = as_sdef16;
	}
	public String getAs_sdef17() {
		return as_sdef17;
	}
	public void setAs_sdef17(String as_sdef17) {
		this.as_sdef17 = as_sdef17;
	}
	public String getAs_sdef18() {
		return as_sdef18;
	}
	public void setAs_sdef18(String as_sdef18) {
		this.as_sdef18 = as_sdef18;
	}
	public String getAs_sdef19() {
		return as_sdef19;
	}
	public void setAs_sdef19(String as_sdef19) {
		this.as_sdef19 = as_sdef19;
	}
	public String getAs_sdef20() {
		return as_sdef20;
	}
	public void setAs_sdef20(String as_sdef20) {
		this.as_sdef20 = as_sdef20;
	}
	public BigDecimal getAs_ndef1() {
		return as_ndef1;
	}
	public void setAs_ndef1(BigDecimal as_ndef1) {
		this.as_ndef1 = as_ndef1;
	}
	public BigDecimal getAs_ndef2() {
		return as_ndef2;
	}
	public void setAs_ndef2(BigDecimal as_ndef2) {
		this.as_ndef2 = as_ndef2;
	}
	public BigDecimal getAs_ndef3() {
		return as_ndef3;
	}
	public void setAs_ndef3(BigDecimal as_ndef3) {
		this.as_ndef3 = as_ndef3;
	}
	public BigDecimal getAs_ndef4() {
		return as_ndef4;
	}
	public void setAs_ndef4(BigDecimal as_ndef4) {
		this.as_ndef4 = as_ndef4;
	}
	public BigDecimal getAs_ndef5() {
		return as_ndef5;
	}
	public void setAs_ndef5(BigDecimal as_ndef5) {
		this.as_ndef5 = as_ndef5;
	}
	public BigDecimal getAs_ndef6() {
		return as_ndef6;
	}
	public void setAs_ndef6(BigDecimal as_ndef6) {
		this.as_ndef6 = as_ndef6;
	}
	public BigDecimal getAs_ndef7() {
		return as_ndef7;
	}
	public void setAs_ndef7(BigDecimal as_ndef7) {
		this.as_ndef7 = as_ndef7;
	}
	public BigDecimal getAs_ndef8() {
		return as_ndef8;
	}
	public void setAs_ndef8(BigDecimal as_ndef8) {
		this.as_ndef8 = as_ndef8;
	}
	public BigDecimal getAs_ndef9() {
		return as_ndef9;
	}
	public void setAs_ndef9(BigDecimal as_ndef9) {
		this.as_ndef9 = as_ndef9;
	}
	public BigDecimal getAs_ndef10() {
		return as_ndef10;
	}
	public void setAs_ndef10(BigDecimal as_ndef10) {
		this.as_ndef10 = as_ndef10;
	}
	public BigDecimal getAs_ndef11() {
		return as_ndef11;
	}
	public void setAs_ndef11(BigDecimal as_ndef11) {
		this.as_ndef11 = as_ndef11;
	}
	
}
