package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpProjectForm;
import com.rc.project.vo.EpProject;
import com.rc.project.vo.EpProjectDetail;
import com.rc.project.vo.RpReport;

public interface ProjectReplyService {
	
	/**
	 * 查找项目批复
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public List<EpProject> findForAuto(EpProjectForm form) throws Exception;
	/**
	 * 查询项目批复明细信息
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public List<EpProjectDetail> findDetailForAuto(EpProjectDetailForm form) throws Exception;
	/**
	 * 导入项目批复信息
	 * @param form
	 * @throws Exception
	 */
	public void importData(EpProjectForm form) throws Exception;
	
	public int findSize(EpProjectForm form) throws Exception;
	
	public RpReport findProjectByNo(String no)  throws Exception;

}
