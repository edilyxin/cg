package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpBidWinForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.BidWinService;
import com.rc.project.service.PackageService;
import com.rc.project.vo.EpBidWin;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class BidWinAction extends BaseAction {
	private EpBidWinForm form;
	private EpBidWin vo;
	private BidWinService bidWinService = (BidWinService)getBean("bidWinService");
	private LogService log= (LogService)getBean("logService");
	private PackageService pService = (PackageService)getBean("packageService");
	private String message;
	
	
	public EpBidWin getVo() {
		return vo;
	}

	public void setVo(EpBidWin vo) {		
		this.vo = vo;
	}
	
	public String toDetail(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.bidWinService.getDetailByPackage(ep_sno, bg_sno);
		return "detail";
	}

	public String toAdd(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.bidWinService.getDetailByPackage(ep_sno, bg_sno);
		return "add";
	}
	
	public String add() throws IOException{
		UserInfo user = (UserInfo)session.get("userInfo");
		if( user == null){
			return ERROR;
		}
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		form.setBG_SNO(bg_sno);
	 	form.setEP_SNO(ep_sno);
	 	//vo = this.bidWinService.getDetailByPackage(ep_sno, bg_sno);
	 	if(form.getEBW_NID() == null){
	 		if(bidWinService.insert(form)){
				EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("中标公示");
				pService.submitCurrentProcess(this.request, process);
				log.logInsert(user, "添加招标结果", "ep_bidwin");
			}
	 	}
	 	else {
	 		form.setEBW_NID(vo.getEBW_NID());
	 		if(bidWinService.updateBidWin(form)){
	 			EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("中标公示");
				pService.submitCurrentProcess(this.request, process);
				log.logInsert(user, "修改招标结果", "ep_bidwin");
	 		}
	 	}
		String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);
		return null;
	}

	public EpBidWinForm getForm() {
		return form;
	}

	public void setForm(EpBidWinForm form) {
		this.form = form;
	}

	public BidWinService getBidWinService() {
		return bidWinService;
	}

	public void setBidWinService(BidWinService bidWinService) {
		this.bidWinService = bidWinService;
	}

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
