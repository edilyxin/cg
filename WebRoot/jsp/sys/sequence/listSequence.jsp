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
<title>编码管理</title> 

<script>
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
	 if(confirm("是否修改？")) 
	 {
		document.form1.action="<%=path%>/seq!toUpdate";
		document.form1.submit();
	 }
	
}
    //删除
   function del(){
 var obj1=document.getElementsByName("seq_sisvalid");
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
			  	    alert("只能对无效状态信息删除!");
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
  	    alert("只能对无效状态信息删除!");
  	    return;
  	 }
	 if(confirm("是否删除所选记录？"))
	 {
		document.form1.action="<%=path%>/seq!toDelete";
		document.form1.submit();
	 }
  }

function toAdd(){
	$("#form1").attr("action","<%=path%>/seq!toAdd");
	$("#form1").submit();
}

function changeValid(){
  if(confirm("是否修改所选记录状态？"))
	{
	$("#form1").attr("action","<%=path%>/seq!changeValid?page=${bean.currentPage}");
	$("#form1").submit();
	}
}
function find(){
	input_trim();
	document.getElementById("searchA").value=document.getElementById("searchA1").value;
	document.getElementById("searchB").value=document.getElementById("searchB1").value;
	document.getElementById("searchC").value=document.getElementById("searchC1").value;
	$("#form1").attr("action","<%=path%>/seq!find");
	$("#form1").submit();
}
 $(function(){
getSysSelect('<s:property value="form.searchA"/>','searchA1','<%=path %>');
});
</script>
</head>

<body  >
<form name="form1"  id="form1"   method="post"  >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>系统管理 &gt; 编码管理</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
  				<span style="white-space:nowrap;">&nbsp;&nbsp;系统名称:
				<select name="searchA1" id="searchA1" style="width:120px;"></select></span>
  				<span style="white-space:nowrap;">&nbsp;&nbsp;编码代码:<input type="text" name="searchB1" value="${form.searchB}" size="12"/></span>
                <span style="white-space:nowrap;">&nbsp;&nbsp;编码名称:<input type="text" name="searchC1" value="${form.searchC}" size="12"/></span>
                <span style="white-space:nowrap;">&nbsp;&nbsp;
               	<a href="javascript:void(0);"  onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/>查询</a></span>
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">编码信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" > 
	        <span class="STYLE1" style="white-space:nowrap;">    	
			<a href="javascript:void(0);" onclick="toAdd()" ><img src="<%=path %>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">新增</span></a>
			<a href="javascript:void(0);" onclick="toUpdate();"><img src="<%=path %>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">修改</span></a>
			<a href="javascript:void(0);" onclick="del();"><img src="<%=path %>/images/del_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">删除</span></a>
			<a href="javascript:void(0);" onclick="changeValid()"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">有效/无效</span></a>&nbsp;</span>
	          </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="20"  class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
	  	</th>
	  	<th width="40px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
	  	<th width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></th>
	  	<th width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">编码代码</span></div></th>
		<th width="120px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">编码名称</span></div></th>
		<th width="120px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">当前值</span></div></th>
		<th width="100px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">前缀</span></div></th>
		<th width="100px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">后缀</span></div></th>
		<th width="100px"  height="20"  class="STYLE6"><div align="center"><span class="STYLE10">流水号</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">步长</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">编码方式</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">年份格式</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">月份格式</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">日期格式</span></div></th>
		<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否有效</span></div></th>
		<th height="20"  class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></th>
		</tr>
		
		<s:iterator value="list" var="v" status="s">
      	<tr bgcolor="#FFFFFF" align="center" class="STYLE19" <s:if test="#v.seq_sisvalid==\"1\"">style="color:red;"</s:if> >
        <th><input type="checkbox" name="idcheckbox" value="${v.seq_nid}" onclick="checkOne();"   />
        <input type="hidden" id="seq_sisvalid" name="seq_sisvalid" value="${v.seq_sisvalid}"/>
        </th>
        
        <td>${s.index+1}</td>
        <td title="${v.sysint_sname}">${v.sysint_sname}</td>
        <td title="${v.seq_sname}">${v.seq_sname}</td> 
        <td title="${v.seq_sdisname}">${v.seq_sdisname}</td>
        <td title="${v.seq_scurvalue}">${v.seq_scurvalue}</td>
        <td title="${v.seq_sprefix}">${v.seq_sprefix}</td>
        <td title="${v.seq_ssuffix}">${v.seq_ssuffix}</td>
        <td title="${v.seq_nvalue}">${v.seq_nvalue}</td>
        <td title="${v.seq_nstep}">${v.seq_nstep}</td> 
        <td title="${v.seq_scurvalue}进制">${v.seq_ntype}进制</td>
        <td title="<s:if test="#v.seq_nyear==\"0\"">不显示</s:if><s:elseif test="#v.seq_nyear==\"2\"">两位年份</s:elseif><s:elseif test="#v.seq_nyear==\"4\"">四位年份</s:elseif>">
        	<s:if test="#v.seq_nyear==\"0\"">不显示</s:if><s:elseif test="#v.seq_nyear==\"2\"">两位年份</s:elseif><s:elseif test="#v.seq_nyear==\"4\"">四位年份</s:elseif></td>
        <td title="<s:if test="#v.seq_nmonth==\"0\"">不显示</s:if><s:elseif test="#v.seq_nmonth==\"2\"">两位月份</s:elseif>">
        	<s:if test="#v.seq_nmonth==\"0\"">不显示</s:if><s:elseif test="#v.seq_nmonth==\"2\"">两位月份</s:elseif></td>
        <td title="<s:if test="#v.seq_nday==\"0\"">不显示</s:if><s:elseif test="#v.seq_nday==\"2\"">两位日期</s:elseif>">
        	<s:if test="#v.seq_nday==\"0\"">不显示</s:if><s:elseif test="#v.seq_nday==\"2\"">两位日期</s:elseif></td>
        <td title="<s:if test="#v.seq_sisvalid==\"0\"">有效</s:if><s:elseif test="#v.seq_sisvalid==\"1\"">无效</s:elseif>">
        	<s:if test="#v.seq_sisvalid==\"0\"">有效</s:if><s:elseif test="#v.seq_sisvalid==\"1\"">无效</s:elseif></td>
        <td title="${v.seq_sdesc}">${v.seq_sdesc}</td> 
      </tr>
      </s:iterator> 
    </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
			<s:if test="list.size()!=0">
				<page:page uri="/seq!find"></page:page>
			</s:if>
			<s:elseif test="list.size()==0">
				<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
			</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		<input type="hidden" name="form.searchA" id="searchA" value="${form.searchA}"/>
  		<input type="hidden" name="form.searchB" id="searchB" value="${form.searchB}"/>
  		<input type="hidden" name="form.searchC" id="searchC" value="${form.searchC}"/>
</form>
</body>
</html>
    
 