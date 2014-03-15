package com.rc.sys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.dao.DictDAO;
import com.rc.sys.form.MngDictForm;
import com.rc.sys.form.MngDictItemForm;
import com.rc.sys.service.DictService;
import com.rc.sys.vo.MngDict;
import com.rc.sys.vo.MngDictItem;

public class DictServiceImpl implements DictService {
  
	private DictDAO dictDAO;

	public void setDictDAO(DictDAO dictDAO) {
		this.dictDAO = dictDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDictForm form){
		return dictDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDictForm form ){
		return dictDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDictForm form){
		return dictDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findByID(String id) {
		 
		return dictDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDictForm form) {
		return dictDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return dictDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return dictDAO.changeValid(idchecked);	
	}

	/**
	 * 查询字典项
	 */
	public List findItemPage(MngDictItemForm form ){
		return dictDAO.findItemPage(form);
	}
	

	/**
	 * 新增字典项
	 * @param form
	 * @return
	 */
	public boolean saveItem(MngDictItemForm form) {
		return dictDAO.saveItem(form);
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findItemByID(String id){
		return (MngDict)dictDAO.findItemByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean updateItem(MngDictItemForm form) {
		return dictDAO.updateItem(form);
	}
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean deleteItem(String[] idchecked){
		return dictDAO.deleteItem(idchecked);
	}

	public MngDictItem findDictItemByID(String id) {
		return dictDAO.findDictItemByID(id);
	}
	
}
	
