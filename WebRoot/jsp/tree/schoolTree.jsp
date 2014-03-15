<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<base target="_self">
<title>校区查询</title>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/itemScreen.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/table.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/cdate.js"></script>
<script type="text/javascript" src="<%=path%>/js/valid.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/My97DatePicker4.7/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=path%>/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/css/alter.css"  type="text/css"/>
<script type="text/javascript">

function find(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.frm.action="tree!findSchool";
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
//获得divwidth的宽度
	function getwidth(){
		document.getElementById("divwidth").style.width= document.body.offsetWidth-50;
			document.getElementById("divwidth").style.width= document.getElementById("idwidth").offsetWidth;
			if(document.getElementById("table1").offsetWidth>document.getElementById("divwidth").offsetWidth){
				document.getElementById("divwidth").style.paddingBottom = "17px";
			}else{
				document.getElementById("divwidth").style.paddingBottom = "0px";
			}
	}
 

</script>
</head>

<body onload="getwidth()"  onresize="getwidth()">  
<form id="frm" name="frm" action="<%=path %>/tree!findSchool" method="post"  >
 

<table width="100%" height="95%"  border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path%>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">校区信息</div></td>
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
        <table width="95%" border="0"  cellspacing="2" >
  <tr style="font-size:12px;" align="left">
    <td >
    <span  style="white-space:nowrap;">&nbsp;&nbsp;
           校区编号:<input type="text" size="6"  id="searchA" name="searchA" value="${form.searchA}"  />
   <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
   
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
                <td width="94%" valign="bottom"><span class="STYLE1">校区信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right">
            
	            	<span class="STYLE1">
	                </span>
	           
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
        <td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="100%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    
       <tr class="dictionary"  style="font-size:14px;">
	      	<td width="40" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>序号</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区编号</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区名称</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区简称</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区地址</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区类型</strong></div></td>
        </tr>
<s:iterator value="treeList"  status="s" var="sh">
	<tr align="center" bgcolor="#ffffff" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#sh.sh_sno"/>','<s:property value="#sh.sh_sname"/>')">
	 <td height="24" align="center">${s.index+1 }</td>
	 <td height="24" align="center" title="<s:property value="#sh.sh_sno"/>"><s:property value="#sh.sh_sno"/></td>
	 <td height="24" title="<s:property value="#sh.sh_sname"/>"><s:property value="#sh.sh_sname"/></td>
	 <td height="24" title="<s:property value="#sh.sh_ssname"/>"><s:property value="#sh.sh_ssname"/> 
</td>
	 	<td height="24" title="<s:property value="#sh.sh_sadder"/>"><s:property value="#sh.sh_sadder"/> 
</td>
	 	<td height="24" >
	 	<s:if test="%{#sh.sh_stype==\"0\"}">主校区</s:if>
	 	<s:if test="%{#sh.sh_stype==\"1\"}">附校区</s:if>
	 	</td>
	</tr>
	</s:iterator>
</table>    </div></td>   
  <tr>
    <td height="30">
   	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="30">
    <div align="center"  >
    				<s:if test="%{treeList.size()!=0}">
    			<page:page uri="/tree!findEmp"></page:page>
    				</s:if>
    				<s:elseif test="%{treeList.size()==0}">
    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
    				</s:elseif>
    			 </div></td></tr>
      
    </table>
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
    <td  valign="bottom" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path%>/images/buttom_bgs.gif"><img src="<%=path%>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path%>/images/mail_rightbg.gif"><img src="<%=path%>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
 <input type="hidden" 	name="form.ud_sno" value="${form.ud_sno}"/>
 <input type="hidden" 	name="form.lo_sno" value="${form.lo_sno}"/>
</form>
           	
</body>
</html>

