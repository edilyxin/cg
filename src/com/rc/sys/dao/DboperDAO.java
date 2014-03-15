package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngDboperForm;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngDboper;
import com.rc.sys.vo.MngRight;

/**
 * 数据权限表数据库操作
 * @author GK
 *
 */
public class DboperDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDboperForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("dboper_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDboperForm form ){
		return getSqlMapClientTemplate().queryForList("dboper_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDboperForm form) {
		return getSqlMapClientTemplate().insert("dboper_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDboper findByID(String id){
		return (MngDboper)getSqlMapClientTemplate().queryForObject("dboper_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDboperForm form) {
		return ((Integer)getSqlMapClientTemplate().update("dboper_update", form)).equals(0)?false:true;
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
					bl = ((Integer)sqlMapClient.update("dboper_delete", idchecked[i])).equals(0)?false:true;;
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
					bl = ((Integer)sqlMapClient.update("dboper_changeValid", idchecked[i])).equals(0)?false:true;;
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

	public List findright(MngRightForm rightform) {
		return getSqlMapClientTemplate().queryForList("dboper_findright",rightform);
	}

	public List findsys(MngSysintForm sysform) {
		return getSqlMapClientTemplate().queryForList("dboper_findsys",sysform);
	}

	public boolean checkOnly(MngDboperForm form) {
		String s = form.getDboper_sno();
		System.out.println(s+"--------------------");
		int i;
		if("".equals(s)||s==null){
			i = (Integer) getSqlMapClientTemplate().queryForObject("dboper_checkOnly",form);
		}else{
			 i = (Integer) getSqlMapClientTemplate().queryForObject("dboper_checkOnly2",form);
		}
		
		return i == 0?false:true;//false代表唯一， true代表不是
	}
}

