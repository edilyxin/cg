package com.rc.project.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.rc.project.dao.EpEntrancecDAO;
import com.rc.project.dao.EpEntrancepDAO;
import com.rc.project.dao.EpPackageDAO;
import com.rc.project.dao.EpPackageListDAO;
import com.rc.project.dao.EpProcessDAO;
import com.rc.project.dao.EpProjectDAO;
import com.rc.project.dao.EpProjectDetailDAO;
import com.rc.project.dao.EpSettingDAO;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.form.EpEntrancepForm;
import com.rc.project.form.EpPackageListForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpEntrancec;
import com.rc.project.vo.EpEntrancep;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpPackageExample;
import com.rc.project.vo.EpPackageList;
import com.rc.project.vo.EpPackageListExample;
import com.rc.project.vo.EpProjectDetail;
import com.rc.project.vo.EpProjectDetailExample;
import com.rc.project.vo.EpSetting;

public class ProjectServiceImpl implements ProjectService {
	private EpProjectDAO projectDAO;
	private EpProjectDetailDAO projectDetailDAO;
	private EpPackageDAO packageDAO;
	private EpPackageListDAO packageListDAO;
	private EpEntrancepDAO entrancepDAO;
	private EpEntrancecDAO entrancecDAO;
	private EpProcessDAO processDAO;
	private EpSettingDAO settingDAO;

	public EpProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(EpProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public EpProjectDetailDAO getProjectDetailDAO() {
		return projectDetailDAO;
	}

	public void setProjectDetailDAO(EpProjectDetailDAO projectDetailDAO) {
		this.projectDetailDAO = projectDetailDAO;
	}

	public EpPackageDAO getPackageDAO() {
		return packageDAO;
	}

	public void setPackageDAO(EpPackageDAO packageDAO) {
		this.packageDAO = packageDAO;
	}

	public EpPackageListDAO getPackageListDAO() {
		return packageListDAO;
	}

	public void setPackageListDAO(EpPackageListDAO packageListDAO) {
		this.packageListDAO = packageListDAO;
	}

	public EpEntrancepDAO getEntrancepDAO() {
		return entrancepDAO;
	}

	public void setEntrancepDAO(EpEntrancepDAO entrancepDAO) {
		this.entrancepDAO = entrancepDAO;
	}

	public EpEntrancecDAO getEntrancecDAO() {
		return entrancecDAO;
	}

	public void setEntrancecDAO(EpEntrancecDAO entrancecDAO) {
		this.entrancecDAO = entrancecDAO;
	}

	public EpProcessDAO getProcessDAO() {
		return processDAO;
	}

	public void setProcessDAO(EpProcessDAO processDAO) {
		this.processDAO = processDAO;
	}

	public EpSettingDAO getSettingDAO() {
		return settingDAO;
	}

	public void setSettingDAO(EpSettingDAO settingDAO) {
		this.settingDAO = settingDAO;
	}

	private void startTransaction() {
//		try {
//			projectDAO.getSqlMapClient().startTransaction();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}

	}

	private void commitTransaction() {
//		try {
//			projectDAO.getSqlMapClient().commitTransaction();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
	}

	private void endTransaction() {
//		try {
//			projectDAO.getSqlMapClient().endTransaction();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}

	}

	@Override
	public List find() {
		return projectDAO.find(null);
	}

	public List findBits(String EP_SNO) {
		EpProjectDetailExample example = new EpProjectDetailExample();
		example.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SSTATEqualTo("2").andEPD_SPURTYPEEqualTo("0");
		return projectDetailDAO.selectByExample(example);

	}

	public void splitPackage(String[] EPD_NIDs) {

		startTransaction();
		try {
			projectDetailDAO.getSqlMapClient().startTransaction();
			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEPD_NIDIn(toList(EPD_NIDs));

			List<EpProjectDetail> projectdDetails = projectDetailDAO.selectByExample(projectDetailExample);
			EpProjectDetail record = new EpProjectDetail();
			record.setEPD_SSTAT("3");
			projectDetailDAO.updateByExampleSelective(record, projectDetailExample);

			EpPackage epPackage = new EpPackage();
			String packageId = UUID.randomUUID().toString();
			epPackage.setEP_SNO(projectdDetails.get(0).getEP_SNO());
			epPackage.setBG_SNO(packageId);
			epPackage.setBG_SNAME(packageId);
			epPackage.setBG_STYPE("1");
			epPackage.setBG_NPURTYPE("0");
			epPackage.setBG_SSTATUS("0");
			packageDAO.insertSelective(epPackage);

			for (EpProjectDetail projectDetail : projectdDetails) {
				EpPackageList epPackageList = new EpPackageList();
				String packageListId = UUID.randomUUID().toString();
				epPackageList.setEP_SNO(projectDetail.getEP_SNO());
				epPackageList.setBG_SNO(packageId);
				epPackageList.setEPD_NID(projectDetail.getEPD_NID());
				epPackageList.setPL_NTYPE("2");

				epPackageList.setPL_NNUM(projectDetail.getEPD_NNUM());
				epPackageList.setPL_SNAME(projectDetail.getEPD_SNAME());

				epPackageList.setPL_SBRAND(projectDetail.getEPD_SBRAND());
				epPackageList.setPL_SSPEC(projectDetail.getEPD_SSPEC());
				epPackageList.setPL_SMODEL(projectDetail.getEPD_SMODEL());
				epPackageList.setPL_SUNIT(projectDetail.getEPD_SUNIT());
				epPackageList.setPL_NNUM(projectDetail.getEPD_NNUM());
				epPackageList.setPL_NPRICE(projectDetail.getEPD_NNUM());
				epPackageList.setPL_NTOTAL(projectDetail.getEPD_NTOTAL());
				epPackageList.setPL_NNUMSONG(projectDetail.getEPD_NNUMSONG());
				epPackageList.setPL_NPRICESONG(projectDetail.getEPD_NPRICESONG());
				epPackageList.setPL_NTOTALSONG(projectDetail.getEPD_NTOTALSONG());
				epPackageList.setPL_NNUMJIAN(projectDetail.getEPD_NNUMJIAN());
				epPackageList.setPL_NPRICEJIAN(projectDetail.getEPD_NPRICEJIAN());
				epPackageList.setPL_NTOTALJIAN(projectDetail.getEPD_NTOTALJIAN());
				epPackageList.setPL_NCANNOT(projectDetail.getEPD_NCANNOT());
				epPackageList.setPL_SAPPROVENOTE(projectDetail.getEPD_SAPPROVENOTE());
				packageListDAO.insertSelective(epPackageList);
			}
			projectDetailDAO.getSqlMapClient().commitTransaction();
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
		}

	}

	@Override
	public List findAllBidPackages(String EP_SNO) {
		EpPackageExample packageExample = new EpPackageExample();
		packageExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andBG_STYPEEqualTo("1");
		List<EpPackage> packages = packageDAO.selectByExample(packageExample);
		for (EpPackage package1 : packages) {

			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andBG_SNOEqualTo(package1.getBG_SNO());
			package1.setPackageList(packageListDAO.selectByExample(packageListExample));

		}

		return packages;

	}

	@Override
	public void deletePackage(String BG_SNO) {
		startTransaction();
		try {
			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andBG_SNOEqualTo(BG_SNO);
			List packageLists = packageListDAO.selectByExample(packageListExample);
			packageListDAO.deleteByExample(packageListExample);

			EpPackageExample packageExample = new EpPackageExample();
			packageExample.createCriteria().andBG_SNOEqualTo(BG_SNO);
			EpPackage epPackage = packageDAO.selectByPrimaryKey(BG_SNO);
			packageDAO.deleteByPrimaryKey(BG_SNO);
			packageDAO.deleteByExample(packageExample);

			EpProjectDetailExample example = new EpProjectDetailExample();
			example.createCriteria().andEP_SNOEqualTo(epPackage.getEP_SNO()).andEPD_NIDIn(getEPD_NIDs(packageLists));

			EpProjectDetail record = new EpProjectDetail();
			record.setEPD_SSTAT("2");
			projectDetailDAO.updateByExampleSelective(record, example);
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void submitBidPackage(String BG_SNO) {
		startTransaction();
		try {
			EpPackage epPackage = new EpPackage();
			epPackage.setBG_SNO(BG_SNO);
			epPackage.setBG_SSTATUS("1");
			packageDAO.updateByPrimaryKeySelective(epPackage);

			epPackage = packageDAO.selectByPrimaryKey(BG_SNO);

			EpSetting setting = settingDAO.selectFirstStep("0");
			EpProcessForm epProcess = new EpProcessForm();
			epProcess.setEP_SNO(epPackage.getEP_SNO());
			epProcess.setBG_SNO(epPackage.getBG_SNO());
			epProcess.setSS_SPURTYPE(epPackage.getBG_NPURTYPE());
			epProcess.setSS_SSTATE("0");

//			epProcess.setSS_NNO(setting.getSET_NNO());
			epProcess.setSS_NNO(setting.getSET_NID());
			epProcess.setSS_SNAME(setting.getSET_SNAME());
			epProcess.setSS_SPAGE(setting.getSET_SPAGE());
			epProcess.setSS_NWORK(setting.getSET_NWORK());

			processDAO.insertSelective(epProcess);
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List findCollects(String EP_SNO) {
		EpProjectDetailExample example = new EpProjectDetailExample();
		example.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SSTATEqualTo("2").andEPD_SPURTYPEEqualTo("1");
		List<EpProjectDetail> projectdDetails = projectDetailDAO.selectByExample(example);

		return projectdDetails;

	}

	private static List toList(String[] arr) {
		List list = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		return list;
	}

	private static List getEPD_NIDs(List<EpPackageList> packageLists) {
		List list = new ArrayList();
		for (EpPackageList epPackageList : packageLists) {
			list.add(epPackageList.getEPD_NID());
		}

		return list;
	}

	@Override
	public EpProjectDetail findProjectDetail(BigDecimal EPD_NID) {
		EpProjectDetailExample example = new EpProjectDetailExample();
		example.createCriteria().andEPD_NIDEqualTo(EPD_NID);
		return (EpProjectDetail) projectDetailDAO.selectByExample(example).get(0);
	}

	@Override
	public void addPackageDetail(EpPackageListForm form) {
		startTransaction();
		try {
			EpPackageList epPackageList = form.toVO();
			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEPD_NIDEqualTo(form.getEPD_NID());
			EpProjectDetail projectDetail = (EpProjectDetail) projectDetailDAO.selectByExample(projectDetailExample).get(0);

			String packageId;
			EpPackageExample packageExample = new EpPackageExample();
			packageExample.createCriteria().andEP_SNOEqualTo(projectDetail.getEP_SNO()).andBG_STYPEEqualTo("0");
			List<EpPackage> packages = packageDAO.selectByExample(packageExample);
			if (packages.size() == 0) {
				EpPackage epPackage = new EpPackage();
				packageId = UUID.randomUUID().toString();
				epPackage.setEP_SNO(projectDetail.getEP_SNO());
				epPackage.setBG_SNO(packageId);
				epPackage.setBG_SNAME(packageId);
				epPackage.setBG_STYPE("0");
				epPackage.setBG_NPURTYPE("1");
				epPackage.setBG_SSTATUS("0");
				packageDAO.insertSelective(epPackage);
			} else {
				packageId = packages.get(0).getBG_SNO();
			}

			String packageListId = UUID.randomUUID().toString();
			epPackageList.setEP_SNO(projectDetail.getEP_SNO());
			epPackageList.setBG_SNO(packageId);
			epPackageList.setEPD_NID(projectDetail.getEPD_NID());
			epPackageList.setPL_NTYPE("1");

			packageListDAO.insertSelective(epPackageList);
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List findCoolectPackageLists(BigDecimal EPD_NID) {

		EpPackageListExample packageListExample = new EpPackageListExample();
		packageListExample.createCriteria().andEPD_NIDEqualTo(EPD_NID);
		return packageListDAO.selectByExample(packageListExample);

	}

	@Override
	public void deletePackageDetail(long PL_NNO) {
		EpPackageListExample packageListExample = new EpPackageListExample();
		packageListExample.createCriteria().andPL_NNOEqualTo(PL_NNO);
		packageListDAO.deleteByExample(packageListExample);

	}

	@Override
	public EpPackageList getPackageDetail(long PL_NNO) {
		EpPackageListExample packageListExample = new EpPackageListExample();
		packageListExample.createCriteria().andPL_NNOEqualTo(PL_NNO);
		return (EpPackageList) packageListDAO.selectByExample(packageListExample).get(0);
	}

	@Override
	public void updatePackageDetail(EpPackageListForm packageListForm) {
		EpPackageList epPackageList = packageListForm.toVO();
		EpPackageListExample example = new EpPackageListExample();
		example.createCriteria().andPL_NNOEqualTo(epPackageList.getPL_NNO());
		packageListDAO.updateByExampleSelective(epPackageList, example);
	}

	@Override
	public void updateProjectDetail(EpProjectDetailForm projectDetailForm) {

		EpProjectDetail projectDetail = projectDetailForm.toVO();
		EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
		projectDetailExample.createCriteria().andEPD_NIDEqualTo(projectDetail.getEPD_NID());
		projectDetailDAO.updateByExampleSelective(projectDetail, projectDetailExample);

	}

	@Override
	public void saveEntranceP(EpEntrancepForm entrancepForm) {
		if (entrancepForm.getETP_SNO() != null && entrancepForm.getETP_SNO().length() > 0) {
			entrancepDAO.updateByPrimaryKeySelective(entrancepForm);
		} else {
			entrancepForm.setETP_SNO(UUID.randomUUID().toString());
			entrancepDAO.insertSelective(entrancepForm);
		}
	}

	@Override
	public EpEntrancep getEntranceP(String EP_SNO) {
		return entrancepDAO.selectByEP_SNO(EP_SNO);
	}

	@Override
	public List findBidProjectDetails(String EP_SNO) {
		EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
		projectDetailExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SPURTYPEEqualTo("0");
		return projectDetailDAO.selectByExample(projectDetailExample);
	}

	@Override
	public EpEntrancec findEntranceC(BigDecimal EPD_NID) {
		return entrancecDAO.selectByEPD_NID(EPD_NID);
	}

	@Override
	public void saveEntranceC(EpEntrancecForm entrancecForm) {
		if (entrancecForm.getETC_NID() != null && entrancecForm.getETC_NID().longValue() > 0) {
			entrancecDAO.updateByPrimaryKeySelective(entrancecForm);
		} else {
			entrancecDAO.insertSelective(entrancecForm);
		}
	}

	@Override
	public void submitCollect(String EP_SNO) {
		startTransaction();
		try {

			EpPackageExample packageExample = new EpPackageExample();
			packageExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andBG_STYPEEqualTo("0");
			EpPackage epPackage = (EpPackage) packageDAO.selectByExample(packageExample).get(0);
			epPackage.setBG_SSTATUS("1");
			packageDAO.updateByPrimaryKeySelective(epPackage);
			int result = packageDAO.updateByExampleSelective(epPackage, packageExample);
			if (result > 0) {
				EpSetting setting = settingDAO.selectFirstStep("1");

				EpProcessForm epProcess = new EpProcessForm();
				epProcess.setEP_SNO(EP_SNO);
				epProcess.setBG_SNO(epPackage.getBG_SNO());
				epProcess.setSS_SPURTYPE(epPackage.getBG_NPURTYPE());
				epProcess.setSS_SSTATE("0");

				//epProcess.setSS_NNO(setting.getSET_NNO());
				epProcess.setSS_NNO(setting.getSET_NID());
				epProcess.setSS_SNAME(setting.getSET_SNAME());
				epProcess.setSS_SPAGE(setting.getSET_SPAGE());
				epProcess.setSS_NWORK(setting.getSET_NWORK());

				processDAO.insertSelective(epProcess);
			}

			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SPURTYPEEqualTo("1");
			List<EpProjectDetail> projectdDetails = projectDetailDAO.selectByExample(projectDetailExample);
			EpProjectDetail projectDetail = new EpProjectDetail();
			projectDetail.setEPD_SSTAT("3");
			projectDetailDAO.updateByExampleSelective(projectDetail, projectDetailExample);
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
			throw new RuntimeException(e);
		}
	}

	public void back(String BG_SNO) {
		startTransaction();
		try {
			EpPackage epPackage = packageDAO.selectByPrimaryKey(BG_SNO);
			epPackage.setBG_SNO(BG_SNO);
			epPackage.setBG_SSTATUS("0");
			packageDAO.updateByPrimaryKeySelective(epPackage);
			
			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andBG_SNOEqualTo(BG_SNO);
			List<EpPackageList> packageLists = packageListDAO.selectByExample(packageListExample);

			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEP_SNOEqualTo(epPackage.getEP_SNO()).andEPD_NIDIn(getEPD_NIDs(packageLists));
			EpProjectDetail record = new EpProjectDetail();
			record.setEPD_SSTAT("2");
			projectDetailDAO.updateByExampleSelective(record, projectDetailExample);
			commitTransaction();
		} catch (Exception e) {
			endTransaction();
			throw new RuntimeException(e);
		}

	}

}
