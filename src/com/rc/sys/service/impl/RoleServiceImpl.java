package com.rc.sys.service.impl;

import java.util.List;

import com.rc.sys.dao.RoleDAO;
import com.rc.sys.form.MngRoleForm;
import com.rc.sys.service.RoleService;
import com.rc.sys.vo.MngRole;

public class RoleServiceImpl implements RoleService {
  
	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRoleForm form){
		return roleDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRoleForm form ){
		return roleDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRoleForm form){
		return roleDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRole findByID(String id) {
		 
		return roleDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRoleForm form) {
		return roleDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return roleDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return roleDAO.changeValid(idchecked);	
	}
	
	/**
	 * 根据角色id查询该角色下的用户
	 */
	public List getUserByRole(MngRoleForm roleSid){
		return roleDAO.getUserByRole(roleSid);	
	}

	public List role_findMngSysint(MngRoleForm sysint_sno) {
	
		return roleDAO.role_findMngSysint(sysint_sno);
	}

	public boolean role_isDefault(String id) {
		return roleDAO.role_isDefault(id);
	}

	public List findAllRoleRightList(MngRoleForm roleSid) {
		return roleDAO.findAllRoleRightList(roleSid);
	}
	public void saveRoleFunc(String roleSid, String str) {
		roleDAO.saveRoleFunc(roleSid, str);
	}
	public List findRoleRightList(MngRoleForm roleSid ) {
		return roleDAO.findRoleRightList(roleSid);
	}
	public List findRoleOperList(String roleSid) {
		return roleDAO.findRoleOperList(roleSid);
	}
	public List findOperList(String sysint_sno) {
		return roleDAO.findOperList(sysint_sno);
	}

	public void saveRoleOper(String roleSid, String[] str) {
		roleDAO.saveRoleOper(roleSid, str);
	}

	public List finddbOperList(String s) {
		return roleDAO.finddbOperList(s);
	}

	
	public void savedbRoleOper(String roleSid, String[] str,String a) {
		 roleDAO.savedbRoleOper(roleSid,str,a);
		
	}

	public List roledbOperfind(String roleSid) {
		return roleDAO.roledbOperfind(roleSid);
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
		return roleDAO.UniqueName(form);
	}
	
	
}
	
