package com.rc.base.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.base.form.MngSchoolForm;
import com.rc.base.vo.MngSchool;

/**
 * 校区信息表数据库操作
 * @author GK
 *
 */
public class SchoolDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSchoolForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("school_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSchoolForm form ){
		return getSqlMapClientTemplate().queryForList("school_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSchoolForm form) {
		return getSqlMapClientTemplate().insert("school_add", form)==null?false:true;
		
	}
	
	/**
	 * 验证唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngSchoolForm form) {
		return ((Integer)getSqlMapClientTemplate().queryForObject("school_findByName", form)).equals(0)?true:false;
		/*int size = (Integer) getSqlMapClientTemplate().queryForObject("school_findByName", form);
		boolean isOK = false;
		if (size == 0) {
			isOK = true;
		}
		return isOK;*/
	}
	
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSchool findByID(String id){
		return (MngSchool)getSqlMapClientTemplate().queryForObject("school_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSchoolForm form) {
		return ((Integer)getSqlMapClientTemplate().update("school_update", form)).equals(0)?false:true;
	}
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(idchecked!=null){
				for(int i=0;i<idchecked.length;i++){
					sqlMapClient.update("school_delete", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			 bl = true;
		}catch(Exception e){
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bl;
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
					sqlMapClient.update("school_changeValid", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			 bl = true;
		}catch(Exception e){
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bl;
	}
	
	/**
	 * 查询所有校区信息
	 * @return
	 */
	public List findAll() {
		return getSqlMapClientTemplate().queryForList("school_findAll");
	}
}

