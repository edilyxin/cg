package com.rc.sys.action;

import java.util.HashMap;
import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.rc.base.vo.MngEmp;
import com.rc.declare.form.NiNoticeInfoForm;
import com.rc.declare.vo.NiNoticeInfo;
import com.rc.sys.form.LoginForm;
import com.rc.sys.service.LoginService;
import com.rc.sys.vo.MngRight;
import com.rc.sys.vo.MngUser;
import com.rc.util.BaseAction;
import com.rc.util.FileUtil;
import com.rc.util.ReadConfig;
import com.rc.util.StringUtil;

import com.rc.util.UserInfo;

/**
 * 
 *  @Project       : PM
 *  @Program Name  : com.rc.sys.action.LoginAction.java
 *  @Class Name    : LoginAction
 *  @Description   : 登陆系统
 *  @Author        : GK
 *  @Creation Date : 2013-3-25 下午02:37:49 
 */
public class LoginAction extends BaseAction {
	private LoginService loginService = (LoginService)getBean("loginService");//获取登陆接口LoginService对象
	private LoginForm loginForm;
	private String message;//登陆信息
	private String error;//错误栏位置
	private String mainID;//菜单栏编号 
	private List menuList;//功能列表


/**
 * 
 *  @Description    : 登陆
 *  @Method_Name    : login
 *  @throws Exception 
 *  @return         : String
 *  @Creation Date  : 2013-3-25下午03:00:16 
 *  @version        : v1.00
 *  @Author         : GK
 */
	public String execute() throws Exception {
		
		if(!"1".equals(session.get("login"))){
			loginForm=null;
			return ERROR;//登出
		}
		session.put("login",null);
		if(loginForm==null){//非输入条件登陆
			return ERROR;//登出
		}
		String username = loginForm.getUsername();//账号
		String password = loginForm.getPassword();//密码 
		//账号密码为空
		if(username==null||username.equals("")){
			error = "errMsg_loginForm.username";
			message = "请输入帐号!";//返回错误信息
			return ERROR;//登出
		}
		if(password==null||password.equals("")){
			error = "errMsg_loginForm.password";
			message = "请输入密码!";//返回错误信息
			return ERROR;//登出
		} 
		password = StringUtil.MD5Encode(password);//MD5加密密码
		//存条件到系统用户表VO
		MngUser mngUser = new MngUser();
		mngUser.setScreenname(username);//账号
		mngUser.setPassword(password);//密码
		mngUser = loginService.findUser(mngUser);//查询用户登陆信息
		
		
		if(mngUser!=null&&username.equals(mngUser.getScreenname()))//用户信息存在且用户名匹配
		{	
			UserInfo userInfo = new UserInfo();
			userInfo.setUserid(mngUser.getUserid());
			userInfo.setIp(StringUtil.getIpAddr(request));//获取IP
			userInfo.setScreenname(mngUser.getScreenname());
			userInfo.setUsername(mngUser.getFirstname()+mngUser.getLastname());
			//根据用户编号，到得用户的员工编号，和员工的二级公司编号
			List list = loginService.getEmpByUserId(userInfo);
			if(list!=null&&list.size()>0){
				MngEmp emp = (MngEmp)list.get(0);
				userInfo.setEmp_sno(emp.getEmp_sno());//设置用户的员工编号
				userInfo.setEmp_sname(emp.getEmp_sname());//设置员工姓名
				userInfo.setUd_sno(emp.getUd_sno1());//设置用户的部门编号
				userInfo.setUd_stopname(emp.getUd_sname());//设置用户的一级单位名称
			}
			userInfo.setSysint_sno("S2013100001");
			session.put("userInfo", userInfo);//用户信息存入session
			List sysList = loginService.findSys(userInfo);
			request.setAttribute("sysList", sysList);
			ActionContext.getContext().getValueStack().set("loginForm", loginForm);	 
			
			List mainList = loginService.findMainRight(userInfo);//查询菜单栏
			session.put("mainList", mainList);//菜单栏信息存入session
			HashMap operList = loginService.findOper(userInfo);
			session.put("operList", operList);//操作信息存入session   
			return SUCCESS;//登陆成功
		}else {
			error = "errMsg_login";
			message = "帐号或密码错误，请重新输入!";//返回错误信息
			return ERROR;//登出
		}
	}
 
		
/**
 * 
 *  @Description    : 显示标题栏菜单
 *  @Method_Name    : loginMainRight
 *  @throws Exception 
 *  @return         : String
 *  @Creation Date  : 2013-3-25下午03:11:24 
 *  @version        : v1.00
 *  @Author         : GK
 */
	public String loginMainRight() throws Exception { 
		return "mainRight"; 
	}
	
	public String getMenuName() throws Exception { 
		String menuname=java.net.URLDecoder.decode(request.getParameter("menuname"),"UTF-8");
		session.put("navbar", menuname);
		return null; 
	}
	
	/**
	 * 
	 *  @Description    : 显示下拉列表
	 *  @Method_Name    : loginMenuRight
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:11:48 
	 *  @version        : v1.00
	 *  @Author         : pc
	 */
	public String loginMenuRight() throws Exception {
		
		LoginService loginService = (LoginService)getBean("loginService");//获取登陆接口LoginService对象
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if(userInfo==null){
			return "errorPage";
		}
		if(mainID==null){//如果没有选择菜单
			List mainList=(List)session.get("mainList");//获取session中菜单栏
			if(mainList!=null&&mainList.size()>0){//查询第一个菜单功能列表
				mainID = ((MngRight)mainList.get(0)).getRight_sno();
			}
		}
		menuList  = loginService.findMenuRight(mainID,userInfo.getUserid(),userInfo.getSysint_sno());
		String top = request.getParameter("top")==null?"": request.getParameter("top");
		top = new String(top.getBytes("ISO-8859-1"),"UTF-8");
		request.setAttribute("menuTop", top);
		System.out.println("menuList.size()="+menuList.size());
		return "menuRight"; 
	}
	 
	/**
	 * 
	 *  @Description    : 显示欢迎页面
	 *  @Method_Name    : loadWelcome
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-3-25下午03:12:19 
	 *  @version        : v1.00
	 *  @Author         : GK
	 */
	public String loadWelcome() throws Exception { 
		 
		return "welcome";  
	}
	
	/**
	 * 
	 *  @Description    : 检查密码
	 *  @Method_Name    : checkPass
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-4-11下午03:52:44 
	 *  @version        : v1.00
	 *  @Author         : pc
	 */
	public String checkPass() throws Exception { 
//		 LoginService loginService = (LoginService)getBean("loginService");//获取登陆接口LoginService对象
//		 userInfo.setUs_sloginpwd(StringUtil.MD5Encode( userInfo.getUs_sloginpwd()));
		 response.setCharacterEncoding("UTF-8");
//			try {
//					response.getWriter().print(loginService.checkPass(userInfo));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		return null;  
	}
	
	/**
	 * 
	 *  @Description    : 修改密码
	 *  @Method_Name    : updatePass
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-4-11下午03:52:44 
	 *  @version        : v1.00
	 *  @Author         : pc
	 */
	public String updatePass() throws Exception { 
//		 LoginService loginService = (LoginService)getBean("loginService");//获取登陆接口LoginService对象
//		 userInfo.setUs_sloginpwd(StringUtil.MD5Encode( userInfo.getUs_sloginpwd()));
//		 if(loginService.updatePass(userInfo)){
//			 message = "密码修改成功！";//返回信息
//		 }else{
//			 message = "密码修改失败！";//返回错误信息
//		 }
		 
		return "updatePass";  
	}
	
	/**
	 * 
	 *  @Description    : 跳转个人信息修改页
	 *  @Method_Name    : toUserUpdate
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-4-11下午03:52:44 
	 *  @version        : v1.00
	 *  @Author         : pc
	 */
	public String toUserUpdate() throws Exception {
		if(session.get("userInfo")==null){//登陆失效
			return "errorPage";//登出
		}
//		 UserService userService = (UserService)getBean("userService");
		 UserInfo userInfo = (UserInfo)session.get("userInfo");
//		 SysUser sysUser = userService.findUserByID(userInfo.getUs_nid());
//		 request.setAttribute("user", sysUser);
		return "updateUser";  
	}
	
	/**
	 * 
	 *  @Description    : 跳转个人信息修改页
	 *  @Method_Name    : toUserUpdate
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-4-11下午03:52:44 
	 *  @version        : v1.00
	 *  @Author         : pc
	 */
	public String updateUser() throws Exception {
//		 UserService userService = (UserService)getBean("userService");
//		 if(userService.updateUser(form)){
//			 message = "个人信息修改成功！";//返回信息
//		 }else{
//			 message = "个人信息修改失败！";//返回错误信息
//		 }
		return toUserUpdate();  
	}
	
	public String downloadTemp() throws Exception {
		UserInfo userInfo =(UserInfo)session.get("userInfo");
		if(userInfo==null){
			return "errorPage";
		}
		String filename = request.getParameter("id");
		filename = ReadConfig.getConfig(filename);
		FileUtil.download(filename, filename,"tempDir", response);
		return null;
	}
	
	public LoginForm getLoginForm() {
		return loginForm;
	}


	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

 

	public List getMenuList() {
		return menuList;
	}

 
	//登陆页面查看通知
	public String welcome() throws Exception{
		
		return "welcome";
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}


	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}

}
