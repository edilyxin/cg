package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngLogForm;
import com.rc.sys.vo.MngLog;

/**
 * 日志表数据库操作
 * @author GK
 *
 */
public class LogDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngLogForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("log_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngLogForm form ){
		return getSqlMapClientTemplate().queryForList("log_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngLogForm form) {
		return getSqlMapClientTemplate().insert("log_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngLog findByID(String id){
		return (MngLog)getSqlMapClientTemplate().queryForObject("log_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngLogForm form) {
		return ((Integer)getSqlMapClientTemplate().update("log_update", form)).equals(0)?false:true;
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
					bl = ((Integer)sqlMapClient.update("log_delete", idchecked[i])).equals(0)?false:true;;
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
					bl = ((Integer)sqlMapClient.update("log_changeValid", idchecked[i])).equals(0)?false:true;;
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
}

