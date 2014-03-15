package com.rc.base.action;


import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngEmpUserForm;
import com.rc.base.form.MngUnitDepartForm;

import com.rc.sys.form.MngUserForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;

import com.rc.sys.vo.MngUser;
import com.rc.base.service.EmpService;
import com.rc.base.vo.MngEmp;
import com.rc.util.BaseAction;
import com.rc.util.StringUtil;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 职工管理ACTION
 * @author GK
 *
 */
public class EmpAction extends BaseAction {
	private EmpService empService = (EmpService)getBean("empService");
	private LogService log = (LogService)getBean("logService");
	private MngEmpForm form; //form表单
	private MngEmpUserForm form1;
	private MngUserForm userform;
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngEmp vo;//查询返回的VO
	private String menu;//下拉菜单传值控制
	private List<MngUser> list1;//查询所有用户
	private List<MngUser> list2;//查询职工所拥有的用户
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private String message;
	private MngUnitDepartForm udform;
	private List udlist;
	private List udlistno;
	private Integer levels;//最低的部门层次
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		
		//判断form表单是否为空
		if(form==null){
			form = new MngEmpForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(empService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句 
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());

		//分页查询
		list = empService.findPage(form);
         
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
	 
		return "add";
		
	}

	/**
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
	 
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "1", "emp_sno");
		form.setEmp_sno(no);
		boolean bl = empService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增职工", "mng_emp");
		}else{
			message = "新增失败";
		}
		
		return find();
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = empService.findByID(idchecked[0]);
		}
		 
		return "update";
	}

	/**
	 * 修改保存
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean bl = empService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改职工", "mng_emp");
		}else{
			message = "修改失败";
		}
		
		return find();
		
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String toDelete() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl =  empService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除职工", "mng_emp");
		}else{
			message = "删除失败";
		}
		
		return find();
	}
	
	/**
	 * 有效/无效
	 * @return
	 * @throws Exception
	 */
	public String changeValid() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl =  empService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新职工状态", "mng_emp");
		}else{
			message = "更新失败";
		}
		
		
		return find();
	}
	
	
	public String exportExcel() throws Exception {
		//判断form表单是否为空
		if(form==null){
			form = new MngEmpForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}

		//按条件查询
		List allList = empService.findPage(form);
		empService.exportExcel(allList,response);
		return null;
	}
	
 
	/**
	 * 新增用户页面跳转
	 * @return
	 */
	public String adduser(){
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = empService.findByID(idchecked[0]);
		}
		
		return "adduser";
		
	}
	/**
	 * 新增用户和用户职工
	 * @return
	 * @throws Exception
	 */
	public String insertuser() throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		
		//MD5加密
		if(userform!=null){
			String pwd=userform.getPassword();
			if(pwd==null||"".equals(pwd)){
				message="密码不能为空！";
				return adduser();
			}else{
				pwd=StringUtil.MD5Encode(pwd);
				userform.setPassword(pwd);
			}
		}
		
		String  userid = empService.adduser(userform);
		log.logInsert(userInfo, "新增用户", "mng_emp");
		if(form1==null){
			form1= new MngEmpUserForm();
		}
	 
		form1.setUserid(userid);
		empService.saveEuser(form1);
		log.logInsert(userInfo, "新增职工用户", "mng_empuser");
		return find();
	 
	 }
	
	/**
	 * 查询职工与用户的对照
	 * @return
	 */
	public String findempuesr(){

		//判断form表单是否为空
		if(form==null){
			form= new MngEmpForm();
		}
		
	   
		String 	empsno = request.getParameter("empsno");
	 
	   if(form1==null){
			form1= new MngEmpUserForm();
		}
	   if(form1.getEmp_sno()!=null){
		   empsno=form1.getEmp_sno();
	   }
	   form.setEmp_sno(empsno);
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(empService.empuserfindsize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());

		//分页查询
	  
		list = empService.empuserfindpage(form);
        
		 
		
		return "userfind";
		
	}
	
	/**
	 * 删除职工用户
	 * @return
	 * @throws Exception
	 */
	public String Delete() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		String  sno=request.getParameter("emp_sno");
		empService.deleteuseremp(idchecked);
		if(form!=null){
			form=new MngEmpForm();
		}
		 
		log.logInsert(userInfo, "删除职工", "mng_useremp");
		 return findempuesr();
	}
	/**
	 * 新增职工用户跳转
	 * @return
	 */
	public String saveempuser(){
		String empsno=request.getParameter("saveempuser");
		return "addempuser";
		
	}
	/**
	 * 新增职工用户
	 * @return
	 * @throws Exception
	 */
	
	 public String saveempuser1() throws  Exception{
			//验证登陆session是否有效
			UserInfo userInfo = (UserInfo) session.get("userInfo");
		 	if (userInfo == null) {
				return ERROR;
			}
			empService.saveempuser(form1);
		  	return findempuesr();
		 
		 
	 }
	 
	 public String udfind() throws Exception{
		 levels = empService.levels();
		 udlist = empService.udlist(udform);
		 return "tree";
	 }
	 
	public MngEmpForm getForm() {
		return form;
	}

	public void setForm(MngEmpForm form) {
		this.form = form;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public MngEmp getVo() {
		return vo;
	}

	public void setVo(MngEmp vo) {
		this.vo = vo;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}


	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public SequenceService getSequenceService() {
		return sequenceService;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	public MngUserForm getUserform() {
		return userform;
	}

	public void setUserform(MngUserForm userform) {
		this.userform = userform;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MngEmpUserForm getForm1() {
		return form1;
	}

	public void setForm1(MngEmpUserForm form1) {
		this.form1 = form1;
	}

	public List<MngUser> getList1() {
		return list1;
	}

	public void setList1(List<MngUser> list1) {
		this.list1 = list1;
	}

	public List<MngUser> getList2() {
		return list2;
	}

	public void setList2(List<MngUser> list2) {
		this.list2 = list2;
	}

	public MngUnitDepartForm getUdform() {
		return udform;
	}

	public void setUdform(MngUnitDepartForm udform) {
		this.udform = udform;
	}

	public List getUdlist() {
		return udlist;
	}

	public void setUdlist(List udlist) {
		this.udlist = udlist;
	}

	public List getUdlistno() {
		return udlistno;
	}

	public void setUdlistno(List udlistno) {
		this.udlistno = udlistno;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	
}
