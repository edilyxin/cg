<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>内网门户管理平台</title>
<style>
    body{background:#eef2fb;}
</style>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset cols="150,*" id="frame1" frameborder="NO" border="0" framespacing="0">
	<frame src="<%=path %>/unitDepart!toMenuUD" name="leftFrame1" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"   />
	<frame src="<%=path %>/unitDepart!find" name="main1" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"   />
</frameset>
</html>
