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
/*	if(checkNO()){
		
	}*/
	if(validator()){
			//window.parent.document.location.href=;//刷新父页面
			document.form1.action="<%=path %>/jsp/sys/role/listRole.jsp";
			document.form1.submit();
		}
	
}

</script>
</head>
<body>
<form name="form1" method="post">
<div class="bigBox">
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
                									<td width="94%" valign="bottom"><span class="STYLE1">权限分配</span></td>
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
								
 			<tr valign="top">
    			<td  >
    				<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" class="tabletext">
                      <tr bgcolor="#B8D5F5" >
								<td width="5%" bordercolor="#94DCEB">
									<div align="center">
										<strong>序号</strong>
									</div>
								</td>
								<td width="5%" height="24" >
									<div align="center">
										<strong>用户id</strong>
									</div>
								</td>
								<td width="15%" height="24" >
									<div align="center">
										<strong>用户名</strong>
									</div>
								</td>
								<td width="15%" height="24" >
									<div align="center">
										<strong>角色ID</strong>
									</div>
								</td>
								<td width="15%" height="24" >
									<div align="center">
										<strong>角色名称</strong>
									</div>
								</td>
							</tr>
							<s:if test="list.size()==0">
							<tr align="center">
								<td colspan="5">该角色未被任何用户使用</td>
							</tr>
							</s:if>
						<s:else>	
							<s:iterator value="list" var="v" status="s">
							<tr bgcolor="#FFFFFF" style="font-size: 14px;" align="center">
								<td width="5%" >
									${s.index+1}
								</td>
								<td width="5%" height="24" >
									${v.userid}
								</td>
								<td width="15%" height="24">
									${v.screenname}
								</td>
								<td width="15%" height="24" >
									${v.role_sno}&nbsp;
								</td>
								<td width="15%" height="24" >
									${v.role_sname }&nbsp;
								</td>
							</tr>
							</s:iterator>
							</s:else>
							 </table></td>
</tr>
					    </table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					   
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
	