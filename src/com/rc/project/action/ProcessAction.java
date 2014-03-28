package com.rc.project.action;

import java.math.BigDecimal;
import java.util.List;

import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.service.PackageService;
import com.rc.project.service.ProcessService;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpSetting;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class ProcessAction extends BaseAction {
	private List list;
	private EpProcess vo;
	private EpProcessForm form;
	// private PageBean bean;
	private PackageService service = (PackageService) getBean("packageService");

	private EpSetting getNextProcess(String purType, int currentNo) {
		int nextNo = currentNo + 1;
		EpSettingForm form = new EpSettingForm();
		form.setSET_SPURTYPE(purType);
		form.setSET_NNO(BigDecimal.valueOf(nextNo));
		return service.findnextSetid(form);
	}

	private EpSetting getPreProcess(String purType, int currentNo) {
		int nextNo = currentNo - 1;
		EpSettingForm form = new EpSettingForm();
		form.setSET_SPURTYPE(purType);
		form.setSET_NNO(BigDecimal.valueOf(nextNo));
		return service.findnextSetid(form);
	}

	public String find() {
		if (form == null) {
			form = new EpProcessForm();
		}
		// 验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		// 初始化分页标签
		// String page = request.getParameter("page");
		// bean = new PageBean(service.findSize(form),
		// PageBean.PAGE_SIZE);
		// if (page != null) {
		// bean.setCurrentPage(Integer.parseInt(page));
		// }
		// 设置分页语句
		// form.setPageSQLA(bean.getPageSQLA());
		// form.setPageSQLB(bean.getPageSQLB());
		// 分页查询
		list = service.findPage();
		return "find";
	}

	public String toFirsttrial() {
		return "firsttrial";
	}

	public String ok() {
		String ss_nid = this.request.getParameter("ss_nid");
		String set_nno = this.request.getParameter("set_nno");
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno = this.request.getParameter("ep_sno");
		String set_spurtype = this.request.getParameter("set_spurtype");
		
		EpProcessForm process = new EpProcessForm();
		process.setSS_SREMARK("当前提交技术审核");

		service.submitCurrentProcess(this.request, process);
		/*// 修改当前状态 已经操作
		EpProcessForm process = new EpProcessForm();
		process.setSS_NID(BigDecimal.valueOf(Integer.parseInt(ss_nid)));
		process.setSS_SSTATE("1");
		process.setSS_SREMARK("某某提交当前状态，添加备注信息");
		System.out.println("修改当前状态1");
		service.updateProcessState(process);

		// 添加下一步操作 为操作
		EpProcessForm form = new EpProcessForm();
		form.setBG_SNO(bg_sno);
		form.setEP_SNO(ep_sno);
		form.setSS_NNO(this.getNextProcess(set_spurtype,
				Integer.parseInt(set_nno)).getSET_NID());
		form.setSS_SSTATE("0");
		service.insertProcess(form);*/
		return this.find();
	}

	// 每一步回退
	public String back() {
		EpProcessForm process = new EpProcessForm();
		/*String ss_nid = this.request.getParameter("ss_nid");
		String set_nid = this.request.getParameter("set_nid");
		String set_nno = this.request.getParameter("set_nno");
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno = this.request.getParameter("ep_sno");
		String set_spurtype = this.request.getParameter("set_spurtype");
		// 修改当前状态为退回
		EpProcessForm process = new EpProcessForm();
		process.setSS_NID(BigDecimal.valueOf(Integer.parseInt(ss_nid)));
		process.setSS_SSTATE("3");
		process.setSS_SREMARK("某某回退");
		service.updateProcessState(process);		
		
		//如果是初审退回操作
		if (set_nno.equals("1")) {
			System.out.println("初审退回");
			return this.reject();
		}
		else{
		// 在process中修改当前状态回退，然后添加一个上一步未操作记录
		// 添加下一步操作 为操作
			int setnnid = Integer.valueOf(set_nid);
			EpProcessForm form = new EpProcessForm();
			form.setBG_SNO(bg_sno);
			form.setEP_SNO(ep_sno);
			form.setSS_NNO(getPreProcess(set_spurtype, Integer.parseInt(set_nno))
					.getSET_NID());
			form.setSS_SSTATE("0");
			service.insertProcess(form);
			System.out.println("步骤退回");
			return this.find();
		}*/
		process.setSS_SREMARK("退回操作");
		service.backCurrentProcess(this.request, process );
		return this.find();
	}

	/*// 初审回退
	public String reject() {
		String ss_nid = this.request.getParameter("ss_nid");
		String bg_sno = this.request.getParameter("bg_sno");
		// 修改包的状态，修改当前process中的状态为未操作。
		ProjectService pService = (ProjectService) getBean("projectService");
		pService.back(bg_sno);
		return this.find();
	}*/

	public String firsttrial() {
		// 根据process中的主键修改当前状态为已操作
		// 在process表中添加一个下一个流程的未操作记录
		return this.ok();
	}

	public String toPrint() {
		return "print";
	}

	public String sendMail() {
		return this.find();
	}

	public String print() {
		return toFirsttrial();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public EpProcess getVo() {
		return vo;
	}

	public void setVo(EpProcess vo) {
		this.vo = vo;
	}

	public EpProcessForm getForm() {
		return form;
	}

	public void setForm(EpProcessForm form) {
		this.form = form;
	}

	public PackageService getService() {
		return service;
	}

	public void setService(PackageService service) {
		this.service = service;
	}

}
