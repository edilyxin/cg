package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpProjectDetailForm;

public interface ProjectDetailService {
	public List findPage(EpProjectDetailForm form);
	public int findSize(EpProjectDetailForm form);
	public boolean updatePurtType(int type,String[] idchecked);
}
