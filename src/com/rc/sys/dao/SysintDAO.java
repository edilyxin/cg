package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngSysint;

/**
 * 用户表数据库操作
 * @author GK
 *
 */
public class SysintDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSysintForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("sysint_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSysintForm form ){
		return getSqlMapClientTemplate().queryForList("sysint_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSysintForm form) {
		return getSqlMapClientTemplate().insert("sysint_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSysint findByID(String id){
		return (MngSysint)getSqlMapClientTemplate().queryForObject("sysint_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSysintForm form) {
		return ((Integer)getSqlMapClientTemplate().update("sysint_update", form)).equals(0)?false:true;
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
					sqlMapClient.delete("sysint_delete", idchecked[i].split("%u0008")[0]);
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
					sqlMapClient.update("sysint_changeValid", idchecked[i].split("%u0008")[0]);
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
	 * 判断系统名称唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngSysintForm form){
		return ((Integer)getSqlMapClientTemplate().queryForObject("sysint_findname", form)).equals(0)?true:false;
	}
	
	
	 
	
	/**
	 * 判断系统名称是否被功能使用
	 * @param id
	 * @return
	 */
	public boolean findID(String id){
		int size=(Integer) getSqlMapClientTemplate().queryForObject("sysint_findID",id);
		boolean isOK=true;
		if(size>0){
			isOK=false;
		}
		return isOK;
	}
}

