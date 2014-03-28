package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpBidForm;
import com.rc.project.form.EpPayMoneyForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.BidService;
import com.rc.project.service.PackageService;
import com.rc.project.service.PayMoneyService;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpPayMoney;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class PayMoneyAction extends BaseAction {
	
	private EpPayMoneyForm form;
	private EpPayMoney vo;
	public EpPayMoney getVo() {
		return vo;
	}


	public void setVo(EpPayMoney vo) {
		this.vo = vo;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public String getMessage() {
		return message;
	}

	private LogService log = (LogService)getBean("logService");
	private PayMoneyService service = (PayMoneyService)getBean("payMoneyService");
	private PackageService pService = (PackageService)getBean("packageService");
	private String message;
	private List list;
	
	public String toDetail(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");		
		if(vo == null){
			vo = new EpPayMoney();
			vo.setBG_SNO(bg_sno);
			vo.setEP_SNO(ep_sno);
			
		}
		list = this.service.getListDetailByPackage(ep_sno, bg_sno);
		System.out.println(list.size());
		if(list != null && list.size()>=1){
			vo = (EpPayMoney) list.get(0);
		}
		return "detail";
	}
	
	
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
	
	public String pay() throws IOException{
		UserInfo user = (UserInfo)this.session.get("userInfo");
		if(user == null)return ERROR;
		form.setBG_SNO(this.request.getParameter("bg_sno"));
	 	form.setEP_SNO(this.request.getParameter("ep_sno"));
		if(service.save(form)){
			EpProcessForm process=new EpProcessForm();
			process.setSS_SREMARK("中标公示");
			pService.submitCurrentProcess(this.request, process);
			message = "添加成功";
			log.logInsert(user, "添加合同", "ep_contract");
		}
		else{
			message = "操作失败";
		}
		String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);
		return null;
	}
	
	public String receive() throws IOException{
		UserInfo user = (UserInfo)this.session.get("userInfo");
		if(user == null)return ERROR;
		form.setBG_SNO(this.request.getParameter("bg_sno"));
	 	form.setEP_SNO(this.request.getParameter("ep_sno"));
		if(service.save(form)){
			EpProcessForm process=new EpProcessForm();
			process.setSS_SREMARK("中标公示");
			pService.submitCurrentProcess(this.request, process);
			message = "添加成功";
			log.logInsert(user, "添加合同", "ep_contract");			
		}
		else{
			message = "操作失败";
		}
		String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);
		return null;
	}
		
	//应付
	public String toAddpayable() {
		String ep_sno = this.request.getParameter("bg_sno");
		String bg_sno =this.request.getParameter("ep_sno");
		list = this.service.getListDetailByPackage(ep_sno, bg_sno);
		return "addpayable";
	}
	
	//应收
	public String toAddreceivable() {
		String ep_sno = this.request.getParameter("bg_sno");
		String bg_sno =this.request.getParameter("ep_sno");
		list = this.service.getListDetailByPackage(ep_sno, bg_sno);
		return "addreceivable";
	}
	
	
	
	

	public void setForm(EpPayMoneyForm form) {
		this.form = form;
	}


	public void setLog(LogService log) {
		this.log = log;
	}


	public void setService(PayMoneyService service) {
		this.service = service;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public EpPayMoneyForm getForm() {
		return form;
	}
	
	
	
}
