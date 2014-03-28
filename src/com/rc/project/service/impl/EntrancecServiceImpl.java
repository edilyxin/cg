/**
 * 
 */
package com.rc.project.service.impl;

import com.rc.project.dao.EpEntrancecDAO;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.service.EntrancecService;

/**
 * @author Administrator
 *
 */
public class EntrancecServiceImpl implements EntrancecService {
	private EpEntrancecDAO epEntrancecDAO;

	public void setEpEntrancecDAO(EpEntrancecDAO epEntrancecDAO) {
		this.epEntrancecDAO = epEntrancecDAO;
	}

	@Override
	public boolean insert(EpEntrancecForm form) {
		// TODO Auto-generated method stub
		return false;
	}

}
