<%@ page language="java" import="java.util.*" isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="robots" content="none">
<title>splitor</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script language="javascript" src="<%=path %>/js/constants.js"></script>
<script language="javascript" src="<%=path %>/js/pubUtil.js"></script>
<script language="javascript" src="<%=path %>/js/splitor.js"></script>
  <script language="javascript">
    var splitor=new FrameSplitor("middle",1,1,1,0);
    function init()
    {      
      splitor.init();
      document.onmousedown=function(ev){splitor.mouseDown(ev)};
      document.onmouseup=function(ev){splitor.mouseUp(ev);}
      document.onmousemove=function(ev){splitor.mouseMove(ev)};
      window.onresize=function(ev){};
      splitor.hideCallback=function()
      {
        PubUtil.showHideElement("navTree",false,top.modNav.document);
        PubUtil.showHideElement("otherTools",false,top.modNavTop.document);
      }

      splitor.showCallback=function()
      {
        PubUtil.showHideElement("navTree",true,top.modNav.document);
        PubUtil.showHideElement("otherTools",true,top.modNavTop.document);
      }

      splitor.moveCallback=function()
      {
        PubUtil.showHideElement("navTree",true,top.modNav.document);
        PubUtil.showHideElement("otherTools",true,top.modNavTop.document);
      }
    }
  </script>
</head>

<body onLoad="javascript:init();">
<table width="14" height="100%" border="0" cellpadding="0" cellspacing="0" style="cursor:e-resize">
  <tr>
    <td height="406" valign="middle" background="<%=path %>/img/main_r3_c3.jpg" style="background-repeat: repeat-y; "><table width="14" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td></td>
      </tr>
      <tr>
        <td><img id="mover" src="<%=path %>/img/close.jpg" style="cursor:hand; " width="14" height="78" onClick="javascript:splitor.showHide();" title="关闭左侧"></td>
      </tr>
      <tr>
        <td></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
