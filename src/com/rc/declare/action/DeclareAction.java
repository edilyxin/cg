package com.rc.declare.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.rc.base.vo.MngUnitDepart;
import com.rc.declare.form.AbApproBudgetForm;
import com.rc.declare.form.AsAccessoryForm;
import com.rc.declare.form.BMXBudgetMXForm;
import com.rc.declare.form.DMFDivMoneyFForm;
import com.rc.declare.form.DMZDivMoneyZForm;
import com.rc.declare.form.FbFeasibilityForm;
import com.rc.declare.form.NiNoticeInfoForm;
import com.rc.declare.form.PgPerformanceGoalForm;
import com.rc.declare.form.RpReportForm;
import com.rc.declare.form.RpReportSonForm;
import com.rc.declare.form.SlSpecialistForm;
import com.rc.declare.form.UBUnitBudgetForm;
import com.rc.declare.service.DeclareService;
import com.rc.declare.vo.AbApproBudget;
import com.rc.declare.vo.AsAccessory;
import com.rc.declare.vo.BMXBudgetMX;
import com.rc.declare.vo.DMFDivMoneyF;
import com.rc.declare.vo.DMZDivMoneyZ;
import com.rc.declare.vo.FbFeasibility;
import com.rc.declare.vo.NiNoticeInfo;
import com.rc.declare.vo.PgPerformanceGoal;
import com.rc.declare.vo.RpReport;
import com.rc.declare.vo.RpReportSon;
import com.rc.declare.vo.SlSpecialist;
import com.rc.declare.vo.UBUnitBudget;
import com.rc.sys.service.LogService;
import com.rc.sys.service.SequenceService;
import com.rc.util.BaseAction;
import com.rc.util.UserInfo;
import com.rc.util.page.PageBean;
/**
 * 
 *  @Project       : CG
 *  @Program Name  : com.rc.declare.action.DeclareAction.java
 *  @Class Name    : DeclareAction
 *  @Description   : 项目申报
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-9上午11:31:54
 */
public class DeclareAction extends BaseAction {
	private DeclareService declareService = (DeclareService)getBean("declareService");
	private LogService log = (LogService)getBean("logService");
	private List list;//查询列表
	private String message;//操作信息
	private String sblx; 
	private String syear;
	private String speriod;
	private String msg;//操作信息1
	private PageBean bean;//分页标签类
	private NiNoticeInfoForm noticeForm;    //申报通知form
	private NiNoticeInfo notice;//申报通知vo
	private RpReportForm form;//项目申报form
	private RpReport vo;//项目申报vo
	private RpReportSonForm sonForm;//项目子表
	private RpReportSon sonVo;//项目子表
	private PgPerformanceGoalForm pgForm;//项目申请阶段性目标表
	private PgPerformanceGoal pg;//项目申请阶段性目标表
	private BMXBudgetMXForm bmxForm;//明细预算表
	private BMXBudgetMX bmx;//明细预算表
	private UBUnitBudgetForm ubForm;//联合评审预算表
	private UBUnitBudget ub;//联合评审预算表
	private AbApproBudgetForm abForm;//项目申请支出预算
	private AbApproBudget ab;//项目申请支出预算
	private FbFeasibilityForm fbForm;//项目可行性附表
	private DMZDivMoneyZForm dmzForm;
	private DMZDivMoneyZ dmz;
	private List rpList;
	private DMFDivMoneyFForm dmfForm;
	private DMFDivMoneyF dmf;//金额分配子表
	private FbFeasibility fb;//项目可行性附表
	private SlSpecialistForm slForm;//专家（人员）表
	private SlSpecialist sl;//专家（人员）表
	private AsAccessoryForm asForm;//附件表
	private AsAccessory as;//附件表
	private String bmx_ntotal = "";//
	private List udlist;//联系人单位，
	private List udlist1;//归口单位
	private MngUnitDepart ud;//部门
	private List sonList;//
	private List pgList;
	private List bmxList;
	private List ubList;
	private List abList;
	private List slList;
	private List asList;
	private Integer maxXuhao = 0;
	private Integer pgNum = 0;
	private Integer bmxNum = 0;
	private Integer ubNum = 0;
	private Integer abNum = 0;
	private Integer slNum = 0;
	private Integer asNum = 0;
	private Integer slNum1 = 0;//添加专家
	private String relativePath="apply";//申请附件上传相对路径
	private String manualFileName;//文件的名称
	private String maxXuhao1;//查看明细返回的地址
	/**
	 * 按条件查询并分页
	 * @return
	 * @throws Exception
	 */
	public String findNotice() throws Exception{
		//判断form表单是否为空
		if(noticeForm==null){
			noticeForm = new NiNoticeInfoForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(declareService.noticeFindSize(noticeForm),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		noticeForm.setPageSQLA(bean.getPageSQLA());
		noticeForm.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.noticeFindList(noticeForm);
		for(int i = 0 ; i < list.size() ; i++){
			NiNoticeInfo ni = (NiNoticeInfo) list.get(i);
			String moneycome = "";
			if(ni.getNi_smoneycome() != null && !"".equals(ni.getNi_smoneycome())){
				if(ni.getNi_smoneycome().indexOf("0")!=-1){
					moneycome += "财政专项";
				}
				if(ni.getNi_smoneycome().indexOf("1")!=-1){
					moneycome += "财政追加专项 ";
				}
				if(ni.getNi_smoneycome().indexOf("2")!=-1){
					moneycome += " 中央财政支撑地方高校发展专项资金 ";
				}
				((NiNoticeInfo) list.get(i)).setNi_smoneycome(moneycome);
			}
			//System.out.println(moneycome+"11111111");
		}
		return "findNotice";
	}
	/**
	 * 
	 *  @Description    : class 类
	 *  @Method_Name    : noticeFindList
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : List
	 */
	public String classFindList(){
		list = declareService.classFindList();
		return "classFindList";
	}

	/**
	 * 跳转新增页
	 * @return
	 * @throws Exception
	 */
	public String noticeToAdd() throws Exception{
		return "noticeToAdd";
	}

	/**
	 * 新增页保存
	 * @return
	 * @throws Exception
	 */
	public String noticeAdd() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(noticeForm==null){
			noticeForm = new NiNoticeInfoForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "ni_sid");
		noticeForm.setNi_sid(no);
		noticeForm.setNi_sreplyby(userInfo.getUsername());
		boolean bl = declareService.noticeAdd(noticeForm);
		if(bl){
			message = "新增成功!";
			log.logInsert(userInfo, "新增通知信息表信息", "NI_NoticeInfo");
		}else{
			message = "新增失败!";
		}
		noticeForm = null;
		return findNotice();
	}
	/**
	 * 跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdateNotice() throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		if(noticeForm==null){
			noticeForm = new NiNoticeInfoForm();
		}
		if(idchecked!=null&&idchecked.length==1){
			noticeForm.setNi_sid(idchecked[0]);
			notice = (NiNoticeInfo) declareService.noticeFindList(noticeForm).get(0);
		}
		return "toUpdateNotice";
	}
	/**
	 * 显示通知
	 * @return
	 * @throws Exception
	 */
	public String shwoNotice() throws Exception{
		if(noticeForm==null){
			noticeForm = new NiNoticeInfoForm();
		}
		noticeForm.setSearchA("1");
		if(declareService.noticeFindList(noticeForm).size()>0){
			notice = (NiNoticeInfo) declareService.noticeFindList(noticeForm).get(0);
		}
		return "shwoNotice";
	}
	/**
	 * 修改保存
	 * @return
	 * @throws Exception
	 */
	public String noticeUpdate() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		noticeForm.setNi_salterby(userInfo.getUsername());
		boolean bl = declareService.noticeUpdate(noticeForm);
		if(bl){
			message = "修改成功!";
			log.logInsert(userInfo, "修改通知信息表信息", "NI_NoticeInfo");
		}else{
			message = "修改失败!";
		}
		noticeForm = null;
		return findNotice();
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String noticeDelete() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = declareService.noticeDelete(idchecked);
		if(bl){
			message = "删除成功!";
			log.logInsert(userInfo, "删除通知信息表信息", "NI_NoticeInfo");
		}else{
			message = "删除失败!";
		}
		return findNotice();
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String noticeIssue() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = declareService.noticeIssue(idchecked);
		if(bl){
			message = "发布成功!";
			log.logInsert(userInfo, "删除通知信息表信息", "NI_NoticeInfo");
		}else{
			message = "发布失败!";
		}
		return findNotice();
	}
	/**
	 * 项目申报查询列表
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		return "find";
		
	}
	//申报初审
	public String findTrial() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
	 	//System.out.println("//初始化分页标签");
	 	form.setSearchD("2");//定义状态为申报提交状态
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		return "findTrial";
	}
	//归口单位审核
	public String findGkdwsh() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
	 	//System.out.println(userInfo.getUd_sno()+"==userInfo.getUd_sno()");
	 	form.setSearchD("3");//定义状态为申报提交状态
	 	//System.out.println("//初始化分页标签");
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		udlist1 = declareService.findUd("2", "1");
		return "findGkdwsh";
	}
	/**
	 * 
	 *  @Description    : 修改初审
	 *  @Method_Name    : toUpdateTrial
	 *  @return
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String toUpdateTrial()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
			form.setRp_sid(form.getRp_sid());
			vo =  (RpReport) declareService.rpFindList(form).get(0);
			//申报子表list
			//附件表
			asForm = new AsAccessoryForm();
			asForm.setEp_sid(vo.getRp_sprojectno());
			asList = declareService.asFindList(asForm);
			//专家（人员）表
			slForm = new SlSpecialistForm();
			slForm.setRp_sprojectno(vo.getRp_sprojectno());
			slList = declareService.slFindList(slForm);
			//项目可行性附表
			//项目申请支出预算
			abForm = new AbApproBudgetForm();
			abForm.setRp_sprojectno(vo.getRp_sprojectno());
			abList = declareService.abFindList(abForm);
			//联合评审预算表
			ubForm = new UBUnitBudgetForm();
			ubForm.setRp_sprojectno(vo.getRp_sprojectno());
			ubList = declareService.ubFindList(ubForm);
			maxXuhao = declareService.ubFindSize(ubForm);
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
			//项目申请阶段性目标表
			pgForm = new PgPerformanceGoalForm();
			pgForm.setRp_sprojectno(vo.getRp_sprojectno());
			pgList = declareService.pgFindList(pgForm);
			System.out.println(pgList.size()+"=pgList.size()");
			return "toUpdateTrial";
	}
	/**
	 *  @Description    : 初审提交的时候重新设置一下归口单位
	 *  @Method_Name    : toSetGkdw
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String toSetGkdw()throws Exception{
		udlist1 = declareService.findUd("2", "1");
		return "toSetGkdw";
	}
	/**
	 *  @Description    : 归口单位审核
	 *  @Method_Name    : toUpdateGkdwsh
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String toUpdateGkdwsh()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//项目单位基本信息
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
			form.setRp_sid(form.getRp_sid());
			vo =  (RpReport) declareService.rpFindList(form).get(0);
			//申报子表list
			//附件表
			asForm = new AsAccessoryForm();
			asForm.setEp_sid(vo.getRp_sprojectno());
			asList = declareService.asFindList(asForm);
			//专家（人员）表
			slForm = new SlSpecialistForm();
			slForm.setRp_sprojectno(vo.getRp_sprojectno());
			slList = declareService.slFindList(slForm);
			//项目可行性附表
			//项目申请支出预算
			abForm = new AbApproBudgetForm();
			abForm.setRp_sprojectno(vo.getRp_sprojectno());
			abList = declareService.abFindList(abForm);
			//联合评审预算表
			ubForm = new UBUnitBudgetForm();
			ubForm.setRp_sprojectno(vo.getRp_sprojectno());
			ubList = declareService.ubFindList(ubForm);
			maxXuhao = declareService.ubFindSize(ubForm);
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
			//项目申请阶段性目标表
			pgForm = new PgPerformanceGoalForm();
			pgForm.setRp_sprojectno(vo.getRp_sprojectno());
			pgList = declareService.pgFindList(pgForm);
			System.out.println(pgList.size()+"=pgList.size()");
			return "toUpdateGkdwsh";
	}
	/**
	 *  @Description    : 归口单位审核
	 *  @Method_Name    : toUpdateGkdwsh
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String toUpdateGkdwsh1()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
		form.setRp_sid(form.getRp_sid());
		vo =  (RpReport) declareService.rpFindList(form).get(0);
		return "toUpdateGkdwsh1";
	}
	/**
	 * 修改项目申报初审保存
	 * @return
	 * @throws Exception
	 */
	public String updateGkdwsh() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		form.setRp_salterby(userInfo.getUsername());
		boolean bl = declareService.rpUpdateGkdwsh(form);
		String str = "";
		String url = "";
		if("3".equals(form.getRp_sstatus())){
			request.setAttribute("form.rp_sid", form.getRp_sid());
			str = "保存";
			url = toUpdateGkdwsh1();
		}else{
			str = "提交";
			url = findGkdwsh();
		}
		if(bl){
			message = str+"成功!";
			log.logInsert(userInfo, "新增通知信息表信息", "NI_NoticeInfo");
		}else{
			message = str+"失败!";
		}
		return url;
	}
	/**
	 *  @Description    : 退回
	 *  @Method_Name    : backspace
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String backspace()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean bl = declareService.rpUpdateGkdwsh(form);
		System.out.println(bl+"==bl");
		ActionContext.getContext().getValueStack().set("bl", bl);
		return "backspace";
	}
	/**
	 * 修改项目申报初审保存
	 * @return
	 * @throws Exception
	 */
	public String updateTrial() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		form.setRp_salterby(userInfo.getUsername());
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		form.setRp_sreplyby(userInfo.getUsername());
		String pg_sid = "";//项目申请阶段性目标表主键
		String bmx_sid = "";//明细预算表主键
		String ub_sid = "";//联合评审预算表主键
		String ab_sid = "";//项目申请支出预算主键
		String sl_sid = "";//专家（人员）表主键
		String as_sid = "";//附件表主键
		String sl_sid1 = "";
		if(pgNum == 1){
			if(form.getPg_sphase() != "" && form.getPg_sphase() != null){
				String[] pg_sPhase = form.getPg_sphase().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						pg_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "pg_sid");
					}else{
						pg_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "pg_sid")+",";
					}
				}
				form.setPg_sid(pg_sid);
			}
		}
		if(ubNum == 1){
			if(form.getUb_nplanname() != "" && form.getUb_nplanname() != null){
				String[] pg_sPhase = form.getUb_nplanname().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid");
					}else{
						ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid")+",";
					}
				}
				form.setUb_sid(ub_sid);
			}
		}
		
		//定义是否有关联
		if(bmxNum == 1){
			if(form.getBmx_ssort() != "" && form.getBmx_ssort() != null){
				String[] pg_sPhase = form.getBmx_ssort().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid");
					}else{
						bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid")+",";
					}
				}
				form.setBmx_sid(bmx_sid);
			}
		}
		if(abNum == 1){
			if(form.getAb_sitems() != "" && form.getAb_sitems() != null){
				String[] pg_sPhase = form.getAb_sitems().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid");
					}else{
						ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid")+",";
					}
				}
				form.setAb_sid(ab_sid);
			}
		}
		
		if(slNum == 1){//项目参加人员列表
				if(form.getSl_sname() != "" && form.getSl_sname() != null){
					String[] pg_sPhase = form.getSl_stype().split(",");
					for(int i = 0 ; i < pg_sPhase.length ; i++){
						if("0".equals(pg_sPhase[i].trim())){
							if(i+1 == pg_sPhase.length){
								sl_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid");
							}else{
								sl_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid")+",";
							}
						}
					}
					System.out.println(sl_sid+"====sl_sid");
					form.setSl_sid(sl_sid);
				}
		}
		if(slNum1 == 1){//项目专家列表
			if(form.getSl_stype1() != "" && form.getSl_stype1() != null){
				System.out.println(form.getSl_stype1()+"===form.getSl_stype()");
				String[] pg_sPhase = form.getSl_stype1().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
						if(i+1 == pg_sPhase.length){
							sl_sid1  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid");
						}else{
							sl_sid1  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid")+",";
						}
				}
			//System.out.println(sl_sid1+"====sl_sid1");
			form.setSl_sid1(sl_sid1);
		  }
	}
		if(asNum == 1){
			if(form.getAs_sname() != "" && form.getAs_sname() != null){
				String[] pg_sPhase = form.getAs_sname().split(",");
				String as_surl = "";
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid");
						as_surl += getManualPath(form.getMyFile()[i], pg_sPhase[i]);
					}else{
						as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
						as_surl += getManualPath(form.getMyFile()[i], pg_sPhase[i])+",";
					}
				}
				form.setAs_sid(as_sid);
				form.setAs_surl(as_surl);				
			}
		}
		boolean bl = declareService.rpUpdate1(form);
		if(bl){
			message = "申报初审成功!";
			log.logInsert(userInfo, "申报初审", "rp_report");
		}else{
			message = "申报初审失败!";
			if(form.getAs_surl() != null && !"".equals(form.getAs_surl())){
				String[] url = form.getAs_surl().split(",");
				for(int j = 0 ; j < url.length - 1 ; j++){
					String realPath = ServletActionContext.getServletContext().getRealPath(relativePath) + "\\" + url[j];
					File manual = new File(realPath);
					manual.delete();
				}
			}
		}
		String myUrl = "";
		if(form.getRp_sstatus() == "2" || "2".equals(form.getRp_sstatus())){
			myUrl = toUpdateTrial();
		}else{
			form = null;
			myUrl = findTrial();
		}
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		return myUrl;
		//return save();
	}
	/**
	 * 项目申报新增跳转页面
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception{
		//联系人，负责人所属单位
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
		return "toAdd";
	}

	/**
	 * 项目申报新增保存
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(form==null){
			form = new RpReportForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		String no = sequenceService.getNO(userInfo.getSysint_sno(), "0", "rp_sid");
		form.setRp_sid(no);//定义申报主表主键
		String rp_sprojectno = sequenceService.getNO(userInfo.getSysint_sno(), "1", "rp_sprojectno");
		form.setRp_sprojectno(rp_sprojectno);//设置项目主键
		form.setRp_sreplyby(userInfo.getUsername());
		String pg_sid = "";//项目申请阶段性目标表主键
		String bmx_sid = "";//明细预算表主键
		String ub_sid = "";//联合评审预算表主键
		String ab_sid = "";//项目申请支出预算主键
		String sl_sid = "";//专家（人员）表主键
		String as_sid = "";//附件表主键
		if(form.getPg_sphase() != "" && form.getPg_sphase() != null){
			String[] pg_sPhase = form.getPg_sphase().split(",");
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				pg_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "pg_sid")+",";
			}
			pg_sid = pg_sid.substring(0, pg_sid.length() - 1);//去掉最后一个逗号
			form.setPg_sid(pg_sid);
		}
		if(form.getUb_nplanname() != "" && form.getUb_nplanname() != null){
			String[] pg_sPhase = form.getUb_nplanname().split(",");
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid")+",";
			}
			ub_sid = ub_sid.substring(0, ub_sid.length() - 1);//去掉最后一个逗号
			form.setUb_sid(ub_sid);
		}
		//定义是否有关联
		if(form.getBmx_ssort() != "" && form.getBmx_ssort() != null){
			String[] pg_sPhase = form.getBmx_ssort().split(",");
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid")+",";
			}
			bmx_sid = bmx_sid.substring(0, bmx_sid.length() - 1);//去掉最后一个逗号
			form.setBmx_sid(bmx_sid);
		}
		if(form.getAb_sitems() != "" && form.getAb_sitems() != null){
			String[] pg_sPhase = form.getAb_sitems().split(",");
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid")+",";
			}
			ab_sid = ab_sid.substring(0, ab_sid.length() - 1);//去掉最后一个逗号
			form.setAb_sid(ab_sid);
		}
		if(form.getSl_sname() != "" && form.getSl_sname() != null){
			String[] pg_sPhase = form.getSl_sname().split(",");
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				sl_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid")+",";
			}
			sl_sid = sl_sid.substring(0, sl_sid.length() - 1);//去掉最后一个逗号
			form.setSl_sid(sl_sid);
		}
		if(form.getAs_sname() != "" && form.getAs_sname() != null){
			String[] pg_sPhase = form.getAs_sname().split(",");
			String as_surl = "";
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				/*if(i+1 == pg_sPhase.length){
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid");
					as_surl += getManualPath(form.getMyFile()[i], pg_sPhase[i]);
				}else{*/
				as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
				as_surl += getManualPath(form.getMyFile()[i], pg_sPhase[i])+",";
			}
			as_sid = as_sid.substring(0, as_sid.length() - 1);//去掉最后一个逗号
			as_surl = as_surl.substring(0, as_surl.length() - 1);//去掉最后一个逗号
			form.setAs_sid(as_sid);
			form.setAs_surl(as_surl);				
		}
		boolean bl = declareService.rpAdd(form);
		if(bl){
			message = "操作成功!";
			log.logInsert(userInfo, "新增申报表", "rp_report");
		}else{
			message = "操作失败!";
			if(form.getAs_surl() != null && !"".equals(form.getAs_surl())){
				String[] url = form.getAs_surl().split(",");
				for(int j = 0 ; j < url.length - 1 ; j++){
					String realPath = ServletActionContext.getServletContext().getRealPath(relativePath) + "\\" + url[j];
					File manual = new File(realPath);
					manual.delete();
				}
			}
		}
		return toUpdate();
	}
	/**
	 * 把附件存放到服务器上，并返回其跟路径下的相对路径
	 * @param file
	 * @param fileName 
	 * @return
	 */
	private String getManualPath(File file, String fileName) {
		String realPath = ServletActionContext.getServletContext().getRealPath(relativePath);
		System.out.println(realPath+"===realPath");
		String result = null;
		String name = null;
		if (file != null) {
			StringBuilder sb = new StringBuilder(fileName);
			sb.insert(fileName.lastIndexOf('.'), "_" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
			name = sb.toString();
			result = realPath + "\\" + name;
			File dir = new File(realPath);
			//如果存放设备操作手册的目录不存在，则创建
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File dest = new File(result);
			//从缓存中获取文件，到工程uploadedManual目录下
			boolean bl = copy(file, dest);
			if (!bl) {
				name = null;
			}
		}
		return name;
	}
	/**
	 * 拷贝文件
	 * @param file
	 * @param dest
	 * @return 
	 */
	private boolean copy(File file, File dest) {
		FileInputStream in = null;
		FileOutputStream out = null;
		boolean bl = false;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(dest);
			FileChannel fin = in.getChannel();
			FileChannel fout = out.getChannel();
			long size = fin.size();
			long actual = fin.transferTo(0, size, fout);
			fin.close();
			fout.close();
			if (size == actual) {
				bl = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bl;
	}
	/**
	 * 项目申报修改跳转修改页
	 * @return
	 * @throws Exception
	 */
	
	public String toUpdate() throws Exception{
		//String[] idchecked = request.getParameterValues("idcheckbox");
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
		form.setRp_sid(form.getRp_sid());
		List rpList = declareService.rpFindList(form);
		if(rpList != null && rpList.size() > 0){
			vo =  (RpReport) rpList.get(0);
			//申报子表list
			//附件表
			asForm = new AsAccessoryForm();
			asForm.setEp_sid(vo.getRp_sprojectno());
			asList = declareService.asFindList(asForm);
			//专家（人员）表
			slForm = new SlSpecialistForm();
			slForm.setRp_sprojectno(vo.getRp_sprojectno());
			slList = declareService.slFindList(slForm);
			//项目可行性附表
			//项目申请支出预算
			abForm = new AbApproBudgetForm();
			abForm.setRp_sprojectno(vo.getRp_sprojectno());
			abList = declareService.abFindList(abForm);
			//联合评审预算表
			ubForm = new UBUnitBudgetForm();
			ubForm.setRp_sprojectno(vo.getRp_sprojectno());
			ubList = declareService.ubFindList(ubForm);
			maxXuhao = declareService.ubFindSize(ubForm);
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
			//项目申请阶段性目标表
			pgForm = new PgPerformanceGoalForm();
			pgForm.setRp_sprojectno(vo.getRp_sprojectno());
			pgList = declareService.pgFindList(pgForm);
		}
			
		return "toAdd";
	}
	/**
	 * 修改项目申报保存
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		form.setRp_salterby(userInfo.getUsername());
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		form.setRp_sreplyby(userInfo.getUsername());
		String pg_sid = "";//项目申请阶段性目标表主键
		String bmx_sid = "";//明细预算表主键
		String ub_sid = "";//联合评审预算表主键
		String ab_sid = "";//项目申请支出预算主键
		String sl_sid = "";//专家（人员）表主键
		String as_sid = "";//附件表主键
		if(pgNum == 1){
			if(form.getPg_sphase() != "" && form.getPg_sphase() != null){
				String[] pg_sPhase = form.getPg_sphase().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					pg_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "pg_sid")+",";
				}
				pg_sid = pg_sid.substring(0, pg_sid.length() - 1);
				form.setPg_sid(pg_sid);
			}
		}
		if(ubNum == 1){
			if(form.getUb_nplanname() != "" && form.getUb_nplanname() != null){
				String[] pg_sPhase = form.getUb_nplanname().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid")+",";
				}
				ub_sid = ub_sid.substring(0, ub_sid.length() - 1);
				form.setUb_sid(ub_sid);
			}
		}
		
		//定义是否有关联
		if(bmxNum == 1){
			if(form.getBmx_ssort() != "" && form.getBmx_ssort() != null){
				String[] pg_sPhase = form.getBmx_ssort().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid")+",";
				}
				bmx_sid = bmx_sid.substring(0, bmx_sid.length() - 1);
				form.setBmx_sid(bmx_sid);
			}
		}
		if(abNum == 1){
			if(form.getAb_sitems() != "" && form.getAb_sitems() != null){
				String[] pg_sPhase = form.getAb_sitems().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid")+",";
				}
				ab_sid = ab_sid.substring(0, ab_sid.length() - 1);
				form.setAb_sid(ab_sid);
			}
		}
		if(slNum == 1){
			if(form.getSl_sname() != "" && form.getSl_sname() != null){
				String[] pg_sPhase = form.getSl_sname().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					sl_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "sl_sid")+",";
				}
				sl_sid = sl_sid.substring(0, sl_sid.length() - 1);
				form.setSl_sid(sl_sid);
			}
		}
		if(asNum == 1){
			if(form.getAs_sname() != "" && form.getAs_sname() != null){
				String[] pg_sPhase = form.getAs_sname().split(",");
				String as_surl = "";
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
					as_surl += getManualPath(form.getMyFile()[i], pg_sPhase[i])+",";
				}
				as_sid = as_sid.substring(0, as_sid.length() - 1);
				as_surl = as_surl.substring(0, as_surl.length() - 1);
				form.setAs_sid(as_sid);
				form.setAs_surl(as_surl);				
			}
		}
		boolean bl = declareService.rpUpdate(form);
		if(bl){
			message = "操作成功!";
			log.logInsert(userInfo, "修改申报表", "rp_report");
		}else{
			message = "操作失败!";
/*			if(form.getAs_surl() != null && !"".equals(form.getAs_surl())){
				String[] url = form.getAs_surl().split(",");
				for(int j = 0 ; j < url.length - 1 ; j++){
					String realPath = ServletActionContext.getServletContext().getRealPath(relativePath) + "\\" + url[j];
					File manual = new File(realPath);
					manual.delete();
				}
			}*/
		}
		if(form.getRp_sstatus() == "0" || "0".equals(form.getRp_sstatus())){
			return  toUpdate();
		}else{
			form = null;
			return find();
		}
	}
	/**
	 * 删除项目申报表信息
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
		boolean bl = declareService.rpDelete(idchecked);
		if(bl){
			message = "删除成功!";
			log.logInsert(userInfo, "删除项目申报表信息", "rp_report");
		}else{
			message = "删除失败!";
		}
		return find();
	} 
	/**
	 * 删除项目申报表信息
	 * @return
	 * @throws Exception
	 */
	public String updateState() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = declareService.noticeIssue(idchecked);
		if(bl){
			//message = "发布成功!";
			log.logInsert(userInfo, "修改项目申报表状态", "rp_report");
		}else{
			//message = "发布失败!";
		}
		return find();
	}
	/**
	 * 项目子表列表
	 * @return
	 * @throws Exception
	 */
	public String findSon() throws Exception{
		//判断form表单是否为空
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		list = declareService.rpSonFindList(sonForm);
		sonList = declareService.rpSonFindBT(sonForm);
		//sonVo = (RpReportSon) list.get(0);
		return "findSon";
	}
	/**
	 * 项目子表列表，没有新增修改的功能
	 * @return
	 * @throws Exception
	 */
	public String findSon1() throws Exception{
		//判断form表单是否为空
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
		list = declareService.rpSonFindList(sonForm);
		sonList = declareService.rpSonFindBT(sonForm);
		//sonVo = (RpReportSon) list.get(0);
		return "findSon1";
	}
	/**
	 * 项目子表新增跳转页面
	 * @return
	 * @throws Exception
	 */
	public String toAddSon() throws Exception{
		return "toAddSon";
	}

	/**
	 * 项目子表新增表头保存
	 * @return
	 * @throws Exception
	 */
	public String addSonBT() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		sonForm.setRpson_sreplyby(userInfo.getUsername());
		boolean bl = declareService.rpSonAddBT(sonForm);
		if(bl){
			message = "操作成功!";
			log.logInsert(userInfo, "新增项目子表", "rp_ReportSon");
		}else{
			message = "操作失败!";
		}
		//sonForm = null;
		return "toAddSonBT";
	}
	/**
	 * 项目子表新增表头保存
	 * @return
	 * @throws Exception
	 */
	public String addSon() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		sonForm.setRpson_sreplyby(userInfo.getUsername());
		boolean bl = declareService.rpSonAdd(sonForm);
		if(bl){
			message = "操作成功!";
			log.logInsert(userInfo, "新增项目子表", "rp_ReportSon");
		}else{
			message = "操作失败!";
		}
		//sonForm = null;
		return null;
	}
	/**
	 * 项目子表修改表头页面跳转
	 * @return
	 * @throws Exception
	 */
	public String toUpdateSonBT() throws Exception{
		sonVo = (RpReportSon) declareService.rpSonFindList(sonForm).get(0);
		return "toUpdateSonBT";
	}
	/**
	 * 项目子表修改表头保存
	 * @return
	 * @throws Exception
	 */
	public String updateSonBT() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		sonForm.setRpson_sreplyby(userInfo.getUsername());
		boolean bl = declareService.rpSonUpdateBT(sonForm);
		if(bl){
			message = "新增成功!";
			log.logInsert(userInfo, "新增项目子表", "rp_ReportSon");
		}else{
			message = "新增失败!";
		}
		//sonForm = null;
		return null;
	}
	/**
	 * 项目子表修改表头保存
	 * @return
	 * @throws Exception
	 */
	public String deleteSonBT() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		sonForm.setRpson_sreplyby(userInfo.getUsername());
		boolean bl = declareService.rpSonDeleteBT(sonForm);
		if(bl){
			message = "新增成功!";
			log.logInsert(userInfo, "新增项目子表", "rp_ReportSon");
		}else{
			message = "新增失败!";
		}
		//sonForm = null;
		return null;
	}
	/**
	 * 项目子表修改跳转修改页
	 * @return
	 * @throws Exception
	 */
	public String toUpdateSon() throws Exception{
		if(sonForm==null){
			sonForm = new RpReportSonForm();
		}
		sonVo =  (RpReportSon) declareService.rpSonFindList(sonForm).get(0);
		return "toUpdateSon";
	}
	/**
	 * 修改项目子表
	 * @return
	 * @throws Exception
	 */
	public String updateSon() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		sonForm.setRpson_salterby(userInfo.getUsername());
		boolean bl = declareService.rpSonUpdate(sonForm);
		if(bl){
			message = "修改成功!";
			log.logInsert(userInfo, "修改项目子表", "rp_ReportSon");
		}else{
			message = "修改失败!";
		}
		return null;
	}
	/**
	 * 删除项目子表信息
	 * @return
	 * @throws Exception
	 */
	public String toDeleteSon() throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		boolean bl = declareService.rpSonDelete(sonForm.getRpson_nid());
		if(bl){
			message = "删除成功!";
			log.logInsert(userInfo, "删除项目子表", "rp_ReportSon");
		}else{
			message = "删除失败!";
		}
		return null;
	}
	/**
	 *  @Description    : 根据项目编号和类型查询附件表数据
	 *  @Method_Name    : findManual
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findManual()throws Exception{
		asList = declareService.asFindList(asForm);
		return "findManual";
	}
	/**
	 *  @Description    : 新增附件表信息
	 *  @Method_Name    : addManual
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String addManual()throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(asForm == null){
			asForm = new AsAccessoryForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		asForm.setAs_sreplyby(userInfo.getUsername());
		if(asForm.getAs_sname() != "" && asForm.getAs_sname() != null){
			String[] pg_sPhase = asForm.getAs_sname().split(",");
			String as_surl = "";
			String as_sid = "";
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				if(i+1 == pg_sPhase.length){
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid");
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i]);
				}else{
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i])+",";
				}
			}
			asForm.setAs_sid(as_sid);
			asForm.setAs_surl(as_surl);				
		}
		boolean bl = declareService.asAdd(asForm);
		if(bl){
			message = "上传成功!";
			log.logInsert(userInfo, "上传附件", "rp_report");
		}else{
			message = "上传失败!";
		}
		asForm.setAs_sid("");
		return findManual();
	}
	/**
	 *  @Description    : 根据项目编号和类型查询附件表数据，学校项目库信息
	 *  @Method_Name    : findManual
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findManualSchool()throws Exception{
		if(asForm == null){
			asForm = new AsAccessoryForm();
		}
		asList = declareService.asFindList(asForm);
		return "findManualSchool";
	}
	/**
	 *  @Description    : 新增附件表信息
	 *  @Method_Name    : addManual
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String addManualSchool()throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(asForm == null){
			asForm = new AsAccessoryForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		asForm.setAs_sreplyby(userInfo.getUsername());
		if(asForm.getAs_sname() != "" && asForm.getAs_sname() != null){
			String[] pg_sPhase = asForm.getAs_sname().split(",");
			String as_surl = "";
			String as_sid = "";
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				if(i+1 == pg_sPhase.length){
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid");
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i]);
				}else{
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i])+",";
				}
			}
			asForm.setAs_sid(as_sid);
			asForm.setAs_surl(as_surl);				
		}
		boolean bl = declareService.asAdd(asForm);
		if(bl){
			message = "上传成功!";
			log.logInsert(userInfo, "上传附件", "rp_report");
		}else{
			message = "上传失败!";
		}
		asForm.setAs_sid("");
		return findManualSchool();
	}
	/**
	 * 删除附件
	 * @return
	 * @throws Exception
	 */
	public String delManual() throws Exception {
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		String realPath = ServletActionContext.getServletContext().getRealPath(relativePath) + "\\" + form.getAs_surl();
		File manual = new File(realPath);
		boolean bl = false;
		if (manual.delete()) {//附件删除是否成功
			//删除附件信息
			boolean isSuccess = declareService.asDeleteByno(form.getAs_sid());
			if (isSuccess) {
				bl = true;
			}
		}
		ActionContext.getContext().getValueStack().set("bl", bl);
		return "delManual";
	}
	/**
	 *  @Description    : 根据项目编号和类型查询附件表数据，支撑材料
	 *  @Method_Name    : findManual
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findManualSupporter()throws Exception{
		if(asForm == null){
			asForm = new AsAccessoryForm();
		}
		asList = declareService.asFindList(asForm);
		return "findManualSupporter";
	}
	/**
	 * 下载操作手册
	 * @return
	 * @throws Exception
	 */
	public String downloadManual() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(relativePath) + "\\" + manualFileName;
		System.out.println("realPath = " + realPath);
		response.reset();
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\"" +URLEncoder.encode(manualFileName, "UTF-8") + "\"");
		FileInputStream in = null;
		ServletOutputStream out = null;
		try {
			in = new FileInputStream(realPath);
			out = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 *  @Description    : 项目库归口单位
	 *  @Method_Name    : findProjectGkdw
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findProjectGkdw()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	if(userInfo.getUd_sno() != null && !"".equals(userInfo.getUd_sno())){
	 		form.setSearchF(userInfo.getUd_sno().trim());
	 	}
	 	System.out.println(userInfo.getUd_sno()+"==userInfo.getUd_sno()");
	 	//初始化分页标签
	 	form.setSearchE("1");//设置只能查询到状态为：4归口单位审核,5.校领导小组审核的信息
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		udlist1 = declareService.findUd("2", "1");
		return "findProjectGkdw";
	}
	/**
	 *  @Description    : 项目库学校
	 *  @Method_Name    : findProjectGkdw
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findProjectSchool()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
	 	form.setSearchE("1");//设置只能查询到状态为：4归口单位审核,5.校领导小组审核的信息
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		udlist1 = declareService.findUd("2", "1");
		return "findProjectSchool";
	}
	/**
	 *  @Description    : 支撑材料-查询上传的所有跟项目的所有的支撑材料
	 *  @Method_Name    : findDealSupporter
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findDealSupporter()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		return "findDealSupporter";
	}
	/**
	 *  @Description    : 支撑材料-上传支撑材料
	 *  @Method_Name    : addManualSupporter
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String addManualSupporter()throws Exception{
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(asForm == null){
			asForm = new AsAccessoryForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		asForm.setAs_sreplyby(userInfo.getUsername());
		if(asForm.getAs_sname() != "" && asForm.getAs_sname() != null){
			String[] pg_sPhase = asForm.getAs_sname().split(",");
			String as_surl = "";
			String as_sid = "";
			for(int i = 0 ; i < pg_sPhase.length ; i++){
				if(i+1 == pg_sPhase.length){
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid");
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i]);
				}else{
					as_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "as_sid")+",";
					as_surl += getManualPath(asForm.getMyFile()[i], pg_sPhase[i])+",";
				}
			}
			asForm.setAs_sid(as_sid);
			asForm.setAs_surl(as_surl);				
		}
		boolean bl = declareService.asAdd(asForm);
		if(bl){
			message = "上传成功!";
			log.logInsert(userInfo, "上传附件", "rp_report");
		}else{
			message = "上传失败!";
		}
		asForm.setAs_sid("");
		return findManualSupporter();
	}
	/**
	 *  @Description    : 项目库-归口单位排序保存
	 *  @Method_Name    : saveGkRank
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String saveGkRank()throws Exception{
		if(form == null){
			form = new RpReportForm();
		}
		boolean bl = declareService.saveGkRank(form.getRp_sid(), form.getRp_ndef1());
		if(bl){
			message = "排序保存成功!";
		}else{
			message = "排序保存失败!";
		}
		form.setRp_sid("");
		return findProjectGkdw();
	}
	/**
	 *  @Description    : 项目库-学校排序保存
	 *  @Method_Name    : saveSchoolRank
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String saveSchoolRank()throws Exception{
		if(form == null){
			form = new RpReportForm();
		}
		boolean bl = declareService.saveSchoolRank(form.getRp_sid(), form.getRp_sdef15());
		if(bl){
			message = "排序保存成功!";
		}else{
			message = "排序保存失败!";
		}
		form.setRp_sid("");
		return findProjectSchool();
	}
	/**
	 *  @Description    : 查询金额分配主表
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmzFind()throws Exception{
		list = declareService.dmzFind(dmzForm);
		return "dmzFind";
	}
	/**
	 *  @Description    : 新增金额分配主表
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmzInsert()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(dmzForm == null){
			dmzForm = new DMZDivMoneyZForm();
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		String dmz_sid = sequenceService.getNO(userInfo.getSysint_sno(), "0", "dmz_sid");
		dmzForm.setDmz_sid(dmz_sid);//主键
		dmzForm.setDmz_stype("1");//分配类型
		dmzForm.setDmz_snodiv("0");//已分配
		//未分配
		dmzForm.setDmz_sdiving(dmzForm.getDmz_ndef1());
		dmzForm.setDmz_sreplyby(userInfo.getUsername());
		boolean bl = declareService.dmzInsert(dmzForm);
		if(bl){
			message = "新增金额分配主表成功!";
		}else{
			message = "新增金额分配主表失败!";
		}
		return allotMoneyGkdw();//dmzFind();
	}
	/**
	 *  @Description    : 查询金额分配主表
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmzUpdate()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(dmzForm == null){
			dmzForm = new DMZDivMoneyZForm();
		}
		dmzForm.setDmz_stype("1");//分配类型
		String dmx_ndef1 = "";
		if(dmzForm.getDmz_ndef1() == null || "".equals(dmzForm.getDmz_ndef1())){
			dmx_ndef1 = 0+"";
		}else{
			dmx_ndef1 = dmzForm.getDmz_ndef1(); 	
		}
		String dmz_snodiv = "";
		if(dmzForm.getDmz_snodiv() == null || "".equals(dmzForm.getDmz_snodiv())){
			dmz_snodiv = 0+"";
		}else{
			dmz_snodiv = dmzForm.getDmz_snodiv();
		}
		Double dmz_sdiving = (Double.parseDouble(dmx_ndef1) - Double.parseDouble(dmz_snodiv));
		dmzForm.setDmz_sdiving(dmz_sdiving.toString());
		dmzForm.setDmz_sreplyby(userInfo.getUsername());
		 boolean bl = declareService.dmzUpdate(dmzForm);
		 if(bl){
				message = "修改金额分配主表成功!";
			}else{
				message = "修改金额分配主表失败!";
			}
		 return allotMoneyGkdw();//dmzFind();
	}
	/**
	 *  @Description    : 查询金额分配主表
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmzDelete()throws Exception{
		boolean bl = declareService.dmzDelete(dmzForm);
		if(bl){
			message = "删除金额分配主表成功!";
		}else{
			message = "删除金额分配主表失败!";
		}
		return dmzFind();
	}
	/**
	 *  @Description    : 查询金额分配子表 
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmfFind()throws Exception{
		 list = declareService.dmfFind(dmfForm);
		 return "dmfFind";
	}
	/**
	 *  @Description    : 新增金额分配子表 
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmfInsert()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		String dmf_sid = sequenceService.getNO(userInfo.getSysint_sno(), "0", "dmf_sid");
		dmfForm.setDmz_sid(dmzForm.getDmz_sid());
		dmfForm.setDmf_sid(dmf_sid);//主键
		
		dmfForm.setDmf_stype("1");//1归口单位2项目单位
		dmfForm.setDmf_sreplyby(userInfo.getUsername());
		dmzForm.setDmz_stype("1");//分配类型
		dmzForm.setDmz_sreplyby(userInfo.getUsername());
		
		
		boolean bl = declareService.dmfInsert(dmfForm);
		 if(bl){
			list = declareService.dmfFind(dmfForm);
			Double do1 = 0d;
			for(int i = 0 ; i < list.size() ;i++){
				do1 += Double.parseDouble(((DMFDivMoneyF)list.get(i)).getDmf_sdivmoneys());
			}
			dmzForm.setDmz_snodiv(do1.toString());
			Double dmz_sdiving = (Double.parseDouble(dmzForm.getDmz_ndef1()) - Double.parseDouble(dmzForm.getDmz_snodiv()));
			dmzForm.setDmz_sdiving(dmz_sdiving.toString());
			declareService.dmzUpdate(dmzForm); 
			message = "新增金额分配子表成功!";
		}else{
			message = "新增金额分配子表失败!";
		}
		 dmfForm = null;
		return allotMoneyGkdw();//dmfFind();
	}
	/**
	 *  @Description    : 修改金额分配子表 
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmfUpdate()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		if(dmfForm == null){
			dmfForm = new DMFDivMoneyFForm();
		}
		dmfForm.setDmf_stype("1");//1归口单位2项目单位
		dmfForm.setDmf_salterby(userInfo.getUsername());
		dmzForm.setDmz_stype("1");//分配类型
		dmzForm.setDmz_sreplyby(userInfo.getUsername());
		boolean bl = declareService.dmfUpdate(dmfForm);
		if(bl){
			list = declareService.dmfFind(dmfForm);
			Double do1 = 0d;
			for(int i = 0 ; i < list.size() ;i++){
				do1 += Double.parseDouble(((DMFDivMoneyF)list.get(i)).getDmf_sdivmoneys());
			}
			dmzForm.setDmz_snodiv(do1.toString());
			Double dmz_sdiving = (Double.parseDouble(dmzForm.getDmz_ndef1()) - Double.parseDouble(dmzForm.getDmz_snodiv()));
			dmzForm.setDmz_sdiving(dmz_sdiving.toString());
			declareService.dmzUpdate(dmzForm);
			message = "修改金额分配子表成功!";
		}else{
			message = "修改金额分配子表失败!";
		}
		dmfForm = null;
		return allotMoneyGkdw();//dmfFind();
	}
	/**
	 *  @Description    : 删除金额分配子表
	 *  @Method_Name    : dmzFind
	 *  @param from
	 *  @return         : List
	 */
	public String dmfDelete()throws Exception{
		boolean bl = declareService.dmfDelete(dmfForm);
		if(bl){
			message = "删除金额分配子表成功!";
		}else{
			message = "删除金额分配子表失败!";
		}
		return dmfFind();
	}
	
	//校领导小组审核
	public String findXldxzsh() throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
	 	//System.out.println("//初始化分页标签");
	 	form.setSearchD("4");//定义状态为校领导小组
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		return "findXldxzsh";
	}
	//跳转到校领导小组审核页面
	public String toUpdateXldxzsh()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
		form.setRp_sid(form.getRp_sid());
		//vo =  (RpReport) declareService.rpFindList(form).get(0);
		List lists = declareService.rpFindList(form);
		if(list != null && list.size() > 0 ){
			vo =  (RpReport) lists.get(0);
		//申报子表list
		//附件表
		asForm = new AsAccessoryForm();
		asForm.setEp_sid(vo.getRp_sprojectno());
		asList = declareService.asFindList(asForm);
		//专家（人员）表
		slForm = new SlSpecialistForm();
		slForm.setRp_sprojectno(vo.getRp_sprojectno());
		slList = declareService.slFindList(slForm);
		//项目可行性附表
		//项目申请支出预算
		abForm = new AbApproBudgetForm();
		abForm.setRp_sprojectno(vo.getRp_sprojectno());
		abList = declareService.abFindList(abForm);
		//联合评审预算表
		ubForm = new UBUnitBudgetForm();
		ubForm.setRp_sprojectno(vo.getRp_sprojectno());
		ubList = declareService.ubFindList(ubForm);
		maxXuhao = declareService.ubFindSize(ubForm);
		//明细预算表
		bmxForm = new BMXBudgetMXForm();
		bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
		bmxList = declareService.bmxFindList(bmxForm);
		//项目申请阶段性目标表
		pgForm = new PgPerformanceGoalForm();
		pgForm.setRp_sprojectno(vo.getRp_sprojectno());
		pgList = declareService.pgFindList(pgForm);
	}
		return "toUpdateXldxzsh";
	}
	//校领导小组审核确认或者是退回
	public String updateXldxzsh()throws Exception{
		if(form == null){
			form = new RpReportForm();
		}
		boolean bl = declareService.rpUpdateGkdwsh(form);
		if(bl){
			message = "操作成功!";
		}else{
			message = "操作失败!";
		}
		form = null;
		return findXldxzsh();
	}
	//上报
	public String shangbao()throws Exception{
		String[] idchecked = request.getParameterValues("idcheckbox");
		boolean bl = true;
		if(idchecked != null && idchecked.length > 0 ){
			for(int i = 0 ; i < idchecked.length; i++){
				RpReportForm form1 = new RpReportForm();
				form1.setRp_sid(idchecked[i].trim());
				form1.setRp_sstatus("6");//已提交财政审批(上报)
				bl = declareService.rpUpdateGkdwsh(form1);
			}
		}
		//form.setRp_sstatus("6");//已提交财政审批(上报)
		//boolean bl = declareService.rpUpdateGkdwsh(form);
		if(bl){
			message = "操作成功!";
		}else{
			message = "操作失败!";
		}
		return findProjectSchool();
	}
	/**
	 *  @Description    : 归口单位金额分配
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String allotMoneyGkdw()throws Exception{
		//查询出所有的归口单位
		//根据年度和批次查询金额分配主表信息
		udlist = declareService.rpFindPC();
		//request.setAttribute("pcList", pcList);
		if(dmzForm == null){
			dmzForm = new DMZDivMoneyZForm();
		}
		if(dmzForm.getDmz_speriod() != null && dmzForm.getDmz_speriod() != "" && dmzForm.getDmz_syear() != null && dmzForm.getDmz_syear() != ""){
			List list1 = declareService.dmzFind(dmzForm);
			System.out.println(list1.size()+"==list1.size()");
			if(list1 != null && list1.size() > 0 ){
				dmz = (DMZDivMoneyZ) list1.get(0);
			}
			//根据金额分配主表主键查询金额分配子表信息
			if(dmfForm == null){
				dmfForm = new DMFDivMoneyFForm();
			}
			if(dmz != null){
				dmfForm.setDmz_sid(dmz.getDmz_sid());
				list = declareService.dmfFind(dmfForm);
				udlist1 =  declareService.findUd("2", "1");
				if(form == null){
					form = new RpReportForm();
				}
				form.setSearchD("5");
				form.setSearchH(dmzForm.getDmz_speriod());
				form.setSearchC(dmzForm.getDmz_syear());
				rpList = declareService.rpFindList(form);//查询出所有的状态为校领导小组审核的信息
			}
		}
		//request.setAttribute("rpList",rpList);
		return "allotMoneyGkdw";
	}
	/**
	 *  @Description    : 项目金额分配
	 *  @Method_Name    : allotMoenryProgrm
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String allotMoenryProgrm()throws Exception{
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		//查询出所有的批次
		udlist = declareService.rpFindPC();
		//request.setAttribute("pcList", pcList);
		if(dmzForm == null){
			dmzForm = new DMZDivMoneyZForm();
		}
		if(dmzForm.getDmz_speriod() != null && dmzForm.getDmz_speriod() != "" && dmzForm.getDmz_syear() != null && dmzForm.getDmz_syear() != ""){
			List list1 = declareService.dmzFind(dmzForm);
			System.out.println(list1.size()+"==list1.size()");
			if(list1 != null && list1.size() > 0 ){
				DMZDivMoneyZ dmz1 = (DMZDivMoneyZ) list1.get(0);
				if(dmfForm == null){
					dmfForm = new DMFDivMoneyFForm();
				}
				if(dmz1 != null){
					dmfForm.setDmz_sid(dmz1.getDmz_sid());
					//if(userInfo.getUd_sno() != null){
						dmfForm.setUd_sno(userInfo.getUd_sno());//userInfo.getUd_sno());
						dmf = (DMFDivMoneyF) declareService.dmfFind(dmfForm).get(0);
						//udlist1 =  declareService.findUd("2", "1");
						if(form == null){
							form = new RpReportForm();
						}
						form.setSearchD("5");
						form.setSearchF(userInfo.getUd_sno());//设置归口单位
						System.out.println(userInfo.getUd_sno()+"===userInfo.getUd_sno()");
						form.setSearchH(dmzForm.getDmz_speriod());
						form.setSearchC(dmzForm.getDmz_syear());
						rpList = declareService.rpFindList(form);//查询出所有的状态为校领导小组审核的信息
					//}
				}
			}
			//根据金额分配主表主键查询金额分配子表信息
			
		}
		return "allotMoenryProgrm";
	}
	/**
	 *  @Description    : 查询项目信息-金额分配修改模块
	 *  @Method_Name    : findAllotMoney
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String findAllotMoney()throws Exception{
		//判断form表单是否为空
		if(form==null){
			form = new RpReportForm();
		}
		//验证登陆session是否有效
		UserInfo userInfo = (UserInfo) session.get("userInfo");
	 	if (userInfo == null) {
			return ERROR;
		}
	 	//初始化分页标签
	 	//System.out.println("//初始化分页标签");
	 	form.setSearchD("5");//定义状态为校领导小组审核,不能上报所以才来修改
		String page = request.getParameter("page");
		bean = new PageBean(declareService.rpFindSize(form),
				PageBean.PAGE_SIZE);
		if (page != null) {
			bean.setCurrentPage(Integer.parseInt(page));
		}
		//设置分页语句
		form.setPageSQLA(bean.getPageSQLA());
		form.setPageSQLB(bean.getPageSQLB());
		//分页查询
		list = declareService.rpFindList(form);
		return "findAllotMoney";
	}
	/**
	 *  @Description    : 修改项目信息-金额分配修改模块 跳转页面
	 *  @Method_Name    : toUpdateAllotMoney
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String toUpdateAllotMoney()throws Exception{
		//String[] idchecked = request.getParameterValues("idcheckbox");
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
			form.setRp_sid(form.getRp_sid());
			vo =  (RpReport) declareService.rpFindList(form).get(0);
			//项目申请支出预算
			abForm = new AbApproBudgetForm();
			abForm.setRp_sprojectno(vo.getRp_sprojectno());
			abList = declareService.abFindList(abForm);
			//联合评审预算表
			ubForm = new UBUnitBudgetForm();
			ubForm.setRp_sprojectno(vo.getRp_sprojectno());
			ubList = declareService.ubFindList(ubForm);
			maxXuhao = declareService.ubFindSize(ubForm);
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
		return "toUpdateAllotMoney";
	}
	//修改项目信息-金额分配修改模块 保存
	public String updateAllotMoney()throws Exception{
		//修改申报表信息
		//明细预算表
		//联合评审预算表
		//项目申请支出预算
		//验证登陆session是否有效
		UserInfo userInfo=(UserInfo)session.get("userInfo");
		if (userInfo == null) {
			return ERROR;
		}
		form.setRp_salterby(userInfo.getUsername());
		SequenceService sequenceService = (SequenceService)getBean("sequenceService");
		form.setRp_sreplyby(userInfo.getUsername());
		String bmx_sid = "";//明细预算表主键
		String ub_sid = "";//联合评审预算表主键
		String ab_sid = "";//项目申请支出预算主键
		if(ubNum == 1){
			if(form.getUb_nplanname() != "" && form.getUb_nplanname() != null){
				String[] pg_sPhase = form.getUb_nplanname().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid");
					}else{
						ub_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ub_sid")+",";
					}
				}
				form.setUb_sid(ub_sid);
			}
		}
		
		//定义是否有关联
		if(bmxNum == 1){
			if(form.getBmx_ssort() != "" && form.getBmx_ssort() != null){
				String[] pg_sPhase = form.getBmx_ssort().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid");
					}else{
						bmx_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "bmx_sid")+",";
					}
				}
				form.setBmx_sid(bmx_sid);
			}
		}
		if(abNum == 1){
			if(form.getAb_sitems() != "" && form.getAb_sitems() != null){
				String[] pg_sPhase = form.getAb_sitems().split(",");
				for(int i = 0 ; i < pg_sPhase.length ; i++){
					if(i+1 == pg_sPhase.length){
						ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid");
					}else{
						ab_sid  += sequenceService.getNO(userInfo.getSysint_sno(), "0", "ab_sid")+",";
					}
				}
				form.setAb_sid(ab_sid);
			}
		}
		boolean bl = declareService.updateAllotMoney(form);
		if(bl){
			message = "修改成功!";
			log.logInsert(userInfo, "修改申报表", "rp_report");
		}else{
			message = "修改失败!";
		}
		System.out.println(form.getRp_sid()+"=form.getRp_sid()");
		if(form.getRp_sstatus() == "0" || "0".equals(form.getRp_sstatus())){
			return  toUpdateAllotMoney();
		}else{
			form = null;
			return findAllotMoney();
		}
	}
	/**
	 *  @Description    : 项目金额分配
	 *  @Method_Name    : updateAllotMoenryProgrm
	 *  @throws Exception 
	 *  @return         : String
	 */
	public String updateAllotMoenryProgrm()throws Exception{
		//修改申报表中的项目资金来源总计（万元）信息
		if(form == null){
			form = new RpReportForm();
		}
		//System.out.println(form.getRp_scometotal()+"===form.getRp_scometotal()");
		boolean bl = declareService.rpUpdateRpscometotal(form.getRp_sid().trim(), form.getRp_scometotal().trim());
		if(bl){
			message = "操作成功!";
		}else{
			message = "操作失败!";
		}
		form = null;
		return allotMoenryProgrm();
	}
	//查看项目申报详细信息
	public String vieDetails()throws Exception{
		if(form==null){
			form = new RpReportForm();
		}
		udlist = declareService.findUd("2","");
		//归口单位：
		udlist1 = declareService.findUd("2", "1");
		//单位基本信息
		ud = (MngUnitDepart) declareService.findUd("1","").get(0);
		form.setRp_sid(form.getRp_sid());
		List list = declareService.rpFindList(form);
		if(list != null && list.size() > 0 ){
			vo =  (RpReport) list.get(0);
			//申报子表list
			//附件表
			asForm = new AsAccessoryForm();
			asForm.setEp_sid(vo.getRp_sprojectno());
			asList = declareService.asFindList(asForm);
			//专家（人员）表
			slForm = new SlSpecialistForm();
			slForm.setRp_sprojectno(vo.getRp_sprojectno());
			slList = declareService.slFindList(slForm);
			//项目可行性附表
			//项目申请支出预算
			abForm = new AbApproBudgetForm();
			abForm.setRp_sprojectno(vo.getRp_sprojectno());
			abList = declareService.abFindList(abForm);
			//联合评审预算表
			ubForm = new UBUnitBudgetForm();
			ubForm.setRp_sprojectno(vo.getRp_sprojectno());
			ubList = declareService.ubFindList(ubForm);
			maxXuhao = declareService.ubFindSize(ubForm);
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
			//项目申请阶段性目标表
			pgForm = new PgPerformanceGoalForm();
			pgForm.setRp_sprojectno(vo.getRp_sprojectno());
			pgList = declareService.pgFindList(pgForm);
		}
		
		return "vieDetails";
	}
	public List getList(){
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PageBean getBean() {
		return bean;
	}

	public void setBean(PageBean bean) {
		this.bean = bean;
	}

	public NiNoticeInfoForm getNoticeForm() {
		return noticeForm;
	}

	public void setNoticeForm(NiNoticeInfoForm noticeForm) {
		this.noticeForm = noticeForm;
	}

	public NiNoticeInfo getNotice() {
		return notice;
	}

	public void setNotice(NiNoticeInfo notice) {
		this.notice = notice;
	}

	public RpReportForm getForm() {
		return form;
	}

	public void setForm(RpReportForm form) {
		this.form = form;
	}

	public RpReport getVo() {
		return vo;
	}

	public void setVo(RpReport vo) {
		this.vo = vo;
	}

	public RpReportSonForm getSonForm() {
		return sonForm;
	}

	public void setSonForm(RpReportSonForm sonForm) {
		this.sonForm = sonForm;
	}

	

	public RpReportSon getSonVo() {
		return sonVo;
	}

	public void setSonVo(RpReportSon sonVo) {
		this.sonVo = sonVo;
	}

	public PgPerformanceGoalForm getPgForm() {
		return pgForm;
	}

	public void setPgForm(PgPerformanceGoalForm pgForm) {
		this.pgForm = pgForm;
	}

	public PgPerformanceGoal getPg() {
		return pg;
	}

	public void setPg(PgPerformanceGoal pg) {
		this.pg = pg;
	}

	public BMXBudgetMXForm getBmxForm() {
		return bmxForm;
	}

	public void setBmxForm(BMXBudgetMXForm bmxForm) {
		this.bmxForm = bmxForm;
	}

	public BMXBudgetMX getBmx() {
		return bmx;
	}

	public void setBmx(BMXBudgetMX bmx) {
		this.bmx = bmx;
	}

	public UBUnitBudgetForm getUbForm() {
		return ubForm;
	}

	public void setUbForm(UBUnitBudgetForm ubForm) {
		this.ubForm = ubForm;
	}

	public UBUnitBudget getUb() {
		return ub;
	}

	public void setUb(UBUnitBudget ub) {
		this.ub = ub;
	}

	public AbApproBudgetForm getAbForm() {
		return abForm;
	}

	public void setAbForm(AbApproBudgetForm abForm) {
		this.abForm = abForm;
	}

	public AbApproBudget getAb() {
		return ab;
	}

	public void setAb(AbApproBudget ab) {
		this.ab = ab;
	}

	public FbFeasibilityForm getFbForm() {
		return fbForm;
	}

	public void setFbForm(FbFeasibilityForm fbForm) {
		this.fbForm = fbForm;
	}

	public FbFeasibility getFb() {
		return fb;
	}

	public void setFb(FbFeasibility fb) {
		this.fb = fb;
	}

	public SlSpecialistForm getSlForm() {
		return slForm;
	}

	public void setSlForm(SlSpecialistForm slForm) {
		this.slForm = slForm;
	}

	public SlSpecialist getSl() {
		return sl;
	}

	public void setSl(SlSpecialist sl) {
		this.sl = sl;
	}

	public AsAccessoryForm getAsForm() {
		return asForm;
	}

	public void setAsForm(AsAccessoryForm asForm) {
		this.asForm = asForm;
	}

	public AsAccessory getAs() {
		return as;
	}

	public void setAs(AsAccessory as) {
		this.as = as;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getBmx_ntotal() {
		return bmx_ntotal;
	}

	public void setBmx_ntotal(String bmx_ntotal) {
		this.bmx_ntotal = bmx_ntotal;
	}

	public List getUdlist() {
		return udlist;
	}

	public void setUdlist(List udlist) {
		this.udlist = udlist;
	}

	public List getUdlist1() {
		return udlist1;
	}

	public void setUdlist1(List udlist1) {
		this.udlist1 = udlist1;
	}

	public MngUnitDepart getUd() {
		return ud;
	}

	public void setUd(MngUnitDepart ud) {
		this.ud = ud;
	}

	public List getSonList() {
		return sonList;
	}

	public void setSonList(List sonList) {
		this.sonList = sonList;
	}
	public List getPgList() {
		return pgList;
	}
	public void setPgList(List pgList) {
		this.pgList = pgList;
	}
	public List getBmxList() {
		return bmxList;
	}
	public void setBmxList(List bmxList) {
		this.bmxList = bmxList;
	}
	public List getUbList() {
		return ubList;
	}
	public void setUbList(List ubList) {
		this.ubList = ubList;
	}
	public List getAbList() {
		return abList;
	}
	public void setAbList(List abList) {
		this.abList = abList;
	}
	public List getSlList() {
		return slList;
	}
	public void setSlList(List slList) {
		this.slList = slList;
	}
	public List getAsList() {
		return asList;
	}
	public void setAsList(List asList) {
		this.asList = asList;
	}
	public Integer getMaxXuhao() {
		return maxXuhao;
	}
	public void setMaxXuhao(Integer maxXuhao) {
		this.maxXuhao = maxXuhao;
	}
	public Integer getPgNum() {
		return pgNum;
	}
	public void setPgNum(Integer pgNum) {
		this.pgNum = pgNum;
	}
	public Integer getBmxNum() {
		return bmxNum;
	}
	public void setBmxNum(Integer bmxNum) {
		this.bmxNum = bmxNum;
	}
	public Integer getUbNum() {
		return ubNum;
	}
	public void setUbNum(Integer ubNum) {
		this.ubNum = ubNum;
	}
	public Integer getAbNum() {
		return abNum;
	}
	public void setAbNum(Integer abNum) {
		this.abNum = abNum;
	}
	public Integer getSlNum() {
		return slNum;
	}
	public void setSlNum(Integer slNum) {
		this.slNum = slNum;
	}
	public Integer getAsNum() {
		return asNum;
	}
	public void setAsNum(Integer asNum) {
		this.asNum = asNum;
	}
	public Integer getSlNum1() {
		return slNum1;
	}
	public void setSlNum1(Integer slNum1) {
		this.slNum1 = slNum1;
	}
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}
	public String getManualFileName() {
		return manualFileName;
	}
	public void setManualFileName(String manualFileName) {
		this.manualFileName = manualFileName;
	}

	public DMZDivMoneyZ getDmz() {
		return dmz;
	}
	public void setDmz(DMZDivMoneyZ dmz) {
		this.dmz = dmz;
	}
	public DMFDivMoneyFForm getDmfForm() {
		return dmfForm;
	}
	public void setDmfForm(DMFDivMoneyFForm dmfForm) {
		this.dmfForm = dmfForm;
	}
	public DMZDivMoneyZForm getDmzForm() {
		return dmzForm;
	}
	public void setDmzForm(DMZDivMoneyZForm dmzForm) {
		this.dmzForm = dmzForm;
	}
	public List getRpList() {
		return rpList;
	}
	public void setRpList(List rpList) {
		this.rpList = rpList;
	}
	public DMFDivMoneyF getDmf() {
		return dmf;
	}
	public void setDmf(DMFDivMoneyF dmf) {
		this.dmf = dmf;
	}
	public String getSblx() {
		return sblx;
	}
	public void setSblx(String sblx) {
		this.sblx = sblx;
	}
	public String getSyear() {
		return syear;
	}
	public void setSyear(String syear) {
		this.syear = syear;
	}
	public String getSperiod() {
		return speriod;
	}
	public void setSperiod(String speriod) {
		this.speriod = speriod;
	}
	public String getMaxXuhao1() {
		return maxXuhao1;
	}
	public void setMaxXuhao1(String maxXuhao1) {
		this.maxXuhao1 = maxXuhao1;
	}
	
}
