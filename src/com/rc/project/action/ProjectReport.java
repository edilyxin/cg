package com.rc.project.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rc.project.form.RpReportBeginForm;
import com.rc.project.form.RpReportForm;
import com.rc.project.service.ProjectReportService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 项目定义管理
 * 
 * @author edilyxin
 * 
 */
public class ProjectReport extends BaseAction {

	private List list;
	private String msg;// 操作信息1
	private PageBean bean;// 分页标签类
	private RpReportForm form;
	private File myfile;// 上传文件
	private String myfileFileName;// 文件名
	private String year; // 年份
	
	

	private ProjectReportService projectReportService = (ProjectReportService) getBean("projectReportService");

	/**
	 * 初申请管理查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAndAuto() throws Exception {
		if(form ==null){
			form = new RpReportForm();
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateSign = sdf.format(now.getTime());
			form.setSearchF(dateSign);
			form.setSearchG(dateSign);
			}
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String page = request.getParameter("page");
		bean = new PageBean(projectReportService.findSize(form), PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		// 设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		list = this.projectReportService.findPage(form);
		return "findAndAuto";

	}

	/**
	 * 上传入口
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		try {
			System.out.println("year : " + form.getYear());
			UserInfo user = (UserInfo) this.session.get("userInfo");
			form.setRP_SREPLYBY(user.getEmp_sno());
			form.setFileName(this.myfileFileName);
			form.setFilePath(this.myfile.toString());
			form.setRP_SYEAR(form.getYear());
			this.projectReportService.importData(form);
			String returnValue = "导入成功了！";
			System.out.println("filepath : " + this.myfile);
			System.out.println("filename : " + this.myfileFileName);
			response.getWriter().print(returnValue);
		} catch (IllegalStateException e) {
			response.getWriter().print("错误 :" + e.getMessage());
		}
		return null;

	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public RpReportForm getForm() {
		return form;
	}

	public void setForm(RpReportForm form) {
		this.form = form;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	

}
