<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
 <link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=path %>/js/valid.js" type=text/javascript></script> 
<script> 
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
	$("#parm_sname").blur(function(){
		addAttr("parm_sname", "<%=path %>/parm!findParmSname", "form.sysint_sno", "${vo.parm_sname}");
	});
});
 
	
	
//保存
function save(){

 addAttr("parm_sname", "<%=path %>/parm!findParmSname", "form.sysint_sno", "${vo.parm_sname}");

	var obj=$('#parm_stype').val(); 
	 if(obj =='1'){
   	 var obj1=$('#sysint_sno').val();
   	 if(obj1==''){
   	alert("系统名称不能为空");
  		 return true;
   }
   
	 }
	 
		if(validator(document.form1)){
			document.form1.action="<%=path%>/parm!update";
			document.form1.submit();
		}
	 
}
function toResut(){
    document.all.form1.reset();
}
function findbyName(){
	if($("#parm_sname").val()==$("#parm_sname1").val())
	{
	return
	}
	else if($("#parm_sname").val()!=$("#parm_sname1").val()){
  
	var string = $('#parm_sname').val();
	var sysint_sno = $('#sysint_sno').val();
	 
var name = "";
string = '' + string;
splitstring = string.split(" "); //双引号之间是个空格；
for(i = 0; i < splitstring.length; i++)
name += splitstring[i];	
$('#parm_sname').val(name);
	var flag = false;
	$.ajax({	
		type:'post',
		data:"form.parm_sname="+name+ "&form.sysint_sno="+sysint_sno,
		dataType:'json',
		async:false,//定义同步，或者异步方式
		url:'<%=path %>/parmsname',
		success:function(data){
		if(data=='1'){//可以
			$('#error').empty();
			flag = true;
		}else{//占用了
			$('#parm_sname').focus();		
			$('#error').append('<li>参数访问名已经存在</li>');
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
	return flag;}
            }
       $(function(){
    	   var obj=$('#parm_stype').val(); 
    	   if(obj=='0'){
    		    form1.sysint_sno.disabled = true;
    		    $('#sysint_sno').val('');
    		    $("#sno").hide();
    		    
    		   }else
    		   if(obj =='1'){
    		     
    		    $("#sno").show();
    		  	 form1.sysint_sno.disabled = true;
    		  	  
    		   
    		   }
    	   
       });
            
function show(){
	   var obj=$('#parm_stype').val(); 
	   /*var obj = document.getElementById("sysint_sno");*/
	    if(obj==''){
	        form1.sysint_sno.disabled = true;
	   		 $('#sysint_sno').val('');
	   	 $("#sno").hide();
	    }
	  
	   if(obj=='0'){
	    form1.sysint_sno.disabled = true;
	    $('#sysint_sno').val('');
	    $("#sno").hide();
	    
	   }else
	   if(obj =='1'){
	     
	    $("#sno").show();
	  	 form1.sysint_sno.disabled = false;
	  	  
	   
	   }
	    
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改参数</span></td>
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
									    <td nowrap align="right" width="20%">参数类别:</td>
									    <td colspan="3">
									     <select name="form.parm_stype" id="parm_stype" onclick="show();"  style="width:110px" valid="required" errmsg="参数状态不能为空!" disabled> 
					          		     <option value="">--请选择--</option>
					                     <option value="0"  <s:if test="vo.parm_stype == \"0\""> selected</s:if>>公共类型</option>
					                      <option value="1"  <s:if test="vo.parm_stype == \"1\""> selected</s:if>>系统类型</option>
					                      </select>  
									    <span style="color:red;"> *</span> &nbsp;&nbsp;
					    					<span style="color:red;"  id="errMsg_parm_stype"></span>
					    				</td>
						     		</tr>
						     		
					 				<tr>
									    <td nowrap align="right" >系统编号:</td>
									    <td colspan="0">
									    
									     <select  name="form.sysint_sno" id="sysint_sno"    disabled> 
					          		     <option value="">--请选择--</option>
					                      <s:iterator value="syslist" status="s" var="sy">
					          		       <option value="${sy.sysint_sno}" <s:if test="vo.sysint_sno==#sy.sysint_sno"> selected </s:if>>${sy.sysint_sname}</option>
									     </s:iterator> 
					                      </select> 
					                      <span id ="sno" style="color:red;">*</span>
									    </td>
						     		</tr>
						     		<tr>
					    				<td nowrap align="right" width="20%">参数访问名:</td>
										    <td colspan="3"><input name="form.parm_sname" id="parm_sname" value="<s:property value="vo.parm_sname"/>"   class="text" style="width:154px" maxlength="10" valid="required" errmsg="参数访问名称不能为空!"  urlmsg="参数名称已存在！"/>
										    <span style="color:red;">*</span>
										    <span style="color:red;"  id="error"></span>
										     </td>
										   	
					    			</tr>
					 				<tr>
					    				<td nowrap align="right" width="20%">参数名称:</td>
										    <td colspan="3"><input name="form.parm_sdisname" id="parm_sdisname" value="<s:property value="vo.parm_sdisname"/>"   class="text" style="width:154px" maxlength="10" valid="required" errmsg="参数名称不能为空!"/>
										    
										    <span style="color:red;">*</span>
										    <span style="color:red;"  id="errMsg_parm_sdisname"></span>
										     				</td>
										   	
					    			</tr>
					    			
					    			<tr>
					    				 <td nowrap align="right" width="20%">参数值:</td>
										    <td colspan="3"><input name="form.parm_svalue" id="parm_svalue" value="<s:property value="vo.parm_svalue"/>"   class="text" style="width:154px" maxlength="10" valid="required" errmsg="参数值不能为空!"/>
										    <span style="color:red;">*</span>&nbsp;&nbsp; 
					    					<span style="color:red;"  id="errMsg_parm_svalue"></span> 
					    				</td>
					    
					  				</tr>
					  				
					  				<tr>
									    <td nowrap align="right" height="120px">描述:</td>
									    <td ><textarea id="parm_sdesc" name="form.parm_sdesc" rows="5" cols="80"  max="250" errmsg="描述长度不能超过250字符!">${vo.parm_sdesc}</textarea>
									    <span style="color:red;"  id="errMsg_role_sdesc"></span>
									    <input type="hidden"  id="parm_nid" name="form.parm_nid" value="${vo.parm_nid }"/>
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
    
  </form>
  </body>
</html>
 