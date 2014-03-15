<%@ page language="java" import="java.util.*" isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="robots" content="none">
<link href="<%=path %>/css/right1.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/right2.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/text.css" rel="stylesheet" type="text/css" />
</head>

<body>
 <div class="right1">
        	<ul class="right1_ul1">
            	<li><img src="<%=path %>/image/landian.jpg" /></li>
                <li><a href="#">新增楼栋</a></li>
                <li><a href="#">修改楼栋</a></li>
                <li><a href="#">拆除楼栋</a></li>
                <li><a href="#">楼栋预分配</a></li>
            </ul>
            <ul class="right1_ul2">
            	<li><img src="<%=path %>/image/lvdian.jpg" /></li>
                <li><a href="#">二维图</a></li>
                <li><img src="<%=path %>/image/lan2.jpg" /></li>
                <li><a href="#">三维图</a></li>
                <li><img src="<%=path %>/image/hongyuan.jpg" /></li>
                <li><a href="#">选择展示</a></li>
                <li><img src="<%=path %>/image/hongyuan.jpg" /></li>
                <li><a href="#">全部展示</a></li>
            </ul>
        </div>
          <div class="right2">
  	<div class="right2_s"></div>
    <div class="right2_x"></div>
  </div>
</body>
</html>
