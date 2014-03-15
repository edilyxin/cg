package com.rc.sys.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MngDboper {
	private String dboper_sno;//数据权限编号
	private String sysint_sno;//系统编号
	private String right_sno;//功能编号:只能对应的是查询与统计及分析功能
	private String tbl_scode;//数据表代码
	private String dboper_sname;//数据权限名称
	private String dboper_stype;//数据范围:0全局数据、1多部门数据、2本部门数据、3按指定数据来源、4个人数据
	private String dboper_svalue;//列表值：为多部门时，可以定义其对应哪些部门，用"&"隔开
	private String dboper_svaluename;//列表名：如:对应dboper_svalue部门编号对应的部门名称
	private String dboper_sisuse;//是否可用：0.可用 ,1.不可用
	private String dboper_sisdel;//是否删除：0。未删；1。删除
	private String dboper_sisvalid;//是否有效：0-有效；1-无效
	private String dboper_sreplyby;//创建人
	private Date dboper_dreplydate;//创建时间
	private String dboper_salterby;//修改人
	private Date dboper_dalterdate;//修改时间
	private String right_sname;//功能名称
	private String sysint_sname;//系统名称
	private String dboper_sdef1;
	private String dboper_sdef2;
	private String dboper_sdef3;
	private String dboper_sdef4;
	private String dboper_sdef5;
	private String dboper_sdef6;
	private String dboper_sdef7;
	private String dboper_sdef8;
	private String dboper_sdef9;
	private String dboper_sdef10;
	private String dboper_sdef11;
	private String dboper_sdef12;
	private String dboper_sdef13;
	private String dboper_sdef14;
	private String dboper_sdef15;
	private String dboper_sdef16;
	private String dboper_sdef17;
	private String dboper_sdef18;
	private String dboper_sdef19;
	private String dboper_sdef20;
	private Date dboper_ddef1;
	private Date dboper_ddef2;
	private Date dboper_ddef3;
	private Date dboper_ddef4;
	private Date dboper_ddef5;
	private Date dboper_ddef6;
	private Date dboper_ddef7;
	private Date dboper_ddef8;
	private Date dboper_ddef9;
	private Date dboper_ddef10;
	private BigDecimal dboper_ndef1;
	private BigDecimal dboper_ndef2;
	private BigDecimal dboper_ndef3;
	private BigDecimal dboper_ndef4;
	private BigDecimal dboper_ndef5;
	private BigDecimal dboper_ndef6;
	private BigDecimal dboper_ndef7;
	private BigDecimal dboper_ndef8;
	private BigDecimal dboper_ndef9;
	private BigDecimal dboper_ndef10;
	private List<MngDboper> list;
	
	public String toString() {
		return "功能"+":"+right_sno+"-"+right_sname+"权限："+dboper_sname+"--";
	}
	public String getDboper_sno() {
		return dboper_sno;
	}
	public void setDboper_sno(String dboper_sno) {
		this.dboper_sno = dboper_sno;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getRight_sno() {
		return right_sno;
	}
	public void setRight_sno(String right_sno) {
		this.right_sno = right_sno;
	}
	public String getTbl_scode() {
		return tbl_scode;
	}
	public void setTbl_scode(String tbl_scode) {
		this.tbl_scode = tbl_scode;
	}
	public String getDboper_sname() {
		return dboper_sname;
	}
	public void setDboper_sname(String dboper_sname) {
		this.dboper_sname = dboper_sname;
	}
	public String getDboper_stype() {
		return dboper_stype;
	}
	public void setDboper_stype(String dboper_stype) {
		this.dboper_stype = dboper_stype;
	}
	public String getDboper_svalue() {
		return dboper_svalue;
	}
	public void setDboper_svalue(String dboper_svalue) {
		this.dboper_svalue = dboper_svalue;
	}
	public String getDboper_svaluename() {
		return dboper_svaluename;
	}
	public void setDboper_svaluename(String dboper_svaluename) {
		this.dboper_svaluename = dboper_svaluename;
	}
	public String getDboper_sisuse() {
		return dboper_sisuse;
	}
	public void setDboper_sisuse(String dboper_sisuse) {
		this.dboper_sisuse = dboper_sisuse;
	}
	public String getDboper_sisdel() {
		return dboper_sisdel;
	}
	public void setDboper_sisdel(String dboper_sisdel) {
		this.dboper_sisdel = dboper_sisdel;
	}
	public String getDboper_sisvalid() {
		return dboper_sisvalid;
	}
	public void setDboper_sisvalid(String dboper_sisvalid) {
		this.dboper_sisvalid = dboper_sisvalid;
	}
	public String getDboper_sreplyby() {
		return dboper_sreplyby;
	}
	public void setDboper_sreplyby(String dboper_sreplyby) {
		this.dboper_sreplyby = dboper_sreplyby;
	}
	public Date getDboper_dreplydate() {
		return dboper_dreplydate;
	}
	public void setDboper_dreplydate(Date dboper_dreplydate) {
		this.dboper_dreplydate = dboper_dreplydate;
	}
	public String getDboper_salterby() {
		return dboper_salterby;
	}
	public void setDboper_salterby(String dboper_salterby) {
		this.dboper_salterby = dboper_salterby;
	}
	public Date getDboper_dalterdate() {
		return dboper_dalterdate;
	}
	public void setDboper_dalterdate(Date dboper_dalterdate) {
		this.dboper_dalterdate = dboper_dalterdate;
	}
	public String getRight_sname() {
		return right_sname;
	}
	public void setRight_sname(String right_sname) {
		this.right_sname = right_sname;
	}
	public String getSysint_sname() {
		return sysint_sname;
	}
	public void setSysint_sname(String sysint_sname) {
		this.sysint_sname = sysint_sname;
	}
	public String getDboper_sdef1() {
		return dboper_sdef1;
	}
	public void setDboper_sdef1(String dboper_sdef1) {
		this.dboper_sdef1 = dboper_sdef1;
	}
	public String getDboper_sdef2() {
		return dboper_sdef2;
	}
	public void setDboper_sdef2(String dboper_sdef2) {
		this.dboper_sdef2 = dboper_sdef2;
	}
	public String getDboper_sdef3() {
		return dboper_sdef3;
	}
	public void setDboper_sdef3(String dboper_sdef3) {
		this.dboper_sdef3 = dboper_sdef3;
	}
	public String getDboper_sdef4() {
		return dboper_sdef4;
	}
	public void setDboper_sdef4(String dboper_sdef4) {
		this.dboper_sdef4 = dboper_sdef4;
	}
	public String getDboper_sdef5() {
		return dboper_sdef5;
	}
	public void setDboper_sdef5(String dboper_sdef5) {
		this.dboper_sdef5 = dboper_sdef5;
	}
	public String getDboper_sdef6() {
		return dboper_sdef6;
	}
	public void setDboper_sdef6(String dboper_sdef6) {
		this.dboper_sdef6 = dboper_sdef6;
	}
	public String getDboper_sdef7() {
		return dboper_sdef7;
	}
	public void setDboper_sdef7(String dboper_sdef7) {
		this.dboper_sdef7 = dboper_sdef7;
	}
	public String getDboper_sdef8() {
		return dboper_sdef8;
	}
	public void setDboper_sdef8(String dboper_sdef8) {
		this.dboper_sdef8 = dboper_sdef8;
	}
	public String getDboper_sdef9() {
		return dboper_sdef9;
	}
	public void setDboper_sdef9(String dboper_sdef9) {
		this.dboper_sdef9 = dboper_sdef9;
	}
	public String getDboper_sdef10() {
		return dboper_sdef10;
	}
	public void setDboper_sdef10(String dboper_sdef10) {
		this.dboper_sdef10 = dboper_sdef10;
	}
	public String getDboper_sdef11() {
		return dboper_sdef11;
	}
	public void setDboper_sdef11(String dboper_sdef11) {
		this.dboper_sdef11 = dboper_sdef11;
	}
	public String getDboper_sdef12() {
		return dboper_sdef12;
	}
	public void setDboper_sdef12(String dboper_sdef12) {
		this.dboper_sdef12 = dboper_sdef12;
	}
	public String getDboper_sdef13() {
		return dboper_sdef13;
	}
	public void setDboper_sdef13(String dboper_sdef13) {
		this.dboper_sdef13 = dboper_sdef13;
	}
	public String getDboper_sdef14() {
		return dboper_sdef14;
	}
	public void setDboper_sdef14(String dboper_sdef14) {
		this.dboper_sdef14 = dboper_sdef14;
	}
	public String getDboper_sdef15() {
		return dboper_sdef15;
	}
	public void setDboper_sdef15(String dboper_sdef15) {
		this.dboper_sdef15 = dboper_sdef15;
	}
	public String getDboper_sdef16() {
		return dboper_sdef16;
	}
	public void setDboper_sdef16(String dboper_sdef16) {
		this.dboper_sdef16 = dboper_sdef16;
	}
	public String getDboper_sdef17() {
		return dboper_sdef17;
	}
	public void setDboper_sdef17(String dboper_sdef17) {
		this.dboper_sdef17 = dboper_sdef17;
	}
	public String getDboper_sdef18() {
		return dboper_sdef18;
	}
	public void setDboper_sdef18(String dboper_sdef18) {
		this.dboper_sdef18 = dboper_sdef18;
	}
	public String getDboper_sdef19() {
		return dboper_sdef19;
	}
	public void setDboper_sdef19(String dboper_sdef19) {
		this.dboper_sdef19 = dboper_sdef19;
	}
	public String getDboper_sdef20() {
		return dboper_sdef20;
	}
	public void setDboper_sdef20(String dboper_sdef20) {
		this.dboper_sdef20 = dboper_sdef20;
	}
	public Date getDboper_ddef1() {
		return dboper_ddef1;
	}
	public void setDboper_ddef1(Date dboper_ddef1) {
		this.dboper_ddef1 = dboper_ddef1;
	}
	public Date getDboper_ddef2() {
		return dboper_ddef2;
	}
	public void setDboper_ddef2(Date dboper_ddef2) {
		this.dboper_ddef2 = dboper_ddef2;
	}
	public Date getDboper_ddef3() {
		return dboper_ddef3;
	}
	public void setDboper_ddef3(Date dboper_ddef3) {
		this.dboper_ddef3 = dboper_ddef3;
	}
	public Date getDboper_ddef4() {
		return dboper_ddef4;
	}
	public void setDboper_ddef4(Date dboper_ddef4) {
		this.dboper_ddef4 = dboper_ddef4;
	}
	public Date getDboper_ddef5() {
		return dboper_ddef5;
	}
	public void setDboper_ddef5(Date dboper_ddef5) {
		this.dboper_ddef5 = dboper_ddef5;
	}
	public Date getDboper_ddef6() {
		return dboper_ddef6;
	}
	public void setDboper_ddef6(Date dboper_ddef6) {
		this.dboper_ddef6 = dboper_ddef6;
	}
	public Date getDboper_ddef7() {
		return dboper_ddef7;
	}
	public void setDboper_ddef7(Date dboper_ddef7) {
		this.dboper_ddef7 = dboper_ddef7;
	}
	public Date getDboper_ddef8() {
		return dboper_ddef8;
	}
	public void setDboper_ddef8(Date dboper_ddef8) {
		this.dboper_ddef8 = dboper_ddef8;
	}
	public Date getDboper_ddef9() {
		return dboper_ddef9;
	}
	public void setDboper_ddef9(Date dboper_ddef9) {
		this.dboper_ddef9 = dboper_ddef9;
	}
	public Date getDboper_ddef10() {
		return dboper_ddef10;
	}
	public void setDboper_ddef10(Date dboper_ddef10) {
		this.dboper_ddef10 = dboper_ddef10;
	}
	public BigDecimal getDboper_ndef1() {
		return dboper_ndef1;
	}
	public void setDboper_ndef1(BigDecimal dboper_ndef1) {
		this.dboper_ndef1 = dboper_ndef1;
	}
	public BigDecimal getDboper_ndef2() {
		return dboper_ndef2;
	}
	public void setDboper_ndef2(BigDecimal dboper_ndef2) {
		this.dboper_ndef2 = dboper_ndef2;
	}
	public BigDecimal getDboper_ndef3() {
		return dboper_ndef3;
	}
	public void setDboper_ndef3(BigDecimal dboper_ndef3) {
		this.dboper_ndef3 = dboper_ndef3;
	}
	public BigDecimal getDboper_ndef4() {
		return dboper_ndef4;
	}
	public void setDboper_ndef4(BigDecimal dboper_ndef4) {
		this.dboper_ndef4 = dboper_ndef4;
	}
	public BigDecimal getDboper_ndef5() {
		return dboper_ndef5;
	}
	public void setDboper_ndef5(BigDecimal dboper_ndef5) {
		this.dboper_ndef5 = dboper_ndef5;
	}
	public BigDecimal getDboper_ndef6() {
		return dboper_ndef6;
	}
	public void setDboper_ndef6(BigDecimal dboper_ndef6) {
		this.dboper_ndef6 = dboper_ndef6;
	}
	public BigDecimal getDboper_ndef7() {
		return dboper_ndef7;
	}
	public void setDboper_ndef7(BigDecimal dboper_ndef7) {
		this.dboper_ndef7 = dboper_ndef7;
	}
	public BigDecimal getDboper_ndef8() {
		return dboper_ndef8;
	}
	public void setDboper_ndef8(BigDecimal dboper_ndef8) {
		this.dboper_ndef8 = dboper_ndef8;
	}
	public BigDecimal getDboper_ndef9() {
		return dboper_ndef9;
	}
	public void setDboper_ndef9(BigDecimal dboper_ndef9) {
		this.dboper_ndef9 = dboper_ndef9;
	}
	public BigDecimal getDboper_ndef10() {
		return dboper_ndef10;
	}
	public void setDboper_ndef10(BigDecimal dboper_ndef10) {
		this.dboper_ndef10 = dboper_ndef10;
	}
	public List<MngDboper> getList() {
		return list;
	}
	public void setList(List<MngDboper> list) {
		this.list = list;
	}
	
}
