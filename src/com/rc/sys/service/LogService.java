package com.rc.sys.service;

import java.util.List;
import com.rc.sys.form.MngLogForm;
import com.rc.util.UserInfo;

public interface LogService {

	

	/**
	 * 登陆登出日志
	 * @param userInfo	用户session
	 * @param message	登陆信息
	 * @param type		日志类型0登录1登出
	 */
	public void login(UserInfo userInfo,String message,String type);
	 
	
	/**
	 * 
	 *  @Description    : 操作日志
	 *  @Method_Name    : logInsert
	 *  @param userInfo	: 用户session
	 *  @param message	: 操作信息
	 *  @param tableName: 操作表名
	 */
	public void logInsert(UserInfo userInfo,String message,String tableName) ;
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngLogForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngLogForm form );
}
