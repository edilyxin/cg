<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script> 
function save(){
	 
		if(document.form1){
			document.form1.action="<%=path%>/declarec!save?EP_SNO=<%=request.getParameter("EP_SNO")%>";
			document.form1.submit();
		}
	 
}

</script>
</head>
<body>
<form name="form1" method="post">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></div></td>
        </tr>
        </table>
    </td>
    <!--<td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif">
    	<img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  --></tr>
  <tr>
	<td height="90%" valign="middle" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
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
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">填写/查看进口申报</span></td>
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
    			<td>
    				<table  width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table class="table1" border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 									 				
					 				<tr >
					    				<td nowrap align="right" width="45%" >设备仪器名称:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SNAME" id="screenname" value="${entrancec.ETC_SNAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >数量（单位）:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_NNUM" id="screenname" value="${entrancec.ETC_NNUM }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >外汇总额:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_DMONEY" id="screenname" value="${entrancec.ETC_DMONEY }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >建设项目名称:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SPRONAME" id="screenname" value="${entrancec.ETC_SPRONAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >经费代码:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SCOME" id="screenname" value="${entrancec.ETC_SCOME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >设备使用人:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SUSER" id="screenname" value="${entrancec.ETC_SUSER }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >联系电话/手机:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_STELE" id="screenname" value="${entrancec.ETC_STELE }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >					    			
					    				<td nowrap align="right" width="45%" >仪器设备型号、规格及具体指标:</td>
					    				<td colspan="3" >
					    				<textarea name="entrancecForm.ETC_SMODEL" rows="5" cols="50">${entrancec.ETC_SMODEL }</textarea>
					     				</td>
					    			</tr>
					    			
					    			<tr >
					    			<td nowrap align="right" width="45%" >仪器设备详细用途说明--工作原来、课程（课题）名称及课程（课题）中如何使用:</td>
					    				<td colspan="3" >
					    				<textarea name="entrancecForm.ETC_SNOTE" rows="5" cols="50">${entrancec.ETC_SNOTE }</textarea>
					     				</td>					    				
					    				
					    			</tr>
					    			
					    			<tr >
					    				<td nowrap align="right" width="45%" >归属:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SBELONG" id="screenname" value="${entrancec.ETC_SBELONG }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" >备注:</td>
					    				<td colspan="3" >
					    					<input name="entrancecForm.ETC_SREMARK" id="screenname" value="${entrancec.ETC_SREMARK }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			
					   			</table>
					   			<input name="entrancecForm.ETC_NID"  type="hidden" value="${entrancec.ETC_NID }" style="width:154px" />
					   			<input name="entrancecForm.ETP_SNO" type="hidden" value="<%=request.getParameter("ETP_SNO")%>" style="width:154px" />
					   			<input name="entrancecForm.EP_SNO" type="hidden" value="<%=request.getParameter("EP_SNO")%>" style="width:154px" />
					   			<input name="entrancecForm.EPD_NID" type="hidden" value="<%=request.getParameter("EPD_NID")%>" style="width:154px" />
					   			
							</td>
      					</tr>
    				</table>
    				
    			</td>
  			</tr>
		</table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>


	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td align="center">
							<input type="button" name="Submit" value="保存内容" class="button" onclick="save();"/>　
							
						</td>
      				</tr>
    				</table>
</form>
</body>
</html>