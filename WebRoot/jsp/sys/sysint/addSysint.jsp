<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>新增系统集成信息</title>
<script> 

		//保存修改
		function save(){
				 if(validator()){
					if(confirm("是否保存？")){
						document.form1.action="<%=path%>/sysint!add";
						document.form1.submit();
					}
				 }
		}
</script>
</head>
<body >
<form name="form1" method="post">
<div class="bigBox" >
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
                									<td width="94%" valign="bottom"><span class="STYLE1">新增系统集成信息</span></td>
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
					     				<td nowrap align="right" width="15%">系统名称:</td>
					    				<td nowrap width="35%">
					    					<input name="form.sysint_sname" id="sysint_sname" value="" onkeyup="document.getElementById('sysint_ssname').value=this.value;"  
					    					 url="<%=path%>/sysint!checkUnique" urlmsg="系统名称已存在！"   
					    					 maxlength="50" valid="required"   errmsg="系统名称不能为空!"/>
					    					<span  style="color:red;">*</span>
					    					<span  id="errMsg_sysint_sname" style="color:red;"></span>
					    				</td>
					    				<td nowrap align="right" width="15%" >系统简称:</td>
					    				<td nowrap width="35%">
					    					<input type="text" name="form.sysint_ssname" id="sysint_ssname"  
					    					 url="<%=path%>/sysint!checkUnique" urlmsg="系统简称已存在！"
					    					  maxlength="50" valid="required" errmsg="系统简称不能为空!"   />
					    					<span style="color:red;">*</span>
					    					<span id="errMsg_sysint_ssname" style="color:red;"></span>
					    				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">集成方式:</td>
					    				<td nowrap>
					    					<select id="sysint_susrtype" name="form.sysint_susrtype" valid="required" errMsg="集成方式不能为空"   >
					    						<option value=""></option>
					    						<option value="0">完全集成</option>
					    						<option value="1">用户信息集成</option>
					    						<option value="2">用户对照集成</option>
					    					</select>
					    					<span style="color:red;">*</span>
					    					<span id="errMsg_sysint_susrtype" style="color:red;"></span>
					    				</td>
					    				<td nowrap align="right">集成图标:</td>
					    				<td nowrap ><span id="sysint_img"></span>
					    				<input type="button" value="选择图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow('sysint_img','sysint_simg');"  >
					    				<input type="hidden" name="form.sysint_simg"  id="sysint_simg" value=""/>
					    				</td>
					  				</tr>
					    			<tr>
					    				
					    				<td nowrap align="right"  >系统访问地址:</td>
					    				<td nowrap>
					    					<input name="form.sysint_surl" id="sysint_surl" value=""   class="text"  maxlength="50"  />
					     					 
					     				</td>
					    				<td nowrap align="right">用户账号参数:</td>
					    				<td nowrap>
					    					<input name="form.sysint_susrpar" id="sysint_susrpar" value=""   class="text" maxlength="50"  />
					    					 
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				
					    				<td nowrap align="right">用户密码参数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.sysint_spwdpar" id="sysint_spwdpar" class="text"   maxlength="50"  />
					    					 
					    				</td>
					    				<td nowrap align="right">用户类别参数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.sysint_susrtypepar" id="sysint_susrtypepar" class="text"   maxlength="50"   />
					    					 
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
							<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    <input type="hidden" name="form.sysint_sreplyby" value="${session.userInfo.screenname}" id="sysint_sreplyby"/>
  </form>
  </body>
</html>

 
