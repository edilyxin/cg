/**
 * 
 */
package com.rc.project.service;
import com.rc.project.form.EpMailForm;

/**
 * @author Administrator
 *
 */
public interface MailService {
	/**
	 * @param form
	 * @return
	 */
	public boolean insert(EpMailForm form) throws Exception;
	
	/**
	 * 发送电邮
	 * @param form
	 * @return
	 */
	public int sendMail(EpMailForm form) throws Exception;
}
