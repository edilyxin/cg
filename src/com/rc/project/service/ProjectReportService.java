package com.rc.project.service;

import java.util.List;

import com.rc.project.form.RpReportForm;


public interface ProjectReportService {
	
	/**
	 * 查询上报申报单
	 * @param form
	 * @return
	 */
	public List findPage(RpReportForm form);
	
	/**
	 * 上传上报申报单
	 * @param form
	 * @throws Exception
	 */
	public void importData(RpReportForm form) throws Exception;
	
	public int findSize(RpReportForm form) throws Exception;
}
