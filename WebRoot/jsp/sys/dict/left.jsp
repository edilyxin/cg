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
<script type="text/javascript">
	$(function(){
		var msg = $('#msg').val();
		if(msg!=null&&msg!=""){
		alert(msg);
			 parent.right.location= "<%=path%>/dict!find1";//删除成功刷新页面
		}
	
	});
function findItemList(obj){
	//查询字典项
	$("#hidId").val(obj);
	$("#form1").attr("action","dict!find1?id="+obj);
   	$("#form1").submit(); 	
}
 function toAdd(){
	  var arguemnts = new Object();
      arguemnts.window = window;
	 window.showModalDialog('<%=path%>/dict!toAdd',arguemnts,'dialogHeight:275Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	             
  }

 	
 function toUpdate(){
		var checkedObj = $(".Off:checked");
		var v = checkedObj.length == 1;
		if (!v) {
			alert("您只能选一项进行修改 ");
			return false;
		} else {
           var arguemnts = new Object();
      	   arguemnts.window = window;
           window.showModalDialog('<%=path%>/dict!toUpdate?idcheckbox='+checkedObj.val(),arguemnts,'dialogHeight:315Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	   }
}
function toDelete(){
		if(isOk(".Off")){
			alert("未选择删除项");
			return;
		}
		if(confirm("是否删除？")){
		  $("#form1").attr("action","dict!toDelete");
          $("#form1").submit();
        }
       
}

function find(){
input_trim();
	$("#form1").attr("action","<%=path%>/dict!find");
    $("#form1").submit();
}


function isOk(obj){//参数class    返回是否选择   没有就是true
	var ok = false;
	var checkedObj = $(obj+":checked");
	var v = checkedObj.length;
	if (v<1) {
		ok = true;
	}
	return ok;
}
//
function checked(obj){
	alert(1212);
	
	if($('.Off').val()==obj){
		$('.Off').attr("checked", true); 
	}
}
function checkAll(){
alert("进来木有");
	var v = $("#checkAll").attr("checked");
	alert(v);
	if (v == true) {
		$(".Off").attr("checked", true);
	} else {
		$(".Off").attr("checked", false);
	}
}

function myCheckAll(){
//alert("进来木有");
	var v = $("#checkAll").attr("checked");
	//alert(v);
	if (v == true) {
		$(".Off").attr("checked", true);
	} else {
		$(".Off").attr("checked", false);
	}
}


</script>
</head>
<body   style="overflow-x:hidden;overflow-y:auto;">
<form name="form1"  id="form1"   method="post">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                	<span  style="white-space:nowrap;">&nbsp;&nbsp;所属系统:
              <input type="text"   id="sysint_sname" name="form.searchA" size="15"  value="${form.searchA}" readonly/>
              <input type="button" class="select_button" onclick="sysintTree('sysint_sno','sysint_sname');" />
    		  <input type="hidden" id="sysint_sno" name="form.sysint_sno"   value="${form.sysint_sno}"/> 
    			 </span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;字典类型:
               		<select name="form.searchC" id="searchC" >
               			<option value=""></option>
               			<option value="0" <s:if test="form.searchC==\"0\"">selected</s:if>>用户</option>
               			<option value="1" <s:if test="form.searchC==\"1\"">selected</s:if>>系统</option>
               		</select>
               	</span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;字典名称:
                <input type="text" name="form.searchB" id="searchB" value="${form.searchB}" size="12"/></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
             	 <a href="javaScript:void(0);"  style="cursor:hand" onclick="find();" target="left">  <img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
             
			 </td>
				<td></td>	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">字典列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            							<span class="STYLE1" style="white-space:nowrap;">
	            						 <s:if test="#session.operList.get(\"010801\")!=null">
              								<a title="添加" href="#" onclick="toAdd();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010801\").oper_simg"/>" width="10" height="10" border="0"/>
              								 <span class="STYLE1"><s:property value="#session.operList.get(\"010801\").oper_sname"/></span></a>&nbsp; 
              							</s:if>
              							 <s:if test="#session.operList.get(\"010802\")!=null">
              								<a title="修改" href="#" onclick="toUpdate();"><img src="<%=path%>/<s:property value="#session.operList.get(\"010802\").oper_simg"/>" width="10" height="10" border="0"/> 
              								<span class="STYLE1"><s:property value="#session.operList.get(\"010802\").oper_sname"/></span></a>&nbsp;&nbsp;
              							</s:if>
              							 <s:if test="#session.operList.get(\"010803\")!=null">
              								<a title="删除" href="#" onclick="toDelete();"><img src="<%=path%>/<s:property value="#session.operList.get(\"010803\").oper_simg"/>" width="10" height="10" border="0"/> 
              								<span class="STYLE1"><s:property value="#session.operList.get(\"010803\").oper_sname"/></span></a>&nbsp;
              							</s:if>
              							</span></td>
					</tr>
			</table>
    			<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    				<table width="500" id="table1" class="table"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#CBE0FF">
        					<th width="40px" height="24"  class="STYLE10"  onclick="myCheckAll();">
        						<div align="center">
          						<input type="checkbox" id="checkAll" />
        						</div>
        					</th>
        					<th width="40px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        					<th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></th>
        					<th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">字典名称</span></div></th>
        					<th height="20"  class="STYLE6"><div align="center"><span class="STYLE10">字典描述</span></div></th>
        					<th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">字典类型</span></div></th>
      					</tr>
      					<s:iterator value="list" var="dict" status="s">
	     				<tr bgcolor="#ffffff" align="center"" class="STYLE19" id="dictID" style="cursor:hand;"   onclick="parent.right.location.href='<%=path %>/dict!find1?id=${dict.dict_sno}';">
	     	    			<td height="20">
	     	    				<!--<input type="text" name="checked" id="checked" value="${checked}"/>
	     	    				--><input name="daichao"  type="checkbox"  class="Off" value="${dict.dict_sno}" <s:if test="#dict.dict_sno==id">checked</s:if>/>
	     	    			</td>
	     	    			
	     					<td >
	     					${s.index+1}
	     					 <input type="hidden" name="dict_sno" id="dict_sno" value="${dict.dict_sno}" />
	     					 <input type="hidden" name="checked" id="checked" value="${checked}"/>
	     					</td>
	     					<td   title="${dict.sysint_sname }">
	     				
	     					${dict.sysint_sname}
	     					</td>
	     					<td   title="${dict.dict_sname }">
	     					
	     					${dict.dict_sname}
	     					</td>
							<td   title="${dict.dict_sdesc }">
							
							 ${dict.dict_sdesc}
							
							 </td>
							<s:if test="#dict.dict_ntype==\"0\"">
							<td   title="用户类">
							
								用户类
							
							</td>
							</s:if>
							<s:else>
							<td    title="系统类">
							
								系统类
								
							</td>
							</s:else>
						
	     				</tr>
	     				</s:iterator>
    				</table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/dict!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
	<input type="hidden" value="" name="form1.dict_sno" id="hidId"/><!-- id 字典项所显示的 -->
	<input type="hidden" class="msg" id="msg" value="${msg}"/>
</form>
</body>
</html>
