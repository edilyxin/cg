package com.rc.base.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.format.PageOrientation;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import com.rc.base.dao.UnitDepartDAO;
import com.rc.base.form.MngSchoolDepartForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.service.UnitDepartService;
import com.rc.base.vo.MngUnitDepart;
import com.rc.sys.service.SequenceService;
import com.rc.util.FileUtil;
import com.rc.util.ReadConfig;
import com.rc.util.UserInfo;

public class UnitDepartServiceImpl implements UnitDepartService {
    public static final long MAX_ROW_COUNT = 65000;
	private UnitDepartDAO unitDepartDAO;

	public void setUnitDepartDAO(UnitDepartDAO unitDepartDAO) {
		this.unitDepartDAO = unitDepartDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngUnitDepartForm form){
		return unitDepartDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngUnitDepartForm form ){
		return unitDepartDAO.findPage(form);
	}

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngUnitDepartForm form){
		try {
			return unitDepartDAO.save(form);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngUnitDepart findByID(String id) {
		 
		return unitDepartDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngUnitDepartForm form) {
		try {
			return unitDepartDAO.update(form);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		boolean bl = false;
		if (idchecked != null && idchecked.length > 0) {
			bl = unitDepartDAO.delete(idchecked);
		}
		return bl;
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		boolean bl = false;
		if (idchecked != null && idchecked.length > 0) {
			bl = unitDepartDAO.changeValid(idchecked);
		}
		return bl;
	}
	
	/**
	 * 查询单位部门信息
	 * @return
	 */
	public List findAll() {
		return unitDepartDAO.findAll();
	}
	
	/**
	 * 检查同一上级单位下，单位名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean checkUni(MngUnitDepartForm form) {
		return unitDepartDAO.checkUni(form);
	}

	
	/**
	 * 查询单位部门菜单树列表
	 * @return
	 */
	public List findTreeList() {
		return unitDepartDAO.findTreeList();
	}

    //XXX 导出的实例	
	/**
	 * 导出单位部门信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response){
		Date now =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateSign = sdf.format(now.getTime());
		String strFilePath = ReadConfig.getRealPath("download");       //临时写入路径
		//System.out.println("临时写入路径"+strFilePath);
		String strfileName = "单位部门信息_"+dateSign+".xls";//文件名
//		若没有则创建文件夹
        File filePath = new File(strFilePath);
        if(!filePath.exists()){
                filePath.mkdirs();
        }
        FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(strFilePath+strfileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        if(writeExcel(out, list)){
            try {
        		FileUtil.download(strfileName, strfileName, "download", response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return;
	}
	
	public boolean writeExcel(OutputStream os, List list ) {
        //System.out.println("性能调试  writeExcel() 的开始" );
		WritableWorkbook wwb = null;
		WritableSheet ws1 = null;  //第一页
        //页初始化
		boolean result = false;
		MngUnitDepart vo = null;
		try {
			/**
			 * 只能通过API提供的工厂方法来创建Workbook，而不能使用WritableWorkbook的构造函数， 因为类WritableWorkbook的构造函数为protected类型
			 * method(1)直接从目标文件中读取WritableWorkbook wwb = Workbook.createWorkbook(new File(targetfile)); method(2)如下实例所示
			 * 将WritableWorkbook直接写入到输出流
			 */
            //定义数字格式
			NumberFormat nf = new NumberFormat("###,##0.00");
			WritableCellFormat wcfN = new WritableCellFormat(nf);
			wcfN.setAlignment(jxl.format.Alignment.RIGHT); 
			wcfN.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

             //定义数字格式不带小数
			NumberFormat nf1 = new NumberFormat("###,##0");
			WritableCellFormat wcfN1 = new WritableCellFormat(nf1);
			wcfN1.setAlignment(jxl.format.Alignment.RIGHT);        // 设置对齐方式
			wcfN1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcfN1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            
            WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
                                              jxl.format.Colour.BLACK); // 定义格式 字体 斜体 粗体 下划线  颜色

            WritableCellFormat wcf = new WritableCellFormat(wf);  // 单元格定义
            wcf.setAlignment(jxl.format.Alignment.CENTRE);        // 设置对齐方式
            wcf.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcf.setWrap(true);// 自动换行

           
            //底色为黄色
            WritableCellFormat wcfyellow = new WritableCellFormat(wf);  // 单元格定义
            wcfyellow.setBackground(jxl.format.Colour.YELLOW);       // 设置单元格的背景颜色
            wcfyellow.setAlignment(jxl.format.Alignment.CENTRE);        // 设置对齐方式
            wcfyellow.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcfyellow.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

            //表名加粗无底色
            WritableFont wf1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
                                              jxl.format.Colour.BLACK); // 定义格式 字体 斜体 粗体 下划线  颜色

            WritableCellFormat wcf1 = new WritableCellFormat(wf1);  // 单元格定义
            wcf1.setAlignment(jxl.format.Alignment.CENTRE);        // 设置对齐方式
            wcf1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            //单元格格式：标题加粗有底色
            WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
                                              jxl.format.Colour.BLACK); // 定义格式 字体 斜体 粗体 下划线  颜色
            WritableCellFormat wcf2 = new WritableCellFormat(wf2);  // 单元格定义
            wcf2.setBackground(jxl.format.Colour.PALE_BLUE);       // 设置单元格的背景颜色
            wcf2.setAlignment(jxl.format.Alignment.CENTRE);        // 设置对齐方式
            wcf2.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

            //单元格无边框
            WritableFont wf3 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
                                              jxl.format.Colour.BLACK); // 定义格式 字体 斜体 粗体 下划线  颜色

            WritableCellFormat wcf3 = new WritableCellFormat(wf3);  // 单元格定义
            wcf3.setAlignment(jxl.format.Alignment.LEFT);        // 设置对齐方式
            wcf3.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);



            //为合并单元格加右边框，属性定义
            WritableFont wfB = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
                                              jxl.format.Colour.BLACK); // 定义格式 字体 斜体 粗体 下划线  颜色
            WritableCellFormat wcfB = new WritableCellFormat(wfB);
            wcfB.setBorder(jxl.format.Border.LEFT, jxl.format.BorderLineStyle.THIN);

			// 创建Excel工作表 指定名称和位置
			wwb = Workbook.createWorkbook(os);
         
            //制表时间
            Date now =new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateSign = sdf.format(now.getTime());
            String headerDetail = "单位部门信息"+"("+dateSign+")";  //标题

			// **************往工作表中添加数据*****************
			// 1.添加Label对象
            ws1 = wwb.createSheet("单位部门信息", 0);
            ws1.setHeader("单位部门信息","","");
            ws1.setFooter("","","第   &P   页，共   &N   页");
           
            
            DecimalFormat currency = new DecimalFormat("###,##0.00"); 
            
            int i=0;//记录行
            if(list != null ){
            ws1.addCell(new Label(0,i,headerDetail,wcf1));
            ws1.mergeCells( 0 , i , 19 , i );
            ws1.setRowView(i,550);
            i++;
            //标题行格式设置
            String[] titles = {
            		"单位编号", "单位名称", "单位简称", "隶属层次", "隶属单位",
            		"单位层次", "隶属市级部门", "原单位名称", "单位类型", "资产规模",
            		"资质等级", "法人代表", "地址", "负责人", "联系人",
            		"电话", "单位邮箱", "同步信息", "是否定编", "是否启用"
            };
            for (int index = 0; index < titles.length; index++) {
            	ws1.addCell(new Label(index, i, titles[index], wcf2));
            } 
            i++;
            int intSheetCount=1;   //为继续的Sheet所加序号
            for (Iterator it = list.iterator(); it.hasNext();) {
            	 if(i>=MAX_ROW_COUNT){
                     ws1 = wwb.createSheet("单位部门信息"+"_继续"+String.valueOf(intSheetCount), intSheetCount);
                     intSheetCount++;    //SHEET加1
                     i=0;                //新SEET从第0行开始写
                 }
            	 if(i==0){
            		 //标题行格式设置
            		 for (int idx = 0; idx < titles.length; idx++) {
            			 ws1.addCell(new Label(idx, i, titles[idx], wcf2));
            		 }
                     i++;
            	 }
             	 vo = (MngUnitDepart) it.next();
             	 String ud_stop = vo.getUd_stop();	//隶属层次 (隶属单位的层次)
             	 String ud_nnumber = Long.toString(vo.getUd_nnumber());	//单位层次：1学校2学部3学院4系
             	 String ud_nistrue = Long.toString(vo.getUd_nistrue());	//是否定编, 0是, 1否
             	 String ud_sisvalid = vo.getUd_sisvalid();	//是否启用：0-启用；1-不启用
             	 if ("1".equals(ud_stop)) {
             		 ud_stop = "学校";
             	 } else if ("2".equals(ud_stop)) {
             		 ud_stop = "学部";
             	 } else if ("3".equals(ud_stop)) {
             		 ud_stop = "学院"; 
             	 } else if ("4".equals(ud_stop)) {
             		 ud_stop = "系";
             	 }
             	 if ("1".equals(ud_nnumber)) {
             		 ud_nnumber = "学校";
             	 } else if ("2".equals(ud_nnumber)) {
             		 ud_nnumber = "学部";
             	 } else if ("3".equals(ud_nnumber)) {
             		 ud_nnumber = "学院"; 
             	 } else if ("4".equals(ud_nnumber)) {
             		 ud_nnumber = "系";
             	 }
             	 if ("0".equals(ud_nistrue)) {
             		ud_nistrue = "是";
             	 } else if ("1".equals(ud_nistrue)) {
             		ud_nistrue = "否";
             	 }
             	 if ("0".equals(ud_sisvalid)) {
             		 ud_sisvalid = "启用";
             	 } else if ("1".equals(ud_sisvalid)) {
             		 ud_sisvalid = "不启用";
             	 }
             	 Object[] content = {
             			 //单位编号，单位名称，单位简称，隶属层次，隶属单位
             			 vo.getUd_sno(), vo.getUd_sname(), vo.getUd_ssname(), ud_stop, vo.getUd_stopno(),
             			 
             			 //单位层次，隶属市级部门，原单位名称，单位类型，资产规模
             			 ud_nnumber, vo.getUd_smunidep(), vo.getUd_soldname(), vo.getUd_stype(), vo.getUd_sassetsize(),
             			 
             			 //资质等级，法人代表，地址，负责人，联系人
             			 vo.getUd_saptitude(), vo.getUd_slegalman(), vo.getUd_saddr(), vo.getUd_swheelman(), vo.getUd_slinkman(),
             			 
             			 //电话，单位邮箱，同步信息，是否定编，是否启用
             			 vo.getUd_stele(), vo.getUd_smail(), vo.getUd_ssynchro(), ud_nistrue, ud_sisvalid
             	 };
             	 for (int n = 0; n < content.length; n++) {
             		ws1.addCell(new Label(n, i, (content[n] == null) ? "" : content[n].toString(), wcf));
             	 }
                 i++;
             }
            }
            ws1.setColumnView( 0, 15);//单位编号
            ws1.setColumnView( 1, 20);//单位名称
            ws1.setColumnView( 2, 20);//单位简称
            ws1.setColumnView( 3, 10);//隶属层次
            ws1.setColumnView( 4, 20);//隶属单位
            ws1.setColumnView( 5, 10);//单位层次
            ws1.setColumnView( 6, 20);//隶属市级部门  
            ws1.setColumnView( 7, 25);//原单位名称
            ws1.setColumnView( 8, 10);//单位类型
            ws1.setColumnView( 9, 10);//资质规模
            ws1.setColumnView( 10, 10);//资质等级
            ws1.setColumnView( 11, 15);//法人代表
            ws1.setColumnView( 12, 25);//地址
            ws1.setColumnView( 13, 15);//负责人
            ws1.setColumnView( 14, 15);//联系人
            ws1.setColumnView( 15, 20);//电话
            ws1.setColumnView( 16, 20);//单位邮箱
            ws1.setColumnView( 17, 20);//同步信息
            ws1.setColumnView( 18, 10);//是否定编
            ws1.setColumnView( 19, 10);//是否启用
            ws1.getSettings().setPrintTitlesRow(0,1);    //分页打印保留1,2行标题
            ws1.getSettings().setHorizontalCentre (true);//打印设置:水平居中
            ws1.getSettings().setOrientation(PageOrientation.LANDSCAPE); //横向打印
            ws1.getSettings().setScaleFactor (72);  //72%缩放打印,为表名单元格提供右边框的单元格占了一部分
			// 写入工作表
			wwb.write();
			result = true;
		}
		catch (Exception e) {
			result = false;
			e.printStackTrace();

		}
		finally {
			if (wwb != null)
				try {
					wwb.close();
				}
				catch (WriteException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}

		}
		return result;
	}
	
	/**
	 * 根据单位层次查询可用隶属单位列表
	 */
	public List findTopList(Long ud_nnumber) {
		return unitDepartDAO.findTopList(ud_nnumber);
	}
	
	/**
	 * 保存单位校区对照信息
	 * @param sdForm
	 * @param arrSchoolNO
	 */
	public void saveSchool(MngSchoolDepartForm sdForm, String[] arrSchoolNO) {
		unitDepartDAO.saveSchool(sdForm, arrSchoolNO);
	}
	
	/**
	 * 根据单位编号查询所对应校区
	 * @param sdForm
	 * @return
	 */
	public List findByUDNo(MngSchoolDepartForm sdForm) {
		return unitDepartDAO.findByUDNo(sdForm);
	}
	
	/**
	 * 通用编码生成器
	 * @param level 级别
	 * @param len 相邻级别之间编码长度之差
	 * @param topNO 上级编码
	 * @return 编码
	 */
	public String getNO(int level, int len, String topNO, SequenceService sequenceService, UserInfo userInfo) {
		String no = null;
		StringBuffer sb = new StringBuffer();
		String tmp = null;
		if ("".equals(topNO)) {
			tmp = sequenceService.getNO(userInfo.getSysint_sno(), "1", "ud_sno");
		} else {
			tmp = topNO;
		}
		if (level == 1) {
			//获取级别为1的记录的条数
			//int count = getLevel(1, null);
			sb.append(tmp);
		} else if (level > 1){
			int count = getLevel(level, topNO);
			sb.append(tmp).append(getSameChar(getDlt(len, count), "0")).append(count + 1);
		}
		if (sb.length() != 0) {
			no = sb.toString();
		}
		return no;
	}
	
	/*public static void main(String[] args) {
		UnitDepartServiceImpl dept = new UnitDepartServiceImpl();
		int count = 96, len = 5;
		String str = "D" + dept.getSameChar(dept.getDlt(len, count), "0");
		System.out.println(str + "\t" + (count + 1));
	}*/
	
	/**
	 * 生成编码前缀中的0
	 * @param len
	 * @param chs 
	 * @return
	 */
	private String getSameChar(int len, String chs) {
		String prefix = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			sb.append(chs);
		}
		if (sb.length() != 0) {
			prefix = sb.toString();
		}
		return prefix;
	}
	
	/**
	 * 获取偏移量
	 * @param len
	 * @param count
	 * @return
	 */
	private int getDlt(int len, int count) {
		int dlt = 0;
		int[] arr = getNum(len);
		for (int i = 0; i < arr.length; i++) {
			if (count < arr[i]) {
				dlt = len - (i + 1);
				break;
			}
		}
		return dlt;
	}
	
	/**
	 * 获取边界数
	 * @param len
	 * @return
	 */
	private int[] getNum(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(getSameChar((i + 1), "9"));
		}
		return arr;
	}
	
	/**
	 * 获取指定编码、指定级别的记录条数
	 * @param level
	 * @param no
	 * @return
	 */
	private int getLevel(int level, String no) {
		Integer count = unitDepartDAO.findByLevel(level, no);
		int size = 0;
		if (count != null) {
			size = count.intValue();
		}
		return size;
	}
	
	/**
	 * 查询是否有单位层次为学校的记录
	 * @param ud_nnumber 
	 * @return
	 */
	public boolean canAddSchool() {
		return unitDepartDAO.canAddSchool();
	}
	
	/**
	 * 根据部门编号判断该部门是否有下级
	 * @param no
	 * @return true有下级，false没下级
	 */
	public boolean hasSub(String no) {
		return unitDepartDAO.hasSub(no);
	}
}
	
