<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
<title>Error</title>  
<script type="text/javascript" >
 $(document).ready(function(){
// 		alert("连接异常，请重新登陆");
//		top.location = "<%=path %>/";  
 });  
 function logout(){
	top.location = "<%=path %>/";
	return false;
} 
 </script>
<style>
body {
	margin:0 auto;
}
.egtError{
}
</style>
</head>
<body  >
<table align="center" width="100%" height="100%">
<tr>
<td align="center" valign="middle" onClick="logout();" style="cursor:pointer;color:red;" ><img src="<%=path %>/images/error.gif" width="50" height="50"  ><br><br>服务器连接异常，请重新登录！</td>
</tr>
</table>
  
</body>
</html>
