package com.rc.base.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.rc.base.form.MngJobForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.service.JobService;
import com.rc.base.vo.MngJob;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 岗位管理ACTION
 * @author GK
 *
 */
public class JobAction extends BaseAction {
	private JobService jobService = (JobService)getBean("jobService");
	private LogService log = (LogService)getBean("logService");
	private MngJobForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngJob vo;//查询返回的VO
	private String ok;
	private List list1;//遍历级别
	private List list2;//遍历所有一级单位
	private String menu;//下拉菜单传值控制
	private MngUnitDepartForm departForm;
	private Integer JobLevel;
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngJobForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(jobService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list1=jobService.findNlevel(form);
		list = jobService.findPage(form);
		
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		form.setUd_sno("");
		form.setUd_sname("");
		list2=jobService.findUdSname(departForm);
		System.out.println("list2.size()="+list2.size());
		return "add"; 
	}
	public String find1(){
		System.out.println("form.getJob_stype()="+form.getJob_stype());
		JobLevel=jobService.findMaxNLevel(form.getJob_stype());
		return "find1";
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
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "job_sno");
		form.setJob_sno(no);
		boolean bl = jobService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增岗位", "mng_job");
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
			vo = jobService.findByID(idchecked[0]);
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
		boolean bl = jobService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改岗位", "mng_job");
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
		boolean bl = jobService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除岗位", "mng_job");
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
		boolean bl = jobService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新岗位状态", "mng_job");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	//新增的时候检查唯一性 job_sno

	public String findJobSname()throws Exception{
		System.out.println("form.getUd_sno()="+form.getUd_sno());
		System.out.println("form.getJob_sname()="+form.getJob_sname());
		list = jobService.findAllSname(form);
		System.out.println(list.size());
		if(list.size()<=0){
			
			ok="1";
			
		}else{
			ok="";
			
		}
		return "findJobSname";
	}
	
	public String checkUnique() throws Exception{
		String linename = new String(request.getParameter("form.job_sname").getBytes("ISO-8859-1"),"UTF-8");
		form.setJob_sname(linename);
		System.out.println(form.getJob_sname());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jobService.checkUnique(form));
		return null;
	}
	
	
	public String exportExcel() throws Exception {
		//判断form表单是否为空
		if(form==null){
			form = new MngJobForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}

		//按条件查询
		List allList = jobService.findPage(form);
		jobService.exportExcel(allList,response);
		return null;
	}
	//数据.....够
	public String toMenuUD() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//查询1级单位部门列表
	 	List udList = jobService.findTreeList();
	 	List udList1 =jobService.findAlljob();
	 	ActionContext.getContext().getValueStack().set("udList", udList);
	 	ActionContext.getContext().getValueStack().set("udList1", udList1);
	 	return "toMenuUD";
	}
	
	
	

	public MngJobForm getForm() {
		return form;
	}

	public void setForm(MngJobForm form) {
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

	public MngJob getVo() {
		return vo;
	}

	public void setVo(MngJob vo) {
		this.vo = vo;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public List getList2() {
		return list2;
	}

	public void setList2(List list2) {
		this.list2 = list2;
	}

	public MngUnitDepartForm getDepartForm() {
		return departForm;
	}

	public void setDepartForm(MngUnitDepartForm departForm) {
		this.departForm = departForm;
	}

	public Integer getJobLevel() {
		return JobLevel;
	}

	public void setJobLevel(Integer jobLevel) {
		JobLevel = jobLevel;
	}

	
}
