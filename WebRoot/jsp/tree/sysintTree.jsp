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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base target="_self"/>
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/util.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统集成信息查询</title>
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
function find(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
  document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.frm.action="<%=path%>/tree!findSysint";
 document.all.frm.submit();
}
function returnVal(val1,val2){
	if (window.opener != undefined) {
	       //for chrome
	    window.opener.returnValue = val1+"|"+val2;
	}
	else {
	    window.returnValue = val1+"|"+val2;
	}
	window.close();	
}
function clearVal(){
	if (window.opener != undefined) {
       //for chrome
   	 window.opener.returnValue = "";
	}
	else {
    window.returnValue = "";
	}
	window.close();	
}
 

</script>
</head>

<body  >
<form name="frm" method="post" action="<%=path %>/tree!findSysint" >
<table width="100%" height="95%"   border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path%>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">系统信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="<%=path%>/images/mail_rightbg.gif"><img src="<%=path%>/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>

  <tr>
    <td valign="middle" height="100%" background="<%=path%>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
      <tr >
        <td   valign="top">
    	<table width="100%" align="center"  border="0" class="STYLE10">
            <tr >
               
                <td >
                	<span  style="white-space:nowrap;">&nbsp;&nbsp;系统名称:
                    <input type="text" name="searchA" size="6" id="searchA" value="${form.searchA}"/>
				    </span>
				    <span  style="white-space:nowrap;">&nbsp;&nbsp;系统简称:
				  <input type="text" name="searchB" size="6" id="searchB" value="${form.searchB}"/>
				  </span>
				   <span  style="white-space:nowrap;">&nbsp;&nbsp;
                <a href="javaScript:void(0);"  style="cursor:hand" onclick="find();" >  <img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
              	 </span>
              	 <span  style="white-space:nowrap;">&nbsp;&nbsp;
              	 <a href="javaScript:void(0);"  style="cursor:hand" onclick="clearVal();" >  <img src="<%=path%>/images/pic3.jpg" width="15" height="15" border="0"/> 清空</a>
              	 </span>
				  </td>
			</tr>
			
        </table>
         
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">系统信息列表</span></td>
              </tr>
            </table></td>
            <td>
	            <div align="right">
	            	<span class="STYLE1">
	                </span>
	           </div>
           </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
        <td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="100%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    
   	<tr>
	  	<td width="40" height="20" bgcolor="d3eaef" class="STYLE6" title="序号"><div align="center"><span class="STYLE10">序号</span></div></td>
	  	<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="系统编号"><div align="center"><span class="STYLE10">系统编号</span></div></td>
	  	<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="系统名称"><div align="center"><span class="STYLE10">系统名称</span></div></td>
	  	<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="系统简称"><div align="center"><span class="STYLE10">系统简称</span></div></td>
		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="用户信息集成方式"><div align="center"><span class="STYLE10">用户信息集成方式</span></div></td>
		<td width="100"  height="20" bgcolor="d3eaef" class="STYLE6" title="集成图标文档路径"><div align="center"><span class="STYLE10">集成图标文档路径</span></div></td>
		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="系统访问地址"><div align="center"><span class="STYLE10">系统访问地址</span></div></td>
		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="用户账号参数"><div align="center"><span class="STYLE10">用户账号参数</span></div></td>
		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="用户密码参数"><div align="center"><span class="STYLE10">用户密码参数</span></div></td>
		<td width="100" height="20" bgcolor="d3eaef" class="STYLE6" title="用户类别参数"><div align="center"><span class="STYLE10">用户类别参数</span></div></td>
		</tr>
		
		<s:iterator value="treeList"  var="v" status="s">
		<tr bgcolor="#ffffff" align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#v.sysint_sno"/>','<s:property value="#v.sysint_sname"/>')">
 		<td height="24"><s:property value="%{#s.index+1}"/> 
 		</td>
		<td title="${v.sysint_sno}"><s:property value="#v.sysint_sno" /></td>
		<td title="${v.sysint_sname}"><s:property value="#v.sysint_sname"/> </td>
		<td title="${v.sysint_ssname}"><s:property value="#v.sysint_ssname"/> </td> 
		<td title="<s:if test="%{#v.sysint_susrtype==\"0\"}">完全集成（系统与基础)</s:if><s:if test="%{#v.sysint_susrtype==\"1\"}">只是用户信息集成</s:if><s:if test="%{#v.sysint_susrtype==\"2\"}">用户对照集成</s:if>">
		<s:if test="%{#v.sysint_susrtype==\"0\"}">完全集成（系统与基础)</s:if>
		<s:if test="%{#v.sysint_susrtype==\"1\"}">只是用户信息集成</s:if>
		<s:if test="%{#v.sysint_susrtype==\"2\"}">用户对照集成</s:if>
		</td>
		<td title="${v.sysint_simg}"><s:property value="#v.sysint_simg"/> </td>
		<td title="${v.sysint_surl}"><s:property value="#v.sysint_surl"/> </td>
		<td title="${v.sysint_susrpar}"><s:property value="#v.sysint_susrpar"/> </td>
		<td title="${v.sysint_spwdpar}"><s:property value="#v.sysint_spwdpar"/> </td>
		<td title="${v.sysint_susrtypepar}"><s:property value="#v.sysint_susrtypepar"/> </td>
		</tr>	
		</s:iterator>	
    </table>
 </div></td></tr>

  <tr>
 
    <td height="30"> 
    
<!-- 分页标签BEGIN -->
<div align="center">
						<s:if test="%{treeList.size()!=0}">
							<page:page uri="/tree!findSysint"></page:page>
						</s:if>
						<s:elseif test="%{treeList.size()==0}">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
						</div>
<!-- 分页标签END -->

    	</td> 
    	</tr>
    	
    </table>

    </td> 
    	</tr>
    	
    </table>
    </td>
    <td background="<%=path%>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
 
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
 
</table>
<input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
<input type="hidden" name="form.right_sno" value="${form.right_sno}"/>
<input type="hidden" name="form.sysint_sno" value="${form.sysint_sno}"/>
</form>
</body>
</html>
