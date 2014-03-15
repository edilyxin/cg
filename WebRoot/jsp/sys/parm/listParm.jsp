<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
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

<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/util.js"></script>
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
  function findInfo(){
  input_trim();
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;
 document.getElementById("searchD1").value=document.getElementById("searchD").value;
 
 document.all.form1.submit();
}
//排序

function findPage(curretPage){
 document.getElementById("currentPage").value=curretPage;
 document.all.form1.submit();
}
function toAdd(){
	document.form1.action="<%=path%>/parm!toAdd";
	document.form1.submit();

} 


 function toUpdate(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	 var obj1=document.getElementsByName("form.parm_sisvalid");
	
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
	    
	 if(obj1[knum].value=="0")
  	 {   
  	 	alert("只能对无效信息修改!");
  	    return;
  	 }else{
  	    
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
		document.form1.action="<%=path%>/parm!toUpdate";
		document.form1.submit();
	 }	
  }
  
 function del(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	    var obj1=document.getElementsByName("form.parm_sisvalid");
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
		alert("请至少选择一条记录！");
		return;
	 }
	  if(obj1[knum].value=="0")
  	 {
  	 	alert("只能对无效信息删除!");
  	    return;
  	 }else{
  	    
  	 }
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/parm!toDelete";
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
		document.form1.action="<%=path%>/parm!changeValid";
		document.form1.submit();
	 }
  }    
  

</script>


</head>

<body >

<form name="form1" method="post" action="<%=path%>/parm!find">
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
	   			<select name="searchA" id="searchA"    > 
					<option value="">--请选择--</option>
					 <s:iterator value="syslist" status="s" var="sy">
		          	 <option value="${sy.sysint_sno}" <s:if test="form.searchA==#sy.sysint_sno"> selected </s:if>>${sy.sysint_sname}</option>
					 </s:iterator> 
				 </select> </span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;参数名称:
                <input type="text" name="searchB" id="searchB" value="${form.searchB}" /></span>
				
				<span  style="white-space:nowrap;">&nbsp;&nbsp;参数值:
                 <input type="text" name="searchC" id="searchC" value="${form.searchC}" /></span>
				
				<span  style="white-space:nowrap;">&nbsp;&nbsp;类别:
               	<select id="searchD" name="searchD" >
			    <option value=""> --请选择--</option>
			     <option value="0" <s:if test="form.searchD == \"0\""> selected </s:if>>公共类型</option>
			    <option value="1" <s:if test="form.searchD==\"1\""> selected </s:if>>系统类型</option>
			    </select></span>
	           
			  <span  style="white-space:nowrap;">&nbsp;&nbsp;             
			 <a href="javascript:void(0);"  onClick="findInfo()" style="cursor:hand" align="left">
			 <img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
             	 <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
         	 	 <input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
          		<input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
        	 	<input type="hidden" id="searchD1" name="form.searchD" value="${form.searchD}"/>
       			<input type="hidden" id="currentPage" name="currentPage" value=""/>  
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">参数信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	<span class="STYLE1" style="white-space:nowrap;">
	            	<s:if test="#session.operList.get(\"010501\")!=null">
						<a title="新增" href="javascript:void(0);" onclick="toAdd()" >
							<img src="<%=path%>/<s:property value="#session.operList.get(\"010501\").oper_simg"/>" width="10" height="10" border="0"/> 
							<span class="STYLE1"><s:property value="#session.operList.get(\"010501\").oper_sname"/></span>
						</a> 
					</s:if>
					<s:if test="#session.operList.get(\"010502\")!=null">
      					<a title="修改" href="javascript:void(0);" onclick="toUpdate();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010502\").oper_simg"/>" width="10" height="10" border="0"/>
							<span class="STYLE1"><s:property value="#session.operList.get(\"010502\").oper_sname"/></span>
						</a>
					</s:if>
					<s:if test="#session.operList.get(\"010503\")!=null">
      					<a title="删除" href="javascript:void(0);" onclick="del();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010503\").oper_simg"/>" width="10" height="10" border="0"/> 
      						<span class="STYLE1"><s:property value="#session.operList.get(\"010503\").oper_sname"/></span>
      					</a>
      				</s:if>
      				<s:if test="#session.operList.get(\"010504\")!=null">
	            		<a title="有效/无效" href="javascript:void(0);" onclick="changeValid();">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"010504\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"010504\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	                </span>
	           </td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    <table width="800"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
         
      <tr bgcolor="#CBE0FF">
      
        <th width="40px" height="20"  class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  />
        </div></th>
        					<th width="40px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        					<th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></th>
        				    <th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">参数名称</span></div></th>
        					<th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">参数访问名</span></div></th>
        					<th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">参数值</span></div></th>
        					<th width="80px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">参数类别</span></div></th>
        					<th  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></th>
        					<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否有效</span></div></th>
      					</tr>
      <s:iterator value="list" status="s" var="param">
      <tr bgcolor="#FFFFFF" align="center" class="STYLE19" <s:if test="#param.parm_sisvalid==\"1\"">style="color:red;"</s:if> >
        <td>
            <input type="checkbox"  id="idcheckbox" name="idcheckbox" onclick="checkOne();"  value="<s:property value="#param.parm_nid"/>"/>
            <input type="hidden"  id="kstat" name="form.parm_sisvalid" value="<s:property value="#param.parm_sisvalid"/>"/>
         </td>
        <td><s:property value="#s.index + 1"/></td>
        <td><s:property value="#param.sysint_sname"/></td>
         <td><s:property value="#param.parm_sdisname"/></td>
        <td><s:property value="#param.parm_sname"/></td> 
         <td><s:property value="#param.parm_svalue"/></td>
        <td> 
         <s:if test="#param.parm_stype == \"0\"">公共类型</s:if>
        <s:if test="#param.parm_stype == \"1\"">系统类型</s:if>
        
        </td> 
         <td><s:property value="#param.parm_sdesc"/></td> 
         <td>
         <s:if test="#param.parm_sisvalid == \"0\"">有效</s:if>
        <s:if test="#param.parm_sisvalid == \"1\"">无效</s:if>
         </td>
      </tr>
     </s:iterator>
  </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/parm!find"></page:page>
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