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
			//window.parent.document.location.href=;//刷新父页面
			document.form1.action="role!add";
			document.form1.submit();
		}
}
// 
function stypeChange(){
	//alert("11");
	var v = $("#role_stype option:selected").val();
	if(v==0){//公共角色
		$("#dict_sname option").eq(0).attr("selected",true);
		$("#dict_sname").attr("disabled",true);
		$("#isdefault").attr("disabled",true);//公共角色不能做缺省值
	}else{
		$("#dict_sname").attr("disabled",false);
	}
}
//是否缺省
function sysintChange(obj){
	$.post("role!isDefault?checkedId="+obj.value,   
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
	$("form").attr("action","role!find");
	$("form").submit();
}
</script>
</head>
<body>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">新增角色</span></td>
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
						    <select name="form.role_stype" id="role_stype" onchange="stypeChange()" style="width:154px" valid="required" errmsg="角色类别不能为空!">
						    	<option value="">--请选择--</option>
						    	<option value="0">公共角色</option>
						    	<option value="1">系统角色</option>
						    </select>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						   <!-- <span style="color:red;"  id="errMsg_role_sname"></span>
					     --></td>
					    </tr>
					    
					    <tr>
					    <td nowrap align="right" width="13%">系统编号:</td>
					    <td colspan="3">
<!--						    <input name="form.sysint_sno" id="dict_sname" value=""   class="text" style="width:154px" maxlength="10" valid="required" errmsg="角色名称不能为空!"/>-->
						    <select name="form.sysint_sno" id="dict_sname" onchange="sysintChange(this)" style="width:154px" valid="required" errmsg="系统编号不能为空!">
						    	<option value="">--请选择--</option>
							    <s:iterator value="list" var="v">
									<option value="${v.sysint_sno}">${v.sysint_sname}-${v.sysint_sno}</option>
								</s:iterator>
							</select>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					    </td>
					    </tr>
					   
					    
					  <tr>
					    <td nowrap align="right" width="13%">角色名称:</td>
					    <td colspan="3">
						    <input name="form.role_sname" id="role_sname" value=""   class="text" style="width:154px" maxlength="10" 
						     url="<%=path%>/role!uniqueName"  urlmsg="角色名称已存在！" 
						    valid="required" errmsg="角色名称不能为空!"/>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style=""  id="errMsg_role_sname"></span>
					     </td>
					   </tr>
					   
					   <tr>
					    <td nowrap align="right" width="13%">是否缺省角色:</td>
					    <td colspan="3">
						    <select name="form.role_sisdefault" id="isdefault" style="width:154px" valid="required" errmsg="是否缺省角色不能为空!">
						    	<option value="">--请选择--</option>
						    	<option value="0">是</option>
						    	<option value="1">否</option>
						    </select>
						    <span style="color:red;">*</span>&nbsp;&nbsp; 
						    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					   </tr>
					   
					   <tr>
					    <td nowrap align="right" width="13%">角色描述:</td>
					    <td colspan="3">
						    <textarea rows="3"  style="width:100%;overflow-y:auto;"  name="form.role_sdesc" id="dict_sdesc" valid="limit"  max="100" errmsg="备注长度不能超过100字符!"></textarea>
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

				 