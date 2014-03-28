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
<title>采购执行人流程设置</title> 
<script>
  //查询
  function findInfo(){
  input_trim();
  document.getElementById("searchA1").value=document.getElementById("searchA").value;
  document.form1.action="<%=path%>/history!find";
  document.all.form1.submit();
}
  //新增
  function toAdd(){
	document.form1.action="<%=path%>/history!toAdd";
	document.form1.submit();

}
 //修改
 function toUpdate(){
  var obj1=document.getElementsByName("setSIsValid");
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
		document.form1.action="<%=path%>/history!toUpdate";
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
 var obj1=document.getElementsByName("setSIsValid");
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
		document.form1.action="<%=path%>/history!toDelete";
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
			document.form1.action="<%=path%>/history!changeValid";
			document.form1.submit();
		 }
  }  
 

</script>

</head>

<body>

<form name="form1" method="post" action="<%=path %>/history!list">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;采购方式:
                <select name="searchA" id="searchA" style="width:145;">
    				<option value="" selected></option>
    				<%-- <s:iterator value="list1" var="job" status="s">
    				<option value="${job.post_nlevel}" <s:if test="form.searchC==#job.post_nlevel">selected</s:if>>${job.post_nlevel}级</option>    
    				</s:iterator>    --%> 
    				</select>
                </span>                
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="findInfo()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
                  
                  <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
                </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">流程列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
					       								<s:if test="#session.operList.get(\"020401\")!=null">
														<a title="新增" href="javascript:void(0);" onclick="toAdd()" >
														  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020401\").oper_sname"/>
														</span></a>&nbsp; 
														</s:if>
														<s:if test="#session.operList.get(\"020402\")!=null">
              											<a title="修改" href="javascript:void(0)" onclick="toUpdate()">
 														  <img  src="<%=path%>/<s:property value="#session.operList.get(\"020402\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020402\").oper_sname"/>             											
              											 </span></a>&nbsp;
              											</s:if>
              											<s:if test="#session.operList.get(\"020403\")!=null">
              											<a title="删除" href="javascript:void(0)" onclick="del();">
              											  <img  src="<%=path%>/<s:property value="#session.operList.get(\"020403\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020403\").oper_sname"/> 
														   </span></a>&nbsp;
              											</s:if>
              											<s:if test="#session.operList.get(\"020404\")!=null">
              											<a title="有效/无效" href="javascript:void(0)" onclick="changeValid();">
              											  <img  src="<%=path%>/<s:property value="#session.operList.get(\"020404\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020404\").oper_sname"/> 
														   </span></a>&nbsp;
              											</s:if>
              						</span></td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
        </th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">项目编号</span></div></th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">包编号 </span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">顺序号</span></div></th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">采购方式</span></div></th> 
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">工作名称</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作人</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作时间</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></th>	
      </tr>
      <s:iterator value="list"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" <s:if test="#li.SS_SISVALID==\"1\"">style="color:red;"</s:if>>
        <td height="20" ><div align="center">
          <input type="checkbox" name="idcheckbox" onclick="checkOne();"  value="${li.SS_NID}" />
          <input type="hidden" id="setSIsValid" name="setSIsValid" value="${li.SS_SISVALID}"/>
        </div></td>
        <td height="20"  >${st.index+1}</td>
        <td height="20"   title="${li.EP_SNO}">${li.EP_SNO}</td>
        <td height="20"   title="${li.BG_SNO}">${li.BG_SNO}</td>
        <td height="20"   title="${li.SS_NNO}">${li.SS_NNO}</td>
        <td height="20"   title="${li.SS_SPURTYPE}">
	        ${li.SS_SPURTYPE}
        </td>
        <td height="20"  title="${li.SS_SNAME}">${li.SS_SNAME}</td>
        <td height="20"   title="${li.SS_TDATE}">${li.SS_TDATE}
	    </td>
        <td height="20"   title="${li.SS_SREMARK}">${li.SS_SREMARK}</td>
      </tr>
      </s:iterator>
   </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/history!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
</form>
</body>
</html>
  