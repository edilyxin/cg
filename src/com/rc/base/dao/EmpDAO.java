package com.rc.base.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngEmpUserForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngEmp;
import com.rc.sys.form.MngUserForm;

/**
 * 职工表数据库操作
 * @author GK
 *
 */
public class EmpDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngEmpForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("emp_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngEmpForm form ){
		return getSqlMapClientTemplate().queryForList("emp_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngEmpForm form) {
		return getSqlMapClientTemplate().insert("emp_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngEmp findByID(String id){
		return (MngEmp)getSqlMapClientTemplate().queryForObject("emp_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngEmpForm form) {
		return ((Integer)getSqlMapClientTemplate().update("emp_update", form)).equals(0)?false:true;
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
					sqlMapClient.update("emp_delete", idchecked[i]);
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
					sqlMapClient.update("emp_changeValid", idchecked[i]);
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
	 * 遍历校区信息
	 * @return
	 */
    public List school(){
		return (List) getSqlMapClientTemplate().queryForList("emp_school");
  }
	
    
    /**
     * 查询职工用户记录数
     * 
     */
    public Integer empuserfindsize(MngEmpForm form){
		return (Integer) getSqlMapClientTemplate().queryForObject("emp_userfindsize",form);
    	
    	
    }
    
    
    /**
     * 查询职工用户结果数
     * 
     */
    public List empuserfindpage(MngEmpForm form){
		return getSqlMapClientTemplate().queryForList("emp_userfindpage",form);
    	
    	
    }
    
    
    /**
	 * 批量删除职工用户
	 * @param idchecked
	 * @return
	 */
	public boolean deleteuseremp(String[] idchecked){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(idchecked!=null){
				for(int i=0;i<idchecked.length;i++){
					bl = ((Integer)sqlMapClient.update("emp_empuserupdate1", idchecked[i])).equals(0)?false:true;;
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
    * 新增用户
    * @param no
    * @return
    */
    public String adduser( MngUserForm userform){
		return (String) getSqlMapClientTemplate().insert("insert_user",userform);
     }
    /**
     * 新增用户职工1
     * @param form
     * @return
     */
    public boolean saveEuser(MngEmpUserForm form) {
		return getSqlMapClientTemplate().insert("emp_empuseradd", form)==null?false:true;
		
	}
    
    /**
     * 查询已经分配的职工
     * @return
     */
    
    public List empuseempuserfind1(MngEmpUserForm form1){
		return getSqlMapClientTemplate().queryForList("emp_empuserfind1",form1);
    	
    }
    /**
     * 保存职工用户对照
     * @throws SQLException 
     */
    public  boolean saveempuser(MngEmpUserForm form1){
    	
    		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
    		
    		try{
    			sqlMapClient.startTransaction(); 
    	     	sqlMapClient.startBatch();
    			 
    			 
    			 
     			  	sqlMapClient.delete("emp_empuserupdate",form1);
    				sqlMapClient.insert("emp_empuseradd", form1);
    				 
    			 
    			sqlMapClient.executeBatch();
    			sqlMapClient.commitTransaction();
    			return true;
    		}catch(Exception e){
    			e.printStackTrace();
    			return false;
    		}finally{
    			try {
    				sqlMapClient.endTransaction();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	
  }
    /**
     * 遍历所有单位
     * @param udform
     * @return
     */
    
    public List udlist(MngUnitDepartForm udform){
		return getSqlMapClientTemplate().queryForList("ud_tree",udform);
     	
    }
    /**
     * 根据单位的隶属编号查询数据
     * @param udform
     * @return
     */
    
    public List udliststopno(MngUnitDepartForm udform){
		return getSqlMapClientTemplate().queryForList("ud_treestopno",udform);
     	
    }
    /**
     * 查询最低层次数
     * @return
     */
    public Integer  levels()
    {
    	
    	return (Integer)getSqlMapClientTemplate().queryForObject("tree_findUDnum");
    	
    }
    
    /**
	 * 遍历校区名
	 * @return
	 */
    public List toSchool(String sno){
		return (List) getSqlMapClientTemplate().queryForList("emp_school1",sno);
  }
    
    public List findbyNameAndSno1(MngEmpForm form){
    	return getSqlMapClientTemplate().queryForList("emp_findbyNameAndSno1", form);
    }
    
}

