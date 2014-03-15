<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="_self">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位校区对照信息</title>
<script type="text/javascript">
	$(function(){
		//初始化单位名称和单位编号
		var paramObj = window.dialogArguments;
		var udname = paramObj.name;
		var supername = paramObj.supername;
		$("input[name='form.searchA']").val(udname);
		$("input[name='form.searchB']").val(supername);
	});
	function toSave() {
		if (confirm("是否保存！")) {
			document.forms[0].submit();
		}
	}
	 
</script>
</head>

<body  >
<form name="form1" method="post" action="<%= path %>/unitDepart!saveSchool">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;单位名称:
                  <input type="text" name="form.searchA" value="" readonly /></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;隶属单位:
                  <input type="text" name="form.searchB" value="" readonly /></span>
                </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">单位校区对照列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            	<span class="STYLE1" style="white-space:nowrap;">
						<a href="javascript:void(0);" onclick="toSave()"><img src="<%=path %>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">保存</span></a>&nbsp;&nbsp; 
						<a href="javascript:void(0);" onclick="javascript:window.close();"><img src="<%=path %>/images/pic12.gif" width="10" height="10" border="0"/> <span class="STYLE1">关闭</span></a>&nbsp; 
	                </span>
	           </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="500"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr>
	  	<td width="40px" height="25" bgcolor="d3eaef" class="STYLE10" >
	  		<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</td>
	  	<td width="40px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
	  	<td width="120px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">校区编号</span></div></td>
	  	<td width="160px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">校区名称</span></div></td>
	  	<td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">类别</span></div></td>
		</tr>
		
		<s:iterator value="list" var="vo" status="st">
		<tr bgcolor="#ffffff" align="center" class="STYLE19">
 		<td>
 			<input name="idcheckbox" type="checkbox" value="${vo.sh_sno}:${vo.sh_stype}" onclick="checkOne();" <s:if test="#vo.isChecked == \"1\"">checked</s:if>/>
 		</td>
 		
 		<td><s:property value="#st.index + 1"/></td>
        <td>${vo.sh_sno}</td>
        <td>${vo.sh_sname}</td>
        <td>
        	<s:if test="#vo.sh_stype == \"0\"">主校区</s:if>
        	<s:if test="#vo.sh_stype == \"1\"">附校区</s:if>
        </td>
		</tr>	
		</s:iterator>	
		
		 </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
 
						<s:if test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:if>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		<input type="hidden" name="sdForm.ud_sno" id="ud_sno" value="<s:property value="#parameters.udno"/>"/>
</form>
</body>
</html>

