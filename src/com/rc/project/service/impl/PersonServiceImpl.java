/**
 * 
 */
package com.rc.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.rc.base.dao.EmpDAO;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.base.vo.MngEmp;
import com.rc.base.vo.MngUnitDepart;
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
	private UnitDepartDAO unitDepartDAO;
	private EmpDAO empDAO;
	
	
	
	public UnitDepartDAO getUnitDepartDAO() {
		return unitDepartDAO;
	}

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}

	public EmpDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

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
		List list = epPersonDAO.findPage(form);
		for (Object o : list) {
			EpPerson p = (EpPerson)o;
			setEmpAndDepart(p);
		}
		return list;
	}
	
	private void setEmpAndDepart(EpPerson p){
		MngEmp emp = this.empDAO.findByNo(p.getEMP_SNO());
		MngUnitDepart depart = this.unitDepartDAO.findByNo(p.getUD_SNO());
		p.setEmp(emp);
		p.setDepart(depart);
		String departName="";
		String[] uds = p.getUD_SNO1().split(",");
		List departList = new ArrayList();
		for (int i = 0; i < uds.length; i++) {
			MngUnitDepart depart1 = this.unitDepartDAO.findByNo(uds[i]);
			if(i==uds.length-1){
				departName += depart1.getUd_sname();
			}
			else{
				departName += depart1.getUd_sname()+",";
			}			
			departList.add(depart1);
		}
		p.setDepart2(departList);
		p.setDepartName(departName);
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
		EpPerson p= epPersonDAO.selectByPrimaryKey(id);
		if(p!=null){
			setEmpAndDepart(p);
		}
		return p;
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
