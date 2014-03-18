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
<title>系统集成管理</title>

<script>
//跳转修改页
function toUpdate(){
 	if(document.form1.idcheckbox==null){
		  return;
	}
	var len = document.form1.idcheckbox.length;
	var flag = 0;
	if(len!=undefined){
		for(var i=0;i<len;i++){
			if(eval(document.form1.idcheckbox[i].checked)){
				flag++;
			}
		}
	}else{
		if(document.form1.idcheckbox.checked){
			flag++;
		}
	}
	if(flag==0){
		alert("请选择一条记录！");
		return;
	}else if(flag!=1){
		alert("请只选择一条记录，不要多选！");
		return;
	}
	if(confirm("是否修改？")){
		document.form1.action="<%=path%>/sysint!toUpdate?page=${bean.currentPage}";
		document.form1.submit();
	}
}

//删除
function del() {
	if(document.form1.idcheckbox==null){
		return;
	}
	var len = document.form1.idcheckbox.length;
	var flag = 0;
	if(len!=undefined){
		for(var i=0;i<len;i++){
			if(eval(document.form1.idcheckbox[i].checked)){
				flag++;
			}
		}
	}else{
		if(document.form1.idcheckbox.checked){
			flag++;
		}
	}
	if(flag==0){
		alert("请选择一条记录！");
		return;
	}
	if(confirm("是否删除？")){
		document.form1.action="<%=path%>/sysint!toDelete?page=${bean.currentPage}";
		document.form1.submit();
	 }
	
}

function commit(){
	if(document.form1.idcheckbox==null){
		 return;
	}
	var len = document.form1.idcheckbox.length;
	var flag = 0;
	if(len!=undefined){
		for(var i=0;i<len;i++){
			if(eval(document.form1.idcheckbox[i].checked)){
				flag++;
			}
		}
	}else{
		if(document.form1.idcheckbox.checked){
			flag++;
		}
	}
	if(flag==0){
		alert("请选择一条记录！");
		return;
	}
	if(confirm("是否更改状态？")){
		document.form1.action="<%=path%>/sysint!changeValid?page=${bean.currentPage}";
		document.form1.submit();
	}
}


	//跳转新增页
	function toAdd(){
		document.form1.action="<%=path%>/sysint!toAdd";
		document.form1.submit();
	}



	//查询
	function findInfo(){
	input_trim();
	 	document.getElementById("searchB").value=document.getElementById("searchB1").value;
	 	document.getElementById("searchC").value=document.getElementById("searchC1").value;
	 	document.getElementById("searchD").value=document.getElementById("searchD1").value;
		document.form1.action="<%=path %>/sysint!find";
		document.form1.submit();
	}

</script>
</head>

<body>
<form name="form1" id="form1" method="post"   >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
               	<span  style="white-space:nowrap;">&nbsp;&nbsp;系统名称:
                  <input type="text" name="searchB1" id="searchB1" value="${form.searchB}" size="12"/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;系统简称:
				  <input type="text" name="searchC1" id="searchC1" value="${form.searchC}" size="12"/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;集成方式:
				<select id="searchD1" name="searchD1" >
						<option value=""></option>
						<option value="0" <s:if test="%{form.searchD==\"0\"}">selected</s:if>>完全集成</option>
						<option value="1" <s:if test="%{form.searchD==\"1\"}">selected</s:if>>用户信息集成</option>
						<option value="2" <s:if test="%{form.searchD==\"2\"}">selected</s:if>>用户对照集成</option>
					</select>
					</span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="findInfo()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
                	
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">系统信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	<span class="STYLE1" style="white-space:nowrap;">
	            	<s:if test="#session.operList.get(\"010101\")!=null">
						<a title="新增" href="javascript:void(0);" onclick="toAdd()" >
							<img src="<%=path%>/<s:property value="#session.operList.get(\"010101\").oper_simg"/>" width="10" height="10" border="0"/> 
							<span class="STYLE1"><s:property value="#session.operList.get(\"010101\").oper_sname"/></span>
						</a>
					</s:if>
					<s:if test="#session.operList.get(\"010102\")!=null">
      					<a title="修改" href="javascript:void(0);" onclick="toUpdate();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010102\").oper_simg"/>" width="10" height="10" border="0"/>
							<span class="STYLE1"><s:property value="#session.operList.get(\"010102\").oper_sname"/></span>
						</a>
					</s:if>
					<s:if test="#session.operList.get(\"010103\")!=null">
      					<a title="删除" href="javascript:void(0);" onclick="del();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010103\").oper_simg"/>" width="10" height="10" border="0"/> 
      						<span class="STYLE1"><s:property value="#session.operList.get(\"010103\").oper_sname"/></span>
      					</a>
      				</s:if>
      				<s:if test="#session.operList.get(\"010104\")!=null">
	            		<a title="有效/无效" href="javascript:void(0);" onclick="commit();">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"010104\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"010104\").oper_sname"/></span>
	            		</a>&nbsp;&nbsp;
	            	</s:if>
	                </span>
	           </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
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
		</tr>
		
		<s:iterator value="list"  var="v" status="s">
		<tr <s:if test="#v.sysint_sstate==\"1\"">style="color:red;"</s:if> >
 		<td height="20"><input name="idcheckbox"  type="checkbox"  id="ibox" value="<s:property value="#v.sysint_sno" />%u0008<s:property value="#v.sysint_sname" />" onclick="checkOne(this)"/></td>
 		<td><s:property value="%{#s.index+1}"/> </td>
		<td title="${v.sysint_sno}"><s:property value="#v.sysint_sno" /></td>
		<td title="${v.sysint_sname}"><s:property value="#v.sysint_sname"/> </td>
		<td title="${v.sysint_ssname}"><s:property value="#v.sysint_ssname"/> </td> 
		<td title="<s:if test="%{#v.sysint_susrtype==\"0\"}">完全集成</s:if><s:if test="%{#v.sysint_susrtype==\"1\"}">用户信息集成</s:if><s:if test="%{#v.sysint_susrtype==\"2\"}">用户对照集成</s:if>">
		<s:if test="%{#v.sysint_susrtype==\"0\"}">完全集成</s:if>
		<s:if test="%{#v.sysint_susrtype==\"1\"}">用户信息集成</s:if>
		<s:if test="%{#v.sysint_susrtype==\"2\"}">用户对照集成</s:if>
		</td>
		<td ><s:if test="%{#v.sysint_simg!=null}"><img src="<%=path %>/<s:property value="#v.sysint_simg"/>"  style="border:1px #666666 solid;" alt="系统图标" width="15" height="15"/></s:if></td>
		<td title="${v.sysint_surl}"><s:property value="#v.sysint_surl"/> </td>
		<td title="${v.sysint_susrpar}"><s:property value="#v.sysint_susrpar"/> </td>
		<td title="${v.sysint_spwdpar}"><s:property value="#v.sysint_spwdpar"/> </td>
		<td title="${v.sysint_susrtypepar}"><s:property value="#v.sysint_susrtypepar"/> </td>
		<td title="<s:if test="%{#v.sysint_sstate==\"0\"}">有效</s:if><s:if test="%{#v.sysint_sstate==\"1\"}">无效</s:if>">
		<s:if test="%{#v.sysint_sstate==\"0\"}">有效</s:if><s:if test="%{#v.sysint_sstate==\"1\"}">无效</s:if>
		 </td>
		</tr>	
		</s:iterator>	
		</table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/sysint!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		
<input type="hidden" id="searchB" name="form.searchB" value="${form.searchB}"/>
<input type="hidden" id="searchC" name="form.searchC" value="${form.searchC}"/>
<input type="hidden" id="searchD" name="form.searchD" value="${form.searchD}"/>
</form>
</body>
</html>