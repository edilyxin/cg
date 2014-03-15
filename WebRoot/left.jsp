<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="left" id="left">
<div class="left_l">
  <img src="image/left1.jpg" width="212" height="71" />
  <ul>
   <li class="li1"><a href="#">功能管理</a></li>
   <li class="li2"><a href="#">操作管理</a></li>
   <li class="li3"><a href="#">编码管理</a></li>
   <li class="li4"><a href="#">角色管理</a></li>
   <li class="li5"><a href="#">用户管理</a></li>
   <li class="li6"><a href="#">字典管理</a></li>
  </ul>
</div>
<div class="left_r" onclick="toggleFrame()" id="left_r"><img src="image/center.jpg" width="12" height="34" /></div>
<script type="text/javascript">
function  toggleFrame(){
	 if(window.parent.document.getElementById("rowFrame").cols=="226,*"){
		window.parent.document.getElementById("rowFrame").cols="13,*"
		document.getElementById("left_r").style.left="0"
		document.getElementById("left_r").getElementsByTagName("img")[0].src="image/showcenter.jpg"
	}else{
		window.parent.document.getElementById("rowFrame").cols="226,*"
		document.getElementById("left_r").style.left="212px"
		document.getElementById("left_r").getElementsByTagName("img")[0].src="image/center.jpg"
	} 
	
}
setInterval( function (){document.getElementById("left").style.height=document.documentElement.clientHeight+'px'},1)
</script>
</div>
</body>
</html>
