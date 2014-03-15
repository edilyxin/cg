<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
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
<title>单位部门信息管理</title>
<script type="text/javascript">
function find() {
input_trim();
	document.forms[0].action="<%= path %>/unitDepart!find";
	document.forms[0].submit();
}
function toAdd() {
	document.forms[0].action="<%=path %>/unitDepart!toAdd";
	document.forms[0].submit();
}
function toUpdate()
{
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
	 if(confirm("是否修改？"))
	 {
		document.form1.action="<%=path%>/unitDepart!toUpdate";
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
		 if(confirm("是否删除？"))
		 {
			$.post("<%=path%>/unitDepart!toDelete",
					$("form[name='form1']").serialize(),
					function(data){
					if (data != "") {
						alert(data);
					}
					document.form1.action="<%=path%>/unitDepart!find?page=${bean.currentPage}";
					document.form1.submit();
				}, "json");
		 }
	 }
  
  	function changeValid() {
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
	 if(confirm("是否改变所选记录状态？"))
	 {
		$.post("<%=path%>/unitDepart!changeValid",
				$("form[name='form1']").serialize(),
				function(data){
				if (data != "") {
					alert(data);
				}
				document.form1.action="<%=path%>/unitDepart!find?page=${bean.currentPage}";
				document.form1.submit();
			}, "json");
	 }
  	}
	 
  	function setSchool() {
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
	 if(confirm("是否设置校区？"))
	 {
		var ud = $("input[name='idcheckbox']:checked");
		var url="<%=path%>/unitDepart!findSchool?udno=" + ud.val();
		var paramObj = {
				name: ud.attr("udname"),
				supername: ud.attr("supername")
				};
		var whObj = { width:"1000px", height:"600px" };
		openShowModalDialog(url,paramObj,whObj);
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
  	
 	
 $(function(){
getDictSelect("<s:property value="form.searchC"/>","searchC","ud_nnumber","","1","<%=path %>");
});
</script>
</head>

<body>
<form name="form1" method="post" action="<%= path %>/unitDepart!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
             	<span style="white-space:nowrap;">&nbsp;&nbsp;单位名称:
                <input type="text" name="form.searchA" id="searchA" value="${form.searchA}"  size="12" <s:if test="menu == \"0\"">readonly style="background:#EEE"</s:if>/></span>
				<span style="white-space:nowrap;">&nbsp;&nbsp;隶属单位:
				 <input type="text" name="form.searchB" value="${form.searchB}"  size="12" <s:if test="menu == \"0\"">readonly style="background:#EEE"</s:if>/></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;单位层次:
				<select name="form.searchC" id="searchC" <s:if test="menu == \"0\"">disabled</s:if> style="width:80px;"></select></span>
				
                <span  style="white-space:nowrap;">&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
				
			 </td>
		</tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">单位部门列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	  <span class="STYLE1" style="white-space:nowrap;">
		            	  <s:if test="#session.operList.get(\"020201\")!=null">
							<a title="新增" href="javascript:void(0);" onclick="toAdd()">
								<img src="<%=path %>/<s:property value="#session.operList.get(\"020201\").oper_simg"/>" width="10" height="10" border="0"/> 
								<span class="STYLE1"><s:property value="#session.operList.get(\"020201\").oper_sname"/></span></a>&nbsp; 
			    			</s:if>
			    			<s:if test="#session.operList.get(\"020202\")!=null">
			    			<a title="修改" href="javascript:void(0);" onclick="toUpdate();">
			    				<img src="<%=path %>/<s:property value="#session.operList.get(\"020202\").oper_simg"/>" width="10" height="10" border="0"/> 
			    				<span class="STYLE1"><s:property value="#session.operList.get(\"020202\").oper_sname"/></span></a>&nbsp;
			    			</s:if>
			    			<s:if test="#session.operList.get(\"020203\")!=null">
			    				<a title="删除" href="javascript:void(0);" onclick="del();">
			    				<img src="<%=path %>/<s:property value="#session.operList.get(\"020203\").oper_simg"/>" width="10" height="10" border="0"/>
			    				<span class="STYLE1"><s:property value="#session.operList.get(\"020203\").oper_sname"/></span>
			    				</a>
			                </s:if>
			                <s:if test="#session.operList.get(\"020204\")!=null">
			                	<a title="有效/无效" href="javascript:void(0);" onclick="changeValid();">
			                	<img src="<%=path %>/<s:property value="#session.operList.get(\"020204\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1">
			                	<s:property value="#session.operList.get(\"020204\").oper_sname"/></span></a>&nbsp;
			                </s:if>
		                </span>
		                <span class="STYLE1" style="white-space:nowrap;">
			                <s:if test="#session.operList.get(\"020205\")!=null">
			                <a title="校区设置" href="javascript:void(0);" onclick="setSchool();">
			                	<img src="<%=path %>/<s:property value="#session.operList.get(\"020205\").oper_simg"/>" width="10" height="10" border="0"/> 
			                	<span class="STYLE1"><s:property value="#session.operList.get(\"020205\").oper_sname"/></span></a>&nbsp;
			                </s:if>
			                <s:if test="#session.operList.get(\"020206\")!=null">
			                <a title="下载模板" href="javascript:void(0);" onclick="downloadTemp('mng_unitdepart');" >
			                	<img src="<%=path %>/<s:property value="#session.operList.get(\"020206\").oper_simg"/>" width="10" height="10" border="0"/> 
			                	<span class="STYLE1"><s:property value="#session.operList.get(\"020206\").oper_sname"/></span></a>
			    			</s:if>
			    			<s:if test="#session.operList.get(\"020207\")!=null">
			    				<a title="导入" href="javascript:void(0);" onclick="importExcel('单位部门信息导入','unitDepart!toImport');">
			    				<img src="<%=path %>/<s:property value="#session.operList.get(\"020207\").oper_simg"/>" width="10" height="10" border="0"/> 
			    				<span class="STYLE1"><s:property value="#session.operList.get(\"020207\").oper_sname"/></span></a>&nbsp;
			                </s:if>
			                <s:if test="#session.operList.get(\"020208\")!=null">
			                	<a title="导出" href="javascript:void(0);" onclick="exportExcel('unitDepart');" >
			                	<img src="<%=path %>/<s:property value="#session.operList.get(\"020208\").oper_simg"/>" width="10" height="10" border="0"/> <span class="STYLE1">
			                	<s:property value="#session.operList.get(\"020208\").oper_sname"/></span></a>&nbsp;&nbsp;
		                	</s:if>
	                </span>  
	           </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="2820px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
	  	</th>
	  	<th width="40px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
	  	<th width="120px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位编号</span></div></th>
	  	<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位名称</span></div></th>
	  	<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位简称</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位层次</span></div></th>
		<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">隶属单位</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">隶属层次</span></div></th>
		<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">隶属市级部门</span></div></th>
		<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">原单位名称</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位类型</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">资产规模</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">资质等级</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">法人代表</span></div></th>
		<th width="300px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">地址</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">负责人</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">联系人</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">电话</span></div></th>
		<th width="160px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">单位邮箱</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">是否定编</span></div></th>
		<th width="100px" height="20" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></th>
		<th height="20" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></th>
		</tr>
		
		<s:iterator value="list" var="unitDept" status="st">
		<tr bgcolor="#ffffff" align="center" class="STYLE19" <s:if test="#unitDept.ud_sisvalid==\"1\"">style="color:red;"</s:if>>
 		<td height="20"><input name="idcheckbox"  type="checkbox"   value="${unitDept.ud_sno}:${unitDept.ud_sname}" udname="${unitDept.ud_sname}" supername="${unitDept.ud_stopname}" onclick="checkOne();"></td>
 		<td><s:property value="#st.index + 1"/></td>
        <td title="${unitDept.ud_sno }">${unitDept.ud_sno }</td>
        <td title="${unitDept.ud_sname }">${unitDept.ud_sname }</td>
        <td title="${unitDept.ud_ssname }">${unitDept.ud_ssname }</td>
       <!-- 单位层次 -->
        <td title="${unitDept.ditem_sname1 }">${unitDept.ditem_sname1 }</td>
        <td title="${unitDept.ud_stopname }">${unitDept.ud_stopname }</td>
        <!-- 隶属层次 -->
        <td title="${unitDept.ditem_sname4 }">${unitDept.ditem_sname4 }</td>
        <!--隶属市级部门 -->
        <td title="${unitDept.ditem_sname3 }">${unitDept.ditem_sname3 }</td>
        <td title="${unitDept.ud_soldname }">${unitDept.ud_soldname }</td>
        <!-- 单位类型 -->
        <td title="${unitDept.ditem_sname2 }">${unitDept.ditem_sname2 }</td>
        <td title="${unitDept.ud_sassetsize }">${unitDept.ud_sassetsize }</td>
        <td title="${unitDept.ud_saptitude }">${unitDept.ud_saptitude }</td>
        <td title="${unitDept.ud_slegalman }">${unitDept.ud_slegalman }</td>
        <td title="${unitDept.ud_saddr }">${unitDept.ud_saddr }</td>
        <td title="${unitDept.ud_swheelman }">${unitDept.ud_swheelman }</td>
        <td title="${unitDept.ud_slinkman }">${unitDept.ud_slinkman }</td>
        <td title="${unitDept.ud_stele }">${unitDept.ud_stele }</td>
        <td title="${unitDept.ud_smail }">${unitDept.ud_smail }</td>
        <td>
        	<s:if test="#unitDept.ud_nistrue == \"0\"">是</s:if>
        	<s:if test="#unitDept.ud_nistrue == \"1\"">否</s:if>
        </td>
        <td>
        	<s:if test="#unitDept.ud_sisvalid == \"0\"">有效</s:if>
        	<s:if test="#unitDept.ud_sisvalid == \"1\"">无效</s:if>
        </td>
        <td title="${unitDept.ud_ssynchro }">${unitDept.ud_ssynchro }</td>
		</tr>	
		</s:iterator>	
    </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/unitDepart!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div> 
		<input type="hidden" name="form.searchD" value="${form.searchD}" />
        <input type="hidden" name="form.menu" value="<s:property value="menu"/>" />
</form>
</body>
</html>
      