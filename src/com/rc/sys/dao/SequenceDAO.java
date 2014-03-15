package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngSequenceForm;
import com.rc.sys.vo.MngSequence;
import com.rc.sys.vo.MngTable;

/**
 * 编码表数据库操作
 * @author GK
 *
 */
public class SequenceDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSequenceForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("seq_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage1(MngTable form ){
		return getSqlMapClientTemplate().queryForList("table_findPage", form);
	}
	/**
	 * 查询结果数
	 */
	public Integer findSize1(MngTable form){
		return (Integer)getSqlMapClientTemplate().queryForObject("table_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSequenceForm form ){
		return getSqlMapClientTemplate().queryForList("seq_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSequenceForm form) {
		return getSqlMapClientTemplate().insert("seq_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSequence findByID(String id){
		return (MngSequence)getSqlMapClientTemplate().queryForObject("seq_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSequenceForm form) {
		return ((Integer)getSqlMapClientTemplate().update("seq_update", form)).equals(0)?false:true;
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
					sqlMapClient.update("seq_delete", idchecked[i]);
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
					sqlMapClient.update("seq_changeValid", idchecked[i]);
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
	//
	public MngSequence findSeq(MngSequenceForm form){
		return (MngSequence) getSqlMapClientTemplate().queryForObject("seq_findSeq",form);
	}
	public void updateCurvalue(MngSequence m){	
		getSqlMapClientTemplate().update("seq_updateCurvalue",m);
	}
	//检查名字唯一
	public boolean checkOnly(String seq_sname){
		int i = (Integer) getSqlMapClientTemplate().queryForObject("seq_checkOnly",seq_sname);
		return i == 0?true:false;//false代表唯一， true代表不是
	}
}

