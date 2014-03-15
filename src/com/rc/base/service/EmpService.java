package com.rc.base.service;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rc.base.form.MngEmpForm;
import com.rc.base.form.MngEmpUserForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngEmp;
import com.rc.sys.form.MngUserForm;
public interface EmpService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngEmpForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngEmpForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngEmpForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngEmp findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngEmpForm form);

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked);
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked);
	 
	
    /**
	 * 导出单位部门信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response);
	 
		
	/**
	 * 新增用户
	 */
	  public String adduser( MngUserForm userform);
	  
	  /**
	     * 新增用户职工1
	     * @param form
	     * @return
	     */
	    public boolean saveEuser(MngEmpUserForm form);
	  /**
	     * 查询职工用户记录数
	     * 
	     */
	    public Integer empuserfindsize(MngEmpForm form);
	   
	    
	    /**
	     * 查询职工用户
	     * 
	     */
	    public List empuserfindpage(MngEmpForm form);
	    /**
		 * 批量删除职工用户
		 * @param idchecked
		 * @return
		 */
		public boolean deleteuseremp(String[] idchecked);
	    /**
	     * 查询已职工以分配的用户
	     */
	    public List empuseempuserfind1(MngEmpUserForm form1);
	    /**
	     * 新增职工用户对照
	     * @param idchecked
	     * @param form1
	     * @throws SQLException 
	     */
	    public  boolean saveempuser(MngEmpUserForm form1) ;
	    /**
	     * 遍历所有单位
	     * @param udform
	     * @return
	     */
	    public List udlist(MngUnitDepartForm udform);
	    /**
	     * 根据隶属单位查询所属单位
	     * @param udform
	     * @return
	     */
	    public List udliststopno(MngUnitDepartForm udform);
	  /**
	   * 查询最低层数
	   * @return
	   */
	    public Integer  levels();
}
