package com.rc.base.service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rc.base.form.MngJobForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngJob;
import com.rc.sys.form.MngOperForm;
import com.rc.sys.form.TreeForm;
public interface JobService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngJobForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngJobForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngJobForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngJob findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngJobForm form);

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
	//根据单位编号遍历出所有岗位名字
	public List findAllSname(MngJobForm form);
	//遍历出表里面的所有等级
	public List findNlevel(MngJobForm form);
	/**
	 * 导出岗位信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response);
	/**
	 * 遍历出一级单位所有单位名称
	 */
	public List findUdSname(MngUnitDepartForm departForm);
	/**
	 * 根据job_stype遍历级别
	 */
	public Integer findMaxNLevel(String job_stype); 

	/**
	 * 查询单位部门菜单树列表
	 * @return
	 */
	public List findTreeList();
	
	/**
	 * 
	 */
	public List findUD(MngUnitDepartForm departForm);
	/**
	 * 遍历所有岗位
	 */
	public List findAlljob();
	
	/**
	 * 操作系统名称唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngJobForm form);
}
