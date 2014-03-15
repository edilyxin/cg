<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>功能信息管理</title>
<script type="text/javascript">
function find() {
input_trim();
	document.form1.action="<%=path%>/right!find";
	document.form1.submit();
}
function toAdd(){
	document.form1.action="<%=path%>/right!toAdd";
	document.form1.submit();
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
		document.form1.action="<%=path%>/right!toUpdate";
		document.form1.submit();
	 }
}
 function del() {
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
	 var checked = $("input[name='idcheckbox']:checked");
	 var arr = new Array();
	 checked.each(function(){
		var isvalid = $(this).attr("isvalid");
		if (isvalid == "0") {
			$(this).attr("checked", false);
			$("#checkbox").attr("checked", false);
			arr.push($(this).val());
		}
	 });
	 if (arr.length > 0) {
		 alert("有效的记录无法删除，已取消选中！");
	 }
	 checked = $("input[name='idcheckbox']:checked");
	 if (checked.length > 0 && confirm("是否删除所选记录？")) {
		 $.post("<%=path%>/right!toDelete",
					$("#form1").serialize(),
					function(data) {
						if (data != "") {
							alert(data);
						}else{
							document.form1.action="<%=path%>/right!find?page=${bean.currentPage}";
							document.form1.submit();
						}
					},"json");
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
			$.post("<%=path%>/right!changeValid",
					$("#form1").serialize(),
					function(data){
						if (data != "") {
							alert(data);
						}else{
							document.form1.action="<%=path%>/right!find?page=${bean.currentPage}";
							document.form1.submit();
						}
					},"json");
		 }
	  }
 
 function lookOper() {
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
	 var right_nmorb = $("input[name='idcheckbox']:checked").attr("isMenu");
	 if (right_nmorb == "0") {
		 alert("请选择一个功能");
		 return;
	 }
	 var sys_right = $("input[name='idcheckbox']:checked").val();
	 var sysint_sno = sys_right.split(":")[0];
	 var right_sno = sys_right.split(":")[1];
	 var rightName = $("input[name='idcheckbox']:checked").attr("rightName");
	 var sysintName = $("input[name='idcheckbox']:checked").attr("sysintName");
	 var url="<%=path%>/rightOper!find?form.right_sno=" + right_sno + "&form.sysint_sno=" + sysint_sno;
	 var whObj = {width:"1000px", height:"500px"};
	 var paramObj = {
			 "right_sname" : rightName,
			 "sysint_sname" : sysintName,
			 "sign":1
	 };
	 openShowModalDialog(url, paramObj, whObj);
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
	
 $(function(){
getSysSelect('<s:property value="form.searchA"/>','sysint_sno','<%=path %>');
});
	 
</script>
</head>
<body>
<form name="form1" id="form1" method="post" >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
               	<span  style="white-space:nowrap;">&nbsp;&nbsp;系统名称:
               	<select name="form.searchA" id="sysint_sno" style="width:120px;"></select></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;功能名称:
				  <input type="text" name="form.searchB" value="${form.searchB}" size="12"/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;上级功能名称:
				<input type="text" name="form.searchC" value="${form.searchC}" size="12"/>
				</span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
				
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">功能信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	<span class="STYLE1" style="white-space:nowrap;">
						<s:if test="#session.operList.get(\"010201\")!=null">
							<a title="新增" href="javascript:void(0);" onclick="toAdd();return false;">
								<img src="<%=path%>/<s:property value="#session.operList.get(\"010201\").oper_simg"/>" width="10" height="10" border="0"/> 
								<span class="STYLE1"><s:property value="#session.operList.get(\"010201\").oper_sname"/></span>
							</a>
						</s:if>
						<s:if test="#session.operList.get(\"010202\")!=null">
	      					<a title="修改" href="javascript:void(0);" onclick="toUpdate();return false;">
	      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010202\").oper_simg"/>" width="10" height="10" border="0"/>
								<span class="STYLE1"><s:property value="#session.operList.get(\"010202\").oper_sname"/></span>
							</a>
						</s:if>
						<s:if test="#session.operList.get(\"010203\")!=null">
	      					<a title="删除" href="javascript:void(0);" onclick="del();">
	      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010203\").oper_simg"/>" width="10" height="10" border="0"/> 
	      						<span class="STYLE1"><s:property value="#session.operList.get(\"010203\").oper_sname"/></span>
	      					</a>
	      				</s:if>
	      				<s:if test="#session.operList.get(\"010204\")!=null">
		            		<a title="有效/无效" href="javascript:void(0);" onclick="changeValid();">
		            			<img src="<%=path%>/<s:property value="#session.operList.get(\"010204\").oper_simg"/>" width="10" height="10" border="0"/> 
		            				<span class="STYLE1"><s:property value="#session.operList.get(\"010204\").oper_sname"/></span>
		            		</a>
		            	</s:if>
					</span>
					<span class="STYLE1" style="white-space:nowrap;">
						<s:if test="#session.operList.get(\"010205\")!=null">
							<a title="下载模板" href="javascript:void(0);" onclick="downloadTemp('mng_right');">
								<img src="<%=path%>/<s:property value="#session.operList.get(\"010205\").oper_simg"/>" width="10" height="10" border="0"/> 
								<span class="STYLE1"><s:property value="#session.operList.get(\"010205\").oper_sname"/></span>
							</a>
						</s:if>
						<s:if test="#session.operList.get(\"010206\")!=null">
	      					<a title="导入" href="javascript:void(0);" onclick="importExcel();">
	      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010206\").oper_simg"/>" width="10" height="10" border="0"/>
								<span class="STYLE1"><s:property value="#session.operList.get(\"010206\").oper_sname"/></span>
							</a>
						</s:if>
						<s:if test="#session.operList.get(\"010207\")!=null">
	      					<a title="功能操作" href="javascript:void(0);" onclick="lookOper();">
	      						<img src="<%=path%>/<s:property value="#session.operList.get(\"010207\").oper_simg"/>" width="10" height="10" border="0"/> 
	      						<span class="STYLE1"><s:property value="#session.operList.get(\"010207\").oper_sname"/></span>
	      					</a>
	      				</s:if>
	      				<s:if test="#session.operList.get(\"010208\")!=null">
		            		<a title="功能排序" href="<%=path %>/right!toOrder">
		            			<img src="<%=path%>/<s:property value="#session.operList.get(\"010208\").oper_simg"/>" width="10" height="10" border="0"/> 
		            				<span class="STYLE1"><s:property value="#session.operList.get(\"010208\").oper_sname"/></span>
		            		</a>
		            	</s:if>
					</span>
	           </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="1300px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF" class="STYLE10">
	  	<th width="40px" height="20" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
	  	</th>
	  	<th width="40px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
	  	<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">上级功能</span></div></th>
		<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">功能编号</span></div></th>
		<th width="120px"  height="20" class="STYLE6"><div align="center"><span class="STYLE10">功能名称</span></div></th>
		<th width="200px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">功能地址</span></div></th>
	  	<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">功能级别</span></div></th>
		<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否菜单</span></div></th>
		<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否末级</span></div></th>
		<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否可用</span></div></th>
		<th width="80px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否有效</span></div></th>
		<th height="20" class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></th>
		</tr>
		
		<s:iterator value="list" var="right" status="st">
		<tr bgcolor="#ffffff" align="center" class="STYLE19" <s:if test="#right.right_sisvalid==\"1\"">style="color:red;"</s:if>>
 		<td height="20"><input name="idcheckbox"  type="checkbox" value="${right.sysint_sno}:${right.right_sno}:${right.sysint_sname}:${right.right_sname}" isMenu="${right.right_nmorb }" rightName="${right.right_sname}" sysintName="${right.sysint_sname}" isvalid="${right.right_sisvalid}" onclick="checkOne();" /></td>

 		 <td><s:property value="#st.index + 1"/></td>
			<td title="${right.sysint_sname}">${right.sysint_sname}</td>
	        <td title="${right.right_sparentname}">${right.right_sparentname}</td>
			<td title="${right.right_sno}">${right.right_sno}</td>
			<td title="${right.right_sname}">${right.right_sname}</td>
	        <td title="${right.right_smenuurl}">${right.right_smenuurl}</td>
	        <td title="${right.right_ndef1}">${right.right_ndef1}</td>
             <td >
              	<s:if test="#right.right_nmorb == \"0\"">菜单</s:if>
              	<s:if test="#right.right_nmorb == \"1\"">非菜单</s:if>
              </td>
              <td>
              	<s:if test="#right.right_sisend == \"0\"">末级</s:if>
              	<s:if test="#right.right_sisend == \"1\"">非末级</s:if>
              </td>
              <td>
              	<s:if test="#right.right_sisuse == \"0\"">可用</s:if>
              	<s:if test="#right.right_sisuse == \"1\"">不可用</s:if>
              </td>
              <td>
              	<s:if test="#right.right_sisvalid == \"0\"">有效</s:if>
              	<s:if test="#right.right_sisvalid == \"1\"">无效</s:if>
              </td>
              <td title="${right.right_sdesc}">
		          ${right.right_sdesc} 
              </td>
		</tr>	
		</s:iterator>	
    </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/right!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
</form>
</body>
</html>
    