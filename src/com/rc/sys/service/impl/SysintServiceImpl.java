package com.rc.sys.service.impl;

import java.util.List;

import com.rc.sys.dao.SysintDAO;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.service.SysintService;
import com.rc.sys.vo.MngSysint;

public class SysintServiceImpl implements SysintService {
  
	private SysintDAO sysintDAO;

	public void setSysintDAO(SysintDAO sysintDAO) {
		this.sysintDAO = sysintDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSysintForm form){
		return sysintDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSysintForm form ){
		return sysintDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSysintForm form){
		return sysintDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSysint findByID(String id) {
		 
		return sysintDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSysintForm form) {
		return sysintDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return sysintDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return sysintDAO.changeValid(idchecked);	
	}

	/**
	 * 判断系统名称唯一
	 */
	public boolean checkUnique(MngSysintForm form) {
		return sysintDAO.checkUnique(form);
	}
 
	/**
	 * 判断系统编号是否被功能占用
	 */
	public boolean findID(String id) {
		return sysintDAO.findID(id);
	}
	
}
	
