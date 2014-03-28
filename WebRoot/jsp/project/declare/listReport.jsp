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
<title>上报申请信息管理</title>

<script>
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
	 
	var path="<%=path%>/jsp/yearfileUpload.jsp?pathname=" + name;

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
	
function find(){
	 input_trim();
	 	document.getElementById("searchA").value=document.getElementById("A").value;
	 	document.getElementById("searchB").value=document.getElementById("B").value;
	 	document.getElementById("searchC").value=document.getElementById("C").value;
	 	document.getElementById("searchD").value=document.getElementById("D").value;
	 	document.getElementById("searchE").value=document.getElementById("E").value;
	 	document.getElementById("searchF").value=document.getElementById("F").value;
	 	document.getElementById("searchG").value=document.getElementById("G").value;
		document.form.action="<%=path%>/sbdeclare!findAndAuto";
		document.form.submit();
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
						<td>申报单位：</td>
						<td><input id="A" name="A" value="" readonly="readonly"><input type="button" class="select_button" onclick="unitDepartTree('ud_sno','A');" /></select></td>
						<td>年份：</td>
						<td colspan="3"><select id="B" name="B"><option>2013</option>
								<option selected="selected">2014</option></select></td>
						<td>项目所在单位：</td>
						<td><input id="C" name="C" value="" readonly="readonly"><input type="button" class="select_button" onclick="unitDepartTree('ud_sno','C');" /></td>
						<td>项目名称：</td>
						<td><input id="D" name="D" value=""></td>
					</tr>
					<tr bgcolor="#D5EAFB">
						<td>项目负责人：</td>
						<td><input id="E" name="E" value="" readonly="readonly"><input type="button" class="select_button" onclick="empTree('emp_sno','E');" /><input type="hidden" name="form.EMP_SNO" id="emp_sno" value="" /></td>
						<td>导入时间：</td>
						<td>
						<input type="text" id="F" name="F" value="${form.searchF}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择开始日期!">
						</td>
						<td>至</td>
						<td><input type="text"id="G" name="G" value="${form.searchG}" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" valid="required" errmsg="请选择结束日期!"></td>
						<td colspan="4"><a href="javascript:void(0);" onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0" /> 查询</a></td>
					</tr>
					<tr bgcolor="#0E6BB1"><!-- importExcel -->
						<td colspan="7"><span class="STYLE1"
							style="white-space: nowrap;">项目汇总信息列表</span></td>
						<td><a href="#"><span class="STYLE1">项目汇总信息表下载(模板)</span></a></td>
						<td><a title="" href="javascript:void(0);" onclick="importRpExcel('sbdeclare!update')">
						<img src="<%=path %>/<s:property value="#session.operList.get(\"020207\").oper_simg"/>" width="10" height="10" border="0"/>
						<span class="STYLE1">导入项目汇总表</span></a></td>
						<td><a href="#"><span class="STYLE1">导出表(按单位统计)</span></a></td>
					</tr>
				</table>
				<!-- 数据展示区域 -->
				<table width="100%" id="table1" class="table" border="0"
					cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr bgcolor="#CBE0FF" class="STYLE10">
						<th width="40px" height="20"><input type="checkbox"
							name="checkbox" id="checkbox" onclick="checkAll(this);" /></th>
						<th width="40px">序号</th>
						<th width="100px">申报单位</th>
						<th width="120px">附件</th>
						<th>项目名称</th>
						<th width="100px">项目负责人</th>
						<th width="80px">项目申报金额（万元）</th>
						<th width="120px">项目批复金额（万元）</th>
						<th width="120px">项目类型</th>
						<th width="120px">导入时间</th>
						<th >关联初申报</th>
					</tr>
                    <s:iterator value="list" var="v" status="s">
					<tr bgcolor="#ffffff" class="STYLE19">
						<td width="40px" height="20"><input type="checkbox"
							name="checkbox" id="ibox" onclick="checkOne(this);" /></td>
						<td width="40px"><s:property value="%{#s.index+1}" /></td>
						<td title="${v.RP_SREPORTUNITNAME}" width="100px"><s:property value="#v.RP_SREPORTUNITNAME" /></td>
						<td title="${v.RP_SNO}" width="80px"><a href="#"><span>查看</span></a></td>
						<td title="${v.RP_SPROJECTNAME}" width="120px"><s:property value="#v.RP_SPROJECTNAME" /></td>
						<td title="${v.RP_SPERSON}" width="120px"><s:property value="#v.RP_SPERSON" /></td>
						<td title="${v.RP_SREPORTTOTAL}" width="120px"><s:property value="#v.RP_SREPORTTOTAL" /></td>
						<td title="${v.RP_STOTAL}" width="120px"><s:property value="#v.RP_STOTAL" /></td>
						<td title="${v.RP_STYPE}" width="120px"><s:property value="#v.RP_STYPE" /></td>
						<td title="${v.RP_SREPLYDATE}" width="120px"><s:property value="#v.RP_SREPLYDATE" /></td>
						<td title="${v.RPB_SNO}" width="120px"><s:property value="#v.RPB_SNO" /></td>
					</tr>
					</s:iterator>
					<div align="center">
						<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
						<!-- TODO -->
							<page:page uri="/sbdeclare!findAndAuto"></page:page>
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
        <input type="hidden" id="searchB" name="form.searchB" value="${form.searchB}" />
        <input type="hidden" id="searchC" name="form.searchC" value="${form.searchC}" />
        <input type="hidden" id="searchD" name="form.searchD" value="${form.searchD}" />
        <input type="hidden" id="searchE" name="form.searchE" value="${form.searchE}" />
        <input type="hidden" id="searchF" name="form.searchF" value="${form.searchF}" />
        <input type="hidden" id="searchG" name="form.searchG" value="${form.searchG}" />
	</form>
</body>
</html>