package com.rc.base.vo;

import java.math.BigDecimal;
import java.util.Date;

public class MngEmp {
	private Long emp_nid;//员工id,自增序列
	private String ud_sno;//所属单位(1级学校)
	private String ud_sname;//所属单位名称
	private String ud_sno1;//所属学部(2级)
	private String ud_sname1;//所属学部名称
	private String ud_sno2;//所属学院(处)编号(3级)
	private String ud_sname2;//所属学院(处)名称
	private String ud_sno3;//所属系[科]编号(4级)
	private String ud_sname3;//所属系[科]名称
	private String sh_sno;//所属校区:存校区编号
	private String emp_sno;//员工编号(唯一)
	private String emp_sname;//姓名
	private String emp_sename;//英文名
	private Long emp_nstate;//状态:0在职、1离职、2停薪留职、3退休、4反聘、5、全职外聘、6、兼职、7、挂职、8、客座、9、去逝
	private String emp_stele;//手机
	private String emp_steleinner;//电话内线
	private String emp_steleout;//电话外线
	private String emp_semail;//电子邮件
	private String emp_sgender;//性别:1男 0 女
	private String emp_sfax	;//传真
	private String job_sno;//职务
	private String post_sno	;//职称
	private String emp_nlevel;//职级:从数据字典取(院士、长江学者）
	private Date emp_dintime;//入职日期
	private Date emp_dbirthday;//出生日期
	private String emp_sstype;//学历类型:从数据字典取(0中专、1高中、2大专、3、本科、4、研究生、5博士、6博士后)
	private String emp_school;//最后毕业学校
	private String emp_scity;//籍贯
	private BigDecimal emp_nlenght;//身高(米)
	private String emp_sadder	;//出生地址
	private String emp_sisyf;//是否已婚：0未婚,1已婚,3离婚
	private String emp_sisdsz;//是否独生子女户：0.是 1.否
	private String emp_sishz;//是否户主：0主户主，1副户主，2其它
	private String emp_sftype;//配偶单位类型：0其它，1外单位，2本单位，3附属单位
	private String emp_sisfsdw;//配偶是否在附属单位：是否本单位或附属单位[0不，1本单位，2附属单位]
	private String emp_sfno;//配偶员工编号:如果配偶在本单位或附属单位的员工工号
	private String emp_sfname;//配偶姓名
	private String emp_siszrbdw;//子女是否本单位员工:0其它，1外单位，2本单位，3附属单位
	private String emp_szrno;//子女员工编号
	private String emp_sisgjrc;//是否高级人才引进：0.是 1.否
	private Long emp_nworknum;//工龄数
	private String emp_sfbtype;//房屋补贴类型：0无补贴,1一次性补贴,2每月补贴
	private BigDecimal emp_nfbsum;//一次补贴总金额
	private Date emp_dfbdate;//一次补贴时间
	private BigDecimal emp_nsum;//总补贴金额数
	private BigDecimal emp_nfblevel;//房屋补贴每月工资的额度(%)：当月工资*额度(66%)=每月房补金额
	private Date emp_dsbddate;//开始补贴日期
	private BigDecimal emp_nybsum;//已补贴金额
	private String emp_sfjno;//住房房间号
	private BigDecimal emp_nprice;//当前工资
	private String emp_shwtype;//住房类别：0无房，1校集中房，2散户
	private String emp_sgltype;//供暖核算方法：0按建筑面积算，1按使用面积算，0不支付暖费
	private BigDecimal emp_nglprice;//供暖单价(元)：0建筑面积*供暖单价1使用面积*供暖单价
	private BigDecimal emp_nwysum;//支付物业费金额：每月支付金额数
	private String emp_scardcode;//门禁卡号
	private String emp_sfingerprint1;//指纹1：有三种：原图象、特征值，优化图象。[14k]
	private String emp_sfingerprint2;//指纹2
	private String emp_sfingerprint3;//指纹3
	private String emp_sfingerprint4;//指纹4
	private String emp_smem;//工作经历
	private String emp_smem1;//学历经历
	private String emp_sisdel;//是否删除：0。未删；1。删除
	private String emp_sisvalid;//是否有效：0-有效；1-无效
	private String emp_sreplyby;//创建人
	private Date emp_dreplydate	;//创建时间
	private String emp_salterby	;//修改人
	private Date emp_dalterdate	;//修改时间
	private String sh_sname; //校区名称
	private String userid;//主键 自增序列
	private String screenname;//帐号:唯一键
	private String password;//密码
	private String email;//邮箱
	private String firstname;//第一个名字
	private String lastname;//最后一个名字
	private String status;
	private String job_sname;
	private String post_sname;
	private String ditem_sname;//字典项名称
	private String ditem_sname1;//字典项名称1
	private String ditem_sname2;//字典项名称2
	private String ditem_sname3;//字典项名称3
	private String ditem_sname4;//字典项名称4
	private String ditem_sname5;//字典项名称5
	private String emp_sdef1;
	private String emp_sdef2;
	private String emp_sdef3;
	private String emp_sdef4;
	private String emp_sdef5;
	private String emp_sdef6;
	private String emp_sdef7;
	private String emp_sdef8;
	private String emp_sdef9;
	private String emp_sdef10;
	private String emp_sdef11;
	private String emp_sdef12;
	private String emp_sdef13;
	private String emp_sdef14;
	private String emp_sdef15;
	private String emp_sdef16;
	private String emp_sdef17;
	private String emp_sdef18;
	private String emp_sdef19;
	private String emp_sdef20;
	private Date emp_ddef1;
	private Date emp_ddef2;
	private Date emp_ddef3;
	private Date emp_ddef4;
	private Date emp_ddef5;
	private Date emp_ddef6;
	private Date emp_ddef7;
	private Date emp_ddef8;
	private Date emp_ddef9;
	private Date emp_ddef10;
	private BigDecimal emp_ndef1;
	private BigDecimal emp_ndef2;
	private BigDecimal emp_ndef3;
	private BigDecimal emp_ndef4;
	private BigDecimal emp_ndef5;
	private BigDecimal emp_ndef6;
	private BigDecimal emp_ndef7;
	private BigDecimal emp_ndef8;
	private BigDecimal emp_ndef9;
	private BigDecimal emp_ndef10;
	private String xlsname;//学历名称
	private String lvesname;//职级名称

	
 
	public String getXlsname() {
		return xlsname;
	}
	public void setXlsname(String xlsname) {
		this.xlsname = xlsname;
	}
	public String getLvesname() {
		return lvesname;
	}
	public void setLvesname(String lvesname) {
		this.lvesname = lvesname;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSh_sname() {
		return sh_sname;
	}
	public void setSh_sname(String sh_sname) {
		this.sh_sname = sh_sname;
	}
	public Long getEmp_nid() {
		return emp_nid;
	}
	public void setEmp_nid(Long emp_nid) {
		this.emp_nid = emp_nid;
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
	public String getSh_sno() {
		return sh_sno;
	}
	public void setSh_sno(String sh_sno) {
		this.sh_sno = sh_sno;
	}
	public String getEmp_sno() {
		return emp_sno;
	}
	public void setEmp_sno(String emp_sno) {
		this.emp_sno = emp_sno;
	}
	public String getEmp_sname() {
		return emp_sname;
	}
	public void setEmp_sname(String emp_sname) {
		this.emp_sname = emp_sname;
	}
	public String getEmp_sename() {
		return emp_sename;
	}
	public void setEmp_sename(String emp_sename) {
		this.emp_sename = emp_sename;
	}
	public Long getEmp_nstate() {
		return emp_nstate;
	}
	public void setEmp_nstate(Long emp_nstate) {
		this.emp_nstate = emp_nstate;
	}
	public String getEmp_stele() {
		return emp_stele;
	}
	public void setEmp_stele(String emp_stele) {
		this.emp_stele = emp_stele;
	}
	public String getEmp_steleinner() {
		return emp_steleinner;
	}
	public void setEmp_steleinner(String emp_steleinner) {
		this.emp_steleinner = emp_steleinner;
	}
	public String getEmp_steleout() {
		return emp_steleout;
	}
	public void setEmp_steleout(String emp_steleout) {
		this.emp_steleout = emp_steleout;
	}
	public String getEmp_semail() {
		return emp_semail;
	}
	public void setEmp_semail(String emp_semail) {
		this.emp_semail = emp_semail;
	}
	public String getEmp_sgender() {
		return emp_sgender;
	}
	public void setEmp_sgender(String emp_sgender) {
		this.emp_sgender = emp_sgender;
	}
	public String getEmp_sfax() {
		return emp_sfax;
	}
	public void setEmp_sfax(String emp_sfax) {
		this.emp_sfax = emp_sfax;
	}
	public String getJob_sno() {
		return job_sno;
	}
	public void setJob_sno(String job_sno) {
		this.job_sno = job_sno;
	}
	public String getPost_sno() {
		return post_sno;
	}
	public void setPost_sno(String post_sno) {
		this.post_sno = post_sno;
	}
	public String getEmp_nlevel() {
		return emp_nlevel;
	}
	public void setEmp_nlevel(String emp_nlevel) {
		this.emp_nlevel = emp_nlevel;
	}
	public Date getEmp_dintime() {
		return emp_dintime;
	}
	public void setEmp_dintime(Date emp_dintime) {
		this.emp_dintime = emp_dintime;
	}
	public Date getEmp_dbirthday() {
		return emp_dbirthday;
	}
	public void setEmp_dbirthday(Date emp_dbirthday) {
		this.emp_dbirthday = emp_dbirthday;
	}
	public String getEmp_sstype() {
		return emp_sstype;
	}
	public void setEmp_sstype(String emp_sstype) {
		this.emp_sstype = emp_sstype;
	}
	public String getEmp_school() {
		return emp_school;
	}
	public void setEmp_school(String emp_school) {
		this.emp_school = emp_school;
	}
	public String getEmp_scity() {
		return emp_scity;
	}
	public void setEmp_scity(String emp_scity) {
		this.emp_scity = emp_scity;
	}
	public BigDecimal getEmp_nlenght() {
		return emp_nlenght;
	}
	public void setEmp_nlenght(BigDecimal emp_nlenght) {
		this.emp_nlenght = emp_nlenght;
	}
	public String getEmp_sadder() {
		return emp_sadder;
	}
	public void setEmp_sadder(String emp_sadder) {
		this.emp_sadder = emp_sadder;
	}
	public String getEmp_sisyf() {
		return emp_sisyf;
	}
	public void setEmp_sisyf(String emp_sisyf) {
		this.emp_sisyf = emp_sisyf;
	}
	public String getEmp_sisdsz() {
		return emp_sisdsz;
	}
	public void setEmp_sisdsz(String emp_sisdsz) {
		this.emp_sisdsz = emp_sisdsz;
	}
	public String getEmp_sishz() {
		return emp_sishz;
	}
	public void setEmp_sishz(String emp_sishz) {
		this.emp_sishz = emp_sishz;
	}
	public String getEmp_sftype() {
		return emp_sftype;
	}
	public void setEmp_sftype(String emp_sftype) {
		this.emp_sftype = emp_sftype;
	}
	public String getEmp_sisfsdw() {
		return emp_sisfsdw;
	}
	public void setEmp_sisfsdw(String emp_sisfsdw) {
		this.emp_sisfsdw = emp_sisfsdw;
	}
	public String getEmp_sfno() {
		return emp_sfno;
	}
	public void setEmp_sfno(String emp_sfno) {
		this.emp_sfno = emp_sfno;
	}
	public String getEmp_sfname() {
		return emp_sfname;
	}
	public void setEmp_sfname(String emp_sfname) {
		this.emp_sfname = emp_sfname;
	}
	public String getEmp_siszrbdw() {
		return emp_siszrbdw;
	}
	public void setEmp_siszrbdw(String emp_siszrbdw) {
		this.emp_siszrbdw = emp_siszrbdw;
	}
	public String getEmp_szrno() {
		return emp_szrno;
	}
	public void setEmp_szrno(String emp_szrno) {
		this.emp_szrno = emp_szrno;
	}
	public String getEmp_sisgjrc() {
		return emp_sisgjrc;
	}
	public void setEmp_sisgjrc(String emp_sisgjrc) {
		this.emp_sisgjrc = emp_sisgjrc;
	}
	public Long getEmp_nworknum() {
		return emp_nworknum;
	}
	public void setEmp_nworknum(Long emp_nworknum) {
		this.emp_nworknum = emp_nworknum;
	}
	public String getEmp_sfbtype() {
		return emp_sfbtype;
	}
	public void setEmp_sfbtype(String emp_sfbtype) {
		this.emp_sfbtype = emp_sfbtype;
	}
	public BigDecimal getEmp_nfbsum() {
		return emp_nfbsum;
	}
	public void setEmp_nfbsum(BigDecimal emp_nfbsum) {
		this.emp_nfbsum = emp_nfbsum;
	}
	public Date getEmp_dfbdate() {
		return emp_dfbdate;
	}
	public void setEmp_dfbdate(Date emp_dfbdate) {
		this.emp_dfbdate = emp_dfbdate;
	}
	public BigDecimal getEmp_nsum() {
		return emp_nsum;
	}
	public void setEmp_nsum(BigDecimal emp_nsum) {
		this.emp_nsum = emp_nsum;
	}
	public BigDecimal getEmp_nfblevel() {
		return emp_nfblevel;
	}
	public void setEmp_nfblevel(BigDecimal emp_nfblevel) {
		this.emp_nfblevel = emp_nfblevel;
	}
	public Date getEmp_dsbddate() {
		return emp_dsbddate;
	}
	public void setEmp_dsbddate(Date emp_dsbddate) {
		this.emp_dsbddate = emp_dsbddate;
	}
	public BigDecimal getEmp_nybsum() {
		return emp_nybsum;
	}
	public void setEmp_nybsum(BigDecimal emp_nybsum) {
		this.emp_nybsum = emp_nybsum;
	}
	public String getEmp_sfjno() {
		return emp_sfjno;
	}
	public void setEmp_sfjno(String emp_sfjno) {
		this.emp_sfjno = emp_sfjno;
	}
	public BigDecimal getEmp_nprice() {
		return emp_nprice;
	}
	public void setEmp_nprice(BigDecimal emp_nprice) {
		this.emp_nprice = emp_nprice;
	}
	public String getEmp_shwtype() {
		return emp_shwtype;
	}
	public void setEmp_shwtype(String emp_shwtype) {
		this.emp_shwtype = emp_shwtype;
	}
	public String getEmp_sgltype() {
		return emp_sgltype;
	}
	public void setEmp_sgltype(String emp_sgltype) {
		this.emp_sgltype = emp_sgltype;
	}
	public BigDecimal getEmp_nglprice() {
		return emp_nglprice;
	}
	public void setEmp_nglprice(BigDecimal emp_nglprice) {
		this.emp_nglprice = emp_nglprice;
	}
	public BigDecimal getEmp_nwysum() {
		return emp_nwysum;
	}
	public void setEmp_nwysum(BigDecimal emp_nwysum) {
		this.emp_nwysum = emp_nwysum;
	}
	public String getEmp_scardcode() {
		return emp_scardcode;
	}
	public void setEmp_scardcode(String emp_scardcode) {
		this.emp_scardcode = emp_scardcode;
	}
	public String getEmp_sfingerprint1() {
		return emp_sfingerprint1;
	}
	public void setEmp_sfingerprint1(String emp_sfingerprint1) {
		this.emp_sfingerprint1 = emp_sfingerprint1;
	}
	public String getEmp_sfingerprint2() {
		return emp_sfingerprint2;
	}
	public void setEmp_sfingerprint2(String emp_sfingerprint2) {
		this.emp_sfingerprint2 = emp_sfingerprint2;
	}
	public String getEmp_sfingerprint3() {
		return emp_sfingerprint3;
	}
	public void setEmp_sfingerprint3(String emp_sfingerprint3) {
		this.emp_sfingerprint3 = emp_sfingerprint3;
	}
	public String getEmp_sfingerprint4() {
		return emp_sfingerprint4;
	}
	public void setEmp_sfingerprint4(String emp_sfingerprint4) {
		this.emp_sfingerprint4 = emp_sfingerprint4;
	}
	public String getEmp_smem() {
		return emp_smem;
	}
	public void setEmp_smem(String emp_smem) {
		this.emp_smem = emp_smem;
	}
	public String getEmp_smem1() {
		return emp_smem1;
	}
	public void setEmp_smem1(String emp_smem1) {
		this.emp_smem1 = emp_smem1;
	}
	public String getEmp_sisdel() {
		return emp_sisdel;
	}
	public void setEmp_sisdel(String emp_sisdel) {
		this.emp_sisdel = emp_sisdel;
	}
	public String getEmp_sisvalid() {
		return emp_sisvalid;
	}
	public void setEmp_sisvalid(String emp_sisvalid) {
		this.emp_sisvalid = emp_sisvalid;
	}
	public String getEmp_sreplyby() {
		return emp_sreplyby;
	}
	public void setEmp_sreplyby(String emp_sreplyby) {
		this.emp_sreplyby = emp_sreplyby;
	}
	public Date getEmp_dreplydate() {
		return emp_dreplydate;
	}
	public void setEmp_dreplydate(Date emp_dreplydate) {
		this.emp_dreplydate = emp_dreplydate;
	}
	public String getEmp_salterby() {
		return emp_salterby;
	}
	public void setEmp_salterby(String emp_salterby) {
		this.emp_salterby = emp_salterby;
	}
	public Date getEmp_dalterdate() {
		return emp_dalterdate;
	}
	public void setEmp_dalterdate(Date emp_dalterdate) {
		this.emp_dalterdate = emp_dalterdate;
	}
	public String getEmp_sdef1() {
		return emp_sdef1;
	}
	public void setEmp_sdef1(String emp_sdef1) {
		this.emp_sdef1 = emp_sdef1;
	}
	public String getEmp_sdef2() {
		return emp_sdef2;
	}
	public void setEmp_sdef2(String emp_sdef2) {
		this.emp_sdef2 = emp_sdef2;
	}
	public String getEmp_sdef3() {
		return emp_sdef3;
	}
	public void setEmp_sdef3(String emp_sdef3) {
		this.emp_sdef3 = emp_sdef3;
	}
	public String getEmp_sdef4() {
		return emp_sdef4;
	}
	public void setEmp_sdef4(String emp_sdef4) {
		this.emp_sdef4 = emp_sdef4;
	}
	public String getEmp_sdef5() {
		return emp_sdef5;
	}
	public void setEmp_sdef5(String emp_sdef5) {
		this.emp_sdef5 = emp_sdef5;
	}
	public String getEmp_sdef6() {
		return emp_sdef6;
	}
	public void setEmp_sdef6(String emp_sdef6) {
		this.emp_sdef6 = emp_sdef6;
	}
	public String getEmp_sdef7() {
		return emp_sdef7;
	}
	public void setEmp_sdef7(String emp_sdef7) {
		this.emp_sdef7 = emp_sdef7;
	}
	public String getEmp_sdef8() {
		return emp_sdef8;
	}
	public void setEmp_sdef8(String emp_sdef8) {
		this.emp_sdef8 = emp_sdef8;
	}
	public String getEmp_sdef9() {
		return emp_sdef9;
	}
	public void setEmp_sdef9(String emp_sdef9) {
		this.emp_sdef9 = emp_sdef9;
	}
	public String getEmp_sdef10() {
		return emp_sdef10;
	}
	public void setEmp_sdef10(String emp_sdef10) {
		this.emp_sdef10 = emp_sdef10;
	}
	public String getEmp_sdef11() {
		return emp_sdef11;
	}
	public void setEmp_sdef11(String emp_sdef11) {
		this.emp_sdef11 = emp_sdef11;
	}
	public String getEmp_sdef12() {
		return emp_sdef12;
	}
	public void setEmp_sdef12(String emp_sdef12) {
		this.emp_sdef12 = emp_sdef12;
	}
	public String getEmp_sdef13() {
		return emp_sdef13;
	}
	public void setEmp_sdef13(String emp_sdef13) {
		this.emp_sdef13 = emp_sdef13;
	}
	public String getEmp_sdef14() {
		return emp_sdef14;
	}
	public void setEmp_sdef14(String emp_sdef14) {
		this.emp_sdef14 = emp_sdef14;
	}
	public String getEmp_sdef15() {
		return emp_sdef15;
	}
	public void setEmp_sdef15(String emp_sdef15) {
		this.emp_sdef15 = emp_sdef15;
	}
	public String getEmp_sdef16() {
		return emp_sdef16;
	}
	public void setEmp_sdef16(String emp_sdef16) {
		this.emp_sdef16 = emp_sdef16;
	}
	public String getEmp_sdef17() {
		return emp_sdef17;
	}
	public void setEmp_sdef17(String emp_sdef17) {
		this.emp_sdef17 = emp_sdef17;
	}
	public String getEmp_sdef18() {
		return emp_sdef18;
	}
	public void setEmp_sdef18(String emp_sdef18) {
		this.emp_sdef18 = emp_sdef18;
	}
	public String getEmp_sdef19() {
		return emp_sdef19;
	}
	public void setEmp_sdef19(String emp_sdef19) {
		this.emp_sdef19 = emp_sdef19;
	}
	public String getEmp_sdef20() {
		return emp_sdef20;
	}
	public void setEmp_sdef20(String emp_sdef20) {
		this.emp_sdef20 = emp_sdef20;
	}
	public Date getEmp_ddef1() {
		return emp_ddef1;
	}
	public void setEmp_ddef1(Date emp_ddef1) {
		this.emp_ddef1 = emp_ddef1;
	}
	public Date getEmp_ddef2() {
		return emp_ddef2;
	}
	public void setEmp_ddef2(Date emp_ddef2) {
		this.emp_ddef2 = emp_ddef2;
	}
	public Date getEmp_ddef3() {
		return emp_ddef3;
	}
	public void setEmp_ddef3(Date emp_ddef3) {
		this.emp_ddef3 = emp_ddef3;
	}
	public Date getEmp_ddef4() {
		return emp_ddef4;
	}
	public void setEmp_ddef4(Date emp_ddef4) {
		this.emp_ddef4 = emp_ddef4;
	}
	public Date getEmp_ddef5() {
		return emp_ddef5;
	}
	public void setEmp_ddef5(Date emp_ddef5) {
		this.emp_ddef5 = emp_ddef5;
	}
	public Date getEmp_ddef6() {
		return emp_ddef6;
	}
	public void setEmp_ddef6(Date emp_ddef6) {
		this.emp_ddef6 = emp_ddef6;
	}
	public Date getEmp_ddef7() {
		return emp_ddef7;
	}
	public void setEmp_ddef7(Date emp_ddef7) {
		this.emp_ddef7 = emp_ddef7;
	}
	public Date getEmp_ddef8() {
		return emp_ddef8;
	}
	public void setEmp_ddef8(Date emp_ddef8) {
		this.emp_ddef8 = emp_ddef8;
	}
	public Date getEmp_ddef9() {
		return emp_ddef9;
	}
	public void setEmp_ddef9(Date emp_ddef9) {
		this.emp_ddef9 = emp_ddef9;
	}
	public Date getEmp_ddef10() {
		return emp_ddef10;
	}
	public void setEmp_ddef10(Date emp_ddef10) {
		this.emp_ddef10 = emp_ddef10;
	}
	public BigDecimal getEmp_ndef1() {
		return emp_ndef1;
	}
	public void setEmp_ndef1(BigDecimal emp_ndef1) {
		this.emp_ndef1 = emp_ndef1;
	}
	public BigDecimal getEmp_ndef2() {
		return emp_ndef2;
	}
	public void setEmp_ndef2(BigDecimal emp_ndef2) {
		this.emp_ndef2 = emp_ndef2;
	}
	public BigDecimal getEmp_ndef3() {
		return emp_ndef3;
	}
	public void setEmp_ndef3(BigDecimal emp_ndef3) {
		this.emp_ndef3 = emp_ndef3;
	}
	public BigDecimal getEmp_ndef4() {
		return emp_ndef4;
	}
	public void setEmp_ndef4(BigDecimal emp_ndef4) {
		this.emp_ndef4 = emp_ndef4;
	}
	public BigDecimal getEmp_ndef5() {
		return emp_ndef5;
	}
	public void setEmp_ndef5(BigDecimal emp_ndef5) {
		this.emp_ndef5 = emp_ndef5;
	}
	public BigDecimal getEmp_ndef6() {
		return emp_ndef6;
	}
	public void setEmp_ndef6(BigDecimal emp_ndef6) {
		this.emp_ndef6 = emp_ndef6;
	}
	public BigDecimal getEmp_ndef7() {
		return emp_ndef7;
	}
	public void setEmp_ndef7(BigDecimal emp_ndef7) {
		this.emp_ndef7 = emp_ndef7;
	}
	public BigDecimal getEmp_ndef8() {
		return emp_ndef8;
	}
	public void setEmp_ndef8(BigDecimal emp_ndef8) {
		this.emp_ndef8 = emp_ndef8;
	}
	public BigDecimal getEmp_ndef9() {
		return emp_ndef9;
	}
	public void setEmp_ndef9(BigDecimal emp_ndef9) {
		this.emp_ndef9 = emp_ndef9;
	}
	public BigDecimal getEmp_ndef10() {
		return emp_ndef10;
	}
	public void setEmp_ndef10(BigDecimal emp_ndef10) {
		this.emp_ndef10 = emp_ndef10;
	}
	public String getJob_sname() {
		return job_sname;
	}
	public void setJob_sname(String job_sname) {
		this.job_sname = job_sname;
	}
	public String getPost_sname() {
		return post_sname;
	}
	public void setPost_sname(String post_sname) {
		this.post_sname = post_sname;
	}
	 
}
