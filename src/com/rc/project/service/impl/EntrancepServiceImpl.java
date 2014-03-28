/**
 * 
 */
package com.rc.project.service.impl;

import com.rc.project.dao.EpEntrancepDAO;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.form.EpEntrancepForm;
import com.rc.project.service.EntrancecService;
import com.rc.project.service.EntrancepService;

/**
 * @author Administrator
 *
 */
public class EntrancepServiceImpl implements EntrancepService {
	
	private EpEntrancepDAO epEntrancepDAO;

	public void setEpEntrancepDAO(EpEntrancepDAO epEntrancepDAO) {
		this.epEntrancepDAO = epEntrancepDAO;
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.EntrancecService#Insert(com.rc.project.form.EpEntrancecForm)
	 */
	@Override
	public boolean insert(EpEntrancepForm form) {
		// TODO Auto-generated method stub
		return false;
	}

}
