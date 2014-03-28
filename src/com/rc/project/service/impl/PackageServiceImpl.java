package com.rc.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rc.project.dao.EpPackageDAO;
import com.rc.project.dao.EpPackageListDAO;
import com.rc.project.dao.EpProcessDAO;
import com.rc.project.dao.EpSettingDAO;
import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.service.PackageService;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpProject;
import com.rc.project.vo.EpSetting;

public class PackageServiceImpl implements PackageService {
	private EpPackageListDAO epPackageListDAO;
	private EpPackageDAO epPackageDAO;
	private EpProcessDAO epProcessDAO;
	private EpSettingDAO epSettingDAO;
	
	//获取项目包的流程状态
	public List findPage(){
		//查找已提交的项目编号
		List epsNoList = this.findEpsNo();
		//获取项目列表
		List projectList = this.findProject(epsNoList);
		
		if(projectList == null)return projectList;
		
		for (Object object : projectList) {
			EpProject project = (EpProject)object;
			//获取包列表
			List packageList = findPackage(project.getEP_SNO());
			for (Object object2 : packageList) {
				EpPackage p = (EpPackage)object2;
				EpProcessForm proQueryForm = new EpProcessForm();
				proQueryForm.setBG_SNO(p.getBG_SNO());
				proQueryForm.setEP_SNO(p.getEP_SNO());				
				proQueryForm.setSS_SSTATE("0");
				//查找包的未操作记录
				EpProcess process = findProcess(proQueryForm);
				//或者相关流程设置
				if(process!=null){
					EpSetting setting = findSetting(Integer.parseInt(String.valueOf(process.getSS_NNO())));				
					process.setSetting(setting);
					p.setProcess(process);
				}
			}
			project.setPackageList(packageList);
		}
		return projectList;
	}
	
	public boolean updateProcessState(EpProcessForm record){
		return epProcessDAO.updateByPrimaryKeySelective(record) == 0?false:true;
	}
	
	public boolean insertProcess(EpProcessForm form){
		return epProcessDAO.insert(form);
	}
	
	public EpSetting findnextSetid(EpSettingForm form){
		return epSettingDAO.findNextsetId(form);		
	}
	
	private EpSetting getPreSetting(String purType, int currentNo) {
		int nextNo = currentNo - 1;
		EpSettingForm form = new EpSettingForm();
		form.setSET_SPURTYPE(purType);
		form.setSET_NNO(BigDecimal.valueOf(nextNo));
		return findnextSetid(form);
	}
	
	private EpSetting getNextSetting(String purType, int currentNo) {
		int nextNo = currentNo + 1;
		EpSettingForm form = new EpSettingForm();
		form.setSET_SPURTYPE(purType);
		form.setSET_NNO(BigDecimal.valueOf(nextNo));
		return findnextSetid(form);
	}
	
	/*
	 * 提交当前流程，修改当前流程状态为1-已操作，添加下一个流程记录
	 * request
	 * process 需要设置当前操作人，操作时间，
	 */
	public void submitCurrentProcess(HttpServletRequest request,EpProcessForm process){
		
		String ss_nid = request.getParameter("ss_nid");
		String set_nno = request.getParameter("set_nno");
		String bg_sno = request.getParameter("bg_sno");
		String ep_sno = request.getParameter("ep_sno");
		String set_spurtype = request.getParameter("set_spurtype");
		
		
		
		// 修改当前状态 已经操作
				
				process.setSS_NID(BigDecimal.valueOf(Integer.parseInt(ss_nid)));
				process.setSS_SSTATE("1");
								
				updateProcessState(process);
				//获取霞个流程设置
				EpSetting  nextsetting = getNextSetting(set_spurtype,Integer.parseInt(set_nno));
				//如果最后一个流程，就不用新增下一步
				if(nextsetting == null){return;}
				// 添加下一步操作 为操作
				EpProcessForm form = new EpProcessForm();
				form.setBG_SNO(bg_sno);
				form.setEP_SNO(ep_sno);
				form.setSS_NNO(nextsetting.getSET_NID());
				form.setSS_SSTATE("0");
				insertProcess(form);
	}
	
	/*
	 * (non-Javadoc) 退回当前操作状态
	 * @see com.rc.project.service.PackageService#backCurrentProcess(javax.servlet.http.HttpServletRequest, com.rc.project.form.EpProcessForm)
	 */
	public void backCurrentProcess(HttpServletRequest request,EpProcessForm process){
		String ss_nid = request.getParameter("ss_nid");
		String set_nid = request.getParameter("set_nid");
		String set_nno = request.getParameter("set_nno");
		String bg_sno = request.getParameter("bg_sno");
		String ep_sno = request.getParameter("ep_sno");
		String set_spurtype = request.getParameter("set_spurtype");
		// 修改当前状态为退回
		process.setSS_NID(BigDecimal.valueOf(Integer.parseInt(ss_nid)));
		process.setSS_SSTATE("3");		
		updateProcessState(process);
		
		EpSetting  presetting = getPreSetting(set_spurtype,Integer.parseInt(set_nno));
		//如果沒有上一步操作，修改包状态
		if(presetting == null){
			ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext());
			ProjectService pService = (ProjectService) ctx.getBean("projectService");
			pService.back(bg_sno);	        
		}
		//添加下一步操作 为操作
		else{
			int setnnid = Integer.valueOf(set_nid);
			EpProcessForm form = new EpProcessForm();
			form.setBG_SNO(bg_sno);
			form.setEP_SNO(ep_sno);
			form.setSS_NNO(presetting.getSET_NID());
			form.setSS_SSTATE("0");
			insertProcess(form);
		}	
	}

	public List findEpsNo(){return epPackageDAO.findEpsNo();}
	
	public List findProject(List ids){return epPackageDAO.findProject(ids);}
	
	public List findPackage(String epsno){return epPackageDAO.findPackage(epsno);}
	
	public EpProcess findProcess(EpProcessForm form){return epPackageDAO.findProcess(form);}
	
	public EpSetting findSetting(int setId){return epPackageDAO.findSetting(setId);}

	public EpPackageListDAO getEpPackageListDAO() {
		return epPackageListDAO;
	}

	public void setEpPackageListDAO(EpPackageListDAO epPackageListDAO) {
		this.epPackageListDAO = epPackageListDAO;
	}

	public EpPackageDAO getEpPackageDAO() {
		return epPackageDAO;
	}

	public void setEpPackageDAO(EpPackageDAO epPackageDAO) {
		this.epPackageDAO = epPackageDAO;
	}

	public EpProcessDAO getEpProcessDAO() {
		return epProcessDAO;
	}

	public void setEpProcessDAO(EpProcessDAO epProcessDAO) {
		this.epProcessDAO = epProcessDAO;
	}

	public EpSettingDAO getEpSettingDAO() {
		return epSettingDAO;
	}

	public void setEpSettingDAO(EpSettingDAO epSettingDAO) {
		this.epSettingDAO = epSettingDAO;
	}
	
	

}
