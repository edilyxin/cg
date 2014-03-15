package com.rc.sys.service;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngUserForm;
import com.rc.sys.vo.MngRight;
import com.rc.sys.vo.MngRole;
import com.rc.sys.vo.MngUser;
public interface UserService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngUserForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngUserForm form );
	
	
	/**
	 * 特权分配之操作保存
	 */
	public Boolean saveUserOper(String userId,String[] checked );
	
	/**
	 * 特权分配之数据操作保存
	 */
	public Boolean saveDBOper(String userId,String[] checked );
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
	public boolean saveUserRight(String userid,String [] rightNos);
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngUserForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngUser findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngUserForm form);
	
	/**
	 * 修改当前用户密码
	 * @param form
	 * @return
	 */
	public boolean updatePwd(MngUserForm form);

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked);
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked);
	
	/**
	 * 
	 *  @Description    : 方法描述：查询所有角色
	 *  @Method_Name    : findRoles
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27上午10:10:48 
	 *  @Author         : 周剑
	 */
	public List findRoles();
	
	/**
	 * 
	 *  @Description    : 方法描述：根据给定的用户id号查询用户已拥有的角色
	 *  @Method_Name    : findUserRoles
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findUserRoles(MngUserForm form);
	
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
	public boolean addUserRoles(String userid,String [] roleNos);
	
	/**
	 * 
	 *  @Description    : 方法描述：查询用户已有操作
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public List findUserOperList(String userId);
	
	/**
	 * 
	 *  @Description    : 方法描述：查询所有数据权限
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public List findOperList();
	
	/**
	 * 
	 *  @Description    : 方法描述：查询用户已有数据权限
	 *  @Method_Name    : addUserRoles
	 *  @param userid
	 *  @param roleNos
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午03:02:52 
	 *  @Author         : 周剑
	 */
	public List findDBOperList(String userId);
	
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
	public boolean cancelUserRoles(String userid,String [] roleNos);
	
	/**
	 * 
	 *  @Description    : 方法描述：根据给定的用户id号查询用户已拥有的权限
	 *  @Method_Name    : findUserRights
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findUserRights(MngUserForm form);
	

	/**
	 * 
	 *  @Description    : 方法描述：查询所有权限
	 *  @Method_Name    : findUserRights
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-27下午02:29:14 
	 *  @Author         : 周剑
	 */
	public List findRights();
	
	/**
	 * 
	 *  @Description    : 方法描述：保存代理权限
	 *  @Method_Name    : saveDlRight
	 *  @param userid
	 *  @param rightNos
	 *  @param empNo
	 *  @param empNoBy
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-5-27下午06:29:15 
	 *  @Author         : 周剑
	 */
	public boolean saveDlRight(String userid,String [] rightNos,String empNo,String empNoBy);
	
	/**
	 *  @Description    : 方法描述：根据代理人和被代理人工号查询相关的代理权限
	 *  @Method_Name    : user_findDlRights
	 *  @return 
	 *  @return         : MngRight
	 *  @Creation Date  : 2013-6-4下午03:22:01 
	 *  @Author         : 周剑
	 */
	public List<MngRight> user_findDlRights(String empNO,String empNOBy,String userId,String sysint_sno);
	/**
	 * 
	 *  @Description    : 查询所有的代理人与被代理人
	 *  @Method_Name    : user_findPersonLook
	 *  @return 
	 *  @return         : List
	 */
	public List findPersonLook();
	/**
	 * 	                  根据用户id查询该用户的用户名，员工名。员工编号 
	 *  @Description    : ethod_Name    : findEmp
	 *  @param form
	 *  @return 
	 *  @return         : MngRole
	 */
	public MngRole findEmp(MngUserForm form);
	
	/**
	 * 
	 *  @Description    : 查询所有系统
	 *  @Method_Name    : findSysint
	 *  @return 
	 *  @return         : List
	 */
	public List findSysint();
	
	/**
	 * 
	 *  @Description    : 根据员工查询其所有具有的用户的权限集合
	 *  @Method_Name    : findRightByEmp
	 *  @param form
	 *  @return 
	 *  @return         : List
	 */
	public List findRightByEmp(MngUserForm form);
	/**
	 * 
	 *  @Description    : 查询某个用户所代理的所有员工
	 *  @Method_Name    : findDlEmp
	 *  @param userId
	 *  @return 
	 *  @return         : List
	 */
	public List findDlEmp(String userId);
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
	public List findDlRightsByNo(String empNO,String empNOBy,String userId,String sysint_sno);
	/**
	 * 
	 *  @Description    : 用户特权权限查询
	 *  @Method_Name    : findUserRightList
	 *  @param userId
	 *  @return 
	 *  @return         : List
	 */
	public List findUserRightList(MngRightForm userId);
	/**
	 * 
	 *  @Description    : 判断是否存在该账号
	 *  @Method_Name    : userUniqueName
	 *  @param name
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean userUniqueName(MngUserForm name);
}
