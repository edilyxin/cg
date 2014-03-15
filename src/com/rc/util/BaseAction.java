/*
 * Copyright (c) 2005 WWW.EASECARD.COM. All Rights Reserved.
 */
package com.rc.util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;


public abstract class BaseAction extends ActionSupport {

    protected final Log logger = LogFactory.getLog(getClass());
    private static ApplicationContext ctx = null;
    public Map session = (Map)ActionContext.getContext().get(ActionContext.SESSION);
    public HttpServletRequest request = ServletActionContext.getRequest ();
    public HttpServletResponse response = ServletActionContext.getResponse();
    
    /**
     * 从spring中返回bean
     * @param name
     * @return
     */
     public Object getBean(String name) {
        if (ctx == null) {
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext());
        }
        return ctx.getBean(name);
    }

    /**
     * @param content            导出内容
     * @param exportType        导出类型
     * @param httpServletResponse   response
     * ToDo   导出数据
     */
    public void Export(String content,String exportType,HttpServletResponse httpServletResponse) throws IOException{

            if(content==null)return ;
                if(exportType.equals("txt")){
                    //设置输出文本
                    httpServletResponse.setContentType("text/plain;charset=UTF-8");
                    httpServletResponse.setHeader("Content-disposition","attachment;filename=" + "result.txt");
                }else if(exportType.equals("xls")){
                    //设置输出excel
                    httpServletResponse.setContentType("application/vnd.ms-excel;charset=GBK");
                    httpServletResponse.setHeader("Content-disposition","attachment;filename=" + "result.xls");
                }else if(exportType.equals("csv")){
                    //设置输出csv
                    httpServletResponse.setContentType("text/plain;charset=GBK");
                    httpServletResponse.setHeader("Content-disposition","attachment;filename=" + "result.csv");
                }
                PrintWriter out = httpServletResponse.getWriter();
                    out.write(content);
                    out.flush();
                    out.close();
    }
    
  //服务器格式  转换中文乱码问题
	public String serviceStr(String str){
		try {
			return new  String(str.getBytes("ISO8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}	
}