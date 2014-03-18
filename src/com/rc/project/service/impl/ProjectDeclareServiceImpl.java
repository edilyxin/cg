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
	private String filepath;    //文档路径
	private String filename;    //文档名称
	

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO) {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	@Override
	public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectByPage(pForm);
	}

	@Override
	public int findSize(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectSize(pForm);
	}

	@Override
	public int importData(RpReportBeginForm pForm) {
		return 0;
	}
	
	private int importExcl(String filename){
		return 0;
	}
}
