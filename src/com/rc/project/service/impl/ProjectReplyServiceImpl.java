package com.rc.project.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.axis.utils.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;

import com.rc.base.dao.EmpDAO;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.project.dao.EpProjectDAO;
import com.rc.project.dao.EpProjectDetailDAO;
import com.rc.project.dao.RpReportDAO;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpProjectForm;
import com.rc.project.form.RpReportForm;
import com.rc.project.service.ProjectReplyService;
import com.rc.project.vo.EpProject;
import com.rc.project.vo.EpProjectDetail;
import com.rc.project.vo.RpReport;
import com.rc.util.DateUtils;

public class ProjectReplyServiceImpl implements ProjectReplyService {

	private EpProjectDAO epProjectDAO;
	private EpProjectDetailDAO epProjectDetailDAO;
	private RpReportDAO rpReportDAO;
	private UnitDepartDAO unitDepartDAO;
	private EmpDAO empDAO;
	
	private DataSourceTransactionManager transactionManager;

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public EmpDAO getEmpDAO() {
		return empDAO;
	}
	

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public UnitDepartDAO getUnitDepartDAO() {
		return unitDepartDAO;
	}

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}

	public RpReportDAO getRpReportDAO() {
		return rpReportDAO;
	}

	public void setRpReportDAO(RpReportDAO rpReportDAO) {
		this.rpReportDAO = rpReportDAO;
	}

	public EpProjectDAO getEpProjectDAO() {
		return epProjectDAO;
	}

	public void setEpProjectDAO(EpProjectDAO epProjectDAO) {
		this.epProjectDAO = epProjectDAO;
	}

	public EpProjectDetailDAO getEpProjectDetailDAO() {
		return epProjectDetailDAO;
	}

	public void setEpProjectDetailDAO(EpProjectDetailDAO epProjectDetailDAO) {
		this.epProjectDetailDAO = epProjectDetailDAO;
	}

	@Override
	public List<EpProject> findForAuto(EpProjectForm form) throws Exception {
		return (List<EpProject>) this.epProjectDAO.findByPage(form);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EpProjectDetail> findDetailForAuto(EpProjectDetailForm form) throws Exception {

		return (List<EpProjectDetail>) this.epProjectDetailDAO.findPage(form);
	}

	@Override
	public void importData(EpProjectForm form) throws Exception {
		final String path = form.getFilePath();
		Workbook book = Workbook.getWorkbook(new File(path));
		Sheet sheetall = book.getSheet(0);
		Sheet sheetDetail = book.getSheet(1);
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		try{
			Map<String, String> map = importList(sheetall, form.getEP_SREPLYBY(), form.isAll());
			importDetail(sheetDetail, form.getEP_SREPLYBY(), form.isAll(), map);
			this.transactionManager.commit(status);
		}catch(Exception e){
			this.transactionManager.rollback(status);
			throw e;
		}
	}

	/**
	 * 导入主表
	 * 
	 * @throws Exception
	 */
	private Map<String,String> importList(Sheet sheet, String oper, boolean isAll) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		int rows = sheet.getRows();
		System.out.println(sheet.getName());
		String epno = ""; // 项目编号
		String pname = ""; // 项目名称
		String sname = "";
		String money = "";
		String rpno = ""; // 上报项目编号
		String xmdwsno = "";   //项目所在单位编号
		String xmdwname = "";   //项目所在单位名称
		String empno = "";      //项目负责人编号
		RpReportForm record;
		List reports;
		for (int r = 1; r < rows - 1; r++) {
			sname = sheet.getCell(2, r).getContents().trim();
//			map.clear();
			if (sheet.getCell(0, r).getContents() != null && sheet.getCell(0, r).getContents().trim().length() > 1) {
				epno = sheet.getCell(0, r).getContents();
				if(map.get("epno")==null)
				   map.put("epno", epno);
			}
			if (sheet.getCell(1, r).getContents() != null && sheet.getCell(1, r).getContents().trim().length() > 1) {
				pname = sheet.getCell(1, r).getContents();
				// TODO 通过项目名称，查询编号 rpReportDAO
				record = new RpReportForm();
				record.setSearchD(pname);
				record.setSearchE(sheet.getCell(6, r).getContents().trim());
				reports = this.rpReportDAO.selectByPage(record);
				if (reports.size() != 1) {
					throw new IllegalStateException("负责人 '" + sheet.getCell(6, r).getContents().trim() + "' 的项目'" + pname + "'找到" + reports.size() + "上报项目的编号");
				}
				rpno = ((RpReport) reports.get(0)).getRP_SNO();
				xmdwsno = ((RpReport) reports.get(0)).getUD_SNO1();
				xmdwname = ((RpReport) reports.get(0)).getRP_SREPORTUNITNAME();
				empno = ((RpReport) reports.get(0)).getEMP_SNO();
				if(map.get("rpsno")==null)
				    map.put("rpsno", rpno);
				if(map.get("udsno")==null)
				    map.put("udsno", xmdwsno);
			}
			//第一次循环时的时候验证是否导入过
			if(r == 1)
			    this.checkExistReplyProject(map.get("rpsno").toString().trim(), map.get("udsno").toString().trim(), empno);
			// 不是全部导入的时候，只导入"设备购置费"或"设备费"数据
			if ((sname.equalsIgnoreCase("设备购置费") || sname.equalsIgnoreCase("设备费")) || isAll) {
				EpProjectForm form = new EpProjectForm();
				// TODO ZHUJIAN
				// 主键
				form.setEP_SID(UUID.randomUUID().toString().substring(0, 6));
				// 项目编号
				form.setEP_SNO(epno);
				// 编号（上报申报项目表) 通过项目名称与上报申报项目表进行关联获取上报编号
				form.setRP_SNO(rpno);
				// 年度
				form.setEP_SYEAR(DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4));
				// 名称（国库预算批复明细
				form.setEP_SNAME(sname);
				// 名称（校内预算模板
				form.setEP_SNAMEXIAO(sheet.getCell(3, r).getContents().trim());
				// 批复金额
				String[] moneys = sheet.getCell(5, r).getContents().trim().split(","); // 以防有逗号的情况123,890.00
				for (int k = 0; k < moneys.length; k++) {
					money += moneys[k];
				}
				form.setEP_SMONEY(new BigDecimal(money));
				money = "";
				// 是否涉及政采
				form.setEP_SISZC((sheet.getCell(4, r).getContents().trim().equals("是")) ? "1" : "0");
				// 项目负责人所属单位
				// ，先查项目，再查单位，最后单位编号
				
				form.setUD_SNO(xmdwsno);
				// 项目负责人所属单位名称
				form.setEP_SPERDEPARTNAME(xmdwname);
				// 项目负责人员工编号
				// TODO empDAO 通过负责人名称找到编号
				form.setEMP_SNO(empno);
				// 项目负责人姓名
				form.setEP_SPERSON(sheet.getCell(6, r).getContents().trim());
				// 是否删除
				form.setEP_SISDEL("0");
				// 是否有效
				form.setEP_SISVALID("0");
				// 创建人
				form.setEP_SREPLYBY(oper);
				// 填写日期
				form.setEP_SREPLYDATE(new Date(System.currentTimeMillis()));
				epProjectDAO.insertSelective(form);
			}
		}
		return map;
	}

	/**
	 * 导入明细
	 * 
	 * @param sheet
	 *            需要导入数据的页签，一般是1
	 * @param oper
	 *            操作人
	 * @param isAll
	 *            是否全部导入
	 * @param psno
	 *            项目编号
	 * @throws Exception
	 */
	private void importDetail(Sheet sheet, String oper, boolean isAll, Map map) throws Exception {
		int rows = sheet.getRows();
		System.out.println(sheet.getName());
		// 公共信息
		// 项目编号 项目代码 项目代码 编号 年度 项目单位 项目单位名称
		String epsno = map.get("epno").toString();
		String epdsaskno = sheet.getCell(0, 3).getContents().trim().split("：")[1].split(" ")[0].trim();
		String rpsno = map.get("rpsno").toString(); // TODO 通过项目名称，查询编号 rpReportDAO
		String syear = DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4);
		String udsno = map.get("udsno").toString(); // TODO unitDepartDAO 通过名称，找单位编号
									// Mng_UnitDepart
		String srun = (sheet.getCell(0, 1).getContents().trim().split("：")[1]).trim();
		String sname = ""; // 明细项目名称
		String note = ""; // 审核说明

		int i = 0;
		for (int r = 6; r < rows - 1; r++) {
			if (sheet.getCell(1, r).getContents() != null && sheet.getCell(1, r).getContents().trim().length() > 0) {
				sname = sheet.getCell(1, r).getContents().trim();
			}
			if (sheet.getCell(14, r).getContents() != null && sheet.getCell(14, r).getContents().trim().length() > 0) {
				note = sheet.getCell(14, r).getContents().trim();
			}
			if ((sname.equalsIgnoreCase("设备购置费") || sname.equalsIgnoreCase("设备费")) || isAll) {
				EpProjectDetailForm form = new EpProjectDetailForm();
				// epd_nId 主键
				// TODO 需要使用表的自增来完成
				form.setEPD_NID(new BigDecimal(Math.random()));
				// ep_sNo 项目编号
				form.setEP_SNO(epsno);
				// epd_sAskNo 项目代码
				form.setEPD_SASKNO(epdsaskno);
				// rp_sNo 编号（上报申报项目表)
				form.setRP_SNO(rpsno);
				// epd_syear 年度
				form.setEPD_SYEAR(syear);
				// ud_sno 项目单位
				form.setUD_SNO(udsno);
				// epd_sReportUnitName 项目单位名称
				form.setEPD_SREPORTUNITNAME(srun);
				// epd_nnum 序
				if (sheet.getCell(0, r).getContents() != null && sheet.getCell(0, r).getContents().trim().length() > 0)
					i++;
				form.setEPD_NNUM(new BigDecimal(i));
				// epd_sName 明细项目名称
				form.setEPD_SNAME(sname);
				//检查重复，项目名称，项目负责人，项目单位
				// epd_sNameXiao 明细预算内容
				form.setEPD_SNAMEXIAO(sheet.getCell(2, r).getContents().trim());
				// epd_smodel 型号
				form.setEPD_SMODEL("");
				// epd_sspec 规格
				form.setEPD_SSPEC("");
				// epd_sbrand 品牌名
				form.setEPD_SBRAND("");
				// epd_sUnit 单位
				form.setEPD_SUNIT(sheet.getCell(3, r).getContents().trim());
				// epd_nNum 数量（审定额）
				form.setEPD_NNUM(new BigDecimal(sheet.getCell(5, r).getContents().trim()));
				// epd_nPrice 单价（审定额）
				form.setEPD_NPRICE(new BigDecimal(sheet.getCell(4, r).getContents().trim()));
				// epd_nTotal 总金额（审定额）
				form.setEPD_NTOTAL(new BigDecimal(sheet.getCell(6, r).getContents().trim()));
				// epd_nNumSong 数量（送审额）
				form.setEPD_NNUMSONG(new BigDecimal(StringUtils.isEmpty(sheet.getCell(8, r).getContents().trim()) ? "0" : sheet.getCell(8, r).getContents().trim()));
				// epd_nPriceSong 单价（送审额）
				form.setEPD_NPRICESONG(new BigDecimal(StringUtils.isEmpty(sheet.getCell(7, r).getContents().trim()) ? "0" : sheet.getCell(7, r).getContents().trim()));
				// epd_nTotalSong 总金额（送审额）
				form.setEPD_NTOTALSONG(new BigDecimal(StringUtils.isEmpty(sheet.getCell(9, r).getContents().trim()) ? "0" : sheet.getCell(9, r).getContents().trim()));
				// epd_nNumJian 数量（审减额）
				form.setEPD_NNUMJIAN(new BigDecimal(StringUtils.isEmpty(sheet.getCell(12, r).getContents().trim()) ? "0" : sheet.getCell(12, r).getContents().trim()));
				// epd_nPriceJian 单价（审减额）
				form.setEPD_NPRICEJIAN(new BigDecimal(StringUtils.isEmpty(sheet.getCell(11, r).getContents().trim()) ? "0" : sheet.getCell(11, r).getContents().trim()));
				// epd_nTotalJian 总金额（审减额）
				form.setEPD_NTOTALJIAN(new BigDecimal(StringUtils.isEmpty(sheet.getCell(13, r).getContents().trim()) ? "0" : sheet.getCell(13, r).getContents().trim()));
				// epd_nCanNot 无法确认额
				form.setEPD_NCANNOT(new BigDecimal(StringUtils.isEmpty(sheet.getCell(10, r).getContents().trim()) ? "0" : sheet.getCell(10, r).getContents().trim()));
				// epd_sApproveNote 审核说明
				form.setEPD_SAPPROVENOTE(note);
				// epd_sstat 状态
				form.setEPD_SSTAT("1");
				// epd_spurtype 采购类别 无
				// epd_sIsImport 是否进口 无
				// epd_sIsFreeTax 是否免税 无
				// epd_sjkfile 进口附件
				// epd_smsfile 免税附件
				// pl_sPara 技术参数
				// pl_sRemark 备注
				// pl_sPayType 支付方式
				// pl_sBuyDate 提交采购方式时间
				// epd_sIsDel 是否删除
				form.setEPD_SISDEL("0");
				// epd_sIsValid 是否有效
				form.setEPD_SISVALID("0");
				// epd_sReplyBy 创建人
				form.setEPD_SREPLYBY(oper);
				// epd_sReplyDate 填写日期
				form.setEPD_SREPLYDATE(new Date(System.currentTimeMillis()));
				epProjectDetailDAO.insert(form.toVO());
				System.out.println(form);
			}
		}

	}

	public static void main(String[] args) {
		ProjectReplyServiceImpl p = new ProjectReplyServiceImpl();
		EpProjectForm form = new EpProjectForm();
		form.setEP_SALTERBY("admin");
		form.setAll(true);
		try {
			p.importData(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int findSize(EpProjectForm form) throws Exception {
		// TODO Auto-generated method stub
		return this.epProjectDAO.findBySize(form);
	}

	@Override
	public RpReport findProjectByNo(String no) throws Exception {
		// TODO Auto-generated method stub
		return this.rpReportDAO.selectByPrimaryKey(no);
	}
	
	/**
	 * 检查批复项目是否已经批复
	 * @param pname
	 * @param usno
	 * @param esno
	 * @throws Exception
	 */
	private void checkExistReplyProject(String psno,String usno,String esno) throws Exception{
		EpProjectForm record = new EpProjectForm();
		record.setRP_SNO(psno);
		record.setUD_SNO(usno);
		record.setEMP_SNO(esno);
		if (epProjectDAO.findBySize(record) > 0){
		    throw new IllegalStateException("单位编号 " +usno+"中员工编号为"+esno+"的项目（编号："+psno+"）已经批复过");	
		}
	}
	
	/**
	 * 检查批复项目明细，批复项目已经检查，明细就不用检查了，暂时不用实现
	 * @throws Exception
	 */
	private void checkExistReplyProjectDetail() throws Exception{
		
	}

}
