package com.rc.declare.vo;

import java.math.BigDecimal;
import java.util.Date;


public class BMXBudgetMX {
	private String ub_nplanname;//明细项目名称
	private String ub_sid;//	联合表主键	varchar
	private String rp_sid;//	申报id	
	private String rp_sprojectno;//	申报项目编码	
	private String ud_sno;//	单位	
	private String bmx_syear;//	年度	
	private String bmx_sid;//	主键	varchar
	private String bmx_ssort;//	项目分类	varchar
	private String bmx_splanname;//	明细预算内容	varchar
	private String bmx_sisxieyi;//	是否协议采购	varchar
	private String bmx_sisimport	;//是否进口	varchar
	private BigDecimal bmx_unitprice;//	单价	decimal
	private BigDecimal bmx_ncount;//	数量	decimal
	private String bmx_sunit;//	单位	varchar
	private String bmx_smodel;//	规格型号	varchar
	private String bmx_srec;//	推荐供应商	varchar
	private Date bmx_sexetime;//	执行时间	datetime
	private BigDecimal bmx_ntotal;//	总额	decimal
	private String bmx_sisdel;//		
	private String bmx_sreplyby;//	创建人	varchar
	private Date bmx_dreplydate;//	创建时间	datetime
	private String bmx_salterby;//	修改人	varchar
	private Date bmx_dalterdate;//	修改时间	datetime
	private String bmx_sdef1;//		varchar
	private String bmx_sdef2	;//	varchar
	private String bmx_sdef3;//		varchar
	private String bmx_sdef4	;//	varchar
	private String bmx_sdef5;//		varchar
	private String bmx_sdef6	;//	varchar
	private String bmx_sdef7	;//	varchar
	private String bmx_sdef8	;//	varchar
	private String bmx_sdef9	;//	varchar
	private String bmx_sdef10	;//	varchar
	private Date bmx_ddef1;//		datetime
	private Date bmx_ddef2;//		datetime
	private Date bmx_ddef3;//		datetime
	private Date bmx_ddef4;//		datetime
	private Date bmx_ddef5;//		datetime
	private BigDecimal bmx_ndef1;//	已批复数量	decimal
	private BigDecimal bmx_ndef2;//		decimal
	private BigDecimal bmx_ndef3;//		decimal
	private BigDecimal bmx_ndef4;//		decimal
	private BigDecimal bmx_ndef5;//		decimal
	
	public String getUb_nplanname() {
		return ub_nplanname;
	}
	public void setUb_nplanname(String ub_nplanname) {
		this.ub_nplanname = ub_nplanname;
	}
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
	public String getBmx_syear() {
		return bmx_syear;
	}
	public void setBmx_syear(String bmx_syear) {
		this.bmx_syear = bmx_syear;
	}
	public String getBmx_sid() {
		return bmx_sid;
	}
	public void setBmx_sid(String bmx_sid) {
		this.bmx_sid = bmx_sid;
	}
	public String getBmx_ssort() {
		return bmx_ssort;
	}
	public void setBmx_ssort(String bmx_ssort) {
		this.bmx_ssort = bmx_ssort;
	}
	public String getBmx_splanname() {
		return bmx_splanname;
	}
	public void setBmx_splanname(String bmx_splanname) {
		this.bmx_splanname = bmx_splanname;
	}
	public String getBmx_sisxieyi() {
		return bmx_sisxieyi;
	}
	public void setBmx_sisxieyi(String bmx_sisxieyi) {
		this.bmx_sisxieyi = bmx_sisxieyi;
	}
	public String getBmx_sisimport() {
		return bmx_sisimport;
	}
	public void setBmx_sisimport(String bmx_sisimport) {
		this.bmx_sisimport = bmx_sisimport;
	}
	public BigDecimal getBmx_unitprice() {
		return bmx_unitprice;
	}
	public void setBmx_unitprice(BigDecimal bmx_unitprice) {
		this.bmx_unitprice = bmx_unitprice;
	}
	public BigDecimal getBmx_ncount() {
		return bmx_ncount;
	}
	public void setBmx_ncount(BigDecimal bmx_ncount) {
		this.bmx_ncount = bmx_ncount;
	}
	public String getBmx_sunit() {
		return bmx_sunit;
	}
	public void setBmx_sunit(String bmx_sunit) {
		this.bmx_sunit = bmx_sunit;
	}
	public String getBmx_smodel() {
		return bmx_smodel;
	}
	public void setBmx_smodel(String bmx_smodel) {
		this.bmx_smodel = bmx_smodel;
	}
	public String getBmx_srec() {
		return bmx_srec;
	}
	public void setBmx_srec(String bmx_srec) {
		this.bmx_srec = bmx_srec;
	}
	
	public Date getBmx_sexetime() {
		return bmx_sexetime;
	}
	public void setBmx_sexetime(Date bmx_sexetime) {
		this.bmx_sexetime = bmx_sexetime;
	}
	public BigDecimal getBmx_ntotal() {
		return bmx_ntotal;
	}
	public void setBmx_ntotal(BigDecimal bmx_ntotal) {
		this.bmx_ntotal = bmx_ntotal;
	}
	public String getBmx_sisdel() {
		return bmx_sisdel;
	}
	public void setBmx_sisdel(String bmx_sisdel) {
		this.bmx_sisdel = bmx_sisdel;
	}
	public String getBmx_sreplyby() {
		return bmx_sreplyby;
	}
	public void setBmx_sreplyby(String bmx_sreplyby) {
		this.bmx_sreplyby = bmx_sreplyby;
	}
	public Date getBmx_dreplydate() {
		return bmx_dreplydate;
	}
	public void setBmx_dreplydate(Date bmx_dreplydate) {
		this.bmx_dreplydate = bmx_dreplydate;
	}
	public String getBmx_salterby() {
		return bmx_salterby;
	}
	public void setBmx_salterby(String bmx_salterby) {
		this.bmx_salterby = bmx_salterby;
	}
	public Date getBmx_dalterdate() {
		return bmx_dalterdate;
	}
	public void setBmx_dalterdate(Date bmx_dalterdate) {
		this.bmx_dalterdate = bmx_dalterdate;
	}
	public String getBmx_sdef1() {
		return bmx_sdef1;
	}
	public void setBmx_sdef1(String bmx_sdef1) {
		this.bmx_sdef1 = bmx_sdef1;
	}
	public String getBmx_sdef2() {
		return bmx_sdef2;
	}
	public void setBmx_sdef2(String bmx_sdef2) {
		this.bmx_sdef2 = bmx_sdef2;
	}
	public String getBmx_sdef3() {
		return bmx_sdef3;
	}
	public void setBmx_sdef3(String bmx_sdef3) {
		this.bmx_sdef3 = bmx_sdef3;
	}
	public String getBmx_sdef4() {
		return bmx_sdef4;
	}
	public void setBmx_sdef4(String bmx_sdef4) {
		this.bmx_sdef4 = bmx_sdef4;
	}
	public String getBmx_sdef5() {
		return bmx_sdef5;
	}
	public void setBmx_sdef5(String bmx_sdef5) {
		this.bmx_sdef5 = bmx_sdef5;
	}
	public String getBmx_sdef6() {
		return bmx_sdef6;
	}
	public void setBmx_sdef6(String bmx_sdef6) {
		this.bmx_sdef6 = bmx_sdef6;
	}
	public String getBmx_sdef7() {
		return bmx_sdef7;
	}
	public void setBmx_sdef7(String bmx_sdef7) {
		this.bmx_sdef7 = bmx_sdef7;
	}
	public String getBmx_sdef8() {
		return bmx_sdef8;
	}
	public void setBmx_sdef8(String bmx_sdef8) {
		this.bmx_sdef8 = bmx_sdef8;
	}
	public String getBmx_sdef9() {
		return bmx_sdef9;
	}
	public void setBmx_sdef9(String bmx_sdef9) {
		this.bmx_sdef9 = bmx_sdef9;
	}
	public String getBmx_sdef10() {
		return bmx_sdef10;
	}
	public void setBmx_sdef10(String bmx_sdef10) {
		this.bmx_sdef10 = bmx_sdef10;
	}
	public Date getBmx_ddef1() {
		return bmx_ddef1;
	}
	public void setBmx_ddef1(Date bmx_ddef1) {
		this.bmx_ddef1 = bmx_ddef1;
	}
	public Date getBmx_ddef2() {
		return bmx_ddef2;
	}
	public void setBmx_ddef2(Date bmx_ddef2) {
		this.bmx_ddef2 = bmx_ddef2;
	}
	public Date getBmx_ddef3() {
		return bmx_ddef3;
	}
	public void setBmx_ddef3(Date bmx_ddef3) {
		this.bmx_ddef3 = bmx_ddef3;
	}
	public Date getBmx_ddef4() {
		return bmx_ddef4;
	}
	public void setBmx_ddef4(Date bmx_ddef4) {
		this.bmx_ddef4 = bmx_ddef4;
	}
	public Date getBmx_ddef5() {
		return bmx_ddef5;
	}
	public void setBmx_ddef5(Date bmx_ddef5) {
		this.bmx_ddef5 = bmx_ddef5;
	}
	public BigDecimal getBmx_ndef1() {
		return bmx_ndef1;
	}
	public void setBmx_ndef1(BigDecimal bmx_ndef1) {
		this.bmx_ndef1 = bmx_ndef1;
	}
	public BigDecimal getBmx_ndef2() {
		return bmx_ndef2;
	}
	public void setBmx_ndef2(BigDecimal bmx_ndef2) {
		this.bmx_ndef2 = bmx_ndef2;
	}
	public BigDecimal getBmx_ndef3() {
		return bmx_ndef3;
	}
	public void setBmx_ndef3(BigDecimal bmx_ndef3) {
		this.bmx_ndef3 = bmx_ndef3;
	}
	public BigDecimal getBmx_ndef4() {
		return bmx_ndef4;
	}
	public void setBmx_ndef4(BigDecimal bmx_ndef4) {
		this.bmx_ndef4 = bmx_ndef4;
	}
	public BigDecimal getBmx_ndef5() {
		return bmx_ndef5;
	}
	public void setBmx_ndef5(BigDecimal bmx_ndef5) {
		this.bmx_ndef5 = bmx_ndef5;
	}

	

}
