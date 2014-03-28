package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpProjectForm;
import com.rc.project.service.ProjectDetailService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class ProjectDetailAction extends BaseAction {

	private List list;
	private EpProjectDetailForm form;
	private PageBean bean;
	private ProjectDetailService service = (ProjectDetailService)getBean("projectDetailService");
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String find() {
		if(form==null){
			form = new EpProjectDetailForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(service.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = service.findPage(form);
		return "find";
	}	
	public String save(){
		if(form==null){
			System.out.println("save form is null");
			form = new EpProjectDetailForm();
		}
		System.out.println(form.getEPD_SPURTYPE());
		System.out.println(request.getParameterValues("idcheckbox")[0]);
		service.updatePurtType(Integer.valueOf(form.getEPD_SPURTYPE()), request.getParameterValues("idcheckbox"));
		return this.find();
	}
	
	
	public ProjectDetailService getService() {
		return service;
	}



	public void setService(ProjectDetailService service) {
		this.service = service;
	}



	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public EpProjectDetailForm getForm() {
		return form;
	}

	public void setForm(EpProjectDetailForm form) {
		this.form = form;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

}
