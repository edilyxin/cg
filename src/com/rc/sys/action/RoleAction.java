package com.rc.sys.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rc.sys.form.MngRoleForm;
import com.rc.sys.form.MngUserForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.RoleService;
import com.rc.sys.service.SequenceService;
import com.rc.sys.vo.MngDboper;
import com.rc.sys.vo.MngRole;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 角色管理ACTION
 * @author GK
 *
 */
public class RoleAction extends BaseAction {
	private RoleService roleService = (RoleService)getBean("roleService");
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private LogService log = (LogService)getBean("logService");
	private MngRoleForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngRole vo;//查询返回的VO
	
	private List funcList;//全部功能权限
	private List rightList;//该角色的功能权限
	private List operList;//全部操作权限
	private List oneOperList;//该角色拥有的操作权限
	private List dbOperList;
	private List oneDBOperList;
	private List list3;
	
	private boolean ok;
	private String checkedId;//页面传来的id checkedId
	private String checked; //功能权限 选择框
	private String[] checkid;//选中的操作权限
	private String sysId="";
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngRoleForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(roleService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = roleService.findPage(form);
		System.out.println(list);
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		if(form == null){
			form = new MngRoleForm();
		}
		list = roleService.role_findMngSysint(form);
		return "toAdd";
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
		String str = sequenceService.getNO(userInfo.getSysint_sno(), "0", "role_sno");
		System.out.println(str);
		form.setRole_sno(str);
		form.setRole_sreplyby(userInfo.getScreenname());
		boolean bl = roleService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增角色", "mng_role");
		}else{
			message = "新增失败";
		}
		
		return find();
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		if(form == null){
			form = new MngRoleForm();
		}
		list = roleService.role_findMngSysint(form);
		vo = roleService.findByID(checkedId);
		return "toUpdate";
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
		boolean bl = roleService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改角色", "mng_role");
		}else{
			message = "修改失败";
		}
		
		return find();
		
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
		boolean bl = roleService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除角色", "mng_role");
		}else{
			message = "删除失败";
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
		boolean bl = roleService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新角色状态", "mng_role");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	//检查是否缺省
	public String isDefault(){
		ok = roleService.role_isDefault(checkedId);
		return "isDefault";
	}

	// 功能权限
	public String toFunction() throws Exception{
		if(vo == null){
			vo = new MngRole();
		}
		vo = roleService.findByID(checkedId);
		String sysint_sno = vo.getSysint_sno();
		if(form == null){
			form = new MngRoleForm();
		}
		if(sysint_sno!=""||sysint_sno!=null){
			form.setSysint_sno(sysint_sno);
		}
		list = roleService.role_findMngSysint(form);//系统
		form.setRole_sno(checkedId);
		funcList = roleService.findAllRoleRightList(form);//全部功能权限
		rightList = roleService.findRoleRightList(form);//角色的功能权限
		System.out.println(list.size());
		System.out.println(funcList.size());
		System.out.println(rightList.size());
		request.setAttribute("role", vo); //词句可无，只是方便页面取 叫 role的值	
		return "toFunction";
	}
	/**
	 * 
	 *  @Description    : 查看功能权限
	 *  @Method_Name    : saveRoleFunc
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String tocheckRole()throws Exception{
		vo = roleService.findByID(checkedId);
		String sysint_sno = vo.getSysint_sno();
		if(form == null){
			form = new MngRoleForm();
		}
		if(sysint_sno!=""||sysint_sno!=null){
			form.setSysint_sno(sysint_sno);
		}
		list = roleService.role_findMngSysint(form);//系统
		form.setRole_sno(checkedId);
		//rightList = roleService.findAllRoleRightList(form);//角色的功能权限
		funcList = roleService.findRoleRightList(form);//

		request.setAttribute("role", vo); //词句可无，只是方便页面取 叫 role的值	
		
		return "tocheckRole";
	}
	//保存功能权限
	public String saveRoleFunc() throws Exception{
		//form = roleService.findRole(checkedId);//保存之前数据，比如搜索等等，返回
		roleService.saveRoleFunc(checkedId,checked);
		return find();
	}
	// 操作权限
	public String toOper() throws Exception{
		vo = roleService.findByID(checkedId);//角色信息
		operList = roleService.findOperList(vo.getSysint_sno());//角色对应系统的所有操作权限列表
		oneOperList = roleService.findRoleOperList(checkedId);//角色已分配操作权限列表
		return "toOper";
	}
	//操作权限保存
	public String saveRoleOper() throws Exception{
		roleService.saveRoleOper(checkedId, checkid);
		return find();
	}
	//MngDboper  按操作排序
	public String todbOper(){
		//System.out.println("--------------"+sysId);
		vo = roleService.findByID(checkedId);
		dbOperList = roleService.finddbOperList(sysId);//全部
		if(form == null){
			form = new MngRoleForm();
		}
		list = roleService.role_findMngSysint(form);//系统列表
		oneDBOperList = roleService.roledbOperfind(checkedId);//角色拥有
		List li = new ArrayList();
		String funNO = "";
		for(int i=0; i<dbOperList.size(); i++){
			MngDboper m = (MngDboper) dbOperList.get(i);
			if(!funNO.equals(m.getRight_sno())){
				funNO = m.getRight_sno();
				li.add(funNO);
			}
		}

		list3 = new ArrayList();
		for(int j=0; j<li.size(); j++){
			List list2 = new ArrayList();
			MngDboper mng = new MngDboper();
			String rightNO = (String) li.get(j);
			mng.setRight_sno(rightNO);
			for(int k=0; k<dbOperList.size(); k++){
				MngDboper m = (MngDboper) dbOperList.get(k);
				if(rightNO.equals(m.getRight_sno())){
					mng.setRight_sname(m.getRight_sname());
					list2.add(m);
				}
			}
			mng.setList(list2);
			list3.add(mng);
		}
		return "todbOper";
	}
	public String saveRoledbOper() throws Exception{
		String[] idchecked = request.getParameterValues("checkid");
		System.out.println(checkedId);
		for(int i = 0 ; i < idchecked.length; i++){
			System.out.println(idchecked[i]);
		}
		
		roleService.savedbRoleOper(checkedId, idchecked,sysId);
		return find();
	}
	/**
	 * 
	 *  @Description    : 根据角色ID返回该角色下的所有用户
	 *  @Method_Name    : getUserByRole
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String getUserByRole()throws Exception{
		if(form == null){
			form = new MngRoleForm();
		}
		form.setRole_sno(checkedId);
		list = roleService.getUserByRole(form);
		return "getUserByRole";
	}
	/**
	 * 
	 *  @Description    : 角色名称唯一性验证
	 *  @Method_Name    : uniqueName
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String uniqueName()throws Exception{
		if(form == null){
			form = new MngRoleForm();
		}
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	String name = request.getParameter("form.role_sname");
		if(name!=null&&!"".equals(name)){
			String linename = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			form.setRole_sname(linename);
		}
		String sno = request.getParameter("form.role_sno");
		if(sno!=null&&!"".equals(sno)){
			String linename = new String(sno.getBytes("ISO-8859-1"),"UTF-8");
			form.setRole_sno(linename);
		}
		boolean bl = true;
		try{
			bl = roleService.UniqueName(form);
		}catch(Exception e){
			e.printStackTrace();
			bl = false;
		}
		//System.out.println("form.getRole_sname="+form.getRole_sname()+",bl="+bl);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(bl);
		return null;
	}
	public MngRoleForm getForm() {
		return form;
	}

	public void setForm(MngRoleForm form) {
		this.form = form;
	}

	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public MngRole getVo() {
		return vo;
	}

	public void setVo(MngRole vo) {
		this.vo = vo;
	}

	public String getCheckedId() {
		return checkedId;
	}

	public void setCheckedId(String checkedId) {
		this.checkedId = checkedId;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List getFuncList() {
		return funcList;
	}

	public void setFuncList(List funcList) {
		this.funcList = funcList;
	}

	public List getRightList() {
		return rightList;
	}

	public void setRightList(List rightList) {
		this.rightList = rightList;
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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public List getDbOperList() {
		return dbOperList;
	}

	public void setDbOperList(List dbOperList) {
		this.dbOperList = dbOperList;
	}

	public List getList3() {
		return list3;
	}

	public void setList3(List list3) {
		this.list3 = list3;
	}

	public List getOneDBOperList() {
		return oneDBOperList;
	}

	public void setOneDBOperList(List oneDBOperList) {
		this.oneDBOperList = oneDBOperList;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String[] getCheckid() {
		return checkid;
	}

	public void setCheckid(String[] checkid) {
		this.checkid = checkid;
	}

	
}
