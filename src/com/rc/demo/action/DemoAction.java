package com.rc.demo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.Demo1Form;
import com.rc.demo.form.DemoForm;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

public class DemoAction extends BaseAction {
	private List list;
	private DemoForm form;
	private PageBean bean;
	
	private void Init(){
		list = new ArrayList();
		for(int i=1;i<11;i++){
			form = new DemoForm();
			form.setField1("这是我的字段内容");
			form.setField2("吧唧吧唧");
			form.setField3("哦了哦了哦哦啊");
			Demo1Form d1form = new Demo1Form();
			d1form.setField1("f11111");
			form.setDemo1Form(d1form);
			list.add(form);
		}
		
		bean = new PageBean(list.size(),10);
	}
	
	public String find(){
		Init();
		
		return "find";
	}
	
	public String menu(){
		return "menu";
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String main(){
		Init();
		return "main";
	}
	
	public String add(){
		return this.find();
	}
	
	public String toUpdate(){return "update";}
	
	public String update(){
		return find();
	}
	
	public String toDelete(){
		return find();
	}
	
	/*
	 * 
	 * result true or false
	 */
	public String checkUnique() throws IOException{
		if(form.getField1().equals("1")){
			response.getWriter().print(true);
		}
		else{
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
