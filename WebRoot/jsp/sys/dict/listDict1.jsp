<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>字典管理</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/images/favicon.ico" />
<style>
    body{background:#eef2fb;}
</style>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset cols="50%,1,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="<%=path %>/dict!find" noresize="noresize" frameborder="0" name="left" scrolling="auto" marginwidth="0" marginheight="0"   />
	<frame   noresize="noresize" frameborder="1"   marginwidth="0" marginheight="0"   />
	<frame src="<%=path %>/jsp/sys/dict/right.jsp" name="right" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"   />
  </frameset>
</html>
