package com.rc.project.action;

import java.util.Date;
import java.util.List;

import com.rc.project.form.EpPersonForm;
import com.rc.project.service.PersonService;
import com.rc.project.vo.EpPerson;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class PersonAction extends BaseAction
{
	private List list;
	private String message;
	private PageBean bean;
	private EpPersonForm form;
	private EpPerson vo;
	private LogService log = (LogService)getBean("logService");
	private PersonService personService = (PersonService)getBean("personService");
	
	public String list() {
		//判断form表单是否为空
		if(form==null){
			form = new EpPersonForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(personService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = personService.findPage(form);
		return "list";
	}
	
	public String toUpdate(){
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = personService.findById(Integer.parseInt(idchecked[0]));
			System.out.println(vo.getPER_NID());
		}
		return "update";
	}
	
	public String update(){
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean bl =  personService.update(form);
		if(bl==true){
			//log.logInsert(userInfo, "修改职称", "ep_setting");
		}else{
			this.message ="修改错误";
		}
		return this.list();
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String add(){
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
//		form.setSET_SISDEL("0");
//		form.setSET_SISVALID("0");
//		form.setSET_SREPLYBY(userInfo.getUsername());
//		form.setSET_SREPLYDATE(new Date(System.currentTimeMillis()));
	 	System.out.println(form.getUD_SNO());
	 	System.out.println(form.getUD_SNO1());
	 	System.out.println(form.getEMP_SNO());
	 	System.out.println(form.getPER_SREMARK());
		this.personService.save(form);
		return this.list();
	}
	
	public String toDelete(){
		//验证登陆session是否有效
				UserInfo userInfo=(UserInfo)session.get("userInfo");
				if (userInfo == null) {
					return ERROR;
				}
				String[] idchecked = request.getParameterValues("idcheckbox");
				boolean bl = personService.delete(idchecked);
				if(bl==true){
					message = "删除成功";
					log.logInsert(userInfo, "删除职称", "ep_setting");
				}else{
					message = "删除失败";
				}
		return this.list();
	}
	
	public String changeValid(){
		//验证登陆session是否有效
				UserInfo userInfo=(UserInfo)session.get("userInfo");
				if (userInfo == null) {
					return ERROR;
				}
				String[] idchecked = request.getParameterValues("idcheckbox");
				boolean bl = personService.changeValid(idchecked);
				if(bl==true){
					message = "更新成功";
					log.logInsert(userInfo, "更新职称状态", "ep_person");
				}else{
					message = "更新失败";
				}
				return this.list();
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PageBean getBean() {
		return bean;
	}
	public void setBean(PageBean bean) {
		this.bean = bean;
	}
	public EpPersonForm getForm() {
		return form;
	}
	public void setForm(EpPersonForm form) {
		this.form = form;
	}
	public EpPerson getVo() {
		return vo;
	}
	public void setVo(EpPerson vo) {
		this.vo = vo;
	}
	public LogService getLog() {
		return log;
	}
	public void setLog(LogService log) {
		this.log = log;
	}
	public PersonService getPersonService() {
		return personService;
	}
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	
	
}
