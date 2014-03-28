<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String s = request.getParameter("sno");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申报批复项目明细查看</title>
<script type="text/javascript">
</script>
</head>
<body>
    <form id="form" name="form" method="POST">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr bgcolor="#D5EAFB">
			<td width="120px">项目单位：</td>
			<td><s:property value="detPunit"/></td>
		</tr>
		<tr bgcolor="#D5EAFB">
			<td>项目名称：</td>
			<td><s:property value="detPname"/></td>
		</tr>
		<tr bgcolor="#D5EAFB">
			<td>项目代码：</td>
			<td><s:property value="detPcode"/></td>
		</tr>
	</table>
	<!-- 数据展示区域 -->
	<div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
	<table width="100%" id="table1" class="table" border="0"
		cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF" class="STYLE10">
			<th width="100px" rowspan="2">序号</th>
			<th width="120px" rowspan="2">明细项目名称</th>
			<th width="120px" rowspan="2">明细预算内容</th>
			<th width="40px" rowspan="2">单位</th>
			<th width="120px" colspan="3">送审额</th>
			<th width="120px" colspan="3">审定额</th>
			<th width="120px" rowspan="2">无法确定额</th>
			<th width="120px" colspan="3">审减额</th>
			<th width="120px" rowspan="2">审核说明</th>
		</tr>
		
		<tr bgcolor="#CBE0FF" class="STYLE10">
			<th>单位</th>
			<th>金额</th>
			<th>总金额</th>
			<th>单位</th>
			<th>金额</th>
			<th>总金额</th>
			<th>单位</th>
			<th>金额</th>
			<th>总金额</th>
		</tr>
		<s:iterator value="details" var="v" status="s">
		<tr bgcolor="#ffffff" class="STYLE19">
			<td ><s:property value="%{#s.index+1}" /></td>
			<td title="${v.EPD_SNAME}"><s:property value="#v.EPD_SNAME" /></td>
			<td title="${v.EPD_SNAMEXIAO}"><s:property value="#v.EPD_SNAMEXIAO" /></td>
			<td title="${v.EPD_SUNIT}"><s:property value="#v.EPD_SUNIT" /></td>
			<td title="${v.EPD_NPRICE}"><s:property value="#v.EPD_NPRICE" /></td>
			<td title="${v.EPD_NTOTAL}"><s:property value="#v.EPD_NTOTAL" /></td>
			<td title="${v.EPD_NNUMSONG}"><s:property value="#v.EPD_NNUMSONG" /></td>
			<td title="${v.EPD_NPRICESONG}"><s:property value="#v.EPD_NPRICESONG" /></td>
			<td title="${v.EPD_NTOTALSONG}"><s:property value="#v.EPD_NTOTALSONG" /></td>
			<td title="${v.EPD_NCANNOT}"><s:property value="#v.EPD_NCANNOT" /></td>
			<td title="${v.EPD_NNUMJIAN}"><s:property value="#v.EPD_NNUMJIAN" /></td>
			<td title="${v.EPD_NPRICEJIAN}"><s:property value="#v.EPD_NPRICEJIAN" /></td>
			<td title="${v.EPD_NTOTALJIAN}"><s:property value="#v.EPD_NTOTALJIAN" /></td>
			<td title="${v.EPD_NTOTALJIAN}"><s:property value="#v.EPD_NTOTALJIAN" /></td>
			<td title="${v.EPD_SAPPROVENOTE}"><s:property value="#v.EPD_SAPPROVENOTE" /></td>
		</tr>
		</s:iterator>
	</table>
	</div>
	<input type="hidden" id="sno" name="sno" value="${s}"> 
	</form>
</body>
</html>