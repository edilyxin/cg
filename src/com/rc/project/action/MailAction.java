package com.rc.project.action;

import java.io.IOException;
import java.util.Date;

import com.rc.project.form.EpMailForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.MailService;
import com.rc.project.service.PackageService;
import com.rc.project.vo.EpMail;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;

public class MailAction extends BaseAction {
	
	private String message;
	private EpMail vo;
	private EpMailForm form;
	private LogService log = (LogService)getBean("logService");
	private PackageService pService = (PackageService)getBean("packageService");
	private MailService mService = (MailService)getBean("mailService");
	
	public String toSendMail(){
		return "sendmail";
	}
	
	public String toMail(){
		return "mail";
	}
	
	public String sendMail() throws Exception{
		UserInfo userInfo = (UserInfo)session.get("userInfo");
		if(mService.insert(form) == true){
			EpProcessForm process=new EpProcessForm();
			process.setSS_SREMARK("发送邮件");
			process.setSS_SMAN(userInfo.getEmp_sname());
			process.setSS_TDATE(new Date(System.currentTimeMillis()));
			pService.submitCurrentProcess(this.request, process);
			this.message = "添加成功";
			log.logInsert(userInfo, "添加招标公示", "Ep_Bid");
		}
		else{
			this.message = "操作失败";
		}
		return "mail";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EpMail getVo() {
		return vo;
	}

	public void setVo(EpMail vo) {
		this.vo = vo;
	}

	public EpMailForm getForm() {
		return form;
	}

	public void setForm(EpMailForm form) {
		this.form = form;
	}
	
	
}
