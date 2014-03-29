package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpPayMoneyForm;

public interface PayMoneyService {
	public boolean save(EpPayMoneyForm form);
	public List getListDetailByPackage(String ep_sno, String bg_sno,String payType);
	public List getListByPayType(String payType);
}
