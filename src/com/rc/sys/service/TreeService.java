package com.rc.sys.service;

import java.util.List;

import com.rc.sys.form.TreeForm;

public interface TreeService {

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
	public List findEmp(TreeForm treeForm);
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
	public List findSys(TreeForm treeForm);
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
	public List findComp(TreeForm treeForm);
	
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
	public List findDep(TreeForm treeForm);
	
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
	public List findJob(TreeForm treeForm);
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
	public List findDict(TreeForm treeForm);
	
	/**
	 * 查询员工结果数
	 */
	public Integer findEmpSize(TreeForm form);
	/**
	 * 查询员工结果分页
	 */
	public List findEmpPage(TreeForm form );

	 
	public Integer findCompSize(TreeForm form);

	public List findCompPage(TreeForm form);

	 
	public Integer findDepSize(TreeForm form);

	public List findDepPage(TreeForm form);

	public Integer findJobSize(TreeForm form);

	public List findJobPage(TreeForm form);

	 	/**
	 * 查询最低的部门层次
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findUDCount();
	/**
	 * 查询单位信息
	 * @param treeForm
	 * @return
	 */
	/**
	 * 查询一个部门的所有子部门单位信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findSonUD(TreeForm treeForm);
	public List findUD(TreeForm treeForm);
	
	
	/**
	 * 查询单位数
	 * @param treeForm
	 * @return
	 */
	public Integer findUdSize(TreeForm treeForm);
	
	/**
	 * 查询学校信息
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public List findSchool(TreeForm treeForm);
	
	/**
	 * 查询学校信息数
	 * @param treeForm
	 * @return
	 * @author luzong
	 */
	public Integer findSchoolSize (TreeForm treeForm);
	
	/**
	 * 根据功能记录分页
	 * @param form
	 * @return
	 */
	public List findRightPage(TreeForm form);
	/**
	 * 查询功能记录总条数
	 * @param form
	 * @return
	 */
	public Integer findRightSize(TreeForm form);
	/**
	 * 根据系统集成信息记录分页
	 * @param form
	 * @return
	 */
	public List findSysintPage(TreeForm form) ;
	/**
	 * 查询系统集成信息记录总条数
	 * @param form
	 * @return
	 */
	public Integer findSysintSize(TreeForm form);

	
	/**
	 * 
	 *职称mng_post放大镜 记录
	 * @param form
	 * @return
	 */
	public List findPostPage(TreeForm form) ;
	/**
	 * 职称mng_post总条数
	 * @param form
	 * @return
	 */
	public Integer findPostSize(TreeForm form) ;

	/**
	 * 根据用户记录分页
	 * @param form
	 * @return
	 */
	public List findUserPage(TreeForm form) ;
	/**
	 * 查询用户总条数
	 * @param form
	 * @return
	 */
	public Integer findUserSize(TreeForm form);

}
