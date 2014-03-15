<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title> 
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/tree/selectjs.js"></script>
<script type="text/javascript" src="<%=path%>/js/tree/treejs.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/text.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/validate.css"  />
<script type="text/javascript" src="<%=path%>/js/DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css"/>
<link rel="stylesheet" href="<%=path%>/common/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/common/css/alter.css"  type="text/css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery.bgiframe.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="<%=path %>/js/tree/ztree/css/zTreeStyle/zTreeStyle.css"/>
<link rel="stylesheet" href="<%=path %>/css/skin.css" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.excheck-3.4.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.exedit-3.4.js"></script>
  <style type="text/css">
.bigBox ul li{ float:none;}
</style>
  <script type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		
		var data =${jsonArray};
		$(document).ready(function(){
			for(var i =0 ;i< data.length;i++){
				if(i == 0){
					$.fn.zTree.init($("#treeDemo"), setting, data[0]);
				}else{
					$('.ztree').eq($('.ztree').length-1).after("<ul   id='treeDemo"+i+"' class='ztree'></ul>");
					$.fn.zTree.init($("#treeDemo"+i), setting, data[i]);
				}
			}
			//$.fn.zTree.init($("#treeDemo"), setting, data);
		});
   </script>
  
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

<form name="form1" method="post"  >
<div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
   		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
					<span style="white-space:nowrap;">&nbsp;&nbsp;用户名：${form.screenname}</span>&nbsp;&nbsp;
	             	<span style="white-space:nowrap;">&nbsp;&nbsp;姓名：${form.firstname}</span>
	             	</td>
				</tr>
				<tr bgcolor="#0E6BB1">
					<td height="30" >
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                			<td valign="bottom"><span class="STYLE1" style="white-space:nowrap;">用户权限</span></td>
              			</tr>
            			</table>
            		</td>
					<td align="right" >
            		<span class="STYLE1" >
						<a href="javascript:void(0);" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            		</span>
            		</td>
				</tr>
        	</table>
        	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      			<tr bgcolor="#FFFFFF">
        			<td   bgcolor="#FFFFFF">
					  	<table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 			<tr height="100%" >
                					<td align="right" valign="top" nowrap="nowrap">
                					<div align="center">
	  									<c:if test="${jsonArray==null||jsonArray=='[]'}">
	  									<br/>
	  									<span style="font-size:14px;font-weight:bold;color:red;">抱歉，该用户暂时没有分配相关权限！</span>
	  									</c:if>
  									</div>
   									<div style="overflow-y:auto;">
  										<ul id="treeDemo" class="ztree"></ul>
  									</div>
 									</td>
              					</tr>
 						</table>
					</td>
      			</tr>
    		</table>
    </div>
</div>
  </form>
  </body>
 
</html>

 