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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title> 
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

//保存角色分配
 function toRole(){
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
	
	 if(flag==0){
		alert("请选择一条记录！");
		return;
	 }
	 if(confirm("是否分配？")){	
		document.form1.action="<%=path%>/user!saveRoleDistribute";
		document.form1.submit();
	 }	
  }
  
//回收角色的分配
 function cancelUserRoles(){
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
	
	 if(flag==0){
		alert("请选择一条记录！");
		return;
	 }
	 if(confirm("是否回收选中的角色？")){	
		document.form1.action="<%=path%>/user!cancelUserRoles";
		document.form1.submit();
	 }	
  }
  //javascript:window.history.go(-1)
 function back(){
	window.location.href="<%=path%>/user!find";
}
</script>

</head>

<body>

<form name="form1" method="post">
<input type="hidden" name="userId" value="${form.userid}"/>
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
					<span style="white-space:nowrap;">&nbsp;&nbsp;用户名：${form.screenname}</span>&nbsp;&nbsp;
                	<span style="white-space:nowrap;">&nbsp;&nbsp;姓名：${form.firstname}</span>
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">用户角色分配</span></td>
              </tr>
            </table></td>
					<td align="right" >
            <span class="STYLE1" >
				<a href="#" onclick="toRole();"><img src="<%=path %>/images/gw2.gif" width="10" height="10" border="0"/> <span class="STYLE1">分配角色</span></a>&nbsp;
				<a href="#" onclick="cancelUserRoles();"><img src="<%=path %>/images/gw2.gif" width="10" height="10" border="0"/> <span class="STYLE1">回收角色</span></a>&nbsp;
				<a href="#" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            </span>
            </td>
					</tr>
			</table>
			<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    <table width="400"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#95B0B9">
		<tr bgcolor="#CBE0FF">
        <th width="40" height="20" > 
        	<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  />
        </th>
        <th width="40" height="20" nowrap="nowrap">序号</th>
        <th width="100" height="20" nowrap="nowrap">角色代码</th>
        <th width="100" height="20" nowrap="nowrap">角色名称</th>
        <th height="20" nowrap="nowrap">角色描述</th>
      </tr>
      <s:iterator var="role" value="roleList" status="status">
      	<tr bgcolor="#FFFFFF">
        <td height="20"> 
          	<input type="checkbox" name="idcheckbox" onclick="checkOne();" value="${role.role_sno}"
	          	<s:iterator var="r" value="roleList2">
	          		<s:if test="%{#r.role_sno==#role.role_sno}">checked</s:if>
	          	</s:iterator>
          	/>
        </td>
        <td height="20" nowrap="nowrap">${status.count}</td>
        <td height="20" nowrap="nowrap" title="${role.role_sno }">${role.role_sno }</td>
        <td height="20" nowrap="nowrap" title="${role.role_sname} ">${role.role_sname}</td>
        <td height="20" nowrap="nowrap" title="${role.role_sdesc}">${role.role_sdesc}</td>
      </tr>
      </s:iterator>
    
</table>
			</div>
  		</div>
		 
		</div>
</form>
</body>
</html>

