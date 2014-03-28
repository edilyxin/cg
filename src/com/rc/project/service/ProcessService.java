package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpProcessForm;
import com.rc.project.vo.EpProcess;

public interface ProcessService {
	public EpProcess findById(int id);
	
	public List findPage(EpProcessForm form);
	
	public int findSize(EpProcessForm form);
	
	public boolean insert(EpProcessForm form);
	
	public boolean update(EpProcessForm form);
}
