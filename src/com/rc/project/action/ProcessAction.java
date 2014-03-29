package com.rc.project.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.service.PackageService;
import com.rc.project.service.ProcessService;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpSetting;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class ProcessAction extends BaseAction {
	private List list;
	private List packageDetailList;
	private EpProcess vo;
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getPackageDetailList() {
		return packageDetailList;
	}

	public void setPackageDetailList(List packageDetailList) {
		this.packageDetailList = packageDetailList;
	}

	private EpProcessForm form;
	// private PageBean bean;
	private PackageService service = (PackageService) getBean("packageService");
	private ProjectService projectService = (ProjectService)getBean("projectService");

	public String find() {
		if (form == null) {
			form = new EpProcessForm();
		}
		// 验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		// 初始化分页标签
		// String page = request.getParameter("page");
		// bean = new PageBean(service.findSize(form),
		// PageBean.PAGE_SIZE);
		// if (page != null) {
		// bean.setCurrentPage(Integer.parseInt(page));
		// }
		// 设置分页语句
		// form.setPageSQLA(bean.getPageSQLA());
		// form.setPageSQLB(bean.getPageSQLB());
		// 分页查询
		list = service.findPage();
		return "find";
	}

	public String toFirsttrial() {
		String BG_SNO = request.getParameter("bg_sno");
		packageDetailList = projectService.getListByBG(BG_SNO);
		return "firsttrial";
	}

	public String ok() {

		EpProcessForm process = new EpProcessForm();
		process.setSS_SREMARK("当前提交技术审核");
		UserInfo userInfo = (UserInfo)session.get("userInfo");
		process.setSS_SMAN(userInfo.getEmp_sname());
		process.setSS_TDATE(new Date(System.currentTimeMillis()));

		service.submitCurrentProcess(this.request, process);
		this.message = "提交成功";
		return this.toFirsttrial();
	}

	// 每一步回退
	public String back() {
		EpProcessForm process = new EpProcessForm();		
		process.setSS_SREMARK("退回操作");
		UserInfo userInfo = (UserInfo)session.get("userInfo");
		process.setSS_SMAN(userInfo.getEmp_sname());
		process.setSS_TDATE(new Date(System.currentTimeMillis()));
		service.backCurrentProcess(this.request, process);
		this.message = "退回成功";
		return this.find();
	}
	
	//集中采购分包在确定采购合同的回退，就直接删除包和历史记录
	public String backSubPackage(){
		projectService.backToSelect(request, null);
		return this.find();
	}

	public String firsttrial() {
		return this.ok();
		
	}
	
	public String skip(){
		this.service.skipProcess(this.request);		
		return this.find();
	}	

	public String toPrint() {
		return "print";
	}

	public String sendMail() {
		return this.find();
	}

	public String print() {
		return toFirsttrial();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public EpProcess getVo() {
		return vo;
	}

	public void setVo(EpProcess vo) {
		this.vo = vo;
	}

	public EpProcessForm getForm() {
		return form;
	}

	public void setForm(EpProcessForm form) {
		this.form = form;
	}

	public PackageService getService() {
		return service;
	}

	public void setService(PackageService service) {
		this.service = service;
	}

}
