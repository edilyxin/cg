package com.rc.project.action;

import java.io.IOException;
import java.util.List;

import com.rc.project.form.EpProcessForm;
import com.rc.project.service.PackageService;
import com.rc.util.BaseAction;



public class SelectSupplierAction extends BaseAction {

	private List list;
	private PackageService pService = (PackageService)getBean("packageService");
	
	public String toselectsupplier(){
		return "selectsupplier";
	}
	
	public String selectsupplier(){
		return "selectsupplier";
	}
	
	public String save() throws IOException{
		
		
		
		
		EpProcessForm process=new EpProcessForm();
		process.setSS_SREMARK("选择了供应商信息");
		pService.submitCurrentProcess(this.request, process);
		
		String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);
		return null;
	}

}
