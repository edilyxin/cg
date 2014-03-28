package com.rc.project.service.impl;

import java.util.List;

import com.rc.project.dao.EpPayMoneyDAO;
import com.rc.project.form.EpPayMoneyForm;
import com.rc.project.service.PayMoneyService;

public class PayMoneyServiceImpl implements PayMoneyService {
	
	private EpPayMoneyDAO epPayMoneyDAO;
	

	public void setEpPayMoneyDAO(EpPayMoneyDAO epPayMoneyDAO) {
		this.epPayMoneyDAO = epPayMoneyDAO;
	}


	@Override
	public boolean save(EpPayMoneyForm from) {
		return this.epPayMoneyDAO.insert(from);
	}


	@Override
	public List getListDetailByPackage(String ep_sno, String bg_sno) {
		// TODO Auto-generated method stub
		return this.epPayMoneyDAO.getListByPackage(ep_sno, bg_sno);
	}

}
