package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngSysint;
public interface SysintService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSysintForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSysintForm form );
	
	/**
	 * 判断系统名称唯一
	 * @param form
	 * @return
	 */
	public boolean checkUnique(MngSysintForm form);
	
	 
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSysintForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSysint findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSysintForm form);

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
	 * 判断系统编号是否被引用
	 * @param form
	 * @return
	 */
	public boolean findID(String id);
	
}
