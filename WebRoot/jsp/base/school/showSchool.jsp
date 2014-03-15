<%@ page language="java" import="java.util.*,com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base target="_self"/>
  <title>校区信息详细</title>
<link href="<%=path %>/css/left.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/css/right1.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/right2.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/text.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/top.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/line.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/js/tree/selectjs.js" type=text/javascript></script>
<script src="<%=path %>/js/valid.js" type=text/javascript></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<jsp:include page="/common/js/util.jsp"/>
</head>
 <body>
  <form name="form1" method="post">
 	<div class="bigBox"><!--外部大DIV，可以调整宽度-->
  	<h2><span style="width:300px;float:left;"><a href="javascript:void(0)">基础管理</a> &gt; <a href="javascript:void(0)">校区信息管理</a>&gt;详细信息</span></h2>
  	
     <div class="right2">
  	<div class="content" >
<div >
  	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tabletext">
				       <tr >
				       		<td width="257" align="right">校区编码：</td>
			       		 <td width="376"><input type="text" name="sh_sNo" readonly="readonly" value="${v.sh_sno }"/></td>
				       		<td width="187" align="right">校区类型：</td>
			       		 <td width="694"><input type="text" name="sh_stype" readonly="readonly" <s:if test="v.sh_stype==\"0\"">value="主校区"</s:if><s:if test="v.sh_stype==\"1\"">value="分校区"</s:if>/>
			       		 </td>
				       		
				       </tr>
				       <tr >
				       		<td width="257" align="right">校区简称：</td>
				       		<td><input type="text" name="sh_ssname" readonly="readonly" value="${v.sh_ssname}" maxlength="20" /></td>
				       		<td width="187" align="right">校区名称：</td>
				       		<td><input type="text" name="sh_sName" readonly="readonly" value="${v.sh_sname}" maxlength="20" /></td>
				       		
				       </tr>
				       <tr >
				       		<td width="257" align="right">校区地址：</td>
				       		<td><input type="text" name="sh_sadder" readonly="readonly" value="${v.sh_sadder}" maxlength="20" /></td>
				       		<td width="187" align="right">校区所属城市：</td>
				       		<td><input type="text" name="sh_scity" readonly="readonly" value="${v.sh_scity}"  maxlength="20" /></td>
				       		
				       </tr>
				       
				       <tr >
				       		<td  align="right">校区邮政编码：</td>
				       		<td><input type="text" readonly="readonly" name="sh_spost" value="${v.sh_spost}" maxlength="6" /></td>
				       		<td  align="right">校区占地面积：</td>
				       		<td><input type="text" readonly="readonly" name="sh_narea" value="${v.sh_narea}" maxlength="20" /></td>
				       		
				       </tr>
				       <tr >
				       		<td  align="right">备注：</td>
				       		<td colspan="3">
				       		<textarea rows="5" readonly="readonly" cols="100" name="sh_smem" >${v.sh_smem}</textarea>
				       		</td>
				       </tr>
				        
			  </table><br/>
			<div align="center">
	        	<input name="Submit22" type="button" class="button_02a" value="关闭" onClick="history.go(-1);"></li>
   			</div>
	       </div>
    </div>
  </div>
  <input type="hidden" name="dictItem_sAlterBy" value="us_sName" scope="session"/>
  </form>
  </body>
</html>
