package com.rc.sys.service;

import java.util.HashMap;
import java.util.List;

import com.rc.sys.vo.MngUser;
import com.rc.util.UserInfo;

/**
 * 登陆接口
 * @author GK
 *
 */
public interface LoginService {

	/**
	 * 登陆查询
	 * @param user 系统用户表VO
	 * @return MngUser 查询结果
	 */
	public MngUser findUser(MngUser user);
	
	/**
	 * 查询菜单栏
	 * @param userInfo
	 * @return
	 */
	public List findMainRight(UserInfo userInfo);
	
	/**
	 * 查询功能列表
	 * @param right_sno
	 * @param userid
	 * @param sysint_sno
	 * @return
	 */
	public List findMenuRight(String right_sno,Long userid,String sysint_sno);
	
	/**
	 * 
	 *  @Description    : 验证密码
	 *  @Method_Name    : checkPass
	 *  @param userInfo
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-4-11下午04:15:38 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public boolean checkPass(UserInfo userInfo);
	
	/**
	 * 
	 *  @Description    : 修改密码
	 *  @Method_Name    : updatePass
	 *  @param userInfo
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2013-4-11下午04:15:38 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public boolean updatePass(UserInfo userInfo);
	

	/**
	 * 用户操作权限
	 * @param userInfo
	 * @return
	 */
	public HashMap findOper(UserInfo userInfo);
	
	/**
	 * 查询系统
	 * @param userInfo
	 * @return
	 */
	public List findSys(UserInfo userInfo);
	
	/**
	 * 
	 *  @Description    : 根据用户编号，到得用户的员工编号，和员工的二级公司编号
	 *  @Method_Name    : getEmpByUserId
	 *  @param userInfo
	 *  @return 
	 *  @return         : List
	 */
	public List getEmpByUserId(UserInfo userInfo);
	
}
