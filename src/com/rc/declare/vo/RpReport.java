package com.rc.declare.vo;

import java.math.BigDecimal;
import java.util.Date;


public class RpReport {
	private String rp_sid;//	申报编号	varchar
	private String org_sno;//	所属单位	varchar
	private String rp_sreportunit;//	申报单位(学院/处)	varchar
	private String rp_sdepartment;//	申报部门（系/科)	varchar
	private String rp_sprojectno;//	项目编码	varchar
	private String rp_sprojectname;//	项目名称	varchar
	private String rp_syear;	//	年度	varchar
	private Date rp_dreportdate;//	申报日期	Datetime
	private String rp_sperson;//	项目负责人	varchar
	private String rp_sperdepart;//	项目负责人所属部门	varchar
	private String ud_sname2;//项目负责人所属部门
	private String rp_spermajor;//	项目负责人所学专业	varchar
	private String rp_spertitle;//	项目负责人技术职称	varchar
	private String rp_sperjob;//	项目负责人现任职务	varchar
	private String rp_spertele;//	项目负责人联系电话	varchar
	private String rp_speremail	;//项目负责人邮箱	varchar
	private String rp_sperout;//	项目负责人与项目相关的主要业绩	text
	private String rp_slinkman;//	联系人	varchar
	private String emp_sname;
	private String emp_sname1;
	private String ud_sname;
	private String rp_slinkjob	;//联系人职务	varchar
	private String rp_slinktele;//	联系电话	varchar
	private String rp_slinkfax	;//联系人办公电话	varchar
	private String rp_slinkemail;//	联系人电子邮箱	varchar
	private String rp_sprotype;//	项目类别	varchar
	private String rp_sproperty;//	项目属性	varchar
	private String rp_sclass;//	类	varchar
	private String rp_sslow	;//款	varchar
	private String rp_sterm	;//项	varchar
	private String rp_sreason;//	申请理由及主要内容	text
	private String rp_spergoal;//	项目绩效目标	text
	private String pg_sid	;//阶段性目标	
	private String rp_scarry;//	项目组织实施条件	text
	private String rp_sisprocure;//	是否集中采购	varchar
	private String rp_scometotal;//	项目资金来源总计（万元）	decimal
	private BigDecimal rp_souttotal;//	支出预算总金额(万元)	decimal
	private String rp_sstatus;//	状态	varchar
	private String rp_sreviewtype;//	评审方式	varchar
	private Date rp_dbegintime;//	项目开始日期	Datetime
	private Date rp_dendtime;//	项目结束日期	Datetime
	private Date rp_dreviewtime;//	评审日期	Datetime
	private String rp_sperfect	;//项目材料及法定手续的完备性	text
	private String rp_sample	;//立项依据充分性	text
	private String rp_srational;//	项目设置的合理性	text
	private String rp_stissue;//	组织实施能力与条件	text
	private String rp_sincome;//	预期社会经济效益	text
	private String rp_sraise;//	资金筹措情况	text
	private String rp_spayrational;//	支出的合理性	text
	private String rp_srisk;//	风险性与不确定因素	text
	private String rp_sreview;//	评审意见	varchar
	private String rp_sreviewre;//	评审结果	varchar
	private String rp_sadvise;//	建议（轻重缓急）	varchar
	private String agency_sid;//	评审机构名称(中介)	varchar
	private String rp_swheelman	;//评审负责人(或专家组组长)	varchar
	private String rp_splan	;//进度与计划安排	text
	private String rp_sverdict;//	主要结论	text
	private String rp_sisdel;//	是否删除	varchar
	private String rp_sisvalid;//	是否有效	varchar
	private String rp_sreplyby	;//创建人	varchar
	private String rp_sreplyDate;//	填写日期	Datetime
	private String rp_salterby	;//修改人	varchar
	private String rp_salterDate;//	修改日期	Datetime
	private String rp_sdef1;//项目联系人所属部门	varchar
	private String ud_sname3;//项目联系人所属部门
	private String rp_sdef2	;//项目联系人 技术职称　	varchar
	private String rp_sdef3	;//项目联系人 所学专业　	varchar
	private String rp_sdef4	;//归口单位　	varchar
	private String ud_sname1;//归口单位名称
	private String rp_sdef5	;//校领导拨回备注	varchar
	private String rp_sdef6	;//	varchar
	private String rp_sdef7	;//	varchar
	private String rp_sdef8	;//	varchar
	private String rp_sdef9	;//申报书中是否包含设备清单表	varchar
	private String rp_sdef10;//	填单人	varchar
	private String rp_sdef11;//	是否进行论证答辩	varchar
	private String rp_sdef12;//	申报类型	varchar
	private String rp_sdef13;//	申报批次	varchar
	private String rp_sdef14;//	项目负责人办公电话	varchar
	private String rp_sdef15;//	存排序的序号（项目库）	int
	private Date rp_ddef16;//		Datetime
	private Date rp_ddef17	;//	Datetime
	private Date rp_ddef18;//		Datetime
	private Date rp_ddef19;//		Datetime
	private Date rp_ddef20	;//	Datetime
	private BigDecimal rp_ndef1	;//记录归口排序序号	decimal
	private BigDecimal rp_ndef2	;//	decimal
	private BigDecimal rp_ndef3	;//	decimal
	private BigDecimal rp_ndef4	;//	decimal
	private BigDecimal rp_ndef5	;//	decimal
	private BigDecimal rp_ndef6	;//	decimal
	private BigDecimal rp_ndef7	;//	decimal
	private BigDecimal rp_ndef8	;//	decimal
	private BigDecimal rp_ndef9	;//	decimal
	private BigDecimal rp_ndef10	;//	decimal
	private BigDecimal rp_ndef11	;//	decimal
	private BigDecimal rp_sfa1;//	财政拨款(一般项目)	decimal
	private BigDecimal rp_applybudget1	;//其中申请当年财政预算(一般项目)	decimal
	private BigDecimal rp_extrabudgetary1;//	预算外资金(一般项目)	decimal
	private BigDecimal rp_others1	;//其他资金(一般项目)	decimal
	private BigDecimal rp_total1	;//合计(一般项目)	decimal
	private String rp_explain1;//	测算依据及说明(一般项目)	text
	private BigDecimal rp_sfa2;//	财政拨款(设备购置) 	decimal
	private BigDecimal rp_applybudget2	;//其中申请当年财政预算(设备购置) 	decimal
	private BigDecimal rp_extrabudgetary2	;//预算外资金(设备购置) 	decimal
	private BigDecimal rp_others2	;//其他资金(设备购置) 	decimal
	private BigDecimal rp_total2	;//合计(设备购置) 	decimal
	private String rp_explain2	;//测算依据及说明(设备购置) 	text
	private String rp_jobcontent	;//1.主要工作内容	text
	private String rp_totaltarget	;//2.预期总目标及阶段性目标情况	text
	private String rp_benefitgoal;//	3.主要预期经济效益或社会效益目标	text
	private String rp_totalsituation;//	4.项目总投入情况（包括人、财、物方面	text
	private String rp_bginformation	;//1.项目背景情况:	text
	private String rp_necessity;//	2.项目实施的必要性:	text
	private String rp_feasibility	;//3.项目实施的可行性:	text
	private String rp_uncertainty;//	4.项目风险与不确定性:	text
	private String rp_personcondition;//	1.人员条件	text
	private String rp_moneycondition;//	2.资金条件:	text
	private String rp_basecondition;//	3.基础条件	text
	private String rp_correlacondition;//	4.其他相关条件:	text
	private String rpson_nid;//申报子表主键
	private String ub_sid;
	private String bmx_sid;
	private String ab_sid;
	private String fb_sid;
	private String sl_sid;
	private String as_sid;
	
	public String getUd_sname2() {
		return ud_sname2;
	}
	public void setUd_sname2(String ud_sname2) {
		this.ud_sname2 = ud_sname2;
	}
	public String getUd_sname3() {
		return ud_sname3;
	}
	public void setUd_sname3(String ud_sname3) {
		this.ud_sname3 = ud_sname3;
	}
	public String getUd_sname1() {
		return ud_sname1;
	}
	public void setUd_sname1(String ud_sname1) {
		this.ud_sname1 = ud_sname1;
	}
	public String getEmp_sname() {
		return emp_sname;
	}
	public void setEmp_sname(String emp_sname) {
		this.emp_sname = emp_sname;
	}
	public String getEmp_sname1() {
		return emp_sname1;
	}
	public void setEmp_sname1(String emp_sname1) {
		this.emp_sname1 = emp_sname1;
	}
	public String getUd_sname() {
		return ud_sname;
	}
	public void setUd_sname(String ud_sname) {
		this.ud_sname = ud_sname;
	}
	public String getRpson_nid() {
		return rpson_nid;
	}
	public void setRpson_nid(String rpson_nid) {
		this.rpson_nid = rpson_nid;
	}
	public String getUb_sid() {
		return ub_sid;
	}
	public void setUb_sid(String ub_sid) {
		this.ub_sid = ub_sid;
	}
	public String getBmx_sid() {
		return bmx_sid;
	}
	public void setBmx_sid(String bmx_sid) {
		this.bmx_sid = bmx_sid;
	}
	public String getAb_sid() {
		return ab_sid;
	}
	public void setAb_sid(String ab_sid) {
		this.ab_sid = ab_sid;
	}
	public String getFb_sid() {
		return fb_sid;
	}
	public void setFb_sid(String fb_sid) {
		this.fb_sid = fb_sid;
	}
	public String getSl_sid() {
		return sl_sid;
	}
	public void setSl_sid(String sl_sid) {
		this.sl_sid = sl_sid;
	}
	public String getAs_sid() {
		return as_sid;
	}
	public void setAs_sid(String as_sid) {
		this.as_sid = as_sid;
	}
	public String getRp_sid() {
		return rp_sid;
	}
	public void setRp_sid(String rp_sid) {
		this.rp_sid = rp_sid;
	}
	public String getOrg_sno() {
		return org_sno;
	}
	public void setOrg_sno(String org_sno) {
		this.org_sno = org_sno;
	}
	public String getRp_sreportunit() {
		return rp_sreportunit;
	}
	public void setRp_sreportunit(String rp_sreportunit) {
		this.rp_sreportunit = rp_sreportunit;
	}
	public String getRp_sdepartment() {
		return rp_sdepartment;
	}
	public void setRp_sdepartment(String rp_sdepartment) {
		this.rp_sdepartment = rp_sdepartment;
	}
	public String getRp_sprojectno() {
		return rp_sprojectno;
	}
	public void setRp_sprojectno(String rp_sprojectno) {
		this.rp_sprojectno = rp_sprojectno;
	}
	public String getRp_sprojectname() {
		return rp_sprojectname;
	}
	public void setRp_sprojectname(String rp_sprojectname) {
		this.rp_sprojectname = rp_sprojectname;
	}
	public String getRp_syear() {
		return rp_syear;
	}
	public void setRp_syear(String rp_syear) {
		this.rp_syear = rp_syear;
	}
	
	public Date getRp_dreportdate() {
		return rp_dreportdate;
	}
	public void setRp_dreportdate(Date rp_dreportdate) {
		this.rp_dreportdate = rp_dreportdate;
	}
	public String getRp_sperson() {
		return rp_sperson;
	}
	public void setRp_sperson(String rp_sperson) {
		this.rp_sperson = rp_sperson;
	}
	public String getRp_sperdepart() {
		return rp_sperdepart;
	}
	public void setRp_sperdepart(String rp_sperdepart) {
		this.rp_sperdepart = rp_sperdepart;
	}
	public String getRp_spermajor() {
		return rp_spermajor;
	}
	public void setRp_spermajor(String rp_spermajor) {
		this.rp_spermajor = rp_spermajor;
	}
	public String getRp_spertitle() {
		return rp_spertitle;
	}
	public void setRp_spertitle(String rp_spertitle) {
		this.rp_spertitle = rp_spertitle;
	}
	public String getRp_sperjob() {
		return rp_sperjob;
	}
	public void setRp_sperjob(String rp_sperjob) {
		this.rp_sperjob = rp_sperjob;
	}
	public String getRp_spertele() {
		return rp_spertele;
	}
	public void setRp_spertele(String rp_spertele) {
		this.rp_spertele = rp_spertele;
	}
	public String getRp_speremail() {
		return rp_speremail;
	}
	public void setRp_speremail(String rp_speremail) {
		this.rp_speremail = rp_speremail;
	}
	public String getRp_sperout() {
		return rp_sperout;
	}
	public void setRp_sperout(String rp_sperout) {
		this.rp_sperout = rp_sperout;
	}
	public String getRp_slinkman() {
		return rp_slinkman;
	}
	public void setRp_slinkman(String rp_slinkman) {
		this.rp_slinkman = rp_slinkman;
	}
	public String getRp_slinkjob() {
		return rp_slinkjob;
	}
	public void setRp_slinkjob(String rp_slinkjob) {
		this.rp_slinkjob = rp_slinkjob;
	}
	public String getRp_slinktele() {
		return rp_slinktele;
	}
	public void setRp_slinktele(String rp_slinktele) {
		this.rp_slinktele = rp_slinktele;
	}
	public String getRp_slinkfax() {
		return rp_slinkfax;
	}
	public void setRp_slinkfax(String rp_slinkfax) {
		this.rp_slinkfax = rp_slinkfax;
	}
	public String getRp_slinkemail() {
		return rp_slinkemail;
	}
	public void setRp_slinkemail(String rp_slinkemail) {
		this.rp_slinkemail = rp_slinkemail;
	}
	public String getRp_sprotype() {
		return rp_sprotype;
	}
	public void setRp_sprotype(String rp_sprotype) {
		this.rp_sprotype = rp_sprotype;
	}
	public String getRp_sproperty() {
		return rp_sproperty;
	}
	public void setRp_sproperty(String rp_sproperty) {
		this.rp_sproperty = rp_sproperty;
	}
	public String getRp_sclass() {
		return rp_sclass;
	}
	public void setRp_sclass(String rp_sclass) {
		this.rp_sclass = rp_sclass;
	}
	public String getRp_sslow() {
		return rp_sslow;
	}
	public void setRp_sslow(String rp_sslow) {
		this.rp_sslow = rp_sslow;
	}
	public String getRp_sterm() {
		return rp_sterm;
	}
	public void setRp_sterm(String rp_sterm) {
		this.rp_sterm = rp_sterm;
	}
	public String getRp_sreason() {
		return rp_sreason;
	}
	public void setRp_sreason(String rp_sreason) {
		this.rp_sreason = rp_sreason;
	}
	public String getRp_spergoal() {
		return rp_spergoal;
	}
	public void setRp_spergoal(String rp_spergoal) {
		this.rp_spergoal = rp_spergoal;
	}
	public String getPg_sid() {
		return pg_sid;
	}
	public void setPg_sid(String pg_sid) {
		this.pg_sid = pg_sid;
	}
	public String getRp_scarry() {
		return rp_scarry;
	}
	public void setRp_scarry(String rp_scarry) {
		this.rp_scarry = rp_scarry;
	}
	public String getRp_sisprocure() {
		return rp_sisprocure;
	}
	public void setRp_sisprocure(String rp_sisprocure) {
		this.rp_sisprocure = rp_sisprocure;
	}
	public String getRp_scometotal() {
		return rp_scometotal;
	}
	public void setRp_scometotal(String rp_scometotal) {
		this.rp_scometotal = rp_scometotal;
	}
	
	public BigDecimal getRp_souttotal() {
		return rp_souttotal;
	}
	public void setRp_souttotal(BigDecimal rp_souttotal) {
		this.rp_souttotal = rp_souttotal;
	}
	public String getRp_sstatus() {
		return rp_sstatus;
	}
	public void setRp_sstatus(String rp_sstatus) {
		this.rp_sstatus = rp_sstatus;
	}
	public String getRp_sreviewtype() {
		return rp_sreviewtype;
	}
	public void setRp_sreviewtype(String rp_sreviewtype) {
		this.rp_sreviewtype = rp_sreviewtype;
	}
	public Date getRp_dbegintime() {
		return rp_dbegintime;
	}
	public void setRp_dbegintime(Date rp_dbegintime) {
		this.rp_dbegintime = rp_dbegintime;
	}
	public Date getRp_dendtime() {
		return rp_dendtime;
	}
	public void setRp_dendtime(Date rp_dendtime) {
		this.rp_dendtime = rp_dendtime;
	}
	public Date getRp_dreviewtime() {
		return rp_dreviewtime;
	}
	public void setRp_dreviewtime(Date rp_dreviewtime) {
		this.rp_dreviewtime = rp_dreviewtime;
	}
	public String getRp_sperfect() {
		return rp_sperfect;
	}
	public void setRp_sperfect(String rp_sperfect) {
		this.rp_sperfect = rp_sperfect;
	}
	public String getRp_sample() {
		return rp_sample;
	}
	public void setRp_sample(String rp_sample) {
		this.rp_sample = rp_sample;
	}
	public String getRp_srational() {
		return rp_srational;
	}
	public void setRp_srational(String rp_srational) {
		this.rp_srational = rp_srational;
	}
	public String getRp_stissue() {
		return rp_stissue;
	}
	public void setRp_stissue(String rp_stissue) {
		this.rp_stissue = rp_stissue;
	}
	public String getRp_sincome() {
		return rp_sincome;
	}
	public void setRp_sincome(String rp_sincome) {
		this.rp_sincome = rp_sincome;
	}
	public String getRp_sraise() {
		return rp_sraise;
	}
	public void setRp_sraise(String rp_sraise) {
		this.rp_sraise = rp_sraise;
	}
	public String getRp_spayrational() {
		return rp_spayrational;
	}
	public void setRp_spayrational(String rp_spayrational) {
		this.rp_spayrational = rp_spayrational;
	}
	public String getRp_srisk() {
		return rp_srisk;
	}
	public void setRp_srisk(String rp_srisk) {
		this.rp_srisk = rp_srisk;
	}
	public String getRp_sreview() {
		return rp_sreview;
	}
	public void setRp_sreview(String rp_sreview) {
		this.rp_sreview = rp_sreview;
	}
	public String getRp_sreviewre() {
		return rp_sreviewre;
	}
	public void setRp_sreviewre(String rp_sreviewre) {
		this.rp_sreviewre = rp_sreviewre;
	}
	public String getRp_sadvise() {
		return rp_sadvise;
	}
	public void setRp_sadvise(String rp_sadvise) {
		this.rp_sadvise = rp_sadvise;
	}
	public String getAgency_sid() {
		return agency_sid;
	}
	public void setAgency_sid(String agency_sid) {
		this.agency_sid = agency_sid;
	}
	public String getRp_swheelman() {
		return rp_swheelman;
	}
	public void setRp_swheelman(String rp_swheelman) {
		this.rp_swheelman = rp_swheelman;
	}
	public String getRp_splan() {
		return rp_splan;
	}
	public void setRp_splan(String rp_splan) {
		this.rp_splan = rp_splan;
	}
	public String getRp_sverdict() {
		return rp_sverdict;
	}
	public void setRp_sverdict(String rp_sverdict) {
		this.rp_sverdict = rp_sverdict;
	}
	public String getRp_sisdel() {
		return rp_sisdel;
	}
	public void setRp_sisdel(String rp_sisdel) {
		this.rp_sisdel = rp_sisdel;
	}
	public String getRp_sisvalid() {
		return rp_sisvalid;
	}
	public void setRp_sisvalid(String rp_sisvalid) {
		this.rp_sisvalid = rp_sisvalid;
	}
	public String getRp_sreplyby() {
		return rp_sreplyby;
	}
	public void setRp_sreplyby(String rp_sreplyby) {
		this.rp_sreplyby = rp_sreplyby;
	}
	public String getRp_sreplyDate() {
		return rp_sreplyDate;
	}
	public void setRp_sreplyDate(String rp_sreplyDate) {
		this.rp_sreplyDate = rp_sreplyDate;
	}
	public String getRp_salterby() {
		return rp_salterby;
	}
	public void setRp_salterby(String rp_salterby) {
		this.rp_salterby = rp_salterby;
	}
	public String getRp_salterDate() {
		return rp_salterDate;
	}
	public void setRp_salterDate(String rp_salterDate) {
		this.rp_salterDate = rp_salterDate;
	}
	public String getRp_sdef1() {
		return rp_sdef1;
	}
	public void setRp_sdef1(String rp_sdef1) {
		this.rp_sdef1 = rp_sdef1;
	}
	public String getRp_sdef2() {
		return rp_sdef2;
	}
	public void setRp_sdef2(String rp_sdef2) {
		this.rp_sdef2 = rp_sdef2;
	}
	public String getRp_sdef3() {
		return rp_sdef3;
	}
	public void setRp_sdef3(String rp_sdef3) {
		this.rp_sdef3 = rp_sdef3;
	}
	public String getRp_sdef4() {
		return rp_sdef4;
	}
	public void setRp_sdef4(String rp_sdef4) {
		this.rp_sdef4 = rp_sdef4;
	}
	public String getRp_sdef5() {
		return rp_sdef5;
	}
	public void setRp_sdef5(String rp_sdef5) {
		this.rp_sdef5 = rp_sdef5;
	}
	public String getRp_sdef6() {
		return rp_sdef6;
	}
	public void setRp_sdef6(String rp_sdef6) {
		this.rp_sdef6 = rp_sdef6;
	}
	public String getRp_sdef7() {
		return rp_sdef7;
	}
	public void setRp_sdef7(String rp_sdef7) {
		this.rp_sdef7 = rp_sdef7;
	}
	public String getRp_sdef8() {
		return rp_sdef8;
	}
	public void setRp_sdef8(String rp_sdef8) {
		this.rp_sdef8 = rp_sdef8;
	}
	public String getRp_sdef9() {
		return rp_sdef9;
	}
	public void setRp_sdef9(String rp_sdef9) {
		this.rp_sdef9 = rp_sdef9;
	}
	public String getRp_sdef10() {
		return rp_sdef10;
	}
	public void setRp_sdef10(String rp_sdef10) {
		this.rp_sdef10 = rp_sdef10;
	}
	public String getRp_sdef11() {
		return rp_sdef11;
	}
	public void setRp_sdef11(String rp_sdef11) {
		this.rp_sdef11 = rp_sdef11;
	}
	public String getRp_sdef12() {
		return rp_sdef12;
	}
	public void setRp_sdef12(String rp_sdef12) {
		this.rp_sdef12 = rp_sdef12;
	}
	public String getRp_sdef13() {
		return rp_sdef13;
	}
	public void setRp_sdef13(String rp_sdef13) {
		this.rp_sdef13 = rp_sdef13;
	}
	public String getRp_sdef14() {
		return rp_sdef14;
	}
	public void setRp_sdef14(String rp_sdef14) {
		this.rp_sdef14 = rp_sdef14;
	}
	public String getRp_sdef15() {
		return rp_sdef15;
	}
	public void setRp_sdef15(String rp_sdef15) {
		this.rp_sdef15 = rp_sdef15;
	}
	public Date getRp_ddef16() {
		return rp_ddef16;
	}
	public void setRp_ddef16(Date rp_ddef16) {
		this.rp_ddef16 = rp_ddef16;
	}
	public Date getRp_ddef17() {
		return rp_ddef17;
	}
	public void setRp_ddef17(Date rp_ddef17) {
		this.rp_ddef17 = rp_ddef17;
	}
	public Date getRp_ddef18() {
		return rp_ddef18;
	}
	public void setRp_ddef18(Date rp_ddef18) {
		this.rp_ddef18 = rp_ddef18;
	}
	public Date getRp_ddef19() {
		return rp_ddef19;
	}
	public void setRp_ddef19(Date rp_ddef19) {
		this.rp_ddef19 = rp_ddef19;
	}
	public Date getRp_ddef20() {
		return rp_ddef20;
	}
	public void setRp_ddef20(Date rp_ddef20) {
		this.rp_ddef20 = rp_ddef20;
	}
	public BigDecimal getRp_ndef1() {
		return rp_ndef1;
	}
	public void setRp_ndef1(BigDecimal rp_ndef1) {
		this.rp_ndef1 = rp_ndef1;
	}
	public BigDecimal getRp_ndef2() {
		return rp_ndef2;
	}
	public void setRp_ndef2(BigDecimal rp_ndef2) {
		this.rp_ndef2 = rp_ndef2;
	}
	public BigDecimal getRp_ndef3() {
		return rp_ndef3;
	}
	public void setRp_ndef3(BigDecimal rp_ndef3) {
		this.rp_ndef3 = rp_ndef3;
	}
	public BigDecimal getRp_ndef4() {
		return rp_ndef4;
	}
	public void setRp_ndef4(BigDecimal rp_ndef4) {
		this.rp_ndef4 = rp_ndef4;
	}
	public BigDecimal getRp_ndef5() {
		return rp_ndef5;
	}
	public void setRp_ndef5(BigDecimal rp_ndef5) {
		this.rp_ndef5 = rp_ndef5;
	}
	public BigDecimal getRp_ndef6() {
		return rp_ndef6;
	}
	public void setRp_ndef6(BigDecimal rp_ndef6) {
		this.rp_ndef6 = rp_ndef6;
	}
	public BigDecimal getRp_ndef7() {
		return rp_ndef7;
	}
	public void setRp_ndef7(BigDecimal rp_ndef7) {
		this.rp_ndef7 = rp_ndef7;
	}
	public BigDecimal getRp_ndef8() {
		return rp_ndef8;
	}
	public void setRp_ndef8(BigDecimal rp_ndef8) {
		this.rp_ndef8 = rp_ndef8;
	}
	public BigDecimal getRp_ndef9() {
		return rp_ndef9;
	}
	public void setRp_ndef9(BigDecimal rp_ndef9) {
		this.rp_ndef9 = rp_ndef9;
	}
	public BigDecimal getRp_ndef10() {
		return rp_ndef10;
	}
	public void setRp_ndef10(BigDecimal rp_ndef10) {
		this.rp_ndef10 = rp_ndef10;
	}
	public BigDecimal getRp_ndef11() {
		return rp_ndef11;
	}
	public void setRp_ndef11(BigDecimal rp_ndef11) {
		this.rp_ndef11 = rp_ndef11;
	}
	public BigDecimal getRp_sfa1() {
		return rp_sfa1;
	}
	public void setRp_sfa1(BigDecimal rp_sfa1) {
		this.rp_sfa1 = rp_sfa1;
	}
	public BigDecimal getRp_applybudget1() {
		return rp_applybudget1;
	}
	public void setRp_applybudget1(BigDecimal rp_applybudget1) {
		this.rp_applybudget1 = rp_applybudget1;
	}
	public BigDecimal getRp_extrabudgetary1() {
		return rp_extrabudgetary1;
	}
	public void setRp_extrabudgetary1(BigDecimal rp_extrabudgetary1) {
		this.rp_extrabudgetary1 = rp_extrabudgetary1;
	}
	public BigDecimal getRp_others1() {
		return rp_others1;
	}
	public void setRp_others1(BigDecimal rp_others1) {
		this.rp_others1 = rp_others1;
	}
	public BigDecimal getRp_total1() {
		return rp_total1;
	}
	public void setRp_total1(BigDecimal rp_total1) {
		this.rp_total1 = rp_total1;
	}
	public String getRp_explain1() {
		return rp_explain1;
	}
	public void setRp_explain1(String rp_explain1) {
		this.rp_explain1 = rp_explain1;
	}
	public BigDecimal getRp_sfa2() {
		return rp_sfa2;
	}
	public void setRp_sfa2(BigDecimal rp_sfa2) {
		this.rp_sfa2 = rp_sfa2;
	}
	public BigDecimal getRp_applybudget2() {
		return rp_applybudget2;
	}
	public void setRp_applybudget2(BigDecimal rp_applybudget2) {
		this.rp_applybudget2 = rp_applybudget2;
	}
	public BigDecimal getRp_extrabudgetary2() {
		return rp_extrabudgetary2;
	}
	public void setRp_extrabudgetary2(BigDecimal rp_extrabudgetary2) {
		this.rp_extrabudgetary2 = rp_extrabudgetary2;
	}
	public BigDecimal getRp_others2() {
		return rp_others2;
	}
	public void setRp_others2(BigDecimal rp_others2) {
		this.rp_others2 = rp_others2;
	}
	public BigDecimal getRp_total2() {
		return rp_total2;
	}
	public void setRp_total2(BigDecimal rp_total2) {
		this.rp_total2 = rp_total2;
	}
	public String getRp_explain2() {
		return rp_explain2;
	}
	public void setRp_explain2(String rp_explain2) {
		this.rp_explain2 = rp_explain2;
	}
	public String getRp_jobcontent() {
		return rp_jobcontent;
	}
	public void setRp_jobcontent(String rp_jobcontent) {
		this.rp_jobcontent = rp_jobcontent;
	}
	public String getRp_totaltarget() {
		return rp_totaltarget;
	}
	public void setRp_totaltarget(String rp_totaltarget) {
		this.rp_totaltarget = rp_totaltarget;
	}
	public String getRp_benefitgoal() {
		return rp_benefitgoal;
	}
	public void setRp_benefitgoal(String rp_benefitgoal) {
		this.rp_benefitgoal = rp_benefitgoal;
	}
	public String getRp_totalsituation() {
		return rp_totalsituation;
	}
	public void setRp_totalsituation(String rp_totalsituation) {
		this.rp_totalsituation = rp_totalsituation;
	}
	public String getRp_bginformation() {
		return rp_bginformation;
	}
	public void setRp_bginformation(String rp_bginformation) {
		this.rp_bginformation = rp_bginformation;
	}
	public String getRp_necessity() {
		return rp_necessity;
	}
	public void setRp_necessity(String rp_necessity) {
		this.rp_necessity = rp_necessity;
	}
	public String getRp_feasibility() {
		return rp_feasibility;
	}
	public void setRp_feasibility(String rp_feasibility) {
		this.rp_feasibility = rp_feasibility;
	}
	public String getRp_uncertainty() {
		return rp_uncertainty;
	}
	public void setRp_uncertainty(String rp_uncertainty) {
		this.rp_uncertainty = rp_uncertainty;
	}
	public String getRp_personcondition() {
		return rp_personcondition;
	}
	public void setRp_personcondition(String rp_personcondition) {
		this.rp_personcondition = rp_personcondition;
	}
	public String getRp_moneycondition() {
		return rp_moneycondition;
	}
	public void setRp_moneycondition(String rp_moneycondition) {
		this.rp_moneycondition = rp_moneycondition;
	}
	public String getRp_basecondition() {
		return rp_basecondition;
	}
	public void setRp_basecondition(String rp_basecondition) {
		this.rp_basecondition = rp_basecondition;
	}
	public String getRp_correlacondition() {
		return rp_correlacondition;
	}
	public void setRp_correlacondition(String rp_correlacondition) {
		this.rp_correlacondition = rp_correlacondition;
	}

	

}
