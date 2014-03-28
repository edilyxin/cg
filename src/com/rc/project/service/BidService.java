package com.rc.project.service;

import com.rc.project.form.EpAccessoryForm;
import com.rc.project.form.EpBidForm;
import com.rc.project.vo.EpBid;

public interface BidService {
	public boolean insert(EpBidForm form);
	public boolean insert(EpBidForm form,EpAccessoryForm fileForm);
	public EpBid getBidByPackage(String ep_sno,String bg_sno);
	public boolean updateBid(EpBidForm form);
}
