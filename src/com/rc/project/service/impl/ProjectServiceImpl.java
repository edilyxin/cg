package com.rc.project.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
import com.rc.project.service.PackageService;
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
	private static ApplicationContext ctx = null;

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

	public Object getBean(String name) {
		if (ctx == null) {
			ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext());
		}
		return ctx.getBean(name);
	}

	private TransactionStatus startTransaction() {
		DataSourceTransactionManager tx = (DataSourceTransactionManager) getBean("transactionManager");
		return tx.getTransaction(new DefaultTransactionDefinition());

	}

	private void commitTransaction(TransactionStatus status) {
		DataSourceTransactionManager tx = (DataSourceTransactionManager) getBean("transactionManager");
		tx.commit(status);
	}

	private void endTransaction(TransactionStatus status) {
		DataSourceTransactionManager tx = (DataSourceTransactionManager) getBean("transactionManager");
		tx.rollback(status);

	}
	
	@Override
	public void backToApprove(String EPD_NID) {
		
		EpProjectDetailExample where = new EpProjectDetailExample();
		where.createCriteria().andEPD_NIDEqualTo(BigDecimal.valueOf(Long.valueOf(EPD_NID)));
		EpProjectDetail record=(EpProjectDetail) projectDetailDAO.selectByExample(where).get(0);
		record.setEPD_SSTAT("1");
		record.setEPD_SPURTYPE(null);
		
		projectDetailDAO.updateByExample(record, where);
		
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

		TransactionStatus ts = startTransaction();
		try {

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
				EpPackageList epPackageList = projectDetail.toPackageList();
				// EpPackageList epPackageList = new EpPackageList();
				// String packageListId = UUID.randomUUID().toString();
				epPackageList.setEP_SNO(projectDetail.getEP_SNO());
				epPackageList.setBG_SNO(packageId);
				epPackageList.setEPD_NID(projectDetail.getEPD_NID());

				packageListDAO.insertSelective(epPackageList);
			}
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
		}

	}

	@Override
	public List findAllBidPackages(String EP_SNO) {
		EpPackageExample packageExample = new EpPackageExample();
		packageExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andBG_STYPEEqualTo("1").andBG_NPURTYPEEqualTo("0");
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
		TransactionStatus ts = startTransaction();
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
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void submitBidPackage(String BG_SNO) {
		TransactionStatus ts = startTransaction();
		try {
			EpPackage epPackage = new EpPackage();
			epPackage.setBG_SNO(BG_SNO);
			epPackage.setBG_SSTATUS("1");
			packageDAO.updateByPrimaryKeySelective(epPackage);

			epPackage = packageDAO.selectByPrimaryKey(BG_SNO);
			EpSetting setting = new EpSetting();			

			EpProcessForm epProcess = new EpProcessForm();
			epProcess.setEP_SNO(epPackage.getEP_SNO());
			epProcess.setBG_SNO(epPackage.getBG_SNO());
			epProcess.setSS_SPURTYPE(epPackage.getBG_NPURTYPE());
			epProcess.setSS_SSTATE("0");

			epProcess.setSS_NNO(BigDecimal.valueOf(settingDAO.selectFirstStep("0")));
			epProcess.setSS_SMAN("admin");
			epProcess.setSS_TDATE(new Date(System.currentTimeMillis()));

			processDAO.insertSelective(epProcess);
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
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
		TransactionStatus ts = startTransaction();
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
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
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
		TransactionStatus ts = startTransaction();
		try {

			// /创建包
			EpPackage epPackage;
			EpPackageExample packageExample = new EpPackageExample();
			packageExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andBG_STYPEEqualTo("0");
			List<EpPackage> packages = packageDAO.selectByExample(packageExample);
			if (packages.size() == 0) {
				epPackage = new EpPackage();
				String packageId = UUID.randomUUID().toString();
				epPackage.setEP_SNO(EP_SNO);
				epPackage.setBG_SNO(packageId);
				epPackage.setBG_SNAME(packageId);
				epPackage.setBG_STYPE("0");
				epPackage.setBG_NPURTYPE("1");
				epPackage.setBG_SSTATUS("1");
				packageDAO.insertSelective(epPackage);
				epPackage = packageDAO.selectByPrimaryKey(packageId);
			} else {
				epPackage = packages.get(0);
			}

			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SPURTYPEEqualTo("1");
			for (EpProjectDetail projectDetail : (List<EpProjectDetail>) projectDetailDAO.selectByExample(projectDetailExample)) {
				EpPackageList epPackageList = projectDetail.toPackageList();
				epPackageList.setEP_SNO(projectDetail.getEP_SNO());
				epPackageList.setBG_SNO(epPackage.getBG_SNO());
				epPackageList.setEPD_NID(projectDetail.getEPD_NID());
				epPackageList.setPL_NTYPE("1");
				packageListDAO.insertSelective(epPackageList);
			}

			
			EpProcessForm epProcess = new EpProcessForm();
			epProcess.setEP_SNO(EP_SNO);
			epProcess.setBG_SNO(epPackage.getBG_SNO());
			epProcess.setSS_SPURTYPE(epPackage.getBG_NPURTYPE());
			epProcess.setSS_SSTATE("0");

			// epProcess.setSS_NNO(setting.getSET_NNO());
			epProcess.setSS_NNO(BigDecimal.valueOf(settingDAO.selectFirstStep("1")));
			epProcess.setSS_SMAN("admin");
			epProcess.setSS_TDATE(new Date(System.currentTimeMillis()));

			processDAO.insertSelective(epProcess);

			projectDetailExample.clear();
			projectDetailExample.createCriteria().andEP_SNOEqualTo(EP_SNO).andEPD_SPURTYPEEqualTo("1");
			List<EpProjectDetail> projectdDetails = projectDetailDAO.selectByExample(projectDetailExample);
			EpProjectDetail projectDetail = new EpProjectDetail();
			projectDetail.setEPD_SSTAT("3");
			projectDetailDAO.updateByExampleSelective(projectDetail, projectDetailExample);

			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
			throw new RuntimeException(e);
		}
	}

	public void back(String BG_SNO) {
		TransactionStatus ts = startTransaction();
		try {
			EpPackage epPackage = packageDAO.selectByPrimaryKey(BG_SNO);
			epPackage.setBG_SNO(BG_SNO);
			epPackage.setBG_SSTATUS("0");
			packageDAO.updateByPrimaryKeySelective(epPackage);

			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andBG_SNOEqualTo(BG_SNO);
			List<EpPackageList> packageLists = packageListDAO.selectByExample(packageListExample);

			//EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			//projectDetailExample.createCriteria().andEP_SNOEqualTo(epPackage.getEP_SNO()).andEPD_NIDIn(getEPD_NIDs(packageLists));
			//EpProjectDetail record = new EpProjectDetail();
			//record.setEPD_SSTAT("2");
			//projectDetailDAO.updateByExampleSelective(record, projectDetailExample);
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
			throw new RuntimeException(e);
		}

	}

	// ///////////////确定供应商/////////////////////

	public List getListByBG(String BG_SNO) {

		EpPackageListExample example = new EpPackageListExample();
		example.createCriteria().andBG_SNOEqualTo(BG_SNO);
		return packageListDAO.selectByExample(example);

	}

	@Override
	public List getListByBG(String BG_SNO, String[] EPD_NIDs) {
		EpPackageListExample example = new EpPackageListExample();
		example.createCriteria().andBG_SNOEqualTo(BG_SNO).andEPD_NIDIn(toList(EPD_NIDs));
		return packageListDAO.selectByExample(example);

	}
	
	@Override
	public void splitCollect(String EP_SNO, String BG_SNO, String AG_NID1, String[] EPD_NIDs, String[] nums,HttpServletRequest request,EpProcessForm process) {

		TransactionStatus ts = startTransaction();
		try {
			List EPD_NID_list = toList(EPD_NIDs);
			List nums_list = toList(nums);

			EpPackage epPackage = new EpPackage();
			String packageId = UUID.randomUUID().toString();
			epPackage.setEP_SNO(EP_SNO);
			epPackage.setBG_SNO(packageId);
			epPackage.setBG_SNAME(packageId);
			epPackage.setBG_STYPE("1");
			epPackage.setBG_NPURTYPE("1");
			epPackage.setBG_SSTATUS("1");
			epPackage.setAG_NID1(BigDecimal.valueOf(Long.valueOf(AG_NID1)));
			packageDAO.insertSelective(epPackage);

			EpProjectDetailExample projectDetailExample = new EpProjectDetailExample();
			projectDetailExample.createCriteria().andEPD_NIDIn(EPD_NID_list);
			List<EpProjectDetail> projectdDetails = projectDetailDAO.selectByExample(projectDetailExample);

			for (EpProjectDetail projectDetail : projectdDetails) {
				EpPackageList epPackageList = projectDetail.toPackageList();
				epPackageList.setEP_SNO(projectDetail.getEP_SNO());
				epPackageList.setBG_SNO(packageId);
				epPackageList.setEPD_NID(projectDetail.getEPD_NID());
				epPackageList.setPL_NTYPE("2");// 项目
				int index = EPD_NID_list.indexOf(epPackageList.getEPD_NID().toString());
				BigDecimal num = BigDecimal.valueOf(Long.valueOf((String) nums_list.get(index)));
				epPackageList.setPL_NNUM(num);
				packageListDAO.insertSelective(epPackageList);
			}

			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andEPD_NIDIn(EPD_NID_list).andBG_SNOEqualTo(BG_SNO).andPL_NTYPEEqualTo("1");
			List<EpPackageList> orglist = (List<EpPackageList>) packageListDAO.selectByExample(packageListExample);
			for (EpPackageList epPackageList : orglist) {
				int index = EPD_NID_list.indexOf(epPackageList.getEPD_NID().toString());
				BigDecimal num = BigDecimal.valueOf(Long.valueOf((String) nums_list.get(index)));
				epPackageList.setPL_NNUM(epPackageList.getPL_NNUM().subtract(num));
				EpPackageListExample where = new EpPackageListExample();
				where.createCriteria().andEPD_NIDEqualTo(epPackageList.getEPD_NID()).andBG_SNOEqualTo(BG_SNO).andPL_NTYPEEqualTo("1");
				packageListDAO.updateByExampleSelective(epPackageList, where);

			}
			
			PackageService pService = (PackageService)getBean("packageService");
			
			pService.submitCurrentProcess(request, process,epPackage.getBG_SNO());

			commitTransaction(ts);

		} catch (Exception e) {
			endTransaction(ts);
			throw new RuntimeException(e);
		}
	}

	public void backToSelect(HttpServletRequest request,EpProcessForm process) {
		String BG_SNO = request.getParameter("bg_sno");
		TransactionStatus ts = startTransaction();
		try {

			EpPackageListExample packageListExample = new EpPackageListExample();
			packageListExample.createCriteria().andBG_SNOEqualTo(BG_SNO);
			List<EpPackageList> packageLists = packageListDAO.selectByExample(packageListExample);
			packageListDAO.deleteByExample(packageListExample);
			packageListExample.clear();
			packageListExample.createCriteria().andEPD_NIDIn(getEPD_NIDs(packageLists)).andPL_NTYPEEqualTo("1");
			List<EpPackageList> oPackageLists = packageListDAO.selectByExample(packageListExample);
			for (EpPackageList opackageList : oPackageLists) {
				EpPackageList ta = getFromEPD_NID(packageLists, opackageList.getEPD_NID());				
				opackageList.setPL_NNUM(ta.getPL_NNUM().add(opackageList.getPL_NNUM()));
				
				EpPackageListExample where = new EpPackageListExample();
				where.createCriteria().andEPD_NIDEqualTo(opackageList.getEPD_NID()).andBG_SNOEqualTo(opackageList.getBG_SNO()).andPL_NTYPEEqualTo("1");
				packageListDAO.updateByExampleSelective(opackageList, where);
			}			
			
			packageDAO.deleteByPrimaryKey(BG_SNO);
			processDAO.deleteByPackage(BG_SNO);
			
		
			commitTransaction(ts);
		} catch (Exception e) {
			endTransaction(ts);
			throw new RuntimeException(e);
		}

	}

	private EpPackageList getFromEPD_NID(List<EpPackageList> packageLists, BigDecimal EPD_NID) {
		for (EpPackageList packageList : packageLists) {
			if (packageList.getEPD_NID().longValue() == EPD_NID.longValue())
				return packageList;
		}
		return null;
	}

	

}
