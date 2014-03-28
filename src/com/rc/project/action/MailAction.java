package com.rc.project.action;

import java.io.IOException;

import com.rc.util.BaseAction;

public class MailAction extends BaseAction {
	
	public String toSendMail(){
		return "sendmail";
	}
	
	public String sendMail() throws IOException{
		String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);
		return null;
	}
}
