<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
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
<script> 
function toResut(){
    document.form1.reset();
}
function save(){
	if(validator(document.form1)){
		document.form1.action="<%=path %>/role!update";
		document.form1.submit();
		}
}
//角色类别改变
function stypeChange(){
	var v = $("#role_stype option:selected").val();
	//alert(v);
	if(v==0){
		$("#dict_sname option").eq(0).attr("selected",true);
		$("#isdefault").attr("disabled",true);//公共角色不能做缺省值
		$("#dict_sname").attr("disabled",true);
	}else{
		$("#dict_sname").attr("disabled",false);
	}
}
//是否缺省
function sysintChange(obj){
	$.post("<%=path %>/role!isDefault?checkedId="+obj.value,   
			function(data){
				if(!data){
					$("#isdefault").attr("disabled",true);
				}else{
					$("#isdefault").attr("disabled",false);
				}
			});
}


//  退后
function toBack(){
	$("form").attr("action","<%=path %>/role!find");
	$("form").submit();
}
</script>
</head>
<body onload="stypeChange();">
<form name="form1" method="post">
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改角色</span></td>
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
					    <td nowrap align="right" width="13%">角色类别:</td>
					    <td colspan="3">
					    	<select name="form.role_stype" id="role_stype" style="width:154px" onchange="stypeChange()">
<!--						    	<option value="">--请选择--</option>-->
						    	<option value="0" <s:if test="vo.role_stype==0">selected</s:if>>公共角色</option>
						    	<option value="1" <s:if test="vo.role_stype==1">selected</s:if>>系统角色</option>
						    </select>
						    <span style="color:red;">*</span>&nbsp;&nbsp;
					    </td>
					    </tr>
					   <tr>
					    <td nowrap align="right" width="13%">角色编码:</td>
					    <td colspan="3"><!-- valid="limit" max="250" errmsg="备注最多不能超过250字符！" -->
						    <input name="form.role_sno" id="sysint_sid" value="${vo.role_sno}"   class="text" style="width:154px" maxlength="10" readonly="readonly"/></td>
					    </tr>
					  <tr>
					    <td nowrap align="right" width="13%">角色名称:</td>
					    <td colspan="3">
						    <input name="form.role_sname"  value="${vo.role_sname}"   class="text" style="width:154px" maxlength="10"
						    url="<%=path%>/role!uniqueName" urlname="form.role_sno"  urlmsg="角色名称已存在！" 
						     valid="required" errmsg="字典名称不能为空!"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					    </tr>
					    <tr>
					    <td nowrap align="right" width="13%">系统编号:</td>
					    <td colspan="3">
						    <select name="form.sysint_sno" id="dict_sname" onchange="sysintChange(this)" style="width:154px">
						    	<option value="">--请选择--</option>
							    <s:iterator value="list" var="v">
									<option value="${v.sysint_sno}" <s:if test="vo.sysint_sno==#v.sysint_sno">selected</s:if>>${v.sysint_sname}-${v.sysint_sno}</option>
								</s:iterator>
							</select>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span id="errMsg_role_sname"  >(公共角色下，没有系统编码)</span>
					    </td>
					   </tr>
					   <tr>
					    <td nowrap align="right" width="13%">是否缺省角色:</td>
					    <td colspan="3">
						    <select name="form.role_sisdefault" id="isdefault" style="width:154px">
						    	<option value="0" <s:if test="vo.role_sisdefault==0">selected</s:if>>是</option>
						    	<option value="1" <s:if test="vo.role_sisdefault==1">selected</s:if>>否</option>
						    </select>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					    </tr>
					    <tr>
					    <td nowrap align="right" width="13%">角色描述:</td>
					    <td colspan="3">
					    	<textarea rows="3" style="width:100%;overflow-y:auto;" name="form.role_sdesc" id="dict_sdesc">${vo.role_sdesc}</textarea>
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
        					  <input type="button" value="返回" class="button" onclick="toBack();"  />
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
 