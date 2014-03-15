package com.rc.sys.service.impl;

import java.util.List;

import com.rc.sys.dao.OperDAO;
import com.rc.sys.form.MngOperForm;
import com.rc.sys.service.OperService;
import com.rc.sys.vo.MngOper;
import com.rc.sys.vo.MngRight;

public class OperServiceImpl implements OperService {
  
	private OperDAO operDAO;

	public void setOperDAO(OperDAO operDAO) {
		this.operDAO = operDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngOperForm form){
		return operDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngOperForm form ){
		return operDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngOperForm form){
		return operDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngOper findByID(MngOperForm form) {
		 
		return operDAO.findByID(form);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngOperForm form) {
		return operDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return operDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return operDAO.changeValid(idchecked);	
	}

	public List findOperByRight(String right_sno,String sysint_sno) {
		// TODO Auto-generated method stub
		return operDAO.findOperByRight(right_sno,sysint_sno);
	}

	public List findAllsysint_sname() {
		// TODO Auto-generated method stub
		return operDAO.findAllsysint_sname();
	}

	public MngRight findByID1(String id) {
		// TODO Auto-generated method stub
		return operDAO.findByID1(id);
	}

	public List findAllSname(MngOperForm form) {
		// TODO Auto-generated method stub
		return operDAO.findAllSname(form);
	}

	public boolean checkUnique(MngOperForm form) {
		// TODO Auto-generated method stub
		return operDAO.checkUnique(form);
	}

	
}
	
