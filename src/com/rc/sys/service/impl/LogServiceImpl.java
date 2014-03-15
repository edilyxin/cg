package com.rc.sys.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.rc.sys.dao.LogDAO;
import com.rc.sys.form.MngLogForm;
import com.rc.sys.service.LogService;
import com.rc.util.UserInfo;

public class LogServiceImpl implements LogService{
		
	private LogDAO logDAO;
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	/**
	 * 
	 *  @Description    : 登陆日志
	 *  @Method_Name    : login
	 *  @param userInfo	: 用户session
	 *  @param message	: 登陆信息
	 *  @param type 	: 日志类型0登录1登出
	 */
	public void login(UserInfo userInfo,String message, String type) {
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String cdate=sDateFormat.format(curDate);
		MngLogForm vo = new MngLogForm();
		vo.setUserid(userInfo.getUserid());
		vo.setLog_scontent(message);
		vo.setLog_sip(userInfo.getIp());
		vo.setLog_sreplyby(userInfo.getScreenname());
		vo.setLog_soptype(type);//日志类型0登录1登出2操作
		if(type.equals("1")){
			vo.setLog_salterby(userInfo.getScreenname());
			vo.setLog_dalterdate(cdate);
		}
		logDAO.save(vo);
	}


	
	/**
	 * 
	 *  @Description    : 操作日志
	 *  @Method_Name    : logInsert
	 *  @param userInfo	: 用户session
	 *  @param message	: 操作信息
	 *  @param tableName: 操作表名
	 */
	public void logInsert(UserInfo userInfo,String message,String tableName) {
		MngLogForm vo = new MngLogForm();
		vo.setUserid(userInfo.getUserid());
		vo.setLog_scontent(message);
		vo.setLog_sip(userInfo.getIp());
		vo.setLog_stable(tableName);
		vo.setLog_sreplyby(userInfo.getScreenname());
		vo.setLog_soptype("2");//日志类型0登录1登出2操作
		logDAO.save(vo);
	}
	

	/**
	 * 查询结果数
	 */
	public Integer findSize(MngLogForm form){
		return logDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngLogForm form ){
		return logDAO.findPage(form);
	}
	

}
