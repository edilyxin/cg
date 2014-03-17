package com.rc.util;

import java.util.Date;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSender {
	
	private JavaMailSender sender;
	private SimpleMailMessage smm;
	
	
	
	public JavaMailSender getSender() {
		return sender;
	}



	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}
	
	/**
	 * html格式发电邮，未实现
	 * @param html
	 */
	public void sendHtmlEmail(String html){
		return ;
	}

	/**
	 * @param subject 主题
	 * @param from    发件人
	 * @param replyTo 回复地址
	 * @param to      收件人地址，字符数组
	 * @param text    发件内容
	 */
	public void sendTextEmail(String subject,String from,String replyTo, String[] to,String text){
		if (text == null||text.length()<=0){
			//没有正文不发电邮
			return;
		}
		smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setReplyTo(replyTo);
		smm.setFrom(from);
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText(text);
//		sender.send(new SimpleMailMessage(smm));
	} 



	public void main(String[] args){
		//测试用spring emailsender 发电邮
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/src/applicationContext.xml");
		
		
	}

}
