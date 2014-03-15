package com.rc.sys.service;
import java.io.File;
import java.util.List;

import com.rc.sys.form.MngRightForm;
import com.rc.sys.vo.MngRight;
public interface RightService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRightForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRightForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRightForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRight findByID(MngRightForm form);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRightForm form);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public boolean delete(List<String> ids);
	
	/**
	 * 批量更新状态
	 * @param ids
	 * @return
	 */
	public boolean changeValid(List<String> ids);
	
	/**
	 * 查询系统信息
	 * @return
	 */
	public List findSysIntList();
	
	/**
	 * 查询功能级别
	 * @return
	 */
	public List findRightNumList(String sysint_sno);
	
	/**
	 * 根据功能级别，查询上级功能列表
	 * @param form
	 * @return
	 */
	public List findSparentList(MngRightForm form);
	
	/**
	 * 根据上级功能编号查询子功能数
	 * @param right_sparentno
	 * @return
	 */
	public int findSubSize(MngRightForm form);
	
	/**
	 * 查询子功能数最大的排序值
	 * @param form
	 * @return
	 */
	public Integer findMaxOrdval(MngRightForm form);
	
	/**
	 * 根据功能编号作物理删除
	 * @param right_sno
	 */
	public void delByRightNO(String right_sno);
	
	/**
	 * 查询某个系统功能级别为1级的菜单
	 * @param sysint_sno
	 * @return
	 */
	public List findMenu(String sysint_sno);
	
	/**
	 * 查询1级菜单最大的排序值
	 * @param form
	 * @return
	 */
	public Integer findMaxMenuOrdval(MngRightForm form);
	
	/**
	 * 查询功能排序列表
	 * @param form
	 * @return
	 */
	public List findSubList(MngRightForm form);
	
	/**
	 * 保存排序值
	 * @param orderVals
	 * @param alertBy 
	 * @return
	 */
	public boolean saveOrderValue(String[] orderVals, String alertBy);
	
	/**
	 * 判断某个功能是否有有效的子功能
	 * @param form
	 * @return
	 */
	public boolean hasSub(MngRightForm form);
	
	/**
	 * 判断该功能是否有有效的操作
	 * @param form
	 * @return
	 */
	public boolean hasOper(MngRightForm form);
	
	/**
	 * 查询该功能对应的角色是否有效
	 * @param form
	 * @return
	 */
	public boolean isRoleRightValid(MngRightForm form);
	
	/**
	 * 检查同一系统同一上级下功能名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean isRightnameValid(MngRightForm form);

	public MngRight findByID2(MngRightForm form);
	
	public String fileUp(File file);
}
