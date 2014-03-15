package com.rc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rc.sys.dao.LoginDAO;

public class FileUtil {
	
	
	/**
	 * 文件下载方法
	 * @param downloadfileName 下载显示的文件名ID
	 * @param strfileNameLOCK  服务器上文件名ID
	 * @param pathID		服务器上文件路径ID
	 * @param response		服务器响应
	 * @throws IOException
	 */
	public static void download(String downloadfileName, String strfileName,String pathID, HttpServletResponse response) throws IOException  {
  		InputStream inStream = null;
  		ServletOutputStream out = null;
  		try {
  			
  	        String filePath = ReadConfig.getRealPath(pathID);
  	        //System.out.println(filePath);
  			//final String CONTENT_TYPE = "text/html; charset=UTF-8";
  			//String pathsavefile;// 要下载的文件
            downloadfileName = URLDecoder.decode(downloadfileName, "UTF-8");      //流文件名转换，保证流输入能找到服务器端缓存文件
            strfileName = URLDecoder.decode(strfileName, "UTF-8");      //流文件名转换，保证流输入能找到服务器端缓存文件
//            fileName = URLEncoder.encode(fileName, "GBK");      //解决下载文件名乱码问题
  			response.reset();
  			response.setContentType("APPLICATION/OCTET-STREAM");
  			response.setHeader("Content-Disposition", "attachment; filename=\"" +URLEncoder.encode(downloadfileName, "UTF-8") + "\"");
  			out = response.getOutputStream();                                    //↑↑↑下载文件名乱码，需要转换
  			inStream = new FileInputStream(filePath + strfileName);
  			// 循环取出流中的数据

  			byte[] b = new byte[1024];
  			int len;
  			while ((len = inStream.read(b)) > 0)
  				out.write(b, 0, len);

  		}
  		catch (Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			if(out!=null){
  					out.flush();
					out.close();
  			}
  			if (inStream != null)
					inStream.close();
  		}
  		return;
  	}
	/**
	 * 文件下载方法
	 * @param filename1 完整的路径
	 * @param filename2文件名
	 * @param response		服务器响应
	 * @throws IOException
	 */
	public static void myDownload(String filename1,String filename2, HttpServletResponse response)throws IOException {
		InputStream inStream = null;
  		ServletOutputStream out = null;
  		try{
  		response.setContentType("APPLICATION/OCTET-STREAM");
		//注意：字符'\'的正则表达式写法为"\\\\"
  		if("".equals(filename2) || filename2 == ""){
  			String tNo = filename1.trim().replaceAll("\\\\", ",");
		//System.out.println(tNo+"=tNo");
  			String[] fileDowmName = tNo.split(",");
  			String filename12 = URLDecoder.decode(fileDowmName[fileDowmName.length-1], "UTF-8"); 
  			response.setHeader("Content-Disposition", "attachment; filename=\"" +URLEncoder.encode(filename12, "UTF-8") + "\"");
  		}else{
  			String filename12 = URLDecoder.decode(filename2, "UTF-8"); 
  			response.setHeader("Content-Disposition", "attachment; filename=\"" +URLEncoder.encode(filename12, "UTF-8") + "\"");
  		}
			out = response.getOutputStream();                                    //↑↑↑下载文件名乱码，需要转换
			inStream = new FileInputStream(filename1);
			// 循环取出流中的数据

			byte[] b = new byte[1024];
			int len;
			while ((len = inStream.read(b)) > 0)
				out.write(b, 0, len);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(out!=null){
					out.flush();
				out.close();
			}
			if (inStream != null)
				inStream.close();
		}
	}
	
	public void upload(){
//		try{
//			 //request.setCharacterEncoding("GBK");
//			//取session 用户oid
//			    int pid = userInfo.getUserId();
//			    String sys_user_id = String.valueOf(pid);
//			//取init配置文件的参数值
//			 String sitePhysicalPath = (String)init.getObject("SitePhysicalPath");
//			 String saveDir  = (String)init.getObject("InfoUploadDir");
//			 String tempDir  = (String)init.getObject("InfoUploadDir");
//			 String fileMemo = "";    //文件说明
//			 String fileName = null;  //存储到数据库的文件名
//			 String saveName = null;  //存储到本地的文件名
//			 String filePath = null;  //存储到本地的文件路径
//			 String savePath = null;  //存储到数据库的文件路径
//			 long   fileSize = 0;     //文件大小
//			 int maxPostSize = -1;    
//			 int dinfo_upload_id = -1;
//			 DiskFileUpload df = new DiskFileUpload();
//			    //设定上传文件大小
//			 df.setSizeMax(maxPostSize);
//			 //设定临时目录
//			 df.setRepositoryPath(sitePhysicalPath + tempDir);
//			    //取得request信息
//			 List items = df.parseRequest(request);
//			    
//			 Iterator iter = items.iterator();
//			    
//			 int temp = 0;
//			 FileItem tempItem = null;
//
//			 while(iter.hasNext()){
//			  temp++;
//			  FileItem item = (FileItem)iter.next();
//			  if(item.isFormField())    //取得文件说明信息
//			  {
//			   fileMemo = item.getString("GBK");
//			   
//			  }
//			  else
//			  {   //取得上传文件信息
//			   fileName = (String)item.getName();
//			   try{
//			    fileName = fileName.substring(fileName.lastIndexOf("//")+1);
//			    fileName = fileName.substring(fileName.lastIndexOf("/")+1);
//			   }catch(Exception e){
//			    System.out.println(e);
//			   }
//			   fileSize = item.getSize();
//			   tempItem = item;
//			  }
//
//			  if(temp == 2 && fileSize != 0)
//			   {    //每两个iter存储一个上传文件
//
//			             //得到info_title_id
//			              String SQL_ID="select S_INFO_UPLOAD.nextval as seqid from dual";
//			           try {
//			                java.sql.Statement stmt = con.createStatement();
//			                java.sql.ResultSet rst= stmt.executeQuery(SQL_ID);
//			                while(rst.next()) 
//			       {
//			                       dinfo_upload_id = rst.getInt("seqid");
//			                }
//
//			             }catch(SQLException e1){
//			                    return;
//			             }
//			            //取得文件扩展名
//			            try{
//			    saveName = fileName.substring(fileName.lastIndexOf("."));
//			   }catch(Exception exc){
//			    saveName = "";
//			   }
//
//			            filePath = sitePhysicalPath + saveDir + Integer.toString(dinfo_upload_id) + saveName;
//			            //存储文件
//			   java.io.File uploadFile = new java.io.File(filePath);
//			   tempItem.write(uploadFile);
			   
			   
			   /*try{
			       FileOutputStream fos = new FileOutputStream(filePath);
			       InputStream is = tempItem.getInputStream();
			       byte[] b = new byte[1024];
			       int nRead;
			       long per = 0;
			       double percent = 0;
			                while((nRead = is.read(b, 0, 1024))>0){
			        fos.write(b, 0, nRead);
			        per += nRead;
			        percent = (double)per/fileSize;

			        session.setAttribute("percent",Double.toString(percent).substring(2,4));
			        session.setAttribute("filename",fileName);
			                }
			       is.close();
			    fos.close();    
			    }catch(Exception e){
			     System.out.println(e);
			    }*/
//			            savePath = saveDir + Integer.toString(dinfo_upload_id) + saveName;
			            /*/存储数据库
			            String sql = " INSERT INTO info_upload (info_upload_id,sys_user_id,file_name,file_memo,file_size,file_path,utime,deleted) "
			              + " VALUES( " + Integer.toString(dinfo_upload_id) + "," + sys_user_id + ",'" + fileName + "','" + fileMemo + "'," + fileSize + ",'" + savePath + "', SYSDATE , 0 )" ;
			   sqlcmd cmd = new sqlcmd(con,sql);
			   */
//			            String sql = " INSERT INTO info_upload (info_upload_id,sys_user_id,file_size,file_path,utime,deleted) "
//			              + " VALUES( " + Integer.toString(dinfo_upload_id) + "," + sys_user_id + "," + fileSize + ",'" + savePath + "', SYSDATE , 0 )" ;
//			   sqlcmd cmd = new sqlcmd(con,sql);
//			            //System.out.println(sql);
//			   java.sql.PreparedStatement pstmt = null;
//			   java.sql.Statement stmt = null;
//			   //fileName = fileName.substring(0, fileName.indexOf("."));
//			   String sql_cn = " UPDATE info_upload SET file_name=?,file_memo=? WHERE info_upload_id=? ";
//			   
//			   java.io.ByteArrayInputStream bais_name = new java.io.ByteArrayInputStream(fileName.getBytes("ISO-8859-1"));
//			   java.io.InputStreamReader isr_name = new java.io.InputStreamReader((InputStream)bais_name,"GBK");
//
//			   java.io.ByteArrayInputStream bais_memo = new java.io.ByteArrayInputStream(fileMemo.getBytes("GBK"));
//			   java.io.InputStreamReader isr_memo = new java.io.InputStreamReader((InputStream)bais_memo,"GBK");
//			   
//			   try{
//			    stmt = con.createStatement();
//			    stmt.getConnection().setAutoCommit(false);
//
//			    pstmt = con.prepareStatement(sql_cn);
//			    pstmt.setCharacterStream(1, isr_name, fileName.length());
//			    pstmt.setCharacterStream(2, isr_memo, fileMemo.length());
//			    pstmt.setInt(3, dinfo_upload_id);
//
//			                //System.out.println(sql_cn);
//
//			    pstmt.execute();
//			    stmt.executeUpdate("COMMIT");
//
//			   }catch(Exception exce){
//			    System.out.println(exce);
//			    stmt.executeUpdate("ROLLBACK");
//			   }
//
//			   temp = 0;
//			  }
//			  else if (temp == 2 && fileSize == 0) {temp = 0;} 
//
//			 }
//			    //session.setAttribute("percent","ok");
//			}catch(Exception ex){
//			 System.out.println(ex);
//			}
//			response.sendRedirect("list.jsp");

	}
	
	/**
	 * 判断是否不为空
	 * @param str
	 * @return
	 */
	public static boolean checkNotNull(Object str){
		if(str instanceof Cell){ 
			return str==null?false:((Cell)str).getContents().trim().equals("")?false:true;
		}else{
			return str==null||str.toString().trim().equals("")?false:true;
		}
		
	}
	
	/**
	 * 验证行是否全空
	 * @param sh 表单
	 * @param column 列数
	 * @param row 行号
	 * @return 错误提示
	 */
	public static boolean findAllNull(Sheet sh ,int column,int row){
		for(int i=0;i<column;i++){
			if(sh.getCell(i, row)!=null&&!sh.getCell(i, row).getContents().trim().equals("")){
				return  false; 
			}
		} 
		return true;
	}
	
	/**
	 * 验证列数
	 * @param sh 表单
	 * @param column 列数
	 * @return 错误提示
	 */
	public static String getSheet(Sheet sh ,int column){
		if(sh.getColumns()!=column){
			return  "列错误，应有"+column+"列，文件中只有"+sh.getColumns()+"列!<br>"; 
		}
		return "";
	}
	/**
	 * 验证数据有效性
	 * @param sh 表单
	 * @param column 列号
	 * @param row 行号
	 * @param str 验证内容（以 '|'隔开）	
	 * 				null：不为空
	 * 				int：整数
	 * 				double：数字
	 * 				date：日期
	 * 				tel:有效电话
	 * 				english：英文
	 * 				chinese:中文
	 * 				zip:邮编
	 * 				account：数字字母下划线组成,至少4位，首位为字母或下划线
	 * @return 错误提示
	 */
	public static String check(Sheet sh ,int column,int row,String str){
		String[] s = str==null?new String[]{}:str.split("\\|");
		String name = sh.getCell(column, 0)!=null?sh.getCell(column, 0).getContents().trim():"";
		for(int i=0;i<s.length;i++){
			if(s[i].equalsIgnoreCase("null")){
				if(sh.getCell(column, row)==null||sh.getCell(column, row).getContents().trim().equals("")){
					return  "第"+(row+1)+"行"+name+"不能为空!<br>"; 
				}
			}else if(s[i].equalsIgnoreCase("double")){
				if(sh.getCell(column, row)!=null&&!sh.getCell(column, row).getContents().trim().equals("")){
					if(!sh.getCell(column, row).getContents().trim().matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){
						return "第"+(row+1)+"行"+name+"应为有效数字!<br>";
						
					}
				}
			}
		}
		return "";
	}
	
	/**
	 * 验证数据有效性
	 * @param sh 表单
	 * @param column 列号
	 * @param row 行号
	 * @param sql 验证语句
	 * @return 错误提示
	 */
	public static String checkHas(Sheet sh ,int[] value ,int column,int row,String sql){
		for(int i=0;i<value.length;i++){
			sql = sql.replaceFirst("\\$", sh.getCell(value[i], row)!=null?sh.getCell(value[i], row).getContents().trim():"");
		}
		String name = sh.getCell(column, 0)!=null?sh.getCell(column, 0).getContents().trim():"";
		LoginDAO loginDAO = (LoginDAO)getBean("loginDAO");
		if(loginDAO.check(sql)){
			return "";
		}else{
			return "第"+(row+1)+"行"+name+"错误，数据无效!<br>";
		}
		
	}
	
	/**
	 * 验证数据重复性
	 * @param sh 表单
	 * @param column 列号
	 * @param row 行号
	 * @param sql 验证语句
	 * @return 错误提示
	 */
	public static String checkRepeat(Sheet sh ,int[] value ,int column,int row,String sql){
		for(int i=0;i<value.length;i++){
			sql = sql.replaceFirst("\\$", sh.getCell(value[i], row)!=null?sh.getCell(value[i], row).getContents().trim():"");
		} 
		String name = sh.getCell(column, 0)!=null?sh.getCell(column, 0).getContents().trim():"";
		LoginDAO loginDAO = (LoginDAO)getBean("loginDAO"); 
		if(loginDAO.check(sql)){
			return "第"+(row+1)+"行"+name+"错误，数据重复!<br>";
		}else{
			return "";
		}
		
	}
public static ApplicationContext ctx = null;
	
    /**
     * 从spring中返回bean
     * @param name
     * @return
     */
     public static Object getBean(String name) {
        if (ctx == null) {
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext());
        }
        return ctx.getBean(name);
    }
}
