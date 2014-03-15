<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>采购管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
</head>
<frameset rows="74,*" cols="*" frameborder="no" border="0" framespacing="0"  >
  	<frame name="top" src="<%=path %>/login!loginMainRight" name="topFrame" scrolling="auto"  noresize="noresize" id="topFrame" title="topFrame"  />
  	<frameset cols="226,*" frameborder="no" border="0" framespacing="0" id="rowFrame">
   		<frame name="leftFrame" frameborder="0" src="<%=path %>/login!loginMenuRight" noresize="noresize"  marginheight="0" marginwidth="0" />
  		<frameset rows="*,20" frameborder="no" border="0" framespacing="0" id="rowFrame"><!-- welcome.jsp -->
  			<frame name="main" frameborder="0" src="<%=path %>/login!welcome" noresize="noresize"  marginheight="0" marginwidth="0" />
  			<frame name="mainbottom" frameborder="0" src="<%=path %>/footer.jsp" noresize="noresize"  marginheight="0" marginwidth="0" />
  		</frameset>
  	</frameset>
</frameset>
<noframes>
</noframes>
</html>
