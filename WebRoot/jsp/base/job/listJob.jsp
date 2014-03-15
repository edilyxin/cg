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
function findInfo(){
input_trim();
/* document.getElementById("searchA1").value=document.getElementById("searchA").value;*/
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;
 document.all.form1.submit();
}
function toAdd(){
	document.form1.action="<%=path%>/job!toAdd";
	document.form1.submit();
}
 function toUpdate(){
  var obj1=document.getElementsByName("job_sisvalid");
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
				if(obj1[knum].value==0)
			  	 {
			  
			  	 }else{
			  	    alert("只能对启用状态信息修改!");
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
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？"))
	 {
		document.form1.action="<%=path%>/job!toUpdate";
		document.form1.submit();
	 }	
  }
  
 function del(){
 var obj1=document.getElementsByName("job_sisvalid");
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
		document.form1.action="<%=path%>/job!toDelete";
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
		document.form1.action="<%=path%>/job!changeValid";
		document.form1.submit();
	 }
  }    
 	function toImport() {
		 var url = "importUnitDepart.jsp";
		 var whObj = { width:"1000px", height:"500px" };
		 openShowModalDialog(url,"",whObj);
	 }

	

</script>

  </head>
  
 <body >

<form name="form1" method="post" action="<%=path %>/job!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
    <span  style="white-space:nowrap;">&nbsp;&nbsp;所属单位:
              
                  <s:if test="menu != \"0\"">
                  <input type="text"   id="searchA"  name="form.searchA"  value="${form.searchA}" readonly   />
                  <input type="button" class="select_button" onclick="unitDepartTree('ud_sno','searchA');" />
              <input type="hidden" id="ud_sno"  name="form.ud_sno"  value="${form.ud_sno}">
                  </s:if>
                  <s:if test="menu == \"0\"">
                  <input type="text" name="form.searchA" id="searchA" value="${form.searchA}" readonly style="background:#EEE;"/>
                  </s:if>
                  </span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;岗位编号:
				  <input type="text" id="searchB" name="searchB" value="${form.searchB}" <s:if test="menu == \"0\"">readonly style="background:#EEE;"</s:if>/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;岗位名称:
				<input type="text" id="searchC" name="searchC" value="${form.searchC}" <s:if test="menu == \"0\"">readonly style="background:#EEE;"</s:if>/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;岗位等级:
				<select name="form.searchD" id="searchD" style="width:145;">
	
    <option value="" selected></option>
    
    <s:iterator value="list1" var="job" status="s">
        
    <option value="${job.job_nlevel}" <s:if test="form.searchD==#job.job_nlevel">selected</s:if>>${job.job_nlevel}级</option>
    
    </s:iterator>
    
    </select>&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="findInfo()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
				 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">岗位信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
					<span class="STYLE1">
            <s:if test="#session.operList.get(\"020301\")!=null"><a title="新增" href="javascript:void(0);" onclick="toAdd();"><img src="<%=path %>/<s:property value="#session.operList.get(\"020301\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020301\").oper_sname"/></span></a>&nbsp; </s:if>
           <s:if test="#session.operList.get(\"020302\")!=null"><a title="修改" href="javascript:void(0);" onclick="toUpdate();"><img src="<%=path %>/<s:property value="#session.operList.get(\"020302\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020302\").oper_sname"/></span></a>&nbsp;</s:if>
            <s:if test="#session.operList.get(\"020303\")!=null"><a  title="删除" href="javascript:void(0);" onclick="del();"><img src="<%=path %>/<s:property value="#session.operList.get(\"020303\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020303\").oper_sname"/></span></a>&nbsp;&nbsp;</s:if>
            <s:if test="#session.operList.get(\"020304\")!=null"><a  title="有效/无效" href="javascript:void(0);" onclick="changeValid();"><img src="<%=path %>/<s:property value="#session.operList.get(\"020304\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020304\").oper_sname"/></span></a>&nbsp;</s:if>
           <s:if test="#session.operList.get(\"020305\")!=null"> <a  title="下载模板" href="javascript:void(0);" onclick="downloadTemp('mng_job');" ><img src="<%=path %>/<s:property value="#session.operList.get(\"020305\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020305\").oper_sname"/></span></a></s:if>
           <s:if test="#session.operList.get(\"020306\")!=null"> <a title="导入"  href="javascript:void(0);"  onclick="importExcel('岗位信息导入','job');"><img src="<%=path %>/<s:property value="#session.operList.get(\"020306\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020306\").oper_sname"/></span></a>&nbsp;</s:if>
           <s:if test="#session.operList.get(\"020307\")!=null"> <a  title="导出" href="javascript:void(0);"  onclick="exportExcel('job');"><img src="<%=path %>/<s:property value="#session.operList.get(\"020307\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1"><s:property value="#session.operList.get(\"020307\").oper_sname"/></span></a>&nbsp;</s:if>
          </span>
		  </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
     <table  width="1500" id ="table1" class="table"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      	<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="24" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
	  	</th>
	  	<th width="40px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">所属单位</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">岗位编号</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">岗位名称</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">岗位类别</span></div></th>
		<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">岗位级别</span></div></th>
		<th width="120px"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">住房面积数</span></div></th>
		<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">办公面积数</span></div></th>
		<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">房补金额数</span></div></th>
		<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">供暖补贴费</span></div></th>
		<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></th>
	    <th  height="20" class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></th>
		</tr>
      <s:iterator value="list" var="job" status="s">
        <tr bgcolor="#FFFFFF" align="center" class="STYLE19" <s:if test="#job.job_sisvalid==\"1\"">style="color:red;"</s:if>>
        <td height="20" > 
          <input type="checkbox" name="idcheckbox" id="idcheckbox" value="${job.job_sno}"   />
          <input type="hidden" id="job_sisvalid" name="job_sisvalid" value="${job.job_sisvalid}"/>
        </td>
        <td height="20"><s:property value="#s.index + 1" /></td>
        <td height="20" title="${job.ud_sname}">
 <s:if test="%{#job.ud_sname.length() <= 15}">${job.ud_sname}</s:if>
		<s:else><s:property value="%{#job.ud_sname.substring(0,15) + '...'}"/></s:else></td>
        <td height="20" title="${job.job_sno}">${job.job_sno}</td>
        <td height="20" title="${job.job_sname}">
<s:if test="%{#job.job_sname.length() <= 15}">${job.job_sname}</s:if>
		<s:else><s:property value="%{#job.job_sname.substring(0,15) + '...'}"/></s:else></td>
		 <td height="20" title="${job.job_stype}">${job.job_stype}</td>
        <td height="20" title="${job.job_nlevel}级">${job.job_nlevel}级</td>
        <td height="20" title="${job.job_nresarea}">${job.job_nresarea}</td>
        <td height="20" title="${job.job_noffarea}">${job.job_noffarea}</td> 
        <td height="20" title="${job_nhousmoney}">${job_nhousmoney}</td> 
        <td height="20" title="${job_nheatmoney}">${job_nheatmoney}</td>
          <td height="20">
        <s:if test='%{#job.job_sisvalid == "0"}'>有效</s:if>
		<s:if test='%{#job.job_sisvalid == "1"}'>无效</s:if>
	</td>   
        <td height="20" title="${job.job_smem}">
<s:if test="%{#job.job_smem.length() <= 15}">${job.job_smem}</s:if>
		<s:else><s:property value="%{#job.job_smem.substring(0,15) + '...'}"/></s:else></td> 
	</tr>
	</s:iterator>
	</table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/job!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
   		<input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>
		<input type="hidden"  name="menu" id="menu" value="<s:property value="menu"/>" /> 
</form>
</body>
</html>