package com.rc.project.service.impl;

import java.util.List;

import com.rc.project.dao.EpProjectDetailDAO;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.service.ProjectDetailService;

public class ProjectDetailServiceImpl implements ProjectDetailService {
	
	private EpProjectDetailDAO epProjectDetailDAO;

	public void setEpProjectDetailDAO(EpProjectDetailDAO epProjectDetailDAO) {
		this.epProjectDetailDAO = epProjectDetailDAO;
	}

	@Override
	public List findPage(EpProjectDetailForm form) {
		// TODO Auto-generated method stub
		return epProjectDetailDAO.findPage(form);
	}

	@Override
	public int findSize(EpProjectDetailForm form) {
		// TODO Auto-generated method stub
		return epProjectDetailDAO.findSize(form);
	}

	@Override
	public boolean updatePurtType(int type,String[] idchecked) {
		// TODO Auto-generated method stub
		return epProjectDetailDAO.updatePurType(type, idchecked);
	}

}
