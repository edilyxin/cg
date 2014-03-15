package com.rc.declare.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.UBUnitBudget.java
 *  @Class Name    : UBUnitBudget
 *  @Description   : 联合评审预算表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class UBUnitBudget {
	private String ub_sid;//	主键	varchar
	private String rp_sid;//	申报id	varchar
	private String rp_sprojectno;//	申报项目编码	
	private String ud_sno;//	单位	
	private String ub_syear;//	年度	
	private String ub_nplanname;//	明细项目名称	varchar
	private BigDecimal ub_nunitprice;//	单价	decimal
	private BigDecimal ub_ncount;//	数量	decimal
	private BigDecimal ub_ntotal;//	总额	decimal
	private String ub_sisdel;//		
	private String ub_sreplyby;//	创建人	varchar
	private Date ub_dreplydate;//	创建时间	datetime
	private String ub_salterby;//	修改人	varchar
	private Date ub_dalterdate;//	修改时间	datetime
	private String ub_sdef1;//		varchar
	private String ub_sdef2;//		varchar
	private String ub_sdef3;//		varchar
	private String ub_sdef4;//		varchar
	private String ub_sdef5;//		varchar
	private String ub_sdef6;//		varchar
	private String ub_sdef7;//		varchar
	private String ub_sdef8;//		varchar
	private String ub_sdef9;//		varchar
	private String ub_sdef10;//		varchar
	private Date ub_ddef1;//		datetime
	private Date ub_ddef2;//		datetime
	private Date ub_ddef3;//		datetime
	private Date ub_ddef4;//		datetime
	private Date ub_ddef5;//		datetime
	private BigDecimal ub_ndef1;//		decimal
	private BigDecimal ub_ndef2;//		decimal
	private BigDecimal ub_ndef3;//		decimal
	private BigDecimal ub_ndef4;//		decimal
	private BigDecimal ub_ndef5;//		decimal
	public String getUb_sid() {
		return ub_sid;
	}
	public void setUb_sid(String ub_sid) {
		this.ub_sid = ub_sid;
	}
	public String getRp_sid() {
		return rp_sid;
	}
	public void setRp_sid(String rp_sid) {
		this.rp_sid = rp_sid;
	}
	public String getRp_sprojectno() {
		return rp_sprojectno;
	}
	public void setRp_sprojectno(String rp_sprojectno) {
		this.rp_sprojectno = rp_sprojectno;
	}
	public String getUd_sno() {
		return ud_sno;
	}
	public void setUd_sno(String ud_sno) {
		this.ud_sno = ud_sno;
	}
	public String getUb_syear() {
		return ub_syear;
	}
	public void setUb_syear(String ub_syear) {
		this.ub_syear = ub_syear;
	}
	
	public String getUb_nplanname() {
		return ub_nplanname;
	}
	public void setUb_nplanname(String ub_nplanname) {
		this.ub_nplanname = ub_nplanname;
	}
	public BigDecimal getUb_nunitprice() {
		return ub_nunitprice;
	}
	public void setUb_nunitprice(BigDecimal ub_nunitprice) {
		this.ub_nunitprice = ub_nunitprice;
	}
	public BigDecimal getUb_ncount() {
		return ub_ncount;
	}
	public void setUb_ncount(BigDecimal ub_ncount) {
		this.ub_ncount = ub_ncount;
	}
	public BigDecimal getUb_ntotal() {
		return ub_ntotal;
	}
	public void setUb_ntotal(BigDecimal ub_ntotal) {
		this.ub_ntotal = ub_ntotal;
	}
	public String getUb_sisdel() {
		return ub_sisdel;
	}
	public void setUb_sisdel(String ub_sisdel) {
		this.ub_sisdel = ub_sisdel;
	}
	public String getUb_sreplyby() {
		return ub_sreplyby;
	}
	public void setUb_sreplyby(String ub_sreplyby) {
		this.ub_sreplyby = ub_sreplyby;
	}
	public Date getUb_dreplydate() {
		return ub_dreplydate;
	}
	public void setUb_dreplydate(Date ub_dreplydate) {
		this.ub_dreplydate = ub_dreplydate;
	}
	public String getUb_salterby() {
		return ub_salterby;
	}
	public void setUb_salterby(String ub_salterby) {
		this.ub_salterby = ub_salterby;
	}
	public Date getUb_dalterdate() {
		return ub_dalterdate;
	}
	public void setUb_dalterdate(Date ub_dalterdate) {
		this.ub_dalterdate = ub_dalterdate;
	}
	public String getUb_sdef1() {
		return ub_sdef1;
	}
	public void setUb_sdef1(String ub_sdef1) {
		this.ub_sdef1 = ub_sdef1;
	}
	public String getUb_sdef2() {
		return ub_sdef2;
	}
	public void setUb_sdef2(String ub_sdef2) {
		this.ub_sdef2 = ub_sdef2;
	}
	public String getUb_sdef3() {
		return ub_sdef3;
	}
	public void setUb_sdef3(String ub_sdef3) {
		this.ub_sdef3 = ub_sdef3;
	}
	public String getUb_sdef4() {
		return ub_sdef4;
	}
	public void setUb_sdef4(String ub_sdef4) {
		this.ub_sdef4 = ub_sdef4;
	}
	public String getUb_sdef5() {
		return ub_sdef5;
	}
	public void setUb_sdef5(String ub_sdef5) {
		this.ub_sdef5 = ub_sdef5;
	}
	public String getUb_sdef6() {
		return ub_sdef6;
	}
	public void setUb_sdef6(String ub_sdef6) {
		this.ub_sdef6 = ub_sdef6;
	}
	public String getUb_sdef7() {
		return ub_sdef7;
	}
	public void setUb_sdef7(String ub_sdef7) {
		this.ub_sdef7 = ub_sdef7;
	}
	public String getUb_sdef8() {
		return ub_sdef8;
	}
	public void setUb_sdef8(String ub_sdef8) {
		this.ub_sdef8 = ub_sdef8;
	}
	public String getUb_sdef9() {
		return ub_sdef9;
	}
	public void setUb_sdef9(String ub_sdef9) {
		this.ub_sdef9 = ub_sdef9;
	}
	public String getUb_sdef10() {
		return ub_sdef10;
	}
	public void setUb_sdef10(String ub_sdef10) {
		this.ub_sdef10 = ub_sdef10;
	}
	public Date getUb_ddef1() {
		return ub_ddef1;
	}
	public void setUb_ddef1(Date ub_ddef1) {
		this.ub_ddef1 = ub_ddef1;
	}
	public Date getUb_ddef2() {
		return ub_ddef2;
	}
	public void setUb_ddef2(Date ub_ddef2) {
		this.ub_ddef2 = ub_ddef2;
	}
	public Date getUb_ddef3() {
		return ub_ddef3;
	}
	public void setUb_ddef3(Date ub_ddef3) {
		this.ub_ddef3 = ub_ddef3;
	}
	public Date getUb_ddef4() {
		return ub_ddef4;
	}
	public void setUb_ddef4(Date ub_ddef4) {
		this.ub_ddef4 = ub_ddef4;
	}
	public Date getUb_ddef5() {
		return ub_ddef5;
	}
	public void setUb_ddef5(Date ub_ddef5) {
		this.ub_ddef5 = ub_ddef5;
	}
	public BigDecimal getUb_ndef1() {
		return ub_ndef1;
	}
	public void setUb_ndef1(BigDecimal ub_ndef1) {
		this.ub_ndef1 = ub_ndef1;
	}
	public BigDecimal getUb_ndef2() {
		return ub_ndef2;
	}
	public void setUb_ndef2(BigDecimal ub_ndef2) {
		this.ub_ndef2 = ub_ndef2;
	}
	public BigDecimal getUb_ndef3() {
		return ub_ndef3;
	}
	public void setUb_ndef3(BigDecimal ub_ndef3) {
		this.ub_ndef3 = ub_ndef3;
	}
	public BigDecimal getUb_ndef4() {
		return ub_ndef4;
	}
	public void setUb_ndef4(BigDecimal ub_ndef4) {
		this.ub_ndef4 = ub_ndef4;
	}
	public BigDecimal getUb_ndef5() {
		return ub_ndef5;
	}
	public void setUb_ndef5(BigDecimal ub_ndef5) {
		this.ub_ndef5 = ub_ndef5;
	}

	

}
