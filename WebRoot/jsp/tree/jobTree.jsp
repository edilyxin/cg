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
<base target="_self"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
  <script>
function find(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;
 document.form1.action="<%=path%>/tree!findJob";
 document.all.form1.submit();
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

<form name="form1" method="post" action="<%=path %>/job!find">
<table width="100%"  height="95%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path %>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">岗位信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>

  <tr>
    <td valign="middle" height="100%" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
      <tr >
        <td   valign="top">
        <table width="100%"  border="0" class="STYLE10">
            <tr>
                <td  ><span  style="white-space:nowrap;">&nbsp;&nbsp;所属单位:
                
				<input  type="text" size="6" id="searchA"  name="searchA" value="${form.searchA}"    ></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;岗位编号:
                <input type="text" size="6" name="searchB" id="searchB" value="${form.searchB}" /></span>
			
                <span  style="white-space:nowrap;">&nbsp;&nbsp;岗位名称:
                <input type="text" name="searchC" size="6" id="searchC"  value="${form.searchC}" /></span>
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
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 岗位信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
						<!--<a href="#" onclick="find()" ><img src="<%=path%>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">查询</span></a>&nbsp; 
      					<a href="#" onclick="clearVal();"><img src="<%=path%>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">清空</span></a>-->&nbsp;
	            </span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
        <td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="150%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
    <tr  bgcolor="d3eaef" >
        <td height="20">序号</td>
        <td height="20">所属单位</td>
        <td height="20">岗位编号</td>
        <td height="20">岗位名称</td>
        <td height="20">岗位级别</td>
        <td height="20">岗位类别</td>  
        <td height="20">住房面积数</td> 
        <td height="20">办公面积数</td> 
        <td height="20">房补金额数</td> 
        <td height="20">供暖补贴费</td> 
        <td height="20">描述</td> 
        <td height="20">是否启用</td> 
      </tr>
      <s:iterator value="treeList" var="job" status="s">
      <tr bgcolor="#ffffff" align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#job.job_sno"/>','<s:property value="#job.job_sname"/>')">
 		
        <td height="24"><s:property value="#s.index + 1" /></td>
        <td height="24" title="${job.ud_sname}">
 <s:if test="%{#job.ud_sname.length() <= 15}">${job.ud_sname}</s:if>
		<s:else><s:property value="%{#job.ud_sname.substring(0,15) + '...'}"/></s:else></td>
        <td height="24" title="${job.job_sno}">${job.job_sno}</td>
        <td height="24" title="${job.job_sname}">
<s:if test="%{#job.job_sname.length() <= 15}">${job.job_sname}</s:if>
		<s:else><s:property value="%{#job.job_sname.substring(0,15) + '...'}"/></s:else></td>
        <td height="24" title="${job.ditem_sname2}级">${job.ditem_sname2}级</td>
        <td height="24" title="${job.ditem_sname1}">${job.ditem_sname1}</td>
        <td height="24" title="${job.job_nresarea}">${job.job_nresarea}</td>
        <td height="24" title="${job.job_noffarea}">${job.job_noffarea}</td> 
        <td height="24" title="${job_nhousmoney}">${job_nhousmoney}</td> 
        <td height="24" title="${job_nheatmoney}">${job_nheatmoney}</td>   
        <td height="24" title="${job.job_smem}">
<s:if test="%{#job.job_smem.length() <= 15}">${job.job_smem}</s:if>
		<s:else><s:property value="%{#job.job_smem.substring(0,15) + '...'}"/></s:else></td> 
        <td height="24">
        <s:if test='%{#job.job_sisvalid == "0"}'>启用</s:if>
		<s:if test='%{#job.job_sisvalid == "1"}'>不启用</s:if>
		</td>
      </tr>
      </s:iterator>
    </table>
</div></td></tr>
</table>
<div align="center"  >
    				<s:if test="%{treeList.size()!=0}">
    			
    			<page:page uri="/tree!findJob"></page:page>
    				</s:if>
    				<s:elseif test="%{treeList.size()==0}">
    				<br>
    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span></s:elseif>
    			 </div>
    	</td> 
    	</tr>
    </table>
   </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
                 <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
    			<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
   				 <input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
   				 <input type="hidden" id="ud_sname1" name="form.ud_sname" value="${form.ud_sname}"/>
   				 <input type="hidden" name="form.ud_sno" id="menu" value="${form.ud_sno}" > 
   				 
</form>
</body>
</html>
