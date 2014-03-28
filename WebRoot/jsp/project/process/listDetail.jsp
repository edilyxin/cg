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
			<span><%-- <s:property value="#session.navbar"/> --%>执行过程管理</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;项目编号:
                <input type="text" name="searchA" id="searchA" value="${form.searchA}" />
                <input type="hidden" name="form.searchA" id="searchA1" value="${form.searchA}" />
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
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">项目明细信息列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
														<s:if test="#session.operList.get(\"020402\")!=null">
              											<a title="修改" href="javascript:void(0)" onclick="toUpdate()">
 														  <img  src="<%=path%>/<s:property value="#session.operList.get(\"020402\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020402\").oper_sname"/>             											
              											 </span></a>&nbsp;
              											</s:if>
              						</span></td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
<!-- 	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
        </th> -->
        
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">项目编号</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">包编号</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">采购方式</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">工作名称</span></div></th> 
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作页面</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作人</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作时间</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></th>
      </tr>
     <s:iterator value="list"  id="li" status="st"> 
     <s:iterator id="sli" value="#li.packageList" status="st2">
      <tr bgcolor="#FFFFFF" <s:if test="#li.SS_SISVALID==\"1\"">style="color:red;"</s:if>>
      	<s:if test="#st2.First">
        	 	<td height="20" rowspan="${li.packageList.size() }"><div align="center">
        	 	${li.EP_SNO}
        		</div></td> 
        	 </s:if>
      	<td height="20"   title="${sli.BG_SNO}">${sli.BG_SNO}</td>
        <td height="20"   title="${sli.BG_NPURTYPE}">
        	<s:if test="#sli.BG_NPURTYPE==0">招标采购</s:if>
        	<s:if test="#sli.BG_NPURTYPE==1">集中采购</s:if>
        	<s:if test="#sli.BG_NPURTYPE==2">自行采购</s:if>
		</td>
        <td height="20"   title="${sli.process.setting.SET_SNAME}">
        	<s:if test="#sli.BG_NPURTYPE==1">
        		<a href="<%=path%>/${sli.process.setting.SET_SPAGE}?set_nid=${sli.process.setting.SET_NID}&ss_nid=${sli.process.SS_NID}&set_nno=${sli.process.setting.SET_NNO}&bg_sno=${sli.BG_SNO}&ep_sno=${li.EP_SNO}&set_spurtype=${sli.process.setting.SET_SPURTYPE}">
        			${sli.process.setting.SET_SNAME}
        		</a>
        	</s:if>
        	<s:else>
        		<a href="<%=path%>/${sli.process.setting.SET_SPAGE}?set_nid=${sli.process.setting.SET_NID}&ss_nid=${sli.process.SS_NID}&set_nno=${sli.process.setting.SET_NNO}&bg_sno=${sli.BG_SNO}&ep_sno=${li.EP_SNO}&set_spurtype=${sli.process.setting.SET_SPURTYPE}">
        			${sli.process.setting.SET_SNAME}
        		</a>
        	</s:else>
        	&nbsp;&nbsp;
        	<s:if test="#sli.process.setting.SET_NNO!=1">
        		<a href="<%=path%>/process!back?set_nid=${sli.process.setting.SET_NID}&ss_nid=${sli.process.SS_NID}&set_nno=${sli.process.setting.SET_NNO}&bg_sno=${sli.BG_SNO}&ep_sno=${li.EP_SNO}&set_spurtype=${sli.process.setting.SET_SPURTYPE}">回退</a>      		
        	</s:if>
        	<a href="<%=path%>/paymoney!toDetail?set_nid=${sli.process.setting.SET_NID}&ss_nid=${sli.process.SS_NID}&set_nno=${sli.process.setting.SET_NNO}&bg_sno=${sli.BG_SNO}&ep_sno=${li.EP_SNO}&set_spurtype=${sli.process.setting.SET_SPURTYPE}">
        			test
        		</a>
        </td>
        <td height="20"   title="${sli.process.setting.SET_SPAGE}">
        	<a href="<%=path%>/${sli.process.setting.SET_SPAGE}">${sli.process.setting.SET_SPAGE}</a>
        </td>
        <td height="20"   title="${sli.process.SS_SMAN}">${sli.process.SS_SMAN}</td>
        <td height="20"  title="${sli.process.SS_TDATE}">${sli.process.SS_TDATE}</td>
        <td height="20"   title="${sli.process.SS_SREMARK}">${sli.process.SS_SREMARK}</td>
      </tr>
      </s:iterator>
      </s:iterator>
   </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<%-- <s:if test="list.size()!=0">
							<page:page uri="/process!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信！</strong></span></div>
						</s:elseif> --%>
		 
<!-- 分页标签END -->
   		</div>
		</div>
	<div><h1>招标采购</h1><br />
		
		<a href="<%=path%>/process!toFirsttrial">初审技术参数</a><br />
		<a href="<%=path%>/bid!toAdd">招标公示</a><br />
		<a href="<%=path%>/bidwin!toAdd">录入中标结果公示</a>	<br />	
		</div>
		<div>
		<h1>集中采购</h1><br />
		<a href="<%=path%>/splite!toSelectsupplier">确定供应商</a><br />
		</div>
		<div>
		<a href="<%=path%>/contract!toAdd">签订合同</a><br />
		<a href="<%=path%>/paymoney!toAddreceivable">支付（应收）</a><br />
		<a href="<%=path%>/paymoney!toAddpayable">支付（应付）</a><br />
		<a href="<%=path%>/mail!toSendMail">发电邮</a><br />
		</div>
</form>
</body>
</html>
  