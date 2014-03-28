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
			document.form1.action="<%=path%>/demo!add";
			document.form1.submit();
			}
		}	
		
		 
}		

function toResut(){
    document.all.form1.reset();
}

  //职称等级
  $(document).ready(function(){
 	getDictSelect("","post_nlevel","post_nlevel","","0","<%=path%>");
	}); 

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
                									<td width="94%" valign="bottom"><span class="STYLE1">添加职称</span></td>
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
					    				<td nowrap align="right" width="45%">职称名称:</td>
					    				<td nowrap width="55%">
					    					<input name="form.f1" id="f1" value="" 
					    					url="<%=path%>/demo!checkUnique"  urlmsg="职称名称已存在！"
					    					 onblur="" class="text" style="width:154px" maxlength="20" valid="required" errmsg="职称名称不能为空!"/>
					    					<span style="color:red;" id="error">*</span>&nbsp;&nbsp; 
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">职称等级:</td>
					    				<td nowrap>
                                            <select  name="form.f1" id="post_nlevel" valid="required" errmsg="职称等级不能为空!">
                                            <option value="">--请选择--</option>
                                            </select>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    				</td>						    									    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">住宅面积数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.post_nresarea" id="" class="text" style="width:154px" maxlength="10" onkeyup="value=value.replace(/[^\.\d]/g,'')"  valid="isMoney" errmsg="住宅面积数(平方米):以数字组成，小数点后最多6为!"/>
					    					<span >m²</span>
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap align="right">办公面积数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.post_noffarea" id="" class="text" style="width:154px" maxlength="10" onkeyup="value=value.replace(/[^\.\d]/g,'')"  valid="isMoney" errmsg="办公面积数(平方米):以数字组成，小数点后最多6为!" />
					    					<span >m²</span>
					    				</td>
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">房补金额数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.post_nhousmoney" id="" class="text" style="width:154px" maxlength="10" onkeyup="value=value.replace(/[^\.\d]/g,'')" valid="isMoney" errmsg="房补金额数(元/平方米):以数字组成，小数点后最多6为!" />
					    					<span >元/m²</span>
					     				</td>
					    
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">供暖补贴费:</td>
					    				<td nowrap>
					    					<input type="text" name="form.post_nheatmoney" id="" class="text" style="width:154px" maxlength="10" onkeyup="value=value.replace(/[^\.\d]/g,'')"  valid="isMoney" errmsg="供暖补贴费(元/平方米):以数字组成，小数点后最多6为!" />
					    					<span >元/m²</span>
					     				</td>
					     			</tr>						    
					  				<tr>
					  				   <td nowrap align="right">是否启用:</td>
					  				   <td nowrap>
					  				        <input type="radio" name="form.post_sisvalid" value="0" checked="checked"/>启用
					  				        <input type="radio" name="form.post_sisvalid" value="1" />不启用
					    					<span style="color:red;"  id="">*</span> &nbsp;&nbsp;
					    			   </td>
					    			</tr>   					  				
					    			<tr>
					    				<td nowrap align="right" width="13%">备注:</td>

					    					 <td colspan="6" align="left"><textarea name="form.post_sdef1" cols="70" rows="5"  valid="limit" max="250" errmsg="备注长度不能超过250字符!"></textarea></td>
					     				
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
 