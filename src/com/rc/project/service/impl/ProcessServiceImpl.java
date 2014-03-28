package com.rc.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.rc.project.dao.EpProcessDAO;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.ProcessService;
import com.rc.project.vo.EpProcess;

public class ProcessServiceImpl implements ProcessService {
	
	private EpProcessDAO epProcessDAO;

	public void setEpProcessDAO(EpProcessDAO epProcessDAO) {
		this.epProcessDAO = epProcessDAO;
	}

	@Override
	public EpProcess findById(int id) {
		// TODO Auto-generated method stub
		return epProcessDAO.selectByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	public int findSize(EpProcessForm form){
		return epProcessDAO.findSize(form);
	}

	@Override
	public List findPage(EpProcessForm form) {
		// TODO Auto-generated method stub
		return epProcessDAO.findPage(form);
	}

	@Override
	public boolean insert(EpProcessForm form) {
		// TODO Auto-generated method stub
		return epProcessDAO.insert(form);
	}

	@Override
	public boolean update(EpProcessForm form) {
		// TODO Auto-generated method stub
		return epProcessDAO.updateByPrimaryKey(form);
	}

}
