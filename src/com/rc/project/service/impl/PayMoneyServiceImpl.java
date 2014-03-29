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
	public List getListDetailByPackage(String ep_sno, String bg_sno,String payType) {
		EpPayMoneyForm form = new EpPayMoneyForm();
    	form.setBG_SNO(bg_sno);
    	form.setEP_SNO(ep_sno);
    	form.setPM_SDEF1(payType);
		// TODO Auto-generated method stub
		return this.epPayMoneyDAO.getListByPackage(form);
	}
	
	public List getListByPayType(String payType){
		return this.epPayMoneyDAO.getListByPayType(payType);
	}

}
