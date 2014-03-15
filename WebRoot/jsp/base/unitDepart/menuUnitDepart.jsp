<%@ page language="java" import="java.util.*, com.rc.base.vo.MngUnitDepart" isELIgnored="false" pageEncoding="UTF-8"%>
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
 	<input type="hidden"  name="form.searchD" id="searchD" >
 	<input type="hidden"  name="menu" id="menu" >
 	<input type="hidden"  name="idcheckbox" id="idcheckbox" >
 </form>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td nowrap valign="top" align="left"><!--菜单树开始--> 
                  			<script type="text/javascript">
							 if (document.getElementById)
							 {
								var node0=new WebFXTree("<b>单位部门</b>","<%=path%>/unitDepart!find","searchB=|menu=");
									<%
										List udList = (List) request.getAttribute("udList");
										for (int i = 0; i < udList.size(); i++) {
											MngUnitDepart ud = (MngUnitDepart) udList.get(i);
											String id = ud.getUd_sno();
											String pId = ud.getUd_stopno();
											Long ud_nnumber = ud.getUd_nnumber();
											String name = ud.getUd_sname();
											String pname = ud.getUd_stopname();
											if (pname == null) {
												pname = "";
											}
											if (pId == null) {
												pId = "0";
											}
											String param3 = "searchB=" + name + "|searchD=" + ud_nnumber + "|menu=0";
									%>
										var node<%=id%> = new WebFXTreeItem("<%=name %>","<%=path%>/unitDepart!find","<%=param3 %>");
										node<%=pId%>.add(node<%=id%>);
									<%
									}
									%>
								document.write(node0);
								node0.expand();
							 };
							</script> 
								<input type="hidden" name="selText">
								<input type="hidden" name="iSize">
								<input type="hidden" name="selTreeID">
								<input type="hidden" name="selNodeID">
                  	<!--菜单树结束--> </td>
	</tr>
</table>


</body>
</html>
