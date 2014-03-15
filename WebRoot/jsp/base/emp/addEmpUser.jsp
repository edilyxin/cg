<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String no=request.getParameter("empsno");
%>
<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base target="_top"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script> 
function toResut(){
    document.form1.reset();
}
function save(){
 	
	if(validator()){
		if(confirm("是否保存?")) {
			$("#useremp").submit();
			window.returnValue = true;
			 window.close();
		}
	}	
}
 
</script>
</head>
<body>
<form name="form1" id="useremp" action="<%=path%>/emp!saveempuser1" method="post" >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></div></div></td>
        </tr>
        </table>
    </td>
    <!--<td width="16" valign="top" background="<%=path%>/images/mail_rightbg.gif">
    	<img src="<%=path%>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  --></tr>
  <tr>
	<td height="100%"  valign="middle" background="<%=path%>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#353c44">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1"> 添加员工用户</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              							</td>
          							</tr>
        						</table>
        					</td>
      					</tr>
    				</table>
    			</td>
  			</tr>
 			<tr valign="top">
    			<td  >
    				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			  <table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;" bgcolor="#E3E9EE">
									   <tr>
									       <td><br></td>	  
									    </tr>      
									     <tr>
									      <td><br></td>	  
									   </tr> 
									  <tr> 
									   <td nowrap align="right" width="38%">用户账号:</td>
									    <td colspan="3">
										   <input name="screenname" id="screenname" value=""  class="text" style="width:154px"  valid="required" errmsg="用户账号不能为空!" readonly="readonly"/>
										      <input type="button" class="select_button" onclick="userTree('userid','screenname');"/>
										     <input name="form1.userid" id="userid" value=""   type="hidden"  style="width:154px"  />
										      <input name="form1.emp_sno" id="emp_sno"  value="<s:property value="#parameters.empsno"/>"  type="hidden" style="width:154px"  />
										      <span style="color:red;">*</span>&nbsp;&nbsp; 
										     <span style="color:red;"  id="errMsg_role_sname"></span>
									     </td>
									    </tr>
									    <tr>
									     <td><br></td>	  
									    </tr>      
									  
									    <tr>
									      <td><br></td>	  
									   </tr> 
					   
					       
					  </table>
		</td>
      </tr>
    </table>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center">
			<input type="button" name="Submit" value="保存" class="button" onclick="save()"/>　
			<input type="button" name="Submit1" value="重置" class="button" onclick="toResut();"/>　
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.close();"/>
		</td>
      </tr>
    </table>
    			</td>
  			</tr>
		</table>
    </td>
    <td background="<%=path%>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <!--<tr>
    <td  valign="bottom" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path%>/images/buttom_bgs.gif"><img src="<%=path%>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path%>/images/mail_rightbg.gif"><img src="<%=path%>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
--></table>
<input type="hidden" name="form.dict_sreplyby" value="admin"/>
</form>
</body>
</html>
