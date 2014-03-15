package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.rc.sys.form.MngRoleForm;
import com.rc.sys.vo.MngRole;
import com.rc.sys.vo.MngRoleDboper;
import com.rc.sys.vo.MngRoleOper;
import com.rc.sys.vo.MngRoleRight;
import com.rc.sys.vo.MngUserOper;
/**
 * 角色信息表数据库操作
 * @author GK
 *
 */
public class RoleDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRoleForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("role_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRoleForm form ){
		return getSqlMapClientTemplate().queryForList("role_findPage", form);
	}
	//查询 系统编号
	public List role_findMngSysint(MngRoleForm sysint_sno){
		return getSqlMapClientTemplate().queryForList("role_findMngSysint",sysint_sno);
	}
	//是否可以缺省
	public boolean role_isDefault(String id){
		int i = (Integer) getSqlMapClientTemplate().queryForObject("role_isDefault",id);
		return i==0?true:false; // 0  表示没有缺省，故可以缺省。  1 表示已经有了缺省
	}
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRoleForm form) {
		return getSqlMapClientTemplate().insert("role_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRole findByID(String id){
		return (MngRole)getSqlMapClientTemplate().queryForObject("role_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRoleForm form) {
		return ((Integer)getSqlMapClientTemplate().update("role_update", form)).equals(0)?false:true;
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
					sqlMapClient.update("role_delete", idchecked[i]);
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
					sqlMapClient.update("role_changeValid", idchecked[i]);
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
	//数据权限   
	public List finddbOperList(String id){
		if("".equals(id)){
			return getSqlMapClientTemplate().queryForList("dbOper_find");
		}
		return getSqlMapClientTemplate().queryForList("dbOper_find2",id);
	}
	public List roledbOperfind(String roleSid) {
		return getSqlMapClientTemplate().queryForList("roledbOper_find", roleSid);
	}
	//保存数据权限
	public void savedbRoleOper(final String roleSid,final String[] str,final String a){
		 // 执行回调  
		MngRoleDboper m1 = new MngRoleDboper();
		m1.setRole_sno(roleSid);
		m1.setRrd_sdef1(a);
		getSqlMapClientTemplate().delete("roledbOper_delete",m1);
		if(!"".equals(str)&&str!=null){
			for(String s:str){
				MngRoleDboper m = new MngRoleDboper();
				String[] list = s.split(":");//${v2.dboper_sno}:${v2.right_sno}
				m.setDboper_sno(list[0]);
				m.setRight_sno(list[1]);
				m.setRole_sno(roleSid);
				m.setRrd_sdef1(a);
				System.out.println(m.getRole_sno());
				System.out.println(m.getRrd_sdef1());
				getSqlMapClientTemplate().insert("roledbOper_insert",m);
			}
		}

	}
	
	
	//功能权限
	public List findRoleRightList(MngRoleForm roleSid) {
		return getSqlMapClientTemplate().queryForList("roleright_find", roleSid);
	}
	//功能权限  全部列表
	public List findAllRoleRightList(MngRoleForm roleSid){
		return getSqlMapClientTemplate().queryForList("right_find",roleSid);
	}
	//保存功能权限
	public void saveRoleFunc(final String roleSid,final String str){
		
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {


			// 实现回调接口
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// 开始批处理
				executor.startBatch();
				MngRoleRight r = new MngRoleRight();
				String[] list = str.split("-");// [1 2 3] 3
				executor.delete("roleright_delete", roleSid);
				for (int i = 1; i < list.length; i++) { // 从数组[1] 开始执行数组长度次
					r.setRole_sno(roleSid);
					//System.out.println("开始："+(list[i]));
					if(list[i].indexOf("|")>-1){
						String[] str1 = list[i].split("\\|");
						//r.setRight_sno(list[i]);
						//System.out.println(str1.length+",数组的长度？,"+str1[0]+","+str1[1]);
						r.setRight_sno(str1[0]);
						r.setRr_sdef1(str1[1]);
					}
					
					executor.insert("roleright_insert", r);
				}

				// 执行批处理
				executor.executeBatch();
				return null;
			}
		});
		
	}
	//一个角色操作权限
	public List findRoleOperList(String roleSid) {
		return getSqlMapClientTemplate().queryForList("roleoper_find", roleSid);
	}
	//操作权限
	public List findOperList(String sysint_sno){ 
		return getSqlMapClientTemplate().queryForList("oper_find",sysint_sno);
	}
	//保存功能权限
	public boolean saveRoleOper( String roleSid, String[] str){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			MngRoleOper r = new MngRoleOper();
			sqlMapClient.delete("roleoper_delete", roleSid);
			if(str!=null){
		   		r.setRole_sno(roleSid);
		   		for(int i=0; i<str.length; i++){ //从数组[1] 开始执行数组长度次	
		   			if(str[i]!=""&&str[i]!=null){
		   				String[] list1 = str[i].split(":");
		   				if(list1.length==3){
		   					r.setOper_sno(list1[0]);
			   				r.setRight_sno(list1[1]);
			   				r.setRro_sdef1(list1[2]);
					   		bl = sqlMapClient.insert("roleoper_insert", r)==null?false:true;
		   				}else{
		   					bl = true;
		   				}
		   			}   
		   			
		   		}
			}else{
				bl = true;
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
				e.printStackTrace();
			}
		}
		 
	}
	/**
	 * 根据角色id查询该角色下的用户
	 */
	public List getUserByRole(MngRoleForm roleSid){
		return getSqlMapClientTemplate().queryForList("getUserByRole", roleSid);
	}
	/**
	 * 
	 *  @Description    : 角色名称唯一性验证
	 *  @Method_Name    : UniqueName
	 *  @param form
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean UniqueName(MngRoleForm form){
		boolean bl = true;
		int size = (Integer) getSqlMapClientTemplate().queryForObject("role_uniqueName",form);
		if(size > 0){
			bl = false ;
		}
		return bl;
	}
}

