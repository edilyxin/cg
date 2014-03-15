package com.rc.sys.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rc.sys.vo.MngUser;
import com.rc.util.UserInfo;

public class LoginDAO extends SqlMapClientDaoSupport{
	
	/**
	 * 
	 *  @Description    : 根据账号密码查询登陆用户
	 *  @Method_Name    : getUser
	 *  @param userVO	
	 *  @return         : MngUser
	 *  @Creation Date  : 2013-3-25下午04:16:08 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public MngUser getUser(MngUser userVO){
		return (MngUser) getSqlMapClientTemplate().queryForObject("getLoginUser", userVO);
	}
	 

	/**
	 * 
	 *  @Description    : 查询菜单栏
	 *  @Method_Name    : findMainRight
	 *  @param userInfo
	 *  @return         : List
	 *  @Creation Date  : 2013-3-25下午04:16:30 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public List findMainRight(UserInfo userInfo){
		return   getSqlMapClientTemplate().queryForList("getMainRight", userInfo);
	}
	
	/**
	 * 查询功能列表
	 * @param right_sno	功能ID
	 * @param userid	用户ID
	 * @param sysint_sno 系统ID
	 * @return
	 */
	public List findMenuRight(String right_sno,Long userid,String sysint_sno){
		HashMap hm = new HashMap();
		hm.put("right_sno", right_sno);
		hm.put("userid", userid);
		hm.put("sysint_sno", sysint_sno);
		return   getSqlMapClientTemplate().queryForList("getMenuRight",hm );
	}
	
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
	public boolean checkPass(UserInfo userInfo){
		return ((Integer)getSqlMapClientTemplate().queryForObject("login_checkPass", userInfo)).equals(1)?true:false;
	}
	
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
	public boolean updatePass(UserInfo userInfo){
		return ((Integer)getSqlMapClientTemplate().update("login_updatePass", userInfo)).equals(0)?false:true;
	}
	
	/**
	 * 用户操作权限
	 * @param userInfo
	 * @return
	 */
	public List findOper(UserInfo userInfo){
		return getSqlMapClientTemplate().queryForList("login_findOper", userInfo);
	}

	/**
	 * 查询系统
	 * @param userInfo
	 * @return
	 */
	public List findSys(UserInfo userInfo){
		return getSqlMapClientTemplate().queryForList("login_findSys", userInfo);
	}
	/**
	 * 
	 *  @Description    : 根据用户编号，到得用户的员工编号，和员工的二级公司编号
	 *  @Method_Name    : getEmpByUserId
	 *  @param userInfo
	 *  @return 
	 *  @return         : List
	 */
	public List getEmpByUserId(UserInfo userInfo){
		return getSqlMapClientTemplate().queryForList("getEmpByUserId",userInfo);
	}
	
	public boolean check(String sql){
		return ((Integer)getSqlMapClientTemplate().queryForObject("login_check", sql))>0?true:false;
	}
}
