package com.rc.project.service.impl;

import com.rc.project.dao.EpBidDAO;
import com.rc.project.form.EpAccessoryForm;
import com.rc.project.form.EpBidForm;
import com.rc.project.service.BidService;
import com.rc.project.vo.EpBid;

public class BidServiceImpl implements BidService {

	private EpBidDAO epBidDAO;
	
	public void setEpBidDAO(EpBidDAO epBidDAO) {
		this.epBidDAO = epBidDAO;
	}

	@Override
	public boolean insert(EpBidForm form) {
		// TODO Auto-generated method stub
		return this.epBidDAO.insert(form);
	}

	@Override
	public boolean insert(EpBidForm form, EpAccessoryForm fileForm) {
		// TODO Auto-generated method stub
		return this.epBidDAO.insert(form, fileForm);
	}

	@Override
	public EpBid getBidByPackage(String ep_sno, String bg_sno) {
		// TODO Auto-generated method stub
		return epBidDAO.getBidByPackage(ep_sno, bg_sno);
				
	}
	
	public boolean updateBid(EpBidForm form){
		return epBidDAO.updateByPrimaryKeySelective(form) == 0?false:true;
	}

}
