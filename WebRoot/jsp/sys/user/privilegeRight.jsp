<%@ page language="java" import="java.util.*,net.sf.json.JSONArray" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList rightList=(ArrayList)request.getAttribute("list"); 
JSONArray jsonArray=JSONArray.fromObject(rightList);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title> 
 <link rel="stylesheet" type="text/css" href="<%=path%>/js/tree/ztree/css/zTreeStyle/zTreeStyle.css"/>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.core-3.4.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.excheck-3.4.js"></script>
<style type="text/css">
	.bigBox ul li{ float:none;}
</style>
  <script type="text/javascript">
  var length;
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		$(document).ready(function(){
			var json = ${jsonArray};
			 var zNodes =json;//tree树形数据
			 length = zNodes.length;
			 for(var i =0 ;i< zNodes.length;i++){
				// alert(zNodes.length);
				 var treeObj;
				 if(i == 0){
						$.fn.zTree.init($("#treeDemo"), setting, zNodes[0]);
						treeObj  = $.fn.zTree.getZTreeObj("treeDemo");
				 }else{
					 	//alert(i);
						$('.ztree').eq($('.ztree').length-1).after("<ul id='treeDemo"+i+"' class='ztree'></ul>");
						$.fn.zTree.init($("#treeDemo"+i), setting, zNodes[i]);
						treeObj  = $.fn.zTree.getZTreeObj("treeDemo"+i);
				 }
				// alert(treeObj);
				 var nodeSysint = treeObj.getNodes();//获取跟节点
					for(var j=0;j<nodeSysint.length;j++){
						nodeSysint[j].nocheck=true;//将根节点设置为没有选择框
						treeObj.updateNode(nodeSysint[j]);//更新修改的根节点
					}
					//将已经保存过的权限选中
					var nodes = treeObj.transformToArray(treeObj.getNodes());
					for(var k=0;k<nodes.length;k++){
						if(nodes[k].myChecked=='1'){
							treeObj.checkNode(nodes[k],true);
							treeObj.updateNode(nodes[k]);//更新修改的根节点
						}
					}
					treeObj = null;
				
			 }
					
		});
		
		//分配功能权限
		function priviligeRight(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			//if(nodes.length==0){
				//alert("请选中一项权限进行分配！");
				//return false;
			//}else{
						//获得选中的checkbox值
				var str="";
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = treeObj.getCheckedNodes(true);
				//if(nodes.length==0||nodes.length==undefined){
					//alert("请选择权限！");
					//return false;
				//}
				for(var i=0;i<nodes.length;i++){
					str+=nodes[i].id+"|"+nodes[i].sysint_sno+",";
				}
				//alert(length);
				for(var i = 1;i<length;i++){
					var treeObj = $.fn.zTree.getZTreeObj("treeDemo"+i);
					var nodes = treeObj.getCheckedNodes(true);
					for(var j=0;j<nodes.length;j++){
						str+=nodes[j].id+"|"+nodes[j].sysint_sno+",";
					}
				}
				$("#rights").val(str);
				//alert(str);
				document.form1.action="<%=path%>/user!saveUserRight";
				document.form1.submit();
			//}
		}
		
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
  
  //特权之操作权限分配
  function privilegeOper(){
  	document.all.form1.action="<%=path%>/user!toUserOper";
  	document.all.form1.submit();
  }
  //特权之数据权限分配
  function dbPrivilegeOper(){
  	document.all.form1.action="<%=path%>/user!toUserDB";
  	document.all.form1.submit();
  }
function back(){
	window.location.href="<%=path%>/user!find";
}
</script>

</head>

<body>

<form name="form1" id="form1" method="post">
<input type="hidden" id="rights" name="rights" value=""/>
<input type="hidden" id="userId" name="userId" value="${userId}"/>
<div class="bigBox" id="idwidth">
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
                			<td valign="bottom"><span class="STYLE1" style="white-space:nowrap;">特权分配 &gt; 功能权限分配</span></td>
              			</tr>
            			</table>
            		</td>
					<td align="right" >
            		<span class="STYLE1" >
						<a href="#" onclick="priviligeRight();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">分配</span></a>&nbsp;
				<a href="#" onclick="privilegeOper();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">操作权限分配</span></a>&nbsp;
				 
				<a href="#" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
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
                					 
   									<div style="height:450px;overflow-y:auto;">
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
 
