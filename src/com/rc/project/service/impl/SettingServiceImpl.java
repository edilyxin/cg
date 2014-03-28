package com.rc.project.service.impl;

import java.util.List;

import com.rc.project.form.EpSettingForm;
import com.rc.project.service.SettingService;
import com.rc.project.vo.EpSetting;
import com.rc.project.dao.EpSettingDAO;

public class SettingServiceImpl implements SettingService{
	private EpSettingDAO settingDAO;
	
	public void setEpSettingDAO(EpSettingDAO settingDAO){
		this.settingDAO = settingDAO;
	}

	@Override
	public Integer findSize(EpSettingForm form) {
		// TODO Auto-generated method stub
		return this.settingDAO.findSize(form);
	}

	@Override
	public List findPage(EpSettingForm form) {
		// TODO Auto-generated method stub
		return this.settingDAO.findPage(form);
	}

	@Override
	public boolean save(EpSettingForm form) {
		// TODO Auto-generated method stub
		return this.settingDAO.insert(form);
	}

	@Override
	public EpSetting findByID(String id) {
		// TODO Auto-generated method stub
		return this.settingDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean update(EpSettingForm form) {
		// TODO Auto-generated method stub
		return settingDAO.updateByPrimaryKey(form);
	}

	@Override
	public boolean delete(String[] idchecked) {
		// TODO Auto-generated method stub
		return settingDAO.delte(idchecked);
	}

	@Override
	public boolean changeValid(String[] idchecked) {
		// TODO Auto-generated method stub
		return settingDAO.changeValid(idchecked);
	}

}
