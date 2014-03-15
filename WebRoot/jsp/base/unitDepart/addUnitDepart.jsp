<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setContentType("text/html; charset=UTF-8");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位部门信息-新增</title>
<script type="text/javascript" src="<%=path%>/js/JS_Pinyin.js"></script>
<script type="text/javascript">
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
 	getDictSelect("","ud_nnumber","ud_nnumber","","1","<%=path %>");
 	getDictSelect("","ud_stype","ud_stype","","1","<%=path %>");
 	getDictSelect("","ud_smunidep","ud_smunidep","","1","<%=path %>");
 	//如果有1个学校，那么清除单位层次下拉的学校层次
 	$.post("<%=path %>/unitDepart!canAddSchool",
 			function(data) {
 				if (data) {
 					$("#ud_nnumber").children("option[value='1']").remove();
 				}
 			},"json"
 			);
	});
	
	$(function() {
		$("#ud_nnumber").change(function() {
			if ($(this).val() == 1) {
				$("#ud_smunidep").val("1");
				$("#ud_stopno").empty();
				$("#ud_stopno").append("<option value='' selected>--请选择--</option>");
				$("#row").show();
				//单位层次等于1时，隶属单位不必选
				$("#ud_stopno").removeAttr("valid");
				$("#ud_stopno").removeAttr("errmsg");
				$("#row").removeAttr("style");
				$("#ud_stype").val("1");
			} else if ($(this).val() > 1){
				$("#row").hide();
				//单位层次大于1时，隶属单位必须选
				$("#ud_stopno").attr({valid:"required", errmsg: "请选择隶属单位！"});
				$("#ud_stype").val("");
				$.post("<%=path %>/unitDepart!findTopList",
						{"form.ud_nnumber":$(this).val()},
						function(data) {
							$("#ud_stopno").empty();
							$("#ud_stopno").append("<option value='' selected>--请选择--</option>");
							for (var i = 0; i < data.length; i++) {
								var ud = data[i];
								$("#ud_stopno").append("<option value='" + ud.ud_sno + "' num='" + ud.ud_nnumber + "' numname='" + ud.ditem_sname + "'>" + ud.ud_sname + "</option>");
							}
						}, "json");
			} else if ($(this).val() == "") {
				$("#row").hide();
				$("#ud_stopno").empty();
				$("#ud_stopno").append("<option value='' selected></option>");
			}
		});
		
		$("#ud_stopno").change(function() {
			if ($(this).val() == "") {
				$("#ud_stop").empty();
				$("#ud_stop").append("<option value='' selected></option>");
				return;
			}			
			var ud_nnumber = $("#ud_stopno option:selected").attr("num");			
			var numname = $("#ud_stopno option:selected").attr("numname");
			//从服务器返回的json串中会用"null"代表空值
			if (numname != "null") {
				$("#ud_stop").empty();
				$("#ud_stop").append("<option value='" + ud_nnumber + "'>" + numname + "</option>");
			} else {
				$("#ud_stop").empty();
				$("#ud_stop").append("<option value='" + ud_nnumber + "'></option>");
			}
		});
	});
</script>
<script type="text/javascript">
$(function() {
	$("#ud_sname").keyup(function(){
		$("#ud_ssname").val($("#ud_sname").val());
		$("#ud_sbriefcode").val(YZCPY2($("#ud_sname").val()));
	});
});

function toSave() {
	if (validator()) {
		if (confirm("是否保存")) {
			document.forms[0].action="<%=path %>/unitDepart!add";
			document.forms[0].submit();
		}
	}
}

function toBack() {
	document.forms[0].action="<%=path %>/unitDepart!find";
	document.forms[0].submit();
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
                									<td width="94%" valign="bottom"><span class="STYLE1">添加单位部门</span></td>
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
                <td width="13%" nowrap style="text-align: right">单位层次：</td>
                <td width="29%" nowrap style="text-align: left"><select name="form.ud_nnumber" id="ud_nnumber" valid="required" errmsg="请选择单位层次！">
                  <option value=""></option>
                </select><span style="color:red;">*</span></td>
                <td nowrap width="13%" style="text-align: right">&nbsp;</td>
                <td nowrap width="45%" style="text-align: left" >&nbsp;</td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">隶属单位：  </td>
                <td nowrap style="text-align: left"><select name="form.ud_stopno" id="ud_stopno">
                  <option value="">--请选择--</option>
                </select></td>
                <td nowrap style="text-align: right">隶属层次：</td>
                <td nowrap style="text-align: left" ><select name="form.ud_stop" id="ud_stop">
                  <option value=""></option>
                </select></td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">单位名称：</td>
                <td nowrap style="text-align: left"><input name="form.ud_sname" id="ud_sname" value="" style="width:154px" maxlength="50" valid="required" errmsg="请输入单位名称！" url="<%=path %>/unitDepart!checkUnique" urlname="form.ud_stopno" urlmsg="单位名称已存在！" /><span id="ud_sname.info" style="color:red;">*</span></td>
                <td nowrap style="text-align: right">单位简称：</td>
                <td nowrap style="text-align: left" ><input name="form.ud_ssname" id="ud_ssname" value="" style="width:154px" maxlength="50" valid="required" errmsg="请输入单位简称！"/><span style="color:red;">*</span>&nbsp;&nbsp; </td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">单位类型：</td>
                <td nowrap style="text-align: left"><select name="form.ud_stype" id="ud_stype">
                  <option value="" selected></option>
                </select></td>
                <td nowrap style="text-align: right">简码：</td>
                <td nowrap style="text-align: left" ><input name="form.ud_sbriefcode" type="text" id="ud_sbriefcode" style="width:154px" value="" maxlength="50" /></td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">负责人：</td>
                <td nowrap style="text-align: left">
                <input type="text" name="form.ud_swheelman" id="emp_sname" value="" style="width:154px;" readonly/>
                <input type="button" class="select_button" onclick="empTree('emp_sno','emp_sname');" />
     			<input type="hidden" name="emp_sno" id="emp_sno" value="" />
                </td>
                <td nowrap style="text-align: right">联系人：</td>
                <td nowrap style="text-align: left" >
                <input type="text" name="form.ud_slinkman" id="emp_sname1" value="" style="width:154px;" readonly/>
                <input type="button" class="select_button" onclick="empTree('emp_sno1','emp_sname1');" />
     			<input type="hidden" name="emp_sno" id="emp_sno1" value="" />
                </td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">教职工人数：</td>
                <td nowrap style="text-align: left"><input name="form.ud_smannum" type="text" id="ud_smannum" style="width:154px" value="" maxlength="50" valid="isNum" errmsg="教职工人数只能为正整数！"/></td>
                <td nowrap style="text-align: right">电话：</td>
                <td nowrap style="text-align: left" ><input name="form.ud_stele" type="text" id="ud_stele" style="width:154px" value="" maxlength="50" valid="isPhone" errmsg="电话号码格式不正确，格式为010-6615438！"/></td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">是否归口单位：</td>
                <td nowrap style="text-align: left"><input name="form.ud_sdef5" type="radio" value="1">
                  是
  <input type="radio" name="form.ud_sdef5" value="0" checked>
                  否</td>
                <td nowrap style="text-align: right">是否启用：</td>
                <td nowrap style="text-align: left" ><input name="form.ud_sisvalid" type="radio" value="0" checked>
                  启用
                  <input type="radio" name="form.ud_sisvalid" value="1">
                  不启用</td>
              </tr>
              <tr>
                <td nowrap style="text-align: right">地址：</td>
                <td colspan="3" nowrap style="text-align: left"><input name="form.ud_saddr" type="text" id="ud_saddr" value="" maxlength="250" style="width:65%" />
                  </td>
              </tr>
                <tr>
                <td nowrap style="text-align: right">备注： </td>
                <td colspan="3" nowrap style="text-align: left"><textarea id="ud_ssynchro" name="form.ud_ssynchro" rows="4" cols="70" valid="limit" max="250" errmsg="备注长度不能超过250字符!" style="width:100%;overflow-y:auto;resize:none;"></textarea></td>
              </tr>
              </table>
              </td>
              </tr>
              <tr id="row" style="display:none">
              	<td colspan="4">
              		<table width="100%" cellspacing="0" cellpadding="0" style="font-size:12px; font-family: Verdana, Arial, Helvetica, sans-serif;">
		              <tr>
		                <td width="13%" nowrap style="text-align: right">隶属市级部门：</td>
		                <td width="29%" nowrap style="text-align: left"><select name="form.ud_smunidep" id="ud_smunidep">
		                  <option value=""></option>
		                </select></td>
		                <td width="13%" nowrap style="text-align: right">在校生人数：</td>
		                <td width="45%" nowrap style="text-align: left" ><input name="form.ud_sschoolnum" maxlength="50"  type="text" id="ud_sschoolnum" valid="isNum" errmsg="在校生人数只能为正整数！" style="width:154px" value="" maxlength="90" /></td>
		              </tr>
		              <tr>
		                <td nowrap style="text-align: right">原单位名称：</td>
		                <td nowrap style="text-align: left"><input name="form.ud_soldname" id="ud_soldname" value="" style="width:154px" maxlength="50" /></td>
		                <td nowrap style="text-align: right">资质等级：</td>
		                <td nowrap style="text-align: left" ><input name="form.ud_saptitude" id="ud_saptitude" style="width:154px" value="" maxlength="50"/></td>
		              </tr>
		              <tr>
		                <td nowrap style="text-align: right">资产规模：</td>
		                <td nowrap style="text-align: left"><input name="form.ud_sassetsize" type="text" id="ud_sassetsize" style="width:154px" value="" maxlength="50" /></td>
		                <td nowrap style="text-align: right">银行账号：</td>
		                <td nowrap style="text-align: left" ><input name="form.ud_sbank" type="text" id="ud_sbank" style="width:154px" value="" valid="isNum" errmsg="银行账号格式不正确！" maxlength="50" /></td>
		              </tr>
		              <tr>
		                <td nowrap style="text-align: right">财务收支：</td>
		                <td nowrap style="text-align: left"><input name="form.ud_sfinance" type="text" id="ud_sfinance" style="width:154px" value="" maxlength="50" /></td>
		                <td nowrap style="text-align: right">单位邮政编码：</td>
		                <td nowrap style="text-align: left" ><input name="form.ud_spostcode" type="text" id="ud_spostcode" style="width:154px" value="" valid="isNum" errmsg="邮政编码格式不正确！" maxlength="50" /></td>
		              </tr>
		              <tr>
		                <td nowrap style="text-align: right">单位邮箱：</td>
		                <td nowrap style="text-align: left"><input name="form.ud_smail" type="text" id="ud_smail" style="width:154px" value="" valid="isEmail" errmsg="邮箱格式不正确！" maxlength="50" /></td>
		                <td nowrap style="text-align: right">法人代表：</td>
		                <td nowrap style="text-align: left" ><input name="form.ud_slegalman" type="text" id="ud_slegalman" style="width:154px" value="" maxlength="50" /></td>
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
        					  <input type="button" value="返回" class="button" onclick="toBack();" id="back" />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
 
</div>
</div>
    <input type="hidden"  name="menu" id="menu" value="<s:property value='menu'/>" >
<input type="hidden" name="form.searchB" value="<s:property value="form.searchB"/>" >

</form>
  </body>
</html>

 