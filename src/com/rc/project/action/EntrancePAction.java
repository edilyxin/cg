package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.form.EpEntrancepForm;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpEntrancec;
import com.rc.project.vo.EpEntrancep;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

public class EntrancePAction extends BaseAction {
	private List list;
	private DemoForm form;
	private PageBean bean;
	private ProjectService projectService = (ProjectService) getBean("projectService");
	private EpEntrancep entrancep;
	
	private EpEntrancepForm entrancepForm;
	
	private List projectDetails;
	
	
	private String toMain() throws IOException {
		String EP_SNO = request.getParameter("EP_SNO");
		String path = request.getContextPath();
		String url = path + "/splite!find?EP_SNO=" + EP_SNO;
		this.response.sendRedirect(url);
		return null;
	}
	
	public String toAdd() {		
		String EP_SNO = request.getParameter("EP_SNO");
		entrancep = projectService.getEntranceP(EP_SNO);
		projectDetails=projectService.findBidProjectDetails(EP_SNO);
		return "add";
	}

	public String saveEntranceP() throws IOException {		
		projectService.saveEntranceP(entrancepForm);
		return toMain();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public DemoForm getForm() {
		return form;
	}

	public void setForm(DemoForm form) {
		this.form = form;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public EpEntrancep getEntrancep() {
		return entrancep;
	}

	public void setEntrancep(EpEntrancep entrancep) {
		this.entrancep = entrancep;
	}

	public EpEntrancepForm getEntrancepForm() {
		return entrancepForm;
	}

	public void setEntrancepForm(EpEntrancepForm entrancepForm) {
		this.entrancepForm = entrancepForm;
	}

	public List getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List projectDetails) {
		this.projectDetails = projectDetails;
	}

	
	
	
}
