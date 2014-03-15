<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base target="_self"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <script type="text/javascript">
  	function find() {
		document.forms[0].action = "<%=path%>/rightOper!find";
		document.forms[0].submit();
	}
	function toResut(){
    	document.all.form1.reset();
	}
	
/**
 * 数据字典下拉框
 * @param value 字典项值
 * @param tagName 标签ID
 * @param name 字典名
 * @param sysint_sno 所属系统	所属系统（为空时默认为公共系统）
 * @param dictType 字典类型 0.系统字典 1.用户字典
 * @param path 工程路径
 */

	
	  $(document).ready(function(){
 		getDictSelect("${vo.oper_stype}","oper_stype","oper_stype","","","<%=path %>");
	}); 
 
 function save(){ 
   	if(validator(document.form1)){
			document.form1.action="<%=path%>/rightOper!update";
			document.form1.submit();
	}  
	
}
</script>

  </head>
  
  <body>
<form name="form1" method="post">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>操作信息</span></h2>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改操作信息</span></td>
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
					    					<td nowrap align="right" width="15%">所属系统:</td>
										    <td width="35%">
						   						<input type="text" name="form.sysint_sname" value="${form.sysint_sname}" readonly style="background:#EEE"/>
											<input type="hidden" name="form.sysint_sno" id="sysint_sno" value="${form.sysint_sno}"/>
										    </td>
										    <td nowrap align="right" width="15%">所属功能:</td>
										    <td width="35%">
										   		<input type="text" id="right_sname" name="form.right_sname" value="${form.right_sname}" readonly style="background:#EEE"/>
                 					`			<input type="hidden" name="form.right_sno" id="right_sno" value="${form.right_sno}"/> 
										    </td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right" >操作编号:</td>
					    				<td colspan="3"><input name="form.oper_sno" id="oper_sno" value="${vo.oper_sno}"     maxlength="10"   readonly/>
					     				</td>
					    			</tr>
					     			<tr>
					    				<td nowrap align="right">操作名称:</td>
					    				<td ><input name="form.oper_sname" id="oper_sname" value="${vo.oper_sname}"   
						url="<%=path%>/rightOper!checkUnique" urlname="form.right_sno|form.sysint_sno|form.searchE" urlmsg="操作名称已存在！"   
					    					 maxlength="50" valid="required"   errmsg="操作名称不能为空!"/>
					    					<span style="color:red;">*</span>
					    					<span style="color:red;white-space:nowrap;"  id="errMsg_oper_sname"></span>
					     				</td>
					     				<td nowrap align="right"  >图标地址:</td>
					    				<td>
					    					<span id="oper_img">
						    				<s:if test="vo.oper_simg!=null">
						    				<img alt="集成图标"  src="<%=path %>/${vo.oper_simg}" style="border:1px #666666 solid;" width="20" height="20"  align="middle">&nbsp;</s:if></span>
						    				<input type="button" value="操作图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow('oper_img','oper_simg');"  >
						    				<input type="hidden" name="form.oper_simg"  id="oper_simg" value="${vo.oper_simg}"/>
					      				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">是否按钮:</td>
					    				<td>
					    					<input type="radio" name="form.oper_nmorb" id="oper_nmorb" value="0" <s:if test="vo.oper_nmorb == \"0\"">checked</s:if>/>是
					    					<input type="radio" name="form.oper_nmorb" id="oper_nmorb" value="1" <s:if test="vo.oper_nmorb == \"1\"">checked</s:if>/>不是
					    					 
					     				</td>
					     				<td nowrap align="right"  >操作类型:</td>
					    				<td >
							 				<select name="form.oper_stype" id="oper_stype" valid="required" errmsg="操作类型不能为空!" >
												<option value="" >--请选择--</option>
							 				</select>
											<span style="color:red;">*</span> 
							 			</td>
					    			</tr>
					    			<tr>
					     				<td nowrap align="right">是否可用:</td>
					    				<td>
					    					<input type="radio" name="form.oper_sisuse" id="oper_sisuse" value="0" <s:if test="vo.oper_sisuse == \"0\"">checked</s:if>/>可用
					    					<input type="radio" name="form.oper_sisuse" id="oper_sisuse" value="1" <s:if test="vo.oper_sisuse == \"1\"">checked</s:if>/>不可用
					    					 
					     				</td>
					       				<td nowrap align="right">是否有效:</td>
					    				<td>
					    					<input type="radio" name="form.oper_sisvalid" id="oper_sisvalid" value="0" <s:if test="vo.oper_sisvalid== \"0\"">checked</s:if>/>有效
					    					<input type="radio" name="form.oper_sisvalid" id="oper_sisvalid" value="1" <s:if test="vo.oper_sisvalid== \"1\"">checked</s:if>/>无效
					    				</td>
					     			</tr>
					       			<tr>
                						<td align="right" nowrap>描述：</td>
                						<td colspan="3" align="left" nowrap>
                  							<textarea id="oper_sdesc" name="form.oper_sdesc"  style="width:100%;overflow-y:auto;" rows="4"  valid="limit" max="250" errmsg="描述长度不能超过250个字符!">${vo.oper_sdesc}</textarea>
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
        					  <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>&nbsp;
							<input type="button" name="Submit3" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
							<input type="button" name="Submit2" value="返回" class="button" onclick="find();"/>
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
   <input type="hidden" name="form.oper_salterby" id="oper_salterby" value="${session.userInfo.screenname}"/>
<input name="form.searchE" id="searchE" value="${vo.oper_sno}" type="hidden"/>
  </form>
  </body>
</html>

 