<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String no=request.getParameter("empsno");
String name=request.getParameter("empsname");
String id=request.getParameter("id");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self"/>
<title>用户管理</title> 
<script>


$(function(){
$("input[name='idcheckbox']").each(function(){
			var empno = $(this).attr("empsno");
			var no = "<%=no %>";
			 
		});
		 
		var paramObj = window.dialogArguments;
		$("#empname").html($("#empname").html() + paramObj.empsname);
		
	});

function tosave(){
	  var arguemnts = new Object();
      arguemnts.window = window;
     var empsno= $("#emp_sno").val();
     var returnValue;
		 if(confirm("是否分配用户？")){
			 returnValue = window.showModalDialog('<%=path%>/emp!saveempuser?empsno='+empsno,arguemnts,'dialogHeight:275Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
 
 	 	}
		 if(returnValue!=undefined){
			 document.form1.action="<%=path%>/emp!findempuesr";
			document.form1.submit();
		 }
}
  function checkAll(box){  //全选或全不选
	form1.checkbox.checked = box.checked;
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
  		form1.idcheckbox.checked = box.checked;	
  		return;
  	}
  	if(box.checked) {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = true;
		}
	} else {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = false;
		}
	}
  }
  
  function checkOne(){  //选一个时全选或全不选
  	
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
		form1.checkbox.checked = form1.idcheckbox.checked;
		return;
  	}
  	var numBox =0;
	for (var i = 0; i < numRow; i++) {
		if(form1.idcheckbox[i].checked){
			numBox++;
		}
	}
	if(numBox==numRow){
		form1.checkbox.checked = true;
	}else {
		form1.checkbox.checked = false;
	}
  }
  
 function del(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	     
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   var knum=0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
				knum=i;
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
		}
	  }
	
	 if(flag==0)
	 {
		alert("请至少选择一条记录！");
		return;
	 }
	  
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/emp!Delete";
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
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB">
					<td height="30" align="left">
		   		 <span  style="white-space:nowrap;" id="empsno">&nbsp;&nbsp;职工编号:&nbsp;&nbsp;&nbsp;${form.emp_sno}
		   		  <input type="hidden" name="form1.emp_sno" id="emp_sno" value="${form.emp_sno}"/>
			     </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span  style="white-space:nowrap;" id="empname" >&nbsp;&nbsp;职工名称:&nbsp;&nbsp;&nbsp;
				  </span>
		   		 
		   		 </td>
		   		 
		   		 </tr>
		   		 </table>
		   		 	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		     		 <tr>
		        		<td height="24" bgcolor="#353c44">
		        			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
		           				<tr>
            					 <td >
           							 <table width="100%" border="0" cellspacing="0" cellpadding="0">
              							<tr>
               							 	<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                							<td width="94%" valign="bottom" style="text-align:left;text-overflow:ellipsis;overflow:hidden;white-space:nowrap; "><span class="STYLE1"> 用户信息列表</span></td>
              							</tr>
          							  </table>
            					</td>
            					<td style="text-align:center;text-overflow:ellipsis;overflow:hidden;white-space:nowrap; ">
           						 <div align="right" >
					            	<span class="STYLE1" >
					 					<a href="javascript:void(0);" onclick="tosave();"><img src="<%=path %>/images/ok.gif" width="10" height="10" border="0"/> <span class="STYLE1">分配用户</span></a>
					 					<a href="javascript:void(0);" onclick="del();"><img src="<%=path %>/images/ok.gif" width="10" height="10" border="0"/> <span class="STYLE1">取消用户</span></a>
					              <a href="javascript:void(0);" onclick="javascript:window.close();"><img src="<%=path %>/images/pic12.gif" width="10" height="10" border="0"/> <span class="STYLE1">关闭</span></a>&nbsp;
					               </span></div>
            					</td>
         					 </tr>
       					 </table>
        				</td>
     				 </tr>
   				 </table>
   			  </td>
 		 </tr>
   
			  <tr>
			    <td>
			    <table  align="center" class="table" width="100%"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce"  >
			       
			     
			      <tr  bgcolor="d3eaef" >
			        <td width="40" height="24" > 
			        	<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  />
			        </td>
			        <td width="40" height="20" align="centert">序号</td>
			        <td  width="150" height="20" align="centert">用户账号</td>
			         <td  width="150" height="20" align="centert">用户名</td>
			        <td   height="20" align="centert">邮箱</td>
			     </tr>
			     <s:iterator value="list" status="s" var="user">
			      <tr bgcolor="#FFFFFF">
			        <td height="20" > 
			          	<input type="checkbox" name="idcheckbox" empsno="${user.emp_sno}" onclick="checkOne();" value="${user.userid}"  />
			      
			        </td>
			        <td height="20" ><s:property value="#s.index + 1"/></td>
			       	 <td height="20" title="${user.screenname}" align="centert"><s:property value="#user.screenname"/></td>
			         
			       	 <td height="20" title="${user.firstname}${user.lastname}" align="centert">${user.firstname}${user.lastname}</td>
			         <td height="20" title="${user.email}" align="centert"><s:property value="#user.email"/></td>
			         
			      </tr>
			   </s:iterator>  
			    </table>
			   
			    </td>
			  </tr>
			  <tr>
			    <td height="30">
			     
			    <div align="center"  >
			    				<s:if test="%{list.size()!=0}">
			    			
			    			<page:page uri="/emp!findempuesr"></page:page>
			    				</s:if>
			    				<s:elseif test="%{list.size()==0}">
			    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
			    				</s:elseif>
			    			 </div> </td>
			 	 </tr>
			 
    </table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr><!--
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
--></table>
</form>
</body>
</html>
