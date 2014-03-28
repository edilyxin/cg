package com.rc.project.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rc.base.form.MngPostForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.service.SettingService;
import com.rc.project.vo.EpSetting;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class ProcessSettingAction extends BaseAction {
	private List list;
	private PageBean bean;
	private EpSettingForm form;
	private EpSetting vo;
	private LogService log = (LogService)getBean("logService");
	private SettingService settingService = (SettingService)getBean("settingService");
	private String message;
	
	public String list(){
		//判断form表单是否为空
				if(form==null){
					form = new EpSettingForm();
				}
				//验证登陆session是否有效
				UserInfo userInfo = (UserInfo) session.get("userInfo");
			 	if (userInfo == null) {
					return ERROR;
				}
			 	//初始化分页标签
				String page = request.getParameter("page");
				bean = new PageBean(settingService.findSize(form),
						PageBean.PAGE_SIZE);
				if (page != null) {
					bean.setCurrentPage(Integer.parseInt(page));
				}
				//设置分页语句
				form.setPageSQLA(bean.getPageSQLA());
				form.setPageSQLB(bean.getPageSQLB());
				//分页查询
				list = settingService.findPage(form);
				return "list";
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String add(){
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		form.setSET_SISDEL("0");
		form.setSET_SISVALID("0");
		form.setSET_SREPLYBY(userInfo.getUsername());
		form.setSET_SREPLYDATE(new Date(System.currentTimeMillis()));
		if(this.settingService.save(form)){
			this.message = "添加成功";
			log.logInsert(userInfo, "添加采购流程", "ep_setting");
		}
		else{
			this.message = "操作失败";
		}
		return this.list();
	}
	
	public String toUpdate(){
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = settingService.findByID(idchecked[0]);
		}
		return "update";
	}
	
	public String update(){
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean bl =  settingService.update(form);
		if(bl==true){
			this.message = "修改成功";
			log.logInsert(userInfo, "修改采购流程", "ep_setting");
		}else{
			this.message = "操作失败";
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
				System.out.println(idchecked);
				boolean bl = settingService.changeValid(idchecked);
				if(bl==true){
					message = "更新成功";
					log.logInsert(userInfo, "更新职称状态", "ep_setting");
				}else{
					message = "更新失败";
				}
				return this.list();
	}
	
	public String toDelete(){
		//验证登陆session是否有效
				UserInfo userInfo=(UserInfo)session.get("userInfo");
				if (userInfo == null) {
					return ERROR;
				}
				String[] idchecked = request.getParameterValues("idcheckbox");
				boolean bl = settingService.delete(idchecked);
				if(bl==true){
					message = "删除成功";
					log.logInsert(userInfo, "删除职称", "ep_setting");
				}else{
					message = "删除失败";
				}
		return this.list();
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
	public EpSettingForm getForm() {
		return form;
	}
	public void setForm(EpSettingForm form) {
		this.form = form;
	}
	public EpSetting getVo() {
		return vo;
	}
	public void setVo(EpSetting vo) {
		this.vo = vo;
	}
	public LogService getLog() {
		return log;
	}
	public void setLog(LogService log) {
		this.log = log;
	}
	public SettingService getSettingService() {
		return settingService;
	}
	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
	
	
}
