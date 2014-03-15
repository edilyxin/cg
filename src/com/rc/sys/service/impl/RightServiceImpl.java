package com.rc.sys.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts2.ServletActionContext;
 
import com.rc.sys.dao.RightDAO;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.service.RightService;
import com.rc.sys.vo.MngRight;

public class RightServiceImpl implements RightService {
  
	private RightDAO rightDAO;

	public void setRightDAO(RightDAO rightDAO) {
		this.rightDAO = rightDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRightForm form){
		return rightDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRightForm form ){
		return rightDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRightForm form){
		return rightDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRight findByID(MngRightForm form) {
		 
		return rightDAO.findByID(form);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRightForm form) {
		return rightDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(List<String> ids) { 
			return rightDAO.delete(ids); 
	}
	
	/**
	 * 批量更新状态
	 * @param ids
	 * @return
	 */
	public boolean changeValid(List<String> ids) {
		return rightDAO.changeValid(ids);
	}
	
	/**
	 * 查询系统信息
	 * @return
	 */
	public List findSysIntList() {
		return rightDAO.findSysIntList();
	}
	
	/**
	 * 查询功能级别
	 * @return
	 */
	public List findRightNumList(String sysint_sno) {
		return rightDAO.findRightNumList(sysint_sno);
	}
	
	/**
	 * 根据功能级别，查询上级功能列表
	 * @param num
	 * @return
	 */
	public List findSparentList(MngRightForm form) {
		return rightDAO.findSparentList(form);
	}
	
	/**
	 * 根据上级功能编号查询子功能数
	 * @param right_sparentno
	 * @return
	 */
	public int findSubSize(MngRightForm form) {
		return rightDAO.findSubSize(form);
	}
	
	/**
	 * 查询子功能数最大的排序值
	 * @param form
	 * @return
	 */
	public Integer findMaxOrdval(MngRightForm form) {
		return rightDAO.findMaxOrdval(form);
	}
	
	/**
	 * 根据功能编号作物理删除
	 * @param right_sno
	 */
	public void delByRightNO(String right_sno) {
		rightDAO.delByRightNO(right_sno);
	}
	
	/**
	 * 查询某个系统功能级别为1级的菜单
	 * @param sysint_sno
	 * @return
	 */
	public List findMenu(String sysint_sno) {
		return rightDAO.findMenu(sysint_sno);
	}
	
	/**
	 * 查询1级菜单最大的排序值
	 * @param form
	 * @return
	 */
	public Integer findMaxMenuOrdval(MngRightForm form) {
		return rightDAO.findMaxMenuOrdval(form);
	}
	
	/**
	 * 查询功能排序列表
	 * @param form
	 * @return
	 */
	public List findSubList(MngRightForm form) {
		return rightDAO.findSubList(form);
	}
	
	/**
	 * 保存排序值
	 * @param orderVals, alertBy
	 * @return
	 */
	public boolean saveOrderValue(String[] orderVals, String alertBy) {
		try {
			return rightDAO.saveOrderValue(orderVals, alertBy);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 判断某个功能是否有子功能
	 * @param form
	 * @return
	 */
	public boolean hasSub(MngRightForm form) {
		return rightDAO.hasSub(form);
	}
	
	/**
	 * 判断该功能是否有有效的操作
	 * @param form
	 * @return
	 */
	public boolean hasOper(MngRightForm form) {
		return rightDAO.hasOper(form);
	}
	
	/**
	 * 查询该功能对应的角色是否有效
	 * @param form
	 * @return
	 */
	public boolean isRoleRightValid(MngRightForm form) {
		return rightDAO.isRoleRightValid(form);
	}
	
	/**
	 * 检查同一系统同一上级下功能名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean isRightnameValid(MngRightForm form) {
		return rightDAO.isRightnameValid(form);
	}
	
	public MngRight findByID2(MngRightForm form) {
		return rightDAO.findByID2(form);
	}
	
	public String fileUp(File file){
		String[] cellname={"账号:not null:int:10","姓名:not null",""};
		// 将文件复制到工程
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMddhhmmss");
		int i =0;
		int col = 10;//模板列长度
		//判断是否上传模板
		if(file!=null){
			try{
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				boolean bl = false;
				int rows = 0; // 表单行数
				Sheet sh = null; // 表单对象
				Workbook book = null;
//				Connection conn = null;
//				PreparedStatement stmt = null;
//				PreparedStatement downStmt = null; 
//					conn = DBConnection.getConnection();
//					if(conn==null){
//						setMessage("数据库连接错误！");
//						return false;
//					}
//					ms.updateStatus((ms.getMax()-ms.getMin())/8+ms.getMin());//进度条
					book = Workbook.getWorkbook(bis);
					sh = book.getSheet(0);
					rows = sh.getRows();
//					ms.updateStatus((ms.getMax()-ms.getMin())/8*3+ms.getMin());//进度条
//					String sql = "INSERT INTO tbapplyforeverchangeinfo (VCAPPLYCHANGEID,VCENTERPRISECODE," +
//							"VCENTERPRISENAME,NUMSRCQUANTITY,NUMTOTALQUANTITY,VCMEASURINGUNIT,ICHEMICALID," +
//							"VCCHEMICALCODE,DTUPDATE) SELECT ?,?,?,?,?,?,t.ICHEMICALID,t.VCCHEMICALCODE,SYSDATE FROM TBCHEMICALINFO t WHERE t.VCCHEMICALNAME=? and t.vcmeasuringunit=?";
//					String downSql = "INSERT INTO tbbusinessfileinfo VALUES(S_TBBUSINESSFILEINFO.NEXTVAL,?,'tbapplyforeverchangeinfo',?,'saveorupdate',SYSDATE,'0')";
					String vcapplychangeid = null;
					String vcenterprisecode = null;
					String vcenterprisename = null;
					Double numsrcquantity = null;
					Double numtotalquantity = null;
					String vcmeasuringunit = null;
					String vcchemicalname = null;
					String usertype = null;
//					downStmt = conn.prepareStatement(downSql);
//					stmt = conn.prepareStatement(sql);
					int num = 0;
					String[] nameStr = {"单位名称","单位简称"};
//					ms.updateStatus((ms.getMax()-ms.getMin())/2+ms.getMin());//进度条
					for ( i = 1; i < rows; i++) { // 程序不取第一行
						//验证信息是否齐全
						Boolean bool = isFull(sh.getRow(i),col);
					    if(bool==null){
					    	continue;
					    }else if(!bool){
//					    	setMessage("第"+(i+1)+"行导入错误，该行数据不全！");
//					    	return false;
					    }
					    
//						vcapplychangeid = getCode();//自动生成32位ID
//						vcenterprisename = sh.getCell(0, i).getContents().trim();//读取单位名称信息
//						vcenterprisecode = sh.getCell(1, i).getContents().trim();//读取单位营业执照信息
						
//						if(!dao.checkVcenterprise(conn, vcenterprisename, vcenterprisecode))
//						{
//							if(!dao.checkVcenterpriseName(conn, vcenterprisename)){
//								setMessage("第"+(i+1)+"行导入错误，该行单位名称无效！");
//								return false;
//							}else if(!dao.checkVcenterpriseCode(conn, vcenterprisecode)){
//								setMessage("第"+(i+1)+"行导入错误，该行单位营业执照无效！");
//								return false;
//							}else{
//								setMessage("第"+(i+1)+"行导入错误，该行单位名称和营业执照不匹配！");
//								return false;
//							}
//						}
						
//						usertype = sh.getCell(2, i).getContents().trim();//读取单位类型
//						if(!isType(usertype)){//判断判断单位类型是否有效
//							setMessage("第"+(i+1)+"行导入错误，无此单位类型！");
//							return false;
//						}
//						if(!dao.checkUserType(conn, vcenterprisecode, usertype)){
//							setMessage("第"+(i+1)+"行导入错误，该行单位类型选择错误！");
//							return false;
//						}
//						vcchemicalname = sh.getCell(3, i).getContents().trim();//读取化学品名称
//						if(!dao.findChemical(conn, vcchemicalname)){
//							setMessage("第"+(i+1)+"行导入错误，该行化学品名称无效,以数据库为准！");
//							return false;
//						}
//						vcmeasuringunit = sh.getCell(4, i).getContents().trim();//读取化学品规格
//						if(!dao.findChemicalType(conn, vcchemicalname, vcmeasuringunit)){
//							setMessage("第"+(i+1)+"行导入错误，该行化学品名称和规格不匹配！");
//							return false;
//						}
//						if(dao.findCodeAndChemical(conn, vcenterprisecode, vcchemicalname,vcmeasuringunit)){//判断数据库该单位化学品是否已有用量
//							setMessage("第"+(i+1)+"行导入错误，数据库中已存在该单位该规格的化学品用量信息 ！");
//							return false;
//						}
//						if(isRepeat(vcenterprisecode,vcchemicalname,vcmeasuringunit, i)){//判断EXCEL表中是否有重复的该单位化学品用量
//							return false;
//						}
//						try{
//						    numsrcquantity = Double.valueOf(sh.getCell(5, i).getContents().trim());//读取化学品用量为初始用量
//						    numtotalquantity = Double.valueOf(sh.getCell(5, i).getContents().trim());//读取化学品用量为永久用量
//						}catch(Exception e){
//							e.printStackTrace();
//							setMessage("第"+(i+1)+"行导入错误，申报数量应为数字！");
//							return false;
//						}
//						//存入用量信息
//						stmt.setString(1, vcapplychangeid);
//						stmt.setString(2, vcenterprisecode);
//						stmt.setString(3, vcenterprisename);
//						stmt.setDouble(4, numsrcquantity);
//						stmt.setDouble(5, numtotalquantity);
//						stmt.setString(6, vcmeasuringunit);
//						stmt.setString(7, vcchemicalname);
//						stmt.setString(8, vcmeasuringunit);
//						num++;
//						stmt.addBatch();
//						//存入下行表信息
//						vcenterprisecode = dao.findVcenterprisecode(conn, vcenterprisecode, usertype);//读取下行数据的单位营业执照
//						if(vcenterprisecode==null){
//							setMessage("第"+(i+1)+"行导入错误，该单位无户主信息！");
//							return false;
//						}
//						downStmt.setString(1, vcenterprisecode);
//						downStmt.setString(2, vcapplychangeid);
//						downStmt.addBatch();
//						ms.updateStatus((ms.getMax()-ms.getMin())/2/(rows-1)*i+(ms.getMax()+ms.getMin())/2);//进度条
//					}
//					conn.setAutoCommit(false);
//					stmt.executeBatch();
//					downStmt.executeBatch();
//					conn.commit();
//					bl = true;
//					setMessage("导入成功,共导入"+num+"行数据！");
//					ms.updateStatus(ms.getMax());//进度条完成
//				}catch (FileNotFoundException e) {   
//					setMessage("导入失败，文件未找到！");
//		            e.printStackTrace();   
//		  
//		        } catch (IOException e) { 
//		        	setMessage("导入失败，IO异常！");
//		            e.printStackTrace();   
//		       
//		        } catch (SQLException e) {   
//		        	setMessage("导入失败，数据库连接失败！");
//		            e.printStackTrace(); 
//		        }catch (Exception e) {
//					setMessage("导入失败，第"+(i+1)+"行数据错误！");
//					e.printStackTrace();
//					if (conn != null) {
//						try {
//							conn.rollback();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				} finally {
//					if (inputStream != null)
//						try {
//							inputStream.close();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					if (book != null)
//						book.close();
//					if (stmt != null)
//						try {
//							stmt.close();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					if (downStmt != null)
//						try {
//							downStmt.close();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					DBConnection.close();
//					
//				}
//				return bl;
//				
//				
//				
//				
//				
//				
//				ServletContext application = ServletActionContext
//						.getServletContext();
//				path1 = application.getRealPath("LabZdinfoFile");
//				File firstFile = new File(path1);
//				if (firstFile.exists()) {
//				} else {
//					firstFile.mkdirs();
//				}
//				FileOutputStream file = new FileOutputStream(path1  + "\\" + mfFileName);
//				BufferedOutputStream bos = new BufferedOutputStream(file);
//				byte[] b = new byte[1000];
//				int i;
//				while ((i = bis.read(b)) != -1) {
//					bos.write(b, 0, b.length);
//				}
//				bos.flush();
//				bos.close();
//				bis.close();
//				path1 = path1  + "\\" + mfFileName;
//				form.setZdinfo_sfile1(path1);
//				if("1".equals(tjType)){
//					add();
//				}else{
//					update();
//				}
//				
//					/*Gson gson=new Gson();
//					returnData=gson.toJson(path1);
//					
//					response.setContentType("text/html; charset=utf-8");
//					PrintWriter pw=response.getWriter();
//					pw.write(returnData);
//					pw.flush();
//					pw.close();	*/
//				
					}
			} catch (Exception e) {
				e.printStackTrace();
				//return "error";
			}
			 
		}
		//return "fileUp";
		return null;
	}
					
					/**
					 * 验证信息是否齐全 (true:齐全 false:不全 null:该行无数据,忽略 )
					 * @param row 行对象
					 * @param col 列长度
					 * @return bl
					 */
					private  Boolean isFull(Cell[] row,int col) {
						Boolean bl = true;
						int j =0;
						for(int k=0;k<row.length;k++){
							if(row[k]==null||row[k].getContents().equals(""))
							{
								bl = false;
								
							}else{
								j=1;
							}
							if(k==(col-1)){
								break;
							}
						}
				        if(row.length<col){
				        	bl = false;
				        }
						if(j==0){
							bl = null;
						}
							
						
						return bl;
					}
}
	
