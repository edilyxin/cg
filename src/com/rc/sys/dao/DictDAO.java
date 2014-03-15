package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngDictForm;
import com.rc.sys.form.MngDictItemForm;
import com.rc.sys.vo.MngDict;
import com.rc.sys.vo.MngDictItem;

/**
 * 字典表数据库操作
 * @author GK
 *
 */
public class DictDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDictForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("dict_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDictForm form ){
		return getSqlMapClientTemplate().queryForList("dict_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDictForm form) {
		return getSqlMapClientTemplate().insert("dict_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findByID(String id){
		return (MngDict)getSqlMapClientTemplate().queryForObject("dict_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDictForm form) {
		return ((Integer)getSqlMapClientTemplate().update("dict_update", form)).equals(0)?false:true;
	}
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked){
		boolean bl = false;
		String id = "";
		if(idchecked!=null){
			for(int i=0;i<idchecked.length;i++){
				id=idchecked[i];
				getSqlMapClientTemplate().update("dict_delete",id);
				//级联删除字典项
				getSqlMapClientTemplate().delete("deleteDictItems", id);
			}
		}
		return true;
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(idchecked!=null){
				for(int i=0;i<idchecked.length;i++){
					bl = ((Integer)sqlMapClient.update("dict_changeValid", idchecked[i])).equals(0)?false:true;;
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			return bl;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	/**
	 * 查询字典项
	 */
	public List findItemPage(MngDictItemForm form ){
		return getSqlMapClientTemplate().queryForList("getDictItem", form);
	}
	

	/**
	 * 新增字典项
	 * @param form
	 * @return
	 */
	public boolean saveItem(MngDictItemForm form) {
		return getSqlMapClientTemplate().insert("setDictItem", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDict findItemByID(String id){
		return (MngDict)getSqlMapClientTemplate().queryForObject("getDictItem", id);
	}
	public MngDictItem findDictItemByID(String id){
		return (MngDictItem)getSqlMapClientTemplate().queryForObject("dict_findItemByID", id);
	}
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean updateItem(MngDictItemForm form) {
		return ((Integer)getSqlMapClientTemplate().update("updateDictItem", form)).equals(0)?false:true;
	}
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean deleteItem(String[] idchecked){
		boolean bl = false;
		String id = "";
		if(idchecked!=null){
			for(int i=0;i<idchecked.length;i++){
				id=idchecked[i];
				getSqlMapClientTemplate().update("deleteDictItem",id);
			}
		}
		return true;
		
	}
}

