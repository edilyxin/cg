<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path%>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<script>

  function checkAll(box){  //全选或全不选
	form1.checkbox.checked = box.checked;
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
  		form1.idcheckbox.checked = box.checked;	
  		return;
  	}
  	if(box.checked) {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = true;
		}
	} else {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = false;
		}
	}
  }
  
  function checkOne(){  //选一个时全选或全不选
  	
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
		form1.checkbox.checked = form1.idcheckbox.checked;
		return;
  	}
  	var numBox =0;
	for (var i = 0; i < numRow; i++) {
		if(form1.idcheckbox[i].checked){
			numBox++;
		}
	}
	if(numBox==numRow){
		form1.checkbox.checked = true;
	}else {
		form1.checkbox.checked = false;
	}
  }
  
  //查询
  function findList(){
  input_trim();
  	 document.getElementById("searchA1").value=document.getElementById("searchA").value;
	 document.getElementById("searchB1").value=document.getElementById("searchB").value;
     document.getElementById("searchC1").value=document.getElementById("searchC").value;
     document.getElementById("searchD1").value=document.getElementById("searchD").value;
	 document.form1.submit();
  }
  
  //新增
  function toAdd(){
  	document.form1.action="school!toAdd";
	document.form1.submit();
  }

 function toUpdate(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
		}
	  }
	
	 if(flag==0)
	 {
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？"))
	 {
		document.form1.action="school!toUpdate";
		document.form1.submit();
	 }
	}
	
	//删除
	function del(){
	 	 
	var obj1=document.getElementsByName("sh_sisvalid");
 	if(document.form1.idcheckbox==null){
		  return;
	}
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	    var knum=0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
				knum=i;
				if(obj1[knum].value==1)
			  	 {
			  
			  	 }else{
			  	    alert("只能对不启用状态信息删除!");
			  	    return;
			  	 }
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
		}
	  }
	
	 if(flag==0)
	 {
		alert("请至少选择一条记录！");
		return;
	 }
	  if(obj1[knum].value=="1")
  	 {
  	 }else{
  	    alert("只能对不启用状态信息删除!");
  	    return;
  	 }
	 
	 if(confirm("是否删除？"))
	 {
		document.form1.action="<%=path%>/school!toDelete";
		document.form1.submit();
	 }
}

	//启用或不启用
	function isValid(){
		if(document.form1.idcheckbox==null){
		  return;
	}
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
		}
	  }
	
	 if(flag==0)
	 {
		alert("请至少选择一条记录！");
		return;
	 }
	 if(confirm("是否执行该操作？"))
	 {
		document.form1.action="<%=path%>/school!changeValid";
		document.form1.submit();
	 }
}

 
</script>

</head>

<body >

<form name="form1" id="form1" action="<%=path%>/school!find" method="post">


<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>基础管理  &gt;校区信息</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
			        <span style="white-space:nowrap;">&nbsp;&nbsp;校区名称:
			        	<input type="text" name="searchA" id="searchA" value="${form.searchA }" maxlength="50"/>
			        </span>
			        <span  style="white-space:nowrap;">&nbsp;&nbsp;校区简称:
			        	<input type="text" name="searchB" id="searchB" value="${form.searchB }" maxlength="50"/>
			        </span>
			        <span  style="white-space:nowrap;">&nbsp;&nbsp;校区类型:
			        	<select name="searchC" id="searchC">
						<option value="">--请选择--</option>
						<option value="0" <c:if test="${form.searchC==0 }">selected</c:if>>主校区</option>
						<option value="1" <c:if test="${form.searchC==1 }">selected</c:if>>附校区</option>
						</select>
					</span>
					<span style="white-space:nowrap;">&nbsp;&nbsp;是否可用:
						<select name="searchD" id="searchD">
						<option value="">--请选择--</option>
						<option value="0" <c:if test="${form.searchD==0}">selected</c:if>>可用</option>
						<option value="1" <c:if test="${form.searchD==1}">selected</c:if>>不可用</option>
						</select>
					</span>
					<span style="white-space:nowrap;">&nbsp;&nbsp;
						<a style="cursor:hand" onclick="findList();"><img src="<%=path%>/images/zoom.png" width="15" height="15"/>查询</a>
					</span>
					<!-- 查询条件 value="${form.searchA}" -->
					<input type="hidden" id="searchA1" name="form.searchA" />
					<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
					<input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
					<input type="hidden" id="searchD1" name="form.searchD" value="${form.searchD}"/>
					
				 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">校区信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            <span class="STYLE1" style="white-space:nowrap;">
					<a href="javascript:void(0)" onclick="toAdd();"><img src="<%=path%>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">新增</span></a>&nbsp; 
	              	<a href="javascript:void(0)" onclick="toUpdate();"><img src="<%=path%>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">修改</span></a>&nbsp;
	              	<a href="javascript:void(0)" onclick="del();"><img src="<%=path%>/images/del_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">删除</span></a>&nbsp;&nbsp;
	              	<a href="javascript:void(0)" onclick="isValid();"><img src="<%=path%>/images/gw2.gif" width="10" height="10" border="0"/> <span class="STYLE1">有效/无效</span></a>&nbsp;
	            </span>
	            </td>
					</tr>
			</table>
    	<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   		<table width="900"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce"> 
	 	<tr bgcolor="#CBE0FF">
	   	<th width="40" height="25" class="STYLE10">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	   	</th>
	   		<th width="40"   class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
	   		<th width="100" height="20" class="STYLE6"><div align="center"><span class="STYLE10">校区名称</span></div></th>
	   		<th width="100" height="20" class="STYLE6"><div align="center"><span class="STYLE10">校区简称</span></div></th>
			<th height="20" class="STYLE6"><div align="center"><span class="STYLE10">校区地址</span></div></th>
			<th width="100" height="20" class="STYLE6"><div align="center"><span class="STYLE10">校区类型</span></div></th>
			<th width="120" height="20" class="STYLE6"><div align="center"><span class="STYLE10">校区占地面积(㎡)</span></div></th>
			<th width="120" height="20" class="STYLE6"><div align="center"><span class="STYLE10">土地编号</span></div></th>
			<th width="80" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否可用</span></div></th>
			<th width="80" height="20" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></th>
	 	</tr>
	 	<s:iterator	var="vo" value="list" status="s" >
	 		<tr bgcolor="#ffffff" align="center"  <s:if test="#vo.sh_sisvalid==\"1\"">style="color:red;"</s:if>>
		 	 <td height="20"><input name="idcheckbox"  type="checkbox" value="${vo.sh_sno}" />
		 	 <input type="hidden" id="sh_sisvalid" name="sh_sisvalid" value="${vo.sh_sisvalid}"/></td>
		 	 <td title="<s:property value="#s.index+1"/>"><s:property value="#s.index+1"/></td>
		 	 <td title="${vo.sh_sname }">${vo.sh_sname }</td>
		 	 <td title="${vo.sh_ssname }">${vo.sh_ssname }</td>
		 	 <td title="${vo.sh_sadder }">${vo.sh_sadder }</td>
		 	 <td title="${vo.sh_stype==0?'主校区':'附校区'}">${vo.sh_stype==0?'主校区':'附校区'}</td>
		 	 <td title="${vo.sh_narea }">${vo.sh_narea }</td>
		 	 <td title="${vo.td_sno }">${vo.td_sno }</td>
		 	 <td title="${vo.sh_sisuse=='0'?'可用':'不可用'}">${vo.sh_sisuse=='0'?'可用':'不可用'}</td>
		 	 <td title="${vo.sh_sisvalid=='0'?'有效':'无效'}">${vo.sh_sisvalid=='0'?'有效':'无效'}</td>
		 	</tr>		
	 	</s:iterator>
		</table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/school!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
</form>
</body>
</html>

 