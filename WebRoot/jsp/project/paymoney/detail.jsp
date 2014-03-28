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
<title>项目立项</title> 
<script>
  //查询
  function findInfo(){
  input_trim();
  document.getElementById("searchA1").value=document.getElementById("searchA").value;
  document.form1.action="<%=path%>/approve!save";
  document.all.form1.submit();
}
 
 //修改
 function toUpdate(){
  var obj1=document.getElementsByName("post_sisvalid");
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
				if(obj1[knum].value==1)
			  	 {			  
			  	 }
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
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？"))
	 {
		document.form1.action="<%=path%>/approve!toUpdate";
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
    //删除
   function del(){
 var obj1=document.getElementsByName("set_sisvalid");
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
				if(obj1[knum].value==1)
			  	 {
			  
			  	 }else{
			  	 	// alert(obj1[knum].value);
			  	    alert("只能对不启用状态信息删除!");
			  	    return;
			  	 }
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
	  if(obj1[knum].value=="1")
  	 {
  	 }else{
  	    alert("只能对不启用状态信息删除!");
  	    return;
  	 }
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/approve!toDelete";
		document.form1.submit();
	 }
  }
  //启用
   function changeValid(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
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
	 if(confirm("是否修改所选记录状态？"))
	 {
		document.form1.action="<%=path%>/approve!changeValid";
		document.form1.submit();
	 }
  }  
 

</script>

</head>

<body>

<form name="form1" method="post" action="<%=path %>/process!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><%-- <s:property value="#session.navbar"/> --%>应收应付记录</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;项目编号:                             
                	${vo.EP_SNO}&nbsp;&nbsp;包编号:                             
                	${vo.BG_SNO}&nbsp;&nbsp;合同编号:                             
                	${vo.CT_SNO}
                </span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="findInfo()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
                </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">应收应付明细信息列表</span></td>
              </tr>
            </table></td>            
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width=""  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">        
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">类型</span></div></th>
        <th width="100px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">金额</span></div></th>
        <th width="100px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">付款时间</span></div></th> 
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">经办人</span></div></th>
      </tr>
     <s:iterator value="list"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" <s:if test="#li.SS_SISVALID==\"1\"">style="color:red;"</s:if>>
      	<td >${st.index+1}</td>
      	<td height="20"  title=""></td>
      	<td height="20"  title="${li.PM_NMONEY}">${li.PM_NMONEY}</td>
      	<td height="20"  title="${li.PM_DTIME}">${li.PM_DTIME}</td>
      	<td height="20"  title="${li.PM_SPERSON}">${li.PM_SPERSON}</td>
      </tr>
      </s:iterator>
   </table>
			</div>
  		</div>
</form>
</body>
</html>
  