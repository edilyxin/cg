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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title> 
 <link rel="stylesheet" type="text/css" href="<%=path%>/js/tree/ztree/css/zTreeStyle/zTreeStyle.css"/>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.core-3.4.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.excheck-3.4.js"></script>

<script>
  function checkAll(box){  //全选或全不选
	form1.checkbox.checked = box.checked;
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
  		form1.idcheckbox.checked = box.checked;	
  		return;
  	}
  	if(box.checked) {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = true;
		}
	} else {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = false;
		}
	}
  }
  
  function checkOne(){  //选一个时全选或全不选
  	
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
		form1.checkbox.checked = form1.idcheckbox.checked;
		return;
  	}
  	var numBox =0;
	for (var i = 0; i < numRow; i++) {
		if(form1.idcheckbox[i].checked){
			numBox++;
		}
	}
	if(numBox==numRow){
		form1.checkbox.checked = true;
	}else {
		form1.checkbox.checked = false;
	}
  }
function back(){
	window.location.href="<%=path%>/user!find";
}
</script>
</head>

<body>

<form name="form1" method="post">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">代理人查看</span></td>
              </tr>
            </table></td>
					<td align="right" >
            <span class="STYLE1" >
				<a href="#" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            </span>
            </td>
					</tr>
			</table>
			<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    <table width="400"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#95B0B9">
		<tr bgcolor="#CBE0FF"  class="STYLE10">
		<td width="40px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
        <td    class="STYLE6"><div align="center"><span >代理人(姓名)</span></div></td>
        <td    class="STYLE6"><div align="center"><span class="STYLE10">被代理人(姓名)</span></div></td>
        		
        		 
      </tr>
      <s:iterator value="list" var="emp" status="s">
		  <tr bgcolor="#ffffff" align="center""  >
		 
		
		  	
			<td height="24" ><strong>${s.index+1}</strong></td>
			<td height="24"><strong>${emp.emp_sname}</strong></td>
			<td height="24"><strong>${emp.emp_snameby}</strong></td>
		  </tr>
		  
		 </s:iterator>
    
</table>
<s:if test="%{list.size()<=0}">
		 	<div style="color: red;font-size: 12px" align="center" >抱歉，未查询到代理人和被代理人的信息！</div>
		 </s:if>
			</div>
  		</div>
		 
		</div>
</form>
</body>
</html>

			
