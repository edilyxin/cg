package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngParmForm;
import com.rc.sys.vo.MngParm;
import com.rc.sys.vo.MngSysint;

/**
 * 参数表数据库操作
 * @author GK
 *
 */
public class ParmDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngParmForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("parm_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngParmForm form ){
		return getSqlMapClientTemplate().queryForList("parm_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngParmForm form) {
		return getSqlMapClientTemplate().insert("parm_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngParm findByID(String id){
		return (MngParm)getSqlMapClientTemplate().queryForObject("parm_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngParmForm form) {
		return ((Integer)getSqlMapClientTemplate().update("parm_update", form)).equals(0)?false:true;
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
					sqlMapClient.update("parm_delete", idchecked[i]);
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
					sqlMapClient.update("parm_changeValid", idchecked[i]);
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
	
		public List<MngSysint> sysinfo(){
			return getSqlMapClientTemplate().queryForList("parm_sysint_sno");		
			}    
		/**
		 * 验证唯一性
		 * @param form
		 * @return
		 */
		
		public boolean findAllSname(MngParmForm form){
			return ((Integer) getSqlMapClientTemplate().queryForObject("parm_findsname",form)).equals(0)?true:false;
			
		}

		/**
		 * 根据参数名查询参数值
		 * @param sysint_sno 系统编号
		 * @param parm_sname 显示名称
		 * @return 参数值
		 */
	    public String getValue(String sysint_sno ,String parm_sname){
	    	HashMap hm = new HashMap();
	    	hm.put("sysint_sno", sysint_sno);
	    	hm.put("parm_sname", parm_sname);
	    	return (String) getSqlMapClientTemplate().queryForObject("parm_getValue",hm);
	    }
}

