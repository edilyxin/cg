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
			document.form1.action="<%=path%>/declarep!saveEntranceP?EP_SNO=<%=request.getParameter("EP_SNO")%>";
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
                									<td width="94%" valign="bottom"><span class="STYLE1">填写/查看进口申报</span></td>
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
					    				<td nowrap align="right" width="45%" >申请单位:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.UD_SNO" id="screenname" value="${entrancep.UD_SNO }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >申请文件名称:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SNAME" id="screenname" value="${entrancep.ETP_SNAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >申请文号:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SREPORTNO" id="screenname" value="${entrancep.ETP_SREPORTNO }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >拟采购产品名称（采购项目名称）:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SPRONAME" id="screenname" value="${entrancep.ETP_SPRONAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >拟采购产品金额（采购项目金额）:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SPROMONEY" id="screenname" value="${entrancep.ETP_SPROMONEY }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
<!-- 					    			<tr > -->
<!-- 					    				<td nowrap align="right" width="45%" >采购项目所属项目名称:</td> -->
<!-- 					    				<td colspan="3" > -->
<%-- 					    					<input name="entrancepForm.screenname" id="screenname" value="${entrancep.xxx }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/> --%>
<%-- 					    					<span style="color:red;">*</span>&nbsp;&nbsp;  --%>
<%-- 					    					<span style="color:red;"  id="errMsg_us_sno"></span> --%>
<!-- 					     				</td> -->
<!-- 					    			</tr> -->
<!-- 					    			<tr > -->
<!-- 					    				<td nowrap align="right" width="45%" >采购项目所属项目金额:</td> -->
<!-- 					    				<td colspan="3" > -->
<%-- 					    					<input name="entrancepForm.screenname" id="screenname" value="${entrancep.xxx }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/> --%>
<%-- 					    					<span style="color:red;">*</span>&nbsp;&nbsp;  --%>
<%-- 					    					<span style="color:red;"  id="errMsg_us_sno"></span> --%>
<!-- 					     				</td> -->
<!-- 					    			</tr> -->
					    			<tr >
					    				<td nowrap align="right" width="45%" >项目使用单位:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SUNITNAME" id="screenname" value="${entrancep.ETP_SUNITNAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			<tr >
					    				<td nowrap align="right" width="45%" >项目组织单位:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_XINAME" id="screenname" value="${entrancep.ETP_XINAME }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" >采购人:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SSHOPPEOPLE " id="screenname" value="${entrancep.ETP_SSHOPPEOPLE }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" >负责人:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SRESPONSP" id="screenname" value="${entrancep.ETP_SRESPONSP }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" >联系人:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SLINKP" id="screenname" value="${entrancep.ETP_SLINKP }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					    			</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" >联系电话:</td>
					    				<td colspan="3" >
					    					<input name="entrancepForm.ETP_SLINKTEL" id="screenname" value="${entrancep.ETP_SLINKTEL }" onblur="" class="text" style="width:154px" maxlength="20" valid="required|isAccount" errmsg="账号不能为空!|账号只能以字母开头，以字母数字下划线组成，最小4位,"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					     				</td>
					    			</tr>
					  				<tr>
					    				<td nowrap align="right" valign="top" >申请理由:</td>
					    				<td colspan="3" >
					    					<textarea rows="10" cols="50" name="entrancepForm.ETP_SOTHER" valid="required|isPassword" errmsg="密码不能为空!|密码只能以字母数字下划线组成6至16位!">${entrancep.ETP_SOTHER }</textarea>
					    					
					    					<span style="color:red;">*</span> &nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_us_spwd"></span>
					    				</td>
						     		</tr>
					  				
					  				</tr>
					    				<tr >
					    				<td nowrap align="right" width="45%" valign="top" >专家论证意见:</td>
					    				<td colspan="3" >
					    				<ul>
					    				<li>1.该产品在中国境内无法获取
					    					<input id="sex1" type="radio" value="0" name="entrancepForm.ETP_SISGETSL"  <s:if test="%{entrancep.ETP_SISGETSL == \"0\"}">  checked </s:if>/>是 &nbsp;
    		   						    	<input id="sex2" type="radio" value="1" name="entrancepForm.ETP_SISGETSL"  <s:if test="%{entrancep.ETP_SISGETSL == \"1\"}">  checked </s:if>/>否
					    				</li>
					    				<li>2.该产品在中国境内无法以合理的商业条件获取
					    					<input id="sex1" type="radio" value="0" name="entrancepForm.ETP_SISGETBYREASONSL"  <s:if test="%{entrancep.ETP_SISGETBYREASONSL == \"0\"}">  checked </s:if>/>是 &nbsp;
    		   						    	<input id="sex2" type="radio" value="1" name="entrancepForm.ETP_SISGETBYREASONSL"  <s:if test="%{entrancep.ETP_SISGETBYREASONSL == \"1\"}">  checked </s:if>/>否
					    				</li>
					    				<li>3.其他意见
					    				<br/>
					    				<textarea name="entrancepForm.ETP_SEXPERT" rows="10" cols="50" valid="required|isPassword" errmsg="密码不能为空!|密码只能以字母数字下划线组成6至16位!">${entrancep.ETP_SEXPERT }</textarea>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_us_sno"></span>
					    				</li>
					    				</ul>
					    					
					     				</td>
					    			</tr>
					   			</table>
					   			<input name="entrancepForm.EP_SNO" id="emp_sno" type="hidden" value="<%=request.getParameter("EP_SNO")%>" style="width:154px" />
					   			<input name="entrancepForm.ETP_SNO" id="emp_sno" type="hidden" value="${entrancep.ETP_SNO }" style="width:154px" />
							</td>
      					</tr>
    				</table>
    				
    			</td>
  			</tr>
		</table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>

<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">论证专家表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
									
					</td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">	  	
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">专家姓名</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">专家单位</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">联系电话</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">身份证号</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">职称</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">职称证书编号</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">发证单位</span></div></th>      
      </tr>
     <s:iterator value="list"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" <s:if test="#li.field1==\"1\"">style="color:red;"</s:if>>
        <td height="20" ><div align="center">
         ${st.index+1}  
        </div></td>
        <td height="20" >${li.field1}</td>
        <td height="20" >${li.field1}</td>     
        <td height="20" >${li.field1}</td>
        <td height="20" >${li.field1}</td>         
       <td height="20"  >${li.field1}</td>     
       <td height="20"  >${li.field1}</td>     
       <td height="20"  >${li.field1}</td>     
      </tr>
      </s:iterator>
   </table>
			</div>
</div>

<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">明细</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
									
					</td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">	  	
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">明显预算内容</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定单价</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定数量</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定总金额</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否进口</span></div></th>    
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否免税</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">进口仪器设备免税申请表</span></div></th>           
      </tr>
     <s:iterator value="projectDetails"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" <s:if test="#li.field1==\"1\"">style="color:red;"</s:if>>
        <td height="20" ><div align="center">
         ${st.index+1}  
        </div></td>
        <td height="20" >${li.EPD_SNAMEXIAO}</td>
        <td height="20" >${li.EPD_SUNIT}</td>     
        <td height="20" >${li.EPD_NPRICE}</td>
        <td height="20" >${li.EPD_NNUM}</td>         
       <td height="20"  >${li.EPD_NTOTAL}</td>     
       <td height="20"  >${li.EPD_SISIMPORT}</td>     
       <td height="20"  >${li.EPD_SISFREETAX}</td>  
       <td height="20"  ><a href="<%=path%>/declarec!toAdd?ETP_SNO=${entrancep.ETP_SNO }&EPD_NID=${li.EPD_NID }&EP_SNO=<%=request.getParameter("EP_SNO")%>">打开设备免税申请表</a><br /></td>        
      </tr>
      </s:iterator>
   </table>
	</div>
	
	
</div>

	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td align="center">
							<input type="button" name="Submit" value="保存内容" class="button" onclick="save();"/>　
							<input type="button" name="Submit2" value="打印表单" class="button" onclick="window.print()"/>
						</td>
      				</tr>
    				</table>
</form>
</body>
</html>