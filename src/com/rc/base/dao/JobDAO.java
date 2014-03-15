package com.rc.base.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.base.form.MngJobForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngJob;

/**
 * 岗位信息表数据库操作
 * @author GK
 *
 */
public class JobDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngJobForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("job_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngJobForm form ){
		return getSqlMapClientTemplate().queryForList("job_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngJobForm form) {
		return getSqlMapClientTemplate().insert("job_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngJob findByID(String id){
		return (MngJob)getSqlMapClientTemplate().queryForObject("job_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngJobForm form) {
		return ((Integer)getSqlMapClientTemplate().update("job_update", form)).equals(0)?false:true;
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
					sqlMapClient.update("job_delete", idchecked[i]);
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
					sqlMapClient.update("job_changeValid", idchecked[i]);
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
	public List findAllSname(MngJobForm form) {
		// TODO Auto-generated method stub
		 return getSqlMapClientTemplate().queryForList("job_findAllSname", form);
	}
	public List findNlevel(MngJobForm form) {
		return getSqlMapClientTemplate().queryForList("job_findNlevel", form);
	}
	public List findUdSname(MngUnitDepartForm departForm) {
		return getSqlMapClientTemplate().queryForList("job_findUdSname", departForm);
	}
	public Integer findMaxNLevel(String job_stype) {
		
		Integer level = 0;
		try{
			level = (Integer) getSqlMapClientTemplate().queryForObject("job_findMaxNLevel",job_stype);
		}catch(Exception e){
			e.printStackTrace();

		} 
		if(level == null ){
			level = 0;
		}
		level++;
		return level;
	}
	
	public List findTreeList() {
		return getSqlMapClientTemplate().queryForList("job_findTreeList");
	}
	public List findUD(MngUnitDepartForm departForm) {
		return getSqlMapClientTemplate().queryForList("job_findUD");
	}
	/**
	 * 遍历所有的岗位
	 */
	public List findAlljob() {
		return getSqlMapClientTemplate().queryForList("job_findAlljob");
	}
	
	public boolean checkUnique(MngJobForm form){
		return ((Integer)getSqlMapClientTemplate().queryForObject("job_findname", form)).equals(0)?true:false;
	}
}

