<%@ page language="java" import="java.util.*,com.rc.sys.vo.*"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/util.jsp"/>
<title>角色操作权限分配</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script type="text/javascript" src="<%=path %>/js/valid.js"></script>
<style type="text/css">
/*通用样式*/
body {
	font-size: 12px;
	font-family: "宋体", Georgia, "Times New Roman", Times, serif;
	background: url(../img/bg.jpg) repeat-x;
}

* {
	padding: 0;
	margin: 0
}

li {
	list-style: none
}

img {
	border: none
}

a img {
	border: none
}

a {
	text-decoration: none
}

input {
	vertical-align: middle;
}

a:hover {
	text-decoration: underline;
}

#roleFrm h4 {
	height: 26px;
	font-size: 12px;
	line-height: 26px;
	padding-left: 30px;
	color: #fff;
	font-weight: 500;
	border: 1px solid #3F7EC1;
	background: url(../../common/img/index/h21.jpg) repeat-x
}

#roleFrm h4 a {
	color: #fff;
}

#roleFrm h4 span {
	color: red;
}

.dictionary td {
	background: #eef7fe;
	height: 19px;
	color: #0065AB;
	font-size: 12px;
	text-align: center
}

.listViewThS1 {
	text-align: center
}
</style>
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script language="javascript">
	function confirmForm() {  //确认选择框
  	if(confirm("您确定此操作吗?")) {
  		return true;
  	} else {
  		return false;
  	}
  }
	function deleteMulti_onClick(){  
    if(confirm("是否保存？"))
	 {
	document.form1.action="<%=path%>/role!addRight";
	document.form1.submit();
	}
   
  }
	function auType_onChange() {
		if(document.form1.select2.value=="1")
			location.href = "manageDataAuthorize.htm";
		else if(document.form1.select2.value=="2")
			location.href = "manageFuncAuthorize.htm";
		else if(document.form1.select2.value=="3")
			location.href = "manageRole.htm";
		else
		;
	}
	
 function chkAll()
 {
      var obj=document.all.oper_sno;
      var len=obj.length;
     if(document.all.chkok.value=="全选")
     {
       for(var i=0;i<len;i++)
       {
          obj[i].checked=true;
        }
        document.all.chkok.value="全取消";
     }else{
     
       for(var i=0;i<len;i++)
       {
          obj[i].checked=false;
       }
       document.all.chkok.value="全选";
     }

 }

 function backPage(){
   document.all.roleFrm.action="role!find";
   document.all.roleFrm.submit();
}
 //保存角色权限
function saveRoleOper(){
	document.all.roleFrm.action="<%=path%>/role!saveRoleOper";
	document.roleFrm.submit();
}
 
//开始 我的js    角色权限保存与显示角色原有权限checkClass
$(function(){
	var checkClass = $(".checkClass");
	var oneOper = $(".oneOper");
	var t=new Array();
    var i=0;
    
    oneOper.each(function(){   //迭代出用户所拥有权限
    	t[i]=$(this).val();
    	i++;	
    	});
    	
    checkClass.each(function(){
    	var c = $(this).val(); 
    	for(var j=0; j<t.length; j++){
    		if(c==t[j]){
    			$(this).attr("checked",true);
    		}	
    	}
    });
});
</script>
</head>
<body>
	<form action="" method="post" name="roleFrm" id="roleFrm">
	<div class="bigBox"><!--外部大DIV，可以调整宽度-->
	<h2><span><a href="javascript:void(0)">系统管理</a> &gt; <a href="javascript:void(0)">角色信息</a> &gt; 角色操作权限分配</span></h2>	
	</div>
	<div class="content">
		<!--<div id="div01" name="div01">
			--><table width="100%" cellspacing="0" cellpadding="0" border="0"
				style="border-top: 0px none; margin-bottom: 4px" class="tabForm">
				<tr>
					<td width='8%' nowrap="nowrap" bgcolor="#eef7fe" align="left"
						valign="middle">&nbsp;角色编号</td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle">角色名称</td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle">角色类别</td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle">
						<input type="button" id="btnSave" name="submit22"  class="button_02a" value="保存" onClick="javascript:saveRoleOper();" />
						&nbsp;&nbsp; 
						<input type="button" id="btnBack" name="submit22"  class="button_02a"
						value="退回" onClick="javascript:backPage();" /></td>
				</tr>
				<tr>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" id="role_sno"
						align="left" valign="middle">&nbsp;${role.role_sno}</td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle">${role.role_sname}</td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle">
							<s:if test="%{role.role_stype==\"0\"}">超级管理员</s:if><s:if test="role.role_stype==\"1\"">系统管理员</s:if>
							<s:if test="role.role_stype==\"2\"">普通用户</s:if><s:if test="role.role_stype==\"3\"">一般用户</s:if><!--
						${role.role_stype}
					--></td>
					<td nowrap="nowrap" width='8%' bgcolor="#eef7fe" align="left"
						valign="middle"><input type="hidden" name="role_sno" id="role_sno"
						value="${role.role_sno}" />&nbsp;
					</td>
				</tr>
				<!-- 隐藏该角色拥有的操作权限 -->
				<s:iterator value="operList" var="v">
					<input class="oneOper" value="${v.oper_sno}" style="display:none" />
				</s:iterator>
			</table>
			<table class="div0" width="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td height="24"
						style="background:url(../../common/img/index/p.jpg) repeat-x; border:1px solid #ADC4D6; padding-left:10px; font-size:12px;"><img
						src='images/icon/07-0.gif' width="16" height="16"
						align="absmiddle" style="cursor:hand">角色操作功能信息</td>
				</tr>
			</table>
			<table cellpadding='0' cellspacing='0' width='100%' border='0'
				class='listview'>
				<tr>
					<td>
						<table border=0>
							<tr height=20 class="dictionary">
								<td scope='col' class='listViewThS1' nowrap height="30"
									width="1%">
									<div style="white-space:nowrap;" align="center">序号</div></td>
								<td scope='col' class='listViewThS1' nowrap height="30"
									width="10%">
									<div style="white-space:nowrap;" align="center">功能编号</div></td>
								<td scope='col' class='listViewThS1' nowrap height="30"
									width="12%">
									<div style="white-space:nowrap;" align="center">功能名称</div></td>
								<td scope='col' class='listViewThS1' nowrap height="30">
									<div style="white-space:nowrap;" align="left">
										操作项 <input type="button" name="submit22"  class="button_02a" id="chkok" value="全选"
											onclick="javascript:chkAll();">
									</div></td>
							</tr>
							<s:iterator value="map.keySet()" var="key" status="st">
							<tr>
									<td scope='col' class='listViewThS1' nowrap height="30"
										width="1%">
										<div style="white-space:nowrap;" align="center">
											<s:property value="#st.index + 1" />
										</div></td>

									<td scope='col' class='listViewThS1' nowrap height="30"
										width="10%">
										<div style="white-space:nowrap;" align="center">${key.right_sno}</div>
									</td>

									<td scope='col' class='listViewThS1' nowrap height="30"
										width="12%">
										<div style="white-space:nowrap;" align="center">${key.right_sname}</div>
									</td>
								
								<td scope='col' class='listViewThS1' nowrap height="30"
									colspan="3">
									<div style="white-space:nowrap;" align="left">
										<s:iterator value="map.get(#key)" var="li">
												<input type="checkbox" class="check" name="check" id="oper_sno" value="${li.right_sno}:${li.oper_sno}" 
													<s:iterator value="operList" var="elem"><s:if test="#li.oper_sno == #elem.oper_sno">checked</s:if></s:iterator>
													>${li.oper_stype}
										</s:iterator>
										<input type="hidden" name="arrMap" id="arrMap" value=""/>
									</div></td>
							</tr>
							</s:iterator>
						</table></td>
				</tr>
			</table>
		</div>
		
	</form>

</body>
</html>

