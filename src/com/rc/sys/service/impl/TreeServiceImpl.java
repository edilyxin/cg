package com.rc.sys.service.impl;

import java.util.List;

import com.rc.base.vo.MngEmp;
import com.rc.sys.dao.TreeDAO;
import com.rc.sys.form.TreeForm;
import com.rc.sys.service.TreeService;

public class TreeServiceImpl implements TreeService {
	private TreeDAO treeDAO;
	
	public void setTreeDAO(TreeDAO treeDAO) {
		this.treeDAO = treeDAO;
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
		return treeDAO.findEmp(treeForm);
		
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
		return treeDAO.findSys(treeForm);
		
	}
	/**
	 * 
	 *  @Description    : 按条件查询字典信息
	 *  @Method_Name    : findDict
	 *  @param treeForm
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-4-12下午10:35:36 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public List findDict(TreeForm treeForm){
		return treeDAO.findDict(treeForm);
		
	}
	public List findComp(TreeForm treeForm) {
		// TODO Auto-generated method stub
		return treeDAO.findComp(treeForm);
	}
	public List findDep(TreeForm treeForm) {
		// TODO Auto-generated method stub
		return treeDAO.findDep(treeForm);
	}
	public List findJob(TreeForm treeForm) {
		// TODO Auto-generated method stub
		return treeDAO.findJob(treeForm);
	}
	
	public Integer findEmpSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findEmpSize(form);
	}
	public List findEmpPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findEmpPage(form);
	}
	public Integer findCompSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findCompSize(form);
	}
	public List findCompPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findCompPage(form);
	}
	public Integer findDepSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findDepSize(form);
	}
	public List findDepPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findDepPage(form);
	}
	public Integer findJobSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findJobSize(form);
	}
	public List findJobPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findJobPage(form);
	}
	/**
	 * 查询最低的部门层次
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findUDCount(){
		return treeDAO.findUDCount();
	}
	/**
	 * 查询一个部门的所有子部门单位信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findSonUD(TreeForm treeForm){
		return treeDAO.findSonUD(treeForm);
	}
	/*
	 * 查询单位信息
	 * @see com.rc.sys.service.TreeService#findUD(com.rc.sys.form.TreeForm)
	 */
	public List findUD(TreeForm treeForm) {
		return treeDAO.findUD(treeForm);
	}
	/*(
	 * 查询单位信息数
	 * @see com.rc.sys.service.TreeService#findUdSize(com.rc.sys.form.TreeForm)
	 */
	public Integer findUdSize(TreeForm treeForm) {
		return treeDAO.findUdSize(treeForm);
	}
	/*\
	 * 查询学校信息
	 * @see com.rc.sys.service.TreeService#findSchool(com.rc.sys.form.TreeForm)
	 */
	public List findSchool(TreeForm treeForm) {
		return treeDAO.findSchool(treeForm);
	}
	/*
	 * 查询学校信息数
	 * @see com.rc.sys.service.TreeService#findSchoolSize(com.rc.sys.form.TreeForm)
	 */
	public Integer findSchoolSize(TreeForm treeForm) {
		return treeDAO.findSchoolSize(treeForm);
	}
	
	/**
	 * 根据功能记录分页
	 * @param form
	 * @return
	 */
	public List findRightPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findRightPage(form);
	}
	/**
	 * 查询功能记录总条数
	 * @param form
	 * @return
	 */
	public Integer findRightSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findRightSize(form);
	}
	/**
	 * 根据系统集成信息记录分页
	 * @param form
	 * @return
	 */
	public List findSysintPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findSysintPage(form);
	}
	/**
	 * 查询系统集成信息记录总条数
	 * @param form
	 * @return
	 */
	public Integer findSysintSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findSysintSize(form);
	}
	/**
	 * 
	 *职称mng_post放大镜 记录
	 * @param form
	 * @return
	 */
	public List findPostPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findPostPage(form);
	}
	/**
	 * 职称mng_post总条数
	 * @param form
	 * @return
	 */
	public Integer findPostSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findPostSize(form);
	}

	/**
	 * 根据用户记录分页
	 * @param form
	 * @return
	 */
	public List findUserPage(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findUserPage(form);
	}
	/**
	 * 查询用户总条数
	 * @param form
	 * @return
	 */
	public Integer findUserSize(TreeForm form) {
		// TODO Auto-generated method stub
		return treeDAO.findUserSize(form);
	}

}
