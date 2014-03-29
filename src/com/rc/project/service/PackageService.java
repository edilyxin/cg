package com.rc.project.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpSetting;

public interface PackageService {
	public List findEpsNo();
	
	public List findProject(List ids);
	
	public List findPackage(String epsno);
	
	public EpProcess findProcess(EpProcessForm form);
	
	public EpSetting findSetting(int setId);
	
	public List findPage();
	
	public boolean updateProcessState(EpProcessForm form);
	
	public boolean insertProcess(EpProcessForm form);
	public EpSetting findnextSetid(EpSettingForm form);
	
	public void submitCurrentProcess(HttpServletRequest request,EpProcessForm process);
	public void backCurrentProcess(HttpServletRequest request,EpProcessForm process);
	public void submitCurrentProcess(HttpServletRequest request,EpProcessForm process,String newBg_sno);
	public void skipProcess(HttpServletRequest request);
}
