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
   <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>   
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门查询</title>

<script type="text/javascript">

function find(){

 document.frm.action="tree!findUD";
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
<body>   
<form id="frm" name="frm" action="<%=path %>/tree!findUD" method="post"  >
 <table width="100%" height="95%"  border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif">
    	<img src="<%=path %>/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="<%=path %>/images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
        <tr>
            <td height="31"><div class="titlebt">单位部门</div></td>
        </tr>
        </table>
    </td>
    <td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif">
    	<img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  </tr>
  <tr>
    <td valign="middle" height="100%" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
      <tr >
        <td   valign="top">
    	<table width="95%" border="0"  cellspacing="2" >
  <tr style="font-size:12px;">
  <td>
    <span  style="white-space:nowrap;">&nbsp;&nbsp;单位编号：
		     <input type="text" maxlength="50" size="6" id="searchA" name="form.searchA" value="${form.searchA}"/>
		     </span>
			<span  style="white-space:nowrap;">&nbsp;&nbsp;单位名称
		     <input type="text" maxlength="50" size="6" id="searchB" name="form.searchB" value="${form.searchB}"/>
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
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">单位部门列表</span></td>
              </tr>
            </table></td>
            <td>
            <div align="right">
            <span class="STYLE1">
	         </span>
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table>
    			</td>
  			</tr>
  			<tr>
    			<td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">     	 
   <table width="100%" id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
	      <tr class="dictionary"  style="font-size:14px;">
	      	<td width="40" height="20" bgcolor="d3eaef"  class="STYLE6"><div align="center"><strong>序号</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef"  class="STYLE6"><div align="center"><strong>单位编号</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>单位名称</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>单位简称</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>隶属层次</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>隶属单位</strong></div></td>
			<td width="100" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>单位层次</strong></div></td>
</tr>
<s:iterator value="treeList"  status="s" var="ud">
	<tr bgcolor="#ffffff" align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#ud.ud_sno"/>','<s:property value="#ud.ud_sname"/>')">
	  <td  >${s.index+1 }</td>
	  <td align="center" height="24"><s:property value="#ud.ud_sno"/></td>
	  <td height="24"><s:property value="#ud.ud_sname"/></td>
	  <td height="24"><s:property value="#ud.ud_ssname"/> </td>
	  <td height="24"><s:property value="#ud.ud_stop"/> </td>
	  <td height="24"><s:property value="#ud.ud_stopno"/> </td>
	  <td height="24"><s:property value="#ud.ditem_sname1"/> </td>
	</tr>
</s:iterator>
</table>  
</div></td></tr>     
  			<tr>
    			<td height="30" align="center">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="100%"><div align="center"  >
			<s:if test="%{treeList.size()!=0}">
				<page:page uri="/tree!findUD"></page:page>
			</s:if>
			<s:elseif test="%{treeList.size()==0}"> 
			<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
			</s:elseif>
	   		</div></td>
      </tr>
    </table></td>
  </tr>
</table>
  </td> 
    	</tr>
    </table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<input type="hidden"  name="menu" id="menu" value="<s:property value="menu"/>" /> 
<input type="hidden" name="form.ud_stopno" value="${form.ud_stopno}"/>
<input type="hidden" name="form.ud_nnumber" value="${form.ud_nnumber}"/>
<input type="hidden" name="form.emp_sno" value="${form.emp_sno}"/>
<input type="hidden" name="form.sh_sno" value="${form.sh_sno}"/>
<input type="hidden" name="form.ud_stop" value="${form.ud_stop}"/>
<input type="hidden" name="form.searchG" value="${form.searchG}"/>
<input type="hidden" name="form.searchH" value="${form.searchH}"/>
</form>   
</body>
</html>

