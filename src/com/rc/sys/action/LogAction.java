package com.rc.sys.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.rc.sys.form.MngLogForm;
import com.rc.sys.service.LogService;
import com.rc.sys.vo.MngLog;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 日志管理ACTION
 * @author GK
 *
 */
public class LogAction extends BaseAction {
	private LogService logService = (LogService)getBean("logService");
	private MngLogForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngLog vo;//查询返回的VO

	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngLogForm();
			Date now =new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    String dateSign = sdf.format(now.getTime());
			form.setBeginDate(dateSign);
			form.setBeginTime("00:00:00");
			form.setEndDate(dateSign);
			form.setEndTime("23:59:59");
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(logService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = logService.findPage(form);
		return "find";
		
	}
 
	

	public MngLogForm getForm() {
		return form;
	}

	public void setForm(MngLogForm form) {
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

	public MngLog getVo() {
		return vo;
	}

	public void setVo(MngLog vo) {
		this.vo = vo;
	}

	
}
