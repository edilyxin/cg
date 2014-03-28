<%@ page language="java" import="java.util.*, com.rc.base.vo.MngUnitDepart" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="main1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script src="<%=path %>/js/prototype.lite.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.pack.js" type="text/javascript"></script>

<link  href="<%=path %>/css/left.css" rel="stylesheet" type="text/css" />
<link  href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var path="<%=path%>/";

</script>
<script src="<%=path %>/js/new_tree.js" type="text/javascript"></script>
</head>
<body>
 <form  name="form1" method="post">
 	<input type="hidden"  name="form.searchA" id="searchA" >
 	<input type="hidden"  name="form.searchB" id="searchB" >
 	<input type="hidden"  name="form.searchC" id="searchC" >
 	<input type="hidden"  name="menu" id="menu" >
 	<input type="hidden"  name="idcheckbox" id="idcheckbox" >




<ul>

<s:iterator value="projectMenu"  id="li" status="st"> 
     <li>     	
     	<a href="<%=path%>/splite!find?EP_SNO=${li.EP_SNO}">${li.EP_SNO }</a>
     </li>       
      </s:iterator>
</ul>
 </form>
</body>
</html>
