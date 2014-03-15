package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngDboperForm;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.form.MngSysintForm;
import com.rc.sys.vo.MngDboper;
import com.rc.sys.vo.MngRight;
public interface DboperService {

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngDboperForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngDboperForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngDboperForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngDboper findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngDboperForm form);

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
	 * 此方法描述的是： 查找全都功能名称
	 * @author: Administrator
	 * @version: 2013-5-27 上午09:45:14
	 * @param rightvo 
	 */
	public List findright(MngRightForm rightform);
    
	/**
	 * 
	 * 此方法描述的是： 查找全都系统名称
	 * @author: Administrator
	 * @version: 2013-5-28 下午03:01:11
	 */
	public List findsys(MngSysintForm sysform);
	public boolean checkOnly(MngDboperForm form);
	
}
