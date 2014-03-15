<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>初申报管理</title>

<script></script>
</head>
<body>
	<form id="form" name="form" method="POST">
		<div class="bigBox" id="idwidth">
			<!--外部大DIV，可以调整宽度-->
			<h2>
				<span><s:property value="#session.navbar" /></span>
			</h2>
			<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				
			</table>
			<table width="1200px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF" class="STYLE10">
	  	<th width="40px" height="20" >
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</th>
	  	<th width="40px">序号</th>
	  	<th width="100px">系统编号</th>
	  	<th width="120px">系统名称</th>
	  	<th width="120px">系统简称</th>
		<th width="100px">集成方式</th>
		<th width="80px" >系统图标</th>
		<th>系统访问地址</th>
		<th width="120px">用户账号参数</th>
		<th width="120px">用户密码参数</th>
		<th width="120px">用户类别参数</th>
		<th width="40px">状态</th>
		</tr></table>
		
			</div>
		</div>
	</form>
</body>
</html>