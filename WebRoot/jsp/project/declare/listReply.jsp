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
<title>批复项目管理</title>

<script>
function importData(){
	alert("快到碗里来");
	document.form.action="<%=path%>/manually!importData";
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
	 
	var path="<%=path%>/jsp/allfileUpload.jsp?pathname="+name;
	  
	var returnValue = window.showModalDialog(path,obj,'dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	//alert(returnValue);
	if(returnValue==undefined){
	    return false;
	}
	if(returnValue!=true){
		alert("导入文件失败！");
	}
}

function find(){
	input_trim();
 	document.getElementById("searchA").value=document.getElementById("sa").value;
 	document.getElementById("searchB").value=document.getElementById("sb").value;
 	document.getElementById("searchC").value=document.getElementById("sc").value;
 	document.getElementById("searchD").value=document.getElementById("sd").value;
 	document.getElementById("searchE").value=document.getElementById("se").value;
 	document.getElementById("searchF").value=document.getElementById("sf").value;
	document.form.action = "<%=path%>/manually!findForAuto";
	document.form.submit();
}

function findDetail(sno){
	self.parent.frames['detail'].document.form.action="<%=path%>/manually!findDetailForAuto?sno="
				+ sno;
		self.parent.frames['detail'].document.form.submit();
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
						<td><select id="sa" name="sa"><option>2013</option>
								<option selected="selected">2014</option></select></td>
						<td>院系：</td>
						<td colspan="3"><input id="sb" name="sb" value="${form.searchB}" readonly="readonly"/><input type="button" class="select_button" onclick="unitDepartTree('ud_sno','sb');" /></td>
						<td>项目名称：</td>
						<td><input id="sc" name="sc" value="${form.searchC}" /></td>
					</tr>
					<tr bgcolor="#D5EAFB">
						<td>项目负责人：</td>
						<td><input id="sd" name="sd" value="${form.searchD}" readonly="readonly"/><input type="button" class="select_button" onclick="empTree('emp_sno','sd');" /><input type="hidden" name="form.EMP_SNO" id="emp_sno" value="" /></td>
						<td>导入时间：</td>
						<td><input type="text" id="se" name="se" value="${form.searchE}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择开始日期!"></td>
						<td>至</td>
						<td><input type="text" id="sf" name="sf" value="${form.searchF}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择结束日期!"></td>
						<td colspan="2"><a href="javascript:void(0);" onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0" /> 查询</a></td>
					</tr>
					<tr bgcolor="#0E6BB1">
						<td colspan="5"><span class="STYLE1" style="white-space: nowrap;">项目批复信息汇总信息列表</span></td>
						<td><a href="#"><span class="STYLE1">批复模板下载</span></a></td>
						<td><a title="导入批复信息" href="javascript:void(0);" onclick="importRpExcel('manually!update')"> <img src="<%=path%>/<s:property value="#session.operList.get(\"020207\").oper_simg"/>"
								width="10" height="10" border="0" /> <span class="STYLE1">导入批复信息</span></a></td>
						<td><a href="#"><span class="STYLE1">导出表(按单位统计)</span></a></td>
					</tr>
				</table>
				<!-- 数据展示区域 -->
				<table width="100%" id="table1" class="table" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr bgcolor="#CBE0FF" class="STYLE10">
						<th width="40px" height="20"><input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);" /></th>
						<th width="100px">项目编号</th>
						<th width="120px">项目名称</th>
						<th width="120px">国库预算批复明细</th>
						<th width="120px">是否涉及政府采购</th>
						<th width="120px">批复金额（万元）</th>
						<th width="100px">负责人</th>
						<th width="120px">导入时间</th>
						<th width="120px">导入经办人</th>
					</tr>
					<s:iterator value="list" var="v" status="s">
						<tr bgcolor="#ffffff" class="STYLE19">
							<td width="40px" height="20"><input type="checkbox" name="checkbox" id="ibox" onclick="checkOne(this);" /></td>
							<td title="${v.EP_SNO}"><a href="javascript:void(0);" onclick="findDetail('<s:property value="#v.EP_SNO" />')"><s:property value="#v.EP_SNO" /></a></td>
							<td title="${v.EP_SPERDEPARTNAME}"><s:property value="#v.EP_SPERDEPARTNAME" /></td>
							<td title="${v.EP_SNAME}"><s:property value="#v.EP_SNAME" /></td>
							<td title="${v.EP_SISZC}"><s:property value="#v.EP_SISZC" /></td>
							<td title="${v.EP_SMONEY}"><s:property value="#v.EP_SMONEY" /></td>
							<td title="${v.EP_SPERSON}"><s:property value="#v.EP_SPERSON" /></td>
							<td title="${v.EP_SREPLYDATE}"><s:property value="#v.EP_SREPLYDATE" /></td>
							<td title="${v.EP_SREPLYBY}"><s:property value="#v.EP_SREPLYBY" /></td>
						</tr>
					</s:iterator>
				</table>
				<div align="center">
					<!-- 分页标签BEGIN -->
					<s:if test="list.size()!=0">
						<page:page uri="/manually!findForAuto"></page:page>
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
		<input type="hidden" id="searchA" name="form.searchA" value="${form.searchA}" /> <input type="hidden" id="searchB" name="form.searchB" value="${form.searchB}" /> <input type="hidden" id="searchC"
			name="form.searchC" value="${form.searchC}" /> <input type="hidden" id="searchD" name="form.searchD" value="${form.searchD}" /> <input type="hidden" id="searchE" name="form.searchE"
			value="${form.searchE}" /> <input type="hidden" id="searchF" name="form.searchF" value="${form.searchF}" />
	</form>
</body>
</html>