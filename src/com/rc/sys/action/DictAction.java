package com.rc.sys.action;

import java.util.Arrays;
import java.util.List;
import com.rc.sys.form.MngDictForm;
import com.rc.sys.form.MngDictItemForm;
import com.rc.sys.form.MngRoleForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.DictService;
import com.rc.sys.service.RoleService;
import com.rc.sys.service.SequenceService;
import com.rc.sys.vo.MngDict;
import com.rc.sys.vo.MngDictItem;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 字典管理ACTION
 * @author GK
 *
 */
public class DictAction extends BaseAction {
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private DictService dictService = (DictService)getBean("dictService");
	private RoleService roleService = (RoleService)getBean("roleService");
	private LogService log = (LogService)getBean("logService");
	private MngDictForm form; //form表单
	private MngDictItemForm form1 ; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private List<MngDictItem> list1;//字典项
	private MngDictItem vo1;
	private MngDict vo;//查询返回的VO
	private String checked;
	private String id;
	private String dict_sno="";
	private String dict_sname ;
	private String msg="";
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	


	public String getDict_sname() {
		return dict_sname;
	}

	public void setDict_sname(String dict_sname) {
		this.dict_sname = dict_sname;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public MngDictItem getVo1() {
		return vo1;
	}

	public void setVo1(MngDictItem vo1) {
		this.vo1 = vo1;
	}
	/**
	 * 
	 *  @Description    : 验证字典名的唯一性
	 *  @Method_Name    : findDictUnique
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findDictUnique()throws Exception{
		//System.out.println("唯一性验证来了");
		if(form == null){
			form = new MngDictForm();
		}
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	String linename = new String(request.getParameter("form.dict_sname").getBytes("ISO-8859-1"),"UTF-8"); 
	 	form.setDict_sname(linename);
	 //	System.out.println(linename);
	 	list =  dictService.findPage(form);
		boolean bl;
		if(list.size()>0){
			bl = false;
		}else{
			bl = true;
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(bl);
		return null;
	}
	/**
	 * 
	 *  @Description    : 验证字典项值或者名的唯一性
	 *  @Method_Name    : findDictUniqueItem
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String serviceStr(String str){//服务器格式
		try {
			return new  String(str.getBytes("ISO8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}	

	public String findDictUniqueItem()throws Exception{
		if(form1 == null){
			form1 = new MngDictItemForm();
		}
		if(form1.getDict_sno() == null){
			return "findDictUniqueItem";
		}
		//ajax，get方法提交定义格式
		String name = request.getParameter("form1.ditem_sname");
		if(name!=null&&!"".equals(name)){
			String linename = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			form1.setDitem_sname(linename);
		}
		list1 = dictService.findItemPage(form1);
		boolean bl;
		if(list1.size()>0){
			bl = false;
		}else{
			bl = true;
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(bl);
		return null;
	}
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngDictForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		//System.out.println(page);
		bean = new PageBean(dictService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null&&page !="") {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		if(form.getSearchB()!=null){
			form.setSearchB(form.getSearchB().trim());
		}
		list = dictService.findPage(form);
		return "findDict";
	}
	public String find1() throws Exception{
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		if(form1==null){
			form1 = new MngDictItemForm();
		}
		if(id!=null){
			form1.setDict_sno(id);
			vo = dictService.findByID(id);
			
		}else{
			vo = dictService.findByID(form1.getDict_sno());
		}
		if(vo != null){
		dict_sname = vo.getDict_sname();
		list1 = dictService.findItemPage(form1);
		/*if(list1.size()>0){
			dict_sname = list1.get(0).getDict_sname();
		}*/
		}
		return "findDictItem";
	}
	/**
	 * 跳转字典新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		MngRoleForm mngRole = new MngRoleForm();
		list = roleService.role_findMngSysint(mngRole);
		return "add";
	}
	
	/**
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		} 
		String str = sequenceService.getNO(userInfo.getSysint_sno(), "0", "dict_sno");
		//String str = sequenceService.getNO("", "0", "dict_sno");
		System.out.println(str);
		form.setDict_sno(str);
		if(form.getSysint_sno()==null||"".equals(form.getSysint_sno())){
			form.setDict_stype("0");
		}else{
			form.setDict_stype("1");
		}
		boolean count = dictService.save(form);
		if(count == false){
			msg = "新增失败";
		}else{
			log.logInsert(userInfo, "新增字典", "mng_dict");
			msg = "新增字典成功";
		}
		return "add";
	}
	
	/**
	 * 跳转字典项增页
	 * @return
	 * @throws Exception
	 */
	public String toAddItem() throws Exception{
		
		vo = dictService.findByID(id);
		return "addItem";
	}


	//saveItem
	public String addItem(){
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		boolean count = dictService.saveItem(form1);
		dict_sno = form1.getDict_sno();
		if(count == false){
			
			msg = "新增字典项失败";
		}else{
			
			log.logInsert(userInfo, "新增字典项", "mng_dictItem");
			msg = "新增字典项成功";
		}
		//id = form1.getDict_sno();
		return "addItem";
	}
	/**
	 * 跳转字典修改页面
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		MngRoleForm mngRole = new MngRoleForm();
		list = roleService.role_findMngSysint(mngRole);
		String[] idchecked = request.getParameterValues("idcheckbox");
		System.out.println(Arrays.toString(idchecked));
		if(idchecked!=null&&idchecked.length==1){
			vo = dictService.findByID(idchecked[0]);
		}
		return "update";
	}
	/**
	 * 修改字典保存
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(form.getSysint_sno()==null||"".equals(form.getSysint_sno())){
			form.setDict_stype("0");
		}else{
			form.setDict_stype("1");
		}
		boolean count = dictService.update(form);
		
		if(count == false){
			msg = "修改失败";
			
		}else{
			log.logInsert(userInfo, "修改字典", "mng_dict");
			msg = "修改成功";
			
		}
		return "update";
		
	}
	public String toUpdateItem() throws Exception{
		vo1 = (MngDictItem) dictService.findDictItemByID(id);
		return "updateItem";
	}
	
	
	/**
	 * 修改保存字典项
	 * @return
	 * @throws Exception
	 */
	public String updateItem() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		dict_sno = form1.getDict_sno();
		boolean count = dictService.updateItem(form1);
		if(count == false){
			msg = "修改失败";
			
		}else{
			log.logInsert(userInfo, "修改字典项", "mng_dictitem");
			msg = "修改成功";
			
		}
		id = form1.getDict_sno();
		return "updateItem";
		
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
		String[] idchecked = request.getParameterValues("daichao");
		//System.out.println(Arrays.toString(idchecked));
		boolean b1 = dictService.delete(idchecked);
		if(b1){
			msg = "删除成功";
		}else{
			msg = "删除失败";
		}
		log.logInsert(userInfo, "删除字典", "mng_dict");
		return find();
	}
	public String toDeleteItem() throws Exception{
		//验证登陆session是否有效
		String[] idchecked = request.getParameterValues("idcheckbox1");
		System.out.println(Arrays.toString(idchecked));
		dictService.deleteItem(idchecked);
		id = form1.getDict_sno();
		return find1();
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
		dictService.changeValid(idchecked);
		log.logInsert(userInfo, "更新字典状态", "mng_dict");
		return find();
	}
	

	public MngDictForm getForm() {
		return form;
	}

	public void setForm(MngDictForm form) {
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

	public MngDict getVo() {
		return vo;
	}

	public void setVo(MngDict vo) {
		this.vo = vo;
	}

	public MngDictItemForm getForm1() {
		return form1;
	}

	public void setForm1(MngDictItemForm form1) {
		this.form1 = form1;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDict_sno() {
		return dict_sno;
	}

	public void setDict_sno(String dict_sno) {
		this.dict_sno = dict_sno;
	}

	

	
}
