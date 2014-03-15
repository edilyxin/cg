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
			$("#form1").submit();
		}
		
	
	}
	
}
$(function(){
	var v = "${msg}";
	if(v!=""){
		alert(v);
		//判断浏览器是否属IE 
		if(navigator.userAgent.indexOf("MSIE") != -1){       
		     	window.dialogArguments.window.location = "<%=path%>/dict!find";
		}
		//判断浏览器是IE之外的其他浏览器  
		else{
		 	window.opener.location.reload();
		}
		window.close();
	}
});
</script>
</head>
<body>
<form name="form1" id="form1" action="dict!update" method="post">
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改字典</span></td>
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
					  
					    <td nowrap align="right" width="13%">所属系统:</td>
					    <td colspan="3">
					  	 <select name="sysint_sno" id="sysint_sid" style="width:154px" disabled="disabled">
						    	<option value="">公共类</option>
							    <s:iterator value="list" var="v">
									<option title="${v.sysint_sname}【${v.sysint_sno}】" value="${v.sysint_sno}" <s:if test="%{#v.sysint_sno==vo.sysint_sno}">selected</s:if>>${v.sysint_sname}【${v.sysint_sno}】</option>
								</s:iterator>
							</select>
						</td>
					    </tr>
					   <tr>
					    <td nowrap align="right" width="13%">字典ID:</td>
					    <td colspan="3">
						    <input name="form.dict_sno" id="dict_sno" value="${vo.dict_sno}"   class="text" style="width:154px;background: white;" maxlength="20" readonly="readonly"/></td>
					    </tr>
					  <tr>
					    <td nowrap align="right" width="13%">字典名称:</td>
					    <td colspan="3">
						    <input name="form.dict_sname" id="dict_sname" value="${vo.dict_sname}"   class="text" style="width:154px;background: white;" maxlength="50" valid="required" errmsg="字典名称不能为空!" readonly="readonly"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					   </tr>
					   <tr>
					    <td nowrap align="right" width="13%">字典类型:</td>
					    <td colspan="3"><select name="form.dict_ntype" id="dict_ntype" valid="required" errmsg="请选择字典类型!" disabled="disabled" style="background: white;">
						    	<option value="">请选择</option>
						    	<option value="0" <s:if test="%{vo.dict_ntype==\"0\"}">selected</s:if>>用户</option>
						    	<option value="1" <s:if test="%{vo.dict_ntype==\"1\"}">selected</s:if>>系统</option>
						    </select>
						    <input type="hidden" name="form.dict_ntype" value="${vo.dict_ntype}"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
					     </td>
					   </tr>
					   <tr>
					    </tr>
					   <tr>
					    <td nowrap align="right" width="13%">字典描述:</td>
					    <td colspan="3">
						    <input name="form.dict_sdesc" id="dict_sdesc" value="${vo.dict_sdesc}"   class="text" style="width:260px" maxlength="100" />
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
    <input type="hidden" name="form.dict_salterby" value="${session.userInfo.screenname}"/>
  </form>
  </body>
</html>

