<%@ page language="java" import="java.util.*,com.rc.util.UserInfo" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//模拟用户登录
//UserInfo userInfo=new UserInfo();
//userInfo.setUserid(Long.parseLong("21"));
//userInfo.setScreenname("test6");
//request.getSession().setAttribute("userInfo",userInfo);

%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script> 

function saveUpdatePwd(){
	//判断是否允许提交表单
	if($("#Submit").attr("flag")==0){
		return false;
	};
	if(validator(document.form1)){
		document.form1.action="<%=path%>/user!saveChangePwd";
		document.form1.submit();
	}
}

//ajax校验输入的原始密码
function checkPwd(obj){
	  $.ajax({  
			type: "POST",  
			url: "user!checkPwd",  
			data: {  
				"pwd":obj.value,
				"form.userid":'${session.userInfo.userid}'
			},  
			datatype:"text",  
			success: function(data) {  
				if(data=="fail"){
					$("#errMsg_password").text("原始密码错误，请重新输入！");
					$("#Submit").attr("flag",0);//0为不能提交表单，1为允许提交表单
				}else{
					$("#errMsg_password").text("");
					$("#Submit").attr("flag",1);//0为不能提交表单，1为允许提交表单
				}
			}
       });  
}
function back(){
	window.location.href="<%=path%>/user!find";
}
</script>
</head>
<body>
<form name="form1" method="post" action="">
<div class="bigBox" id="idwidth">
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改密码</span></td>
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
					 				<tr>
					    				<td nowrap align="right" width="45%">
					    					用户名:
					    				</td>
					    				<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    					${session.userInfo.screenname}
					    					<input type="hidden" name="form.userid" id="userid" value="${session.userInfo.userid}"/>
					    					<span style="color:red;" id="errMsg_userid"></span>
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">原始密码:</td>
					    				<td colspan="3">
					    					<input type="password" name="form.password" id="password" class="text" style="width:154px" valid="required" errmsg="原始密码不能为空!" onblur="checkPwd(this);"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					<span style="color:red;" id="errMsg_password"></span> 
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">修改密码:</td>
					    				<td colspan="3" >
					    					<input type="password" name="form.updatePwd" id="updatePwd" class="text" style="width:154px" valid="required|isPassword" errmsg="修改密码不能为空!|修改密码只能以字母数字下划线组成6至16位!"/>
					    					<span style="color:red;"> *</span> &nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_us_spwd"></span>
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap align="right">确认密码:</td>
					    				<td colspan="3" >
					    					<input type="password" name="form.confirmPwd" id="confirmPwd" class="text" style="width:154px" valid="required|equal" equalName="updatePwd" errmsg="确认密码不能为空!|两次密码不同!"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_us_spwd1"></span> 
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
        					  <input type="button" value="保存" class="button" onclick="saveUpdatePwd();"/>&nbsp;
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
 