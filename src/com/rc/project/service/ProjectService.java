package com.rc.project.service;

import java.math.BigDecimal;
import java.util.List;

import com.rc.project.form.EpEntrancecForm;
import com.rc.project.form.EpEntrancepForm;
import com.rc.project.form.EpPackageListForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.vo.EpEntrancec;
import com.rc.project.vo.EpEntrancep;
import com.rc.project.vo.EpPackageList;
import com.rc.project.vo.EpProjectDetail;


public interface ProjectService {
	public List find();
	
	public List findBits(String EP_SNO);
	
	
	public void splitPackage(String[] EPD_NIDs);

	public List findAllBidPackages(String eP_SNO);

	public void deletePackage(String BG_SNO);

	public void submitBidPackage(String bG_SNO);

	public List findCollects(String eP_SNO);

	public EpProjectDetail findProjectDetail(BigDecimal EPD_NID);

	public void addPackageDetail(EpPackageListForm form);

	public List findCoolectPackageLists(BigDecimal ePD_NID);

	public void deletePackageDetail(long pL_NNO);

	public EpPackageList getPackageDetail(long pL_NNO);

	public void updatePackageDetail(EpPackageListForm packageListForm);

	public void updateProjectDetail(EpProjectDetailForm projectDetailForm);

	public void saveEntranceP(EpEntrancepForm entrancepForm);

	public EpEntrancep getEntranceP(String eP_SNO);

	public List findBidProjectDetails(String EP_SNO);

	public EpEntrancec findEntranceC(BigDecimal ePD_NID);
	
	public void saveEntranceC(EpEntrancecForm entrancecForm);

	public void submitCollect(String eP_SNO);
	
	public void back(String BG_SNO);
}

