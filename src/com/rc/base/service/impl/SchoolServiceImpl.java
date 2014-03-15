package com.rc.base.service.impl;

import java.util.List;

import com.rc.base.dao.SchoolDAO;
import com.rc.base.form.MngSchoolForm;
import com.rc.base.service.SchoolService;
import com.rc.base.vo.MngSchool;

public class SchoolServiceImpl implements SchoolService {
  
	private SchoolDAO schoolDAO;

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSchoolForm form){
		return schoolDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSchoolForm form ){
		return schoolDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSchoolForm form){
		return schoolDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSchool findByID(String id) {
		 
		return schoolDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSchoolForm form) {
		return schoolDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return schoolDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return schoolDAO.changeValid(idchecked);	
	}
	
	/**
	 * 查询所有校区信息
	 * @return
	 */
	public List findAll() {
		return schoolDAO.findAll();
	}

	
	/** 
	 *  @Description    : 方法描述
	 *  @Method_Name    : checkUnique
	 */
		
	public boolean checkUnique(MngSchoolForm form) {
		// TODO Auto-generated method stub
		return schoolDAO.checkUnique(form);
	}
}
	
