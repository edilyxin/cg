package com.rc.sys.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rc.sys.form.TreeForm;

public class TreeDAO extends SqlMapClientDaoSupport{

	
	/**
	 * 查询最低的部门层次
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findUDCount(){
		return (Integer) getSqlMapClientTemplate().queryForObject("tree_findUDCount");
	}
	/**
	 * 查询单位信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findUD(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findUD",treeForm);
	}
	
	/**
	 * 查询单位信息数
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findUdSize(TreeForm treeForm){
		return (Integer) getSqlMapClientTemplate().queryForObject("tree_findUDSize",treeForm);
	}
	
	/**
	 * 查询一个部门的所有子部门单位信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findSonUD(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findSonUD",treeForm);
	}
	/**
	 * 查询学校信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findSchool(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findSchool",treeForm);
	}
	
	/**
	 * 查询学校信息数
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findSchoolSize (TreeForm treeForm){
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findSchoolSize",treeForm);
	}
	/**
	 * 
	 *  @Description    : 按条件查询员工信息
	 *  @Method_Name    : findEmp
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findEmp(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findEmp",treeForm);
		
	}
	/**
	 * 
	 *  @Description    : 按条件查询系统信息
	 *  @Method_Name    : findEmp
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findSys(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findSys",treeForm);
		
	}
	/**
	 * 查询员工结果数
	 */
	public Integer findEmpSize(TreeForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findEmpSize",form);
	}
	
	/**
	 * 查询员工结果分页
	 */
	public List findEmpPage(TreeForm form ){
		return getSqlMapClientTemplate().queryForList("tree_findEmpPage", form);
	}
	
	/**
	 * 
	 *  @Description    : 按条件查询单位信息
	 *  @Method_Name    : findComp
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findComp(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findComp",treeForm);
		
	}
	/**
	 * 
	 *  @Description    : 按条件查询部门信息
	 *  @Method_Name    : findDep
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findDep(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findDep",treeForm);
		
	}
	/**
	 * 
	 *  @Description    : 按条件查询岗位信息
	 *  @Method_Name    : findJob
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findJob(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findJob",treeForm);
		
	}
	/**
	 * 
	 *  @Description    : 按条件查询字典信息
	 *  @Method_Name    : findEmp
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findDict(TreeForm treeForm){
		return getSqlMapClientTemplate().queryForList("tree_findDict",treeForm);
		
	}

	/**
	 * 查询单位记录总条数
	 * @param form
	 * @return
	 */
	public Integer findCompSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findCompSize",form);
	}
	/**
	 * 根据单位记录分页
	 * @param form
	 * @return
	 */
	public List findCompPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findCompPage",form);
	}
	/**
	 * 查询部门记录总条数
	 * @param form
	 * @return
	 */
	public Integer findDepSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findDepSize",form);
	}
	/**
	 * 根据部门记录分页
	 * @param form
	 * @return
	 */
	public List findDepPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findDepPage",form);
	}
	/**
	 * 查询岗位记录总条数
	 * @param form
	 * @return
	 */
	public Integer findJobSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findJobSize",form);
	}
	/**
	 * 根据岗位记录分页
	 * @param form
	 * @return
	 */
	public List findJobPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findJobPage",form);
	}
	
	/**
	 * 根据功能记录分页
	 * @param form
	 * @return
	 */
	public List findRightPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findRight",form);
	}
	/**
	 * 查询功能记录总条数
	 * @param form
	 * @return
	 */
	public Integer findRightSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findRightSize",form);
	}
	/**
	 * 根据系统集成信息记录分页
	 * @param form
	 * @return
	 */
	public List findSysintPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findSysint",form);
	}
	/**
	 * 查询系统集成信息记录总条数
	 * @param form
	 * @return
	 */
	public Integer findSysintSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findSysintSize",form);
	}

	
	/**
	 * 
	 *职称mng_post放大镜 记录
	 * @param form
	 * @return
	 */
	public List findPostPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findPost",form);
	}
	/**
	 * 职称mng_post总条数
	 * @param form
	 * @return
	 */
	public Integer findPostSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findPostSize",form);
	}

	/**
	 * 根据用户记录分页
	 * @param form
	 * @return
	 */
	public List findUserPage(TreeForm form) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("tree_findUserPage",form);
	}
	/**
	 * 查询用户总条数
	 * @param form
	 * @return
	 */
	public Integer findUserSize(TreeForm form) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("tree_findUserSize",form);
	}
	
}
