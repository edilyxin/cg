package com.rc.util.page;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



public class PageTag extends TagSupport{
	
	private String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		ServletContext servletContext = pageContext.getServletContext();
		PageBean pageBean = (PageBean)request.getAttribute("bean");
		
	    
	    try{
	    	out.println("<table width='100%' border='0' cellspacing='1' cellpadding='1' style='font-size:13px;'><tr height=\"25\">");
	    	out.println("<td align=\"left\" valign=\"middle\"><span style=\"white-space:nowrap;vertical-align:middle;\">&nbsp;&nbsp;共有 <strong>"+pageBean.getTotalResults()+"</strong> 条记录，当前第 <strong>"+pageBean.getCurrentPage()+"</strong> 页，共 <strong>"+pageBean.getTotalPages()+"</strong> 页</span> </td>");
	    	out.println("<td align=\"right\" valign=\"middle\"><span style=\"white-space:nowrap;\">&nbsp;&nbsp;");
	    	if(pageBean.hasPreviousPage()){
	    		out.println("<a herf=\"javascript:void(0);\" style=\"cursor:hand;font-weight:bold;color:#0E6BB1;\" onclick='document.forms[0].action=\""+request.getContextPath()+uri+"?page=1\";document.forms[0].submit();' >首页</a>");
	    	}else{
	    		out.println("<span >首页</span>");
	    	}
	    	if(pageBean.hasPreviousPage()){
	    		out.println("<a herf=\"javascript:void(0);\" style=\"cursor:hand;font-weight:bold;color:#0E6BB1;\" onclick='document.forms[0].action=\""+request.getContextPath()+uri+"?page="+(pageBean.getCurrentPage()-1)+"\";document.forms[0].submit();' >上一页</a>");
	    	}else{
	    		out.println("<span >上一页</span>");
	    	}
	    	if(pageBean.hasNextPage()){
	    		out.println("<a  herf=\"javascript:void(0);\" style=\"cursor:hand;font-weight:bold;color:#0E6BB1;\" onclick='document.forms[0].action=\""+request.getContextPath()+uri+"?page="+(pageBean.getCurrentPage()+1)+"\";document.forms[0].submit();'>下一页</a>");
	    	}else{
	    		out.println("<span >下一页</span>");
	    	}
	    	if(pageBean.hasNextPage()){
	    		out.println("<a  herf=\"javascript:void(0);\" style=\"cursor:hand;font-weight:bold;color:#0E6BB1;\" onclick='document.forms[0].action=\""+request.getContextPath()+uri+"?page="+pageBean.getTotalPages()+"\";document.forms[0].submit();'>尾页</a>");
	    	}else{
	    		out.println("<span >尾页</span>");
	    	}
	    	
	    	out.println("  转到  <select style='height:18px;' onchange=\" document.forms[0].action='"+request.getContextPath()+uri+"?page='+this.options[this.selectedIndex].value;document.forms[0].submit();\">");
			
			for (int i = 1; i <= pageBean.getTotalPages(); i++) {
				out.println("<option class='STYLE22' value=\"" + i + "\""
						+ (i == pageBean.getCurrentPage() ? " selected" : "")
						+ ">第" + i + "页</option>");
			}
			out.println("</select></span></td></tr></table>");
	    
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	
}
