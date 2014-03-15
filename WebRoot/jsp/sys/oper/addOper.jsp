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
  
    <script> 
    

    
function save(){
   	if(validator(document.form1)){
			document.form1.action="<%=path%>/oper!add";
			document.form1.submit();
	}
	 
}

function toResut(){
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
 	getDictSelect("","oper_stype","oper_stype","","","<%=path %>");
 	
	
	}); 
//功能放大镜
function selectFun(){
//1.功能编号对应标签ID 2.功能名称对应 标签ID         3功能编号,4系统编号
	var v = $("#sysint_sno").val();
	var s=$("#right_sname").val();
	if(v==""){
		alert("请选择系统");
		document.getElementById("sysint_sno").focus();
		return;
	}
	rightTree("right_sno","right_sname","",v);
}
function cleaner(){
$("#right_sno").val("");
$("#right_sname").val("");

}






//操作名称唯一性验证
	function findbyName(){
		var oper_sname = $('#oper_sname').val().trim();
		var sysint_sno = $('#sysint_sno').val().trim();
		var right_sno=$('#right_sno').val().trim();
		if(oper_sname==""||sysint_sno==""||right_sno==""){
			return true;
		}
			var flag = false;
			$.ajax({	
				type:'post',
				data:"form.oper_sname="+oper_sname+ "&form.sysint_sno="+sysint_sno+"&form.right_sno="+right_sno,
				dataType:'json',
				async:false,//定义同步，或者异步方式
				url:'<%=path %>/oper!findOperSname',
				success:function(data){
					if(data=='1'){//可以
						$('#errMsg_oper_sname').empty();
						flag = true;
					}else{//占用了
						$('#oper_sname').focus();
						$('#errMsg_oper_sname').html('操作名称已经存在!');
						flag = false;
					}	 
				},
				error:function (data) {
					alert(textStatus);// 通常情况下textStatus和errorThown只有其中一个有值   
					document.write(errorThrown); // the options for this ajax request  
	  			}
			});
		return flag;
    }

</script>

  </head>
  
  <body>
<form name="form1" method="post" action="<%=path %>/oper!add">
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
                									<td width="94%" valign="bottom"><span class="STYLE1">新增操作信息</span></td>
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
					    			<td nowrap align="right" width="15%">所属系统：</td>
									<td width="35%" nowrap="nowrap">
										<select name="form.sysint_sno" id="sysint_sno"  valid="required" errmsg="系统名称不能为空!"    onchange="cleaner();">
							      			<option value="" ></option>
	                              			<s:iterator value="list1" var="oper" status="s">
											<option value="${oper.sysint_sno}">${oper.sysint_sname}</option>
											</s:iterator>														   
									 	</select>
										<span style="white-space:nowrap;color:red;">*</span>
									</td>
					     			<td nowrap align="right" width="15%" >所属功能：</td>
					    			<td width="35%" nowrap>
					    				<input type="text"   id="right_sname"   value=""  valid="required" errmsg="功能名称不能为空!" style="width:134px;" readonly/>
					    				<input type="button" class="select_button" onclick="selectFun();" />
     									<input type="hidden"" id="right_sno" name="form.right_sno"    value=""> 
					   				 	<span style="color:red;white-space:nowrap;">*</span>
									</td>
					    		</tr> 
					    		<tr>
					    			<td nowrap align="right" >操作名称：</td>
					    			<td>
					    				<input name="form.oper_sname" id="oper_sname" value=""  
					    				url="<%=path%>/oper!checkUnique" urlname="form.right_sno|form.sysint_sno" urlmsg="操作名称已存在！"   
					    					 maxlength="50" valid="required"   errmsg="操作名称不能为空!"/>

					    				<span style="color:red;white-space:nowrap;">*</span>
					    				<span style="color:red;white-space:nowrap;"  id="errMsg_oper_sname"></span>
					     			</td>
					     			<td nowrap align="right">操作图标：</td>
					      				<td nowrap ><span id="oper_img"></span>
					    				<input type="button" value="操作图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow('oper_img','oper_simg');"  >
					    				<input type="hidden" name="form.oper_simg"  id="oper_simg" value=""/>
					    				</td>
					      				
					    		</tr>
					    		<tr>
					    			<td nowrap align="right">是否按钮：</td>
					    			<td>
					    				<input type="radio" name="form.oper_nmorb" id="oper_nmorb" value="0" checked/>是
										<input type="radio" name="form.oper_nmorb" value="1" />不是
					     			</td>
					    			<td nowrap align="right">操作类型：</td>
					    			<td >
							 			<select name="form.oper_stype" id="oper_stype" valid="required" errmsg="操作类型不能为空!">
											<option value="" >--请选择--</option>
							 			</select>
										<span style="color:red;white-space:nowrap;">*</span>
							 		</td>
					    		</tr>
					    		<tr>
					     			<td nowrap align="right">是否可用：</td>
					   		 		<td>
					    				<input type="radio" name="form.oper_sisuse" id="oper_sisuse" value="0" checked/>可以
										<input type="radio" name="form.oper_sisuse" value="1" />不可以
					     			</td>
					       			<td nowrap align="right">是否有效：</td>
					    			<td>
					    				<input type="radio" name="form.oper_sisvalid" id="oper_sisvalid" value="0" checked/>有效
										<input type="radio" name="form.oper_sisvalid" value="1" />无效
					     			</td>
					    		</tr>
					     		<tr>
                					<td align="right" nowrap>描述：</td>
                					<td colspan="3" align="left" nowrap>
                  						<textarea id="oper_sdesc" name="form.oper_sdesc"  style="width:100%;overflow-y:auto;" rows="4"   valid="limit" max="250" errmsg="描述长度不能超过250个字符!"></textarea>
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
    <input type="hidden" name="form.oper_sreplyby" id="oper_sreplyby" value="${session.userInfo.screenname}" />
  </form>
  </body>
</html>
 