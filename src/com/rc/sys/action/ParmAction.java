package com.rc.sys.action;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.rc.sys.form.MngParmForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.ParmService;
import com.rc.sys.vo.MngParm;
import com.rc.sys.vo.MngSysint;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 参数管理ACTION
 * @author GK
 *
 */
public class ParmAction extends BaseAction {
	private ParmService parmService = (ParmService)getBean("parmService");
	private LogService log = (LogService)getBean("logService");
	private MngParmForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngParm vo;//查询返回的VO
	private String ok;
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
			form = new MngParmForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(parmService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = parmService.findPage(form);
		List<MngSysint> syslist = parmService.sysinfo();
		
		ActionContext.getContext().getValueStack().set("syslist", syslist);
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		
		List<MngSysint> syslist = parmService.sysinfo();
	
		ActionContext.getContext().getValueStack().set("syslist", syslist);
	
		return "add";
	}
	/**
	 * 遍历所有访问名
	 * @throws IOException 
	 */
	public String findParmSname() throws Exception{
		String linename = new String(request.getParameter("form.parm_sname").getBytes("ISO-8859-1"),"UTF-8");
	 	form.setParm_sname(linename);
	 	response.setCharacterEncoding("UTF-8");
		response.getWriter().print(parmService.findAllSname(form));
		return null;
		
	}
	public String serviceStr(String str){//服务器格式
		try {
			return new  String(str.getBytes("ISO8859-1"),"GBK");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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
		
		boolean bl =  parmService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增参数", "mng_parm");
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
		String[] idchecked = request.getParameterValues("idcheckbox");
		
		if(idchecked!=null&&idchecked.length==1){
			vo = parmService.findByID(idchecked[0]);
		}
		
	
		List<MngSysint> syslist = parmService.sysinfo();
		ActionContext.getContext().getValueStack().set("syslist", syslist);
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
		boolean bl =  parmService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改参数", "mng_parm");
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
		boolean bl = parmService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除参数", "mng_parm");
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
		boolean bl = parmService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新参数状态", "mng_parm");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	

	public MngParmForm getForm() {
		return form;
	}

	public void setForm(MngParmForm form) {
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

	public MngParm getVo() {
		return vo;
	}

	public void setVo(MngParm vo) {
		this.vo = vo;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	
}
