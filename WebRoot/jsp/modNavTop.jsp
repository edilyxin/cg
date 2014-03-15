<%@ page language="java" import="java.util.*" isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style type="text/css">
div.topBar{
    width:100%;
	SCROLLBAR-FACE-COLOR: #E1F2FC;
SCROLLBAR-HIGHLIGHT-COLOR: #A3C3D5; 
SCROLLBAR-SHADOW-COLOR: #A3C3D5;
SCROLLBAR-3DLIGHT-COLOR:#ffffff; 
SCROLLBAR-ARROW-COLOR:#5B86AF; 
SCROLLBAR-TRACK-COLOR: #EDF7FA; 
SCROLLBAR-DARKSHADOW-COLOR: #DBEDF2;
SCROLLBAR-BASE-COLOR: #DBEDF2;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script language="javascript">
    var showFlag=1;

    //显示/隐藏顶部及nav.
    function showHideHdNav()
    {
      var topFrameset=top.document.getElementById("top");
      if(showFlag==1)//当前显示,隐藏
      {
        top.splitor.splitor.showHide(0);
        topFrameset.rows="0,*,0";
        showFlag=0;        
      }
      else
      {
        top.splitor.splitor.showHide(1);
        topFrameset.rows="82,*,25";
        showFlag=1;        
      }      
    }
  </script>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<meta name="robots" content="none">
<body>
<div>
  <table width="100%" height="14" border="0" cellpadding="0" cellspacing="0" >
    <tr>
      <td align="center"  background="<%=path %>/img/top2_bg.jpg"><img style="cursor:hand " align="middle" alt="隐藏/显示上栏" title="隐藏/显示上栏" onClick="javascript:showHideHdNav();"  src="<%=path %>/img/top2_1.gif" width="78" height="14"></td>
    </tr>
  </table>
</div>
</body>
</html>
