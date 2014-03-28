package com.rc.project.service.impl;

import com.rc.project.dao.EpBidWinDAO;
import com.rc.project.form.EpBidForm;
import com.rc.project.form.EpBidWinForm;
import com.rc.project.service.BidWinService;
import com.rc.project.vo.EpBidWin;

public class BidWinServiceImpl implements BidWinService {

	private EpBidWinDAO epBidWinDAO;
	
	public void setEpBidWinDAO(EpBidWinDAO dao){
		this.epBidWinDAO = dao;
	}		
	@Override
	public boolean insert(EpBidWinForm form) {
		// TODO Auto-generated method stub
		return this.epBidWinDAO.insert(form);
	}
	@Override
	public EpBidWin getDetailByPackage(String ep_sno, String bg_sno) {
		// TODO Auto-generated method stub
		return epBidWinDAO.getBidByPackage(ep_sno, bg_sno);
	}
	
	public boolean updateBidWin(EpBidWinForm form){
		return this.epBidWinDAO.updateByPrimaryKeySelective(form) == 0?false:true;
	}
}
