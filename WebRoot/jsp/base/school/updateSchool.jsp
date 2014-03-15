<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path%>/css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=path%>/js/valid.js" type=text/javascript></script> 
<script type="text/javascript" src="<%=path%>/js/DatePicker/WdatePicker.js"></script>
<script> 

//var flag = true;
function update(){
	/*if (!flag) {
			$("#sh_sname").focus();
			alert("校区名称已存在，请重新输入！");
			return;
		} 
	if(validator(document.form1)){
		document.form1.action="<%=path%>/school!update";
//		document.form1.submit();
//	}
	*/
	
	if(validator(document.form1)){
			if(confirm("是否保存？")){
			document.form1.action="<%=path%>/school!update";
			document.form1.submit();
			}
		}	
	
}

function toReset(){
		  document.all.form1.reset();
}
		
$(function() {
$("#sh_sname").blur(function() {
			var sh_sname = $("#sh_sname").val();			
			if ($.trim(sh_sname) != ""&& $.trim(sh_sname) != "${vo.sh_sname}") {
			 $("#sh_ssname").val($("#sh_sname").val());
			}			
		});

	$("#td_sno").blur(function() {
	 	var td_sno = $("#td_sno").val();
		td_sno.toUpperCase();
		$("#td_sno").val(td_sno.toUpperCase());	
	});

});


</script>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="form.sh_sno" value="${vo.sh_sno}"/>
<div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>基础管理  &gt;校区信息</span></h2>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改校区信息</span></td>
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
					    				<td nowrap align="right" width="45%">校区名称:</td>
					    				<td >
					    					<span style="white-space:nowrap;" >
					    					<input name="form.sh_sname" id="sh_sname" value="${vo.sh_sname }" onblur=""
					    					url="<%=path%>/school!checkUnique" urlname="form.searchE" urlmsg="校区名称已存在！"   
					    					 class="text" style="width:154px" maxlength="50" valid="required" errmsg="校区名称不能为空!"/>
					    					<span id="sh_sname.info" style="color:red;">*</span>
					    					</span> 
					     				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">校区简称:</td>
					    				<td >
					    				<span style="white-space:nowrap;" >
					    					<input name="form.sh_ssname" id="sh_ssname" value="${vo.sh_ssname}" onblur="" class="text" style="width:154px" maxlength="25" valid="required" errmsg="校区简称不能为空!"/>
					    					<span style="color:red;">*</span>&nbsp;&nbsp; 
					    					</span>
					    				</td>
					    			</tr>
					    			
					  				<tr>
					    				<td nowrap align="right">校区类型:</td>
					    				<td >
					    					<span style="white-space:nowrap;" >
					    					<select id="sh_stype" name="form.sh_stype" valid="required" errmsg="校区类型不能为空!">
					    						<option value="">--请选择--</option>
					    						<option value="0" <c:if test="${vo.sh_stype==0 }">selected</c:if>>主校区</option>
					    						<option value="1" <c:if test="${vo.sh_stype==1 }">selected</c:if>>附校区</option>
					    					</select>
					    					<span style="color:red;">*</span>&nbsp;&nbsp;
					    					</span>
					     				</td>
					  				</tr>
					  				<tr>
					    				<td nowrap align="right">校区占地面积:</td>
					    				<td >
					    					<input type="text" name="form.sh_narea" value="${vo.sh_narea}" id="sh_narea" class="text" maxlength="10" style="width:154px" valid="isNumber" errmsg="校区占地面积只能是数字！" onkeyup="if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"/>
					    				㎡</td>
						     		</tr>
						     		<tr>
					    				<td nowrap align="right">校区地址:</td>
					    				<td >
					    				<span style="white-space:nowrap;" >
					    				<input type="text" name="form.sh_sadder" value="${vo.sh_sadder}" id="sh_sadder" class="text" maxlength="100" style="width:254px" valid="required" errmsg="校区地址不能为空!"/>
					    				<span style="color:red;">*</span>&nbsp;&nbsp; 
					    				</span>
					    				</td>
					  				</tr>
						     		<tr>
					    				<td nowrap align="right">是否可用:</td>
					    				<td>
					    					<input type="radio" name="form.sh_sisuse" id="sh_sisuse1" class="text" value="0" <c:if test="${vo.sh_sisuse==0 }">checked</c:if>/>可用
					    					<input type="radio" name="form.sh_sisuse" id="sh_sisuse2" class="text" value="1" <c:if test="${vo.sh_sisuse==1 }">checked</c:if>/>不可用
					     				</td>
					  				</tr>
					    			<tr>
					    				<td nowrap align="right" width="13%">土地编号:</td>
					    				<td>
					    					<input name="form.td_sno" id="td_sno" value="${vo.td_sno }" onblur="" class="text" style="width:154px" valid="limit" max="25" errmsg="土地编号长度不能超过25字符!"/>
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
        					  <input type="button" value="保存" class="button" onclick="update();"/>&nbsp;
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
    
 
<input type="hidden" name="us_sreplyby" value=""/>
<input type="hidden" name="form.searchE" id="searchE" value="${vo.sh_sname }" />
  </form>
  </body>
</html>

</form>
</body>
</html>