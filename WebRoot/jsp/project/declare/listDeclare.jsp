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

<script>
//TODO 查询
function find(){
    input_trim();
 	document.getElementById("searchA").value=document.getElementById("A").value;
 	/* document.getElementById("searchB1").value=document.getElementById("B1").value; */
 	document.getElementById("searchB2").value=document.getElementById("B2").value;
 	document.getElementById("searchC").value=document.getElementById("C").value;
 	document.getElementById("searchD").value=document.getElementById("D").value;
 	document.getElementById("searchE").value=document.getElementById("E").value;
 	document.getElementById("searchF").value=document.getElementById("F").value;
	document.form.action="<%=path%>/pdeclare!find";
	document.form.submit();
}

//导出验证后的数据
function importData(){
	alert("importData");
	document.form.action="<%=path%>/pdeclare!importData";
	document.form.submit();
}

//导入Excel
function importRpExcel(name,pathname,Width,Height){
	if(Height==undefined)
	{
		Height = '200px';
	}
	if(Width==undefined)
	{
		Width = '300px';
	}
	 
	var path="<%=path%>/jsp/allfileUpload.jsp?pathname=" + name;

		var returnValue = window
				.showModalDialog(
						path,
						obj,
						'dialogHeight:'
								+ Height
								+ ';dialogWidth:'
								+ Width
								+ ';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
		if (returnValue == undefined) {
			return false;
		}
		if (returnValue != true) {
			alert("导入文件失败！");
		}
	}
</script>
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
						<td><select id="A"><option>2013</option><option selected="selected">2014</option></select></td>
						<td>院系：</td>
						<td colspan="4"><input id="B" size="40" readonly="readonly"><input type="button" class="select_button" onclick="unitDepartTree('B2','B');" /><input type="hidden" name="B2" id="B2" value="" /></td>
						<td>项目名称：</td>
						<td><input id="C"value="" size="40"></td>
					</tr>
					<tr bgcolor="#D5EAFB">
						<td>项目负责人：</td>
						<td><input id="D"value="" readonly="readonly"><input type="button" class="select_button" onclick="empTree('emp_sno','D');" /><input type="hidden" name="form.EMP_SNO" id="emp_sno" value="" /></td>
						<td>导入时间：</td>
						<td><input type="text" id="E" name="E" value="${form.searchE}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择开始日期!"></td>
						<td>至</td>
						<td><input type="text"id="F" name="F" value="${form.searchF}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择结束日期!"></td>
						<td colspan="4"><a href="javascript:void(0);" onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0" /> 查询</a></td>
					</tr>
					<tr bgcolor="#0E6BB1">
						<a>
							<td colspan="7"><span class="STYLE1" style="white-space: nowrap;">初申报信息列表</span></td>
							<td><a href="#"><span class="STYLE1">初申报项目汇总表下载(模板)</span></a></td> <!-- importExcel('导入初申报项目汇总表','unitDepart!toImport'); importData()-->
							<td><a title="导入初申报项目汇总表" href="javascript:void(0);" onclick="importRpExcel('pdeclare!update');">
							<img src="<%=path %>/<s:property value="#session.operList.get(\"020207\").oper_simg"/>" width="10" height="10" border="0"/>
							<span class="STYLE1">导入初申报项目汇总表</span></a></td>
							<td><a href="#"><span class="STYLE1">导出表(按单位统计)</span></a></td>
					</tr>
				</table>
				<!-- 数据展示区域 -->
				<table width="100%" id="table1" class="table" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr bgcolor="#CBE0FF" class="STYLE10">
						<th width="40px" height="20"><input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);" /></th>
						<th width="40px">序号</th>
						<th width="100px">院系</th>
						<th width="120px">附件</th>
						<th>项目名称</th>
						<th width="100px">项目负责人</th>
						<th width="80px">申报金额（万元）</th>
						<th width="120px">建议金额（万元）</th>
						<th width="120px">项目重要性</th>
						<th width="120px">专家意见</th>
						<th width="120px">导入时间</th>
					</tr>
					<s:iterator value="list" var="v" status="s">
						<tr bgcolor="#ffffff" class="STYLE19">
							<td width="40px" height="20"><input type="checkbox" name="checkbox" id="ibox" onclick="checkOne(this);" /></td>
							<td width="40px"><s:property value="%{#s.index+1}" /></td>
							<td title="${v.RPB_SREPORTUNITNAME}" width="100px"><s:property value="#v.RPB_SREPORTUNITNAME" /></td>
							<td title="${v.RPB_SNO}"><a href="#"><span>查看附件</span></a></td>
							<td title="${v.RPB_SPROJECTNAME}"><s:property value="#v.RPB_SPROJECTNAME" /></td>
							<td title="${v.RPB_SPERSON}"><s:property value="#v.RPB_SPERSON" /></td>
							<td title="${v.RPB_SREPORTTOTAL}"><s:property value="#v.RPB_SREPORTTOTAL" /></td>
							<td title="${v.RPB_SSUGGESTTOTAL}"><s:property value="#v.RPB_SSUGGESTTOTAL" /></td>
							<td title="${v.RPB_SLEVEL}"><s:property value="#v.RPB_SLEVEL" /></td>
							<td title="${v.RPB_SMEM}"><s:property value="#v.RPB_SMEM" /></td>
							<td title="${v.RPB_SREPLYDATE}"><s:property value="#v.RPB_SREPLYDATE" /></td>
						</tr>
					</s:iterator>
				</table>
				<div align="center">
					<!-- 分页标签BEGIN -->
					<s:if test="list.size()!=0">
						<page:page uri="/pdeclare!find"></page:page>
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
		<input type="hidden" id="searchA" name="form.searchA" value="${form.searchA}" />
        <%-- <input type="hidden" id="searchB1" name="form.searchB1" value="${form.searchB1}" /> --%>
        <input type="hidden" id="searchB2" name="form.searchB2" value="${form.searchB2}" />
        <input type="hidden" id="searchC" name="form.searchC" value="${form.searchC}" />
        <input type="hidden" id="searchD" name="form.searchD" value="${form.searchD}" />
        <input type="hidden" id="searchE" name="form.searchE" value="${form.searchE}" />
        <input type="hidden" id="searchF" name="form.searchF" value="${form.searchF}" />
	</form>
</body>
</html>