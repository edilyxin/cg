package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngOperForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngOper;
import com.rc.sys.vo.MngRight;

/**
 * 操作表数据库操作
 * @author GK
 *
 */
public class OperDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngOperForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("oper_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngOperForm form ){
		return getSqlMapClientTemplate().queryForList("oper_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngOperForm form) {
		return getSqlMapClientTemplate().insert("oper_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngOper findByID(MngOperForm form){
		return (MngOper)getSqlMapClientTemplate().queryForObject("oper_findByID", form);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngOperForm form) {
		return ((Integer)getSqlMapClientTemplate().update("oper_update", form)).equals(0)?false:true;
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
					String str = idchecked[i];
					String[] arr = str.split("-");
					MngOperForm form =new MngOperForm();
					if (arr!=null) {
						form.setOper_sno(arr[0]);
						form.setSysint_sno(arr[1]);
					}
					sqlMapClient.update("oper_delete", form);
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
					String str = idchecked[i];
					String[] arr = str.split("-");
					MngOperForm form =new MngOperForm();
					if (arr!=null) {
						form.setOper_sno(arr[0]);
						form.setSysint_sno(arr[1]);
					}
					sqlMapClient.update("oper_changeValid", form);
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
	public List findOperByRight(String right_sno,String sysint_sno) {
		  HashMap hm = new HashMap();
		  hm.put("right_sno", right_sno);
		  hm.put("sysint_sno", sysint_sno);
		 return getSqlMapClientTemplate().queryForList("oper_findOperByRight",hm);
	}
	public List findAllsysint_sname() {
		return getSqlMapClientTemplate().queryForList("oper_findAllsysint_sname");
	}
	public MngRight findByID1(String id) {
		return (MngRight)getSqlMapClientTemplate().queryForObject("oper_findByID1", id);
	}
	public List findAllSname(MngOperForm form) {
		 return getSqlMapClientTemplate().queryForList("oper_findAllSname", form);
	}
	/**
	 * 判断系统名称唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngOperForm form){
		return ((Integer)getSqlMapClientTemplate().queryForObject("oper_findname", form)).equals(0)?true:false;
	}
}

