/**
 * 
 */
package com.rc.project.service.impl;

import java.util.List;

import com.rc.project.dao.EpPersonDAO;
import com.rc.project.form.EpPersonForm;
import com.rc.project.service.PersonService;
import com.rc.project.vo.EpPerson;

/**
 * @author Administrator
 *
 */
public class PersonServiceImpl implements PersonService {
	
	private EpPersonDAO epPersonDAO;
	
	public void setEpPersonDAO(EpPersonDAO epPersonDAO) {
		this.epPersonDAO = epPersonDAO;
	}

	public void setepPersonDAO(EpPersonDAO dao){
		this.epPersonDAO = dao;
	}

	/**
	 * 
	 */
	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#findSize(com.rc.project.form.EpPersonForm)
	 */
	@Override
	public int findSize(EpPersonForm form) {
		// TODO Auto-generated method stub
		return epPersonDAO.findSize(form);
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#findPage(com.rc.project.form.EpPersonForm)
	 */
	@Override
	public List findPage(EpPersonForm form) {
		// TODO Auto-generated method stub
		return epPersonDAO.findPage(form);
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#save(com.rc.project.form.EpPersonForm)
	 */
	@Override
	public boolean save(EpPersonForm form) {
		// TODO Auto-generated method stub
		return epPersonDAO.insert(form);
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#findById(int)
	 */
	@Override
	public EpPerson findById(int id) {
		// TODO Auto-generated method stub
		return epPersonDAO.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#delete(java.lang.String[])
	 */
	@Override
	public boolean delete(String[] checkedIds) {
		// TODO Auto-generated method stub
		return epPersonDAO.delete(checkedIds);
	}

	/* (non-Javadoc)
	 * @see com.rc.project.service.PersonService#changeValid(java.lang.String[])
	 */
	@Override
	public boolean changeValid(String[] checkedIds) {
		// TODO Auto-generated method stub
		return epPersonDAO.changeValid(checkedIds);
	}
	
	public boolean update(EpPersonForm form){
		return epPersonDAO.updateByPrimaryKey(form);
	}

}
