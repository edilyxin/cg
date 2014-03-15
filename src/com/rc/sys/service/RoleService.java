package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngRoleForm;
import com.rc.sys.vo.MngRole;
public interface RoleService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRoleForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRoleForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRoleForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRole findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRoleForm form);

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
	//查询 系统编号
	public List role_findMngSysint(MngRoleForm sysint_sno);
	//是否可以缺省
	public boolean role_isDefault(String id);
	
	//权限
	public List findAllRoleRightList(MngRoleForm roleSid );
	public void saveRoleFunc(String roleSid,String str);
	//功能权限  全部列表
	public List findRoleRightList(MngRoleForm roleSid );
	//一个角色操作权限
	public List findRoleOperList(String roleSid);
	public List findOperList(String sysint_sno);
	//保存功能权限
	public void saveRoleOper(String roleSid,String[] str);
	
	//数据权限
	public List finddbOperList(String s);
	//保存数据权限
	public void savedbRoleOper(final String roleSid,final String[] str,final String a);
	public List roledbOperfind(String roleSid);
	/**
	 * 根据角色id查询该角色下的用户
	 */
	public List getUserByRole(MngRoleForm roleSid);
	/**
	 * 
	 *  @Description    : 角色名称唯一性验证
	 *  @Method_Name    : UniqueName
	 *  @param form
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean UniqueName(MngRoleForm form);
}
