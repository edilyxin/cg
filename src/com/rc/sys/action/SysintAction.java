package com.rc.sys.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.sys.service.SysintService;
import com.rc.sys.vo.MngSysint;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 系统集成信息管理ACTION
 * @author GK
 *
 */
public class SysintAction extends BaseAction {
	private SequenceService sequenceService = (SequenceService)getBean("sequenceService");
	private SysintService sysintService = (SysintService)getBean("sysintService");
	private LogService log = (LogService)getBean("logService");
	private MngSysintForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngSysint vo;//查询返回的VO
	private String id;
	private String message;
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
		 String no = sequenceService.getNO("", "0", "sys_sno");
		form.setSysint_sno(no);
		String path = request.getContextPath() + "/sysint!find";
		response.setCharacterEncoding("UTF-8");
		boolean bl =  sysintService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增系统集成信息", "mng_sysint");
		}else{
			message = "新增失败";
		}
		/*if (sysintService.save(form)) {
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "'</script>");
			log.logInsert(userInfo, "新增系统集成信息", "mng_sysint");
		} else {
			response.getWriter().print("<script type='text/javascript'>window.location.href='" + path + "'</script>");
		}*/

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
		boolean bl =  sysintService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新系统集成信息状态", "mng_sysint");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	
	

	/**
	 * 判断系统名称唯一
	 * @return
	 * @throws Exception
	 */
	public String checkUnique() throws Exception{
		if(null!=form.getSysint_sname()){
		form.setSysint_sname(serviceStr(form.getSysint_sname()));
		}
		if(null!=form.getSysint_ssname()){
		form.setSysint_ssname(serviceStr(form.getSysint_ssname()));
		}
		response.getWriter().print(sysintService.checkUnique(form));
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
			form = new MngSysintForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(sysintService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = sysintService.findPage(form);
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
		List<String> ids = new ArrayList<String>();
		 
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < idchecked.length; i++) {
			String str = idchecked[i].split("%u0008")[0];
			String sysname = idchecked[i].split("%u0008")[1];
			boolean bl = sysintService.findID(str);
			if (bl) {
				ids.add(str);
			} else {
				sb.append("系统 【" + sysname + "】有功能在使用中,无法删除！\\n");
			}
		}
		message = sb.toString();
		idchecked = ids.toArray(idchecked);
		if (ids.size() > 0) {
			boolean bl = sysintService.delete(idchecked);
			if(bl==true){
				message = "删除成功";
				log.logInsert(userInfo, "删除系统集成信息", "mng_sysint");
			}else{
				message = "删除失败";
			}
			
		}
		
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
			vo = sysintService.findByID(idchecked[0].split("%u0008")[0]);
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
		boolean bl = sysintService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改系统集成信息", "mng_sysint");
		}else{
			message = "修改失败";
		}
		
		return find();
		
	}

	
	public PageBean getBean() {
		return bean;
	}
	
	public MngSysintForm getForm() {
		return form;
	}
	public String getId() {
		return id;
	}
	
	
	

	public List getList() {
		return list;
	}

	public MngSysint getVo() {
		return vo;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public void setForm(MngSysintForm form) {
		this.form = form;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setVo(MngSysint vo) {
		this.vo = vo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
