package com.rc.base.service;
import java.util.List;

import com.rc.base.form.MngSchoolForm;
import com.rc.base.vo.MngSchool;
public interface SchoolService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSchoolForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSchoolForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSchoolForm form);
	
    /**   
     *  @Description    : 验证唯一
     *  @Method_Name    : checkUnique
     *  @return
     */
	public boolean checkUnique(MngSchoolForm form);
	
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSchool findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSchoolForm form);

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
	 * 查询所有校区信息
	 * @return
	 */
	public List findAll();
	
}
