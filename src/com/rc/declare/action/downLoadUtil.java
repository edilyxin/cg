package com.rc.declare.action;

import org.apache.poi.ss.util.Region;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.rc.base.vo.MngUnitDepart;
import com.rc.declare.form.AbApproBudgetForm;
import com.rc.declare.form.AsAccessoryForm;
import com.rc.declare.form.BMXBudgetMXForm;
import com.rc.declare.form.DMFDivMoneyFForm;
import com.rc.declare.form.DMZDivMoneyZForm;
import com.rc.declare.form.FbFeasibilityForm;
import com.rc.declare.form.PgPerformanceGoalForm;
import com.rc.declare.form.RpReportForm;
import com.rc.declare.form.SlSpecialistForm;
import com.rc.declare.form.UBUnitBudgetForm;
import com.rc.declare.service.DeclareService;
import com.rc.declare.vo.AbApproBudget;
import com.rc.declare.vo.AsAccessory;
import com.rc.declare.vo.BMXBudgetMX;
import com.rc.declare.vo.DMFDivMoneyF;
import com.rc.declare.vo.DMZDivMoneyZ;
import com.rc.declare.vo.FbFeasibility;
import com.rc.declare.vo.PgPerformanceGoal;
import com.rc.declare.vo.RpReport;
import com.rc.declare.vo.SlSpecialist;
import com.rc.declare.vo.UBUnitBudget;
import com.rc.util.BaseAction;

 


public class downLoadUtil extends BaseAction{
	private DeclareService declareService = (DeclareService)getBean("declareService");
	private String fileName = "项目申报1.1.xls";// 文件名
	private RpReportForm form;//项目申报form
	private RpReport vo;//项目申报vo
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
	private DMFDivMoneyFForm dmfForm;
	private DMFDivMoneyF dmf;//金额分配子表
	private FbFeasibility fb;//项目可行性附表
	private SlSpecialistForm slForm;//专家（人员）表
	private SlSpecialist sl;//专家（人员）表
	private AsAccessoryForm asForm;//附件表
	private AsAccessory as;//附件表
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
	private InputStream bais;// 导出的文件
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExcel() throws IOException {
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
			//明细预算表
			bmxForm = new BMXBudgetMXForm();
			bmxForm.setRp_sprojectno(vo.getRp_sprojectno());
			bmxList = declareService.bmxFindList(bmxForm);
			//项目申请阶段性目标表
			pgForm = new PgPerformanceGoalForm();
			pgForm.setRp_sprojectno(vo.getRp_sprojectno());
			pgList = declareService.pgFindList(pgForm);
		FileOutputStream fileOut = null;   
        BufferedImage bufferImg = null;   
        BufferedImage bufferImg1 = null;   
       // 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray   
      /* // 读入图片1
        String barName = request.getRealPath("/")+"\\jsp/ny\\" + "shebb1-1.png";//要导出到Excel文件中的图片路径
        System.out.println("barName="+barName);
        File jpgfile = new File(barName);//barName 为统计图片在服务器上的路径
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();   
        bufferImg = ImageIO.read(jpgfile);   
        ImageIO.write(bufferImg, "png", byteArrayOut);   
          
       // 读入图片2   
        ByteArrayOutputStream byteArrayOut1 = new ByteArrayOutputStream();   
        bufferImg1 = ImageIO.read(jpgfile);   
        ImageIO.write(bufferImg1, "png", byteArrayOut1);   
*/
		
		
		
		
		// 文件的编码格式
		try {
			fileName = new String(fileName.getBytes("GBK"), "GBK");
			// fileName = new String(fileName.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		//第一页
		HSSFSheet sheet = workbook.createSheet("p1");
		//String [] nsd =  form.getYh_nsd().split(", ");
		//nyService.jiaSdef8(nsd,form.getYh_sdef8());
		
		//List list =null;
		//list = nyService.findExcelList(nsd);
		//System.out.println("list.size()="+list.size());
//		sheet.setProtect();
		//设置工作表的密码
		//sheet.protectSheet(new String("3335")); 
	
		// 获得excel的第一行  并设置第一行的样式
        HSSFCellStyle style = workbook.createCellStyle(); // 样式对象       
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直      
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平      
        //设置为只读
        style.setLocked(true);
       
        //生成一个字体
        HSSFFont font=workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font.setFontHeightInPoints((short)24);
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
       //把字体应用到当前的样式
        style.setFont(font);

        HSSFCellStyle setBorder = workbook.createCellStyle();
        

        
        HSSFRow row1 = sheet.createRow((short) 0);      
        HSSFRow row2 = sheet.createRow((short) 1);      
        
//      addMergedRegion(new Region(行, (short)列, 行, (short)列));
       
        sheet.addMergedRegion(new Region(0, (short) 0, 2, (short) 7));      
        HSSFCell ce = row1.createCell(0);      
        ce.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        ce.setCellValue("项目申报书"); // 表格的第一行第一列显示的数据      
        ce.setCellStyle(style); // 样式，居中   
		
        
        HSSFRow row3 = sheet.createRow(4);
        sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 3));
        sheet.addMergedRegion(new Region(4, (short) 4, 4, (short) 6));
     // 设置流水号、项目主管的字体样式
        HSSFCellStyle style4 = workbook.createCellStyle(); // 样式对象       
//        style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直      
//        style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平      
        //生成一个字体
        HSSFFont font4=workbook.createFont();
        font4.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font4.setFontHeightInPoints((short)12);
//        font4.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
       //把字体应用到当前的样式
//        style4.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style4.setFont(font4);
  
        
        HSSFCell ce1 = row3.createCell(0);      
        ce1.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        ce1.setCellValue("项目名称:"+vo.getRp_sprojectname()); // 表格的第一行第一列显示的数据      
        ce1.setCellStyle(style4); // 样式，居中  
//        ce1.setColor(HSSFColor.BLACK.index);
        
        HSSFCell ce3 = row3.createCell(4);      
        ce3.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        ce3.setCellValue("项目编号:"+vo.getRp_sprojectno()); // 表格的第一行第一列显示的数据  
        ce3.setCellStyle(style4); // 样式，居中
		
		
		HSSFRow row = sheet.createRow(6);
		// 获得excel的第六行字段名  并设置该行的样式
		HSSFCellStyle style1 = workbook.createCellStyle(); // 样式对象       
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直      
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平  
        sheet.setColumnWidth(0, 3766);//第一列
//        sheet.setColumnWidth(5, 3766);//第六列
        sheet.setColumnWidth(6, 3766);//第六列
        sheet.setColumnWidth(7, 3766);//第七列
        //生成一个字体
        HSSFFont font1=workbook.createFont();
        font1.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font1.setFontHeightInPoints((short)11);
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
       //把字体应用到当前的样式
        style1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框

        style1.setFont(font1);
		
		HSSFCell cell = row.createCell(0);
		{
			cell=row.createCell(0);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("编号");
			 
			cell.setCellStyle(style1); // 样式，居中   
			cell = row.createCell(1);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("品名"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row.createCell(2);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("单位"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row.createCell(3);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("单价(元)"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row.createCell(4);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("数量"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row.createCell(5);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("总额(元)"); // 填充字段名			
			cell.setCellStyle(style1); // 样式，居中   
			cell=row.createCell(6);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("发票号");
			cell.setCellStyle(style1); // 样式，居中   
			cell=row.createCell(7);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("经费卡号");
			cell.setCellStyle(style1); // 样式，居中   	
		}
		
		
		
		
		
		// 设置循环的list的字体样式
        HSSFCellStyle style5 = workbook.createCellStyle(); // 样式对象       
        style5.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直      
        style5.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平      
        //生成一个字体
        HSSFFont font5=workbook.createFont();
        font5.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font5.setFontHeightInPoints((short)10);
//        font4.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
       //把字体应用到当前的样式
        style5.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style5.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        style5.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
        style5.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style5.setFont(font5);
		
		/*Asset assets = null;
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				assets = (Asset) list.get(i);
				// 循环创建每一列
				row = sheet.createRow(i+7);

				cell = row.createCell(0);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_nid()); // 条形码
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(1);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sname());// 物品名称
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(2);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_splace()); // 单位
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(3);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dprice()); // 单价
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(4);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_quantity()); // 数量
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(5);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dtotal()); // 总额
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(6);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sbill()); // 发票号
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(7);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sfundsno()); //经费卡号 	
				cell.setCellStyle(style5); // 样式，居中
			}
		}
		if(6-list.size()>0){
		for (int i = 0; i <6-list.size(); i++) {
			row = sheet.createRow(i+7+list.size());	
			HSSFCellStyle style6 = workbook.createCellStyle(); // 样式对象    
			style6.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	        style6.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	        style6.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
	        style6.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
			cell = row.createCell(0);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(1);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(2);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(3);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(4);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(5);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(6);
			cell.setCellStyle(style6); // 样式，居中
			cell = row.createCell(7);
			cell.setCellStyle(style6); // 样式，居中
			
	        
		 }
		}
		
		
		
		
	   HSSFRow row10 = sheet.createRow(14);
	   sheet.addMergedRegion(new Region(14, (short) 0, 14, (short) 2));
       sheet.addMergedRegion(new Region(14, (short) 3, 14, (short) 4));
       sheet.addMergedRegion(new Region(14, (short) 5, 14, (short) 6));
//       sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 1));
       HSSFCell ce13 = row10.createCell(0);      
       ce13.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
       ce13.setCellValue("项目主管:"+form.getYh_smanager()); // 表格的第一行第一列显示的数据   
       ce13.setCellStyle(style4); // 样式，居中
      
		
       HSSFCell ce14 = row10.createCell(3);      
       ce14.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
       ce14.setCellValue("领用人:"+form.getYh_sparman()); // 表格的第一行第一列显示的数据    
       ce14.setCellStyle(style4); // 样式，居中
       
       
       HSSFCell ce15 = row10.createCell(5);      
       ce15.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
       ce15.setCellValue("录入人:"+form.getYh_sdef6()); // 表格的第一行第一列显示的数据 
       ce15.setCellStyle(style4); // 样式，居中
      
		
       HSSFRow row11 = sheet.createRow(16);
       
    // 获得excel的最后一行  并设置该行的样式
       HSSFCellStyle style3 = workbook.createCellStyle(); // 样式对象       
//       style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直      
//       style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平      
       //生成一个字体
       HSSFFont font3=workbook.createFont();
       font3.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
       font3.setFontHeightInPoints((short)14);
       font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);         //字体增粗
      //把字体应用到当前的样式
       style3.setFont(font3);
       
       sheet.addMergedRegion(new Region(16, (short) 0, 16, (short) 7));
       HSSFCell ce16 = row11.createCell(0);      
       ce16.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
       ce16.setCellValue("第一联    财务处"); // 表格的第一行第一列显示的数据      
       ce16.setCellStyle(style3); // 
		
       
		HSSFRow row13 = sheet.createRow((short) 22);      
        
//      addMergedRegion(new Region(行, (short)列, 行, (short)列));

                
        sheet.addMergedRegion(new Region(22, (short) 0, 24, (short) 7));      
        HSSFCell ce11 = row13.createCell(0);      
        ce11.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        ce11.setCellValue("北京理工大学材料、元器件及低值品入库单"); // 表格的第一行第一列显示的数据      
        ce11.setCellStyle(style); // 样式，居中   
		
        HSSFRow row15 = sheet.createRow(26);
        sheet.addMergedRegion(new Region(26, (short) 0, 26, (short) 3));
        sheet.addMergedRegion(new Region(26, (short) 4, 26, (short) 6));
//        sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 1));
        HSSFCell cell5 = row15.createCell(0);      
        cell5.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        cell5.setCellValue("流水号:"+form.getYh_sdef8()); // 表格的第一行第一列显示的数据      
        cell5.setCellStyle(style4); // 样式，居中  
        
        HSSFCell cell6 = row15.createCell(4);      
        cell6.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
        cell6.setCellValue("单位名称:"+form.getYh_sdept()); // 表格的第一行第一列显示的数据      
        cell6.setCellStyle(style4); // 样式，居中  
        
		
		
		HSSFRow row16 = sheet.createRow(28);
						
		HSSFCell cel1 = row16.createCell(0);
		{
			cell=row16.createCell(0);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("编号");
			cell.setCellStyle(style1); // 样式，居中   
			cell = row16.createCell(1);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("品名"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row16.createCell(2);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("单位"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row16.createCell(3);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("单价(元)"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row16.createCell(4);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("数量"); // 填充字段名
			cell.setCellStyle(style1); // 样式，居中   
			cell = row16.createCell(5);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("总额(元)"); // 填充字段名			
			cell.setCellStyle(style1); // 样式，居中   
			cell=row16.createCell(6);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("发票号");
			cell.setCellStyle(style1); // 样式，居中   
			cell=row16.createCell(7);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue("经费卡号");
			cell.setCellStyle(style1); // 样式，居中   

		}
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				assets = (Asset) list.get(i);
				// 循环创建每一列
				row = sheet.createRow(i+29);

				cell = row.createCell(0);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_nid()); // 条形码
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(1);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sname());// 物品名称
				cell.setCellStyle(style5); // 样式，居中

				cell = row.createCell(2);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_splace()); // 单位
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(3);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dprice()); // 单价
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(4);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_quantity()); // 数量
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(5);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dtotal()); // 总额
				cell.setCellStyle(style5); // 样式，居中
								
				cell = row.createCell(6);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sbill()); // 发票号
				cell.setCellStyle(style5); // 样式，居中
				cell = row.createCell(7);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sfundsno()); //经费卡号 	
				cell.setCellStyle(style5); // 样式，居中
			}
		}
		
		if(6-list.size()>0){
			for (int i = 0; i <6-list.size(); i++) {
				row = sheet.createRow(i+29+list.size());	
				HSSFCellStyle style6 = workbook.createCellStyle(); // 样式对象    
				style6.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		        style6.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		        style6.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框
		        style6.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				cell = row.createCell(0);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(1);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(2);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(3);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(4);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(5);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(6);
				cell.setCellStyle(style6); // 样式，居中
				cell = row.createCell(7);
				cell.setCellStyle(style6); // 样式，居中
				
		        
			 }
			}
		
		
		
		
		  HSSFRow row23 = sheet.createRow(37);
	//      sheet.addMergedRegion(new Region(0, (short) 0, 1, (short) 1));
		  sheet.addMergedRegion(new Region(37, (short) 0, 37, (short) 2));
	      sheet.addMergedRegion(new Region(37, (short) 3, 37, (short) 4));
	      sheet.addMergedRegion(new Region(37, (short) 5, 37, (short) 6));
	      HSSFCell ce123 = row23.createCell(0);      
	      ce123.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
	      ce123.setCellValue("项目主管:"+form.getYh_smanager()); // 表格的第一行第一列显示的数据      	     
	      ce123.setCellStyle(style4); // 样式，居中  
			
	      HSSFCell ce118 = row23.createCell(3);      
	      ce118.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
	      ce118.setCellValue("领用人:"+form.getYh_sparman()); // 表格的第一行第一列显示的数据    	     
	      ce118.setCellStyle(style4); // 样式，居中  
			
	      HSSFCell ce119 = row23.createCell(5);      
	      ce119.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
	      ce119.setCellValue("录入人:"+form.getYh_sdef6()); // 表格的第一行第一列显示的数据    	      
	      ce119.setCellStyle(style4); // 样式，居中  
			
	      HSSFRow row24 = sheet.createRow(39);
	      sheet.addMergedRegion(new Region(39, (short) 0, 39, (short) 7));
	      HSSFCell ce120 = row24.createCell(0);      
	      ce120.setCellType(HSSFCell.CELL_TYPE_STRING);// 中文处理      
	      ce120.setCellValue("第二联    领用部门"); // 表格的第一行第一列显示的数据      
	      ce120.setCellStyle(style3); // 
		

		Assets assets = null;
		if (list.size() >= 1) {
			for (int i = 1; i <= list.size(); i++) {
				assets = (Assets) list.get(i - 1);
				// 循环创建每一列
				row = sheet.createRow(i);

				cell = row.createCell(0);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_scode()); // 条形码
				cell = row.createCell(1);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sname());// 物品名称

				cell = row.createCell(2);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_splace()); // 单位
				cell = row.createCell(3);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dprice()); // 单价
				cell = row.createCell(4);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_quantity()); // 数量
				cell = row.createCell(5);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_dtotal()); // 总额
								
				cell = row.createCell(8);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sbill()); // 发票号
				cell = row.createCell(9);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(assets.getYh_sfundsno()); //经费卡号 
				
			}

		}
	     
	      */
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			workbook.write(baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] ba = baos.toByteArray();
		bais = new ByteArrayInputStream(ba);
		return "bais";
	
	}

	public DeclareService getDeclareService() {
		return declareService;
	}

	public void setDeclareService(DeclareService declareService) {
		this.declareService = declareService;
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

	public DMZDivMoneyZForm getDmzForm() {
		return dmzForm;
	}

	public void setDmzForm(DMZDivMoneyZForm dmzForm) {
		this.dmzForm = dmzForm;
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

	public DMFDivMoneyF getDmf() {
		return dmf;
	}

	public void setDmf(DMFDivMoneyF dmf) {
		this.dmf = dmf;
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

	public InputStream getBais() {
		return bais;
	}

	public void setBais(InputStream bais) {
		this.bais = bais;
	}
	
}
