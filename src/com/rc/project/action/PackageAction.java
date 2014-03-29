package com.rc.project.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rc.base.service.EmpService;
import com.rc.demo.form.DemoForm;
import com.rc.project.dao.EpPackageDAO;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.form.EpEntrancepForm;
import com.rc.project.form.EpPackageListForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpEntrancep;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpPackageList;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpProjectDetail;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

public class PackageAction extends BaseAction {
	private List list;
	private List projectMenu;
	private List bitList;
	private List allPackage;
	private List collectList;
	private List packageLists;
	private EpProjectDetail projectDetail;
	private EpPackageListForm packageListForm;
	private EpProjectDetailForm projectDetailForm;
	private EpPackageList packageList;
	private PageBean bean;
	private ProjectService projectService = (ProjectService) getBean("projectService");
	private LogService log = (LogService) getBean("logService");

	public String find() {
		String EP_SNO = request.getParameter("EP_SNO");
		bitList = projectService.findBits(EP_SNO);
		allPackage = projectService.findAllBidPackages(EP_SNO);
		collectList = projectService.findCollects(EP_SNO);
		return "find";
	}

	///////选择供应商/////////////////////////////
	public String toSelectsupplier() {
		String BG_SNO = request.getParameter("bg_sno");
		if(BG_SNO==null)
			BG_SNO = request.getParameter("BG_SNO");
		packageLists = projectService.getListByBG(BG_SNO);
		return "selectsupplier";
	}

	public String toSelectsupplierDetail() {
		String[] EPD_NIDs = request.getParameterValues("idcheckbox");
		String BG_SNO = request.getParameter("bg_sno");
		packageLists = projectService.getListByBG(BG_SNO,EPD_NIDs);
		return "selectsupplierDetail";
	}

	public String selectsupplierDetail() {
		String EP_SNO = request.getParameter("ep_sno");
		String BG_SNO = request.getParameter("bg_sno");
		String AG_NID1 = request.getParameter("AG_NID1");
		String[] EPD_NIDs = request.getParameterValues("id");
		String[] nums = request.getParameterValues("num");
		EpProcessForm form = new EpProcessForm();
		form.setBG_SNO(BG_SNO);
		form.setEP_SNO(EP_SNO);
		projectService.splitCollect(EP_SNO,BG_SNO,AG_NID1,EPD_NIDs,nums,request,form);
		return this.toSelectsupplier();
	}

	public String menu() {
		projectMenu = projectService.find();		
		return "menu";
	}

	public String main() {
		return "main";
	}

	// /////////////////招标采购/////////////////////////////
	
	public String bidBackToApprove() {
		String EPD_NID = request.getParameter("EPD_NID");
		projectService.backToApprove(EPD_NID);
		return this.findbit();
	}

	public String findbit(){
		String EP_SNO = request.getParameter("EP_SNO");
		bitList = projectService.findBits(EP_SNO);
		allPackage = projectService.findAllBidPackages(EP_SNO);
		//collectList = projectService.findCollects(EP_SNO);
		return "findbit";
	}
	
	
	public String toUpdateparameter() {
		long EPD_NID = Long.valueOf(request.getParameter("EPD_NID"));
		projectDetail = projectService.findProjectDetail(BigDecimal.valueOf(EPD_NID));
		return "updateparameter";
	}

	public String updateparameter() {
		projectService.updateProjectDetail(projectDetailForm);
		return this.findbit();
	}

	public String splitPackage() {
		String[] ids = request.getParameterValues("idcheckbox");

		System.out.println(ids);
		projectService.splitPackage(ids);

		return this.findbit();
	}

	public String submitPackage() {
		String BG_SNO = request.getParameter("BG_SNO");
		projectService.submitBidPackage(BG_SNO);
		return this.findbit();
	}

	public String deletePackage() {
		String BG_SNO = request.getParameter("BG_SNO");
		projectService.deletePackage(BG_SNO);

		return this.findbit();
	}

	// ///////////集中采购///////////////////
	
	public String collectBackToApprove() {
		String EPD_NID = request.getParameter("EPD_NID");
		projectService.backToApprove(EPD_NID);
		return this.findcollect();
	}

	public String findcollect(){
		String EP_SNO = request.getParameter("EP_SNO");
//		bitList = projectService.findBits(EP_SNO);
//		allPackage = projectService.findAllBidPackages(EP_SNO);
		collectList = projectService.findCollects(EP_SNO);
		return "findcollect";
	}
	
	public String toAddcollectpackage() {
		return "addcollectpackage";
	}

	public String toCollectdetail() {
		long EPD_NID = Long.valueOf(request.getParameter("EPD_NID"));
		projectDetail = projectService.findProjectDetail(BigDecimal.valueOf(EPD_NID));
		packageLists = projectService.findCoolectPackageLists(BigDecimal.valueOf(EPD_NID));

		return "collectdetail";
	}

	public String toCollectupdate() {
		long EPD_NID = Long.valueOf(request.getParameter("EPD_NID"));
		projectDetail = projectService.findProjectDetail(BigDecimal.valueOf(EPD_NID));
		return "collectupdate";
	}

	public String collectupdate() {
		projectService.updateProjectDetail(projectDetailForm);
		return this.findcollect();
	}

	public String submitCollect() {
		String EP_SNO = request.getParameter("EP_SNO");
		projectService.submitCollect(EP_SNO);
		return this.findcollect();
	}

	public String toAddPackageDetail() {
		return "addcollectpackage";
	}

	public String addPackageDetail() {
		projectService.addPackageDetail(packageListForm);
		return this.toCollectdetail();
	}

	public String toUpdatePackageDetail() {
		long PL_NNO = Long.valueOf(request.getParameter("PL_NNO"));
		packageList = projectService.getPackageDetail(PL_NNO);
		return "addcollectpackage";
	}

	public String updatePackageDetail() {
		projectService.updatePackageDetail(packageListForm);
		return this.toCollectdetail();
	}

	public String deletePackageDetail() {
		long PL_NNO = Long.valueOf(request.getParameter("PL_NNO"));
		projectService.deletePackageDetail(PL_NNO);
		return this.toCollectdetail();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public EpPackageListForm getPackageListForm() {
		return packageListForm;
	}

	public void setPackageListForm(EpPackageListForm packageListForm) {
		this.packageListForm = packageListForm;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public List getProjectMenu() {
		return projectMenu;
	}

	public void setProjectMenu(List projectMenu) {
		this.projectMenu = projectMenu;
	}

	public List getBitList() {
		return bitList;
	}

	public void setBitList(List bitList) {
		this.bitList = bitList;
	}

	public List getCollectList() {
		return collectList;
	}

	public void setCollectList(List collectList) {
		this.collectList = collectList;
	}

	public List getAllPackage() {
		return allPackage;
	}

	public void setAllPackage(List allPackage) {
		this.allPackage = allPackage;
	}

	public EpProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(EpProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	public List getPackageLists() {
		return packageLists;
	}

	public void setPackageLists(List packageLists) {
		this.packageLists = packageLists;
	}

	public EpPackageList getPackageList() {
		return packageList;
	}

	public void setPackageList(EpPackageList packageList) {
		this.packageList = packageList;
	}

	public EpProjectDetailForm getProjectDetailForm() {
		return projectDetailForm;
	}

	public void setProjectDetailForm(EpProjectDetailForm projectDetailForm) {
		this.projectDetailForm = projectDetailForm;
	}

}
