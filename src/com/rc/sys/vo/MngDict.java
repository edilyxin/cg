package com.rc.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class MngDict {
	private String dict_sno;//数据字典编号
	private String dict_sname;//数据字典访问名称,唯一
	private Long dict_ntype;//字典类型：0.用户类 1.系统类
	private String dict_sdesc;//数据字典类型描述
	private String dict_stype;//字典类别:(公共类无所属系统)0.公共类 1.系统类
	private String sysint_sno;//所属系统编号（公共类为空）
	private String sysint_sname;//所属系统名称
	private String dict_sisdel;//是否删除：0。未删；1。删除
	private String dict_sisvalid;//是否有效：0-有效；1-无效
	private String dict_sreplyby;//创建人
	private Date dict_dreplydate;//创建时间
	private String dict_salterby;//修改人
	private Date dict_dalterdate;//修改时间
	private String dict_sdef1;//描述
	private String dict_sdef2;
	private String dict_sdef3;
	private String dict_sdef4;
	private String dict_sdef5;
	private String dict_sdef6;
	private String dict_sdef7;
	private String dict_sdef8;
	private String dict_sdef9;
	private String dict_sdef10;
	private String dict_sdef11;
	private String dict_sdef12;
	private String dict_sdef13;
	private String dict_sdef14;
	private String dict_sdef15;
	private String dict_sdef16;
	private String dict_sdef17;
	private String dict_sdef18;
	private String dict_sdef19;
	private String dict_sdef20;
	private Date dict_ddef1;
	private Date dict_ddef2;
	private Date dict_ddef3;
	private Date dict_ddef4;
	private Date dict_ddef5;
	private Date dict_ddef6;
	private Date dict_ddef7;
	private Date dict_ddef8;
	private Date dict_ddef9;
	private Date dict_ddef10;
	private BigDecimal dict_ndef1;
	private BigDecimal dict_ndef2;
	private BigDecimal dict_ndef3;
	private BigDecimal dict_ndef4;
	private BigDecimal dict_ndef5;
	private BigDecimal dict_ndef6;
	private BigDecimal dict_ndef7;
	private BigDecimal dict_ndef8;
	private BigDecimal dict_ndef9;
	private BigDecimal dict_ndef10;
	
	public String getSysint_sname() {
		return sysint_sname;
	}
	public void setSysint_sname(String sysint_sname) {
		this.sysint_sname = sysint_sname;
	}
	public String getDict_sno() {
		return dict_sno;
	}
	public void setDict_sno(String dict_sno) {
		this.dict_sno = dict_sno;
	}
	public String getDict_sname() {
		return dict_sname;
	}
	public void setDict_sname(String dict_sname) {
		this.dict_sname = dict_sname;
	}
	public Long getDict_ntype() {
		return dict_ntype;
	}
	public void setDict_ntype(Long dict_ntype) {
		this.dict_ntype = dict_ntype;
	}
	public String getDict_sdesc() {
		return dict_sdesc;
	}
	public void setDict_sdesc(String dict_sdesc) {
		this.dict_sdesc = dict_sdesc;
	}
	public String getDict_stype() {
		return dict_stype;
	}
	public void setDict_stype(String dict_stype) {
		this.dict_stype = dict_stype;
	}
	public String getSysint_sno() {
		return sysint_sno;
	}
	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}
	public String getDict_sisdel() {
		return dict_sisdel;
	}
	public void setDict_sisdel(String dict_sisdel) {
		this.dict_sisdel = dict_sisdel;
	}
	public String getDict_sisvalid() {
		return dict_sisvalid;
	}
	public void setDict_sisvalid(String dict_sisvalid) {
		this.dict_sisvalid = dict_sisvalid;
	}
	public String getDict_sreplyby() {
		return dict_sreplyby;
	}
	public void setDict_sreplyby(String dict_sreplyby) {
		this.dict_sreplyby = dict_sreplyby;
	}
	public Date getDict_dreplydate() {
		return dict_dreplydate;
	}
	public void setDict_dreplydate(Date dict_dreplydate) {
		this.dict_dreplydate = dict_dreplydate;
	}
	public String getDict_salterby() {
		return dict_salterby;
	}
	public void setDict_salterby(String dict_salterby) {
		this.dict_salterby = dict_salterby;
	}
	public Date getDict_dalterdate() {
		return dict_dalterdate;
	}
	public void setDict_dalterdate(Date dict_dalterdate) {
		this.dict_dalterdate = dict_dalterdate;
	}
	public String getDict_sdef1() {
		return dict_sdef1;
	}
	public void setDict_sdef1(String dict_sdef1) {
		this.dict_sdef1 = dict_sdef1;
	}
	public String getDict_sdef2() {
		return dict_sdef2;
	}
	public void setDict_sdef2(String dict_sdef2) {
		this.dict_sdef2 = dict_sdef2;
	}
	public String getDict_sdef3() {
		return dict_sdef3;
	}
	public void setDict_sdef3(String dict_sdef3) {
		this.dict_sdef3 = dict_sdef3;
	}
	public String getDict_sdef4() {
		return dict_sdef4;
	}
	public void setDict_sdef4(String dict_sdef4) {
		this.dict_sdef4 = dict_sdef4;
	}
	public String getDict_sdef5() {
		return dict_sdef5;
	}
	public void setDict_sdef5(String dict_sdef5) {
		this.dict_sdef5 = dict_sdef5;
	}
	public String getDict_sdef6() {
		return dict_sdef6;
	}
	public void setDict_sdef6(String dict_sdef6) {
		this.dict_sdef6 = dict_sdef6;
	}
	public String getDict_sdef7() {
		return dict_sdef7;
	}
	public void setDict_sdef7(String dict_sdef7) {
		this.dict_sdef7 = dict_sdef7;
	}
	public String getDict_sdef8() {
		return dict_sdef8;
	}
	public void setDict_sdef8(String dict_sdef8) {
		this.dict_sdef8 = dict_sdef8;
	}
	public String getDict_sdef9() {
		return dict_sdef9;
	}
	public void setDict_sdef9(String dict_sdef9) {
		this.dict_sdef9 = dict_sdef9;
	}
	public String getDict_sdef10() {
		return dict_sdef10;
	}
	public void setDict_sdef10(String dict_sdef10) {
		this.dict_sdef10 = dict_sdef10;
	}
	public String getDict_sdef11() {
		return dict_sdef11;
	}
	public void setDict_sdef11(String dict_sdef11) {
		this.dict_sdef11 = dict_sdef11;
	}
	public String getDict_sdef12() {
		return dict_sdef12;
	}
	public void setDict_sdef12(String dict_sdef12) {
		this.dict_sdef12 = dict_sdef12;
	}
	public String getDict_sdef13() {
		return dict_sdef13;
	}
	public void setDict_sdef13(String dict_sdef13) {
		this.dict_sdef13 = dict_sdef13;
	}
	public String getDict_sdef14() {
		return dict_sdef14;
	}
	public void setDict_sdef14(String dict_sdef14) {
		this.dict_sdef14 = dict_sdef14;
	}
	public String getDict_sdef15() {
		return dict_sdef15;
	}
	public void setDict_sdef15(String dict_sdef15) {
		this.dict_sdef15 = dict_sdef15;
	}
	public String getDict_sdef16() {
		return dict_sdef16;
	}
	public void setDict_sdef16(String dict_sdef16) {
		this.dict_sdef16 = dict_sdef16;
	}
	public String getDict_sdef17() {
		return dict_sdef17;
	}
	public void setDict_sdef17(String dict_sdef17) {
		this.dict_sdef17 = dict_sdef17;
	}
	public String getDict_sdef18() {
		return dict_sdef18;
	}
	public void setDict_sdef18(String dict_sdef18) {
		this.dict_sdef18 = dict_sdef18;
	}
	public String getDict_sdef19() {
		return dict_sdef19;
	}
	public void setDict_sdef19(String dict_sdef19) {
		this.dict_sdef19 = dict_sdef19;
	}
	public String getDict_sdef20() {
		return dict_sdef20;
	}
	public void setDict_sdef20(String dict_sdef20) {
		this.dict_sdef20 = dict_sdef20;
	}
	public Date getDict_ddef1() {
		return dict_ddef1;
	}
	public void setDict_ddef1(Date dict_ddef1) {
		this.dict_ddef1 = dict_ddef1;
	}
	public Date getDict_ddef2() {
		return dict_ddef2;
	}
	public void setDict_ddef2(Date dict_ddef2) {
		this.dict_ddef2 = dict_ddef2;
	}
	public Date getDict_ddef3() {
		return dict_ddef3;
	}
	public void setDict_ddef3(Date dict_ddef3) {
		this.dict_ddef3 = dict_ddef3;
	}
	public Date getDict_ddef4() {
		return dict_ddef4;
	}
	public void setDict_ddef4(Date dict_ddef4) {
		this.dict_ddef4 = dict_ddef4;
	}
	public Date getDict_ddef5() {
		return dict_ddef5;
	}
	public void setDict_ddef5(Date dict_ddef5) {
		this.dict_ddef5 = dict_ddef5;
	}
	public Date getDict_ddef6() {
		return dict_ddef6;
	}
	public void setDict_ddef6(Date dict_ddef6) {
		this.dict_ddef6 = dict_ddef6;
	}
	public Date getDict_ddef7() {
		return dict_ddef7;
	}
	public void setDict_ddef7(Date dict_ddef7) {
		this.dict_ddef7 = dict_ddef7;
	}
	public Date getDict_ddef8() {
		return dict_ddef8;
	}
	public void setDict_ddef8(Date dict_ddef8) {
		this.dict_ddef8 = dict_ddef8;
	}
	public Date getDict_ddef9() {
		return dict_ddef9;
	}
	public void setDict_ddef9(Date dict_ddef9) {
		this.dict_ddef9 = dict_ddef9;
	}
	public Date getDict_ddef10() {
		return dict_ddef10;
	}
	public void setDict_ddef10(Date dict_ddef10) {
		this.dict_ddef10 = dict_ddef10;
	}
	public BigDecimal getDict_ndef1() {
		return dict_ndef1;
	}
	public void setDict_ndef1(BigDecimal dict_ndef1) {
		this.dict_ndef1 = dict_ndef1;
	}
	public BigDecimal getDict_ndef2() {
		return dict_ndef2;
	}
	public void setDict_ndef2(BigDecimal dict_ndef2) {
		this.dict_ndef2 = dict_ndef2;
	}
	public BigDecimal getDict_ndef3() {
		return dict_ndef3;
	}
	public void setDict_ndef3(BigDecimal dict_ndef3) {
		this.dict_ndef3 = dict_ndef3;
	}
	public BigDecimal getDict_ndef4() {
		return dict_ndef4;
	}
	public void setDict_ndef4(BigDecimal dict_ndef4) {
		this.dict_ndef4 = dict_ndef4;
	}
	public BigDecimal getDict_ndef5() {
		return dict_ndef5;
	}
	public void setDict_ndef5(BigDecimal dict_ndef5) {
		this.dict_ndef5 = dict_ndef5;
	}
	public BigDecimal getDict_ndef6() {
		return dict_ndef6;
	}
	public void setDict_ndef6(BigDecimal dict_ndef6) {
		this.dict_ndef6 = dict_ndef6;
	}
	public BigDecimal getDict_ndef7() {
		return dict_ndef7;
	}
	public void setDict_ndef7(BigDecimal dict_ndef7) {
		this.dict_ndef7 = dict_ndef7;
	}
	public BigDecimal getDict_ndef8() {
		return dict_ndef8;
	}
	public void setDict_ndef8(BigDecimal dict_ndef8) {
		this.dict_ndef8 = dict_ndef8;
	}
	public BigDecimal getDict_ndef9() {
		return dict_ndef9;
	}
	public void setDict_ndef9(BigDecimal dict_ndef9) {
		this.dict_ndef9 = dict_ndef9;
	}
	public BigDecimal getDict_ndef10() {
		return dict_ndef10;
	}
	public void setDict_ndef10(BigDecimal dict_ndef10) {
		this.dict_ndef10 = dict_ndef10;
	}
	
}
