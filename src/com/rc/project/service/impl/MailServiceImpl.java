/**
 * 
 */
package com.rc.project.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.axis.utils.StringUtils;

import com.rc.project.dao.EpMailDAO;
import com.rc.project.form.EpMailForm;
import com.rc.project.service.MailService;
import com.rc.util.StringUtil;
import com.rc.util.mail.MailSenderInfo;
import com.rc.util.mail.SimpleMailSender;

/**
 * @author Administrator
 * 
 */
public class MailServiceImpl implements MailService {

	public static final int SENDMAIL_SECCUSS = 200;
	public static final int SENDMAIL_ERROR_NOSERVER = 101;

	private final String host = "mail.server.host";
	private final String port = "mail.server.port";
	private final String auth = "mail.smtp.auth";
	private final String user = "mail.send.user";
	private final String pswd = "mail.send.password";
	private final String useDefault = "mail.send.usedefault";

	private EpMailDAO epMailDAO;

	public void setEpMailDAO(EpMailDAO epMailDAO) {
		this.epMailDAO = epMailDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rc.project.service.MailService#insert(com.rc.project.form.EpMailForm)
	 */
	@Override
	public boolean insert(EpMailForm form) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int sendMail(EpMailForm form) throws Exception {
		// TODO Auto-generated method stub
		MailSenderInfo mail = form.getMailinfo();
		// 读取配置
		Properties props = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(this.getClass().getResource("/mail.properties").getPath()));
		props.load(in);
		in.close();
		mail.setMailServerHost(props.getProperty(this.host));
		mail.setMailServerPort(props.getProperty(this.port));
		if (StringUtils.isEmpty(mail.getFromAddress())) {
			// TODO 邮件格式也需要验证
			if (props.getProperty(useDefault).equalsIgnoreCase("true")) {
				mail.setFromAddress(props.getProperty(user));
			} else {
				throw new IllegalArgumentException("请填写发送地址");
			}
		}
		if (StringUtils.isEmpty(mail.getPassword())) {
			if (props.getProperty(useDefault).equalsIgnoreCase("true")) {
				mail.setPassword(props.getProperty(pswd));
			} else {
				throw new IllegalArgumentException("请填写邮箱密码");
			}
		}
		if (StringUtils.isEmpty(mail.getUserName())) {
			mail.setUserName(mail.getFromAddress().split("@")[0]);
		}
		if (StringUtils.isEmpty(mail.getToAddress())) {
			throw new IllegalArgumentException("请填目标地址");
		}
		mail.setValidate(props.get(this.auth).toString().equalsIgnoreCase("true") ? true : false);

		return (SimpleMailSender.sendHtmlMail(mail)) ? SENDMAIL_SECCUSS : SENDMAIL_ERROR_NOSERVER;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailServiceImpl mail = new MailServiceImpl();
		try {
			EpMailForm form = new EpMailForm();
			form.getMailinfo().setSubject("狠电邮-带附件");
			form.getMailinfo().setUserName("狠用户");
			form.getMailinfo().setToAddress("xiaoql@yeah.net");
			form.getMailinfo().setContent("<p>hi test!</p><p>这是一封蛮狠的电邮,带个附件哟</p>");
			String[] a = new String[1];
			a[0] = "D:\\temp\\采购数据表空间创建.sql";
			form.getMailinfo().setAttachFileNames(a);
			System.out.println(mail.sendMail(form));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
