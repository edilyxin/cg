package com.rc.project.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rc.project.form.EpBidForm;
import com.rc.project.form.EpProcessForm;
import com.rc.sys.service.LogService;
import com.rc.project.service.BidService;
import com.rc.project.service.PackageService;
import com.rc.project.vo.EpBid;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;

public class BidAction extends BaseAction {
	private EpBidForm form;
	private EpBid vo;	
	public EpBid getVo() {
		return vo;
	}

	public void setVo(EpBid vo) {
		this.vo = vo;
	}
	private LogService log = (LogService)getBean("logService");
	private BidService bidService = (BidService)getBean("bidService");
	private PackageService pService = (PackageService)getBean("packageService");
	private String message;
	
	public void addActionError(String anErrorMessage){
		   String s=anErrorMessage;
		   System.out.println(s);
		  }
		  public void addActionMessage(String aMessage){
		   String s=aMessage;
		   System.out.println(s);
		  
		  }
		  public void addFieldError(String fieldName, String errorMessage){
		   String s=errorMessage;
		   String f=fieldName;
		   System.out.println(s);
		   System.out.println(f);
		  
		  }
	
	public String toDetail(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.bidService.getBidByPackage(ep_sno, bg_sno);
		System.out.println(vo);
		return "detail";
	}
	
	public String toAdd(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.bidService.getBidByPackage(ep_sno, bg_sno);
		return "add";
	}
	
	public String add() throws IOException{
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");	

		form.setBG_SNO(bg_sno);
	 	form.setEP_SNO(ep_sno);
		if(form.getEB_NID() == null){			
			if(bidService.insert(form) == true){
				EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("提交公示");
				pService.submitCurrentProcess(this.request, process);
				this.message = "添加成功";
				log.logInsert(userInfo, "添加招标公示", "Ep_Bid");
			}
			else{
				this.message = "操作失败";
			}
		}
		else{
			//form.setEB_NID(vo.getEB_NID());
			if(bidService.updateBid(form)){
				EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("提交公示");
				pService.submitCurrentProcess(this.request, process);
				this.message = "修改成功";
				log.logInsert(userInfo, "修改招标公示", "Ep_Bid");
			}
		}
		return "add";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public EpBidForm getForm() {
		return form;
	}
	public void setForm(EpBidForm form) {
		this.form = form;
	}
	public LogService getLog() {
		return log;
	}
	public void setLog(LogService log) {
		this.log = log;
	}
	public BidService getBitService() {
		return bidService;
	}
	public void setBitService(BidService bidService) {
		this.bidService = bidService;
	}
	
	
	
}
