<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>图标选择</title>
<link href="<%=path %>/css/default.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript">
	function getPath(path) {
		window.returnValue = path;
		window.close();
	}
</script>
  </head>
  <body>
    <body style="text-align:left;">
    
	<div id="content">
		<div class="selecter">
			<div class="selecterContent">
			<input type="button"  onclick="getPath('');" value="清空"><br>
				<ul class="nolist">
					  
					<s:iterator value="imgNameList" var="imgPath">
						<li><a href="javascript:void(0);" onclick="getPath('${imgPath}');"><img src="<%=path %>/${imgPath}" alt="${imgPath}" title="${imgPath}" width="20" height="20" style="cursor:hand"/></a></li>
					</s:iterator>
				</ul>	
			</div>
		</div>
		
	</div>  
</body> 
</html>
