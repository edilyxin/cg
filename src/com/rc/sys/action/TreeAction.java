package com.rc.sys.action;

import java.util.List;

import com.rc.base.form.MngSchoolForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.service.SchoolService;
import com.rc.base.service.UnitDepartService;
import com.rc.base.vo.*;
import com.rc.sys.form.TreeForm;
import com.rc.sys.service.TreeService;
import com.rc.sys.vo.*;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;


public class TreeAction  extends BaseAction{
	private TreeService treeService = (TreeService)getBean("treeService");
	private TreeForm form;
	private List treeList;//查询列表
	private PageBean bean;//分页标签
	private List udList;//
	private Integer levels;//最低的部门层次
	private String switchs;//控制是否可以返回值
	private String ud_snos;//部门集合
	
	public String getUd_snos() {
		return ud_snos;
	}

	public void setUd_snos(String ud_snos) {
		this.ud_snos = ud_snos;
	}

	public String getSwitchs() {
		return switchs;
	}

	public void setSwitchs(String switchs) {
		this.switchs = switchs;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public List getTreeList() {
		return treeList;
	}

	public void setTreeList(List treeList) {
		this.treeList = treeList;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public TreeForm getForm() {
		return form;
	}

	public void setForm(TreeForm form) {
		this.form = form;
	}

	/**
	 * 字典下拉框
	 * @return
	 * @throws Exception
	 */
	public String selectDict() throws Exception {

		String id = form.getDitem_svalue(); 
		List list = treeService.findDict(form);
		String returnValue = "";
		for(Object vo :list){
			if (((MngDictItem)vo).getDitem_svalue().equals(id)){
				returnValue += "<option value='"+((MngDictItem)vo).getDitem_svalue()+"' title='"+((MngDictItem)vo).getDitem_sname()+"' selected>"+((MngDictItem)vo).getDitem_sname()+"</option>";
			}else{
				returnValue += "<option value='"+((MngDictItem)vo).getDitem_svalue()+"' title='"+((MngDictItem)vo).getDitem_sname()+"'>"+((MngDictItem)vo).getDitem_sname()+"</option>";	
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(returnValue);
		return null; 
		 
	}
	/**
	 * 系统下拉框
	 * @return
	 * @throws Exception
	 */
	public String selectSys() throws Exception { 
		String id = form.getSysint_sno();
		List list = treeService.findSys(form);
		String returnValue = "";
		for(Object vo :list){
			if (((MngSysint)vo).getSysint_sno().equals(id)){
				returnValue += "<option value='"+((MngSysint)vo).getSysint_sno()+"' title='"+((MngSysint)vo).getSysint_sname()+"' selected>"+((MngSysint)vo).getSysint_sname()+"</option>";
			}else{
				returnValue += "<option value='"+((MngSysint)vo).getSysint_sno()+"' title='"+((MngSysint)vo).getSysint_sname()+"'>"+((MngSysint)vo).getSysint_sname()+"</option>";	
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(returnValue);
		return null;
	}
	
	/**
	 * 员工下拉框
	 * @return
	 * @throws Exception
	 */
	public String selectEmp() throws Exception {
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		String id = form.getEmp_sno();
		List list = treeService.findEmp(form);
		String returnValue = "";
		for(Object vo :list){
			if (((MngEmp)vo).getEmp_sno().equals(id)){
				returnValue += "<option value='"+((MngEmp)vo).getEmp_sno()+"' selected>"+((MngEmp)vo).getEmp_sno()+":"+((MngEmp)vo).getEmp_sname()+"</option>";
			}else{
				returnValue += "<option value='"+((MngEmp)vo).getEmp_sno()+"'>"+((MngEmp)vo).getEmp_sno()+":"+((MngEmp)vo).getEmp_sname()+"</option>";	
			}
		}
		response.getWriter().print(returnValue);
		return null;
	}
	
	 
	

	
	/**
	 * 单位部门下拉框
	 * @return
	 * @throws Exception
	 */
	public String selectDep() throws Exception {
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		String id = form.getDep_sno();
		List list = treeService.findDep(form);
		String returnValue = "";
		for(Object vo :list){
			if (((MngUnitDepart)vo).getUd_sno().equals(id)){
				returnValue += "<option value='"+((MngUnitDepart)vo).getUd_sno()+"' selected>"+((MngUnitDepart)vo).getUd_sname()+"</option>";
			}else{
				returnValue += "<option value='"+((MngUnitDepart)vo).getUd_sno()+"'>"+((MngUnitDepart)vo).getUd_sname()+"</option>";	
			}
		}
		response.getWriter().print(returnValue);
		return null;
	}
	
	/**
	 * 岗位下拉框
	 * @return
	 * @throws Exception
	 */
	public String selectJob() throws Exception {
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		String id = form.getJob_sno();
		List list = treeService.findJob(form);
		String returnValue = "";
		for(Object vo :list){
			if (((MngJob)vo).getJob_sno().equals(id)){
				returnValue += "<option value='"+((MngJob)vo).getJob_sno()+"' selected>"+((MngJob)vo).getJob_sname()+"</option>";
			}else{
				returnValue += "<option value='"+((MngJob)vo).getJob_sno()+"'>"+((MngJob)vo).getJob_sname()+"</option>";	
			}
		}
		response.getWriter().print(returnValue);
		return null;
	}
	 
	
	
	/**
	 * 
	 *  @Description    : 员工查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findEmp() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		SchoolService schoolService = (SchoolService)getBean("schoolService");
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	/*if (userInfo == null) {
			return "findEmp";
		}*/
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findEmpSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findEmpPage(form);
		MngSchoolForm school = new MngSchoolForm();
		udList = schoolService.findPage(school);
		return "findEmp";
		
	}
	

	/**
	 * 
	 *  @Description    : 单位查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findComp() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return "findComp";
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findCompSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findCompPage(form);
		return "findComp";
		
	}
	
	/**
	 * 单位放大镜
	 * @return
	 * @throws Exception
	 * @author luzong
	 */
	public String findUD()throws Exception{
		TreeService treeService =(TreeService) getBean("treeService");
		//判断form是否为空
		if(form==null){
			form=new TreeForm();
		}
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		/*if(userInfo==null){
			return "findUD";
		}*/
		
		// 初始化分页标签
		String page=request.getParameter("page");
		bean=new PageBean(treeService.findUdSize(form),PageBean.PAGE_SIZE);
		if(page!=null){
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList =treeService.findUD(form);
		return "findUD";
	}
	public String findUD1()throws Exception{
		TreeService treeService =(TreeService) getBean("treeService");
		//判断form是否为空
		String ud_sno1 = null;
		String ud_sno2 = null;
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		//最低的部门层次
		levels = treeService.findUDCount();
		if(ud_snos!=null){
			if(ud_snos.indexOf("-")>-1){
				String[] a = ud_snos.split("-");
				ud_sno1 = a[0];
				ud_sno2 = a[1];
				System.out.println(a[0]+","+a[1]);
			}else{
				ud_sno1 = ud_snos;
			}
		}
		//一级部门
		TreeForm form1 = new TreeForm();
		form1.setUd_nnumber("1");
		udList = treeService.findUD(form1);
		TreeForm form2 = new TreeForm();
		form2.setSearchC("1");
		treeList = treeService.findUD(form2);//除一级部门以外的所有部门
		if(ud_sno1!=null&&ud_sno2!=null){//去除没有设定的部门及其子部门
			for(Integer index = 0;index<treeList.size();index++){
				if(!ud_sno1.equals(((MngUnitDepart) treeList.get(index)).getUd_sno())&&
						(!ud_sno2.equals(((MngUnitDepart) treeList.get(index)).getUd_sno()))&&
						((MngUnitDepart) treeList.get(index)).getUd_nnumber()==2){
					//删除去所有的子部门
					TreeForm treeForm1 = new TreeForm();
					treeForm1.setUd_sno(((MngUnitDepart) treeList.get(index)).getUd_sno());
					List a = treeService.findSonUD(treeForm1);
					treeList.removeAll(a);
				}
			}
		}if(ud_sno1!=null&&ud_sno2==null){
			for(Integer index = 0;index<treeList.size();index++){//去除没有设定的部门
				if(!ud_sno1.equals(((MngUnitDepart) treeList.get(index)).getUd_sno())&&
						((MngUnitDepart) treeList.get(index)).getUd_nnumber()==2){
					//删除去所有的子部门
					TreeForm treeForm1 = new TreeForm();
					treeForm1.setUd_sno(((MngUnitDepart) treeList.get(index)).getUd_sno());
					List a = treeService.findSonUD(treeForm1);
					treeList.removeAll(a);
				}
			}
		}
		return "findUD1";
	}
	public String findSchool()throws Exception{
		TreeService treeService= (TreeService) getBean("treeService");
		//判断form是否为空
		if(form==null){
			form=new TreeForm();
		}
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		/*if(userInfo==null){
			return "findSchool";
		}*/
		
		//初始化分页标签
		String page=request.getParameter("page");
		bean=new PageBean(treeService.findSchoolSize(form),PageBean.PAGE_SIZE);
		if(page!=null){
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList=treeService.findSchool(form);
		return "findSchool";
	}
	public String findSchoolcheck()throws Exception{
		TreeService treeService= (TreeService) getBean("treeService");
		//判断form是否为空
		if(form==null){
			form=new TreeForm();
		}
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		/*if(userInfo==null){
			return "findSchool";
		}*/
		
		//初始化分页标签
		String page=request.getParameter("page");
		bean=new PageBean(treeService.findSchoolSize(form),PageBean.PAGE_SIZE);
		if(page!=null){
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList=treeService.findSchool(form);
		return "findSchoolcheck";
	}	
	 
	/**
	 * 
	 *  @Description    : 部门查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findDep() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return "findDep";
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findDepSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findDepPage(form);
		return "findDep";
		
	}
	/**
	 * 
	 *  @Description    : 岗位查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findJob() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	/*if (userInfo == null) {
			return "findJob";
		}*/
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findJobSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findJobPage(form);
		return "findJob";
		
	}
	 
	/**
	 * 
	 *  @Description    : 系统集成查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findSysint() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	/*if (userInfo == null) {
			return "findEmp";
		}*/
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findSysintSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findSysintPage(form);
		return "findSysint";
	}
	public String findSysint1() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		treeList = treeService.findSysintPage(form);
		System.out.println(treeList.size()+"进来没有");
		return "findSysint1";
	}
	/**
	 * 
	 *  @Description    : 功能查询并分页
	 *  @Method_Name    : find
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:58:42 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String findRight() throws Exception{
		TreeService treeService = (TreeService)getBean("treeService");//获取登陆接口LoginService对象
		//判断form表单是否为空
		if(form==null){
			form = new TreeForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	/*if (userInfo == null) {
			return "findEmp";
		}*/
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(treeService.findRightSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		treeList = treeService.findRightPage(form);
		return "findRight";
	}
	
	
}
