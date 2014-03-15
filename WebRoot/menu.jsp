<%@ page language="java"  import="java.util.*,com.rc.sys.vo.MngRight"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<script language=javascript>
NS4 = (document.layers) ? 1 : 0;
IE4 = (document.all) ? 1 : 0;
ver4 = (NS4 || IE4) ? 1 : 0;

if (ver4) {
with (document) {
write("<STYLE TYPE='text/css'>");
if (NS4) {
write(".parent {position:absolute; visibility:visible background:red}");
write(".child {position:absolute; visibility:hide;display:block; }");
write(".regular {position:absolute; visibility:visible}");
}
else {
write(".child {display:block;text-align:left}");
}
write("</STYLE>");
}
}
</script>
<script language=javascript>
/**
 *展开关闭菜单 当前ID ，当前菜单序号，当前菜单链接
 */
function expandIt(el,num,aTag)
{	 
	//alert("btt==="+el+"Child");
	var fd="Child"+el;
	//alert("fd==="+fd);
	var whichEl=document.getElementsByName(fd);
	var allEl = document.getElementsByTagName("div");
	var allImage = document.getElementsByName("image");
	//var whichEl = eval(el + "Child");
	//alert("btt==="+document.getElementsByTagName("div")[1].id ) ;
	//var ff="image"+el;
	//var s1=document.getElementById(ff);
	//var s1 = eval(el + "f");
	//alert(whichEl);
	var len = allEl.length;

	if(len!=undefined){
 		for(var i=0;i<len;i++){
 			if(allEl[i].id.indexOf(fd)==0){
	  			if(aTag.id  == "open"){
	 				allEl[i].style.display = "none";
	 			//	if(allImage[i].src.indexOf("iOpenFolder.gif")>0){
	 			//		allImage[i].src="<%=path %>/images/iGenericFolder.gif";
	 			//	}
	 			//	allImage[num].src="<%=path %>/images/iGenericFolder.gif";
					//s1.innerHTML = "<img src='<%=path %>/images/iGenericFolder.gif'>";
	 			}else {
	 				allEl[i].style.display = "block";
	 			//	if(allImage[i].src.indexOf("iGenericFolder.gif")>0){
	 			//		allImage[i].src="<%=path %>/images/iOpenFolder.gif";
	 			//	}
	 			//	allImage[num].src="<%=path %>/images/iOpenFolder.gif";
					//alert(whichEl.style.pixelHeight);
					//alert(whichEl.style.width);
					//s1.innerHTML = "<img src='<%=path %>/images/iOpenFolder.gif'>";
				}
			}
	 	}
	}
	else {
		if(allEl.id.indexOf(fd)==0){
			if (aTag.id  == "open") {
				allEl.style.display = "none";
			//	if(allImage.src.indexOf("iOpenFolder.gif")>0){
	 		//			allImage.src="<%=path %>/images/iGenericFolder.gif";
	 		//		}
	 				
				//s1.innerHTML = "<img src='<%=path %>/images/iGenericFolder.gif'>";
			}else {
				allEl.style.display = "block";
			//	if(allImage.src.indexOf("iGenericFolder.gif")>0){
	 		//			allImage.src="<%=path %>/images/iOpenFolder.gif";
	 		//		}
				//alert(whichEl.style.pixelHeight);
				//alert(whichEl.style.width);
				//s1.innerHTML = "<img src='<%=path %>/images/iOpenFolder.gif'>";
			}
		}
	}
	if(aTag.id == "open"){
		aTag.id = "close";
	}else{
		aTag.id = "open";
	}
	
	//arrange()
	// whichE1.pageY = 200;
}
function button_over(o)
{
o.style.background="#eee";
}

function button_out(o)
{
o.style.background="";
}
/* Create a new XMLHttpRequest object to talk to the Web server */
var xmlHttp = false;
/*@cc_on @*/
/*@if (@_jscript_version >= 5)
try {
xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
try {
xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
} catch (e2) {
xmlHttp = false;
}
}
@end @*/
if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
xmlHttp = new XMLHttpRequest();
}

function getMenuname(menuname){
	xmlHttp.open("POST","<%=path%>/login!getMenuName?menuname="+encodeURI(encodeURI(menuname)),false);
	xmlHttp.onreadystatechange=function(){
//		if(xmlHttp.readyState==4 && xmlHttp.status==200)
//		{
//			document.getElementById(idName).innerHTML = "<select name='"+fieldName+"' style='width:132px'>"+xmlHttp.responseText+"</select>";
//		}else if(xmlHttp.readyState==4 && xmlHttp.status!=200){
//			document.getElementById(idName).innerHTML = "<select name='"+fieldName+"' style='width:132px'><option style='color:red'>数据错误！</option></select>";
//		}
	}
	xmlHttp.send();
	 
}
</script>

<link rel="stylesheet" type="text/css" href="css/style.css" />

<style type="text/css">
a{color:#04508c;margin-left:15px;}
</style>
</head>

<body class="left" style="word-break:keep-all;white-space:nowrap;overflow:hidden;">
<div style="width:212px;height:70px;background:url(image/left1.jpg);">
	<div style="margin-left: 90px;padding-top: 30px;font-size: 20px;font-weight: bold;color:#FFFFFF;">
	 <%=request.getAttribute("menuTop")==null?"功能菜单":(request.getAttribute("menuTop").equals("")?"信息平台":request.getAttribute("menuTop")) %>
	</div>
</div>
<s:iterator value="#request.menuList" status="status" var="right">
<s:if test="#right.right_nmorb==0 && #right.right_sischild==\"1\"">

<div id="div" class="parent">
  <!--<table width="190" border=0 cellpadding="0" cellSpacing=0>
    <tr>
     <td width="16"  >   </td>
      <td  style="cursor:hand;height:35px;text-align:center;font-size:14px;font-weight:600;">
      <a id="open" onClick="expandIt('<s:property value="#right.right_sno"/>',<s:property value="%{#status.index}"/>,this); return false;"><s:property value="#right.right_sname"/></a></td>
    </tr>
  </table>
--></div>
</s:if>
<s:else>
<div id="Child<s:property value="#right.right_sparentno"/>" class="child">
		<table width="190" border=0 cellpadding="0" cellSpacing=0>
		<tr>
      	 <td width="16">
     	 <s:if test="%{#right.right_sisend==\"0\"}">  </s:if>
     	 <s:elseif test="%{#right.right_sisend==\"1\"}"></s:elseif>
     	 </td> 
     	 <td   style="cursor:hand;background-image: url('image/li0.jpg');height:35px;text-align:left;font-size:14px;font-weight:600;color:#04508C"  >
     	  <a   onclick="getMenuname('<%=request.getAttribute("menuTop")==null?"功能菜单":(request.getAttribute("menuTop").equals("")?"信息平台":request.getAttribute("menuTop")) %> > <s:property value="#right.right_sname"/>');" 
     	  <s:if test="%{#right.right_smenuurl!=null}">href="<%=path %>/<s:property value="#right.right_smenuurl"/>"</s:if>  target="<s:property value="#right.right_sposition"/>">
     	  	<img src='<%=path %>/<s:property value="#right.right_simg"/>' border='0' width='25' height='25' style="vertical-align:middle;"/>&nbsp;&nbsp;<s:property value="#right.right_sname"/>
     	  </a>
     	 </td>
   	</tr> 
  	</table>
</div>
</s:else>
</s:iterator>

 

</body>
</html>
