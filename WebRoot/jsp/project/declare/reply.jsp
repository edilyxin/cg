<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
    body{background:#eef2fb;}
</style>
<title>批复管理</title>
</head>
<frameset rows="300,*" id="frame1" frameborder="NO" border="0" framespacing="0">
	<frame src="<%=path %>/manually!findForAuto" name="main" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"   />
	<frame src="<%=path %>/manually!findDetailForAuto" name="detail" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"   />
</frameset>

</html>