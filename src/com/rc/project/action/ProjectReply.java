package com.rc.project.action;

import java.util.ArrayList;
import java.util.List;

import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpProjectForm;
import com.rc.project.service.ProjectReplyService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 项目定义管理
 * 
 * @author edilyxin
 * 
 */
public class ProjectReply extends BaseAction {

	private List list;
	private String msg;             // 操作信息1
	private PageBean bean;          // 分页标签类
	private EpProjectForm form;     // 参数form
	private ProjectReplyService projectReplyService = (ProjectReplyService)getBean("projectReplyService");
	

	/**
	 * 批复主表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findForAuto() throws Exception {
		return "findForAuto";

	}

	/**
	 * 批复明细表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findDetailForAuto() throws Exception {
		return "findDetailForAuto";
	}

	/**
	 * 导入列表和明细表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importData() throws Exception {
		//写死的文件路径
		final String filePath = "";
		UserInfo user = (UserInfo)this.session.get("userInfo");
		//TODO form 为null
		form = new EpProjectForm();
		form.setEP_SALTERBY(user.getEmp_sno());
		this.projectReplyService.importData(form);
		return findForAuto();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public EpProjectForm getForm() {
		return form;
	}

	public void setForm(EpProjectForm form) {
		this.form = form;
	}
	
	

	

}
