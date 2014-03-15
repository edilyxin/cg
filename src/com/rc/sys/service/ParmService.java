package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngParmForm;
import com.rc.sys.vo.MngParm;
import com.rc.sys.vo.MngSysint;
public interface ParmService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngParmForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngParmForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngParmForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngParm findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngParmForm form);

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
	 * 查询系统编号
	 * @return
	 */
	public List<MngSysint> sysinfo();

	/**
	 * 根据参数名查询参数值
	 * @param sysint_sno 系统编号
	 * @param parm_sname 显示名称
	 * @return 参数值
	 */
	public String getValue(String sysint_sno ,String parm_sname);

	/**
	 * 判断唯一性
	 * @param form
	 * @return
	 */
	public boolean findAllSname(MngParmForm form);
}
