package com.rc.sys.form;

public class TreeForm {
	private Long emp_nid;//员工ID
	private String emp_sno;//员工编号
	private String comp_sno;//单位编号
	private String dep_sno;//部门编号
	private String job_sno;//岗位编号
	private String class_sno;//班组编号
	private String team_sno;//团队编号
	private String ditem_svalue;//字典项值
	private String dict_sname;//字典名
	private Long dict_ntype;//字典类型
	private String sysint_sno;//系统编号
	private String ditem_sname;//字典项名------
	private String ditem_sname1;//字典项名------
	private String ditem_sname2;//字典项名------
	private String ditem_sname3;//字典项名------
	private String dict_stype;
	private String  comp_ssuper;//所属单位
	private String searchA ;//查询条件1
	private String searchB ;//查询条件2
	private String searchC ;//查询条件3
	private String searchD ;//查询条件4 
	private String searchE ;//查询条件5 
	private String searchF;//查询条件6
	private String searchG;//查询条件7
	private String searchH;//查询条件8
	private String searchI;//查询条件9
	private String pageSQLA;//分页前段
	private String pageSQLB;//分页后段
	private String ctype_sno;//客户类别编号
	private String coopt_sno;//合作企业类别编号
	private String pi_stype;//项目类型 0.大项目 1.小项目
	private String ud_sno;//所属单位(1级学校)
	private String ud_sname;//单位名称
	private String ud_sno1;//	所属学部(2级)
	private String ud_sname1;//	所属学部名称
	private String ud_sno2;//	所属学院(处)编号(3级)
	private String ud_sname2;//	所属学院(处)名称
	private String ud_sno3;//	所属系[科]编号(4级)
	private String ud_sname3;//	所属系[科]名称
	private String sh_sno;//校区编号
	private String sh_sname;//	校区名称
	private String right_sno;//权限编号
	private String hs_sno;//	楼栋编号
	private String hs_sname;//	楼栋名称
	private String hu_sno;//	单元编号
	private String hu_sname;//	单元名称
	private String hl_sno;//	楼层编号
	private String hl_sname;//	楼层名称
	private String rm_sno;//	房间编号
	private String rm_sname;//	房间名称
	private String ast_sno;//	资产类型编号
	private String ast_sname;//	类型名称
	private String ast_stype;//	分类
	private String ud_stopno;//上级单位
	private String ud_nnumber;//单位层次
	private String tg_sno;//教研组编号
	private String degt_sno;//学历编码
	private String prof_sno;//专业编号
	private String xk_sno;//学科编号
	private String course_sno;//课程编号
	private String st_sno;//学生编号
	private String course_stype;//课程类型
	private String lo_stype;//类别0管理机构、1人员、2中心机构
	private String lo_stop;//	隶属层次
	private String lo_stopno;//	隶属机构
	private String lo_nnumber;//	组织架构层次
	private String gqu_sno;//	管控设备编号
	private String post_sno;//职称编号
	private String labrm_sno;//主键,实验室房屋信息
	private String lp_sno;//实验室岗位编号
	private String ud_stype;//	单位类型
	private String lp_stype; //类别:0、管理类、1操作类
	private String lo_sno; //组织架构编码
	private String pgtype_sno;//评估类型
	private String lt_sno;//实验室类型
	private String xm_sno;//实验室项目
	private String pgtx_sno;//评估体系
	private String pgtype_stype;//	类别
	private String pgtype_sname;//	类型名称
	private String pgtype_ssname;//	类型简称
	private String xm_sstat;//实验项目信息管理状态
	private String xm_stype;//实验项目信息管理类别[1]
	private String rt_nlevel;//实验室类型类别
	private String ud_stop;//隶属层次
	private String prof_sdef1;//专业编号
	private String sh_ssupno;//	所属校区
	private String ud_ssupno;//	隶属部门
	private String lo_ssupno;//	组织架构编码
	private String lo_slabno; //实验室编码
	private String xq_sno;//学期编码
	private String xq_syear;//年份
	private String xq_squarter;//季度:0春季，1秋季
	private String xq_dstartdate;//开始日期
	private String xq_denddate;//结束日期
	private Long xq_nweeknum;//周数:上课总周数
	private String xq_dskstartdate;//上课开始日期
	private String xq_dskenddate;//上课结束日期
	private String xq_sisweek1;//周一是否上课:0-是；1-否
	private String xq_sisweek2;//周二是否上课:0-是；1-否
	private String xq_sisweek3;//周三是否上课:0-是；1-否
	private String xq_sisweek4;//周四是否上课:0-是；1-否
	private String xq_sisweek5;//周五是否上课:0-是；1-否
	private String xq_sisweek6;//周六是否上课0-是；1-否
	private String xq_sisweek7;//周日是否上课:0-是；1-否
	private String xq_sisjc1;//节次一(每节次两节课):0-是；1-否
	private String xq_sisjc2;//节次二(每节次两节课):0-是；1-否
	private String xq_sisjc3;//节次三(每节次两节课):0-是；1-否
	private String xq_sisjc4;//节次四(每节次两节课):0-是；1-否
	private String xq_sisjc5;//节次五(每节次两节课):0-是；1-否
	private String xq_sisjc6;//节次六(每节次两节课):0-是；1-否
	private String xq_sisvalid;//是否有效：0-有效；1-无效
	
	public String getSearchI() {
		return searchI;
	}

	public void setSearchI(String searchI) {
		this.searchI = searchI;
	}

	public String getSearchH() {
		return searchH;
	}

	public void setSearchH(String searchH) {
		this.searchH = searchH;
	}

	public String getSh_ssupno() {
		return sh_ssupno;
	}

	public void setSh_ssupno(String sh_ssupno) {
		this.sh_ssupno = sh_ssupno;
	}

	public String getUd_ssupno() {
		return ud_ssupno;
	}

	public void setUd_ssupno(String ud_ssupno) {
		this.ud_ssupno = ud_ssupno;
	}

	public String getLo_ssupno() {
		return lo_ssupno;
	}

	public void setLo_ssupno(String lo_ssupno) {
		this.lo_ssupno = lo_ssupno;
	}

	public String getProf_sdef1() {
		return prof_sdef1;
	}

	public void setProf_sdef1(String prof_sdef1) {
		this.prof_sdef1 = prof_sdef1;
	}

	public String getUd_stop() {
		return ud_stop;
	}

	public void setUd_stop(String ud_stop) {
		this.ud_stop = ud_stop;
	}

	public String getRt_nlevel() {
		return rt_nlevel;
	}

	public void setRt_nlevel(String rt_nlevel) {
		this.rt_nlevel = rt_nlevel;
	}

	public String getXm_sstat() {
		return xm_sstat;
	}

	public void setXm_sstat(String xm_sstat) {
		this.xm_sstat = xm_sstat;
	}

	public String getXm_stype() {
		return xm_stype;
	}

	public void setXm_stype(String xm_stype) {
		this.xm_stype = xm_stype;
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

	public String getPgtype_stype() {
		return pgtype_stype;
	}

	public void setPgtype_stype(String pgtype_stype) {
		this.pgtype_stype = pgtype_stype;
	}

	public String getPgtype_sname() {
		return pgtype_sname;
	}

	public void setPgtype_sname(String pgtype_sname) {
		this.pgtype_sname = pgtype_sname;
	}

	public String getPgtype_ssname() {
		return pgtype_ssname;
	}

	public void setPgtype_ssname(String pgtype_ssname) {
		this.pgtype_ssname = pgtype_ssname;
	}

	public String getPgtype_sno() {
		return pgtype_sno;
	}

	public void setPgtype_sno(String pgtype_sno) {
		this.pgtype_sno = pgtype_sno;
	}

	public String getLt_sno() {
		return lt_sno;
	}

	public void setLt_sno(String lt_sno) {
		this.lt_sno = lt_sno;
	}

	public String getXm_sno() {
		return xm_sno;
	}

	public void setXm_sno(String xm_sno) {
		this.xm_sno = xm_sno;
	}

	public String getPgtx_sno() {
		return pgtx_sno;
	}

	public void setPgtx_sno(String pgtx_sno) {
		this.pgtx_sno = pgtx_sno;
	}

	public String getDitem_sname() {
		return ditem_sname;
	}

	public void setDitem_sname(String ditem_sname) {
		this.ditem_sname = ditem_sname;
	}

	public String getUd_stype() {
		return ud_stype;
	}

	public void setUd_stype(String ud_stype) {
		this.ud_stype = ud_stype;
	}

	public String getGqu_sno() {
		return gqu_sno;
	}

	public void setGqu_sno(String gqu_sno) {
		this.gqu_sno = gqu_sno;
	}

	public String getPost_sno() {
		return post_sno;
	}

	public void setPost_sno(String post_sno) {
		this.post_sno = post_sno;
	}

	public String getLabrm_sno() {
		return labrm_sno;
	}

	public void setLabrm_sno(String labrm_sno) {
		this.labrm_sno = labrm_sno;
	}

	public String getLp_sno() {
		return lp_sno;
	}

	public void setLp_sno(String lp_sno) {
		this.lp_sno = lp_sno;
	}

	public String getLo_stop() {
		return lo_stop;
	}

	public void setLo_stop(String lo_stop) {
		this.lo_stop = lo_stop;
	}

	public String getLo_stopno() {
		return lo_stopno;
	}

	public void setLo_stopno(String lo_stopno) {
		this.lo_stopno = lo_stopno;
	}

	public String getLo_nnumber() {
		return lo_nnumber;
	}

	public void setLo_nnumber(String lo_nnumber) {
		this.lo_nnumber = lo_nnumber;
	}

	public String getCourse_stype() {
		return course_stype;
	}

	public void setCourse_stype(String course_stype) {
		this.course_stype = course_stype;
	}

	public String getLo_stype() {
		return lo_stype;
	}

	public void setLo_stype(String lo_stype) {
		this.lo_stype = lo_stype;
	}

	public String getDegt_sno() {
		return degt_sno;
	}

	public void setDegt_sno(String degt_sno) {
		this.degt_sno = degt_sno;
	}

	public String getProf_sno() {
		return prof_sno;
	}

	public void setProf_sno(String prof_sno) {
		this.prof_sno = prof_sno;
	}

	public String getXk_sno() {
		return xk_sno;
	}

	public void setXk_sno(String xk_sno) {
		this.xk_sno = xk_sno;
	}

	public String getCourse_sno() {
		return course_sno;
	}

	public void setCourse_sno(String course_sno) {
		this.course_sno = course_sno;
	}

	public String getSt_sno() {
		return st_sno;
	}

	public void setSt_sno(String st_sno) {
		this.st_sno = st_sno;
	}

	public String getTg_sno() {
		return tg_sno;
	}

	public void setTg_sno(String tg_sno) {
		this.tg_sno = tg_sno;
	}

	public String getUd_nnumber() {
		return ud_nnumber;
	}

	public void setUd_nnumber(String ud_nnumber) {
		this.ud_nnumber = ud_nnumber;
	}

	public String getUd_stopno() {
		return ud_stopno;
	}

	public void setUd_stopno(String ud_stopno) {
		this.ud_stopno = ud_stopno;
	}

	public String getAst_stype() {
		return ast_stype;
	}

	public void setAst_stype(String ast_stype) {
		this.ast_stype = ast_stype;
	}

	public String getAst_sno() {
		return ast_sno;
	}

	public void setAst_sno(String ast_sno) {
		this.ast_sno = ast_sno;
	}

	public String getAst_sname() {
		return ast_sname;
	}

	public void setAst_sname(String ast_sname) {
		this.ast_sname = ast_sname;
	}

	public String getRm_sno() {
		return rm_sno;
	}

	public void setRm_sno(String rm_sno) {
		this.rm_sno = rm_sno;
	}

	public String getRm_sname() {
		return rm_sname;
	}

	public void setRm_sname(String rm_sname) {
		this.rm_sname = rm_sname;
	}

	public String getHl_sno() {
		return hl_sno;
	}

	public void setHl_sno(String hl_sno) {
		this.hl_sno = hl_sno;
	}

	public String getHl_sname() {
		return hl_sname;
	}

	public void setHl_sname(String hl_sname) {
		this.hl_sname = hl_sname;
	}

	public String getHu_sno() {
		return hu_sno;
	}

	public void setHu_sno(String hu_sno) {
		this.hu_sno = hu_sno;
	}

	public String getHu_sname() {
		return hu_sname;
	}

	public void setHu_sname(String hu_sname) {
		this.hu_sname = hu_sname;
	}

	public String getHs_sno() {
		return hs_sno;
	}

	public void setHs_sno(String hs_sno) {
		this.hs_sno = hs_sno;
	}

	public String getHs_sname() {
		return hs_sname;
	}

	public void setHs_sname(String hs_sname) {
		this.hs_sname = hs_sname;
	}

	public String getSearchF() {
		return searchF;
	}

	public void setSearchF(String searchF) {
		this.searchF = searchF;
	}

	public String getSearchG() {
		return searchG;
	}

	public void setSearchG(String searchG) {
		this.searchG = searchG;
	}

	public String getRight_sno() {
		return right_sno;
	}

	public void setRight_sno(String right_sno) {
		this.right_sno = right_sno;
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

	public String getSysint_sno() {
		return sysint_sno;
	}

	public void setSysint_sno(String sysint_sno) {
		this.sysint_sno = sysint_sno;
	}

	public String getDict_stype() {
		return dict_stype;
	}

	public void setDict_stype(String dict_stype) {
		this.dict_stype = dict_stype;
	}

	public String getPi_stype() {
		return pi_stype;
	}

	public void setPi_stype(String pi_stype) {
		this.pi_stype = pi_stype;
	}

	public String getCtype_sno() {
		return ctype_sno;
	}

	public void setCtype_sno(String ctype_sno) {
		this.ctype_sno = ctype_sno;
	}

	public String getCoopt_sno() {
		return coopt_sno;
	}

	public void setCoopt_sno(String coopt_sno) {
		this.coopt_sno = coopt_sno;
	}

	public String getSearchE() {
		return searchE;
	}

	public void setSearchE(String searchE) {
		this.searchE = searchE;
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

	public String getComp_ssuper() {
		return comp_ssuper;
	}

	public void setComp_ssuper(String comp_ssuper) {
		this.comp_ssuper = comp_ssuper;
	}

	

	public String getDitem_svalue() {
		return ditem_svalue;
	}

	public void setDitem_svalue(String ditem_svalue) {
		this.ditem_svalue = ditem_svalue;
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

	public Long getEmp_nid() {
		return emp_nid;
	}

	public void setEmp_nid(Long emp_nid) {
		this.emp_nid = emp_nid;
	}

	public String getEmp_sno() {
		return emp_sno;
	}

	public void setEmp_sno(String emp_sno) {
		this.emp_sno = emp_sno;
	}

	public String getComp_sno() {
		return comp_sno;
	}

	public void setComp_sno(String comp_sno) {
		this.comp_sno = comp_sno;
	}

	public String getDep_sno() {
		return dep_sno;
	}

	public void setDep_sno(String dep_sno) {
		this.dep_sno = dep_sno;
	}

	public String getJob_sno() {
		return job_sno;
	}

	public void setJob_sno(String job_sno) {
		this.job_sno = job_sno;
	}

	public String getClass_sno() {
		return class_sno;
	}

	public void setClass_sno(String class_sno) {
		this.class_sno = class_sno;
	}

	public String getTeam_sno() {
		return team_sno;
	}

	public void setTeam_sno(String team_sno) {
		this.team_sno = team_sno;
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

	public String getSh_sno() {
		return sh_sno;
	}

	public void setSh_sno(String sh_sno) {
		this.sh_sno = sh_sno;
	}

	public String getSh_sname() {
		return sh_sname;
	}

	public void setSh_sname(String sh_sname) {
		this.sh_sname = sh_sname;
	}

	public String getLp_stype() {
		return lp_stype;
	}

	public void setLp_stype(String lp_stype) {
		this.lp_stype = lp_stype;
	}

	public String getLo_sno() {
		return lo_sno;
	}

	public void setLo_sno(String lo_sno) {
		this.lo_sno = lo_sno;
	}

	public String getLo_slabno() {
		return lo_slabno;
	}

	public void setLo_slabno(String lo_slabno) {
		this.lo_slabno = lo_slabno;
	}

	public String getXq_sno() {
		return xq_sno;
	}

	public void setXq_sno(String xq_sno) {
		this.xq_sno = xq_sno;
	}

	public String getXq_syear() {
		return xq_syear;
	}

	public void setXq_syear(String xq_syear) {
		this.xq_syear = xq_syear;
	}

	public String getXq_squarter() {
		return xq_squarter;
	}

	public void setXq_squarter(String xq_squarter) {
		this.xq_squarter = xq_squarter;
	}

	public String getXq_dstartdate() {
		return xq_dstartdate;
	}

	public void setXq_dstartdate(String xq_dstartdate) {
		this.xq_dstartdate = xq_dstartdate;
	}

	public String getXq_denddate() {
		return xq_denddate;
	}

	public void setXq_denddate(String xq_denddate) {
		this.xq_denddate = xq_denddate;
	}

	public Long getXq_nweeknum() {
		return xq_nweeknum;
	}

	public void setXq_nweeknum(Long xq_nweeknum) {
		this.xq_nweeknum = xq_nweeknum;
	}

	public String getXq_dskstartdate() {
		return xq_dskstartdate;
	}

	public void setXq_dskstartdate(String xq_dskstartdate) {
		this.xq_dskstartdate = xq_dskstartdate;
	}

	public String getXq_dskenddate() {
		return xq_dskenddate;
	}

	public void setXq_dskenddate(String xq_dskenddate) {
		this.xq_dskenddate = xq_dskenddate;
	}

	public String getXq_sisweek1() {
		return xq_sisweek1;
	}

	public void setXq_sisweek1(String xq_sisweek1) {
		this.xq_sisweek1 = xq_sisweek1;
	}

	public String getXq_sisweek2() {
		return xq_sisweek2;
	}

	public void setXq_sisweek2(String xq_sisweek2) {
		this.xq_sisweek2 = xq_sisweek2;
	}

	public String getXq_sisweek3() {
		return xq_sisweek3;
	}

	public void setXq_sisweek3(String xq_sisweek3) {
		this.xq_sisweek3 = xq_sisweek3;
	}

	public String getXq_sisweek4() {
		return xq_sisweek4;
	}

	public void setXq_sisweek4(String xq_sisweek4) {
		this.xq_sisweek4 = xq_sisweek4;
	}

	public String getXq_sisweek5() {
		return xq_sisweek5;
	}

	public void setXq_sisweek5(String xq_sisweek5) {
		this.xq_sisweek5 = xq_sisweek5;
	}

	public String getXq_sisweek6() {
		return xq_sisweek6;
	}

	public void setXq_sisweek6(String xq_sisweek6) {
		this.xq_sisweek6 = xq_sisweek6;
	}

	public String getXq_sisweek7() {
		return xq_sisweek7;
	}

	public void setXq_sisweek7(String xq_sisweek7) {
		this.xq_sisweek7 = xq_sisweek7;
	}

	public String getXq_sisjc1() {
		return xq_sisjc1;
	}

	public void setXq_sisjc1(String xq_sisjc1) {
		this.xq_sisjc1 = xq_sisjc1;
	}

	public String getXq_sisjc2() {
		return xq_sisjc2;
	}

	public void setXq_sisjc2(String xq_sisjc2) {
		this.xq_sisjc2 = xq_sisjc2;
	}

	public String getXq_sisjc3() {
		return xq_sisjc3;
	}

	public void setXq_sisjc3(String xq_sisjc3) {
		this.xq_sisjc3 = xq_sisjc3;
	}

	public String getXq_sisjc4() {
		return xq_sisjc4;
	}

	public void setXq_sisjc4(String xq_sisjc4) {
		this.xq_sisjc4 = xq_sisjc4;
	}

	public String getXq_sisjc5() {
		return xq_sisjc5;
	}

	public void setXq_sisjc5(String xq_sisjc5) {
		this.xq_sisjc5 = xq_sisjc5;
	}

	public String getXq_sisjc6() {
		return xq_sisjc6;
	}

	public void setXq_sisjc6(String xq_sisjc6) {
		this.xq_sisjc6 = xq_sisjc6;
	}

	public String getXq_sisvalid() {
		return xq_sisvalid;
	}

	public void setXq_sisvalid(String xq_sisvalid) {
		this.xq_sisvalid = xq_sisvalid;
	}



}
