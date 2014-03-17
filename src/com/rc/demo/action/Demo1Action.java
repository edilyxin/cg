package com.rc.demo.action;

import java.io.IOException;

import com.rc.util.BaseAction;

public class Demo1Action extends BaseAction {
	
	public String toAdd(){
		return "toAdd";
	}
	
	public String add() throws IOException{
		String path = request.getContextPath();
		String url = path+"/demo!find";
		this.response.sendRedirect(url);
		return null;
	}
}
