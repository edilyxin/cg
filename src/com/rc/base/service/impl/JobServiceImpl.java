package com.rc.base.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

import com.rc.base.dao.JobDAO;
import com.rc.base.form.MngJobForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.service.JobService;
import com.rc.base.vo.MngJob;
import com.rc.util.FileUtil;
import com.rc.util.ReadConfig;

public class JobServiceImpl implements JobService {
	 public static final long MAX_ROW_COUNT = 65000;
  
	private JobDAO jobDAO;

	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngJobForm form){
		return jobDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngJobForm form ){
		return jobDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngJobForm form){
		return jobDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngJob findByID(String id) {
		 
		return jobDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngJobForm form) {
		return jobDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return jobDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return jobDAO.changeValid(idchecked);	
	}
    /**
     * 
     *  @Description    : 岗位名称唯一性，遍历数据的所有岗位
     *  @Method_Name    : findAllSname
     *  @param form
     *  @return 
     *  @Creation Date  : 2013-6-3上午11:08:36 
     *  @version        : v1.00
     *  @Author         : Administrator
     */
	public List findAllSname(MngJobForm form) {
		// TODO Auto-generated method stub
		return jobDAO.findAllSname(form);
	}
	/**
	 * 
	 *  @Description    : 遍历所以岗位的级别
	 *  @Method_Name    : findNlevel
	 *  @param form
	 *  @return 
	 *  @Creation Date  : 2013-6-3上午11:09:24 
	 *  @version        : v1.00
	 *  @Author         : Administrator
	 */

	public List findNlevel(MngJobForm form) {
		// TODO Auto-generated method stub
		return jobDAO.findNlevel(form);
	}
	/**
	 * 导出岗位信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response){
		Date now =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateSign = sdf.format(now.getTime());
		String strFilePath = ReadConfig.getRealPath("download");       //临时写入路径
		//System.out.println("临时写入路径"+strFilePath);
		String strfileName = "岗位信息_"+dateSign+".xls";//文件名
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
		MngJob vo = null;
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
            String headerDetail = "岗位信息"+"("+dateSign+")";  //标题

			// **************往工作表中添加数据*****************
			// 1.添加Label对象
            ws1 = wwb.createSheet("岗位信息", 0);
            ws1.setHeader("岗位信息","","");
            ws1.setFooter("","","第   &P   页，共   &N   页");
           
            
            DecimalFormat currency = new DecimalFormat("###,##0.00"); 
            
            int i=0;//记录行
            if(list != null ){
            ws1.addCell(new Label(0,i,headerDetail,wcf1));
            ws1.mergeCells( 0 , i , 19 , i );
            ws1.setRowView(i,550);
            i++;
            //标题行格式设置
                     ws1.addCell(new Label(0, i, "所属单位",wcf2));
                     ws1.addCell(new Label(1, i, "岗位编号",wcf2));
                     ws1.addCell(new Label(2, i, "岗位名称",wcf2));
                     ws1.addCell(new Label(3, i, "岗位类别",wcf2));
                     ws1.addCell(new Label(4, i, "岗位级别",wcf2));
                     ws1.addCell(new Label(5, i, "住房面积数",wcf2));
                     ws1.addCell(new Label(6, i, "办公面积数",wcf2));
                     ws1.addCell(new Label(7, i, "房补金额数",wcf2));
                     ws1.addCell(new Label(8, i, "供暖补贴费",wcf2));
                     ws1.addCell(new Label(9, i, "是否启用",wcf2));
                     ws1.addCell(new Label(10, i, "描述",wcf2));
                     i++;
             int intSheetCount=1;   //为继续的Sheet所加序号
             for (Iterator it = list.iterator(); it.hasNext();) {
            	 if(i>=MAX_ROW_COUNT){
                     ws1 = wwb.createSheet("岗位信息"+"_继续"+String.valueOf(intSheetCount), intSheetCount);
                     intSheetCount++;    //SHEET加1
                     i=0;                //新SEET从第0行开始写
                 }
            	 if(i==0){
            		 //标题行格式设置
            		 ws1.addCell(new Label(0, i, "所属单位",wcf2));
                     ws1.addCell(new Label(1, i, "岗位编号",wcf2));
                     ws1.addCell(new Label(2, i, "岗位名称",wcf2));
                     ws1.addCell(new Label(3, i, "岗位类别",wcf2));
                    ws1.addCell(new Label(4, i, "岗位级别",wcf2));
                     ws1.addCell(new Label(5, i, "住房面积数",wcf2));
                     ws1.addCell(new Label(6, i, "办公面积数",wcf2));
                     ws1.addCell(new Label(7, i, "房补金额数",wcf2));
                     ws1.addCell(new Label(8, i, "供暖补贴费",wcf2));
                     ws1.addCell(new Label(9, i, "是否启用",wcf2));
                     ws1.addCell(new Label(10, i, "描述",wcf2));
                     i++;
            	 }
             	 vo = (MngJob) it.next();
                 ws1.addCell(new Label(0, i, vo.getUd_sname(),wcf));//所属单位
                 ws1.addCell(new Label(1, i, vo.getJob_sno(),wcf));//岗位编号
                 ws1.addCell(new Label(2, i, vo.getJob_sname(),wcf));//岗位名称
                 ws1.addCell(new Label(3, i, vo.getJob_stype(),wcf));//岗位类别
                 ws1.addCell(new Label(4, i, (vo.getJob_nlevel()).toString(),wcf));//岗位级别
                 ws1.addCell(new Label(5, i, vo.getJob_nresarea(),wcf));
                 //住房面积数
                ws1.addCell(new Label(6, i, vo.getJob_noffarea(),wcf));//办公面积数
                 ws1.addCell(new Label(7, i, vo.getJob_nhousmoney(),wcf));//房补金额数
                ws1.addCell(new Label(8, i, vo.getJob_nheatmoney(),wcf));//供暖补贴费
                 if(vo.getJob_sisvalid().equals("0")){
                	 
                	 ws1.addCell(new Label(9, i, "启用",wcf));//是否启用
                 }
                 else
                	 if(vo.getJob_sisvalid().equals("1")){
                	 ws1.addCell(new Label(9, i, "不启用",wcf));//是否启用
                 }
                 ws1.addCell(new Label(10, i, vo.getJob_smem(),wcf));//描述
                 
                 i++;
             }
            }

            
            ws1.setColumnView( 0, 15);//所属单位
            ws1.setColumnView( 1, 20);//岗位编号
            ws1.setColumnView( 2, 20);//岗位名称
            ws1.setColumnView( 3, 10);//岗位类别
           ws1.setColumnView( 4, 20);//岗位级别
            ws1.setColumnView( 5, 25);//住房面积数
            ws1.setColumnView( 6, 25);//办公面积数
            ws1.setColumnView( 7, 25);//房补金额数
            ws1.setColumnView( 8, 25);//供暖补贴费
            ws1.setColumnView( 9, 15);//是否启用
            ws1.setColumnView( 10, 25);//描述
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

	public List findUdSname(MngUnitDepartForm departForm) {
		// TODO Auto-generated method stub
		return jobDAO.findUdSname(departForm);
	}

	public Integer findMaxNLevel(String job_stype) {
		// TODO Auto-generated method stub
		return jobDAO.findMaxNLevel(job_stype);
	}

	public List findTreeList() {
		// TODO Auto-generated method stub
		return jobDAO.findTreeList();
	}
/**
 * 遍历出一级二级单位
 */
	public List findUD(MngUnitDepartForm departForm) {
		// TODO Auto-generated method stub
		return jobDAO.findUD(departForm);
	}

public List findAlljob() {
	// TODO Auto-generated method stub
	return jobDAO.findAlljob();
}

public boolean checkUnique(MngJobForm form) {
	// TODO Auto-generated method stub
	return jobDAO.checkUnique(form);
}

}
	
