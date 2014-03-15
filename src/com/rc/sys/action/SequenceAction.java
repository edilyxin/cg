package com.rc.sys.action;

import java.util.List;

import com.rc.sys.form.MngSequenceForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.sys.vo.MngSequence;
import com.rc.sys.vo.MngTable;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 编码信息管理ACTION
 * @author GK
 *
 */
public class SequenceAction extends BaseAction {
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private LogService log = (LogService)getBean("logService");
	private MngSequenceForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngSequence vo;//查询返回的VO
	private MngTable form1;
	private String msg="";
	private boolean ok;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
/*	*//**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 *//*
	public String toAjax(){
		ok = sequenceService.checkOnly(msg);
		return "toAjax";
	}*/
	
	
	 
	//验证唯一性
	public String checkUnique() throws Exception{					
		form.setSeq_sname(serviceStr(form.getSeq_sname()));
		response.getWriter().print(sequenceService.checkOnly(form.getSeq_sname()));
		return null;
	}
	
	public String table()throws Exception{
		//判断form表单是否为空
		if(form1==null){
			form1 = new MngTable();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(sequenceService.findSize1(form1),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form1.setPageSQLA(bean.getPageSQLA());
		form1.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = sequenceService.findPage1(form1);
		return "table";
		
	}
	public String tableTree(){
		if(form1==null){
			form1 = new MngTable();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(sequenceService.findSize1(form1),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form1.setPageSQLA(bean.getPageSQLA());
		form1.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = sequenceService.findPage1(form1);
		return "tableTree";
	}
	public MngTable getForm1() {
		return form1;
	}
	public void setForm1(MngTable form1) {
		this.form1 = form1;
	}
	public String find() throws Exception{
		
		//判断form表单是否为空
		if(form==null){
			form = new MngSequenceForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(sequenceService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = sequenceService.findPage(form);
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
		form.setSeq_sreplyby(userInfo.getScreenname());
		boolean bl = sequenceService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增编码信息", "mng_sequence");
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
			vo = sequenceService.findByID(idchecked[0]);
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
		
		boolean bl = sequenceService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改编码信息", "mng_sequence");
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
		boolean bl =  sequenceService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除编码信息", "mng_sequence");
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
		boolean bl =  sequenceService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新编码信息状态", "mng_sequence");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	

	public MngSequenceForm getForm() {
		return form;
	}

	public void setForm(MngSequenceForm form) {
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

	public MngSequence getVo() {
		return vo;
	}

	public void setVo(MngSequence vo) {
		this.vo = vo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
