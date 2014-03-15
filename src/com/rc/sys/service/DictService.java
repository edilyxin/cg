package com.rc.sys.service;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngDictForm;
import com.rc.sys.form.MngDictItemForm;
import com.rc.sys.vo.MngDict;
import com.rc.sys.vo.MngDictItem;
public interface DictService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDictForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDictForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDictForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDictForm form);

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
	
	

	/**
	 * 查询字典项
	 */
	public List findItemPage(MngDictItemForm form );
	

	/**
	 * 新增字典项
	 * @param form
	 * @return
	 */
	public boolean saveItem(MngDictItemForm form) ;
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findItemByID(String id);
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean updateItem(MngDictItemForm form) ;
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean deleteItem(String[] idchecked);
	public MngDictItem findDictItemByID(String id);
	
}
