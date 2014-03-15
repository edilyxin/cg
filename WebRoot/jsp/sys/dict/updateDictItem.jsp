<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base target="_top"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script>
function toResut(){
    document.form1.reset();
} 
function save(){
	if(validator(document.form1)){
		if(confirm("是否修改?")) {
			$("#daichao").submit();
		}
	}
}
$(function(){
	var v = "${msg}";
	if(v!=""){
		alert(v);
		var dictnNo = $('#dict_sno1').val();
		//判断浏览器是否属IE 
		if(navigator.userAgent.indexOf("MSIE") != -1){       
		     	window.dialogArguments.window.location = "<%=path%>/dict!find1?form1.dict_sno="+dictnNo;
		}
		//判断浏览器是IE之外的其他浏览器  
		else{
		 	window.opener.location.reload();
		}
		window.close();
	}
});

//Ajax验证字典项名称的唯一性
	function findUniqueName(){
	//获取当前的类型名称是否存在
	var level = $('#dict_sname').val();
	var dictnNo = $('#dict_sno').val();
	var dictItemsNno = $('#ditem_nid').val();
	//alert(level+','+dictnNo+','+dictItemsNno);
	//alert(level);
	var falg = false;
	$.ajax({	
		type:'post',
		data:'form1.searchA='+level+"&form1.dict_sno="+dictnNo+"&form1.searchC="+dictItemsNno,
		dataType:'json',
		async:false,//定义同步，或者异步方式
		url:'dict!findDictUniqueItem',
		success:function(data){
		if(data.vo1==null){
			falg = true;
		}else{
			alert("字典项名称已存在，请重新输入！");
			falg = false;
		}	 
		}
	
	});
	return falg;
}
 //验证字典项值的唯一性
 	function findUniqueValue(){
	//获取当前的类型名称是否存在
	var level = $('#ditem_svalue').val();
	var dictItemsNno = $('#ditem_nid').val();
	var dictnNo = $('#dict_sno').val();
	var falg = false;
	$.ajax({	
		type:'post',
		data:'form1.searchB='+level+"&form1.dict_sno="+dictnNo+"&form1.searchC="+dictItemsNno,
		dataType:'json',
		async:false,//定义同步，或者异步方式
		url:'dict!findDictUniqueItem',
		success:function(data){
		if(data.vo1==null){
			falg = true;
		}else{
			alert("字典项值已存在，请重新输入！");
			falg = false;
		}	 
		}
	
	});
	//alert(falg+'最后是否为空');
	return falg;
} 
</script>
</head>
<body>
<form name="form1" id="daichao" action="dict!updateItem" method="post">
 <div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span></h2>
   <div class="content" id="divheight" style="overflow:auto;"> 
	 
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#0E6BB1">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">修改字典项</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              							</td>
          							</tr>
        						</table>
        					</td>
      					</tr>
    				</table>
    			</td>
  			</tr>
 			<tr valign="top">
    			<td>
    				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 				<tr>
					    <td nowrap align="right" width="13%">字典名称:</td>
					    <td colspan="3">
						    <input name="form1.dict_sname" id="dict_sname" value="${vo1.dict_sname}" readonly="readonly" class="text" style="width:154px;background: white;" maxlength="10" valid="required" errmsg="字典名称不能为空!"/>
						    <input name="form1.ditem_nid" id="ditem_nid" value="${vo1.ditem_nid}"   type="hidden" style="width:154px" maxlength="10"/>
						     <input name="form1.dict_sno" id="dict_sno" value="${vo1.dict_sno}"   type="hidden" style="width:154px" maxlength="10"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					    </tr>
					    <tr>
					    <td nowrap align="right" width="13%">字典项名称:</td>
					    <td colspan="3">
						    <input name="form1.ditem_sname" id="ditem_sname" value="${vo1.ditem_sname}"  class="text" style="width:154px" 
						     url="<%=path%>/dict!findDictUniqueItem?form1.dict_sno=${vo1.dict_sno}&form1.searchC=${vo1.ditem_nid}" urlmsg="字典项名称已存在！" 
						    maxlength="50" valid="required" errmsg="字典项名称不能为空!"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						   
					     </td>
					   </tr>
					    <tr>
					    <td nowrap align="right" width="13%">字典项值:</td>
					    <td colspan="3">
						    <input name="form1.ditem_svalue" id="ditem_svalue"  value="${vo1.ditem_svalue}"   class="text" style="width:154px" 
						    url="<%=path%>/dict!findDictUniqueItem?form1.dict_sno=${vo1.dict_sno}&form1.searchC=${vo1.ditem_nid}" urlmsg="字典项值已存在！" 
						    maxlength="10" valid="required" errmsg="字典项值不能为空!"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    
					     </td>
					     </tr><tr>
					      <td nowrap align="right" width="13%">字典项描述:</td>
					    <td colspan="3" >
						    <input name="form1.ditem_sdef1" style="width:260px" maxlength="100" id="ditem_sdef1" value="${vo1.ditem_sdef1}"   class="text"  />
						    
					     </td>
					    </tr>
					  </table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="save();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="window.close();"  />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    <input type="hidden" id="dict_sno1" value="${dict_sno}">
  </form>
  </body>
</html>
 