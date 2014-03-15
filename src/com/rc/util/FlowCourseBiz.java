package com.rc.util;

import java.util.List;

public interface FlowCourseBiz{

	
	/**
	 * 功能：查询表单已审批过程
	 * 返回类型：
	 * 参数：
	 * 作者：刘世权
	 * 开发时间：2008-06-21
	 * 版本：V1
	 */
	public List findFlow(String key);
	
	/**
	 * 功能:查询表单总体审批流程
	 * 返回类型:List (查询出来的结果集)
	 * 参数:String key(页面获取的编号)
	 * 作者:刘世权
	 * 开发时间:2008-06-21
	 * 版本:V1
	 */
	public List findForm(String key);
}
