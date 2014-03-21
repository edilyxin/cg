package com.rc.project.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectDeclareService;
import com.rc.sys.form.MngLogForm;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 项目定义管理
 * 
 * @author edilyxin
 * 
 */
public class ProjectDeclare extends BaseAction {

	private List list;
	private String msg;// 操作信息1
	private PageBean bean;// 分页标签类
	private RpReportBeginForm form; // 表单
	private ProjectDeclareService projectDeclareService = (ProjectDeclareService)getBean("projectDeclareService");

	/**
	 * 初申请管理查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception {
		// 判断form表单是否为空
		if (form == null) {
			form = new RpReportBeginForm();
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
		bean = new PageBean(projectDeclareService.findSize(form), PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		// 设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		list = projectDeclareService.findAndAuto(form);
		return "find";

	}
	
	/**
	 * 上传文件并且检查文件的合法性
	 * 如果不合法给出错误提示，如果合法，回写filename和filepath，以便后续的导入
	 * @return
	 * @throws Exception
	 */
	public String fileuploadAndCheck() throws Exception{
		//上传文件
		//检查文件合法新
		return "fileuploadAndCheck";
	}
	
	/**
	 * 在检验合法的情况下提交数据写库
	 * @return
	 */
	public String importData() throws Exception {
		UserInfo user = (UserInfo)this.session.get("userInfo");
		form.setRPB_SALTERBY(user.getEmp_sno());
		this.projectDeclareService.importData(form);
		return find();
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

	public RpReportBeginForm getForm() {
		return form;
	}

	public void setForm(RpReportBeginForm form) {
		this.form = form;
	}

	
	
	

}
