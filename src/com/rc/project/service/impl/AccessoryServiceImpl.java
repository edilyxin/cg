/**
 * 
 */
package com.rc.project.service.impl;

import com.rc.project.dao.EpAccessoryDAO;
import com.rc.project.form.EpAccessoryForm;
import com.rc.project.service.AccessoryService;

/**
 * @author Administrator
 *
 */
public class AccessoryServiceImpl implements AccessoryService {
	
	private EpAccessoryDAO epAccessoryDAO;
	
	public void setEpAccessoryDAO(EpAccessoryDAO dao){
		this.epAccessoryDAO = dao;
	}

	/**
	 * 
	 */
	public AccessoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.AccessoryService#insert(com.rc.project.form.EpAccessoryForm)
	 */
	@Override
	public boolean insert(EpAccessoryForm form) {
		// TODO Auto-generated method stub
		Object result = this.epAccessoryDAO.getSqlMapClientTemplate().insert("Ep_AccessoryForm_insert");
		return result == null?false:true;
	}

}
