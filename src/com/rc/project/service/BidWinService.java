package com.rc.project.service;

import com.rc.project.form.EpBidForm;
import com.rc.project.form.EpBidWinForm;
import com.rc.project.vo.EpBid;
import com.rc.project.vo.EpBidWin;

public interface BidWinService {
	public boolean insert(EpBidWinForm form);
	public EpBidWin getDetailByPackage(String ep_sno,String bg_sno);
	public boolean updateBidWin(EpBidWinForm form);
}
