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
function save(){

		if(validator()){
		if(confirm("是否保存？")){
			document.form1.action="<%=path%>/history!add";
			document.form1.submit();
			}
		}	
		
		 
}		

function toResut(){
    document.all.form1.reset();
}
  
</script>
</head>
<body>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">添加过程</span></td>
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
					    				<td nowrap align="right" width="45%">项目编号:</td>
					    				<td nowrap width="55%">
					    					<span style="white-space:nowrap;" >
					    					<input type="text" name="form.EP_SNO" id="EP_SNO" class="text" maxlength="20" style="width:60px" />
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					</span> 
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right" width="45%">包编号:</td>
					    				<td nowrap width="55%">
					    					<span style="white-space:nowrap;" >
					    					<input type="text" name="form.BG_SNO" id="BG_SNO" class="text" maxlength="20" style="width:60px" />
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					</span> 
					     				</td>
					    			</tr>
					 				<tr>
					    				<td nowrap align="right" width="45%">采购方式:</td>
					    				<td nowrap width="55%">
					    					<span style="white-space:nowrap;" >
					    					<select id="111" name="form.SS_SPURTYPE" valid="required" errmsg="采购方式不能为空!">
					    						<option value="">--请选择--</option>
					    						<option value="0">招标采购</option>
					    						<option value="1">集中采购</option>
					    						<option value="2">自行采购</option>
					    					</select>				    					
					    					
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					</span> 
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">流程序号:</td>
					    				<td nowrap>
                                            <input type="text" name="form.SET_NNO" id="setNno" class="text" maxlength="1" style="width:60px" valid="required|isNumber" errmsg="序号只能是数字！" onkeyup="value=value.replace(/[^\d]/g,'')"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>						    									    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">工作名称:</td>
					    				<td nowrap>
					    					<input type="text" name="form.SS_SNAME" id="SSSname" class="text" style="width:154px" maxlength="32"  valid="required" errmsg="工作名称不能为空！"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap align="right">工作日:</td>
					    				<td nowrap>
                                            <input type="text" name="form.SS_NWORK" id="SSNwork" class="text" style="width:60px" valid="required|isNumber" errmsg="序号只能是数字！" onkeyup="value=value.replace(/[^\d]/g,'')"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>						    									    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">操作页面:</td>
					    				<td nowrap>
					    					<input type="text" name="form.SS_SPAGE" id="SSSpage" class="text" style="width:154px" maxlength="64"  valid="required" errmsg="操作Page不能为空！"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>
						     		</tr>						     		
					    			<tr>
					    				<td nowrap align="right">操作人:</td>
					    				<td nowrap>
					    					<input type="text" name="form.SS_SMAN" id="SSSname" class="text" style="width:154px" maxlength="32"  valid="required" errmsg="工作名称不能为空！"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>
						     		</tr>
						     		<tr>
					    				<td nowrap align="right">操作时间:</td>
					    				<td nowrap>
					    					<input type="text" name="form.SS_TDATE" id="SSSname" class="text" style="width:154px" maxlength="32" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  valid="required" errmsg="工作名称不能为空！"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>
						     		</tr>
					    			<tr>
					    				<td nowrap align="right" width="13%">备注:</td>

					    					 <td colspan="6" align="left"><textarea name="form.SET_SREMARK" cols="70" rows="5"  valid="limit" max="250" errmsg="备注长度不能超过250字符!"></textarea></td>
					     				
					  				</tr>	
					  				<tr>				    			  
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
        					  <input type="button" value="返回" class="button" onclick="window.history.go(-1);"  />
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
 