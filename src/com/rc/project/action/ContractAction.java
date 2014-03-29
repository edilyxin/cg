package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpContractForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.ContractService;
import com.rc.project.service.PackageService;
import com.rc.project.vo.EpContract;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class ContractAction extends BaseAction {
	private EpContractForm form;
	private EpContract vo;
	private ContractService contractService = (ContractService)getBean("contractService");
	private LogService log = (LogService)getBean("logService");
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
	
	public EpContract getVo() {
		return vo;
	}

	public void setVo(EpContract vo) {
		this.vo = vo;
	}

	public String toDetail(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.contractService.getDetailByPackage(ep_sno, bg_sno);
		return "detail";
	}
	
	public String toAdd(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		vo = this.contractService.getDetailByPackage(ep_sno, bg_sno);
//		System.out.println(vo.getCT_SNO());
		return "add";
	}
	
	public String add() throws IOException{
		UserInfo user = (UserInfo)this.session.get("userInfo");
		if(user == null)return ERROR;
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");
		System.out.println(form.getBG_SNO());
	 	if(form.getBG_SNO().equals("")){
	 		form.setBG_SNO(bg_sno);
		 	form.setEP_SNO(ep_sno);
	 		if(contractService.insert(form)){
				EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("添加合同信息");
				pService.submitCurrentProcess(this.request, process);
				message = "添加成功";
				log.logInsert(user, "添加合同", "ep_contract");			
			}
			else{
				message = "操作失败";
			}
	 	}
	 	else{
	 		if(contractService.updateContract(form)){
				EpProcessForm process=new EpProcessForm();
				process.setSS_SREMARK("修改合同信息");
				pService.submitCurrentProcess(this.request, process);
				message = "添加成功";
				log.logInsert(user, "修改合同", "ep_contract");			
			}
			else{
				message = "操作失败";
			}
	 	}
		System.out.println("履约金："+form.getCT_SISLYJ());
		System.out.println("质保金："+form.getCT_SISZBJ());
		
		return "add";
	}

	public EpContractForm getForm() {
		return form;
	}

	public void setForm(EpContractForm form) {
		this.form = form;
	}

	public ContractService getContractService() {
		return contractService;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
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
