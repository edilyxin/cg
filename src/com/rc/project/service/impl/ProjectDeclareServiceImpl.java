package com.rc.project.service.impl;

import java.util.List;

import com.rc.project.dao.RpReportBeginDAO;
import com.rc.project.form.PojectDeclareForm;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectDeclareService;
import com.rc.project.vo.RpReportBegin;
import com.rc.project.vo.RpReportBeginExample;

public class ProjectDeclareServiceImpl implements ProjectDeclareService {

	private RpReportBeginDAO rpReportBeginDAO;
	private RpReportBeginExample example;
	

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO) {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	@Override
	public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectByPage(pForm);
	}

	@Override
	public int findSize(RpReportBeginForm pForm) {
		// TODO Auto-generated method stub
		return this.rpReportBeginDAO.selectSize(pForm);
	}
}