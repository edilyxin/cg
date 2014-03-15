package com.rc.base.service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rc.base.form.MngPostForm;
import com.rc.base.vo.MngPost;
public interface PostService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngPostForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngPostForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngPostForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngPost findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngPostForm form);

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
    * 
    * 此方法描述的是：导出职称信息表 
    * @author: Administrator
    * @version: 2013-6-2 下午06:22:22
    */
	public void exportExcel(List list, HttpServletResponse response);
  /**
   * 
   * 此方法描述的是： 验证唯一性
   * @author: Administrator
   * @version: 2013-6-23 下午11:11:43
   */
    public boolean checkOnly(MngPostForm form);
   /**
    * 
    * 此方法描述的是： 查询出职称等级
    * @author: luzong
    * @version: 2013-8-2 上午10:31:22
    */
    public List findnlevel(MngPostForm form);
	
 }
 