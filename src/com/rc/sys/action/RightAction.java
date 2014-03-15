package com.rc.sys.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.service.LogService;
import com.rc.sys.service.RightService;
import com.rc.sys.vo.MngRight;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;
import com.rc.util.UserInfo;

/**
 * 功能权限管理ACTION
 * @author GK
 *
 */
public class RightAction extends BaseAction implements ServletContextAware{
	private RightService rightService = (RightService)getBean("rightService");
	private LogService log = (LogService)getBean("logService");
	private MngRightForm form; //form表单
	private PageBean bean;//分页标签类
	private List list;//查询列表
	private MngRight vo;//查询返回的VO
	private ServletContext servletContext;//Servlet上下文
	private List<String> imgNameList;	//图标地址列表
	private File mf;// 客户端上传的文件
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
			form = new MngRightForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(rightService.findSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = rightService.findPage(form);
		
		return "find";
		
	}
 
	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngRightForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	List sysIntList = rightService.findSysIntList();
	 	ActionContext.getContext().getValueStack().set("sysIntList", sysIntList);
		return "toAdd";
	}
	
	/**
	 * 查找功能级别列表
	 * @return
	 * @throws Exception
	 */
	public String findRightNum() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	List rightNumList = rightService.findRightNumList(form.getSysint_sno());
	 	ActionContext.getContext().getValueStack().set("rightNumList", rightNumList);
		return "findRightNum";
	}
	/**
	 * 处理查询上级功能请求.<p>
	 * @return 返回json数据类型
	 * @throws Exception
	 */
	public String findSparent() throws Exception {
		List sparentList = rightService.findSparentList(form);
		ActionContext.getContext().getValueStack().set("sparentList", sparentList);
		return "findSparent";
	}
	/**
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngRightForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		//功能编号
		String right_sno = "";
		//菜单长度
		int len = form.getRight_sname().length();
		String right_sparentno = form.getRight_sparentno();
		if (!"0".equals(right_sparentno)) {
			//根据上级功能编号查询子功能数
			int size = rightService.findSubSize(form);
			if (size < 9) {
				right_sno = right_sparentno + "0" + Integer.toString(size + 1); 
			} else {
				right_sno = right_sparentno + Integer.toString(size + 1);
			}
			Integer ordVal = rightService.findMaxOrdval(form);
			if (ordVal == null) {
				ordVal = 1;
			} else {
				ordVal = ordVal + 1;
			}
			form.setRight_norder(ordVal.longValue());
			form.setRight_sischild("0");
			form.setRight_sfather(right_sparentno);
		} else {
			//查询功能级别为1级的所有功能
			int size = rightService.findMenu(form.getSysint_sno()).size();
			System.out.println("size = " + size);
			if (size < 9) {
				right_sno = right_sparentno + Integer.toString(size + 1);
			} else {
				right_sno = Integer.toString(size + 1);
			}
			Integer menuOrdval = rightService.findMaxMenuOrdval(form);
			if (menuOrdval == null) {
				menuOrdval = 1;
			} else {
				menuOrdval = menuOrdval + 1;
			}
			form.setRight_norder(menuOrdval.longValue());
			form.setRight_sischild("1");
		}
		//设置功能编号:系统编号 + 生成的编号
		form.setRight_sno(right_sno);
		System.out.println("功能编号："  + form.getRight_sno());
		form.setRight_nmenulength(Integer.valueOf(len).longValue());
		form.setRight_sisvalid("0");
		form.setRight_sisdel("0");
		form.setRight_sreplyby(userInfo.getScreenname());
		boolean bl = rightService.save(form); 
		if(bl==true){
			message = "新增成功";
			log.logInsert(userInfo, "新增功能权限", "mng_right");
		}else{
			message = "新增失败";
		}
		/*if (rightService.save(form)) {
			 log.logInsert(userInfo, "新增功能权限", "mng_right");
		}*/  
		return find();
	}

	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new MngRightForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(idchecked!=null&&idchecked.length==1){
			String[] str = idchecked[0].split(":");
			if (str!=null) {
				form.setSysint_sno(str[0]);
				form.setRight_sno(str[1]);
			}
			vo = rightService.findByID(form);
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
		form.setRight_salterby(userInfo.getScreenname());
		boolean bl = rightService.update(form);
		if(bl==true){
			message = "修改成功";
			log.logInsert(userInfo, "修改功能权限", "mng_right");
		}else{
			message = "修改失败";
		}
		
		form = null;
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
		String msg = "";
		StringBuffer sb = new StringBuffer();
		String[] idchecked = request.getParameterValues("idcheckbox");
		List<String> ids = new ArrayList<String>();
		if (idchecked != null && idchecked.length > 0) {
			for (int i = 0; i < idchecked.length; i++) {
				String str = idchecked[i];
				if (str == null) {
					continue;
				}
				String[] arr = str.split(":"); 
				if (arr!=null) { 
					form.setSysint_sno(arr[0]);
					form.setRight_sno(arr[1]);
					form.setSysint_sname(arr[2]);
					form.setRight_sname(arr[3]);
				}
				boolean bl = true;
				if (rightService.hasSub(form)) { 
					sb.append("系统：" + form.getSysint_sname() + "，功能：" + form.getRight_sname()+"("+form.getRight_sno() + ")还有下级功能，请先删除下级功能！\n");
					bl = false;
				} else if (rightService.hasOper(form)) {
					sb.append("系统：" + form.getSysint_sname() + "，功能：" + form.getRight_sname()+"("+form.getRight_sno() + ")还有有效的操作功能，请先删除操作功能！\n");
					bl = false;
				} else if (rightService.isRoleRightValid(form)) {
					sb.append("系统：" + form.getSysint_sname() + "，功能：" + form.getRight_sname()+"("+form.getRight_sno() + ")还有有效的角色在使用，无法删除！\n");
					bl =false;
				} else { 
					ids.add(str);
				}
			}
		}
		if (ids.size() > 0 && "".equals(sb.toString())) {
			boolean bl = rightService.delete(ids);
			if(bl==true){
				message = "删除成功";
				log.logInsert(userInfo, "删除功能权限", "mng_right");
			}else{
				message = "删除失败";
			}
			
		}
		msg = sb.toString();
		ActionContext.getContext().getValueStack().set("msg", msg);
		return "toDelete";
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
		String msg = "";
		StringBuffer sb = new StringBuffer();
		List<String> ids = new ArrayList<String>();
		if (idchecked != null && idchecked.length != 0) {
			for (int i = 0; i < idchecked.length; i++) {
				String tmp = idchecked[i];
				String[] arr = tmp.split(":");
				String sysint_sno = "";
				String sysint_sname = "";
				String right_sno = ""; 
				String right_sname = "";
				if (arr != null ) { 
					sysint_sno = arr[0];
					right_sno = arr[1];
					sysint_sname = arr[2];
					right_sname = arr[3];
				}
				form.setSysint_sno(sysint_sno);
				form.setSysint_sname(sysint_sname);
				form.setRight_sno(right_sno); 
				form.setRight_sname(right_sname); 
				if (rightService.isRoleRightValid(form)) { 
					sb.append("系统：" + form.getSysint_sname() + "，功能：" + form.getRight_sname()+"("+form.getRight_sno() + ")还有角色在使用，无法改变状态！\n");
				} else {
					ids.add(tmp);
				}
			}
		}
		if (ids.size() != 0&& "".equals(sb.toString())) {
			boolean bl = rightService.changeValid(ids);
			if(bl==true){
				message = "更新成功";
				log.logInsert(userInfo, "更新功能权限状态", "mng_right");
			}else{
				message = "更新失败";
			}
			
		}
		msg = sb.toString();
		ActionContext.getContext().getValueStack().set("msg", msg);
		return "changeValid";
	}
	
	/**
	 * 跳转功能排序页面
	 * @return
	 * @throws Exception
	 */
	public String toOrder() throws Exception {
		List sysIntList = rightService.findSysIntList();
		ActionContext.getContext().getValueStack().set("sysIntList", sysIntList);
		return "toOrder";
	}
	
	/**
	 * 查询菜单排序列表
	 * @return
	 * @throws Exception
	 */
	public String findMenu() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		//查询某个系统功能级别为1级的菜单
		System.out.println("sysint_sno = " + form.getSysint_sno());
		List menuList = rightService.findMenu(form.getSysint_sno());
		ActionContext.getContext().getValueStack().set("menuList", menuList);
		return "findMenu";
	}
	
	/**
	 * 查询功能排序列表
	 * @return
	 * @throws Exception
	 */
	public String findSub() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		MngRight right = rightService.findByID2(form);
		if (right != null) {
			form.setRight_ndef1(right.getRight_ndef1());
		}
		List subList = rightService.findSubList(form);
		ActionContext.getContext().getValueStack().set("subList", subList);
		return "findSub";
	}
	
	/**
	 * 保存排序值
	 * @return
	 * @throws Exception
	 */
	public String order() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean isSuccess = false;
		String orderValue = request.getParameter("orderValue");
		if (orderValue != null) {
			String[] orderVals = orderValue.split(",");
			System.out.println(Arrays.toString(orderVals));
			if (orderVals.length != 0) {
				isSuccess = rightService.saveOrderValue(orderVals, userInfo.getScreenname());
			}
		}
		if (isSuccess) {
			log.logInsert(userInfo, "修改功能排序", "mng_right");
		}
		ActionContext.getContext().getValueStack().set("isSuccess", isSuccess);
		return "order";
	}
	
	public String findImgList() throws Exception {
		String realPath = servletContext.getRealPath("images");
		File folder = new File(realPath);
		imgNameList = new ArrayList<String>();
		this.listFilesNames(folder);
		return "findImgList";
	}
	
	/**
	 * 获取图标文件名列表
	 * @param folder
	 * @throws Exception
	 */
	private void listFilesNames(File folder){
		if (folder.isFile()) {
			throw new RuntimeException(folder.getPath() + "不是一个文件夹！");
		}
		File[] files = folder.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				listFilesNames(f);
			} else {
				String path = f.getPath();
				//获取images文件夹的图标名，若有文件夹，则为文件夹名+图标名
				String sub = path.substring(path.lastIndexOf("images"));
				//以'/'替换掉路径中的'\'
				if (sub.contains("\\")) {
					//注意：字符'\'的正则表达式写法为"\\\\"
					sub = sub.replaceAll("\\\\", "/");
				}
				imgNameList.add(sub);
			}
		}
	}
	
	/**
	 * 检查功能名称唯一性
	 * @return
	 * @throws Exception
	 */
	public String checkUnique() throws Exception {
		form.setRight_sname(serviceStr(form.getRight_sname()));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(rightService.isRightnameValid(form));
		return null;
	}
	
	 
	
	/**
	 * 上传制度文档
	 * 
	 * @return
	 * @throws Exception
	 */
	public void fileUp() throws Exception {
		response.setCharacterEncoding("UTF-8");
		String message = "";
		if(mf==null){
			message = "请选择文件！"; 
		}else{
			message = rightService.fileUp(mf);
		}
		response.getWriter().print(message);
		
	}
	
	
	
	public MngRightForm getForm() {
		return form;
	}

	public void setForm(MngRightForm form) {
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

	public MngRight getVo() {
		return vo;
	}

	public void setVo(MngRight vo) {
		this.vo = vo;
	}

	public List<String> getImgNameList() {
		return imgNameList;
	}

	public void setImgNameList(List<String> imgNameList) {
		this.imgNameList = imgNameList;
	}

	public void setServletContext(ServletContext context) {
		servletContext = context; 
	}

	public File getMf() {
		return mf;
	}

	public void setMf(File mf) {
		this.mf = mf;
	}
	
	
	
}
