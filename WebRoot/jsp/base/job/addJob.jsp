<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
 <script> 
//点击单位的时候必选先点岗位类别
 function selectFun(){
 if($("#job_stype").val()==""){
		alert("请先选择岗位类别！");
		document.getElementById("job_stype").focus();
		$("#ud_sname").val("");
		$("#ud_sno").val("");
		return;
 }
 if($("#job_stype").val()=="公共"){
 unitDepartTree('ud_sno','ud_sname','','','1');
 }
 else if($("#job_stype").val()=="部门"){
  unitDepartTree('ud_sno','ud_sname','','','2');
 }
 else{
	 unitDepartTree('ud_sno','ud_sname','','','');
 }
 
 }
 
 function cleaner(){
 $("#ud_sname").val("");
		$("#ud_sno").val("");
 }
 //鼠标点击事件
 $(function() {
	$("#ud_sname").click(function() {
	  if($("#job_stype").val()==""){
		alert("请先选择岗位类别！");
		document.getElementById("job_stype").focus();
		$("#ud_sname").val("");
		$("#ud_sno").val("");
		return;
 }
			 if($("#job_stype").val()=="公共"){
			 unitDepartTree('ud_sno','ud_sname','','','1');
			 }
			 else if($("#job_stype").val()=="部门"){
			  unitDepartTree('ud_sno','ud_sname','','','2');
			 }
			 else{
			  unitDepartTree('ud_sno','ud_sname','','','');
			 }
		});

	});
//设置岗位名称的时候必需先选择所属单位，这样可以判定唯一性
  $(function(){
		$("#job_sname").change(function(){
		if($("#ud_sname").val()==""){
		alert("请先选择单位名称！");
		document.getElementById("ud_sname").focus();
		$("#job_sname").val("");
		return;
		}
			});
		});
//选择岗位类别的时候，联动等级......
 $(function(){
		$("#job_stype").change(function(){
		if($(this).val()=="部门"){
		  $(document).ready(function(){
		getDictSelect("","job_nlevel","job_nlevel","","","<%=path %>");
		});
		return;
		}
		if(1>=$(this).val()){
		$("#job_nlevel").empty();
		$("#job_nlevel").append("<option value=''>--请选择--</option>");
		
		return;	}
		else{
			$.post(
				"<%=path%>/job!find1",
				{"form.job_stype":$(this).val()},
				
				function(childList) {
					$("#job_nlevel").empty();
					$("#job_nlevel").append("<option value=''>--请选择--</option>");
					
					for (var i=1; i < childList+1; i++) {
						var child = i;
						$("#job_nlevel").append("<option value='" + child + "'>" + child+'级' +"</option>");
					}
				}, "json"
			);
			}
		});
	});
 
 
 //岗位唯一性验证
	function findbyName(){
	var string = $('#job_sname').val();
	var ud_sno = $('#ud_sno').val();
var name = "";
string = '' + string;
splitstring = string.split(" "); //双引号之间是个空格；
for(i = 0; i < splitstring.length; i++)
name += splitstring[i];	
$('#job_sname').val(name);
	var flag = false;
	$.ajax({	
		type:'post',
		data:"form.job_sname="+name+ "&form.ud_sno="+ud_sno,
		dataType:'json',
		async:false,//定义同步，或者异步方式
		url:'<%=path %>/jobsname',
		success:function(data){
		
		if(data=='1'){//可以
			$('#error').empty();
			flag = true;
		}else{//占用了
			$('#job_sname').focus();
			$('#error').append('<li>该岗位已经存在</li>');
			$('#error li:eq(1)').remove();
			flag = false;
		}	 
		},
		error:function (data) {
		alert(textStatus);// 通常情况下textStatus和errorThown只有其中一个有值   
	document.write(errorThrown); // the options for this ajax request  
		
	  }
}
	);
	return flag;
            }
 
 
function save(){
   	if(validator(document.form1)){
			document.form1.action="<%=path%>/job!add";
			document.form1.submit();
	}
}
function toReset(){
		  document.all.form1.reset();
}

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
 	getDictSelect("","job_stype","job_stype","","","<%=path %>");
	}); 
</script>
  </head>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">添加岗位</span></td>
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
					    <td nowrap align="right" width="13%">岗位类别:</td>
					    <td  nowrap="nowrap"><select name="form.job_stype" id="job_stype" valid="required" errmsg="岗位类别不能为空!" onchange="cleaner();">
									    <option value="" >--请选择--</option>
									    <option value="公共" >公共</option>
									    <option value="部门" >部门</option>
									    </select>
					    
					    <span style="color:red;" >*</span>&nbsp;&nbsp; 
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					     <td nowrap align="right" width="13%">等级:</td>
					    <td ><select name="form.job_nlevel" id="job_nlevel" valid="required" errmsg="等级不能为空!">
									    <option value="" >--请选择--</option>
									    </select>
					    
					    <span style="color:red;">*</span>&nbsp;&nbsp; 
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					     
					    </tr>
					    <tr>
					        
					       <td nowrap align="right" width="13%">所属单位:</td>
					    <td nowrap="nowrap">
					    
					    <input type="text"   id="ud_sname"  name="form.ud_sname"  value="${form.ud_sname}" readonly   valid="required" errmsg="所属单位不能为空!"/>
							<input type="button" class="select_button" onclick="selectFun()" />	
              <input type="hidden"" id="ud_sno"  name="form.ud_sno"  value="${form.ud_sno}" />
					 <span style="color:red;">*</span>&nbsp;&nbsp; 
							</td>
					  
</tr>
					    
					     <tr>
					    <td nowrap align="right" width="13%">岗位名称:</td>
					    <td  nowrap="nowrap"><input name="form.job_sname" id="job_sname" value="" 
	url="<%=path%>/job!checkUnique" urlname="form.ud_sno" urlmsg="岗位名称已存在！"   
					    					 maxlength="50" valid="required"   errmsg="岗位名称不能为空!"/>
					    <span style="color:red;white-space:nowrap;">*</span>&nbsp;&nbsp; 
					    <span style="color:red;white-space:nowrap;"  id="errMsg_role_sname"></span>
					    <div id="error" style="color:red;"></div>
					     </td>
					    </tr>
					     <tr>
					     <td nowrap align="right" width="13%">住宅面积数:</td>
					    <td ><input name="form.job_nresarea" id="job_nresarea" value=""   class="text" style="width:154px" maxlength="10"
					    valid="isNumber" errmsg="住宅面积数只能是正数！" 
					     onkeyup="if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"/>
					    <span >元/m²</span>
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					       <td nowrap align="right" width="13%">办公面积数:</td>
					    <td ><input name="form.job_noffarea" id="job_noffarea" value=""   class="text" style="width:154px" maxlength="10" 
					    valid="isNumber" errmsg="办公面积数只能是正数！" 
					     onkeyup="if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"/>
					    <span >元/m²</span>
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					     </tr>
					       <tr>
					  
					     <td nowrap align="right" width="13%">房补金额数:</td>
					    <td ><input name="form.job_nhousmoney" id="job_nhousmoney" value=""   class="text" style="width:154px" maxlength="10" 
valid="isNumber" errmsg="房补金额数只能是正数！" 
					     onkeyup="if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"/>
					    <span >元/m²</span>
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					      <td nowrap align="right" width="13%">供暖补贴费:</td>
					    <td><input name="form.job_nheatmoney" id="job_nheatmoney" value=""   class="text" style="width:154px" maxlength="10" 
valid="isNumber" errmsg="供暖补贴费只能是正数！" 
					     onkeyup="if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"/>
					    <span >元/m²</span>
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					     
					     </tr>
					      <tr>
					       <td nowrap align="right" width="13%">是否启用:</td>
					    <td >
					    <input type="radio" name="form.job_sisvalid" id="job_sisvalid" value="0" checked/>启用&nbsp;<input type="radio" name="form.job_sisvalid" id="job_sisvalid" value="1" />不启用
					    <span style="color:red;"  id="errMsg_role_sname"></span>
					     </td>
					    
					    </tr>
					   
					     <tr>
                <td nowrap align="right" width="13%">描述：</td>
                <td colspan="4" align="left" nowrap>
                  <textarea id="job_smem" name="form.job_smem"  style="width:100%;overflow-y:auto;"
                   rows="4" cols="100" valid="limit" max="250" errmsg="功能描述长度不能超过500字符!"></textarea>
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
    <input type="hidden" name="us_sreplyby" value=""/>
<input type="hidden"  name="menu" id="menu" value="<s:property value="menu"/>" >
 	<input type="hidden"  name="form.searchA" id="searchA" value="${form.searchA}">
 	  <input type="hidden" name="form.job_sreplyby" id="job_sreplyby" value="${session.userInfo.username}"/>

  </form>
  </body>
</html>

 