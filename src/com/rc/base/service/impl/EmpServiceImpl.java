package com.rc.base.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
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

import com.rc.base.dao.EmpDAO;
import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngEmpUserForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.service.EmpService;
import com.rc.base.vo.MngEmp;
import com.rc.sys.form.MngUserForm;
import com.rc.util.FileUtil;
import com.rc.util.ReadConfig;
import com.rc.base.vo.MngSchool;
public class EmpServiceImpl implements EmpService {
  
	private EmpDAO empDAO;
	 public static final long MAX_ROW_COUNT = 65000;

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngEmpForm form){
		return empDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngEmpForm form ){
		List list= empDAO.findPage(form);
		for(int i=0;i<list.size();i++){ 
			if(!"".equals(((MngEmp)list.get(i)).getSh_sno())&&((MngEmp)list.get(i)).getSh_sno()!=null){
				String tNo = "'"+((MngEmp)list.get(i)).getSh_sno().trim().replaceAll(",", "','")+"'";
				List list1 = empDAO.toSchool(tNo);//根据id取出namelist
				String name = "";
				for(int j = 0;j<list1.size();j++){
					//name += ((MngEmp)list1.get(j)).getEmp_sname();
					if(j==list1.size()-1){
						name += ((MngSchool)list1.get(j)).getSh_sname();
					}else{
						name += ((MngSchool)list1.get(j)).getSh_sname()+",";
					}
					System.out.println(name);
				}
				((MngEmp)list.get(i)).setSh_sname(name);
			}
		
			
		}
		return list;
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngEmpForm form){
		return empDAO.save(form);
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngEmp findByID(String id) {
		 
		MngEmp vo= empDAO.findByID(id);
		if(!"".equals(vo.getSh_sno())&&(vo.getSh_sno()!=null)){
		String tNo = "'"+vo.getSh_sno().trim().replaceAll(",", "','")+"'";
		List list1 = empDAO.toSchool(tNo);//根据id取出namelist
		String name = "";
		for(int j = 0;j<list1.size();j++){
			//name += ((MngEmp)list1.get(j)).getEmp_sname();
			if(j==list1.size()-1){
				name += ((MngSchool)list1.get(j)).getSh_sname();
			}else{
				name += ((MngSchool)list1.get(j)).getSh_sname()+",";
			}
			System.out.println(name);
		}
		vo.setSh_sname(name);
	}
		

	 	return vo;
		
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngEmpForm form) {
		return empDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return empDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return empDAO.changeValid(idchecked);	
	}

 
 
	/**
	 * 导出职工信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response){
		Date now =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateSign = sdf.format(now.getTime());
		String strFilePath = ReadConfig.getRealPath("download");       //临时写入路径
		//System.out.println("临时写入路径"+strFilePath);
		String strfileName = "职工信息_"+dateSign+".xls";//文件名
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
		MngEmp vo = null;
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
            String headerDetail = "职工信息"+"("+dateSign+")";  //标题

			// **************往工作表中添加数据*****************
			// 1.添加Label对象
            ws1 = wwb.createSheet("职工信息", 0);
            ws1.setHeader("职工信息","","");
            ws1.setFooter("","","第   &P   页，共   &N   页");
           
            
            DecimalFormat currency = new DecimalFormat("###,##0.00"); 
            
            int i=0;//记录行
            if(list != null ){
            ws1.addCell(new Label(0,i,headerDetail,wcf1));
            ws1.mergeCells( 0 , i , 16 , i );
            ws1.setRowView(i,550);
            i++;
            //标题行格式设置
            ws1.addCell(new Label(0, i, "所属校区",wcf2));
            ws1.addCell(new Label(1, i, "所属单位;",wcf2));
            ws1.addCell(new Label(2, i, "员工编号",wcf2));
            ws1.addCell(new Label(3, i, "员工姓名",wcf2));
            ws1.addCell(new Label(4, i, "员工英文名",wcf2));
            ws1.addCell(new Label(5, i, "性别",wcf2));
            ws1.addCell(new Label(6, i, "学历",wcf2));
            ws1.addCell(new Label(7, i, "手机号码",wcf2));
            ws1.addCell(new Label(8, i, "电话内线",wcf2));
            ws1.addCell(new Label(9, i, "电话外线",wcf2));
            ws1.addCell(new Label(10, i, "传真号码",wcf2));
            ws1.addCell(new Label(11, i, "电子邮箱",wcf2));
            ws1.addCell(new Label(12, i, "职务",wcf2));
            ws1.addCell(new Label(13, i, "职称",wcf2));
            ws1.addCell(new Label(14, i, "职级",wcf2));
            ws1.addCell(new Label(15, i, "状态",wcf2));
            ws1.addCell(new Label(16, i, "是否启用",wcf2));
                    i++;
             int intSheetCount=1;   //为继续的Sheet所加序号
             for (Iterator it = list.iterator(); it.hasNext();) {
            	 if(i>=MAX_ROW_COUNT){
                     ws1 = wwb.createSheet("职工信息"+"_继续"+String.valueOf(intSheetCount), intSheetCount);
                     intSheetCount++;    //SHEET加1
                     i=0;                //新SEET从第0行开始写
                 }
            	 if(i==0){
            		 //标题行格式设置
            		 ws1.addCell(new Label(0, i, "所属校区",wcf2));
                     ws1.addCell(new Label(1, i, "所属单位名称;",wcf2));
                     ws1.addCell(new Label(2, i, "员工编号",wcf2));
                     ws1.addCell(new Label(3, i, "员工姓名",wcf2));
                     ws1.addCell(new Label(4, i, "员工英文名",wcf2));
                     ws1.addCell(new Label(5, i, "性别",wcf2));
                     ws1.addCell(new Label(6, i, "学历",wcf2));
                     ws1.addCell(new Label(7, i, "手机号码",wcf2));
                     ws1.addCell(new Label(8, i, "电话内线",wcf2));
                     ws1.addCell(new Label(9, i, "电话外线",wcf2));
                     ws1.addCell(new Label(10, i, "传真号码",wcf2));
                     ws1.addCell(new Label(11, i, "电子邮箱",wcf2));
                     ws1.addCell(new Label(12, i, "职务",wcf2));
                     ws1.addCell(new Label(13, i, "职称",wcf2));
                     ws1.addCell(new Label(14, i, "职级",wcf2));
                     ws1.addCell(new Label(15, i, "状态",wcf2));
                     ws1.addCell(new Label(16, i, "是否启用",wcf2));
                     i++;
            	 }
             	 vo = (MngEmp)it.next();
                 ws1.addCell(new Label(0, i,vo.getEmp_sno() ,wcf));//所属校区
                 ws1.addCell(new Label(1, i,vo.getUd_sno(),wcf));	//所属单位名称;
                 ws1.addCell(new Label(2, i,vo.getEmp_sno() ,wcf));//员工编号
                 ws1.addCell(new Label(3, i,vo.getEmp_sname() ,wcf));//员工姓名
                 ws1.addCell(new Label(4, i,vo.getEmp_sename() ,wcf));//员工英文名
                 ws1.addCell(new Label(5, i,vo.getEmp_sgender() ,wcf));//性别
                 ws1.addCell(new Label(6, i,vo.getEmp_sstype(),wcf));//学历
                 ws1.addCell(new Label(7, i,vo.getEmp_stele() ,wcf));//手机号码
                 ws1.addCell(new Label(8, i, vo.getEmp_steleinner(),wcf));//电话内线
                 ws1.addCell(new Label(9, i, vo.getEmp_steleout(),wcf));//电话外线
                 ws1.addCell(new Label(10, i, vo.getEmp_sfax(),wcf));//传真号码
                 ws1.addCell(new Label(11, i, vo.getEmp_semail(),wcf));//电子邮箱
                 ws1.addCell(new Label(12, i, vo.getJob_sno(),wcf));//职务
                 ws1.addCell(new Label(13, i, vo.getPost_sno(),wcf));//职称
                 ws1.addCell(new Label(14, i, vo.getEmp_nlevel(),wcf));//职级
                 ws1.addCell(new Label(15, i, vo.getEmp_nstate().toString(),wcf));//状态
                 ws1.addCell(new Label(16, i, vo.getEmp_sisvalid(),wcf));//是否启用
                
                 i++;
             }
            }

            
            ws1.setColumnView( 0, 20);//所属校区
            ws1.setColumnView( 1, 20);//所属单位名称;
            ws1.setColumnView( 2, 15);//员工编号
            ws1.setColumnView( 3, 20);//员工姓名
            ws1.setColumnView( 4, 20);//员工英文名
            ws1.setColumnView( 5, 10);//性别
            ws1.setColumnView( 6, 10);//学历
            ws1.setColumnView( 7, 25);//手机号码
            ws1.setColumnView( 8, 20);//电话内线
            ws1.setColumnView( 9, 20);//电话外线
            ws1.setColumnView( 10, 20);//传真号码
            ws1.setColumnView( 11, 50);//电子邮箱
            ws1.setColumnView( 12, 15);//职务
            ws1.setColumnView( 13, 15);//职称
            ws1.setColumnView( 14, 20);//职级
            ws1.setColumnView( 15, 20);//状态
            ws1.setColumnView( 16, 10);//是否启用
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
	 * 新增用户
	 */
	  public String adduser(MngUserForm userform) {
		// TODO Auto-generated method stub
		   return empDAO.adduser(userform);
	  }
	 
	  /**
	     * 新增用户职工1
	     * @param form
	     * @return
	     */
	    public boolean saveEuser(MngEmpUserForm form){
			return empDAO.saveEuser(form);
	    }
	  
	  
	     
		/**
		 * 查询职工用户对照记录条数
		 */
		public Integer empuserfindsize(MngEmpForm form) {
			// TODO Auto-generated method stub
			return empDAO.empuserfindsize(form);
		}
		/**
		 * 查询职工用户对照
		 */
		public List empuserfindpage(MngEmpForm form) {
			// TODO Auto-generated method stub
			return empDAO.empuserfindpage(form);
		}
		
		/**
		 * 批量删除职工用户
		 * @param idchecked
		 * @return
		 */
		public boolean deleteuseremp(String[] idchecked){
			return empDAO.deleteuseremp(idchecked);
			
		}
		
		
		
		
		
		/**
		 * 保存用户职工对照表	
		 * @throws SQLException 
		 */
		public boolean saveempuser(MngEmpUserForm form1)  {
			return empDAO.saveempuser(form1);
		}

		
		
		
		
		public List empuseempuserfind1(MngEmpUserForm form1) {
			// TODO Auto-generated method stub
			return empDAO.empuseempuserfind1(form1);
		}
		/**
		 * 遍历所有单位
		 */
		public List udlist(MngUnitDepartForm udform) {
			// TODO Auto-generated method stub
			return empDAO.udlist(udform);
		}
		/**
		 * 根据隶属单位编号查询所属单位
		 */

		public List udliststopno(MngUnitDepartForm udform) {
			// TODO Auto-generated method stub
			return  empDAO.udliststopno(udform);
		}
			/**
			 * 查询最低层数
			 */
		public Integer levels() {
			// TODO Auto-generated method stub
			return empDAO.levels();
		}
 

}
	
