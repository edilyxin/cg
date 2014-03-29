package com.rc.project.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.aop.IntroductionAdvisor;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpBidForm;
import com.rc.project.form.EpPayMoneyForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.service.BidService;
import com.rc.project.service.ContractService;
import com.rc.project.service.PackageService;
import com.rc.project.service.PayMoneyService;
import com.rc.project.vo.EpContract;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpPayMoney;
import com.rc.sys.service.LogService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;

public class PayMoneyAction extends BaseAction {
	
	private EpPayMoneyForm form;
	private EpPayMoney vo;
	private EpContract cvo;
	private String lyj;
	private String htj;
	private String bzj;
	private String ct_sno;
	public String getCt_sno() {
		return ct_sno;
	}


	public void setCt_sno(String ct_sno) {
		this.ct_sno = ct_sno;
	}


	private LogService log = (LogService)getBean("logService");
	private PayMoneyService service = (PayMoneyService)getBean("payMoneyService");
	private PackageService pService = (PackageService)getBean("packageService");
	private ContractService contractService = (ContractService)getBean("contractService");
	private String message;
	private List list;
	
	public String toDetail(){
		String bg_sno = this.request.getParameter("bg_sno");
		String ep_sno =this.request.getParameter("ep_sno");		
		if(vo == null){
			vo = new EpPayMoney();
			vo.setBG_SNO(bg_sno);
			vo.setEP_SNO(ep_sno);
			
		}
		list = this.service.getListDetailByPackage(ep_sno, bg_sno,null);		
		System.out.println(list.size());
		if(list != null && list.size()>=1){
			vo = (EpPayMoney) list.get(0);
		}
		return "detail";
	}
	
	
	public String pay() throws IOException{
		System.out.println("合同编号："+(this.cvo == null));
		UserInfo user = (UserInfo)this.session.get("userInfo");
		if(user == null)return ERROR;
		form.setBG_SNO(this.request.getParameter("bg_sno"));
	 	form.setEP_SNO(this.request.getParameter("ep_sno"));
		if(service.save(form)){			
			message = "添加成功";
			log.logInsert(user, "添加付款", "ep_contract");
		}
		else{
			message = "操作失败";
		}
		/*String path = request.getContextPath();
		String url = path+"/process!find";
		this.response.sendRedirect(url);*/
		return "addpayable";
	}
	
	public String receive() throws IOException{
		UserInfo user = (UserInfo)this.session.get("userInfo");
		if(user == null)return ERROR;
		form.setBG_SNO(this.request.getParameter("bg_sno"));
	 	form.setEP_SNO(this.request.getParameter("ep_sno"));
		if(service.save(form)){			
			message = "添加成功";
			log.logInsert(user, "添加收款", "ep_contract");			
		}
		else{
			message = "操作失败";
		}
		return "addreceivable";
	}
	
	public String commitProcess(){
		UserInfo user = (UserInfo)this.session.get("userInfo");
		EpProcessForm process=new EpProcessForm();
		process.setSS_SMAN(user.getEmp_sname());
		process.setSS_TDATE(new Date(System.currentTimeMillis()));
		//收款提交
		if(request.getParameter("payType").equals("0")){
			process.setSS_SREMARK("添加付款记录");
			pService.submitCurrentProcess(this.request, process);
			this.message = "操作成功";
			return "addreceivable";
		}
		//付款提交
		else{
			process.setSS_SREMARK("添加收款纪录");
			pService.submitCurrentProcess(this.request, process);
			this.message = "操作成功";
			return "addpayable";
		}
		
	}
	
	//计算合同金额
	private void calcHtj(int payCount,EpContract ctVo){
		BigDecimal ctMoney = ctVo.getCT_NMONEY();
		String payRadio = ctVo.getCT_NPAYRATIO();
		String[] ss = payRadio.split(":");
		int sum=0;
		for (String s : ss) {
			int t = Integer.valueOf(s);
			sum += t;
		}
		int current = Integer.valueOf(ss[payCount]);
		float result = (float)current/(float)sum;
		this.htj = ctMoney.multiply(BigDecimal.valueOf(result)).toString();
	}
	
	private void setMoney(EpContract ctVo){
		
		if(ctVo.getCT_SISLYJ().equals("1")){
			this.lyj = ctVo.getCT_NMONEY().multiply(ctVo.getCT_NLYJSUM().divide(BigDecimal.valueOf(100))).toString();
			//this.setLyj(lyj);
			System.out.println("履约金："+this.lyj.toString());
		}
		if(ctVo.getCT_SISZBJ().equals("1")){
			this.bzj = ctVo.getCT_NMONEY().multiply(ctVo.getCT_NZBJSUM().divide(BigDecimal.valueOf(100))).toString();
			System.out.println("保质金："+this.bzj.toString());
			//this.setLyj(bzj);
		}
	}
		
	//应付
	public String toAddpayable() {
		String ep_sno = this.request.getParameter("ep_sno");
		String bg_sno =this.request.getParameter("bg_sno");
		this.cvo=this.contractService.getDetailByPackage(ep_sno, bg_sno);
		this.ct_sno = cvo.getCT_SNO();
		list = this.service.getListDetailByPackage(ep_sno, bg_sno,"1");
		int payCount = list == null?0:list.size();
		this.calcHtj(payCount, cvo);
		this.setMoney(cvo);
		return "addpayable";
	}
	
	//应收
	public String toAddreceivable() {
		String ep_sno = this.request.getParameter("ep_sno");
		String bg_sno =this.request.getParameter("bg_sno");
		this.cvo=this.contractService.getDetailByPackage(ep_sno, bg_sno);
		this.ct_sno = cvo.getCT_SNO();
		list = this.service.getListDetailByPackage(ep_sno, bg_sno,"0");
		//list = this.service.getListDetailByPackage(ep_sno, bg_sno);
		this.setMoney(cvo);
		return "addreceivable";
	}
	
	
	
	

	public void setForm(EpPayMoneyForm form) {
		this.form = form;
	}


	public void setLog(LogService log) {
		this.log = log;
	}


	public void setService(PayMoneyService service) {
		this.service = service;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	public EpPayMoneyForm getForm() {
		return form;
	}


	public String getLyj() {
		return lyj;
	}


	public void setLyj(String lyj) {
		this.lyj = lyj;
	}


	public String getHtj() {
		return htj;
	}


	public void setHtj(String htj) {
		this.htj = htj;
	}


	public String getBzj() {
		return bzj;
	}


	public void setBzj(String bzj) {
		this.bzj = bzj;
	}
	
	public EpPayMoney getVo() {
		return vo;
	}


	public void setVo(EpPayMoney vo) {
		this.vo = vo;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public String getMessage() {
		return message;
	}
	
}
