package com.rc.declare.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *  @Project       : BeiGS
 *  @Program Name  : com.rc.declare.vo.SlSpecialist.java
 *  @Class Name    : SlSpecialist
 *  @Description   : 专家（人员）表
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午04:47:30
 */
public class SlSpecialist {
	private String sl_sid;//	id	varchar
	private String org_sno;//	所属单位	varchar
	private String rp_sprojectno;//	项目编码	varchar
	private String sl_stype;//	类别	varchar
	private String sl_sclass;//	类型	vatchar
	private String sl_snumber;//	序号	varchar
	private String sl_sname;//	姓名	varchar
	private String sl_spin;//	身份证号	varchar
	private String sl_sjob;//	职务	varchar
	private String sl_sjobtitle;//	职称	varchar
	private String sl_sjobtitleno;//	职称证书编号	varchar
	private String sl_sgetjobaddr;//	发证机关	varchar
	private String sl_smajor;//	专业	varchar
	private String sl_stele;//	联系电话	varchar
	private String sl_semail;//	email	varchar
	private String sl_slevel;//	对专业熟炼程度	varchar
	private String sl_sisget;//	中国境内无法获取	varchar
	private String sl_sisgetbyreason;//	中国境内无法以合理的商业条件获取	varchar
	private String sl_sisdel;//	是否删除	varchar
	private String sl_sisvalid;//	是否有效	varchar
	private String sl_sreplyby;//	创建人	varchar
	private Date sl_sreplydate;//	填写日期	datetime
	private String sl_salterby;//	修改人	varchar
	private Date sl_salterdate;//	修改日期	datetime
	private String sl_sdef1	;//	varchar
	private String sl_sdef2;//		varchar
	private String sl_sdef3;//		varchar
	private String sl_sdef4;//		varchar
	private String sl_sdef5;//		varchar
	private String sl_sdef6	;//	varchar
	private String sl_sdef7	;//	varchar
	private String sl_sdef8;//		varchar
	private String sl_sdef9;//	专家单位	varchar
	private String sl_sdef10;//	申请单编号	varchar
	private String sl_sdef11;//		varchar
	private String sl_sdef12;//		varchar
	private String sl_sdef13;//		varchar
	private String sl_sdef14;//		varchar
	private String sl_sdef15;//		varchar
	private Date sl_sdef16	;//	datetime
	private Date sl_sdef17;//		datetime
	private Date sl_sdef18;//		datetime
	private Date sl_sdef19;//		datetime
	private Date sl_sdef20;//		datetime
	private BigDecimal sl_ndef1;//		decimal
	private BigDecimal sl_ndef2;//		decimal
	private BigDecimal sl_ndef3;//		decimal
	private BigDecimal sl_ndef4;//		decimal
	private BigDecimal sl_ndef5;//		decimal
	private BigDecimal sl_ndef6;//		decimal
	private BigDecimal sl_ndef7;//		decimal
	private BigDecimal sl_ndef8;//		decimal
	private BigDecimal sl_ndef9;//		decimal
	private BigDecimal sl_ndef10;//		decimal
	private BigDecimal sl_ndef11;//		decimal
	public String getSl_sid() {
		return sl_sid;
	}
	public void setSl_sid(String sl_sid) {
		this.sl_sid = sl_sid;
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
	public String getSl_stype() {
		return sl_stype;
	}
	public void setSl_stype(String sl_stype) {
		this.sl_stype = sl_stype;
	}
	public String getSl_sclass() {
		return sl_sclass;
	}
	public void setSl_sclass(String sl_sclass) {
		this.sl_sclass = sl_sclass;
	}
	public String getSl_snumber() {
		return sl_snumber;
	}
	public void setSl_snumber(String sl_snumber) {
		this.sl_snumber = sl_snumber;
	}
	public String getSl_sname() {
		return sl_sname;
	}
	public void setSl_sname(String sl_sname) {
		this.sl_sname = sl_sname;
	}
	public String getSl_spin() {
		return sl_spin;
	}
	public void setSl_spin(String sl_spin) {
		this.sl_spin = sl_spin;
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
	public String getSl_sjobtitleno() {
		return sl_sjobtitleno;
	}
	public void setSl_sjobtitleno(String sl_sjobtitleno) {
		this.sl_sjobtitleno = sl_sjobtitleno;
	}
	public String getSl_sgetjobaddr() {
		return sl_sgetjobaddr;
	}
	public void setSl_sgetjobaddr(String sl_sgetjobaddr) {
		this.sl_sgetjobaddr = sl_sgetjobaddr;
	}
	public String getSl_smajor() {
		return sl_smajor;
	}
	public void setSl_smajor(String sl_smajor) {
		this.sl_smajor = sl_smajor;
	}
	public String getSl_stele() {
		return sl_stele;
	}
	public void setSl_stele(String sl_stele) {
		this.sl_stele = sl_stele;
	}
	public String getSl_semail() {
		return sl_semail;
	}
	public void setSl_semail(String sl_semail) {
		this.sl_semail = sl_semail;
	}
	public String getSl_slevel() {
		return sl_slevel;
	}
	public void setSl_slevel(String sl_slevel) {
		this.sl_slevel = sl_slevel;
	}
	public String getSl_sisget() {
		return sl_sisget;
	}
	public void setSl_sisget(String sl_sisget) {
		this.sl_sisget = sl_sisget;
	}
	public String getSl_sisgetbyreason() {
		return sl_sisgetbyreason;
	}
	public void setSl_sisgetbyreason(String sl_sisgetbyreason) {
		this.sl_sisgetbyreason = sl_sisgetbyreason;
	}
	public String getSl_sisdel() {
		return sl_sisdel;
	}
	public void setSl_sisdel(String sl_sisdel) {
		this.sl_sisdel = sl_sisdel;
	}
	public String getSl_sisvalid() {
		return sl_sisvalid;
	}
	public void setSl_sisvalid(String sl_sisvalid) {
		this.sl_sisvalid = sl_sisvalid;
	}
	public String getSl_sreplyby() {
		return sl_sreplyby;
	}
	public void setSl_sreplyby(String sl_sreplyby) {
		this.sl_sreplyby = sl_sreplyby;
	}
	public Date getSl_sreplydate() {
		return sl_sreplydate;
	}
	public void setSl_sreplydate(Date sl_sreplydate) {
		this.sl_sreplydate = sl_sreplydate;
	}
	public String getSl_salterby() {
		return sl_salterby;
	}
	public void setSl_salterby(String sl_salterby) {
		this.sl_salterby = sl_salterby;
	}
	public Date getSl_salterdate() {
		return sl_salterdate;
	}
	public void setSl_salterdate(Date sl_salterdate) {
		this.sl_salterdate = sl_salterdate;
	}
	public String getSl_sdef1() {
		return sl_sdef1;
	}
	public void setSl_sdef1(String sl_sdef1) {
		this.sl_sdef1 = sl_sdef1;
	}
	public String getSl_sdef2() {
		return sl_sdef2;
	}
	public void setSl_sdef2(String sl_sdef2) {
		this.sl_sdef2 = sl_sdef2;
	}
	public String getSl_sdef3() {
		return sl_sdef3;
	}
	public void setSl_sdef3(String sl_sdef3) {
		this.sl_sdef3 = sl_sdef3;
	}
	public String getSl_sdef4() {
		return sl_sdef4;
	}
	public void setSl_sdef4(String sl_sdef4) {
		this.sl_sdef4 = sl_sdef4;
	}
	public String getSl_sdef5() {
		return sl_sdef5;
	}
	public void setSl_sdef5(String sl_sdef5) {
		this.sl_sdef5 = sl_sdef5;
	}
	public String getSl_sdef6() {
		return sl_sdef6;
	}
	public void setSl_sdef6(String sl_sdef6) {
		this.sl_sdef6 = sl_sdef6;
	}
	public String getSl_sdef7() {
		return sl_sdef7;
	}
	public void setSl_sdef7(String sl_sdef7) {
		this.sl_sdef7 = sl_sdef7;
	}
	public String getSl_sdef8() {
		return sl_sdef8;
	}
	public void setSl_sdef8(String sl_sdef8) {
		this.sl_sdef8 = sl_sdef8;
	}
	public String getSl_sdef9() {
		return sl_sdef9;
	}
	public void setSl_sdef9(String sl_sdef9) {
		this.sl_sdef9 = sl_sdef9;
	}
	public String getSl_sdef10() {
		return sl_sdef10;
	}
	public void setSl_sdef10(String sl_sdef10) {
		this.sl_sdef10 = sl_sdef10;
	}
	public String getSl_sdef11() {
		return sl_sdef11;
	}
	public void setSl_sdef11(String sl_sdef11) {
		this.sl_sdef11 = sl_sdef11;
	}
	public String getSl_sdef12() {
		return sl_sdef12;
	}
	public void setSl_sdef12(String sl_sdef12) {
		this.sl_sdef12 = sl_sdef12;
	}
	public String getSl_sdef13() {
		return sl_sdef13;
	}
	public void setSl_sdef13(String sl_sdef13) {
		this.sl_sdef13 = sl_sdef13;
	}
	public String getSl_sdef14() {
		return sl_sdef14;
	}
	public void setSl_sdef14(String sl_sdef14) {
		this.sl_sdef14 = sl_sdef14;
	}
	public String getSl_sdef15() {
		return sl_sdef15;
	}
	public void setSl_sdef15(String sl_sdef15) {
		this.sl_sdef15 = sl_sdef15;
	}
	public Date getSl_sdef16() {
		return sl_sdef16;
	}
	public void setSl_sdef16(Date sl_sdef16) {
		this.sl_sdef16 = sl_sdef16;
	}
	public Date getSl_sdef17() {
		return sl_sdef17;
	}
	public void setSl_sdef17(Date sl_sdef17) {
		this.sl_sdef17 = sl_sdef17;
	}
	public Date getSl_sdef18() {
		return sl_sdef18;
	}
	public void setSl_sdef18(Date sl_sdef18) {
		this.sl_sdef18 = sl_sdef18;
	}
	public Date getSl_sdef19() {
		return sl_sdef19;
	}
	public void setSl_sdef19(Date sl_sdef19) {
		this.sl_sdef19 = sl_sdef19;
	}
	public Date getSl_sdef20() {
		return sl_sdef20;
	}
	public void setSl_sdef20(Date sl_sdef20) {
		this.sl_sdef20 = sl_sdef20;
	}
	public BigDecimal getSl_ndef1() {
		return sl_ndef1;
	}
	public void setSl_ndef1(BigDecimal sl_ndef1) {
		this.sl_ndef1 = sl_ndef1;
	}
	public BigDecimal getSl_ndef2() {
		return sl_ndef2;
	}
	public void setSl_ndef2(BigDecimal sl_ndef2) {
		this.sl_ndef2 = sl_ndef2;
	}
	public BigDecimal getSl_ndef3() {
		return sl_ndef3;
	}
	public void setSl_ndef3(BigDecimal sl_ndef3) {
		this.sl_ndef3 = sl_ndef3;
	}
	public BigDecimal getSl_ndef4() {
		return sl_ndef4;
	}
	public void setSl_ndef4(BigDecimal sl_ndef4) {
		this.sl_ndef4 = sl_ndef4;
	}
	public BigDecimal getSl_ndef5() {
		return sl_ndef5;
	}
	public void setSl_ndef5(BigDecimal sl_ndef5) {
		this.sl_ndef5 = sl_ndef5;
	}
	public BigDecimal getSl_ndef6() {
		return sl_ndef6;
	}
	public void setSl_ndef6(BigDecimal sl_ndef6) {
		this.sl_ndef6 = sl_ndef6;
	}
	public BigDecimal getSl_ndef7() {
		return sl_ndef7;
	}
	public void setSl_ndef7(BigDecimal sl_ndef7) {
		this.sl_ndef7 = sl_ndef7;
	}
	public BigDecimal getSl_ndef8() {
		return sl_ndef8;
	}
	public void setSl_ndef8(BigDecimal sl_ndef8) {
		this.sl_ndef8 = sl_ndef8;
	}
	public BigDecimal getSl_ndef9() {
		return sl_ndef9;
	}
	public void setSl_ndef9(BigDecimal sl_ndef9) {
		this.sl_ndef9 = sl_ndef9;
	}
	public BigDecimal getSl_ndef10() {
		return sl_ndef10;
	}
	public void setSl_ndef10(BigDecimal sl_ndef10) {
		this.sl_ndef10 = sl_ndef10;
	}
	public BigDecimal getSl_ndef11() {
		return sl_ndef11;
	}
	public void setSl_ndef11(BigDecimal sl_ndef11) {
		this.sl_ndef11 = sl_ndef11;
	}


}
