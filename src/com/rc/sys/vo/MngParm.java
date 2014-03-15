package com.rc.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class MngParm {
	private Long parm_nid;//参数id，自增序列
	private String sysint_sno;//系统编号:如果为公共类型则为空;否则必选
	private String parm_stype;//参数类型0公共类型（表示所有系统公用)、1系统类型(各自系统）
	private String parm_sname;//访问名称(英文名)：参数名称（访问用） 唯一
	private String parm_sdisname;//显示名称：参数名称（显示用）。默认为访问名称。
	private String parm_svalue;//参数值:当前参数的值
	private String parm_sdesc;//描述
	private String sysint_sname;
	private String parm_sisdel;//是否删除：0。未删；1。删除
	private String parm_sisvalid;//是否有效：0-有效；1-无效
	private String parm_sdef1;
	private String parm_sdef2;
	private String parm_sdef3;
	private String parm_sdef4;
	private String parm_sdef5;
	private String parm_sdef6;
	private String parm_sdef7;
	private String parm_sdef8;
	private String parm_sdef9;
	private String parm_sdef10;
	private String parm_sdef11;
	private String parm_sdef12;
	private String parm_sdef13;
	private String parm_sdef14;
	private String parm_sdef15;
	private String parm_sdef16;
	private String parm_sdef17;
	private String parm_sdef18;
	private String parm_sdef19;
	private String parm_sdef20;
	private Date parm_ddef1;
	private Date parm_ddef2;
	private Date parm_ddef3;
	private Date parm_ddef4;
	private Date parm_ddef5;
	private Date parm_ddef6;
	private Date parm_ddef7;
	private Date parm_ddef8;
	private Date parm_ddef9;
	private Date parm_ddef10;
	private BigDecimal parm_ndef1;
	private BigDecimal parm_ndef2;
	private BigDecimal parm_ndef3;
	private BigDecimal parm_ndef4;
	private BigDecimal parm_ndef5;
	private BigDecimal parm_ndef6;
	private BigDecimal parm_ndef7;
	private BigDecimal parm_ndef8;
	private BigDecimal parm_ndef9;
	private BigDecimal parm_ndef10;
	
	public String getSysint_sname() {
		return sysint_sname;
	}
	public void setSysint_sname(String sysint_sname) {
		this.sysint_sname = sysint_sname;
	}
	public Long getParm_nid() {
		return parm_nid;
	}
	public void setParm_nid(Long parm_nid) {
		this.parm_nid = parm_nid;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getParm_stype() {
		return parm_stype;
	}
	public void setParm_stype(String parm_stype) {
		this.parm_stype = parm_stype;
	}
	public String getParm_sname() {
		return parm_sname;
	}
	public void setParm_sname(String parm_sname) {
		this.parm_sname = parm_sname;
	}
	public String getParm_sdisname() {
		return parm_sdisname;
	}
	public void setParm_sdisname(String parm_sdisname) {
		this.parm_sdisname = parm_sdisname;
	}
	public String getParm_svalue() {
		return parm_svalue;
	}
	public void setParm_svalue(String parm_svalue) {
		this.parm_svalue = parm_svalue;
	}
	public String getParm_sdesc() {
		return parm_sdesc;
	}
	public void setParm_sdesc(String parm_sdesc) {
		this.parm_sdesc = parm_sdesc;
	}
	public String getParm_sisdel() {
		return parm_sisdel;
	}
	public void setParm_sisdel(String parm_sisdel) {
		this.parm_sisdel = parm_sisdel;
	}
	public String getParm_sisvalid() {
		return parm_sisvalid;
	}
	public void setParm_sisvalid(String parm_sisvalid) {
		this.parm_sisvalid = parm_sisvalid;
	}
	public String getParm_sdef1() {
		return parm_sdef1;
	}
	public void setParm_sdef1(String parm_sdef1) {
		this.parm_sdef1 = parm_sdef1;
	}
	public String getParm_sdef2() {
		return parm_sdef2;
	}
	public void setParm_sdef2(String parm_sdef2) {
		this.parm_sdef2 = parm_sdef2;
	}
	public String getParm_sdef3() {
		return parm_sdef3;
	}
	public void setParm_sdef3(String parm_sdef3) {
		this.parm_sdef3 = parm_sdef3;
	}
	public String getParm_sdef4() {
		return parm_sdef4;
	}
	public void setParm_sdef4(String parm_sdef4) {
		this.parm_sdef4 = parm_sdef4;
	}
	public String getParm_sdef5() {
		return parm_sdef5;
	}
	public void setParm_sdef5(String parm_sdef5) {
		this.parm_sdef5 = parm_sdef5;
	}
	public String getParm_sdef6() {
		return parm_sdef6;
	}
	public void setParm_sdef6(String parm_sdef6) {
		this.parm_sdef6 = parm_sdef6;
	}
	public String getParm_sdef7() {
		return parm_sdef7;
	}
	public void setParm_sdef7(String parm_sdef7) {
		this.parm_sdef7 = parm_sdef7;
	}
	public String getParm_sdef8() {
		return parm_sdef8;
	}
	public void setParm_sdef8(String parm_sdef8) {
		this.parm_sdef8 = parm_sdef8;
	}
	public String getParm_sdef9() {
		return parm_sdef9;
	}
	public void setParm_sdef9(String parm_sdef9) {
		this.parm_sdef9 = parm_sdef9;
	}
	public String getParm_sdef10() {
		return parm_sdef10;
	}
	public void setParm_sdef10(String parm_sdef10) {
		this.parm_sdef10 = parm_sdef10;
	}
	public String getParm_sdef11() {
		return parm_sdef11;
	}
	public void setParm_sdef11(String parm_sdef11) {
		this.parm_sdef11 = parm_sdef11;
	}
	public String getParm_sdef12() {
		return parm_sdef12;
	}
	public void setParm_sdef12(String parm_sdef12) {
		this.parm_sdef12 = parm_sdef12;
	}
	public String getParm_sdef13() {
		return parm_sdef13;
	}
	public void setParm_sdef13(String parm_sdef13) {
		this.parm_sdef13 = parm_sdef13;
	}
	public String getParm_sdef14() {
		return parm_sdef14;
	}
	public void setParm_sdef14(String parm_sdef14) {
		this.parm_sdef14 = parm_sdef14;
	}
	public String getParm_sdef15() {
		return parm_sdef15;
	}
	public void setParm_sdef15(String parm_sdef15) {
		this.parm_sdef15 = parm_sdef15;
	}
	public String getParm_sdef16() {
		return parm_sdef16;
	}
	public void setParm_sdef16(String parm_sdef16) {
		this.parm_sdef16 = parm_sdef16;
	}
	public String getParm_sdef17() {
		return parm_sdef17;
	}
	public void setParm_sdef17(String parm_sdef17) {
		this.parm_sdef17 = parm_sdef17;
	}
	public String getParm_sdef18() {
		return parm_sdef18;
	}
	public void setParm_sdef18(String parm_sdef18) {
		this.parm_sdef18 = parm_sdef18;
	}
	public String getParm_sdef19() {
		return parm_sdef19;
	}
	public void setParm_sdef19(String parm_sdef19) {
		this.parm_sdef19 = parm_sdef19;
	}
	public String getParm_sdef20() {
		return parm_sdef20;
	}
	public void setParm_sdef20(String parm_sdef20) {
		this.parm_sdef20 = parm_sdef20;
	}
	public Date getParm_ddef1() {
		return parm_ddef1;
	}
	public void setParm_ddef1(Date parm_ddef1) {
		this.parm_ddef1 = parm_ddef1;
	}
	public Date getParm_ddef2() {
		return parm_ddef2;
	}
	public void setParm_ddef2(Date parm_ddef2) {
		this.parm_ddef2 = parm_ddef2;
	}
	public Date getParm_ddef3() {
		return parm_ddef3;
	}
	public void setParm_ddef3(Date parm_ddef3) {
		this.parm_ddef3 = parm_ddef3;
	}
	public Date getParm_ddef4() {
		return parm_ddef4;
	}
	public void setParm_ddef4(Date parm_ddef4) {
		this.parm_ddef4 = parm_ddef4;
	}
	public Date getParm_ddef5() {
		return parm_ddef5;
	}
	public void setParm_ddef5(Date parm_ddef5) {
		this.parm_ddef5 = parm_ddef5;
	}
	public Date getParm_ddef6() {
		return parm_ddef6;
	}
	public void setParm_ddef6(Date parm_ddef6) {
		this.parm_ddef6 = parm_ddef6;
	}
	public Date getParm_ddef7() {
		return parm_ddef7;
	}
	public void setParm_ddef7(Date parm_ddef7) {
		this.parm_ddef7 = parm_ddef7;
	}
	public Date getParm_ddef8() {
		return parm_ddef8;
	}
	public void setParm_ddef8(Date parm_ddef8) {
		this.parm_ddef8 = parm_ddef8;
	}
	public Date getParm_ddef9() {
		return parm_ddef9;
	}
	public void setParm_ddef9(Date parm_ddef9) {
		this.parm_ddef9 = parm_ddef9;
	}
	public Date getParm_ddef10() {
		return parm_ddef10;
	}
	public void setParm_ddef10(Date parm_ddef10) {
		this.parm_ddef10 = parm_ddef10;
	}
	public BigDecimal getParm_ndef1() {
		return parm_ndef1;
	}
	public void setParm_ndef1(BigDecimal parm_ndef1) {
		this.parm_ndef1 = parm_ndef1;
	}
	public BigDecimal getParm_ndef2() {
		return parm_ndef2;
	}
	public void setParm_ndef2(BigDecimal parm_ndef2) {
		this.parm_ndef2 = parm_ndef2;
	}
	public BigDecimal getParm_ndef3() {
		return parm_ndef3;
	}
	public void setParm_ndef3(BigDecimal parm_ndef3) {
		this.parm_ndef3 = parm_ndef3;
	}
	public BigDecimal getParm_ndef4() {
		return parm_ndef4;
	}
	public void setParm_ndef4(BigDecimal parm_ndef4) {
		this.parm_ndef4 = parm_ndef4;
	}
	public BigDecimal getParm_ndef5() {
		return parm_ndef5;
	}
	public void setParm_ndef5(BigDecimal parm_ndef5) {
		this.parm_ndef5 = parm_ndef5;
	}
	public BigDecimal getParm_ndef6() {
		return parm_ndef6;
	}
	public void setParm_ndef6(BigDecimal parm_ndef6) {
		this.parm_ndef6 = parm_ndef6;
	}
	public BigDecimal getParm_ndef7() {
		return parm_ndef7;
	}
	public void setParm_ndef7(BigDecimal parm_ndef7) {
		this.parm_ndef7 = parm_ndef7;
	}
	public BigDecimal getParm_ndef8() {
		return parm_ndef8;
	}
	public void setParm_ndef8(BigDecimal parm_ndef8) {
		this.parm_ndef8 = parm_ndef8;
	}
	public BigDecimal getParm_ndef9() {
		return parm_ndef9;
	}
	public void setParm_ndef9(BigDecimal parm_ndef9) {
		this.parm_ndef9 = parm_ndef9;
	}
	public BigDecimal getParm_ndef10() {
		return parm_ndef10;
	}
	public void setParm_ndef10(BigDecimal parm_ndef10) {
		this.parm_ndef10 = parm_ndef10;
	}
	
}
