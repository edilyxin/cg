<%@ page language="java" import="com.rc.sys.vo.*,java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/time.js"></script>
<style type="text/css">
ul li{}
</style>
</head>
<body style="word-break:keep-all;white-space:nowrap;background:#0D5E9F;">
<div class="top"  >
<table width="100%"   border="0"  cellpadding="0" cellspacing="0">
<tr>
	<td  >
 <div class="top1"  >
  	<img src="<%=path %>/image/top1.jpg" width="447" height="34" style="float:left"/>
  	<p><a href="<%=path %>/"   target="_parent"   style="cursor:hand;color: #000000;"><span class="tui">退出</span></a>
  	<span id="timeBox"></span>&nbsp;&nbsp;<span class="peo"  >当前用户</span>：<s:property value="#session.userInfo.username"/>  </p>
 </div>
 </td>
 </tr>
 </table>
 <div class="top2" id="navMenu" name="navMenu" >
  <img src="<%=path %>/image/top2.jpg" width="210" height="40"  style="float:left"/>
  <ul>
   <s:iterator value="#session.mainList" status="i" var="right">
    <li><a href="<%=path %>/login!loginMenuRight?mainID=<s:property value="#right.right_sno"/>&top=<s:property value="#right.right_sname"/>"  target="<s:property value="#right.right_sposition"/>" ><s:property value="#right.right_sname"/></a></li>
   </s:iterator>
  </ul>
 </div>
</div>
</body>
</html>
