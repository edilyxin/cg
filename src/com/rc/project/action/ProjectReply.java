package com.rc.project.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpProjectForm;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectReplyService;
import com.rc.project.vo.EpProjectDetail;
import com.rc.util.BaseAction;
import com.rc.util.DateUtils;
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
	private List details; // 详细信息
	private String msg; // 操作信息1
	private PageBean bean; // 分页标签类
	private EpProjectForm form; // 参数form
	private ProjectReplyService projectReplyService = (ProjectReplyService) getBean("projectReplyService");
	private File myfile;// 上传文件
	private String myfileFileName;// 文件名

	private String detPunit; // 详细项目单位
	private String detPname; // 详细项目名称
	private String detPcode; // 详细项目代码

	/**
	 * 批复主表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findForAuto() throws Exception {
		if (form == null) {
			form = new EpProjectForm();
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateSign = sdf.format(now.getTime());
			form.setSearchE(dateSign);
			form.setSearchF(dateSign);
		}
		// 验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		// 初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(projectReplyService.findSize(form), PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		// 设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		list = projectReplyService.findForAuto(form);

		return "findForAuto";

	}

	/**
	 * 批复明细表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findDetailForAuto() throws Exception {
		String sno = this.request.getParameter("sno");
		if (StringUtils.isNotEmpty(sno)) {
			EpProjectDetailForm f = new EpProjectDetailForm();
			f.setEP_SNO(sno);
			details = projectReplyService.findDetailForAuto(f);
			if (details.size() > 1) {
				setDetPunit(((EpProjectDetail) details.get(0)).getEPD_SREPORTUNITNAME());
				setDetPname(projectReplyService.findProjectByNo(((EpProjectDetail) details.get(0)).getRP_SNO()).getRP_SPROJECTNAME());
				setDetPcode(((EpProjectDetail) details.get(0)).getEPD_SASKNO());
			}
		}
		return "findDetailForAuto";
	}

	/**
	 * 上传并且导入列表和明细
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (form == null) {
			form = new EpProjectForm();
			// form.setSearchE(getStartDate(date));
		}
		response.setContentType("text/html;charset=utf-8");
		try {
			UserInfo user = (UserInfo) this.session.get("userInfo");
			form.setEP_SALTERBY(user.getEmp_sno());
			form.setFileName(this.myfileFileName);
			form.setFilePath(this.myfile.toString());
			System.out.println("filepath : " + this.myfile);
			System.out.println("filename : " + this.myfileFileName);
			System.out.println("isall : " + form.isAll());
			this.projectReplyService.importData(form);
			String returnValue = "导入成功了！";

			// 验证文件
			// 同年度，同名称的项目只能存在一个

			response.getWriter().print(returnValue);
		} catch (IllegalStateException e) {
			response.getWriter().print("错误 :" + e.getMessage());
		}
		return null;
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

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public ProjectReplyService getProjectReplyService() {
		return projectReplyService;
	}

	public void setProjectReplyService(ProjectReplyService projectReplyService) {
		this.projectReplyService = projectReplyService;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public List getDetails() {
		return details;
	}

	public void setDetails(List details) {
		this.details = details;
	}

	public String getDetPunit() {
		return detPunit;
	}

	public void setDetPunit(String detPunit) {
		this.detPunit = detPunit;
	}

	public String getDetPname() {
		return detPname;
	}

	public void setDetPname(String detPname) {
		this.detPname = detPname;
	}

	public String getDetPcode() {
		return detPcode;
	}

	public void setDetPcode(String detPcode) {
		this.detPcode = detPcode;
	}

}
