<%@ page language="java" import="java.util.*,com.rc.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


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
  
</script>

<script type="text/javascript">
	var setting = {
	//treeObj:,
	
		
		check: {
			enable: true,
			chkStyle : "checkbox",
			nocheckInherit: false,
			chkboxType: { "Y" : "ps", "N" : "ps" }
		
			
			
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		
		callback: {
		beforeCheck: zTreeBeforeCheck
	}
	};
function zTreeBeforeCheck(treeId, treeNode) {
	//alert(treeNode.myChecked);
    return true;
};



var length;	
	
  //保存权限代理
  function saveDlRight(){
  		if(validator(document.form1)){
	  		//获得选中的checkbox值
			var str="";
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			if(nodes.length==0||nodes.length==undefined){
				alert("请选择代理权限！");
				return false;
			}
			for(var i=0;i<nodes.length;i++){
				str+=nodes[i].id+"|"+nodes[i].sysint_sno+",";
			}
			for(var i = 1;i<length;i++){
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo"+i);
				var nodes = treeObj.getCheckedNodes(true);
				for(var j=0;j<nodes.length;j++){
					str+=nodes[j].id+"|"+nodes[j].sysint_sno+",";
				}
			}
			$("#rights").val(str);
			document.form1.action="<%=path%>/user!saveDlRight";
			document.form1.submit();
		}
  }
  
  //选择代理人或被代理人触发的事件
  function isCheck(str){
  	if(str=="empNOBy"){
  		var empNO=$("#empNO").val();
  		if(empNO==null||empNO==""){
  			alert("请选择代理人！");
  			$("#empNO").focus();
  			return false;
  		}
  	}else if(str=="empNO"){
  		var empNOBy=$("#empNOBy").val();
  		if(empNOBy==null||empNOBy==""){
  			$("#empNOBy").focus();
  			return false;
  		}
  	}
  	var empNO=$("#empNO").val();//代理人编号 
  	var empNOBy=$("#empNOBy").val();//被代理人编号
  	
  	   $.ajax({  
			type: "POST",  
			url: "user!findDlRight",  
			data: {  
				empNO:empNO,
				empNOBy:empNOBy
			},  
			datatype: "json",  
			success: function(data) {  
				//alert(data);
			}
    	});  
  }	
 //点击input框click事件

  $(function (){
 
  $("#emp_snameby").click(function(){
   var empNO=$("#emp_sno").val();//代理人编号 
 	 empTree('emp_snoby','emp_snameby','','${userinfo.ud_sno}','','','','','','','','','','',empNO);
   		var empNO=$("#emp_sno").val();//代理人编号 
	  	var empNOBy=$("#emp_snoby").val();//被代理人编号
	  	var userId = $("#userid").val();
	  	if(empNOBy==""){
	  		$('#treeDemo').empty();
	  	}
		if(empNO!=""&&empNOBy!=""){
			$('#treeDemo').empty();
	  		$.ajax({  
				type: "POST",  
				url: "user!findDlRight",  
				data: { 
					userId:userId,
					empNO:empNO, 
					empNOBy:empNOBy
				},  
				datatype: "json",  
				success: function(data) {  
	      		    var msg = eval('(' + data + ')');//将字符串转换为json对象
					var zNodes =msg;//tree树形数据
					$(function(){
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
						}
						/*
						$.fn.zTree.init($("#treeDemo"), setting, zNodes);
						var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
						var nodeSysint = treeObj.getNodes();//获取跟节点
						for(var i=0;i<nodeSysint.length;i++){
							nodeSysint[i].nocheck=true;//将根节点设置为没有选择框
							treeObj.updateNode(nodeSysint[i]);//更新修改的根节点
							
						}
						//将已经保存过的权限选中
						var nodes = treeObj.transformToArray(treeObj.getNodes());
						for(var i=0;i<nodes.length;i++){
							if(nodes[i].myChecked=='1'){
								treeObj.checkNode(nodes[i],true);
								treeObj.updateNode(nodes[i]);//更新修改的根节点
							}
						}
						*/
					});		
					
					}
	    	});  
	 	}
  });
});
function back(){
	window.location.href="<%=path%>/user!find";
}
</script>

</head>

<body>

<form name="form1" method="post"  >
<input type="hidden" id="rights" name="rights" value=""/><!-- session.userInfo.userid -->
<input type="hidden" id="userId" name="userId" value="${userId}"/>
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				 
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">权限代理</span></td>
              </tr>
            </table></td>
					<td align="right" >
            <span class="STYLE1" >
				<a href="javascript:void(0)" onclick="saveDlRight();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">确定代理</span></a>&nbsp;
				<a href="javascript:void(0)" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            </span>
            </td>
					</tr>
			</table>
			<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    		<s:if test="role.emp_sno!=null">
   			<table class="table" width="500px" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
   			<tr  bgcolor="d3eaef">
   			
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">代理用户：</span></td>
	  			<td height="25"  nowrap="nowrap">
	  			 <input type="text"  id="screenname" name="screenname"  value="${role.screenname}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			<input type="hidden"  id="userid" name="form.userid"  value="${userId}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			 </td>
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">代理人：</span></td>
	  			<td height="25"  nowrap="nowrap">
	  			 <input type="text" id="emp_sname" name="emp_sname"  value="${role.emp_sname}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			<input type="hidden"   id="emp_sno" name="empNO"  value="${role.emp_sno}"/>
	  			</td>
		   		</tr><tr>
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">被代理人：</span></td>
	  			<td height="25" nowrap="nowrap" >
		   		 <input type="text"   id="emp_snameby"   value="" valid="required" errmsg="被代理人不能为空!" readonly/>
    			 <input type="hidden" id="emp_snoby"  name="empNOBy" value=""/> 
		   		</td>
		   		<td title="选择一个被代理人进行代理"  nowrap="nowrap" colspan="2">
		   		<div style="color: red">注意：选择一个被代理人进行代理</div>
		   		</td>
	   		</tr>
   			</table>
   			</s:if>
		   		<s:else>
		   		<br/>
		   			<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，该用户还没有设置员工！</strong></span></div>
		   		</s:else>
		<div style="height:330;overflow-y:auto;">
   		<ul id="treeDemo" class="ztree"></ul>
   		
   		</div>
			</div>
  		</div>
		 
		</div>
</form>
</body>
</html>
			
			 