package com.rc.base.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.rc.base.form.MngSchoolDepartForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.base.service.SchoolService;
import com.rc.base.service.UnitDepartService;
import com.rc.base.vo.MngSchool;
import com.rc.base.vo.MngUnitDepart;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 单位部门管理ACTION
 * @author GK
 *
 */
public class UnitDepartAction extends BaseAction {
	private UnitDepartService unitDepartService = (UnitDepartService)getBean("unitDepartService");
	private SchoolService schoolService = (SchoolService)getBean("schoolService");
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private LogService log = (LogService)getBean("logService");
	private MngUnitDepartForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngUnitDepart vo;//查询返回的VO
	private String menu;//菜单查询
	private MngSchoolDepartForm sdForm; //单位校区表单
	private String msg = "";//消息
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 初始化单位部门信息菜单树
	 * @return
	 * @throws Exception
	 */
	public String toMenuUD() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//查询1级单位部门列表
	 	List udList = unitDepartService.findTreeList();
	 	ActionContext.getContext().getValueStack().set("udList", udList);
	 	return "toMenuUD";
	}
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngUnitDepartForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(unitDepartService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = unitDepartService.findPage(form);
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		return "add";
	}
	
	/**
	 * 如果有1个学校，那么清除单位层次下拉的学校层次
	 * @return
	 * @throws Exception
	 */
	public String canAddSchool() throws Exception {
		boolean bl = unitDepartService.canAddSchool();
		ActionContext.getContext().getValueStack().set("bl", bl);
		return "canAddSchool";
	}
	
	/**
	 * 检查同一上级单位下，单位名称是否唯一
	 * @return
	 * @throws Exception
	 */
	public String checkUnique() throws Exception {
		form.setUd_sname(serviceStr(form.getUd_sname()));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(unitDepartService.checkUni(form));
		return null;
	}
	 
	
	/**
	 * 根据单位层次查询可用隶属单位列表
	 * @return
	 * @throws Exception
	 */
	public String findTopList() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		List topList = unitDepartService.findTopList(form.getUd_nnumber());
		ActionContext.getContext().getValueStack().set("topList", topList);
		return "findTopList";
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
		//相邻级别之间编码长度之差
		int length = 2;
		String no = unitDepartService.getNO(form.getUd_nnumber().intValue(), length, form.getUd_stopno(), sequenceService, userInfo);
		form.setUd_sno(no);
		form.setUd_nisuse(0L);
		form.setUd_sisdel("0");
		form.setUd_sreplyby(userInfo.getScreenname());
		//获取action的名字
		String actionName = ActionContext.getContext().getName();
		String path = request.getContextPath() + "/" + actionName + "!find";
		response.setCharacterEncoding("UTF-8");
		boolean bl = unitDepartService.save(form);
		 if (bl) {
				message = "新增成功！";
				log.logInsert(userInfo, "新增单位部门", "mng_unitDepart");
			} else {
				message = "新增失败！";
			}
			form = null;
		/*if (unitDepartService.save(form)) {
			//防刷新重复提交，防后退，window.returnValue = false解决IE可能的跳转失败
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "';window.returnValue = false;</script>");
			log.logInsert(userInfo, "新增单位部门", "mng_unitDepart");
		} else {
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "';window.returnValue = false;</script>");
		}*/
		return find();
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			String[] arr = idchecked[0].split(":");
			vo = unitDepartService.findByID(arr[0]);
		}
		List udList = unitDepartService.findAll();
		ActionContext.getContext().getValueStack().set("udList", udList);
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
		form.setUd_dalterdate(userInfo.getScreenname());
		//获取action的名字
		//String actionName = ActionContext.getContext().getName();
		//String path = request.getContextPath() + "/" + actionName + "!find";
		response.setCharacterEncoding("UTF-8");
		boolean bl = unitDepartService.update(form);
		System.out.println("bl="+bl);
		 if (bl) {
				message = "修改成功！";
				log.logInsert(userInfo, "修改单位部门", "mng_unitDepart");
			} else {
				message = "修改失败！";
			}
			form = null;
		/*if (unitDepartService.update(form)) {
			//防刷新重复提交，防后退，window.returnValue = false解决IE可能的跳转失败
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "';window.returnValue = false;</script>");
			log.logInsert(userInfo, "修改单位部门", "mng_unitDepart");
		} else {
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "';window.returnValue = false;</script>");
		}*/
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
		boolean bl = unitDepartService.delete(hasSub(idchecked, "还有下级部门，无法删除！\n"));
		if (bl) {
			message = "删除成功！";
			log.logInsert(userInfo, "删除单位部门信息", "mng_unitdepart");
		} else {
			message = "删除失败！";
		}
		return "toDelete";
	}
	
	/**
	 * 根据编号数组判断其中有哪些信息不能改变，哪些能改变
	 * @param arr
	 * @return
	 */
	private String[] hasSub(String[] arr, String message) {
		String[] results = null;
		if (arr != null) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < arr.length; i++) {
				String str = arr[i];
				String[] no_name = str.split(":");
				String no = no_name[0];
				String name = no_name[1];
				if (unitDepartService.hasSub(no)) {
					msg += name + "(" + no + ")" + message;
				} else {
					list.add(no);
				}
			}
			int size = list.size();
			if (size > 0) {
				results = new String[size];
				results = list.toArray(results);
			}
		}
		return results;
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
		boolean bl = unitDepartService.changeValid(hasSub(idchecked, "还有有效的下级部门，无法改变状态！\n"));
		if (bl) {
			message = "更新成功！";
			log.logInsert(userInfo, "更新单位部门信息", "mng_unitdepart");
		} else {
			message = "更新失败！";
		}
		return "changeValid";
	}
	
	/**
	 * 导入单位部门信息
	 * @return
	 * @throws Exception
	 */
	public String toImport() throws Exception {
		return null;
	}
	
	/**
	 * 导出单位部门信息
	 * @return
	 * @throws Exception
	 */
	public String exportExcel() throws Exception {
		//判断form表单是否为空
		if(form==null){
			form = new MngUnitDepartForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}

		//按条件查询
		List allList = unitDepartService.findPage(form);
		unitDepartService.exportExcel(allList,response);
		return null;
	}
	
	/**
	 * 设置校区
	 * @return
	 * @throws Exception
	 */
	public String findSchool() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	if (sdForm == null) {
	 		sdForm = new MngSchoolDepartForm();
	 	}
	 	String udno = request.getParameter("udno");
 		sdForm.setUd_sno(udno);
 		List noList = unitDepartService.findByUDNo(sdForm);
 		System.out.println("noList = " + noList);
	 	list = schoolService.findAll();
	 	for (int i = 0, size = list.size(); i < size; i++) {
	 		MngSchool school = (MngSchool) list.get(i);
	 		System.out.println("sh_sno = " + school.getSh_sno());
	 		if (noList.contains(school.getSh_sno())) {
	 			school.setIsChecked("1");
	 		} else {
	 			school.setIsChecked("0");
	 		}
	 	}
		return "findSchool";
	}
	
	/**
	 * 保存校区设置
	 * @return
	 * @throws Exception
	 */
	public String saveSchool() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//arrSchoolNO为null表示没有复选框被选中
	 	String[] arrSchoolNO = request.getParameterValues("idcheckbox");
	 	unitDepartService.saveSchool(sdForm, arrSchoolNO);
	 	response.setCharacterEncoding("UTF-8");
	 	response.getWriter().print("<script type='text/javascript'>window.close();</script>");
	 	return null;
	}
	
	public MngUnitDepartForm getForm() {
		return form;
	}

	public void setForm(MngUnitDepartForm form) {
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

	public MngUnitDepart getVo() {
		return vo;
	}

	public void setVo(MngUnitDepart vo) {
		this.vo = vo;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	public MngSchoolDepartForm getSdForm() {
		return sdForm;
	}
	public void setSdForm(MngSchoolDepartForm sdForm) {
		this.sdForm = sdForm;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
