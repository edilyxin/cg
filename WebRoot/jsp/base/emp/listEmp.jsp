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

<script type="text/javascript">


function findInfo(){
input_trim();
<%--	 document.getElementById("searchA1").value=document.getElementById("searchA").value;--%>
	 document.getElementById("searchB1").value=document.getElementById("searchB").value;
	 document.getElementById("searchC1").value=document.getElementById("searchC").value;
	 document.getElementById("searchD1").value=document.getElementById("searchD").value;
	  document.getElementById("searchE1").value=document.getElementById("searchE").value; 
	 document.all.form1.submit();
	}
//排序

function findPage(curretPage){
 document.getElementById("currentPage").value=curretPage;
 document.all.form1.submit();
}
function toAdd(){
	document.form1.action="<%=path%>/emp!toAdd";
	document.form1.submit();

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


 function toUpdate(){
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
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？"))
	 {
		document.form1.action="<%=path%>/emp!toUpdate";
		document.form1.submit();
	 }	
  }
  
 function del(){
 if(document.form1.idcheckbox==null){
		  return;
	}
	    var obj1=document.getElementsByName("form.emp_sisvalid");
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
	  if(obj1[knum].value=="0")
  	 {
  	 	alert("只能对不启用信息删除!");
  	    return;
  	 }else{
  	    
  	 }
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/emp!toDelete";
		document.form1.submit();
	 }
  }  
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
		document.form1.action="<%=path%>/emp!changeValid";
		document.form1.submit();
	 }
  }    
  

function toaddUser(){
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
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 
	 if(confirm("是否产生用户信息？"))
	 {
		 var obj=$("input:checkbox[name=idcheckbox]:checked");
			
		 var empsno= obj.attr("flname");
		document.form1.action="<%=path%>/emp!adduser?empsno="+empsno;
		document.form1.submit();
	 }
	
}

function tosetupUser() {
		if(document.form1.idcheckbox==null)
    {
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
	alert("请选择一条记录！");
	return;
 }else if(flag!=1)
 {
	alert("请只选择一条记录，不要多选！");
	return;
 }
 if(confirm("是否查看用户？"))
 {
	 var obj=$("input:checkbox[name=idcheckbox]:checked");
	
	var empsname= obj.attr("sname");
	var empsno= obj.attr("flname");
	
	 var id = $("input[name='idcheckbox']:checked").val();
	var url="<%=path%>/emp!findempuesr?id=" + id + "&empsno=" + empsno
	var whObj = { width:"700px", height:"450px" };
	var param = {"empsname":empsname};
	openShowModalDialog(url,param,whObj);
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

<body >
<form name="form1" method="post" action="<%=path%>/emp!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
				<span  style="white-space:nowrap;">&nbsp;&nbsp;所属校区:
				 
				 <input type="text"  name="form.sh_sname" id="sh_sname"  onclick="schoolTree('searchC','sh_sname');" value="${form.sh_sname}" readonly size="12"/>
				 <input type="button" class="select_button" onclick="schoolTree('searchC','sh_sname');" />
				  <input type="hidden" id="searchC"  name="form.sh_sno" value="${form.sh_sno}" />
				 </span>
 
				
				<span  style="white-space:nowrap;">&nbsp;&nbsp;所属学院:
					<s:if test="menu != \"0\"">
               
               <input type="text"  name="form.ud_sname1" id="ud_sname1" value="${form.ud_sname1}" onclick="unitDepartTree('searchB','ud_sname1','','','2');" readonly size="12"/>
               <input type="button" class="select_button" onclick="unitDepartTree('searchB','ud_sname1','','','2');"/>
          	  <input type="hidden" name="form.ud_sno1"  id="searchB" value="${form.ud_sno1}" />
              </s:if>
              	<s:if test="menu == \"0\"">
              	<input type="text" id="ud_sname1" name="form.ud_sname1" value="${form.ud_sname1}" readonly style="background:#EEE;"/>
              	<input type="hidden" id="searchB" name="searchB" value="${form.searchB}" readonly style="background:#EEE;"/>
              	</s:if>
               </span>
               <span  style="white-space:nowrap;">&nbsp;&nbsp;所属科系:
					<s:if test="menu != \"0\"">
               
               <input type="text"  name="form.ud_sname2" id="ud_sname2" value="${form.ud_sname2}" onclick="unitDepartTree('searchE','ud_sname2','','','3');" readonly size="12"/>
               <input type="button" class="select_button" onclick="unitDepartTree('searchE','ud_sname2','','','3');"/>
              <input type="hidden" name="form.ud_sno2"  id="searchE" value="${form.ud_sno2}" />
              </s:if>
              	<s:if test="menu == \"0\"">
              	<input type="text" id="ud_sname2" name="form.ud_sname2" value="${form.ud_sname2}" readonly style="background:#EEE;"/>
              	<input type="hidden" id="searchE" name="searchE" value="${form.searchE}" readonly style="background:#EEE;"/>
              	</s:if>
               </span>
               
               
				<span  style="white-space:nowrap;">&nbsp;&nbsp;员工姓名:
               <input type="text" name="searchD"  id="searchD" value="${form.searchD}" /></span> 
			  
			  
			  <span  style="white-space:nowrap;">&nbsp;&nbsp;             
			 <a href="javascript:void(0);"  onclick="findInfo();" style="cursor:hand" align="left"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
			    <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}" />
    			<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
   				<input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
   			    <input type="hidden" id="searchD1" name="form.searchD" value="${form.searchD}"/>
   			    <input type="hidden" id="searchE1" name="form.searchE" value="${form.searchE}"/>
			    <input type="hidden"  name="menu" id="menu" value="<s:property value="menu"/>" /> 
			   
			   	<input type="hidden" id="emp_sno" name="form.emp_sno" value=""/>
   				<input type="hidden" id="emp_sname" name="form.emp_sname" value=""/>
   			    <input type="hidden" id="emp_nid" name="form.emp_nid" value=""/>
			   
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">职工信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	<span class="STYLE1" style="white-space:nowrap;">
	            	<s:if test="#session.operList.get(\"020501\")!=null">
						<a title="新增" href="javascript:void(0);" onclick="toAdd()" >
							<img src="<%=path%>/<s:property value="#session.operList.get(\"020501\").oper_simg"/>" width="10" height="10" border="0"/> 
							<span class="STYLE1"><s:property value="#session.operList.get(\"020501\").oper_sname"/></span>
						</a> 
					</s:if>
					<s:if test="#session.operList.get(\"020503\")!=null">
      					<a title="修改" href="javascript:void(0);" onclick="toUpdate();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"020503\").oper_simg"/>" width="10" height="10" border="0"/>
							<span class="STYLE1"><s:property value="#session.operList.get(\"020503\").oper_sname"/></span>
						</a>
					</s:if>
					<s:if test="#session.operList.get(\"020502\")!=null">
      					<a title="删除" href="javascript:void(0);" onclick="del();">
      						<img src="<%=path%>/<s:property value="#session.operList.get(\"020502\").oper_simg"/>" width="10" height="10" border="0"/> 
      						<span class="STYLE1"><s:property value="#session.operList.get(\"020502\").oper_sname"/></span>
      					</a>
      				</s:if>
      				<s:if test="#session.operList.get(\"020504\")!=null">
	            		<a title="有效/无效" href="javascript:void(0);" onclick="changeValid();">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020504\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020504\").oper_sname"/></span>
	            		</a>
	            	</s:if></span>
	            	<span class="STYLE1" style="white-space:nowrap;">
	            	<s:if test="#session.operList.get(\"020509\")!=null">
	            		<a title="下载模板" href="javascript:void(0);" onclick="downloadTemp('mng_emp');">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020509\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020509\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	            	<s:if test="#session.operList.get(\"020505\")!=null">
	            		<a title="导入" href="javascript:void(0);" onclick="importExcel('职工信息导入','emp');">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020505\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020505\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	            	<s:if test="#session.operList.get(\"020506\")!=null">
	            		<a title="导出" href="javascript:void(0);" onclick="exportExcel('emp');">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020506\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020506\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	            	<s:if test="#session.operList.get(\"020507\")!=null">
	            		<a title="查看可用用户" href="javascript:void(0);" onclick="tosetupUser();">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020507\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020507\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	            	<s:if test="#session.operList.get(\"020508\")!=null">
	            		<a title="新增用户信息" href="javascript:void(0);" onclick="toaddUser();">
	            			<img src="<%=path%>/<s:property value="#session.operList.get(\"020508\").oper_simg"/>" width="10" height="10" border="0"/> 
	            				<span class="STYLE1"><s:property value="#session.operList.get(\"020508\").oper_sname"/></span>
	            		</a>
	            	</s:if>
	                </span>
	           </td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   
    <table width="2300px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
     
   	  <tr bgcolor="#CBE0FF">
         <td width="40px" height="25" class="STYLE10"><div align="center">
        <input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  /></div></td>
        <td width="40px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
             <td width="100" height="20" class="STYLE6"><div align="center"><span class="STYLE10">所属校区</span></div></td>
<%--		   <td  width="200" height="20" class="STYLE6"><div align="center"><span class="STYLE10">所属单位</span></div></td>--%>
			<td  width="160" height="20" class="STYLE6"><div align="center"><span class="STYLE10">所属学院</span></div></td>
			<td width="80"height="20" class="STYLE6"><div align="center"><span class="STYLE10">所属科系</span></div></td>
			
			<td width="150" height="20" class="STYLE6"><div align="center"><span class="STYLE10">员工编号</span></div></td>
			<td width="100"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">员工名称</span></div></td>
			<td width="80" height="20" class="STYLE6"><div align="center"><span class="STYLE10">英文名</span></div></td>
			<td width="80"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">性别</span></div></td>
			<td width="80" height="20" class="STYLE6"><div align="center"><span class="STYLE10">学历</span></div></td>
			<td width="150" height="20" class="STYLE6"><div align="center"><span class="STYLE10">手机号码</span></div></td>
			<td width="150"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">电话内线</span></div></td>
			 <td  height="20" class="STYLE6"><div align="center"><span class="STYLE10">电话外线</span></div></td>
		    <td width="80" height="20" class="STYLE6"><div align="center"><span class="STYLE10">传真号</span></div></td>
		    <td width="200"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">电子邮件</span></div></td>
	        <td width="80"   height="20" class="STYLE6"><div align="center"><span class="STYLE10">入职时间</span></div></td>
			<td width="80"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">职务</span></div></td>
			<td width="80"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">职称</span></div></td>
			<td width="80"   height="20" class="STYLE6"><div align="center"><span class="STYLE10">职级</span></div></td>
		  
			<td width="80"   height="20" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></td>
			<td width="80"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否启用</span></div></td>
         </tr>
          <s:iterator value="list" status="s" var="emp">
     	<tr  bgcolor="#FFFFFF" align="center" class="STYLE19" <s:if test="#emp.emp_sisvalid==\"1\"">style="color:red;"</s:if> >
        <td height="20"><div align="center">
           <input type="checkbox"  id="idcheckbox" onclick="checkOne();" name="idcheckbox" sname="${emp.emp_sname }" flname="${emp.emp_sno}"  value="<s:property value="#emp.emp_nid"/>"/>
    	 <input type="hidden"  id="kstat" name="form.emp_sisvalid" value="<s:property value="#emp.emp_sisvalid"/>"/>
          </div></td>
				        <td height="20"><div align="center"><s:property value="#s.index + 1"/></div></td>
				        <td height="20" title="${emp.sh_sname}"><div align="center"><s:property value="#emp.sh_sname"/></div></td>
<%--				        <td height="20"title="${emp.ud_sname}"><div align="center"><s:property value="#emp.ud_sname"/></div></td>--%>
				        <td height="20"title="${emp.ud_sname1}"><div align="center"><s:property value="#emp.ud_sname1"/></div></td>
				        <td height="20"title="${emp.ud_sname2}"><div align="center"><s:property value="#emp.ud_sname2"/></div></td>
				        <td height="20"title="${emp.emp_sno}"><div align="center"><s:property value="#emp.emp_sno"/></div></td>
				        <td height="20"title="${emp.emp_sname}"><div align="center"><s:property value="#emp.emp_sname"/></div></td> 
				        <td height="20"title="${emp.emp_sename}"><div align="center"><s:property value="#emp.emp_sename"/></div></td>
				        <td height="20"><div align="center">
				        <s:if test="#emp.emp_sgender==1"> 男	 </s:if>
				        <s:if test="#emp.emp_sgender==0"> 女 </s:if>
				        </div></td>
				        <td height="20" title="${emp.xlsname}"><div align="center">${emp.xlsname}</div></td>
				        <td height="20" title="${emp.emp_stele}"><div align="center"><s:property value="#emp.emp_stele"/></div></td>
				        <td height="20"title="${emp.emp_steleinner}"><div align="center"><s:property value="#emp.emp_steleinner"/></div></td> 
				        <td height="20"title="${emp.emp_steleout}"><div align="center"><s:property value="#emp.emp_steleout"/></div></td>
				        <td height="20"title="${emp.emp_sfax}"><div align="center"><s:property value="#emp.emp_sfax"/></div></td>
				        <td height="20"title="${emp.emp_semail}"><div align="center"><s:property value="#emp.emp_semail"/></div></td>
				        <td height="20" title="<s:date name="#emp.emp_dintime" format="yyyy-MM-dd"/>"><div align="center"><s:date name="#emp.emp_dintime" format="yyyy-MM-dd"/></div></td>
				        <td height="20"title="${emp.job_sname}"><div align="center"><s:property value="#emp.job_sname"/></div></td>
				        <td height="20"title="${emp.post_sname}"><div align="center"><s:property value="#emp.post_sname"/></div></td> 
				        <td height="20"title="${emp.lvesname}"><div align="center"><s:property value="#emp.lvesname"/></div></td> 
				    
				        <td height="20"><div align="center">
				        <s:if test="#emp.emp_nstate==0">在职</s:if>
				        <s:if test="#emp.emp_nstate==1">离职</s:if>
				        <s:if test="#emp.emp_nstate==2">停薪留职</s:if>
				        <s:if test="#emp.emp_nstate==3">退休</s:if>
				        <s:if test="#emp.emp_nstate==4">反聘</s:if>
				        <s:if test="#emp.emp_nstate==5">全职外聘</s:if>
				        <s:if test="#emp.emp_nstate==6">兼职</s:if>
				        <s:if test="#emp.emp_nstate==7">挂职</s:if>
				        <s:if test="#emp.emp_nstate==8">客座</s:if>
				        <s:if test="#emp.emp_nstate==9">去逝</s:if>
				       
				        </div></td> 
				        <td height="20"><div align="center">
				          <s:if test="#emp.emp_sisvalid==0">启用</s:if>
				        <s:if test="#emp.emp_sisvalid==1">不启用</s:if>
				        </div></td> 
				      </tr>
				     </s:iterator>
         </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/emp!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		<input type="hidden" id="empsno" name="form.emp_sno" value=""/>
<input type="hidden" id="empsname" name="form.emp_sname" value=""/>
</form>
</body>
</html>
   