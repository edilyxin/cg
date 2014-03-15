<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Error</title>
<script language=JavaScript>
function logout(){
	top.location = "<%=path %>/";
	return false;
} 
</script>
<style>
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.egtError{
}
</style>
</head>
<body>
<table align="center" width="100%" height="100%">
<tr>
<td align="center" onClick="logout();" style="cursor:pointer;"><img src="<%=path %>/img/error.gif"></td>
</tr>
</table>
</body>
</html>
