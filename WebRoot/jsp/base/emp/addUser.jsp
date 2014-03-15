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
	 
		if(validator(document.form1)){
			document.form1.action="<%=path %>/emp!insertuser";
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
                									<td width="94%" valign="bottom"><span class="STYLE1"> 添加用户</span></td>
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
					    				<td nowrap align="right" width="45%" >账号:</td>
					    				<td colspan="3" >
					    					<input name="userform.screenname" id="screenname" value="" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">姓名:</td>
					    				<td colspan="3">
					    					<input dir='rtl' name="userform.firstname" id="firstname" value="${vo.emp_sname}" class="text" style="width:75px" valid="required|isEnglishChinese" errmsg="姓名不能为空!|姓名必须为中文或英文!"/>
					    					<input name="userform.lastname" id="lastname" class="text" style="width:75px" />
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sname"></span> 
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">密码:</td>
					    				<td colspan="3" >
					    					<input type="password" name="userform.password" id="password" class="text" style="width:154px" valid="required|isPassword" errmsg="密码不能为空!|密码只能以字母数字下划线组成6至16位!"/>
					    					<span style="color:red;">*</span> &nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_us_spwd"></span>
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap align="right">确认密码:</td>
					    				<td colspan="3" >
					    					<input type="password" name="confirmPwd" id="confirmPwd" class="text" style="width:154px" valid="required|equal" equalName="password" errmsg="确认密码不能为空!|两次密码不同!" />
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_us_spwd1"></span> 
					    				</td>
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">邮箱:</td>
					    				<td colspan="3">
					    					<input name="userform.email" id="email" class="text" style="width:154px" valid="isEmail" errmsg="邮箱格式不正确！"/>
					     				</td>
					    
					  				</tr>
					   			</table>
					   			<input name="form1.emp_sno" id="emp_sno" type="hidden" value="${vo.emp_sno}" style="width:154px" />
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td align="center">
							<input type="button" name="Submit" value="保存" class="button" onclick="save();"/>　
							<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <!--<tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
--></table>
<input type="hidden" name="us_sreplyby" value=""/>
</form>
</body>
</html>