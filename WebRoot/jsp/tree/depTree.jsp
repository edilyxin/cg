<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>   
<base target="_self">
<title>部门查询</title>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/itemScreen.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/table.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/cdate.js"></script>
<script type="text/javascript" src="<%=path%>/js/valid.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/My97DatePicker4.7/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=path%>/common/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/common/css/alter.css"  type="text/css"/>
<script type="text/javascript">

function find(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;
 document.all.frm.submit();
}
function returnVal(val1,val2){
	window.dialogArguments[0].value= val1;
	window.dialogArguments[1].value= val2;
	window.close();	
}
function clearVal(){
	window.dialogArguments[0].value= "";
	window.dialogArguments[1].value= "";
	window.close();	
}
</script>
</head>
<body>   
<form id="frm" name="frm" action="<%=path %>/tree!findDep" method="post"  >
 <div class="indexItem">
<div class="indexScreen">
        	 
            <div class="options">
           	  <table width="95%" border="0"  cellspacing="2" >
  <tr style="font-size:12px;">
    <td height="16" class="definition">部门编号:</td>
    <td height="16"><input type="text" size="6"  id="searchA" name="searchA" value="${form.searchA}"  /></td>
    
	<td height="16" class="definition">部门名称:</td>
    <td height="16"><input type="text" size="6"  id="searchB" name="searchB" value="${form.searchB}"  /></td>						
     <td height="16" class="definition">所属单位:</td>
    <td height="16"><input type="text" size="6"  id="searchC" name="searchC" value="${form.searchC}"  /></td>	
    <td align="right" height="16"><input type="button"  class="optionsButton" value="查 询" onClick="find()"/>
    <input type="button"  class="optionsButton" value="清空" onClick="clearVal();"/>
    <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
    <input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
    <input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
        <input type="hidden"  name="form.comp_sno" value="${form.comp_sno}"/> 
</td>
  </tr>
</table>
            </div> 
            <div class="indexParticular">
         <table id="empDatas" class="tablelistcontent" width="100%" border="1" cellspacing="1" >
	      <tr class="dictionary"  style="font-size:14px;">
	      <td width="4%" bordercolor="#000000"><div align="center"><strong>序号</strong></div></td>
	      <td width="16%" height="24" bordercolor="#000000"><div align="center"><strong>部门编号</strong></div></td>
	      <td width="20%" height="24" bordercolor="#000000"><div align="center"><strong>部门名称</strong></div></td>
	      <td width="20%" height="24" bordercolor="#000000"><div align="center"><strong>部门简称</strong></div></td>
          <td width="20%" height="24" bordercolor="#000000"><div align="center"><strong>上级部门</strong></div></td>
          <td width="20%" height="24" bordercolor="#000000"><div align="center"><strong>所属单位</strong></div></td>
        </tr>
         
         
<s:iterator value="treeList"  status="s" var="dep">
	
	<tr align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#dep.dep_sno"/>','<s:property value="#dep.dep_sname"/>')">
 
	   <td  bordercolor="#CCCCCC">${s.index+1 }</td>
	  <td align="center" bordercolor="#CCCCCC"><s:property value="#dep.dep_sno"/></td>  
   	  <td bordercolor="#CCCCCC" title="${dep.dep_sname}">
									<s:if test="%{#dep.dep_sname.length() <= 15}">${dep.dep_sname}</s:if>
									<s:else><s:property value="%{#dep.dep_sname.substring(0,15) + '...'}"/></s:else>
								</td>
   	  <td bordercolor="#CCCCCC" title="${dep.dep_ssname}">
									<s:if test="%{#dep.dep_ssname.length() <= 15}">${dep.dep_ssname}</s:if>
									<s:else><s:property value="%{#dep.dep_ssname.substring(0,15) + '...'}"/></s:else>
								</td>
   	  <td bordercolor="#CCCCCC" title="${dep.dep_ssupername}">
									<s:if test="%{#dep.job_sname.length() <= 15}">${dep.dep_ssupername}</s:if>
									<s:else><s:property value="%{#dep.dep_ssupername.substring(0,15) + '...'}"/></s:else>
								</td>
   	  <td bordercolor="#CCCCCC" title="${dep.comp_sname}">
									<s:if test="%{#dep.comp_sname.length() <= 10}">${dep.comp_sname}</s:if>
									<s:else><s:property value="%{#dep.comp_sname.substring(0,10) + '...'}"/></s:else>
								</td> 				 
	</tr>
	</s:iterator>
  			
  			

</table>       
    
    </div>
     <div align="center"  >
    				<s:if test="%{treeList.size()!=0}">
    			
    			<page:page uri="/tree!findDep"></page:page>
    				</s:if>
    				<s:elseif test="%{treeList.size()==0}"><br>
    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
    				</s:elseif>
    			 </div>   
    </div>
    </div> 
    </form>   
</body>
</html>

