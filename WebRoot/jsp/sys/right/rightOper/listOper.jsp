<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self">
<title>操作管理</title> 
<script>
function findInfo(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;
 document.all.form1.action="<%=path %>/rightOper!find";
 document.all.form1.submit();
}
function toAdd(){
	document.form1.action="<%=path%>/rightOper!toAdd";
	document.form1.submit();

}
 function toUpdate(){
  var obj1=document.getElementsByName("oper_sisvalid");
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
		document.form1.action="<%=path%>/rightOper!toUpdate";
		document.form1.submit();
	 }	
  }
  
 function del(){
 var obj1=document.getElementsByName("oper_sisvalid");
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
			  	    alert("只能对无效状态的信息删除!");
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
  	    alert("只能对无效状态的信息删除!");
  	    return;
  	 }
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/rightOper!toDelete";
		document.form1.submit();
	 }
  }  
 function changeValid(){
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
	 if(confirm("是否修改所选记录状态？"))
	 {
		document.form1.action="<%=path%>/rightOper!changeValid";
		document.form1.submit();
	 }
  }    

 //初始化功能名称和系统名称
 $(function() {
	 var paramObj = window.dialogArguments;
	 $("#sysint_sname").val(paramObj.sysint_sname);
	 $("#right_sname").val(paramObj.right_sname);
	 	getSysSelect('<s:property value="form.sysint_sno"/>','sysint_sno','<%=path %>');
 });		
 </script>

</head>
<body>
<form name="form1" method="post" action="<%=path %>/rightOper!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>操作信息</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
               	<span style="white-space:nowrap;">&nbsp;&nbsp;系统名称:
	               	<input type="text" id="sysint_sname" name="form.sysint_sname"  value="${form.sysint_sname}" readonly style="width:160px;background:#EEE" />
  					<input type="hidden" name="form.sysint_sno" value="<s:property value="#parameters['form.sysint_sno']"/>"/>
				</span>
				<span style="white-space:nowrap;">&nbsp;&nbsp;功能名称:
					<input type="text" id="right_sname" name="form.right_sname" value="${form.right_sname}" readonly style="width:160px;background:#EEE" />
                  <input type="hidden" name="form.right_sno" value="<s:property value="#parameters['form.right_sno']"/>"/>
				</span>
				 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">操作信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
            	<span class="STYLE1" style="white-space:nowrap;">
				<a href="javascript:void(0);" onclick="toAdd();"><img src="<%=path %>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">新增</span></a>&nbsp; 
  				<a href="javascript:void(0);" onclick="toUpdate();"><img src="<%=path %>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">修改</span></a>&nbsp;
  				<a href="javascript:void(0);" onclick="del();"><img src="<%=path %>/images/del_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">删除</span></a>&nbsp;
  				<a href="javascript:void(0);" onclick="changeValid();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">有效/无效</span></a>&nbsp;
            	</span>
            	</td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
     <table  width="1400px" id ="table1" class="table"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      	<tr bgcolor="#CBE0FF">
	  	<td width="40px" height="25"  class="STYLE10">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</td>
	  	<td width="40px"    class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
	  	<td width="180px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></td>
	  	<td width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">功能编号</span></div></td>
	  	<td width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">功能名称</span></div></td>
		<td width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">操作编号</span></div></td>
		<td width="120px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">操作名称</span></div></td>
		<td width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">操作类型</span></div></td>
		<td width="150px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">图标地址</span></div></td>
		<td width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否可用</span></div></td>
		<td width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否按钮</span></div></td>
	    <td width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否有效</span></div></td>
	    <td height="20"  class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></td>
		</tr>
      <s:iterator value="list" var="oper" status="s">
       <tr bgcolor="#FFFFFF" align="center" class="STYLE19" <s:if test="#oper.oper_sisvalid==\"1\"">style="color:red;"</s:if>>
        <td height="20" > 
          <input type="checkbox" name="idcheckbox" id="idcheckbox" value="${oper.oper_sno}-${oper.sysint_sno}"   />
          <input type="hidden" id="oper_sisvalid" name="oper_sisvalid" value="${oper.oper_sisvalid}"/>
        </td>
        <td  ><s:property value="#s.index + 1" /></td>
        <td title="${oper.sysint_sname}">${oper.sysint_sname}</td>
        <td title="${oper.right_sno}">${oper.right_sno}</td>
        <td title="${oper.right_sname}">${oper.right_sname}</td>
        <td title="${oper.oper_sno}">${oper.oper_sno}</td>
        <td title="${oper.oper_sname}">${oper.oper_sname}</td>
        <td title="${oper.ditem_sname}">${oper.ditem_sname}</td>
        <td title="${oper.oper_simg}"><s:if test="%{#oper.oper_simg!=null}"><img src="<%=path %>/<s:property value="#oper.oper_simg"/>"  style="border:1px #666666 solid;" alt="操作图标" width="15" height="15"/></s:if></td>    
        <td>
        <s:if test='%{#oper.oper_nmorb == "0"}'>可用</s:if>
		<s:if test='%{#oper.oper_nmorb == "1"}'>不可用</s:if></td>  
        <td>
        <s:if test='%{#oper.oper_nmorb == "0"}'>是</s:if>
		<s:if test='%{#oper.oper_nmorb == "1"}'>不是</s:if></td> 
        <td>
        <s:if test='%{#oper.oper_sisvalid == "0"}'>有效</s:if>
		<s:if test='%{#oper.oper_sisvalid == "1"}'>无效</s:if></td>
		<td title="${oper.oper_sdesc}">${oper.oper_sdesc}</td>
   </tr>
   </s:iterator>
  </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
					 
						<s:if test="list.size()!=0">
							<page:page uri="/rightOper!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
 
		 
<!-- 分页标签END -->
   		</div>
		</div>
		 
<input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
<input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
</form>
</body>
</html>