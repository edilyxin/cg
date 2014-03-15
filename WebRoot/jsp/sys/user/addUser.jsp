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
		if(validator()){
			document.form1.action="<%=path %>/user!add";
			document.form1.submit();
		}
}
function back(){
	window.location.href="<%=path%>/user!find";
}
 

</script>
</head>
<body>
<form name="form1" method="post">
<div class="bigBox" >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span></h2>
   <div class="content" id="divheight" style="overflow:auto;"> 
	 
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#0E6BB1">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">新增用户</span></td>
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
    				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 			<tr >
					    				<td nowrap align="right" width="45%" >账号:</td>
					    				<td colspan="3" >
					    					<input name="form.screenname" id="screenname" value="" onblur="" class="text" style="width:154px" maxlength="20" 
					    					url="<%=path%>/user!userUniqueName" urlmsg="用户账号已存在！" 
					    					valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">姓名:</td>
					    				<td colspan="3">
					    					<input dir='rtl' name="form.firstname" id="firstname"  class="text" style="width:75px" maxlength="10" valid="required|isEnglishChinese" errmsg="姓名不能为空!|姓名必须为中文或英文!"/>
					    					<input name="form.lastname" id="lastname" class="text" style="width:75px" maxlength="10"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sname"></span> 
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">密码:</td>
					    				<td colspan="3" >
					    					<input type="password" name="form.password" id="password" class="text" style="width:154px" valid="required|isPassword" errmsg="密码不能为空!|密码只能以字母数字下划线组成6至16位!"/>
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
					    					<input name="form.email" id="email" class="text" maxlength="50" style="width:154px" valid="isEmail" errmsg="邮箱格式不正确！"/>
					     				</td>
					    
					  				</tr>
					   			</table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="save();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="back();"  />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    
  </form>
  </body>
</html>