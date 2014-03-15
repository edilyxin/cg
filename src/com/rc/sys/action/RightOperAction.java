/**
 * 
 */
package com.rc.sys.action;

import java.util.List;

import com.rc.sys.form.MngOperForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.OperService;
import com.rc.sys.vo.MngOper;
import com.rc.sys.vo.MngRight;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

/**
 * 功能操作对应的Action类.<p>
 * @author Administrator
 */
public class RightOperAction extends BaseAction {
	private OperService operService = (OperService)getBean("operService");
	private LogService log = (LogService)getBean("logService");
	private MngOperForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngOper vo;//查询返回的VO
	private MngRight vo1;//查询返回的VO
	private List list1;//查询所有系统名称
	private String sign;
	private String ok;
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngOperForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(operService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = operService.findPage(form);
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		 list1=operService.findAllsysint_sname();
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
		list=operService.findOperByRight(form.getRight_sno(),form.getSysint_sno());
           if(list.size()<9){
			form.setOper_sno(form.getRight_sno()+"0"+(list.size()+1));
		}else{
			form.setOper_sno(form.getRight_sno()+(list.size()+1));
		}
		operService.save(form);
		log.logInsert(userInfo, "新增操作权限", "mng_oper");
		return find();
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		System.out.println("idchecked[0]="+idchecked[0]);
		if(idchecked!=null&&idchecked.length==1){
			String s[]=idchecked[0].split("-");
			System.out.println(s[0]+"s[0]");
			if (s!=null) {
				form.setOper_sno(s[0]);
				form.setSysint_sno(s[1]);
			}
			vo = operService.findByID(form);
			list1=operService.findAllsysint_sname();
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
		operService.update(form);
		log.logInsert(userInfo, "修改操作权限", "mng_oper");
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
		operService.delete(idchecked);
		log.logInsert(userInfo, "删除操作权限", "mng_oper");
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
		operService.changeValid(idchecked);
		log.logInsert(userInfo, "更新操作权限状态", "mng_oper");
		return find();
	}
	
	public String findOperSname()throws Exception{
		System.out.println("form.getSysint_sno()="+form.getSysint_sno());
		System.out.println("form.getRight_sno()="+form.getRight_sno());
		System.out.println("form.getOper_sname()="+form.getOper_sname());
		list = operService.findAllSname(form);
		System.out.println(list.size());
		if(list.size()<=0){
			
			ok="1";
			
		}else{
			ok="";
			
		}
		return "findOperSname";
	}
	
	public String checkUnique() throws Exception{
		System.out.println("form.getSysint_sno()="+form.getSysint_sno());
		System.out.println("form.getRight_sno()="+form.getRight_sno());
		
		String oper_sname=request.getParameter("form.oper_sname");
		oper_sname=new String(oper_sname.getBytes("ISO-8859-1"),"utf-8") ;
		System.out.println(oper_sname+"oper_sname");
		form.setOper_sname(oper_sname);
		System.out.println("form.getOper_sname()="+form.getOper_sname());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(operService.checkUnique(form));
		return null;
	}

	public MngOperForm getForm() {
		return form;
	}

	public void setForm(MngOperForm form) {
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

	public MngOper getVo() {
		return vo;
	}

	public void setVo(MngOper vo) {
		this.vo = vo;
	}

	public MngRight getVo1() {
		return vo1;
	}

	public void setVo1(MngRight vo1) {
		this.vo1 = vo1;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
}
