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
	 
		if(document.form1){
			document.form1.action="<%=path%>/splite!collectupdate?EP_SNO=<%=request.getParameter("EP_SNO")%>";
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
			<span><s:property value="#session.navbar"/></div></td>
        </tr>
        </table>
    </td>
    <!--<td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif">
    	<img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  --></tr>
  <tr>
	<td height="90%" valign="middle" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#353c44">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1"> 技术参数</span></td>
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
    				<table  width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table class="table1" border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 				<tr >
					    				<td nowrap align="right" width="45%" >明细预算内容（产品品目）:</td>
					    				<td colspan="3" >
					    					<span>${projectDetail.EPD_SNAME }</span>&nbsp;&nbsp; 					    					
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >单位:</td>
					    				<td colspan="3" >
					    					<span>${projectDetail.EPD_SUNIT }</span>&nbsp;&nbsp; 					    					
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >审定单价:</td>
					    				<td colspan="3" >
					    					<span>${projectDetail.EPD_NPRICE }</span>&nbsp;&nbsp; 					    					
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >审定数量:</td>
					    				<td colspan="3" >
					    					<span>${projectDetail.EPD_NNUM }</span>&nbsp;&nbsp; 					    					
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >审定总金额:</td>
					    				<td colspan="3" >
					    					<span>${projectDetail.EPD_NTOTAL }</span>&nbsp;&nbsp; 					    					
					     				</td>
					    			</tr>
					 				
					 				<tr >
					    				<td nowrap align="right" width="45%" >品牌:</td>
					    				<td colspan="3" >
					    					<input name="projectDetailForm.EPD_SBRAND" id="screenname" value="${projectDetail.EPD_SBRAND }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">型号:</td>
					    				<td colspan="3">
					    					<input name="projectDetailForm.EPD_SMODEL" id="screenname" value="${projectDetail.EPD_SMODEL }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">报价（单价）:</td>
					    				<td colspan="3" >
					    				<input name="projectDetailForm.EPD_NPRICESONG" id="screenname" value="${projectDetail.EPD_NPRICESONG }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					    				</td>
						     		</tr>
					  				
					  				<tr>
					    				<td nowrap align="right">报价（总金额）:</td>
					    				<td colspan="3" >
					    				<input name="projectDetailForm.EPD_NTOTALSONG" id="screenname" value="${projectDetail.EPD_NTOTALSONG }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					    				</td>
						     		</tr>
						     		<tr>
					    				<td nowrap align="right">备注:</td>
					    				<td colspan="3" >
					    					<input name="projectDetailForm.PL_SREMARK" id="screenname" value="${projectDetail.PL_SREMARK }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					    				</td>
						     		</tr>
					   			</table>
					   			<input name="projectDetailForm.EPD_NID" id="emp_sno" type="hidden" value="${projectDetail.EPD_NID }" style="width:154px" />
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td align="center">
							<input type="button" name="Submit" value="保存" class="button" onclick="save();"/>　
							<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <!--<tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
--></table>

</form>
</body>
</html>