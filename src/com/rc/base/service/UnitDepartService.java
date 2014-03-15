package com.rc.base.service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rc.base.form.MngSchoolDepartForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngUnitDepart;
import com.rc.sys.service.SequenceService;
import com.rc.util.UserInfo;
public interface UnitDepartService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngUnitDepartForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngUnitDepartForm form );

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngUnitDepartForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngUnitDepart findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngUnitDepartForm form);

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
	 * 查询单位部门信息
	 * @return
	 */
	public List findAll();
	
	/**
	 * 检查同一上级单位下，单位名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean checkUni(MngUnitDepartForm form);
	

	/**
	 * 查询单位部门菜单树列表
	 * @return
	 */
	public List findTreeList();
	

	/**
	 * 导出单位部门信息
	 * @param response
	 */
	public void exportExcel(List list , HttpServletResponse response);
	
	/**
	 * 根据单位层次查询可用隶属单位列表
	 * @param ud_nnumber
	 * @return
	 */
	public List findTopList(Long ud_nnumber);
	
	/**
	 * 保存单位校区对照信息
	 * @param sdForm
	 * @param arrSchoolNO
	 */
	public void saveSchool(MngSchoolDepartForm sdForm, String[] arrSchoolNO);
	
	/**
	 * 根据单位编号查询所对应校区
	 * @param sdForm
	 * @return
	 */
	public List findByUDNo(MngSchoolDepartForm sdForm);
	
	/**
	 * 生成编码
	 * @param level 级别
	 * @param len 编码长度
	 * @param topNO 上级编码
	 * @param sequenceService 
	 * @param userInfo 
	 * @return 编码
	 */
	public String getNO(int level, int len , String topNO, SequenceService sequenceService, UserInfo userInfo);
	
	/**
	 * 查询是否有单位层次为学校的记录
	 * @return
	 */
	public boolean canAddSchool();
	
	/**
	 * 根据部门编号判断该部门是否有下级
	 * @param no
	 * @return true有下级，false没下级
	 */
	public boolean hasSub(String no);
	
}
