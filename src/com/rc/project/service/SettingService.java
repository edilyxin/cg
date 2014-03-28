package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpSettingForm;
import com.rc.project.vo.EpSetting;

public interface SettingService {
	/**
	 * 查询结果数
	 */
	public Integer findSize(EpSettingForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(EpSettingForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(EpSettingForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public EpSetting findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(EpSettingForm form);

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked);
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked);
}
