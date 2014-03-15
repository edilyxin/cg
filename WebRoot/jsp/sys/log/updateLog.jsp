<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>日志管理</title>
    <link href="<%=path %>/css/right1.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/right2.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/text.css" rel="stylesheet" type="text/css" />

<script language="javascript">
function save()
{
	if(confirm("是否删除?"))
	{
		document.form1.action="<%=path %>/log.do?method=del";
		document.form1.submit();
	}
}
</script>
  </head>
  
  <body>
 <form name="form1" method="post">
  <div class="right1" align="center">
        	<ul class="right1_ul3" >
            	<li > <input name="submit22" type="button" class="button_02a" value="删除" onClick="save()"></li>
            </ul>
        </div>
          <div class="right2">
  	<div class="right2_s"></div>
  	<div class="right2_x" >
  	<div style="width:728px;height:490px;overflow:auto;">
  	<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" class="tabletext">
				       <tr bgcolor="#ffffff">
				       		<td width="50%" align="right">起始时间：</td>
				       		<td><input type="text" name="beginTime"/></td>
				       		
				       </tr>
				         <tr bgcolor="#ffffff">
				       		<td align="right">结束时间：</td>
				       		<td><input type="text" name="endTime"/></td>
				       		
				       </tr>
				       
			  </table>
	       </div>
	       
	      
  	
    </div>
  </div>
  
  </form>
  </body>
</html:html>
