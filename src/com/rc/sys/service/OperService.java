package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngOperForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngOper;
import com.rc.sys.vo.MngRight;
public interface OperService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngOperForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngOperForm form);
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngOperForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngOper findByID(MngOperForm form);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngOperForm form);

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
	 *  @Description    : 遍历出自己所有的right_sno,根据right_sno自动生成oper_sno编号
	 *  @Method_Name    : findOperByRight
	 *  @param right_sno
	 *  @param sysint_sno
	 *  @return 
	 *  @return         : List
	 *  @Creation Date  : 2013-5-24下午08:51:47 
	 *  @version        : v1.00
	 *  @Author         : Administrator
	 */
	public List findOperByRight(String right_sno,String sysint_sno);
	/**
	 * 遍历出功能管理的所有系统编号
	 */
	public List findAllsysint_sname();
	public MngRight findByID1(String id);
	public List findAllSname(MngOperForm form);
	
	/**
	 * 操作系统名称唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngOperForm form);
}
