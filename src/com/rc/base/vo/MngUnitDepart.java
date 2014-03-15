package com.rc.base.vo;

import java.math.BigDecimal;
import java.util.Date;


public class MngUnitDepart {
	private String ud_sno;//单位编码
	private String ud_sname;//单位名称(同一上级单位中唯一)
	private String ud_ssname;//单位简称
	private String ud_sno1;//1级单位编码
	private String ud_sname1;//1级单位名称(同一上级单位中唯一)
	private String ud_sno2;//2级单位编码
	private String ud_sname2;//2级单位名称(同一上级单位中唯一)
	private String ud_sno3;//3级单位编码
	private String ud_sname3;//3级单位名称(同一上级单位中唯一)
	private String ud_sno4;//4级单位编码
	private String ud_sname4;//4级单位名称(同一上级单位中唯一)
	private String ud_sno5;//5级单位编码
	private String ud_sname5;//5级单位名称(同一上级单位中唯一)
	private String ud_sno6;//6级单位编码
	private String ud_sname6;//6级单位名称(同一上级单位中唯一)
	private String ud_stop;//隶属层次 (隶属单位的层次)
	private String ud_stopno;//上级单位
	private String ud_stopname;//上级单位名称
	private String ud_stopsname;//上级单位简称
	private Long ud_nnumber;//单位层次：1学校2学部3学院4系
	private Long ud_nisuse;//是否启用
	private Long ud_nistrue	;//是否定编
	private String ud_sbrightpwd;//密码明码
	private String ud_spwd;//登录密码
	private Long ud_ntimes;//登陆次数
	private Date ud_tlogin;//最近登录
	private String ud_ssynchro;//同步信息
	private String ud_soldname;//原单位名称
	private String ud_sdealsign;//处理标志
	private String ud_smanname;//处理人
	private Date ud_tmantime;//处理时间
	private String ud_saddr;//地址
	private String ud_stele;//电话
	private String ud_spostcode;//单位邮政编码
	private String ud_smail;//单位邮箱
	private String ud_stype;//单位类型
	private String ud_sbank;//银行帐号
	private String ud_sduty;//税号
	private String ud_slinkman;//联系人
	private String ud_slegalman;//法人代表
	private String ud_sassetsize;//资产规模
	private String ud_smannum;//教职工人数
	private String ud_sschoolnum;//在校生人数
	private String ud_sfinance;//财务收支
	private String ud_saptitude;//资质等级
	private String ud_smunidep;//隶属市级部门
	private String ud_sbriefcode;//简码
	private String ud_swheelman;//负责人
	private String ud_sisdel;//是否删除：0。未删；1。删除
	private String ud_sisvalid;//是否有效：0-有效；1-无效
	private String ud_sreplyby;//创建人
	private Date ud_dreplydate;//创建时间
	private String ud_salterby;//修改人
	private Date ud_dalterdate;//修改时间
	private String ud_sdef1;
	private String ud_sdef2;
	private String ud_sdef3;
	private String ud_sdef4;
	private String ud_sdef5;
	private String ud_sdef6;
	private String ud_sdef7;
	private String ud_sdef8;
	private String ud_sdef9;
	private String ud_sdef10;
	private String ud_sdef11;
	private String ud_sdef12;
	private String ud_sdef13;
	private String ud_sdef14;
	private String ud_sdef15;
	private String ud_sdef16;
	private String ud_sdef17;
	private String ud_sdef18;
	private String ud_sdef19;
	private String ud_sdef20;
	private Date ud_ddef1;
	private Date ud_ddef2;
	private Date ud_ddef3;
	private Date ud_ddef4;
	private Date ud_ddef5;
	private Date ud_ddef6;
	private Date ud_ddef7;
	private Date ud_ddef8;
	private Date ud_ddef9;
	private Date ud_ddef10;
	private BigDecimal ud_ndef1;
	private BigDecimal ud_ndef2;
	private BigDecimal ud_ndef3;
	private BigDecimal ud_ndef4;
	private BigDecimal ud_ndef5;
	private BigDecimal ud_ndef6;
	private BigDecimal ud_ndef7;
	private BigDecimal ud_ndef8;
	private BigDecimal ud_ndef9;
	private BigDecimal ud_ndef10;
	private String job_sname;
	private String job_sno;
	private String ditem_sname;//字典项名称
	private String ditem_sname1;//字典项名称1
	private String ditem_sname2;//字典项名称2
	private String ditem_sname3;//字典项名称3
	private String ditem_sname4;//字典项名称4
	private String ditem_sname5;//字典项名称5
	
	 public String getDitem_sname() {
		return ditem_sname;
	}
	public void setDitem_sname(String ditem_sname) {
		this.ditem_sname = ditem_sname;
	}
	public String getDitem_sname1() {
		return ditem_sname1;
	}
	public void setDitem_sname1(String ditem_sname1) {
		this.ditem_sname1 = ditem_sname1;
	}
	public String getDitem_sname2() {
		return ditem_sname2;
	}
	public void setDitem_sname2(String ditem_sname2) {
		this.ditem_sname2 = ditem_sname2;
	}
	public String getDitem_sname3() {
		return ditem_sname3;
	}
	public void setDitem_sname3(String ditem_sname3) {
		this.ditem_sname3 = ditem_sname3;
	}
	public String getDitem_sname4() {
		return ditem_sname4;
	}
	public void setDitem_sname4(String ditem_sname4) {
		this.ditem_sname4 = ditem_sname4;
	}
	public String getDitem_sname5() {
		return ditem_sname5;
	}
	public void setDitem_sname5(String ditem_sname5) {
		this.ditem_sname5 = ditem_sname5;
	}
	//覆盖equals方法 注意参数为：Object类型   
    public boolean equals(Object obj){
    	MngUnitDepart stu = null;
    	//判断obj是否为空
    	if (obj == null) {
    		return false;
    	}
    	//判断obj是否为MngUnitDepart的实例，否则会出现转型异常
    	if (obj instanceof MngUnitDepart) {
    		stu = (MngUnitDepart)obj;   
    	} else {
    		return false;
    	}
    	boolean flag = true;
        if(!stu.getUd_sno().equals(ud_sno)){   
            flag = false;   
        }else if(!stu.getUd_sname().equals(ud_sname)){   
            flag = false;   
        }/*else if(stu.getAge()!=age){   
            flag = false;   
        } */  
        return flag;   
    }   
	public String getUd_sno1() {
		return ud_sno1;
	}
	public void setUd_sno1(String ud_sno1) {
		this.ud_sno1 = ud_sno1;
	}
	public String getUd_sname1() {
		return ud_sname1;
	}
	public void setUd_sname1(String ud_sname1) {
		this.ud_sname1 = ud_sname1;
	}
	public String getUd_sno2() {
		return ud_sno2;
	}
	public void setUd_sno2(String ud_sno2) {
		this.ud_sno2 = ud_sno2;
	}
	public String getUd_sname2() {
		return ud_sname2;
	}
	public void setUd_sname2(String ud_sname2) {
		this.ud_sname2 = ud_sname2;
	}
	public String getUd_sno3() {
		return ud_sno3;
	}
	public void setUd_sno3(String ud_sno3) {
		this.ud_sno3 = ud_sno3;
	}
	public String getUd_sname3() {
		return ud_sname3;
	}
	public void setUd_sname3(String ud_sname3) {
		this.ud_sname3 = ud_sname3;
	}
	public String getUd_sno4() {
		return ud_sno4;
	}
	public void setUd_sno4(String ud_sno4) {
		this.ud_sno4 = ud_sno4;
	}
	public String getUd_sname4() {
		return ud_sname4;
	}
	public void setUd_sname4(String ud_sname4) {
		this.ud_sname4 = ud_sname4;
	}
	public String getUd_sno5() {
		return ud_sno5;
	}
	public void setUd_sno5(String ud_sno5) {
		this.ud_sno5 = ud_sno5;
	}
	public String getUd_sname5() {
		return ud_sname5;
	}
	public void setUd_sname5(String ud_sname5) {
		this.ud_sname5 = ud_sname5;
	}
	public String getUd_sno6() {
		return ud_sno6;
	}
	public void setUd_sno6(String ud_sno6) {
		this.ud_sno6 = ud_sno6;
	}
	public String getUd_sname6() {
		return ud_sname6;
	}
	public void setUd_sname6(String ud_sname6) {
		this.ud_sname6 = ud_sname6;
	}
	public String getUd_sno() {
		return ud_sno;
	}
	public void setUd_sno(String ud_sno) {
		this.ud_sno = ud_sno;
	}
	public String getUd_sname() {
		return ud_sname;
	}
	public void setUd_sname(String ud_sname) {
		this.ud_sname = ud_sname;
	}
	public String getUd_ssname() {
		return ud_ssname;
	}
	public void setUd_ssname(String ud_ssname) {
		this.ud_ssname = ud_ssname;
	}
	public String getUd_stop() {
		return ud_stop;
	}
	public void setUd_stop(String ud_stop) {
		this.ud_stop = ud_stop;
	}
	public String getUd_stopno() {
		return ud_stopno;
	}
	public void setUd_stopno(String ud_stopno) {
		this.ud_stopno = ud_stopno;
	}
	public String getUd_stopname() {
		return ud_stopname;
	}
	public void setUd_stopname(String ud_stopname) {
		this.ud_stopname = ud_stopname;
	}
	public String getUd_stopsname() {
		return ud_stopsname;
	}
	public void setUd_stopsname(String ud_stopsname) {
		this.ud_stopsname = ud_stopsname;
	}
	public Long getUd_nnumber() {
		return ud_nnumber;
	}
	public void setUd_nnumber(Long ud_nnumber) {
		this.ud_nnumber = ud_nnumber;
	}
	public Long getUd_nisuse() {
		return ud_nisuse;
	}
	public void setUd_nisuse(Long ud_nisuse) {
		this.ud_nisuse = ud_nisuse;
	}
	public Long getUd_nistrue() {
		return ud_nistrue;
	}
	public void setUd_nistrue(Long ud_nistrue) {
		this.ud_nistrue = ud_nistrue;
	}
	public String getUd_sbrightpwd() {
		return ud_sbrightpwd;
	}
	public void setUd_sbrightpwd(String ud_sbrightpwd) {
		this.ud_sbrightpwd = ud_sbrightpwd;
	}
	public String getUd_spwd() {
		return ud_spwd;
	}
	public void setUd_spwd(String ud_spwd) {
		this.ud_spwd = ud_spwd;
	}
	public Long getUd_ntimes() {
		return ud_ntimes;
	}
	public void setUd_ntimes(Long ud_ntimes) {
		this.ud_ntimes = ud_ntimes;
	}
	public Date getUd_tlogin() {
		return ud_tlogin;
	}
	public void setUd_tlogin(Date ud_tlogin) {
		this.ud_tlogin = ud_tlogin;
	}
	public String getUd_ssynchro() {
		return ud_ssynchro;
	}
	public void setUd_ssynchro(String ud_ssynchro) {
		this.ud_ssynchro = ud_ssynchro;
	}
	public String getUd_soldname() {
		return ud_soldname;
	}
	public void setUd_soldname(String ud_soldname) {
		this.ud_soldname = ud_soldname;
	}
	public String getUd_sdealsign() {
		return ud_sdealsign;
	}
	public void setUd_sdealsign(String ud_sdealsign) {
		this.ud_sdealsign = ud_sdealsign;
	}
	public String getUd_smanname() {
		return ud_smanname;
	}
	public void setUd_smanname(String ud_smanname) {
		this.ud_smanname = ud_smanname;
	}
	public Date getUd_tmantime() {
		return ud_tmantime;
	}
	public void setUd_tmantime(Date ud_tmantime) {
		this.ud_tmantime = ud_tmantime;
	}
	public String getUd_saddr() {
		return ud_saddr;
	}
	public void setUd_saddr(String ud_saddr) {
		this.ud_saddr = ud_saddr;
	}
	public String getUd_stele() {
		return ud_stele;
	}
	public void setUd_stele(String ud_stele) {
		this.ud_stele = ud_stele;
	}
	public String getUd_spostcode() {
		return ud_spostcode;
	}
	public void setUd_spostcode(String ud_spostcode) {
		this.ud_spostcode = ud_spostcode;
	}
	public String getUd_smail() {
		return ud_smail;
	}
	public void setUd_smail(String ud_smail) {
		this.ud_smail = ud_smail;
	}
	public String getUd_stype() {
		return ud_stype;
	}
	public void setUd_stype(String ud_stype) {
		this.ud_stype = ud_stype;
	}
	public String getUd_sbank() {
		return ud_sbank;
	}
	public void setUd_sbank(String ud_sbank) {
		this.ud_sbank = ud_sbank;
	}
	public String getUd_sduty() {
		return ud_sduty;
	}
	public void setUd_sduty(String ud_sduty) {
		this.ud_sduty = ud_sduty;
	}
	public String getUd_slinkman() {
		return ud_slinkman;
	}
	public void setUd_slinkman(String ud_slinkman) {
		this.ud_slinkman = ud_slinkman;
	}
	public String getUd_slegalman() {
		return ud_slegalman;
	}
	public void setUd_slegalman(String ud_slegalman) {
		this.ud_slegalman = ud_slegalman;
	}
	public String getUd_sassetsize() {
		return ud_sassetsize;
	}
	public void setUd_sassetsize(String ud_sassetsize) {
		this.ud_sassetsize = ud_sassetsize;
	}
	public String getUd_smannum() {
		return ud_smannum;
	}
	public void setUd_smannum(String ud_smannum) {
		this.ud_smannum = ud_smannum;
	}
	public String getUd_sschoolnum() {
		return ud_sschoolnum;
	}
	public void setUd_sschoolnum(String ud_sschoolnum) {
		this.ud_sschoolnum = ud_sschoolnum;
	}
	public String getUd_sfinance() {
		return ud_sfinance;
	}
	public void setUd_sfinance(String ud_sfinance) {
		this.ud_sfinance = ud_sfinance;
	}
	public String getUd_saptitude() {
		return ud_saptitude;
	}
	public void setUd_saptitude(String ud_saptitude) {
		this.ud_saptitude = ud_saptitude;
	}
	public String getUd_smunidep() {
		return ud_smunidep;
	}
	public void setUd_smunidep(String ud_smunidep) {
		this.ud_smunidep = ud_smunidep;
	}
	public String getUd_sbriefcode() {
		return ud_sbriefcode;
	}
	public void setUd_sbriefcode(String ud_sbriefcode) {
		this.ud_sbriefcode = ud_sbriefcode;
	}
	public String getUd_swheelman() {
		return ud_swheelman;
	}
	public void setUd_swheelman(String ud_swheelman) {
		this.ud_swheelman = ud_swheelman;
	}
	public String getUd_sisdel() {
		return ud_sisdel;
	}
	public void setUd_sisdel(String ud_sisdel) {
		this.ud_sisdel = ud_sisdel;
	}
	public String getUd_sisvalid() {
		return ud_sisvalid;
	}
	public void setUd_sisvalid(String ud_sisvalid) {
		this.ud_sisvalid = ud_sisvalid;
	}
	public String getUd_sreplyby() {
		return ud_sreplyby;
	}
	public void setUd_sreplyby(String ud_sreplyby) {
		this.ud_sreplyby = ud_sreplyby;
	}
	public Date getUd_dreplydate() {
		return ud_dreplydate;
	}
	public void setUd_dreplydate(Date ud_dreplydate) {
		this.ud_dreplydate = ud_dreplydate;
	}
	public String getUd_salterby() {
		return ud_salterby;
	}
	public void setUd_salterby(String ud_salterby) {
		this.ud_salterby = ud_salterby;
	}
	public Date getUd_dalterdate() {
		return ud_dalterdate;
	}
	public void setUd_dalterdate(Date ud_dalterdate) {
		this.ud_dalterdate = ud_dalterdate;
	}
	public String getUd_sdef1() {
		return ud_sdef1;
	}
	public void setUd_sdef1(String ud_sdef1) {
		this.ud_sdef1 = ud_sdef1;
	}
	public String getUd_sdef2() {
		return ud_sdef2;
	}
	public void setUd_sdef2(String ud_sdef2) {
		this.ud_sdef2 = ud_sdef2;
	}
	public String getUd_sdef3() {
		return ud_sdef3;
	}
	public void setUd_sdef3(String ud_sdef3) {
		this.ud_sdef3 = ud_sdef3;
	}
	public String getUd_sdef4() {
		return ud_sdef4;
	}
	public void setUd_sdef4(String ud_sdef4) {
		this.ud_sdef4 = ud_sdef4;
	}
	public String getUd_sdef5() {
		return ud_sdef5;
	}
	public void setUd_sdef5(String ud_sdef5) {
		this.ud_sdef5 = ud_sdef5;
	}
	public String getUd_sdef6() {
		return ud_sdef6;
	}
	public void setUd_sdef6(String ud_sdef6) {
		this.ud_sdef6 = ud_sdef6;
	}
	public String getUd_sdef7() {
		return ud_sdef7;
	}
	public void setUd_sdef7(String ud_sdef7) {
		this.ud_sdef7 = ud_sdef7;
	}
	public String getUd_sdef8() {
		return ud_sdef8;
	}
	public void setUd_sdef8(String ud_sdef8) {
		this.ud_sdef8 = ud_sdef8;
	}
	public String getUd_sdef9() {
		return ud_sdef9;
	}
	public void setUd_sdef9(String ud_sdef9) {
		this.ud_sdef9 = ud_sdef9;
	}
	public String getUd_sdef10() {
		return ud_sdef10;
	}
	public void setUd_sdef10(String ud_sdef10) {
		this.ud_sdef10 = ud_sdef10;
	}
	public String getUd_sdef11() {
		return ud_sdef11;
	}
	public void setUd_sdef11(String ud_sdef11) {
		this.ud_sdef11 = ud_sdef11;
	}
	public String getUd_sdef12() {
		return ud_sdef12;
	}
	public void setUd_sdef12(String ud_sdef12) {
		this.ud_sdef12 = ud_sdef12;
	}
	public String getUd_sdef13() {
		return ud_sdef13;
	}
	public void setUd_sdef13(String ud_sdef13) {
		this.ud_sdef13 = ud_sdef13;
	}
	public String getUd_sdef14() {
		return ud_sdef14;
	}
	public void setUd_sdef14(String ud_sdef14) {
		this.ud_sdef14 = ud_sdef14;
	}
	public String getUd_sdef15() {
		return ud_sdef15;
	}
	public void setUd_sdef15(String ud_sdef15) {
		this.ud_sdef15 = ud_sdef15;
	}
	public String getUd_sdef16() {
		return ud_sdef16;
	}
	public void setUd_sdef16(String ud_sdef16) {
		this.ud_sdef16 = ud_sdef16;
	}
	public String getUd_sdef17() {
		return ud_sdef17;
	}
	public void setUd_sdef17(String ud_sdef17) {
		this.ud_sdef17 = ud_sdef17;
	}
	public String getUd_sdef18() {
		return ud_sdef18;
	}
	public void setUd_sdef18(String ud_sdef18) {
		this.ud_sdef18 = ud_sdef18;
	}
	public String getUd_sdef19() {
		return ud_sdef19;
	}
	public void setUd_sdef19(String ud_sdef19) {
		this.ud_sdef19 = ud_sdef19;
	}
	public String getUd_sdef20() {
		return ud_sdef20;
	}
	public void setUd_sdef20(String ud_sdef20) {
		this.ud_sdef20 = ud_sdef20;
	}
	public Date getUd_ddef1() {
		return ud_ddef1;
	}
	public void setUd_ddef1(Date ud_ddef1) {
		this.ud_ddef1 = ud_ddef1;
	}
	public Date getUd_ddef2() {
		return ud_ddef2;
	}
	public void setUd_ddef2(Date ud_ddef2) {
		this.ud_ddef2 = ud_ddef2;
	}
	public Date getUd_ddef3() {
		return ud_ddef3;
	}
	public void setUd_ddef3(Date ud_ddef3) {
		this.ud_ddef3 = ud_ddef3;
	}
	public Date getUd_ddef4() {
		return ud_ddef4;
	}
	public void setUd_ddef4(Date ud_ddef4) {
		this.ud_ddef4 = ud_ddef4;
	}
	public Date getUd_ddef5() {
		return ud_ddef5;
	}
	public void setUd_ddef5(Date ud_ddef5) {
		this.ud_ddef5 = ud_ddef5;
	}
	public Date getUd_ddef6() {
		return ud_ddef6;
	}
	public void setUd_ddef6(Date ud_ddef6) {
		this.ud_ddef6 = ud_ddef6;
	}
	public Date getUd_ddef7() {
		return ud_ddef7;
	}
	public void setUd_ddef7(Date ud_ddef7) {
		this.ud_ddef7 = ud_ddef7;
	}
	public Date getUd_ddef8() {
		return ud_ddef8;
	}
	public void setUd_ddef8(Date ud_ddef8) {
		this.ud_ddef8 = ud_ddef8;
	}
	public Date getUd_ddef9() {
		return ud_ddef9;
	}
	public void setUd_ddef9(Date ud_ddef9) {
		this.ud_ddef9 = ud_ddef9;
	}
	public Date getUd_ddef10() {
		return ud_ddef10;
	}
	public void setUd_ddef10(Date ud_ddef10) {
		this.ud_ddef10 = ud_ddef10;
	}
	public BigDecimal getUd_ndef1() {
		return ud_ndef1;
	}
	public void setUd_ndef1(BigDecimal ud_ndef1) {
		this.ud_ndef1 = ud_ndef1;
	}
	public BigDecimal getUd_ndef2() {
		return ud_ndef2;
	}
	public void setUd_ndef2(BigDecimal ud_ndef2) {
		this.ud_ndef2 = ud_ndef2;
	}
	public BigDecimal getUd_ndef3() {
		return ud_ndef3;
	}
	public void setUd_ndef3(BigDecimal ud_ndef3) {
		this.ud_ndef3 = ud_ndef3;
	}
	public BigDecimal getUd_ndef4() {
		return ud_ndef4;
	}
	public void setUd_ndef4(BigDecimal ud_ndef4) {
		this.ud_ndef4 = ud_ndef4;
	}
	public BigDecimal getUd_ndef5() {
		return ud_ndef5;
	}
	public void setUd_ndef5(BigDecimal ud_ndef5) {
		this.ud_ndef5 = ud_ndef5;
	}
	public BigDecimal getUd_ndef6() {
		return ud_ndef6;
	}
	public void setUd_ndef6(BigDecimal ud_ndef6) {
		this.ud_ndef6 = ud_ndef6;
	}
	public BigDecimal getUd_ndef7() {
		return ud_ndef7;
	}
	public void setUd_ndef7(BigDecimal ud_ndef7) {
		this.ud_ndef7 = ud_ndef7;
	}
	public BigDecimal getUd_ndef8() {
		return ud_ndef8;
	}
	public void setUd_ndef8(BigDecimal ud_ndef8) {
		this.ud_ndef8 = ud_ndef8;
	}
	public BigDecimal getUd_ndef9() {
		return ud_ndef9;
	}
	public void setUd_ndef9(BigDecimal ud_ndef9) {
		this.ud_ndef9 = ud_ndef9;
	}
	public BigDecimal getUd_ndef10() {
		return ud_ndef10;
	}
	public void setUd_ndef10(BigDecimal ud_ndef10) {
		this.ud_ndef10 = ud_ndef10;
	}
	public String getJob_sname() {
		return job_sname;
	}
	public void setJob_sname(String job_sname) {
		this.job_sname = job_sname;
	}
	public String getJob_sno() {
		return job_sno;
	}
	public void setJob_sno(String job_sno) {
		this.job_sno = job_sno;
	}
}
