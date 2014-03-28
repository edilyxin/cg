/**
 * 
 */
package com.rc.project.service.impl;

import com.rc.project.dao.EpContractDAO;
import com.rc.project.form.EpContractForm;
import com.rc.project.service.ContractService;
import com.rc.project.vo.EpContract;

/**
 * @author Administrator
 *
 */
public class ContractServiceImpl implements ContractService {
	private EpContractDAO epContractDAO;
	

	public void setEpContractDAO(EpContractDAO epContractDAO) {
		this.epContractDAO = epContractDAO;
	}


	/* (non-Javadoc)
	 * @see com.rc.project.service.ContractService#insert(com.rc.project.form.EpContractForm)
	 */
	@Override
	public boolean insert(EpContractForm form) {
		// TODO Auto-generated method stub
		return this.epContractDAO.insert(form);
	}


	@Override
	public EpContract getDetailByPackage(String ep_sno, String bg_sno) {
		// TODO Auto-generated method stub
		return this.epContractDAO.getDetailByPackage(ep_sno, bg_sno);
	}
	
	public boolean updateContract(EpContractForm form){
		return this.epContractDAO.updateByPrimaryKeySelective(form) == 0 ? false : true;
	}

}
