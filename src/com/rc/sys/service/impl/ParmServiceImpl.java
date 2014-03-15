package com.rc.sys.service.impl;

import java.util.List;

import com.rc.sys.dao.ParmDAO;
import com.rc.sys.form.MngParmForm;
import com.rc.sys.service.ParmService;
import com.rc.sys.vo.MngParm;
import com.rc.sys.vo.MngSysint;

public class ParmServiceImpl implements ParmService {
  
	private ParmDAO parmDAO;

	public void setParmDAO(ParmDAO parmDAO) {
		this.parmDAO = parmDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngParmForm form){
		return parmDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngParmForm form ){
		return parmDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngParmForm form){
		return parmDAO.save(form);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngParm findByID(String id) {
		 
		return parmDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngParmForm form) {
		return parmDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return parmDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return parmDAO.changeValid(idchecked);	
	}

	public List<MngSysint> sysinfo() {
		// TODO Auto-generated method stub
		return parmDAO.sysinfo();
	}

	/**
	 * 根据参数名查询参数值
	 * @param sysint_sno 系统编号
	 * @param parm_sname 显示名称
	 * @return 参数值
	 */
	public String getValue(String sysint_sno ,String parm_sname){
		return parmDAO.getValue(sysint_sno ,parm_sname);
		
	}
	/**
	 * 判断唯一性
	 */
	public boolean findAllSname(MngParmForm form) {
		// TODO Auto-generated method stub
		return parmDAO.findAllSname(form);
	}
}
	
