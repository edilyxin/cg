package com.rc.base.action;

import java.util.List;
import com.rc.base.form.MngPostForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.base.service.PostService;
import com.rc.base.vo.MngPost;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 职称管理ACTION
 * @author GK
 *
 */
public class PostAction extends BaseAction {
	private PostService postService = (PostService)getBean("postService");
	private LogService log = (LogService)getBean("logService");
	private MngPostForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngPost vo;//查询返回的VO
	private boolean ok;
	private  List list1;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
/*	public String toAjax(){
		form.setPost_sname(serviceStr(form.getPost_sname()));
		ok = postService.checkOnly(form);
		return "toAjax";
	}*/
	


	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngPostForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(postService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = postService.findPage(form);
		//查询等级
		list1=postService.findnlevel(form);
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

	/**String no = sequenceService.getNO(userInfo.getSysint_sno(), "1", "emp_sno");
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		form.setPost_sreplyby(userInfo.getScreenname());
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "post_sno");
		form.setPost_sno(no);
		boolean bl = postService.save(form);
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增职称", "mng_post");
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
			vo = postService.findByID(idchecked[0]);
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
		boolean bl =  postService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改职称", "mng_post");
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
		boolean bl = postService.delete(idchecked);
		if(bl==true){
			message = "删除成功";
			log.logInsert(userInfo, "删除职称", "mng_post");
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
		boolean bl = postService.changeValid(idchecked);
		if(bl==true){
			message = "更新成功";
			log.logInsert(userInfo, "更新职称状态", "mng_post");
		}else{
			message = "更新失败";
		}
		
		return find();
	}
	/**
	 * 
	 * 此方法描述的是：导出 
	 * @author: Administrator
	 * @version: 2013-6-2 下午06:21:15
	 */
	public String exportExcel() throws Exception {
		//判断form表单是否为空
		if(form==null){
			form = new MngPostForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}

		//按条件查询
		List allList = postService.findPage(form);
		postService.exportExcel(allList,response);
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
	//验证唯一性
	public String checkUnique() throws Exception{
		
		
				
		form.setPost_sname(serviceStr(form.getPost_sname()));
		response.getWriter().print(postService.checkOnly(form));
		return null;
	}	
	

	public MngPostForm getForm() {
		return form;
	}

	public void setForm(MngPostForm form) {
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

	public MngPost getVo() {
		return vo;
	}

	public void setVo(MngPost vo) {
		this.vo = vo;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	
}
