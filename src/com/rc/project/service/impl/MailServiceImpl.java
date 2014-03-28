/**
 * 
 */
package com.rc.project.service.impl;

import com.rc.project.dao.EpMailDAO;
import com.rc.project.form.EpMailForm;
import com.rc.project.service.MailService;

/**
 * @author Administrator
 *
 */
public class MailServiceImpl implements MailService {
	
	public static final int SENDMAIL_SECCUSS = 200;
	public static final int SENDMAIL_ERROR_NOSERVER = 101;

	private EpMailDAO epMailDAO;
	
	
	public void setEpMailDAO(EpMailDAO epMailDAO) {
		this.epMailDAO = epMailDAO;
	}
	/* (non-Javadoc)
	 * @see com.rc.project.service.MailService#insert(com.rc.project.form.EpMailForm)
	 */
	@Override
	public boolean insert(EpMailForm form) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int sendMail(EpMailForm form) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
 
}
