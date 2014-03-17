<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
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
<title>批复项目管理</title>

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
				<!-- 查询操作区域 -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr bgcolor="#D5EAFB">
						<td>年份：</td>
						<td><select><option>2012</option>
								<option>2013</option>
								<option>2013</option></select></td>
						<td>院系：</td>
						<td colspan="3"><input id="" name="" value="sss"></select></td>
						<td>项目名称：</td>
						<td><input></td>
					</tr>
					<tr bgcolor="#D5EAFB">
						<td>项目负责人：</td>
						<td><select><option>2012</option>
								<option>2013</option>
								<option>2013</option></select></td>
						<td>导入时间：</td>
						<td><select><option>2012</option>
								<option>2013</option>
								<option>2013</option></select></td>
						<td>至</td>
						<td><select><option>2012</option>
								<option>2013</option>
								<option>2013</option></select></td>
						<td colspan="2"><input type="button" id="" name=""
							value="查询项目汇总信息" /></td>
					</tr>
					<tr bgcolor="#0E6BB1">
						<td colspan="5"><span class="STYLE1"
							style="white-space: nowrap;">项目批复信息汇总信息列表</span></td>
						<td><a href="#"><span class="STYLE1">批量提交</span></a></td>
						<td><a href="#"><span class="STYLE1">项目汇总信息表下载(模板)</span></a></td>
						<td><a href="#"><span class="STYLE1">导入项目汇总表</span></a></td>
						<td><a href="#"><span class="STYLE1">导出表(按单位统计)</span></a></td>
					</tr>
				</table>
				<!-- 数据展示区域 -->
				<table width="1200px" id="table1" class="table" border="0"
					cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr bgcolor="#CBE0FF" class="STYLE10">
						<th width="40px" height="20"><input type="checkbox"
							name="checkbox" id="checkbox" onclick="checkAll(this);" /></th>
						<th width="100px">项目编号</th>
						<th width="120px">项目名称</th>
						<th>国库预算批复明细</th>
						<th width="100px">是否涉及政府采购</th>
						<th width="80px">批复金额（万元）</th>
						<th width="120px">负责人</th>
						<th width="120px">导入时间</th>
						<th width="120px">导入经办人</th>
					</tr>

					<tr bgcolor="#ffffff" class="STYLE19">
						<td width="40px" height="20"><input type="checkbox"
							name="checkbox" id="ibox" onclick="checkOne(this);" /></td>
						</th>
						<th width="40px">121212</th>
						<th width="100px">大学院系</th>
						<th width="120px"><a href="replyDetails.jsp">设备购置费</a></th>
						<th>项目名称</th>
						<th width="100px">项目负责人</th>
						<th width="80px">123456789</th>
						<th width="120px">123456789</th>
						<th width="120px">项目重要性</th>
						<th width="120px">导入时间</th>
					</tr>
					</table>
					<div align="center">
						<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/sysint!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center">
								<span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span>
							</div>
						</s:elseif>

						<!-- 分页标签END -->
					</div>
			</div>
		</div>
	</form>
</body>
</html>