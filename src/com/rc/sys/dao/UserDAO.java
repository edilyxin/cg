package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngUserForm;
import com.rc.sys.vo.MngRight;
import com.rc.sys.vo.MngRole;
import com.rc.sys.vo.MngRoleOper;
import com.rc.sys.vo.MngUser;
import com.rc.sys.vo.MngUserDboper;
import com.rc.sys.vo.MngUserOper;

/**
 * 用户表数据库操作
 * @author GK
 *
 */
public class UserDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngUserForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("user_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngUserForm form ){
		return getSqlMapClientTemplate().queryForList("user_findPage", form);
	}
	
	/**
	 * 查询用户已有操作
	 */
	public List findUserOperList(String userId) {
		return getSqlMapClientTemplate().queryForList("useroper_find", userId);
	}
	
	/**
	 * 查询用户已有数据权限
	 */
	public List findDBOperList(String userId) {
		return getSqlMapClientTemplate().queryForList("dboper_find", userId);
	}
	
	/**
	 * 查询所有数据权限
	 */
	public List findOperList() {
		return getSqlMapClientTemplate().queryForList("dballoper_find");
	}

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngUserForm form) {
		return getSqlMapClientTemplate().insert("user_add", form)==null?false:true;
		
	}
	
	/**
	 * 特权分配之操作保存
	 * @param userId
	 * @param str
	 */
	public Boolean saveUserOper(String userId,String[] str){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			//sqlMapClient.startBatch();
			MngUserOper r = new MngUserOper();
			if(str!=null&&str.length>0){
		   		String[] list = str;
		   		sqlMapClient.delete("useroper_delete", userId);
		   		r.setUserid(Long.valueOf(userId));
		   		for(int i=0; i<list.length; i++){ //从数组[1] 开始执行数组长度次	
		   			if(list[i]!=""&&list[i]!=null){
		   				String[] list1 = list[i].split("-");
		   				if(list1.length==3){
		   					r.setOper_sno(list1[0]);
			   				r.setRight_sno(list1[1]);
			   				r.setSysint_sno(list1[2]);
					   		bl = sqlMapClient.insert("useroper_insert", r)==null?false:true;
		   				}else{
		   					bl = true;
		   				}
		   			}   
		   			
		   		}
			}else{
				sqlMapClient.delete("useroper_delete", userId);
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
	 * 特权分配之数据操作保存
	 * @param userId
	 * @param str
	 */
	public Boolean saveDBOper(String userId,String[] str){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			MngUserDboper r = new MngUserDboper();
	   		String[] list = str;//[1 2 3] 3
	   		sqlMapClient.delete("dbuseroper_delete", userId);
	   		r.setUsersid(Long.valueOf(userId));
	   		for(int i=0; i<list.length; i++){ //从数组[1] 开始执行数组长度次	
	   			if(list[i]!=""&&list[i]!=null){
	   				String[] list1 = list[i].split("-");
	   				if(list1.length==3){
	   				//${lst.dboper_sno}-${lst.right_sno}-${lst.sysint_sno}
		   				r.setDboper_sno(list1[0]);
		   				r.setRight_sno(list1[1]);
		   				r.setSysint_sno(list1[2]);
		   				bl = sqlMapClient.insert("dboper_insert", r)==null?false:true;
	   				}else{
	   					bl = true;
	   				}
	   				
	   				
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
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngUser findByID(String id){
		return (MngUser)getSqlMapClientTemplate().queryForObject("user_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngUserForm form) {
		return ((Integer)getSqlMapClientTemplate().update("user_update", form)).equals(0)?false:true;
	}
	
	/**
	 * 修改当前用户密码
	 * @param form
	 * @return
	 */
	public boolean updatePwd(MngUserForm form) {
		return ((Integer)getSqlMapClientTemplate().update("user_updatePwd", form)).equals(0)?false:true;
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
					sqlMapClient.delete("user_delete", idchecked[i]);
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
					sqlMapClient.update("user_changeValid", idchecked[i]);
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
	 * 
	 *  @Description    : 方法描述：查询所有角色
	 *  @Method_Name    : findRoles
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27上午10:10:04 
	 *  @Author         : 周剑
	 */
	public List findRoles(){
		return this.getSqlMapClientTemplate().queryForList("user_findRoles");
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：根据给定的用户id号查询用户已拥有的角色
	 *  @Method_Name    : findUserRoles
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findUserRoles(MngUserForm form){
		return this.getSqlMapClientTemplate().queryForList("user_findUserRoles",form);
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：根据给定的用户id号查询用户已拥有的权限
	 *  @Method_Name    : findUserRights
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findUserRights(MngUserForm form){
		return this.getSqlMapClientTemplate().queryForList("user_findUserRights",form);
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：查询所有权限
	 *  @Method_Name    : findUserRights
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findRights(){
		return this.getSqlMapClientTemplate().queryForList("user_findRights");
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：保存给用户分配的角色
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public boolean addUserRoles(String userid,String [] roleNos){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			System.out.println("进来没有DAO1");
			if(roleNos!=null){
				//先将该用户的所有权限都删除
				System.out.println("进来没有DAO");
				MngRole form1 = new MngRole();
				form1.setUserid(userid);
				Integer a = sqlMapClient.delete("user_cancelUserAllRoles", form1);
				//新增用户的权限
				for(int i=0;i<roleNos.length;i++){
					HashMap<String,String> map=new HashMap<String,String>();
					String roleNo=roleNos[i];
					map.put("userid",userid);
					/*if(roleNo.indexOf("-")<-1){*/
						map.put("roleNo", roleNo);
					/*}else{
						String[] abc = roleNo.split("-");
						map.put("roleNo", abc[0]);
						map.put("ur_sdef1",abc[1]);
					}*/
					
					
					bl = ((Integer)sqlMapClient.insert("user_addUserRoles",map)).equals(0)?false:true;;
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
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 *  @Description    : 方法描述：保存代理权限
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public boolean saveDlRight(String userid,String [] rightNos,String empNo,String empNoBy){
		boolean bl = true;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		HashMap<String,String> map=null;
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			//保存代理权限前先将以前的所有的权限全部删除
			MngUserForm form = new MngUserForm();
			form.setUserid(userid);
			sqlMapClient.delete("user_deleteDlRight", form);
			if(rightNos!=null){
				for(int i=0;i<rightNos.length;i++){
					map=new HashMap<String,String>();
					String[] rightNo=rightNos[i].split("\\|");
					map.put("userid",userid);
					System.out.println(rightNo[0]+","+rightNo[1]+","+rightNos[i]);
					map.put("right_sno", rightNo[0]);
					map.put("sysint_sno", rightNo[1]);
					map.put("empNo",empNo);
					map.put("empNoBy",empNoBy);
					sqlMapClient.insert("user_saveDlRight",map);
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
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 *  @Description    : 方法描述：保存用户特权权限
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 戴超
	 */
	public boolean saveUserRight(String userid,String [] rightNos){
		boolean bl = true;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		HashMap<String,String> map=null;
		try{
			sqlMapClient.startTransaction(); 
			//sqlMapClient.startBatch();
			//保存用户特权权限前先将以前的所有的用户特权权限全部删除
			MngUserForm form = new MngUserForm();
			form.setUserid(userid);
			sqlMapClient.delete("userright_delete", form);
			if(rightNos!=null){
				for(int i=0;i<rightNos.length;i++){
					map=new HashMap<String,String>();
					String[] rightNo=rightNos[i].split("\\|");
					map.put("userid",userid);
					System.out.println(rightNo[0]+","+rightNo[1]+","+rightNos[i]+","+userid);
					map.put("right_sno", rightNo[0]);
					map.put("sysint_sno", rightNo[1]);
					sqlMapClient.insert("userright_insert",map);
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
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：注销给用户分配的角色
	 *  @Method_Name    : cancelUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public boolean cancelUserRoles(String userid,String [] roleNos){
		boolean bl = true;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(roleNos!=null){
				for(int i=0;i<roleNos.length;i++){
					HashMap<String,String> map=new HashMap<String,String>();
					String roleNo=roleNos[i];
					map.put("userid",userid);
					map.put("roleNo", roleNo);
					sqlMapClient.delete("user_cancelUserRoles",map);
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
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *  @Description    : 方法描述：根据代理人和被代理人工号,及用户查询相关的代理权限
	 *  @Method_Name    : user_findDlRights
	 *  @return 
	 *  @return         : MngRight
	 *  @Creation Date  : 2013-6-4下午03:22:01 
	 *  @Author         : 周剑
	 */
	@SuppressWarnings("unchecked")
	public List<MngRight> user_findDlRights(String empNO,String empNOBy,String userId,String sysint_sno){
		Map<String,String> map=new HashMap<String, String>();
		map.put("empNO", empNO);
		map.put("empNOBy", empNOBy);
		map.put("userId", userId);
		map.put("sysint_sno", sysint_sno);
		return this.getSqlMapClientTemplate().queryForList("user_findDlRights",map);
	}
	/**
	 * 
	 *  @Description    : 查询所有的代理人与被代理人
	 *  @Method_Name    : user_findPersonLook
	 *  @return 
	 *  @return         : List
	 */
	public List user_findPersonLook(){
		return getSqlMapClientTemplate().queryForList("user_findPersonLook");
	}
	/**
	 * 	                  根据用户id查询该用户的用户名，员工名。员工编号 
	 *  @Description    : ethod_Name    : findEmp
	 *  @param form
	 *  @return 
	 *  @return         : MngRole
	 */
	public MngRole findEmp(MngUserForm form){
		return (MngRole) getSqlMapClientTemplate().queryForObject("user_findEmp",form );
	}
	/**
	 * 
	 *  @Description    : 查询所有系统
	 *  @Method_Name    : findSysint
	 *  @return 
	 *  @return         : List
	 */
	public List findSysint(){
		return getSqlMapClientTemplate().queryForList("user_findSysint");
	}
	/**
	 * 
	 *  @Description    : 根据员工查询其所有具有的用户的权限集合
	 *  @Method_Name    : findRightByEmp
	 *  @param form
	 *  @return 
	 *  @return         : List
	 */
	public List findRightByEmp(MngUserForm form){
		return getSqlMapClientTemplate().queryForList("user_findRightByEmp",form);
	}
	/**
	 * 
	 *  @Description    : 删除用户的所有代理权限
	 *  @Method_Name    : deleteDlRight
	 *  @param form 
	 *  @return         : void
	 */
	public void deleteDlRight(MngUserForm form){
		getSqlMapClientTemplate().delete("user_deleteDlRight", form);
	}
	/**
	 * 
	 *  @Description    : 查询某个用户所代理的所有员工
	 *  @Method_Name    : findDlEmp
	 *  @param userId
	 *  @return 
	 *  @return         : List
	 */
	public List findDlEmp(String userId){
		return getSqlMapClientTemplate().queryForList("user_findDlEmp", userId);
	}
	/**
	 * 
	 *  @Description    : 根据代理人用户和被代理人的员工号查询所被代理的所有的权限
	 *  @Method_Name    : findDlRightsByNo
	 *  @param empNO
	 *  @param empNOBy
	 *  @param userId
	 *  @return 
	 *  @return         : List
	 */
	public List findDlRightsByNo(String empNO,String empNOBy,String userId,String sysint_sno){
		Map<String,String> map=new HashMap<String, String>();
		map.put("empNOBy", empNOBy);
		map.put("userId", userId);
		map.put("empNO", empNO);
		map.put("sysint_sno", sysint_sno);
		return getSqlMapClientTemplate().queryForList("user_findDlRightsByNo", map);
	}
	/**
	 * 
	 *  @Description    : 用户特权权限查询
	 *  @Method_Name    : findUserRightList
	 *  @param userId
	 *  @return 
	 *  @return         : List
	 */
	public List findUserRightList(MngRightForm userId){
		return getSqlMapClientTemplate().queryForList("user_findUserRightList", userId);
	}
	/**
	 * 
	 *  @Description    : 判断是否存在该账号
	 *  @Method_Name    : userUniqueName
	 *  @param name
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean userUniqueName(MngUserForm name){
		Integer size = (Integer) getSqlMapClientTemplate().queryForObject("user_uniqueName", name);
		boolean bl = true;
		if(size>0){
			bl = false;
		}
		return bl;
	}
}

