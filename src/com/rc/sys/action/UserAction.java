package com.rc.sys.action;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.rc.sys.form.MngDictForm;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngUserForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.RoleService;
import com.rc.sys.service.UserService;
import com.rc.sys.vo.MngRight;
import com.rc.sys.vo.MngRole;
import com.rc.sys.vo.MngUser;
import com.rc.util.BaseAction;
import com.rc.util.StringUtil;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 用户管理ACTION
 * @author GK
 *
 */
public class UserAction extends BaseAction {
	private UserService userService = (UserService)getBean("userService");
	private LogService log = (LogService)getBean("logService");
	private MngUserForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngUser vo;//查询返回的VO
	private MngRole role;//
	private String message;//操作信息
	private String userId;//用户ID
	private String json;//json数据
	private String empNO;//代理人工号
	private String empNOBy;//被代理人工号
	private String rights;//代理权限
	private String pwd;//原始密码
	private String checked;//功能和操作编号集合
	private List<MngRole> roleList;//所有角色信息
	private List<MngRole> roleList2;//根据用户id号查询用户拥有的所有角色信息
	private List<MngRight> rightList;//根据用户id号查询用户拥有的所有权限信息
	private List operList;//查询所有操作
	private List oneOperList;//查询用户已有操作
	private List oneDBOperList;//查询用户已有数据权限
	private List rightByno;
//	private JSONArray jsonArray;
	private String[] operckb;
	public List getRightByno() {
		return rightByno;
	}

	public void setRightByno(List rightByno) {
		this.rightByno = rightByno;
	}


	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}



	/**
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		//MD5加密
		if(form!=null){
			String pwd=form.getPassword();
			if(pwd==null||"".equals(pwd)){
				message="密码不能为空！";
				return toAdd();
			}else{
				pwd=StringUtil.MD5Encode(pwd);
				form.setPassword(pwd);
			}
		}
		if(userService.save(form))
			message = "新增成功！";
		else{
			message = "新增失败";
		log.logInsert(userInfo, "新增用户", "mng_user");
		}
		return find();
	}
	
	/**
	 * 
	 *  @Description    : 方法描述：注销给用户分配的角色
	 *  @Method_Name    : cancelUserRoles
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27下午02:47:02 
	 *  @Author         : 周剑
	 */
	public String cancelUserRoles() throws Exception{
		String[] roleNos=request.getParameterValues("idcheckbox");
		boolean b=userService.cancelUserRoles(userId, roleNos);
		if(b){
			message="回收角色成功！";
		}else{
			message="回收角色失败！";
		}
		return find();
	}

	/**
	 * 有效/无效
	 * @return
	 * @throws Exception
	 */
	public String changeValid() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = userService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新用户状态", "mng_user");
		}else{
			message = "更新失败";
		}
		
		return find();
	}

	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngUserForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(userService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = userService.findPage(form);
		return "find";
		
	}

	public PageBean getBean() {
		return bean;
	}

	public String getEmpNO() {
		return empNO;
	}
	public String getEmpNOBy() {
		return empNOBy;
	}
	public MngUserForm getForm() {
		return form;
	}

	public String getJson() {
		return json;
	}

	public List getList() {
		return list;
	}

	public String getMessage() {
		return message;
	}

	public List<MngRight> getRightList() {
		return rightList;
	}

	public List<MngRole> getRoleList() {
		return roleList;
	}

	public List<MngRole> getRoleList2() {
		return roleList2;
	}

	public String getUserId() {
		return userId;
	}

	public MngUser getVo() {
		return vo;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 *  @Description    : 方法描述：查看用户权限
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String lookRight() throws Exception{
		List<MngRight> sysint = userService.findSysint();
		list = new ArrayList();
		for(int i = 0;i<sysint.size();i++){
			form.setSysint_sno(sysint.get(i).getSysint_sno());
			List<MngRight> rightList = userService.findUserRights(form);
			if(rightList!=null&&rightList.size()>0){
				rightList.add(sysint.get(i));
				list.add(rightList);
			}
		}
		//Gson gson=new Gson();
		//json=gson.toJson(list.get(0));
//		jsonArray = JSONArray.fromObject(list);
		return "lookRight";
	}
	/**
	 *  @Description    : 方法描述：特权分配
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	 
	public String toPRight() throws Exception{
		//所有权限
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	if(vo == null){
	 		vo = new MngUser();
	 	}
	 	vo.setUserid(userInfo.getUserid());
	 	vo.setScreenname(userInfo.getScreenname());
		
		List<MngRight> sysint = userService.findSysint();
		//list.addAll(sysint);
		list = new ArrayList();
	  //选中的权限
		for(int k=0;k<sysint.size();k++){
			MngUserForm form1 = new MngUserForm();
			MngRightForm mngRightForm = new MngRightForm();
			mngRightForm.setUserid(userId);
			mngRightForm.setSysint_sno(sysint.get(k).getSysint_sno());
			List<MngRight> rightList1 = userService.findUserRightList(mngRightForm);//已经拥有的权限
			form1.setUserid(userId);
			form1.setSysint_sno(sysint.get(k).getSysint_sno());
			List<MngRight> list1 = userService.findUserRights(form1);
			if(list1!=null&&list1.size()>0){
				list1.add(sysint.get(k));
			
			for(int i=0;i<rightList1.size();i++){
				for(int j=0;j<list1.size();j++){
					if(rightList1.get(i).getId().equals(((MngRight)list1.get(j)).getId())){
					/*	System.out.println("大家进来没有");*/
						((MngRight)list1.get(j)).setMyChecked("1");
						//去除已有的权限，list.remove(j);
						
					}
				}
			}
			list.add(list1);
			}
		}
		
		//Gson gson=new Gson();
		//json=gson.toJson(list.get(0));
//		jsonArray = JSONArray.fromObject(list);
		//System.out.println(jsonArray.get(0));
		//System.out.println(jsonArray.get(1));
		//System.out.println(jsonArray.get(2));
		//
		return "toUserRight";
	}
	/**
	 * 
	 *  @Description    : 特权设置
	 *  @Method_Name    : saveUserRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String saveUserRight()throws Exception{
		if(rights!=null&&!"".equals(rights)){
			rights=rights.substring(0,rights.lastIndexOf(","));
			String rts[]=rights.split(",");
			boolean b=userService.saveUserRight(userId, rts);
			if(b){
				message="保存成功！";
			}else{
				message="保存失败！";
			}
		}
		return toPRight();
	}
	
	/**
	 *  @Description    : 方法描述：特权分配之操作
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String toUserOper() throws Exception{
		RoleService roleService = (RoleService)getBean("roleService");
		vo = userService.findByID(userId);
		operList = roleService.findOperList(null);//查出所有的操作权限
		//查出已经具有的特权操作权限
		oneOperList = userService.findUserOperList(userId);
		return "toPrivilegeOper";
	}
	
	/**
	 *  @Description    : 方法描述：特权分配之数据
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String toUserDB() throws Exception{
		vo = userService.findByID(userId);
		operList = userService.findOperList();
		oneDBOperList = userService.findDBOperList(userId);
		return "toDBPrivilegeOper";
	}
	
	/**
	 *  @Description    : 方法描述：特权分配之操作保存
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String saveUserOper() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(userService.saveUserOper(userId, operckb)){
			message = "分配成功！";
		    log.logInsert(userInfo, "给特权用户分配操作权限", "mng_useroper");
		}
		else
			message = "分配失败！";
		return find();
	}
	
	/**
	 *  @Description    : 方法描述：特权分配之数据操作保存
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String saveDBOper() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(userService.saveDBOper(userId, operckb)){
			message = "分配成功！";
		    log.logInsert(userInfo, "给特权用户分配数据权限", "mng_userright");
		}
		else
			message = "分配失败！";
		return find();
	}
	/**
	 * 
	 *  @Description    : 方法描述：界面ajax校验用户输入的原始密码
	 *  @Method_Name    : checkPwd 
	 *  @return         : void
	 * @throws Exception 
	 *  @Creation Date  : 2013-6-5上午11:25:03 
	 *  @Author         : 周剑
	 */
	public void checkPwd() throws Exception{
		vo = userService.findByID(form.getUserid());
		PrintWriter pw=response.getWriter();
		if(vo!=null){
			if(vo.getPassword().equals(StringUtil.MD5Encode(this.pwd))){
				pw.write("success");
			}else{
				pw.write("fail");
			}
			pw.flush();
			pw.close();
		}
	}
 
	/**
	 * 
	 *  @Description    : 方法描述：保存当前用户修改的密码
	 *  @Method_Name    : saveChangePwd
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午09:06:51 
	 *  @Author         : 周剑
	 */
	public String saveChangePwd() throws Exception{
		//后台判断两次输入的密码是否一致
		String updatePwd=form.getUpdatePwd();
		String confirmPwd=form.getConfirmPwd();
		if(!updatePwd.equals(confirmPwd)){
			message="两次输入的密码不一致！";
			return toChangePwd();
		}
		//后台再次校验用户输入的原始密码
		vo = userService.findByID(form.getUserid());
		if(vo!=null){
		if(!vo.getPassword().equals(StringUtil.MD5Encode(form.getPassword()))){
			message="原始密码输入错误！";
			return toChangePwd();
		}else{
			form.setPassword(StringUtil.MD5Encode(form.getUpdatePwd()));
			boolean b=userService.updatePwd(form);
			if(b){
				message="修改密码成功！";
			}else{
				message="修改密码失败！";
			}
			return find();
		}
		}else{
			return ERROR;
		}
	}

	/**
	 * 
	 *  @Description    : 方法描述：保存代理权限
	 *  @Method_Name    : saveDlRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27下午06:30:49 
	 *  @Author         : 周剑
	 */
	public String saveDlRight() throws Exception{
		if(rights!=null&&!"".equals(rights)){
			rights=rights.substring(0,rights.lastIndexOf(","));
			String rts[]=rights.split(",");
			boolean b=userService.saveDlRight(userId,rts, empNO, empNOBy);
			if(b){
				message="保存成功！";
			}else{
				message="保存失败！";
			}
		}
		return find();
	}

	/**
	 * 
	 *  @Description    : 方法描述：保存分配给用户的角色
	 *  @Method_Name    : saveRoleDistribute
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27下午02:47:02 
	 *  @Author         : 周剑
	 */
	public String saveRoleDistribute() throws Exception{
		String[] roleNos=request.getParameterValues("idcheckbox");
		boolean b=userService.addUserRoles(userId, roleNos);
		if(b){
			message="角色分配成功！";
		}else{
			message="角色分配失败！";
		}
		return find();
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}
	
	public void setEmpNO(String empNO) {
		this.empNO = empNO;
	}
	
	public void setEmpNOBy(String empNOBy) {
		this.empNOBy = empNOBy;
	}
	
	public void setForm(MngUserForm form) {
		this.form = form;
	}
	
	public void setJson(String json) {
		this.json = json;
	}
	
	public void setList(List list) {
		this.list = list;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setRightList(List<MngRight> rightList) {
		this.rightList = rightList;
	}
	
	public void setRoleList(List<MngRole> roleList) {
		this.roleList = roleList;
	}
	
	public void setRoleList2(List<MngRole> roleList2) {
		this.roleList2 = roleList2;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setVo(MngUser vo) {
		this.vo = vo;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List getOperList() {
		return operList;
	}

	public void setOperList(List operList) {
		this.operList = operList;
	}

	public List getOneOperList() {
		return oneOperList;
	}

	public void setOneOperList(List oneOperList) {
		this.oneOperList = oneOperList;
	}

	public List getOneDBOperList() {
		return oneDBOperList;
	}

	public void setOneDBOperList(List oneDBOperList) {
		this.oneDBOperList = oneDBOperList;
	}
	public MngRole getRole() {
		return role;
	}

	public void setRole(MngRole role) {
		this.role = role;
	}
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		return "add";
	}

	/**
	 * 
	 *  @Description    : 方法描述：跳转到修改当前用户密码页面
	 *  @Method_Name    : changePwd
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午08:36:31 
	 *  @Author         : 周剑
	 */
	public String toChangePwd() throws Exception{
		return "updatePwd";
	}

	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String toDelete() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = userService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除用户", "mng_user");
		}else{
			message = "删除失败";
		}
		
		return find();
	}

	/**
	 *  @Description    : 方法描述：跳转至权限代理
	 *  @Method_Name    : lookRight
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午11:02:31 
	 *  @Author         : 周剑
	 */
	public String toDlRight() throws Exception{
		//根据用户id查出用户的名，代理人名称，代理人姓名
		MngUserForm form1 = new MngUserForm();
		//System.out.println("userId="+userId);
		form1.setUserid(userId);
		role = userService.findEmp(form1);
//		System.out.println(role.getEmp_sname()+"员工编号");
		//查询该用户具有的所有权限
		if(!"".equals(empNOBy)){
			rightList=userService.findRights();
//			Gson gson=new Gson();
//			json=gson.toJson(rightList);
		}
		return "toDlRight";
	}

	/**
	 * 
	 *  @Description    : 方法描述：根据代理人和被代理人工号查询相关权限
	 *  @Method_Name    : findDlRight
	 *  @throws Exception 
	 *  @return         : void
	 *  @Creation Date  : 2013-6-4下午03:12:15 
	 *  @Author         : 周剑
	 */
	public void findDlRight() throws Exception{		
		if(form == null){
			form = new MngUserForm();
			form.setEmp_sno(empNO);
		}
		System.out.println(form.getEmp_sno()+","+empNO);
		//由员工编号求该员工下的所有的用户的所有权限
		List<MngRight> sysint = userService.findSysint();
		list = new ArrayList();
		for(int k = 0 ;k<sysint.size();k++){
			form.setSysint_sno(sysint.get(k).getSysint_sno());
			List<MngRight> rights=userService.findRightByEmp(form);//代理人权限列表
			rights.add(sysint.get(k));
			List<MngRight> rightList1 = userService.user_findDlRights(empNO, empNOBy,userId,sysint.get(k).getSysint_sno());//该系统的权限
			for(int i=0;i<rightList1.size();i++){
				for(int j=0;j<rights.size();j++){
					//System.out.println("大家进来没有"+rightList1.get(i).getRight_sno()+",rights.get(j).getId()"+rights.get(j).getId());
					if(rightList1.get(i).getRight_sno().equals(rights.get(j).getId())){
						rights.get(j).setMyChecked("1");
					}
				}
			}
			list.add(rights);
		}
//		Gson gson=new Gson();
//		String json=gson.toJson(list);
//		System.out.println(json);
		response.setContentType("text/javascript; charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();		
	}
	/**
	 *  @Description    : 方法描述：跳转至角色分配页面
	 *  @Method_Name    : toRoleDistribute
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 *  @Creation Date  : 2013-5-27上午10:03:43 
	 *  @Author         : 周剑
	 */
	public String toRoleDistribute() throws Exception{
		//查询所有角色信息
		roleList=userService.findRoles();
		//查询选中的用户已拥有的角色
		roleList2=userService.findUserRoles(form);
		
		return "toRoleDistribute";
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = userService.findByID(idchecked[0]);
		}
		return "update";
	}

	/**
	 * 修改保存
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		//MD5加密
		if(form!=null){
			String pwd=form.getPassword();
			if(pwd==null||"".equals(pwd)){
				message="修改密码不能为空！";
				return toUpdate();
			}else{
				pwd=StringUtil.MD5Encode(pwd);
				form.setPassword(pwd);
			}
		}
		boolean bl = userService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改用户", "mng_user");
		}else{
			message = "修改失败";
		}
		
		return find();
		
	}
	
	
	/**
	 * 
	 *  @Description    : 查看所有代理人与被代理人
	 *  @Method_Name    : findPersonLook
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findPersonLook()throws Exception{
		list = userService.findPersonLook();
		return "findPersonLook";
	}
	/**
	 * 
	 *  @Description    : 代理权限查看
	 *  @Method_Name    : rightDlLook
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String rightDlLook()throws Exception{
		//根据用户id查出用户的名，代理人名称，代理人姓名
		MngUserForm form1 = new MngUserForm();
		form1.setUserid(userId);
		role = userService.findEmp(form1);
		//1.查询出所有被代理的员工
		List emp = userService.findDlEmp(userId);
		//2.根据被代理的员工查询所被代理的权限--系统加权限
		 //查询出所有的系统
		//System.out.println("进来木有撒"+empNOBy);
		List<MngRight> sysint = userService.findSysint();
		list = new ArrayList();
		if(empNOBy!=null&&!"".equals(empNOBy)){
			for(int i = 0 ;i <sysint.size();i++){
				rightByno = userService.findDlRightsByNo(empNO,empNOBy, userId,sysint.get(i).getSysint_sno());
				rightByno.add(sysint.get(i));
				list.add(rightByno);
			}
			
			//rightByno.addAll(sysint);
			//JSONArray jsonArray=JSONArray.fromObject(rightByno);//将list转换为json数组
//			Gson gson=new Gson();
//			String json=gson.toJson(list);
//			response.setContentType("text/javascript; charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();	
		}
		 
		
		//3.查出该用的所有被代理人
		return "rightDlLook";
	}
	/**
	 * 
	 *  @Description    : 验证用户名的唯一性
	 *  @Method_Name    : findDictUnique
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String userUniqueName()throws Exception{
		//System.out.println("唯一性验证来了");
		if(form == null){
			form = new MngUserForm();
		}
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		boolean bl = userService.userUniqueName(form);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(bl);
		return null;
	}
	/*public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}*/

	public String[] getOperckb() {
		return operckb;
	}

	public void setOperckb(String[] operckb) {
		this.operckb = operckb;
	}

	
}
