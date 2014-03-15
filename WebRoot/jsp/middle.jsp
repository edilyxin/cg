<%@ page language="java" import="java.util.*" isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
%>
<HEAD>
<meta name="robots" content="none">
<script type="text/javascript" src="<%=path%>/js/limit.js"></script>
</HEAD>
    <TABLE width="998" border="0" cellpadding="0" cellspacing="0" align="center"  height='603'>
<TR>
	<TD id="frmTitle" valign="top">
	<IFRAME width="130" height='603' id=frmleft name=frmleft src="<%=path %>/MenuServlet?action=6" scrolling=no frameBorder=0 allowTransparency align="middle"></IFRAME>
	
	</TD>

<td width="14" height='603' background="img/main_r3_c3.jpg" style="background-repeat: repeat-y; ">
		<table width="14" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td onclick="switchSysBar()"><SPAN style="cursor:hand; " id="switchPoint" title="关闭/打开左栏"><img src="img/close.jpg" width="14" height="78"></span></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table></td>
	 <td width="843" valign="top" align="center"><IFRAME height='600' width="840" id="workspace" name="workspace" src="" scrolling=auto frameBorder=0 allowTransparency align="middle"></IFRAME></td>
</TR>
</TABLE>
