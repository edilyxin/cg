<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

  <head>
    <base href="<%=basePath%>"/>
    <title>修改系统集成信息</title>

<script> 

 

	//保存修改
	function save(){
		if(validator(document.form1)){
			if(confirm("是否保存？")){
				document.form1.action="<%=path%>/sysint!update";
				document.form1.submit();
			}
		}
	}
	
	//重置
	function reset(){
			document.form1.reset();
	}
	//打开图标弹出窗口
	function openIconWindow() {
		var url="<%=path%>/right!findImgList";
		var whObj = { width:"650px", height:"500px" };
		var returnValue = openShowModalDialog(url,"",whObj);
		if (returnValue != undefined) {
			document.getElementById("sysint_simg").value = returnValue;
			if(returnValue==""){
				document.getElementById("sysint_img").innerHTML = returnValue;
			}else{
				document.getElementById("sysint_img").innerHTML = "<img alt=\"集成图标\" style=\"border:1px #666666 solid;\" width=\"20\" height=\"20\"  align=\"middle\" src=\"<%=path%>/"+returnValue+"\"/>&nbsp;";
			}
		}
	}
	function openShowModalDialog(url,param,whparam){   
	     
		 // 传递至子窗口的参数   
		 var paramObj = param || { };   
		         
		 // 模态窗口高度和宽度   
		 var whparamObj = whparam || { width: 500, height: 300 };   
		         
		 // 相对于浏览器的居中位置   
		 var bleft = (window.width - whparamObj.width) / 2;   
		 var btop = (window.height - whparamObj.height) / 2;   
		         
		 // 根据鼠标点击位置算出绝对位置     
		         
		 // 最终模态窗口的位置   
		 var left = bleft  ;   
		 var top = btop  ;   
		         
		 // 参数   
		 var p = "help:no;status:no;center:yes;";   
		     p += 'dialogWidth:'+(whparamObj.width)+'px;';   
		     p += 'dialogHeight:'+(whparamObj.height)+'px;';   
		     p += 'dialogLeft:' + left + 'px;';   
		     p += 'dialogTop:' + top + 'px;';   
		  return showModalDialog(url,paramObj,p);   
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
                									<td width="94%" valign="bottom"><span class="STYLE1">修改系统集成信息</span></td>
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
					    				<td nowrap align="right" >系统编号:</td>
					    				<td nowrap>
					    					<input name="form.sysint_sno" id="sysint_sno" value="${vo.sysint_sno}"    readonly />
					     				</td>
					     				<td  ></td>
					    				<td  > </td>
					    			</tr>
					 				<tr>
					     				<td nowrap align="right">系统名称:</td>
					    				<td nowrap>
					    					<input name="form.sysint_sname" id="sysint_sname" value="${vo.sysint_sname}"    readonly  />
					    					
					    				</td>
					    				<td nowrap align="right">系统简称:</td>
					    				<td nowrap>
					    					<input type="text" name="form.sysint_ssname" id="sysint_ssname" value="${vo.sysint_ssname}"  readonly />
					    					
					    				</td>
					    			</tr>
					    			<tr>
					    				<td nowrap align="right">集成方式:</td>
					    				<td nowrap>
					    					<select id="sysint_susrtype" name="form.sysint_susrtype" valid="required" errMsg="集成方式不能为空">
					    						<option value=""></option>
					    						<option value="0" <s:if test="%{vo.sysint_susrtype==\"0\"}">selected</s:if>>完全集成</option>
					    						<option value="1" <s:if test="%{vo.sysint_susrtype==\"1\"}">selected</s:if>>用户信息集成</option>
					    						<option value="2" <s:if test="%{vo.sysint_susrtype==\"2\"}">selected</s:if>>用户对照集成</option>
					    					</select>
					    					<span style="color:red;">*</span>
					    				</td>
					    				<td nowrap align="right">集成图标:</td>
					    				<td nowrap ><span id="sysint_img">
					    				<s:if test="vo.sysint_simg!=null">
					    				<img alt="集成图标"  src="<%=path %>/${vo.sysint_simg}" style="border:1px #666666 solid;" width="20" height="20"  align="middle">&nbsp;</s:if></span>
<!--					    				<img alt="集成图标" id="sysint_img" src="<%=path %>/${vo.sysint_simg}" style="cursor:hand;border:1px #666666 solid;" width="20" height="20"  align="middle" onclick="openIconWindow();">-->
					    				<input type="button" value="选择图标 " style="height:25px;vertical-align:middle;" onclick="openIconWindow();"  >
					    				<input type="hidden" name="form.sysint_simg"  id="sysint_simg" value="${vo.sysint_simg}"/>
					    				</td>
					  				</tr>
					    			<tr>
					    				
					    				<td nowrap align="right"  >系统访问地址:</td>
					    				<td nowrap>
					    					<input name="form.sysint_surl" id="sysint_surl" value="${vo.sysint_surl}" onblur="" class="text"  maxlength="50"  />
					     					 
					     				</td>
					    				<td nowrap align="right">用户账号参数:</td>
					    				<td nowrap>
					    					<input name="form.sysint_susrpar" id="sysint_susrpar" value="${vo.sysint_susrpar}" onblur="" class="text" maxlength="50"  />
					    					 
					    				</td>
					    
					  				</tr>
					  				<tr>
					    				
					    				<td nowrap align="right">用户密码参数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.sysint_spwdpar" id="sysint_spwdpar" value="${vo.sysint_spwdpar}"  maxlength="50"  />
					    					 
					    				</td>
					    				<td nowrap align="right">用户类别参数:</td>
					    				<td nowrap>
					    					<input type="text" name="form.sysint_susrtypepar" id="sysint_susrtypepar" value="${vo.sysint_susrtypepar}"   maxlength="50"   />
					    					 
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
        					  <input type="button" name="Submit" value="保存" class="button" onclick="save();"/>&nbsp;
							<input type="button" name="Submit3" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
							<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    <input type="hidden" name="form.sysint_salterby" value="${session.userInfo.screenname}"/>
  </form>
  </body>
</html>
 