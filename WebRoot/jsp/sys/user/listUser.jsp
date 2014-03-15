<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title> 
<script>

 //查询
  function findList(){
  	 input_trim();
  	 document.getElementById("searchA1").value=document.getElementById("searchA").value;
	 document.getElementById("searchB1").value=document.getElementById("searchB").value;
	 document.form1.submit();
  }

function toAdd(){
	document.form1.action="<%=path%>/user!toAdd";
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
		document.form1.action="<%=path%>/user!toUpdate";
		document.form1.submit();
	 }	
  }
  
 function del(){
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
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/user!toDelete";
		document.form1.submit();
	 }
  }  
  
  //有效无效
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
		document.form1.action="<%=path%>/user!changeValid";
		document.form1.submit();
	 }
  }    
  
  //修改密码
 function updatePwd(){
	 if(confirm("是否修改？")){
		document.form1.action="<%=path%>/user!toChangePwd";
		document.form1.submit();
	 }	
  }
  
  //用户中的角色分配
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
	
	 if(flag==0)
	 {
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 
	 //用户名携带至下一个页面
	 var obj=$("input:checkbox[name=idcheckbox]:checked");
	 $("#screenname").val($(obj).attr("sname"));
	 $("#flname").val($(obj).attr("flname"));
	 $("#userid").val($(obj).val());
	 
	 if(confirm("是否角色分配？")){
		document.form1.action="<%=path%>/user!toRoleDistribute";
		document.form1.submit();
	 }	
  }
  
  //权限查看
 function lookRight(){
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
	 
	 //用户名携带至下一个页面
	 var obj=$("input:checkbox[name=idcheckbox]:checked");
	 $("#screenname").val($(obj).attr("sname"));
	 $("#flname").val($(obj).attr("flname"));
	 $("#userid").val($(obj).val());
	 
	 if(confirm("是否查看权限？")){
		document.form1.action="<%=path%>/user!lookRight";
		document.form1.submit();
	 }	
  }
  
  //权限代理
  function rightDl(){

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
	var obj1=$("input[name=idcheckbox]:checked").val();
	 
	 if(confirm("是否进行权限代理？")){
		document.form1.action="<%=path%>/user!toDlRight?userId="+obj1;
		document.form1.submit();
		}
	 }	
  
  
  //权限代理查看
  function rightDlLook(){
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
	var obj1=$("input[name=idcheckbox]:checked").val();
	 if(confirm("是否查看权限代理？"))
	 {
		document.form1.action="<%=path%>/user!rightDlLook?userId="+obj1;
		document.form1.submit();
	 }	
  }
  
  //代理人查看
  function DlPersonLook(){
	 if(confirm("是否查看代理人？")){//jsp/sys/user/DlPersonLook.jsp
		document.form1.action="<%=path%>/user!findPersonLook";
		document.form1.submit();
	 }	
  }
  
  //特权分配
  function privilege(){
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
	var obj1=$("input[name=idcheckbox]:checked").val();
	//用户名携带至下一个页面
	 var obj=$("input:checkbox[name=idcheckbox]:checked");
	 $("#screenname").val($(obj).attr("sname"));
	 $("#flname").val($(obj).attr("flname"));
	 $("#userid").val($(obj).val());
	 if(confirm("是否查看代理人？"))
	 {
		document.form1.action="<%=path%>/user!toPRight?userId="+obj1;
		document.form1.submit();
	 }	
  }

</script>

</head>

<body  >

<form name="form1" id="form1" method="post" action="<%=path%>/user!find">
<!-- 查询条件 -->
<input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>

<input type=hidden id="screenname" name="form.screenname" value=""/>
<input type="hidden" id="flname" name="form.firstname" value=""/>
<input type="hidden" id="userid" name="form.userid" value=""/>

<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
					<span style="white-space:nowrap;">&nbsp;&nbsp;用户账号:<input type="text" id="searchA" name="searchA" value="${form.searchA }"/></span>
	            <span style="white-space:nowrap;">&nbsp;&nbsp;姓名:<input type="text" name="searchB" id="searchB" value="${form.searchB }"/></span>
	            <span style="white-space:nowrap;">&nbsp;&nbsp;<a style="cursor:hand" onclick="findList();"><img src="<%=path %>/images/zoom.png" width="15" height="15"/> 查询</a></span>
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">用户信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
		            <span class="STYLE1" style="white-space:nowrap;vertical-align:middle;">
		             <s:if test="#session.operList.get(\"010701\")!=null">
						<a title="新增" href="javascript:void(0);" onclick="toAdd();" ><img src="<%=path %>/<s:property value="#session.operList.get(\"010701\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010701\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010702\")!=null">
						<a title="修改" href="javascript:void(0);" onclick="toUpdate();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010702\").oper_simg"/>" align="middle" border="0"/>
						 <span class="STYLE1"><s:property value="#session.operList.get(\"010702\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010703\")!=null">
						<a title="删除"  href="javascript:void(0);" onclick="del();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010703\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010703\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010704\")!=null">
						<a title="有效/无效" href="javascript:void(0);" onclick="changeValid();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010704\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010704\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010705\")!=null">
						<a title="密码修改" href="javascript:void(0);" onclick="updatePwd();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010705\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010705\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010706\")!=null">
						<a title="角色分配" href="javascript:void(0);" onclick="toRole();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010706\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010706\").oper_sname"/></span></a>
					</s:if>	
					</span>
					
						<span class="STYLE1" style="white-space:nowrap;vertical-align:middle;">
					 <s:if test="#session.operList.get(\"010707\")!=null">
						<a title="权限查看" href="javascript:void(0);" onclick="lookRight();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010707\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010707\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010708\")!=null">
						<a title="权限代理" href="javascript:void(0);" onclick="rightDl();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010708\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010708\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010709\")!=null">
						<a title="权限代理查看" href="javascript:void(0);" onclick="rightDlLook();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010709\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010709\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010710\")!=null">
						<a title="代理人查看" href="javascript:void(0);" onclick="DlPersonLook();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010710\").oper_simg"/>" align="middle" border="0"/>
						 <span class="STYLE1"><s:property value="#session.operList.get(\"010710\").oper_sname"/></span></a>
					</s:if>
					 <s:if test="#session.operList.get(\"010711\")!=null">
						<a title="特权分配" href="javascript:void(0);" onclick="privilege();"><img src="<%=path %>/<s:property value="#session.operList.get(\"010711\").oper_simg"/>" align="middle" border="0"/> 
						<span class="STYLE1"><s:property value="#session.operList.get(\"010711\").oper_sname"/></span></a>
					</s:if>
					</span>
					</td>
					</tr>
			</table>
						 
    		<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   			<table width="500"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#95B0B9">
		     
		      <tr bgcolor="#CBE0FF">
		        <th width="40px" height="24" class="STYLE10"><input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/></th>
		        <th width="40px" height="20" class="STYLE10">序号</th>
		        <th width="100px" height="20" class="STYLE10">用户名</th>
		        <th width="100px" height="20" class="STYLE10">姓名</th>
		        <th   height="20"  class="STYLE10">邮箱</th>
		        <th width="40px" height="20"  class="STYLE10">状态</th> 
		      </tr>
		      <c:forEach var="vo" items="${list}" varStatus="status">
		      <tr bgcolor="#FFFFFF" ${vo.status==0?'':'style="color:red;"' } >
		        <td height="20" > 
		          	<input type="checkbox" id="idcheckbox" name="idcheckbox" onclick="checkOne();" sname="${vo.screenname }" flname="${vo.firstname}${vo.lastname}" value="${vo.userid}"/>
		        </td>
		        <td height="20" >${status.count}</td>
		        <td height="20" title="${vo.screenname }">${vo.screenname }</td>
		        <td height="20" title="${vo.firstname}${vo.lastname}">${vo.firstname}${vo.lastname}</td>
		        <td height="20" title="${vo.email}">${vo.email}</td>
		        <td height="20" title="${vo.status==0?'有效':'无效' }">${vo.status==0?'有效':'无效' }</td> 
		      </tr>
		      </c:forEach>
		      </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/user!find"></page:page>
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
