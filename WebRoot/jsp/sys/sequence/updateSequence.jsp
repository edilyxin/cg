<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
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
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=path %>/js/valid.js" type=text/javascript></script> 
<script> 
//团队放大镜 1.编号对应标签ID 2.名称对应 标签ID 3.班组编号 
function tableTree(text1,text2,searchA){
searchA = $("#sysint_sno").val();
	var dataPath = "?"; 
	if(searchA!=undefined&&searchA!=null&&searchA!=""){
		dataPath+="&form1.searchA="+searchA;
	}
	tree(text1,text2,'<%=path%>/seq!tableTree'+dataPath);
}
function save(){
	var n = $("#seqNvalue").val().length;
	var l = $("#showLength").val()*1;
	if(n<=l){
		
	}else{
		alert("流水号不能大于流水长度");
		$("#seqNvalue").focus();
		return;
	}
	if(validator(document.form1)){
		if(validator(document.form1)){
			document.form1.action="seq!update";
			document.form1.submit();
		}
	}
}
function fileUp(obj){
//alert(obj.value);
$("#img").attr("src",obj.value);
alert($("#img").attr("src"));
}
$(function(){
	$(".showLen").change(function(){
	
		var seqSPrefix = $("#seqSPrefix").val().length;// 前缀长度
		var seqSsuffix = $("#seqSsuffix").val().length;//后缀长度
		var seqNYear = $("#seqNYear").val()*1;
		var seqNMonth = $("#seqNMonth").val()*1;
		var seqNday = $("#seqNday").val()*1;
		var showLength = $("#showLength").val()*1;
		var v = seqSPrefix +seqSsuffix +seqNYear +seqNMonth +seqNday +showLength;
		$("#seqNstep").val(v);
	});
});
function back(){
	document.form1.action="seq!find";
			document.form1.submit();
}
</script>
</head>
<body>
<form name="form1"   method="post" >
<div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>系统管理 &gt; 编码管理</span></h2>
   <div class="content" id="divheight" style="overflow:auto;"> 
	 
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#0E6BB1">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">修改编码</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              							</td>
          							</tr>
        						</table>
        					</td>
      					</tr>
    				</table>
    			</td>
  			</tr>
 			<tr valign="top">
    			<td>
    				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 				
<tr>
	<td nowrap align="right" >系统编号:</td>
   	<td colspan="0" >
   	<input type="text"   id="sysint_sname"  value="${vo.sysint_sname}" readonly/>
    <input type="hidden" id="sysint_sno"    value="" name="form.sysint_sno" />
	</td>
    <td nowrap align="right" width="10%">编码类型:</td>
    <td colspan="0" >
    	<select id="seqSType" name="form.seq_stype" valid="required" errmsg="规则类型不能为空!" disabled>
    		<option value="" >--请选择--</option>
    		<option value="0" <s:if test="vo.seq_stype==0">selected</s:if>>主键</option>
    		<option value="1" <s:if test="vo.seq_stype==1">selected</s:if>>编码</option>
    		<option value="2" <s:if test="vo.seq_stype==2">selected</s:if>>代码</option>
    	</select>
    	<input type="hidden" name="form.seq_stype" id="" value="${vo.seq_stype}"   />
    	<span style="color:red;"> * </span>
    </td>
</tr>
<tr>
    <td nowrap align="right">访问名称(英文名):</td>
    <td nowrap>
    	<input type="text" name="form.seq_sname" id="id1" value="${vo.seq_sname}"  maxlength="40" valid="required" errmsg="访问名称不能为空!" readonly/>
    	<input type="button" class="select_button" onclick="tableTree('id1','id2');" />
<span style="color:red;" id="checkSpan" style="width:100px"> * </span>
    </td>
    <td nowrap align="right">显示名称(中文名):</td>
    <td nowrap>
   	 <input type="text" name="form.seq_sdisname" id="id2" value="${vo.seq_sdisname}"   />
    <span style="color:red;"> * </span>
    </td>
</tr>
<tr>
    <td nowrap align="right">前缀：</td>
    <td >
    	<input type="text" maxlength="10" name="form.seq_sprefix"  class="showLen" id="seqSPrefix" value="${vo.seq_sprefix}" />
    </td>
    <td nowrap align="right">后缀：</td>
    <td nowrap>
    	<input type="text" maxlength="10" name="form.seq_ssuffix" class="showLen" id="seqSsuffix" value="${vo.seq_ssuffix}" />
    </td>
</tr>
<tr> 
 <td nowrap align="right">年份格式:</td>
    <td >
	    <select name="form.seq_nyear" id="seqNYear" class="showLen" >
		    <option value="0" <s:if test="vo.seq_nyear==0">selected</s:if>>不启用</option>
		    <option value="2" <s:if test="vo.seq_nyear==2">selected</s:if>>二位年</option>
		    <option value="4" <s:if test="vo.seq_nyear==4">selected</s:if>>四位年</option>
	    </select>
    <span style="color:red;"> * </span>
    </td>
    <td nowrap align="right">月份格式:</td>
    <td >
	    <select name="form.seq_nmonth" id="seqNMonth" class="showLen">
	    	<option value="0" <s:if test="vo.seq_nmonth==0">selected</s:if>>不显示</option>
	    	<option value="2" <s:if test="vo.seq_nmonth==2">selected</s:if>>两位月份</option>
	    </select><span style="color:red;"> * </span>
	</td>
</tr>
<tr>
    <td nowrap align="right">日期格式:</td>
    <td >
	    <select name="form.seq_nday" id="seqNday" class="showLen">
	    	<option value="0" <s:if test="vo.seq_nday==0">selected</s:if>>不显示</option>
	    	<option value="2" <s:if test="vo.seq_nday==2">selected</s:if>>两位日期</option>
	    </select><span style="color:red;"> * </span>
	</td>
    <td nowrap align="right">流水号长度：</td>
    <td nowrap>
	    <select name="form.seq_nlength" id="showLength" class="showLen"valid="required" errMsg="流水号长度不能为空">
			<option value="">--请选择--</option>
			<option value="1" <s:if test="vo.seq_nlength==1">selected</s:if> >1</option>
			<option value="2" <s:if test="vo.seq_nlength==2">selected</s:if>>2</option>
			<option value="3" <s:if test="vo.seq_nlength==3">selected</s:if>>3</option>
			<option value="4" <s:if test="vo.seq_nlength==4">selected</s:if>>4</option>
			<option value="5" <s:if test="vo.seq_nlength==5">selected</s:if>>5</option>
			<option value="6" <s:if test="vo.seq_nlength==6">selected</s:if>>6</option>
			<option value="7" <s:if test="vo.seq_nlength==7">selected</s:if>>7</option>
			<option value="8" <s:if test="vo.seq_nlength==8">selected</s:if>>8</option>
			<option value="9" <s:if test="vo.seq_nlength==9">selected</s:if>>9</option>
			<option value="10" <s:if test="vo.seq_nlength==10">selected</s:if>>10</option>
			<option value="11" <s:if test="vo.seq_nlength==11">selected</s:if> >11</option>
			<option value="12" <s:if test="vo.seq_nlength==12">selected</s:if>>12</option>
			<option value="13" <s:if test="vo.seq_nlength==13">selected</s:if>>13</option>
			<option value="14" <s:if test="vo.seq_nlength==14">selected</s:if>>14</option>
			<option value="15" <s:if test="vo.seq_nlength==15">selected</s:if>>15</option>
			<option value="16" <s:if test="vo.seq_nlength==16">selected</s:if>>16</option>
			<option value="17" <s:if test="vo.seq_nlength==17">selected</s:if>>17</option>
			<option value="18" <s:if test="vo.seq_nlength==18">selected</s:if>>18</option>
			<option value="19" <s:if test="vo.seq_nlength==19">selected</s:if>>19</option>
			<option value="20" <s:if test="vo.seq_nlength==20">selected</s:if>>20</option>
		</select><span style="color:red;"> * </span>
	</td>
</tr>
<tr>
    <td nowrap align="right">总长度：  </td>
    <td nowrap>
    	<input type="text" maxlength="10" name="form.seq_ntotallength" id="seqNstep" value="${vo.seq_ntotallength}" valid="required" errmsg="步长不能为空!" onkeyup="value=value.replace(/[^\d]/g,'') "
    	readonly/><span style="color:red;"> * </span>
    </td>
    <td nowrap align="right">流水号：</td>
    <td>
    	<input type="text" maxlength="10" name="form.seq_nvalue" id="seqNvalue" value="${vo.seq_nvalue}" valid="required" errmsg="当前值不能为空!" onkeyup="value=value.replace(/[^\d]/g,'') "
    	/><span style="color:red;"> * </span>
    </td>
</tr>    
<tr>
    <td nowrap align="right">步长：  </td>
    <td nowrap>
    	<select name="form.seq_nstep" id="sysint_sstate" valid="required" errMsg="步长不能为空">
			<option value="">--请选择--</option>
			<option value="1" <s:if test="vo.seq_nstep==1">selected</s:if> >1</option>
			<option value="2" <s:if test="vo.seq_nstep==2">selected</s:if>>2</option>
			<option value="3" <s:if test="vo.seq_nstep==3">selected</s:if>>3</option>
			<option value="4" <s:if test="vo.seq_nstep==4">selected</s:if>>4</option>
			<option value="5" <s:if test="vo.seq_nstep==5">selected</s:if>>5</option>
			<option value="6" <s:if test="vo.seq_nstep==6">selected</s:if>>6</option>
			<option value="7" <s:if test="vo.seq_nstep==7">selected</s:if>>7</option>
			<option value="8" <s:if test="vo.seq_nstep==8">selected</s:if>>8</option>
			<option value="9" <s:if test="vo.seq_nstep==9">selected</s:if>>9</option>
			<option value="10" <s:if test="vo.seq_nstep==10">selected</s:if>>10</option>
		</select><span style="color:red;"> * </span>
    </td>
    <td nowrap align="right">当前值：</td>
    <td>
    	<input type="text" maxlength="10" name="form.seq_scurvalue" id="" value="${vo.seq_scurvalue}" valid="required" errmsg="当前值不能为空!" onkeyup="value=value.replace(/[^\d]/g,'') "
    	readonly/><span style="color:red;"> * </span>
    </td>
</tr>

<tr>
    <td nowrap align="right">备注：</td>
    <td colspan="3"> <textarea id="seq_SDesc"  rows="5" style="width:80%;overflow-y:auto;" name="form.seq_sdesc" valid="limit"   max="250" errmsg="备注长度不能超过250个字符!">${vo.seq_sdesc}</textarea></td>
</tr>
</table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="save();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="back();"  />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
</div>
    <input type="hidden" name="form.searchA" value="${form.searchA}" />
<input type="hidden" name="form.searchB" value="${form.searchB}" />
<input type="hidden" name="form.searchC" value="${form.searchC}" />
<input type="hidden" name="form.seq_sisvalid" value="${vo.seq_sisvalid}"/>
<input type="hidden" name="form.seq_nid" id="seqSName" value="${vo.seq_nid}"/>
  </form>
  </body>
</html>