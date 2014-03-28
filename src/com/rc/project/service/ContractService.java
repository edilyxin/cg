package com.rc.project.service;

import com.rc.project.form.EpContractForm;
import com.rc.project.vo.EpBidWin;
import com.rc.project.vo.EpContract;

public interface ContractService {
	public boolean insert(com.rc.project.form.EpContractForm form);
	public EpContract getDetailByPackage(String ep_sno,String bg_sno);
	public boolean updateContract(EpContractForm form);
}
