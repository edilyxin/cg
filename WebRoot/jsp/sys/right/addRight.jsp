<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>功能管理-新增</title>
<script type="text/javascript">
function toReset(){
    document.forms[0].reset();
}
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
		
		$("#right_ndef1").change(function() {
			if ($(this).val() > 1) {
				$("#right_sparentno").attr("valid", "required");
				$("#right_sparentno").attr("errmsg", "请选择上级功能");
				$("#right_sparentno").append('<span style="color:red;" id="msg">*</span>');
				$.post(
					"<%=path %>/right!findSparent",
					{"form.right_ndef1":$(this).val(), "form.sysint_sno":$("#sysint_sno").val()},
					function(data) {
						$("#right_sparentno").empty();
						$("#right_sparentno").append("<option value=''>--请选择--</option>");
						for (var i = 0; i < data.length; i++) {
							var right = data[i];
							$("#right_sparentno").append("<option value='" + right.right_sno + "'>" + right.right_sname + "</option>");
						}
					},"json"
				);
			} else {
				$("#right_sparentno").empty();
				$("#right_sparentno").append("<option value='0' selected>--请选择--</option");
				$("#right_sparentno").removeAttr("valid");
				$("#right_sparentno").removeAttr("errmsg");
				$("#msg").remove();
			}
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
function toSave() {
	if (validator()) {
		if (confirm("是否保存")) {
			document.forms[0].action="<%=path %>/right!add";
			document.forms[0].submit();
		}
	}
}

function toBack() {
	document.forms[0].action="<%=path %>/right!find";
	document.forms[0].submit();
}

function findRightNum() {
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
                									<td width="94%" valign="bottom"><span class="STYLE1">新增功能</span></td>
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
					    				<td nowrap style="text-align: left">
					    				<input type="hidden" name="form.sysint_sno" id="sysint_sno" />
					    				  <input type="text" name="form.sysint_sname" id="sysint_sname" valid="required" errmsg="请选择系统！" readonly  />
					    				  <input type="button" class="select_button" onclick="sysintTree('sysint_sno', 'sysint_sname');findRightNum();validator();"/><span style="color:red;">*</span>
                                        </td>
					    				<td   nowrap style="text-align: right">&nbsp;</td>
					    				<td   nowrap style="text-align: left">&nbsp;</td>
					    			</tr>
					    			<tr>
					    			<td nowrap style="text-align: right" >功能名称：</td>
					    				<td nowrap style="text-align: left"  >
					    				<input name="form.right_sname" id="right_sname" value="" maxlength="25" urlmsg="功能名称已存在！" url="<%=path %>/right!checkUnique" urlname="form.sysint_sno|form.right_sparentno" valid="required" errmsg="请输入功能名称！"/>
                                        <span style="color:red;">*</span>&nbsp;&nbsp;</td>
					    				<td nowrap style="text-align: right" >功能级别：</td>
					    				<td nowrap style="text-align: left"  ><select name="form.right_ndef1" id="right_ndef1" valid="required" errmsg="请选择功能级别！">
					    				  <option value="">--请选择--</option>
					    				  </select>
                                        <span style="color:red;">*</span></td>
                                        
					    
					  				</tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >菜单/功能：</td>
					    				<td nowrap style="text-align: left"  ><input name="form.right_nmorb" type="radio" class="right_nmorb" value="0" checked="checked" />
											菜单
											  <input type="radio" name="form.right_nmorb" class="right_nmorb" value="1" />
											功能</td>
										<td nowrap style="text-align: right" >上级功能：</td>
					    				<td nowrap style="text-align: left"  ><select name="form.right_sparentno" id="right_sparentno" >
					    				  <option value="">--请选择--</option>
				    				    </select>
					    				</td>
						     		</tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >功能地址：</td>
			    				    	<td nowrap style="text-align: left"  >
			    				    		<input name="form.right_smenuurl" id="right_smenuurl" value="" class="text" style="width:154px" maxlength="150" />
			    				    	</td>
					    				<td nowrap style="text-align: right" >是否末级：</td>
					    				<td nowrap style="text-align: left"  >
					    					<input name="form.right_sisend" type="radio" class="right_sisend" value="0" checked="checked" />是
  											<input type="radio" name="form.right_sisend" class="right_sisend" value="1" />不是
  										</td>
					  				</tr>
					  				<tr>
					  				  <td nowrap style="text-align: right" >弹出位置：</td>
					  				  <td nowrap style="text-align: left" >
					  				    <input type="radio" name="form.right_sposition" value="main" checked>主窗口
					  				    <input type="radio" name="form.right_sposition" value="leftFrame">左边窗口
                                      </td>
					  				  <td nowrap style="text-align: right" >图标地址：</td>
				  				    <td nowrap style="text-align: left" ><span id="addr"></span>
					  				    <input type="button" value="选择图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow('addr','right_simg');"  >
						    			<input type="hidden" name="form.right_simg"  id="right_simg" value=""/>
					  				</td>
				  				  </tr>
					  				<tr>
					  				  <td nowrap style="text-align: right" >是否可用：</td>
					  				  <td nowrap style="text-align: left"  ><input name="form.right_sisuse" type="radio"   value="0" checked="checked" />可用
					  				  <input type="radio" name="form.right_sisuse"   value="1" />不可用</td>
					  				  <td nowrap style="text-align: right" >&nbsp;</td>
					  				  <td nowrap style="text-align: left"  >&nbsp;</td>
				  				  </tr>
					  				<tr>
					    				<td nowrap style="text-align: right" >功能描述：</td>
				    				  <td  colspan="3" nowrap style="text-align: left" ><textarea id="right_sdesc" name="form.right_sdesc" rows="4" cols="70" valid="limit" max="500" errmsg="功能描述长度不能超过500字符!" style="width:100%;overflow-y:auto;resize:none;"></textarea></td>
				     				</tr>
					   			</table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="toSave();"/>&nbsp;
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
