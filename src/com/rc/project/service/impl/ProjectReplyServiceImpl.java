package com.rc.project.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.axis.utils.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;

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
import com.rc.project.service.ProjectReplyService;
import com.rc.project.vo.EpProject;
import com.rc.project.vo.EpProjectDetail;
import com.rc.util.DateUtils;

public class ProjectReplyServiceImpl implements ProjectReplyService {

	private EpProjectDAO epProjectDAO;
	private EpProjectDetailDAO epProjectDetailDAO;
	private RpReportDAO rpReportDAO;
	private UnitDepartDAO unitDepartDAO;
	private EmpDAO empDAO;

//	private List<EpProjectForm> projectForms = new ArrayList<EpProjectForm>(0); // 批复主表待导入信息
//	private List<EpProjectDetailForm> projectDetailForms = new ArrayList<EpProjectDetailForm>(0); // 批复明细待导入信息

	
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EpProjectDetail> findDetailForAuto(EpProjectDetailForm form) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importData(EpProjectForm form) throws Exception {
		final String path = "D:\\workspace-ee\\cg\\src\\import\\reply\\20140321000001\\123456.xls";
		Workbook book = Workbook.getWorkbook(new File(path));
		Sheet sheetall = book.getSheet(0);
		Sheet sheetDetail = book.getSheet(1);
		importList(sheetall, form.getEP_SALTERBY(), form.isAll());
		importDetail(sheetDetail, form.getEP_SALTERBY(), form.isAll(),sheetall.getCell(0,1).getContents());
	}

	/**
	 * 导入主表
	 * 
	 * @throws Exception
	 */
	private void importList(Sheet sheet, String oper, boolean isAll) throws Exception {
		int rows = sheet.getRows();
		System.out.println(sheet.getName());
		String sno = "";
		String pname = "";
		String sname = "";
		String money = "";
		//
		for (int r = 1; r < rows-1; r++) {
			sname = sheet.getCell(2, r).getContents().trim();
			// 不是全部导入的时候，只导入"设备购置费"或"设备费"数据
			if (sheet.getCell(0, r).getContents() != null && sheet.getCell(0, r).getContents().trim().length() > 1) {
				sno = sheet.getCell(0, r).getContents();
			}
			if (sheet.getCell(1, r).getContents() != null && sheet.getCell(1, r).getContents().trim().length() > 1) {
				pname = sheet.getCell(1, r).getContents();
				// TODO 通过项目名称，查询编号 rpReportDAO
			}
			if ((sname.equalsIgnoreCase("设备购置费") || sname.equalsIgnoreCase("设备费")) || isAll ) {
				EpProjectForm form = new EpProjectForm();
				// TODO ZHUJIAN
				// 主键 
				form.setEP_SID(UUID.randomUUID().toString().substring(0, 6));
				// 项目编号
				form.setEP_SNO(sno);
				// 编号（上报申报项目表) 通过项目名称与上报申报项目表进行关联获取上报编号
				form.setRP_SNO(pname);
				// 年度
				form.setEP_SYEAR(DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4));
				// 名称（国库预算批复明细
				form.setEP_SNAME(sname);
				// 名称（校内预算模板
				form.setEP_SNAMEXIAO(sheet.getCell(3, r).getContents().trim());
				// 批复金额
				String[] moneys = sheet.getCell(5, r).getContents().trim().split(",");   //以防有逗号的情况123,890.00
				for(int k = 0 ;k<moneys.length ;k++){
					money += moneys[k];
				}
				form.setEP_SMONEY(new BigDecimal(money));
				money = "";
				// 是否涉及政采
				form.setEP_SISZC((sheet.getCell(4, r).getContents().trim().equals("是")) ? "1" : "0");
				// 项目负责人所属单位
				// TODO unitDepartDAO 通过名称，找单位编号 Mng_UnitDepart
				// ，先查项目，再查单位，最后单位编号
				form.setUD_SNO("测试单位0001");
				// 项目负责人所属单位名称
				form.setEP_SPERDEPARTNAME("首都师范大学");
				// 项目负责人员工编号
				// TODO empDAO 通过负责人名称找到编号
				form.setEMP_SNO("TESTEMPNO000001");
				// 项目负责人姓名
				form.setEP_SPERSON(sheet.getCell(6, r).getContents().trim());
				// 是否删除
				form.setEP_SISDEL("1");
				// 是否有效
				form.setEP_SISVALID("1");
				// 创建人
				form.setEP_SALTERBY(oper);
				// 填写日期
				form.setEP_SREPLYDATE(new Date(System.currentTimeMillis()));
				epProjectDAO.insertSelective(form);
				System.out.println(form.toString());
			}
		}
	}

	/**
	 * 导入明细
	 * @param sheet 需要导入数据的页签，一般是1
	 * @param oper  操作人
	 * @param isAll 是否全部导入
	 * @param psno  项目编号
	 * @throws Exception
	 */
	private void importDetail(Sheet sheet, String oper, boolean isAll,String ep_sno) throws Exception {
		int rows = sheet.getRows();
		System.out.println(sheet.getName());
		//公共信息
		//项目编号 项目代码 项目代码 编号 年度 项目单位 项目单位名称
		String epsno = ep_sno;
		String epdsaskno = sheet.getCell(0,3).getContents().trim().split("：")[1].split(" ")[0].trim();
		String rpsno = "XMBH000001";      // TODO 通过项目名称，查询编号 rpReportDAO
		String syear = DateUtils.getDate(new Date(System.currentTimeMillis())).substring(0, 4);
		String udsno = "测试单位0001";   //TODO unitDepartDAO 通过名称，找单位编号 Mng_UnitDepart
		String srun = (sheet.getCell(0,1).getContents().trim().split("：")[1]).trim();
		String sname = "";   //明细项目名称
		String note = "";   //审核说明
		
		int i = 0;
		for(int r = 6; r<rows-1;r++){
			if(sheet.getCell(1,r).getContents()!=null && sheet.getCell(1,r).getContents().trim().length() > 0){
				sname = sheet.getCell(1, r).getContents().trim();
			}
			if(sheet.getCell(14, r).getContents()!=null &&sheet.getCell(14, r).getContents().trim().length() > 0){
				note = sheet.getCell(14, r).getContents().trim();
			}
			if ((sname.equalsIgnoreCase("设备购置费") || sname.equalsIgnoreCase("设备费")) || isAll) {
				EpProjectDetailForm form = new EpProjectDetailForm();
//		epd_nId	主键
				//TODO 需要使用表的自增来完成
				form.setEpdNid(new BigDecimal(Math.random()));
//		ep_sNo	项目编号
				form.setEpSno(epsno);
//		epd_sAskNo	项目代码
				form.setEpdSaskno(epdsaskno);
//		rp_sNo	编号（上报申报项目表)
				form.setRpSno(rpsno);
//		epd_syear	年度
				form.setEpdSyear(syear);
//		ud_sno	项目单位
				form.setUdSno(udsno);
//		epd_sReportUnitName	项目单位名称
				form.setEpdSreportunitname(srun);
//		epd_nnum	序
				if(sheet.getCell(0, r).getContents()!=null && sheet.getCell(0, r).getContents().trim().length() > 0)
					i++;
				form.setEpdNnum(new BigDecimal(i));
//		epd_sName	明细项目名称
				form.setEpdSname(sname);
//		epd_sNameXiao	明细预算内容
				form.setEpdSnamexiao(sheet.getCell(2, r).getContents().trim());
//		epd_smodel	型号
				form.setEpdSmodel("");
//		epd_sspec	规格
				form.setEpdSspec("");
//		epd_sbrand	品牌名
				form.setEpdSbrand("");
//		epd_sUnit	单位
				form.setEpdSunit(sheet.getCell(3, r).getContents().trim());
//		epd_nNum	数量（审定额）
				form.setEpdNnum(new BigDecimal(sheet.getCell(5, r).getContents().trim()));
//		epd_nPrice	单价（审定额）
				form.setEpdNprice(new BigDecimal(sheet.getCell(4, r).getContents().trim()));
//		epd_nTotal	总金额（审定额）
				form.setEpdNtotal(new BigDecimal(sheet.getCell(6, r).getContents().trim()));
//		epd_nNumSong	数量（送审额）
				form.setEpdNnumsong(new BigDecimal(StringUtils.isEmpty(sheet.getCell(8, r).getContents().trim())?"0": sheet.getCell(8, r).getContents().trim()));
//		epd_nPriceSong	单价（送审额）
				form.setEpdNpricesong(new BigDecimal(StringUtils.isEmpty(sheet.getCell(7, r).getContents().trim())?"0": sheet.getCell(7, r).getContents().trim()));
//		epd_nTotalSong	总金额（送审额）
				form.setEpdNtotalsong(new BigDecimal(StringUtils.isEmpty(sheet.getCell(9, r).getContents().trim())?"0": sheet.getCell(9, r).getContents().trim()));
//		epd_nNumJian	数量（审减额）
				form.setEpdNnumjian(new BigDecimal(StringUtils.isEmpty(sheet.getCell(12, r).getContents().trim())?"0":sheet.getCell(12, r).getContents().trim()));
//		epd_nPriceJian	单价（审减额）
				form.setEpdNpricejian(new BigDecimal(StringUtils.isEmpty(sheet.getCell(11, r).getContents().trim())?"0":sheet.getCell(11, r).getContents().trim()));
//		epd_nTotalJian	总金额（审减额）
				form.setEpdNtotaljian(new BigDecimal(StringUtils.isEmpty(sheet.getCell(13, r).getContents().trim())?"0":sheet.getCell(13, r).getContents().trim()));
//		epd_nCanNot	无法确认额
				form.setEpdNcannot(new BigDecimal(StringUtils.isEmpty(sheet.getCell(10, r).getContents().trim())?"0":sheet.getCell(10, r).getContents().trim()));
//		epd_sApproveNote	审核说明
				form.setEpdSapprovenote(note);
//		epd_sstat	状态
				form.setEpdSstat("1");
//		epd_spurtype	采购类别  无
//		epd_sIsImport	是否进口  无
//		epd_sIsFreeTax	是否免税  无
//		epd_sjkfile	进口附件
//		epd_smsfile	免税附件
//		pl_sPara	技术参数
//		pl_sRemark	备注
//		pl_sPayType	支付方式
//		pl_sBuyDate	提交采购方式时间
//		epd_sIsDel	是否删除
				form.setEpdSisdel("1");
//		epd_sIsValid	是否有效
				form.setEpdSisvalid("1");
//		epd_sReplyBy	创建人
				form.setEpdSreplyby(oper);
//				epd_sReplyDate	填写日期
                form.setEpdSreplydate(new Date(System.currentTimeMillis()));
                epProjectDetailDAO.insertSelective(form);
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

}
