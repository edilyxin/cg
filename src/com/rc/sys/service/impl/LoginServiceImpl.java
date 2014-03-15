package com.rc.sys.service.impl;

import java.util.HashMap;
import java.util.List;

import com.rc.sys.dao.LoginDAO;
import com.rc.sys.service.LoginService;
import com.rc.sys.vo.MngOper;
import com.rc.sys.vo.MngUser;
import com.rc.util.UserInfo;

/**
 * 登陆实现类
 * @author pc
 *
 */
public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO ; 
    
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	
	/**
	 * 登陆查询
	 * @param user 系统用户表VO
	 * @return MngUser 查询结果
	 */
	public MngUser findUser(MngUser user) {
		return loginDAO.getUser(user);//按账号密码查询
	}

	/**
	 * 查询菜单栏
	 * @param userInfo
	 * @return
	 */
	public List findMainRight(UserInfo userInfo){
		return loginDAO.findMainRight(userInfo);
	}
	
	/**
	 * 查询功能列表
	 * @param right_sno
	 * @param userid
	 * @param sysint_sno
	 * @return
	 */
	public List findMenuRight(String right_sno,Long userid,String sysint_sno){
		return loginDAO.findMenuRight(right_sno,userid,sysint_sno);
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
	public boolean checkPass(UserInfo userInfo) {
		return loginDAO.checkPass(userInfo);
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
	public boolean updatePass(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return loginDAO.updatePass(userInfo);
	}
	


	/**
	 * 用户操作权限
	 * @param userInfo
	 * @return
	 */
	public HashMap findOper(UserInfo userInfo) {
		
		List operList = loginDAO.findOper(userInfo);
		HashMap hm = new HashMap();
		for(int i=0;i<operList.size();i++){
			MngOper oper = (MngOper)operList.get(i);
			hm.put(oper.getOper_sno(), oper);
		}
		return hm;
	}
	
	/**
	 * 查询系统
	 * @param userInfo
	 * @return
	 */
	public List findSys(UserInfo userInfo){
		return loginDAO.findSys(userInfo);
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
		return loginDAO.getEmpByUserId(userInfo);
	}
}
