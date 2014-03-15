package com.rc.sys.form;

import java.math.BigDecimal;

public class MngRightForm {
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String searchA;//查询条件A
	private String searchB;//查询条件B
	private String searchC;//查询条件C
	private String searchD;//查询条件D
	private String searchE;//查询条件E
	private String right_sno;//功能编号:权限代码，2位，4位，6位（序列码）
	private String userid;//用户编号
	private String sysint_sno;//系统编号
	private String sysint_sname;//系统名称
	private String right_sparentno;//所属模块，上级的功能编号
	private String right_sparentname;//所属模块，上级的功能名称
	private String right_sname;//功能名称
	private String right_sdesc;//功能描述:模块或权限描述
	private String right_sisend;// 是否末级:0,末级 1,非末级
	private String right_smenuurl;//功能地址：末级菜单对应的url
	private Long right_nmenulength;//菜单长度
	private String right_sisuse;//是否可用：0可用 ,1不可用
	private Long right_nmorb;//菜单/功能按钮：0：菜单  1：功能
	private String right_simg;//图标地址
	private Long right_norder;//排序顺序
	private String right_sischild;//是否子菜单：0子；1父
	private String right_sfather;//父菜单编号
	private String right_sposition;//弹出位置
	private String right_sisdel;//是否删除：0-未删；1-删除
	private String right_sisvalid;//是否有效：0-是；1-否
	private String right_sreplyby;//创建人
	private String right_dreplydate;//创建时间
	private String right_salterby;//修改人
	private String right_dalterdate;//修改时间
//	private String right_nnum;//功能级别
	private String right_sdef1;			
	private String right_sdef2;	
	private String right_sdef3;
	private String right_sdef4;
	private String right_sdef5;
	private String right_sdef6;
	private String right_sdef7;
	private String right_sdef8;
	private String right_sdef9;
	private String right_sdef10;
	private String right_sdef11;
	private String right_sdef12;
	private String right_sdef13;
	private String right_sdef14;
	private String right_sdef15;
	private String right_sdef16;
	private String right_sdef17;
	private String right_sdef18;
	private String right_sdef19;
	private String right_sdef20;
	private String right_ddef1;
	private String right_ddef2;
	private String right_ddef3;
	private String right_ddef4;
	private String right_ddef5;
	private String right_ddef6;
	private String right_ddef7;
	private String right_ddef8;
	private String right_ddef9;
	private String right_ddef10;
	private BigDecimal right_ndef1;//功能级别
	private BigDecimal right_ndef2;
	private BigDecimal right_ndef3;
	private BigDecimal right_ndef4;
	private BigDecimal right_ndef5;
	private BigDecimal right_ndef6;
	private BigDecimal right_ndef7;
	private BigDecimal right_ndef8;
	private BigDecimal right_ndef9;
	private BigDecimal right_ndef10;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getRight_sno() {
		return right_sno;
	}
	public void setRight_sno(String right_sno) {
		this.right_sno = right_sno;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getSysint_sname() {
		return sysint_sname;
	}
	public void setSysint_sname(String sysint_sname) {
		this.sysint_sname = sysint_sname;
	}
	public String getRight_sparentno() {
		return right_sparentno;
	}
	public void setRight_sparentno(String right_sparentno) {
		this.right_sparentno = right_sparentno;
	}
	public String getRight_sparentname() {
		return right_sparentname;
	}
	public void setRight_sparentname(String right_sparentname) {
		this.right_sparentname = right_sparentname;
	}
	public String getRight_sname() {
		return right_sname;
	}
	public void setRight_sname(String right_sname) {
		this.right_sname = right_sname;
	}
	public String getRight_sdesc() {
		return right_sdesc;
	}
	public void setRight_sdesc(String right_sdesc) {
		this.right_sdesc = right_sdesc;
	}
	public String getRight_sisend() {
		return right_sisend;
	}
	public void setRight_sisend(String right_sisend) {
		this.right_sisend = right_sisend;
	}
	public String getRight_smenuurl() {
		return right_smenuurl;
	}
	public void setRight_smenuurl(String right_smenuurl) {
		this.right_smenuurl = right_smenuurl;
	}
	public Long getRight_nmenulength() {
		return right_nmenulength;
	}
	public void setRight_nmenulength(Long right_nmenulength) {
		this.right_nmenulength = right_nmenulength;
	}
	public String getRight_sisuse() {
		return right_sisuse;
	}
	public void setRight_sisuse(String right_sisuse) {
		this.right_sisuse = right_sisuse;
	}
	public Long getRight_nmorb() {
		return right_nmorb;
	}
	public void setRight_nmorb(Long right_nmorb) {
		this.right_nmorb = right_nmorb;
	}
	public String getRight_simg() {
		return right_simg;
	}
	public void setRight_simg(String right_simg) {
		this.right_simg = right_simg;
	}
	public Long getRight_norder() {
		return right_norder;
	}
	public void setRight_norder(Long right_norder) {
		this.right_norder = right_norder;
	}
	public String getRight_sischild() {
		return right_sischild;
	}
	public void setRight_sischild(String right_sischild) {
		this.right_sischild = right_sischild;
	}
	public String getRight_sfather() {
		return right_sfather;
	}
	public void setRight_sfather(String right_sfather) {
		this.right_sfather = right_sfather;
	}
	public String getRight_sposition() {
		return right_sposition;
	}
	public void setRight_sposition(String right_sposition) {
		this.right_sposition = right_sposition;
	}
	public String getRight_sisdel() {
		return right_sisdel;
	}
	public void setRight_sisdel(String right_sisdel) {
		this.right_sisdel = right_sisdel;
	}
	public String getRight_sisvalid() {
		return right_sisvalid;
	}
	public void setRight_sisvalid(String right_sisvalid) {
		this.right_sisvalid = right_sisvalid;
	}
	public String getRight_sreplyby() {
		return right_sreplyby;
	}
	public void setRight_sreplyby(String right_sreplyby) {
		this.right_sreplyby = right_sreplyby;
	}
	public String getRight_dreplydate() {
		return right_dreplydate;
	}
	public void setRight_dreplydate(String right_dreplydate) {
		this.right_dreplydate = right_dreplydate;
	}
	public String getRight_salterby() {
		return right_salterby;
	}
	public void setRight_salterby(String right_salterby) {
		this.right_salterby = right_salterby;
	}
	public String getRight_dalterdate() {
		return right_dalterdate;
	}
	public void setRight_dalterdate(String right_dalterdate) {
		this.right_dalterdate = right_dalterdate;
	}
	public String getRight_sdef1() {
		return right_sdef1;
	}
	public void setRight_sdef1(String right_sdef1) {
		this.right_sdef1 = right_sdef1;
	}
	public String getRight_sdef2() {
		return right_sdef2;
	}
	public void setRight_sdef2(String right_sdef2) {
		this.right_sdef2 = right_sdef2;
	}
	public String getRight_sdef3() {
		return right_sdef3;
	}
	public void setRight_sdef3(String right_sdef3) {
		this.right_sdef3 = right_sdef3;
	}
	public String getRight_sdef4() {
		return right_sdef4;
	}
	public void setRight_sdef4(String right_sdef4) {
		this.right_sdef4 = right_sdef4;
	}
	public String getRight_sdef5() {
		return right_sdef5;
	}
	public void setRight_sdef5(String right_sdef5) {
		this.right_sdef5 = right_sdef5;
	}
	public String getRight_sdef6() {
		return right_sdef6;
	}
	public void setRight_sdef6(String right_sdef6) {
		this.right_sdef6 = right_sdef6;
	}
	public String getRight_sdef7() {
		return right_sdef7;
	}
	public void setRight_sdef7(String right_sdef7) {
		this.right_sdef7 = right_sdef7;
	}
	public String getRight_sdef8() {
		return right_sdef8;
	}
	public void setRight_sdef8(String right_sdef8) {
		this.right_sdef8 = right_sdef8;
	}
	public String getRight_sdef9() {
		return right_sdef9;
	}
	public void setRight_sdef9(String right_sdef9) {
		this.right_sdef9 = right_sdef9;
	}
	public String getRight_sdef10() {
		return right_sdef10;
	}
	public void setRight_sdef10(String right_sdef10) {
		this.right_sdef10 = right_sdef10;
	}
	public String getRight_sdef11() {
		return right_sdef11;
	}
	public void setRight_sdef11(String right_sdef11) {
		this.right_sdef11 = right_sdef11;
	}
	public String getRight_sdef12() {
		return right_sdef12;
	}
	public void setRight_sdef12(String right_sdef12) {
		this.right_sdef12 = right_sdef12;
	}
	public String getRight_sdef13() {
		return right_sdef13;
	}
	public void setRight_sdef13(String right_sdef13) {
		this.right_sdef13 = right_sdef13;
	}
	public String getRight_sdef14() {
		return right_sdef14;
	}
	public void setRight_sdef14(String right_sdef14) {
		this.right_sdef14 = right_sdef14;
	}
	public String getRight_sdef15() {
		return right_sdef15;
	}
	public void setRight_sdef15(String right_sdef15) {
		this.right_sdef15 = right_sdef15;
	}
	public String getRight_sdef16() {
		return right_sdef16;
	}
	public void setRight_sdef16(String right_sdef16) {
		this.right_sdef16 = right_sdef16;
	}
	public String getRight_sdef17() {
		return right_sdef17;
	}
	public void setRight_sdef17(String right_sdef17) {
		this.right_sdef17 = right_sdef17;
	}
	public String getRight_sdef18() {
		return right_sdef18;
	}
	public void setRight_sdef18(String right_sdef18) {
		this.right_sdef18 = right_sdef18;
	}
	public String getRight_sdef19() {
		return right_sdef19;
	}
	public void setRight_sdef19(String right_sdef19) {
		this.right_sdef19 = right_sdef19;
	}
	public String getRight_sdef20() {
		return right_sdef20;
	}
	public void setRight_sdef20(String right_sdef20) {
		this.right_sdef20 = right_sdef20;
	}
	public String getRight_ddef1() {
		return right_ddef1;
	}
	public void setRight_ddef1(String right_ddef1) {
		this.right_ddef1 = right_ddef1;
	}
	public String getRight_ddef2() {
		return right_ddef2;
	}
	public void setRight_ddef2(String right_ddef2) {
		this.right_ddef2 = right_ddef2;
	}
	public String getRight_ddef3() {
		return right_ddef3;
	}
	public void setRight_ddef3(String right_ddef3) {
		this.right_ddef3 = right_ddef3;
	}
	public String getRight_ddef4() {
		return right_ddef4;
	}
	public void setRight_ddef4(String right_ddef4) {
		this.right_ddef4 = right_ddef4;
	}
	public String getRight_ddef5() {
		return right_ddef5;
	}
	public void setRight_ddef5(String right_ddef5) {
		this.right_ddef5 = right_ddef5;
	}
	public String getRight_ddef6() {
		return right_ddef6;
	}
	public void setRight_ddef6(String right_ddef6) {
		this.right_ddef6 = right_ddef6;
	}
	public String getRight_ddef7() {
		return right_ddef7;
	}
	public void setRight_ddef7(String right_ddef7) {
		this.right_ddef7 = right_ddef7;
	}
	public String getRight_ddef8() {
		return right_ddef8;
	}
	public void setRight_ddef8(String right_ddef8) {
		this.right_ddef8 = right_ddef8;
	}
	public String getRight_ddef9() {
		return right_ddef9;
	}
	public void setRight_ddef9(String right_ddef9) {
		this.right_ddef9 = right_ddef9;
	}
	public String getRight_ddef10() {
		return right_ddef10;
	}
	public void setRight_ddef10(String right_ddef10) {
		this.right_ddef10 = right_ddef10;
	}
	public BigDecimal getRight_ndef1() {
		return right_ndef1;
	}
	public void setRight_ndef1(BigDecimal right_ndef1) {
		this.right_ndef1 = right_ndef1;
	}
	public BigDecimal getRight_ndef2() {
		return right_ndef2;
	}
	public void setRight_ndef2(BigDecimal right_ndef2) {
		this.right_ndef2 = right_ndef2;
	}
	public BigDecimal getRight_ndef3() {
		return right_ndef3;
	}
	public void setRight_ndef3(BigDecimal right_ndef3) {
		this.right_ndef3 = right_ndef3;
	}
	public BigDecimal getRight_ndef4() {
		return right_ndef4;
	}
	public void setRight_ndef4(BigDecimal right_ndef4) {
		this.right_ndef4 = right_ndef4;
	}
	public BigDecimal getRight_ndef5() {
		return right_ndef5;
	}
	public void setRight_ndef5(BigDecimal right_ndef5) {
		this.right_ndef5 = right_ndef5;
	}
	public BigDecimal getRight_ndef6() {
		return right_ndef6;
	}
	public void setRight_ndef6(BigDecimal right_ndef6) {
		this.right_ndef6 = right_ndef6;
	}
	public BigDecimal getRight_ndef7() {
		return right_ndef7;
	}
	public void setRight_ndef7(BigDecimal right_ndef7) {
		this.right_ndef7 = right_ndef7;
	}
	public BigDecimal getRight_ndef8() {
		return right_ndef8;
	}
	public void setRight_ndef8(BigDecimal right_ndef8) {
		this.right_ndef8 = right_ndef8;
	}
	public BigDecimal getRight_ndef9() {
		return right_ndef9;
	}
	public void setRight_ndef9(BigDecimal right_ndef9) {
		this.right_ndef9 = right_ndef9;
	}
	public BigDecimal getRight_ndef10() {
		return right_ndef10;
	}
	public void setRight_ndef10(BigDecimal right_ndef10) {
		this.right_ndef10 = right_ndef10;
	}
	
	
}
