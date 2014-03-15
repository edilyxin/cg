package com.rc.sys.service.impl;

import java.util.List;

import com.rc.sys.dao.DboperDAO;
import com.rc.sys.form.MngDboperForm;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.service.DboperService;
import com.rc.sys.vo.MngDboper;
import com.rc.sys.vo.MngRight;

public class DboperServiceImpl implements DboperService {
  
	private DboperDAO dboperDAO;

	public void setDboperDAO(DboperDAO dboperDAO) {
		this.dboperDAO = dboperDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDboperForm form){
		return dboperDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDboperForm form ){
		return dboperDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDboperForm form){
		return dboperDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDboper findByID(String id) {
		 
		return dboperDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDboperForm form) {
		return dboperDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return dboperDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return dboperDAO.changeValid(idchecked);	
	}
    /**
     * 查询全都的功能名称
     */

	public List findright(MngRightForm rightform) {
		// TODO Auto-generated method stub
		return dboperDAO.findright(rightform);
	}
    /**
     * 查询全都的系统的名称
     */
	public List findsys(MngSysintForm sysform) {
		// TODO Auto-generated method stub
		return dboperDAO.findsys(sysform);
	}

	public DboperDAO getDboperDAO() {
		return dboperDAO;
	}
	public boolean checkOnly(MngDboperForm form) {
		return dboperDAO.checkOnly(form);
	}
}
	
