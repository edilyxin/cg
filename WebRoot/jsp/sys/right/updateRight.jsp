<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>功能管理-修改</title>
<script type="text/javascript">
	$(function() {
		if ($(".right_nmorb:checked").val() == 0) {
			$("#right_smenuurl").val("");
			$("#right_smenuurl").attr({readonly:"readonly", style:"background:#EEE; width:154px"});
			$(".right_sisend[value='1']").attr("checked", "true");
		} else {
			$("#right_smenuurl").removeAttr("readonly");
			$("#right_smenuurl").attr("style", "width:154px");
			$(".right_sisend[value='0']").attr("checked", "true");
		}
		
		if ($(".right_sisend:checked").val() == 0) {
			$(".right_nmorb[value='1']").attr("checked", "true");
			$("#right_smenuurl").removeAttr("readonly");
			$("#right_smenuurl").attr("style", "width:154px");
		} else {
			$(".right_nmorb[value='0']").attr("checked", "true");
			$("#right_smenuurl").val("");
			$("#right_smenuurl").attr({readonly:"readonly", style:"background:#EEE; width:154px"});
		}
		
		$("#sysint_sname").next("img").click(function() {
			$.post("<%=path%>/right!findRightNum",
					{"form.sysint_sno":$("#sysint_sno").val()},
					function(data){
						$("#right_ndef1").empty();
						$("#right_ndef1").append("<option value=''>--请选择--</option>");
						var count = 0;
						for (var i = 0; i < data.length; i++) {
							if (data[i] == null) {
								count++;
							} else {
								$("#right_ndef1").append("<option value='" + data[i] + "'>" + data[i] + "</option>");
							}
							
						}
						$("#right_ndef1").append("<option value='" + (data.length - count + 1) + "'>" + (data.length - count + 1) + "</option>");
					},"json");
		});
		
		$(".right_nmorb").click(function(){
			if ($(".right_nmorb:checked").val() == 0) {
				$("#right_smenuurl").val("");
				$("#right_smenuurl").attr({readonly:"readonly", style:"background:#EEE; width:154px"});
				$(".right_sisend[value='1']").attr("checked", "true");
			} else {
				$("#right_smenuurl").removeAttr("readonly");
				$("#right_smenuurl").attr("style", "width:154px");
				$(".right_sisend[value='0']").attr("checked", "true");
			}
		});
		$(".right_sisend").click(function() {
			if ($(".right_sisend:checked").val() == 0) {
				$(".right_nmorb[value='1']").attr("checked", "true");
				$("#right_smenuurl").removeAttr("readonly");
				$("#right_smenuurl").attr("style", "width:154px");
			} else {
				$(".right_nmorb[value='0']").attr("checked", "true");
				$("#right_smenuurl").val("");
				$("#right_smenuurl").attr({readonly:"readonly", style:"background:#EEE; width:154px"});
			}
		});
	});
</script>
<script type="text/javascript">
addAttr=function(id, url, urlname, originalVal) {
	var val = $("#" + id).val();
	if ($.trim(val) == originalVal) {
		$("#" + id).removeAttr("url");
		$("#" + id).removeAttr("urlname");
	} else {
		$("#" + id).attr({url: url, urlname: urlname});
	}
};
$(function(){
	$("#right_sname").blur(function(){
		addAttr("right_sname", "<%=path %>/right!checkUnique", "form.sysint_sno|form.right_sparentno", "${vo.right_sname}");
	});
});
function toSave() {
	addAttr("right_sname", "<%=path %>/right!checkUnique", "form.sysint_sno|form.right_sparentno", "${vo.right_sname}");
	if (validator()) {
		if (confirm("是否保存")) {
			document.forms[0].action="<%=path %>/right!update";
			document.forms[0].submit();
		}
	}
}

function toBack() {
	document.forms[0].action="<%=path %>/right!find";
	document.forms[0].submit();
}
</script>
</head>
 
<body>
<form name="form1" method="post" >
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改功能</span></td>
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
					    				<td nowrap style="text-align: right">系统名称：</td>
					    				<td nowrap style="text-align: left">${vo.sysint_sname}
					    				  <input type="hidden" name="form.sysint_sname" id="sysint_sname" value="${vo.sysint_sname}"  />
					    				  <input type="hidden" name="form.sysint_sno" id="sysint_sno" value="${vo.sysint_sno}"  />
                                        </td>
					    				<td    nowrap style="text-align: right">功能编号：</td>
					    				<td   nowrap style="text-align: left">${vo.right_sno}
					    				<input type="hidden" name="form.right_sno" value="${vo.right_sno}"/></td>
					    			</tr>
					    			<tr>
					    				<td nowrap style="text-align: right" >功能名称：</td>
					    				<td nowrap style="text-align: left"  >
					    				<input name="form.right_sname" id="right_sname" style="width:154px" value="${vo.right_sname}" maxlength="25" urlmsg="功能名称已存在！" valid="required" errmsg="请输入功能名称！"/>
					    				
                                        <span style="color:red;">*</span></td>
					    				<td nowrap style="text-align: right" >功能级别：</td>
					    				<td nowrap style="text-align: left" >${vo.right_ndef1}
					    				<input type="hidden" name="form.right_ndef1" value="${vo.right_ndef1}"/>
                                        </td>
                                        
					    
					  				</tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >菜单/功能：</td>
					    				<td nowrap style="text-align: left"  ><input name="form.right_nmorb" type="radio" class="right_nmorb" value="0" <s:if test="vo.right_nmorb == \"0\"">checked</s:if>/>
											菜单
											  <input type="radio" name="form.right_nmorb" class="right_nmorb" value="1" <s:if test="vo.right_nmorb == \"1\"">checked</s:if>/>
											功能</td>
										<td nowrap style="text-align: right">上级功能：</td>
					    				<td nowrap style="text-align: left">${vo.right_sparentname}
					    				<input type="hidden" name="form.right_sparentno" value="${vo.right_sparentno}"/>
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >功能地址：</td>
			    				    	<td nowrap style="text-align: left"  ><input   name="form.right_smenuurl" id="right_smenuurl" value="${vo.right_smenuurl}"  style="width:154px" maxlength="150" /></td>
					    				<td nowrap style="text-align: right" >是否末级：</td>
					    				<td nowrap style="text-align: left" >
					    				<input name="form.right_sisend" type="radio" class="right_sisend" value="0" <s:if test="vo.right_sisend == \"0\"">checked</s:if> />是
  										<input type="radio" name="form.right_sisend" class="right_sisend" value="1" <s:if test="vo.right_sisend == \"1\"">checked</s:if>/>不是</td>
					  				</tr>
					  				<tr>
					  				  <td nowrap style="text-align: right" >弹出位置：</td>
					  				  <td nowrap style="text-align: left" >
					  				    <input type="radio" name="form.right_sposition" value="main" <s:if test="vo.right_sposition == \"main\"">checked</s:if>>主窗口
					  				    <input type="radio" name="form.right_sposition" value="leftFrame" <s:if test="vo.right_sposition == \"leftFrame\"">checked</s:if>>左边窗口
                                      </td>
					  				  <td nowrap style="text-align: right" >图标地址：</td>
				  				    <td nowrap style="text-align: left" >
				  				    	<span id="addr">
					  				    	<s:if test="vo.right_simg != null">
					  				    	<img alt="${vo.right_simg}" src="<%=path%>/${vo.right_simg}" border="0" style="border:1px #666666 solid;" width="20" height="20" align="middle"/>&nbsp;
					  				    	</s:if>
				  				    	</span>
					  				    <input type="button" value="选择图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow('addr','right_simg');"  >
						    			<input type="hidden" name="form.right_simg"  id="right_simg" value="${vo.right_simg}"/>
					  			</td>
				  				  </tr>
					  				<tr>
					  				  <td nowrap style="text-align: right" >是否可用：</td>
					  				  <td nowrap style="text-align: left" >
					  				  <input name="form.right_sisvalid" type="radio" class="right_sisuse" value="0" <s:if test="vo.right_sisuse == \"0\"">checked</s:if>/>可用
					  				  
  										<input type="radio" name="form.right_sisvalid" class="right_sisuse" value="1" <s:if test="vo.right_sisuse == \"1\"">checked</s:if>/>不可用</td>
					  				  <td nowrap style="text-align: right" >&nbsp;</td>
					  				  <td nowrap style="text-align: left"  >&nbsp;</td>
				  				  </tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >功能描述：</td>
				    				  <td  colspan="3" nowrap style="text-align: left" ><textarea id="right_sdesc" name="form.right_sdesc" rows="4"   valid="limit" max="500" errmsg="功能描述长度不能超过500字符!" style="width:100%;overflow-y:auto;resize:none;">${vo.right_sdesc}</textarea></td>
				     				</tr>
					   			</table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td    nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="toSave();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="toBack();" id="back"/>
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
