package com.rc.declare.form;

import java.io.File;
import java.math.BigDecimal;


public class RpReportForm {
	private String searchA;
	private String searchB;
	private String searchC;
	private String searchD;
	private String searchE;
	private String searchF;
	private String searchH;
	private String[] shuzu;
	private String pageSQLA;// 分页前段
	private String pageSQLB;// 分页后段 
	private String rp_sid;//	申报编号	varchar
	private String org_sno;//	所属单位	varchar
	private String rp_sreportunit;//	申报单位(学院/处)	varchar
	private String rp_sdepartment;//	申报部门（系/科)	varchar
	private String rp_sprojectno;//	项目编码	varchar
	private String rp_sprojectname;//	项目名称	varchar
	private String rp_syear;//	年度	varchar
	private String rp_dreportdate;//	申报日期	Stringtime
	private String rp_sperson;//	项目负责人	varchar
	private String rp_sperdepart;//	项目负责人所属部门	varchar
	private String rp_spermajor;//	项目负责人所学专业	varchar
	private String rp_spertitle;//	项目负责人技术职称	varchar
	private String rp_sperjob;//	项目负责人现任职务	varchar
	private String rp_spertele;//	项目负责人联系电话	varchar
	private String rp_speremail	;//项目负责人邮箱	varchar
	private String rp_sperout;//	项目负责人与项目相关的主要业绩	text
	private String rp_slinkman;//	联系人	varchar
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
	private String rp_souttotal;//	支出预算总金额(万元)	decimal
	private String rp_sstatus;//	状态	varchar
	private String rp_sreviewtype;//	评审方式	varchar
	private String rp_dbegintime;//	项目开始日期	Stringtime
	private String rp_dendtime;//	项目结束日期	Stringtime
	private String rp_dreviewtime;//	评审日期	Stringtime
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
	private String rp_sreplyString;//	填写日期	Stringtime
	private String rp_salterby	;//修改人	varchar
	private String rp_salterString;//	修改日期	Stringtime
	private String rp_sdef1;//项目联系人所属部门	varchar
	private String rp_sdef2	;//项目联系人 技术职称　	varchar
	private String rp_sdef3	;//项目联系人 所学专业　	varchar
	private String rp_sdef4	;//归口单位　	varchar
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
	private String rp_ddef16;//		Stringtime
	private String rp_ddef17	;//	Stringtime
	private String rp_ddef18;//		Stringtime
	private String rp_ddef19;//		Stringtime
	private String rp_ddef20	;//	Stringtime
	private String rp_ndef1	;//记录归口排序序号	decimal
	private String rp_ndef2	;//	decimal
	private String rp_ndef3	;//	decimal
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
	private String fb_sid;
	//项目子表
	private String rpson_nid;//申报子表主键
	private String rpson_sname;//	项目名称
	private String rpson_sperson;//	负责人
	private String rpson_syear;//	年度
	private String rpson_nmoney;//	下拨经费
	private String rpson_sremark;//	备注
	private String rpson_sdef1;//	表头
	private String rpson_nfinance;//	财政拨款
	private String rpson_nfithisyear;//	其中申请当年财政预算
	private String rpson_nout;//	预算外资金
	private String rpson_nother;//	其他资金
	private String rpson_ntotal;//	合计
	private String rpson_sexplain;//	测算依据及说明
	//项目申请阶段性目标表
	private String pg_sphase;//	实施阶段
	private String pg_starget;//	目标内容
	private String pg_ttime;//	时间(月)
	private String pg_sreplyby;//	创建人
	private String pg_salterby;//	修改人
	//明细预算表
	private String bmx_sid;//	主键
	private String bmx_ssort;//	项目分类
	private String bmx_splanname;//	明细预算内容
	private String bmx_sisxieyi;//	是否协议采购
	private String bmx_sisimport;//	是否进口
	private String bmx_unitprice;//	单价
	private String bmx_ncount;//	数量
	private String bmx_sunit;//	单位
	private String bmx_smodel;//	规格型号
	private String bmx_srec;//	推荐供应商
	private String bmx_sexetime;//	执行时间
	private String bmx_ntotal;//	总额
	private String bmx_sdef1;//	备注
	private String bmx_sreplyby;//	创建人
	private String bmx_salterby;//	修改人
	private String bmx_sdef2;//	序号

	//联合评审预算表
	private String ub_sid;//主键
	private String ub_nplanname;//	明细项目名称
	private String ub_nunitprice;//	单价
	private String ub_ncount;//	数量
	private String ub_ntotal;//	总额
	private String ub_sreplyby;//	创建人
	private String ub_salterby;//	修改人
	private String ub_sdef1;//	序号
	//项目申请支出预算
	private String ab_sid;//	id
	private String ab_ssort;//	类别
	private String ab_sitems;//	预算项
	private String ab_smoney;//	金额
	private String ab_sreplyby;//	创建人
	private String ab_salterby;//	修改人
	//项目申请参与人
	private String sl_sid;//	id
	private String sl_sreplyby;//	创建人
	private String sl_snumber;
	private String sl_stype;
	private String sl_sname;
	private String sl_sjob;
	private String sl_sjobtitle;
	private String sl_smajor;
	private String sl_slevel;
	//专家（人员）表
	private String sl_sid1;//	id
	private String sl_sclass1;
	private String sl_stele1;
	private String sl_spin1;
	private String sl_snumber1;
	private String sl_smajor1;
	private String sl_sname1;
	private String sl_sjobtitleno1;
	private String sl_sdef9;
	private String sl_sgetjobaddr1;
	private String sl_stype1;
	
	//附件表
	private String as_sid;//	编号
	private String as_sno;//	包编号
	private String as_ntype;//	类型
	private String as_sname;//	名称
	private String as_surl;//	路径
	private String as_sperson;//	上传人
	private String as_dtime;//	上传时间
	private String as_sfiletype;//	附件类型（备用18）
	private String as_scontrtype;//	合同类型（备用19，协议中1协议，2结算）
	private String as_sreplyby;//	创建人
	private String as_salterby;//	修改人
	private File[] myFile;
	

	
	public String getSearchH() {
		return searchH;
	}
	public void setSearchH(String searchH) {
		this.searchH = searchH;
	}
	public String getSearchF() {
		return searchF;
	}
	public void setSearchF(String searchF) {
		this.searchF = searchF;
	}
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
	public String getRp_dreportdate() {
		return rp_dreportdate;
	}
	public void setRp_dreportdate(String rp_dreportdate) {
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
	public String getRp_souttotal() {
		return rp_souttotal;
	}
	public void setRp_souttotal(String rp_souttotal) {
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
	public String getRp_dbegintime() {
		return rp_dbegintime;
	}
	public void setRp_dbegintime(String rp_dbegintime) {
		this.rp_dbegintime = rp_dbegintime;
	}
	public String getRp_dendtime() {
		return rp_dendtime;
	}
	public void setRp_dendtime(String rp_dendtime) {
		this.rp_dendtime = rp_dendtime;
	}
	public String getRp_dreviewtime() {
		return rp_dreviewtime;
	}
	public void setRp_dreviewtime(String rp_dreviewtime) {
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
	public String getRp_sreplyString() {
		return rp_sreplyString;
	}
	public void setRp_sreplyString(String rp_sreplyString) {
		this.rp_sreplyString = rp_sreplyString;
	}
	public String getRp_salterby() {
		return rp_salterby;
	}
	public void setRp_salterby(String rp_salterby) {
		this.rp_salterby = rp_salterby;
	}
	public String getRp_salterString() {
		return rp_salterString;
	}
	public void setRp_salterString(String rp_salterString) {
		this.rp_salterString = rp_salterString;
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
	public String getRp_ddef16() {
		return rp_ddef16;
	}
	public void setRp_ddef16(String rp_ddef16) {
		this.rp_ddef16 = rp_ddef16;
	}
	public String getRp_ddef17() {
		return rp_ddef17;
	}
	public void setRp_ddef17(String rp_ddef17) {
		this.rp_ddef17 = rp_ddef17;
	}
	public String getRp_ddef18() {
		return rp_ddef18;
	}
	public void setRp_ddef18(String rp_ddef18) {
		this.rp_ddef18 = rp_ddef18;
	}
	public String getRp_ddef19() {
		return rp_ddef19;
	}
	public void setRp_ddef19(String rp_ddef19) {
		this.rp_ddef19 = rp_ddef19;
	}
	public String getRp_ddef20() {
		return rp_ddef20;
	}
	public void setRp_ddef20(String rp_ddef20) {
		this.rp_ddef20 = rp_ddef20;
	}
	public String getRp_ndef1() {
		return rp_ndef1;
	}
	public void setRp_ndef1(String rp_ndef1) {
		this.rp_ndef1 = rp_ndef1;
	}
	public String getRp_ndef2() {
		return rp_ndef2;
	}
	public void setRp_ndef2(String rp_ndef2) {
		this.rp_ndef2 = rp_ndef2;
	}
	public String getRp_ndef3() {
		return rp_ndef3;
	}
	public void setRp_ndef3(String rp_ndef3) {
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
	public String getFb_sid() {
		return fb_sid;
	}
	public void setFb_sid(String fb_sid) {
		this.fb_sid = fb_sid;
	}
	public String getRpson_nid() {
		return rpson_nid;
	}
	public void setRpson_nid(String rpson_nid) {
		this.rpson_nid = rpson_nid;
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
	public String getRpson_nmoney() {
		return rpson_nmoney;
	}
	public void setRpson_nmoney(String rpson_nmoney) {
		this.rpson_nmoney = rpson_nmoney;
	}
	public String getRpson_sremark() {
		return rpson_sremark;
	}
	public void setRpson_sremark(String rpson_sremark) {
		this.rpson_sremark = rpson_sremark;
	}
	public String getRpson_sdef1() {
		return rpson_sdef1;
	}
	public void setRpson_sdef1(String rpson_sdef1) {
		this.rpson_sdef1 = rpson_sdef1;
	}
	public String getRpson_nfinance() {
		return rpson_nfinance;
	}
	public void setRpson_nfinance(String rpson_nfinance) {
		this.rpson_nfinance = rpson_nfinance;
	}
	public String getRpson_nfithisyear() {
		return rpson_nfithisyear;
	}
	public void setRpson_nfithisyear(String rpson_nfithisyear) {
		this.rpson_nfithisyear = rpson_nfithisyear;
	}
	public String getRpson_nout() {
		return rpson_nout;
	}
	public void setRpson_nout(String rpson_nout) {
		this.rpson_nout = rpson_nout;
	}
	public String getRpson_nother() {
		return rpson_nother;
	}
	public void setRpson_nother(String rpson_nother) {
		this.rpson_nother = rpson_nother;
	}
	public String getRpson_ntotal() {
		return rpson_ntotal;
	}
	public void setRpson_ntotal(String rpson_ntotal) {
		this.rpson_ntotal = rpson_ntotal;
	}
	public String getRpson_sexplain() {
		return rpson_sexplain;
	}
	public void setRpson_sexplain(String rpson_sexplain) {
		this.rpson_sexplain = rpson_sexplain;
	}
	public String getPg_sphase() {
		return pg_sphase;
	}
	public void setPg_sphase(String pg_sphase) {
		this.pg_sphase = pg_sphase;
	}
	public String getPg_starget() {
		return pg_starget;
	}
	public void setPg_starget(String pg_starget) {
		this.pg_starget = pg_starget;
	}
	public String getPg_ttime() {
		return pg_ttime;
	}
	public void setPg_ttime(String pg_ttime) {
		this.pg_ttime = pg_ttime;
	}
	public String getPg_sreplyby() {
		return pg_sreplyby;
	}
	public void setPg_sreplyby(String pg_sreplyby) {
		this.pg_sreplyby = pg_sreplyby;
	}
	public String getPg_salterby() {
		return pg_salterby;
	}
	public void setPg_salterby(String pg_salterby) {
		this.pg_salterby = pg_salterby;
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
	public String getBmx_unitprice() {
		return bmx_unitprice;
	}
	public void setBmx_unitprice(String bmx_unitprice) {
		this.bmx_unitprice = bmx_unitprice;
	}
	public String getBmx_ncount() {
		return bmx_ncount;
	}
	public void setBmx_ncount(String bmx_ncount) {
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
	public String getBmx_sexetime() {
		return bmx_sexetime;
	}
	public void setBmx_sexetime(String bmx_sexetime) {
		this.bmx_sexetime = bmx_sexetime;
	}
	public String getBmx_ntotal() {
		return bmx_ntotal;
	}
	public void setBmx_ntotal(String bmx_ntotal) {
		this.bmx_ntotal = bmx_ntotal;
	}
	public String getBmx_sdef1() {
		return bmx_sdef1;
	}
	public void setBmx_sdef1(String bmx_sdef1) {
		this.bmx_sdef1 = bmx_sdef1;
	}
	public String getBmx_sreplyby() {
		return bmx_sreplyby;
	}
	public void setBmx_sreplyby(String bmx_sreplyby) {
		this.bmx_sreplyby = bmx_sreplyby;
	}
	public String getBmx_salterby() {
		return bmx_salterby;
	}
	public void setBmx_salterby(String bmx_salterby) {
		this.bmx_salterby = bmx_salterby;
	}
	public String getBmx_sdef2() {
		return bmx_sdef2;
	}
	public void setBmx_sdef2(String bmx_sdef2) {
		this.bmx_sdef2 = bmx_sdef2;
	}
	public String getUb_sid() {
		return ub_sid;
	}
	public void setUb_sid(String ub_sid) {
		this.ub_sid = ub_sid;
	}
	public String getUb_nplanname() {
		return ub_nplanname;
	}
	public void setUb_nplanname(String ub_nplanname) {
		this.ub_nplanname = ub_nplanname;
	}
	public String getUb_nunitprice() {
		return ub_nunitprice;
	}
	public void setUb_nunitprice(String ub_nunitprice) {
		this.ub_nunitprice = ub_nunitprice;
	}
	public String getUb_ncount() {
		return ub_ncount;
	}
	public void setUb_ncount(String ub_ncount) {
		this.ub_ncount = ub_ncount;
	}
	public String getUb_ntotal() {
		return ub_ntotal;
	}
	public void setUb_ntotal(String ub_ntotal) {
		this.ub_ntotal = ub_ntotal;
	}
	public String getUb_sreplyby() {
		return ub_sreplyby;
	}
	public void setUb_sreplyby(String ub_sreplyby) {
		this.ub_sreplyby = ub_sreplyby;
	}
	public String getUb_salterby() {
		return ub_salterby;
	}
	public void setUb_salterby(String ub_salterby) {
		this.ub_salterby = ub_salterby;
	}
	public String getUb_sdef1() {
		return ub_sdef1;
	}
	public void setUb_sdef1(String ub_sdef1) {
		this.ub_sdef1 = ub_sdef1;
	}
	public String getAb_sid() {
		return ab_sid;
	}
	public void setAb_sid(String ab_sid) {
		this.ab_sid = ab_sid;
	}
	public String getAb_ssort() {
		return ab_ssort;
	}
	public void setAb_ssort(String ab_ssort) {
		this.ab_ssort = ab_ssort;
	}
	public String getAb_sitems() {
		return ab_sitems;
	}
	public void setAb_sitems(String ab_sitems) {
		this.ab_sitems = ab_sitems;
	}
	public String getAb_smoney() {
		return ab_smoney;
	}
	public void setAb_smoney(String ab_smoney) {
		this.ab_smoney = ab_smoney;
	}
	public String getAb_sreplyby() {
		return ab_sreplyby;
	}
	public void setAb_sreplyby(String ab_sreplyby) {
		this.ab_sreplyby = ab_sreplyby;
	}
	public String getAb_salterby() {
		return ab_salterby;
	}
	public void setAb_salterby(String ab_salterby) {
		this.ab_salterby = ab_salterby;
	}
	public String getSl_sid() {
		return sl_sid;
	}
	public void setSl_sid(String sl_sid) {
		this.sl_sid = sl_sid;
	}
	public String getSl_sreplyby() {
		return sl_sreplyby;
	}
	public void setSl_sreplyby(String sl_sreplyby) {
		this.sl_sreplyby = sl_sreplyby;
	}
	public String getSl_snumber() {
		return sl_snumber;
	}
	public void setSl_snumber(String sl_snumber) {
		this.sl_snumber = sl_snumber;
	}
	public String getSl_stype() {
		return sl_stype;
	}
	public void setSl_stype(String sl_stype) {
		this.sl_stype = sl_stype;
	}
	public String getSl_sname() {
		return sl_sname;
	}
	public void setSl_sname(String sl_sname) {
		this.sl_sname = sl_sname;
	}
	public String getSl_sjob() {
		return sl_sjob;
	}
	public void setSl_sjob(String sl_sjob) {
		this.sl_sjob = sl_sjob;
	}
	public String getSl_sjobtitle() {
		return sl_sjobtitle;
	}
	public void setSl_sjobtitle(String sl_sjobtitle) {
		this.sl_sjobtitle = sl_sjobtitle;
	}
	public String getSl_smajor() {
		return sl_smajor;
	}
	public void setSl_smajor(String sl_smajor) {
		this.sl_smajor = sl_smajor;
	}
	public String getSl_slevel() {
		return sl_slevel;
	}
	public void setSl_slevel(String sl_slevel) {
		this.sl_slevel = sl_slevel;
	}
	public String getSl_sid1() {
		return sl_sid1;
	}
	public void setSl_sid1(String sl_sid1) {
		this.sl_sid1 = sl_sid1;
	}
	public String getSl_sclass1() {
		return sl_sclass1;
	}
	public void setSl_sclass1(String sl_sclass1) {
		this.sl_sclass1 = sl_sclass1;
	}
	public String getSl_stele1() {
		return sl_stele1;
	}
	public void setSl_stele1(String sl_stele1) {
		this.sl_stele1 = sl_stele1;
	}
	public String getSl_spin1() {
		return sl_spin1;
	}
	public void setSl_spin1(String sl_spin1) {
		this.sl_spin1 = sl_spin1;
	}
	public String getSl_snumber1() {
		return sl_snumber1;
	}
	public void setSl_snumber1(String sl_snumber1) {
		this.sl_snumber1 = sl_snumber1;
	}
	public String getSl_smajor1() {
		return sl_smajor1;
	}
	public void setSl_smajor1(String sl_smajor1) {
		this.sl_smajor1 = sl_smajor1;
	}
	public String getSl_sname1() {
		return sl_sname1;
	}
	public void setSl_sname1(String sl_sname1) {
		this.sl_sname1 = sl_sname1;
	}
	public String getSl_sjobtitleno1() {
		return sl_sjobtitleno1;
	}
	public void setSl_sjobtitleno1(String sl_sjobtitleno1) {
		this.sl_sjobtitleno1 = sl_sjobtitleno1;
	}
	public String getSl_sdef9() {
		return sl_sdef9;
	}
	public void setSl_sdef9(String sl_sdef9) {
		this.sl_sdef9 = sl_sdef9;
	}
	public String getSl_sgetjobaddr1() {
		return sl_sgetjobaddr1;
	}
	public void setSl_sgetjobaddr1(String sl_sgetjobaddr1) {
		this.sl_sgetjobaddr1 = sl_sgetjobaddr1;
	}
	public String getSl_stype1() {
		return sl_stype1;
	}
	public void setSl_stype1(String sl_stype1) {
		this.sl_stype1 = sl_stype1;
	}
	public String getAs_sid() {
		return as_sid;
	}
	public void setAs_sid(String as_sid) {
		this.as_sid = as_sid;
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
	public String getAs_sreplyby() {
		return as_sreplyby;
	}
	public void setAs_sreplyby(String as_sreplyby) {
		this.as_sreplyby = as_sreplyby;
	}
	public String getAs_salterby() {
		return as_salterby;
	}
	public void setAs_salterby(String as_salterby) {
		this.as_salterby = as_salterby;
	}
	public String[] getShuzu() {
		return shuzu;
	}
	public void setShuzu(String[] shuzu) {
		this.shuzu = shuzu;
	}
	
	

	

}
