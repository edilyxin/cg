package com.rc.base.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.rc.base.form.MngSchoolForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.base.service.SchoolService;
import com.rc.base.vo.MngSchool;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 校区管理ACTION
 * @author GK
 *
 */
public class SchoolAction extends BaseAction {
	private SchoolService schoolService = (SchoolService)getBean("schoolService");
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private LogService log = (LogService)getBean("logService");
	private MngSchoolForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngSchool vo;//查询返回的VO
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
			form = new MngSchoolForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(schoolService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = schoolService.findPage(form);
		return "find";
		
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
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "SH_SNO");
		form.setSh_sno(no);
		boolean bl = schoolService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增校区", "mng_school");
		}else{
			message = "新增失败";
		}
		
		return find();
	}

	/**
	 * 校区名称是否唯一
	 * @return
	 * @throws Exception
	 */
	public String checkUnique() throws Exception{

		
		if(form.getSearchE()!=null){
		form.setSearchE(serviceStr(form.getSearchE()));		
		}
		form.setSh_sname(serviceStr(form.getSh_sname()));
		response.getWriter().print(schoolService.checkUnique(form));
		return null;
	}
	
	
	//服务器格式  转换中文乱码问题
	public String serviceStr(String str){
		try {
			return new  String(str.getBytes("ISO8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}	
	/*public String checkUnique() throws Exception {
		
		boolean isOK = schoolService.checkUnique(form);
		ActionContext.getContext().getValueStack().set("isOK", isOK);
		return "checkUnique";
	}*/
	
	
	
	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			vo = schoolService.findByID(idchecked[0]);
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
		boolean bl = schoolService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改校区", "mng_school");
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
		boolean bl = schoolService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除校区", "mng_school");
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
		boolean bl = schoolService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新校区状态", "mng_school");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	

	public MngSchoolForm getForm() {
		return form;
	}

	public void setForm(MngSchoolForm form) {
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

	public MngSchool getVo() {
		return vo;
	}

	public void setVo(MngSchool vo) {
		this.vo = vo;
	}

	
}
