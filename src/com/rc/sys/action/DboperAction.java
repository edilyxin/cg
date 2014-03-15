package com.rc.sys.action;

import java.util.List;
import com.rc.sys.form.MngDboperForm;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.DboperService;
import com.rc.sys.service.SequenceService;
import com.rc.sys.vo.MngDboper;
import com.rc.sys.vo.MngRight;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 数据权限管理ACTION
 * @author GK
 *
 */
public class DboperAction extends BaseAction {
	private DboperService dboperService = (DboperService)getBean("dboperService");
	private LogService log = (LogService)getBean("logService");
	private MngDboperForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngDboper vo;//查询返回的VO
	private MngRightForm rightform; //功能表form
	private List syslist;
	private MngSysintForm sysform; //系统表form
	private String msg;
	private boolean ok;
	public String toAjax(){
		form.setDboper_sname(serviceStr(form.getDboper_sname()));
		ok = dboperService.checkOnly(form);
		return "toAjax";
	}
	public String serviceStr(String str){//服务器格式
		try {
			return new  String(str.getBytes("ISO8859-1"),"gbk");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngDboperForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(dboperService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = dboperService.findPage(form);
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		list=dboperService.findright(rightform);
		syslist=dboperService.findsys(sysform);
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
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "dboper_sno");
		form.setDboper_sno(no);
		dboperService.save(form);
		log.logInsert(userInfo, "新增数据权限", "mng_dboper");
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
			vo = dboperService.findByID(idchecked[0]);
		}
		//System.out.println(vo.getRight_sno());
		//System.out.println(vo.getDboper_sname());
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
		dboperService.update(form);
		log.logInsert(userInfo, "修改数据权限", "mng_dboper");
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
		dboperService.delete(idchecked);
		log.logInsert(userInfo, "删除数据权限", "mng_dboper");
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
		dboperService.changeValid(idchecked);
		log.logInsert(userInfo, "更新数据权限状态", "mng_dboper");
		return find();
	}
	

	public MngDboperForm getForm() {
		return form;
	}

	public void setForm(MngDboperForm form) {
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

	public MngRightForm getRightform() {
		return rightform;
	}

	public void setRightform(MngRightForm rightform) {
		this.rightform = rightform;
	}

	public MngDboper getVo() {
		return vo;
	}

	public void setVo(MngDboper vo) {
		this.vo = vo;
	}

	public List getSyslist() {
		return syslist;
	}

	public void setSyslist(List syslist) {
		this.syslist = syslist;
	}

	public MngSysintForm getSysform() {
		return sysform;
	}

	public void setSysform(MngSysintForm sysform) {
		this.sysform = sysform;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	


	
}
