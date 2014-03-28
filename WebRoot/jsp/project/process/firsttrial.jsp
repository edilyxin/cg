<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String urlparams = "ss_nid="+request.getParameter("ss_nid")+
					"&set_nno="+request.getParameter("set_nno")+
					"&bg_sno="+request.getParameter("bg_sno")+
					"&ep_sno="+request.getParameter("ep_sno")+
					"&set_spurtype="+request.getParameter("set_spurtype")+
					"&set_nid="+request.getParameter("set_nid");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>初审技术参数</title> 
<script>
	//回退
	function back(){
		document.form1.action="<%=path%>/process!back?<%=urlparams%>";
		document.form1.submit();
	}
	function print(){
		document.form1.action="<%=path%>/process!toPrint";
		document.form1.submit();
	}
	//提交
	function sub(){
		alert("<%=urlparams%>");
		document.form1.action="<%=path%>/process!firsttrial?<%=urlparams%>";
		document.form1.submit();
	}
  function showParams(index){
	  var name = "hid"+index;	  
	  var text = $(":hidden[name="+name+"]").val();
	  $("#params").val(text);
  }  
  //新增
  function toAdd(){
	document.form1.action="<%=path%>/setting!toAdd";
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
		document.form1.action="<%=path%>/setting!toUpdate";
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
		document.form1.action="<%=path%>/setting!toDelete";
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
			document.form1.action="<%=path%>/setting!changeValid";
			document.form1.submit();
		 }
  }  
 

</script>

</head>

<body>

<form name="form1" method="post" action="<%=path %>/setting!list">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
               <a href="javascript:void(0);">查看项目进口申请表</a>&nbsp; &nbsp; 
               <a href="javascript:void(0);">批量导出技术参数</a>
               </span>
                </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">包信息列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<%-- <span class="STYLE1"   style="white-space:nowrap;">
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
              						</span> --%></td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">包名称</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">分包明细</span></div></th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位 </span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定单价</span></div></th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定数量</span></div></th> 
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定总金额</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否进口</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否免税</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">技术参数</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">免税申请表</span></div></th>	
      </tr>
      
      <tr>
      	<td>1</td>
      	<td rowspan="2">是了的空间发了</td>
      	<td>阿勒快减肥啦</td>
      	<td>个</td>
      	<td>10.00</td>
      	<td>100</td>
      	<td>1000.00</td>
      	<td>是</td>
      	<td>否</td>
      	<td><a href="#" onclick="showParams('1')">查看</a>&nbsp; <a>打印</a><input name="hid1" type="hidden" value="1111" /></td>
      	<td>查看</td>
      </tr>
      <tr>
      	<td>1</td>
      	<td>阿勒快减肥啦</td>
      	<td>个</td>
      	<td>10.00</td>
      	<td>100</td>
      	<td>1000.00</td>
      	<td>是</td>
      	<td>否</td>
      	<td>查看</td>
      	<td>查看</td>
      </tr>
     <%--  <s:iterator value="list"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" <s:if test="#li.SET_SISVALID==\"1\"">style="color:red;"</s:if>>
        <td height="20" ><div align="center">
          <input type="checkbox" name="idcheckbox" onclick="checkOne();"  value="${li.SET_NID}" />
          <input type="hidden" id="setSIsValid" name="setSIsValid" value="${li.SET_SISVALID}"/>
        </div></td>
        <td height="20"  >${st.index+1}</td>
        <td height="20"   title="${li.SET_SPERSONTYPE}">
        	<s:if test='%{#li.SET_SPERSONTYPE=="0"}'>招标采购</s:if>
        	<s:if test='%{#li.SET_SPERSONTYPE=="1"}'>集中采购</s:if>
        	<s:if test='%{#li.SET_SPERSONTYPE=="2"}'>自行采购</s:if>
        </td>
        <td height="20"   title="${li.SET_NNO}">${li.SET_NNO}</td>
        <td height="20"   title="${li.SET_SNAME}">${li.SET_SNAME}</td>
        <td height="20"   title="${li.SET_NWORK}">
	        ${li.SET_NWORK}
        </td>
        <td height="20"  title="${li.SET_SPAGE}">${li.SET_SPAGE}</td>
        <td height="20"   title="${li.SET_SPERSONTYPE}">
        	<s:if test='%{#li.SET_SPERSONTYPE=="0"}'>项目负责人</s:if>
	        <s:if test='%{#li.SET_SPERSONTYPE=="1"}'>采购人员</s:if>
	    </td>
        <td height="20"   title="${li.SET_SREMARK}">${li.SET_SREMARK}</td>
        <td height="20"  >
           <s:if test='%{#li.SET_SISVALID=="0"}'>有效</s:if>
	       <s:if test='%{#li.SET_SISVALID=="1"}'>无效</s:if>     
        </td>        
      </tr>
      </s:iterator> --%>
   </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/post!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
   		<div class=content>
   			<table width="100%">
   				<tr>
   					<td>技术参数</td>
   				</tr>
   				<tr>
   					<td><textarea id="params" rows="6" cols="" readonly="readonly" style="width: 100%"></textarea></td>
   				</tr>
   				<tr><td height="20"></td></tr>
   				<tr>
   					<td>退回备注</td>
   				</tr>
   				<tr>
   					<td><textarea rows="6" cols="" style="width: 100%"></textarea></td>
   				</tr>
   			</table>
   			<table width=100%>
   				<tr>
   					<td align="right"><input onclick="back()" type=button value="退回项目负责人"/></td>
   					<td width=20></td>
   					<td align=left><input onclick="sub()" type=button value="确定"/></td>
   					<td width=20></td>
   					<td align=left><input onclick="print()" type=button value="打印技术参数"/></td>
   				</tr>
   			</table>
   		</div>
		</div>
</form>
</body>
</html>
  

<a href="<%=path%>/process!back">退回项目负责人，重新修改</a>
<br />
<a href="<%=path%>/process!toPrint">打印技术参数，发标公司</a>