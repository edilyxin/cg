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

<html>
<head>
<base target="_self"/>
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/util.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<style type="text/css">

</style>

<script>
function find(){

 document.frm.action="<%=path%>/tree!findUser";
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
<form name="frm" method="post" action="<%=path %>/tree!findClass" >
<table width="100%" height="95%"   border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path%>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">用户信息</div></td>
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
            <tr>
             <td>
            <span style="white-space:nowrap;">&nbsp;&nbsp;用户账号:<input type="text" id="searchA" name="" value="${form.searchA}"/></span>
	        <span style="white-space:nowrap;">&nbsp;&nbsp;姓名:<input type="text" name="us_sname" id="searchB" value="${form.searchB}"/></span>
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
                <td width="94%" valign="bottom"><span style="white-space:nowrap;" class="STYLE1">班级信息列表</span></td>
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
   	<table width="100%" class="table" id="table1" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr>
	  	   <td width="40px" height="20" bgcolor="d3eaef" class="STYLE10">序号</td>
		   <td width="150px" height="20" bgcolor="d3eaef" class="STYLE10">用户名</td>
		   <td width="150px" height="20" bgcolor="d3eaef" class="STYLE10">姓名</td>
		   <td  height="20" bgcolor="d3eaef" class="STYLE10">邮箱</td>
		   <td width="100px" height="20" bgcolor="d3eaef" class="STYLE10">状态</td> 
          </tr>
          <s:iterator value="treeList"  var="v" status="s">
		<tr bgcolor="#ffffff" align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('${v.userid}','${v.screenname}')">
          	<td height="24">${s.index+1}</td>
            <td height="24" title="${v.screenname }">${v.screenname }</td>
		    <td height="24" title="${v.firstname}${vo.lastname}">${v.firstname}${v.lastname}</td>
		    <td height="24" title="${v.email}">${v.email}</td>
		    <td height="24" title="${v.status==0?'有效':'无效' }">${v.status==0?'有效':'无效' }</td> 
          </tr>
		</s:iterator>	
    </table>
   </div>
   </td>
  </tr>
  <tr>
    <td height="30"> 
<!-- 分页标签BEGIN -->
						<s:if test="%{treeList.size()!=0}">
							<page:page uri="/tree!findClass"></page:page>
						</s:if>
						<s:elseif test="%{treeList.size()==0}">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
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
<input type="hidden" id="searchA" name="form.searchA" value="${form.searchA}"/>
<input type="hidden" id="searchB" name="form.searchB" value="${form.searchB}"/>
</form>
</body>
</html>
