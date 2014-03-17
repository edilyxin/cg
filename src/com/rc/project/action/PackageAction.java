package com.rc.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

public class PackageAction extends BaseAction {
	private List list;
	private DemoForm form;
	private PageBean bean;

	private void Init() {
		list = new ArrayList();
		for (int i = 1; i < 11; i++) {
			form = new DemoForm();
			form.setField1("这是我的字段内容");
			form.setField2("吧唧吧唧");
			form.setField3("哦了哦了哦哦啊");
			list.add(form);
		}
		bean = new PageBean(list.size(), 10);
	}

	public String toSelectsupplier() throws IOException {
		return "selectsupplier";
	}
		
	public String findcollect() {
		return "findcollect";
	}
	
	public String findbit() {
		return "findbit";
	}
	
	public String menu() {
		return "menu";
	}	

	public String main() {
		Init();
		return "main";
	}	
	///////////////////招标采购/////////////////////////////
	
	public String toUpdateparameter(){
		return "updateparameter";
	}	
	
	public String updateparameter(){
		return this.findbit();
	}	

	public String splitPackage() {
		return this.findbit();
	}
	
	public String submitPackage() {
		return this.findbit();
	}
	
	public String deletePackage() {
		return this.findbit();
	}

	public String saveEntranceP(){
		return this.findbit();
	}
	
	
/////////////集中采购///////////////////	
	
	
	public String toAddcollectpackage(){
		return "addcollectpackage";
	}
	
	public String toCollectdetail(){
		return "collectdetail";
	}
	
	public String toCollectupdate(){
		return "collectupdate";
	}
	
	public String collectupdate(){
		return this.findcollect();
	}
	
	public String submitCollect(){
		return this.findcollect();
	}
	
	public String toAddPackageDetail(){
		return "addcollectpackage";
	}
	
	public String addPackageDetail(){
		return this.toCollectdetail();
	}
	
	public String toUpdatePackageDetail(){
		return "addcollectpackage";
	}
	
	public String deletePackageDetail(){
		return this.toCollectdetail();
	}	
	
	/*
	 * 
	 * result true or false
	 */
	public String checkUnique() throws IOException {
		if (form.getField1().equals("1")) {
			response.getWriter().print(true);
		} else {
			response.getWriter().print(false);
		}
		return null;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public DemoForm getForm() {
		return form;
	}

	public void setForm(DemoForm form) {
		this.form = form;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}
}
