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
<script>

function findItemList(obj){
	//查询字典项
	$("#hidId").val(obj);
	$("#form1").attr("action","dict!find?id="+obj);
   	$("#form1").submit(); 	
}
 function toAdd(){
	  var arguemnts = new Object();
      arguemnts.window = window;
	 window.showModalDialog('<%=path%>/dict!toAdd',arguemnts,'dialogHeight:275Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	             
  }
  //添加字典项
 function toAddItem(){
 	//var checked = $(".Off:checked").val();
 	var checked = $('#hidId').val();
 	if(checked==undefined||checked==null||checked==""){
 		alert("请选择一个字典类型");
 		return;
 	}
     var arguemnts = new Object();
     arguemnts.window = window;
     window.showModalDialog('<%=path%>/dict!toAddItem?id='+checked,arguemnts,'dialogHeight:250Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	   
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
function toDeleteItem(){
		if(isOk(".Off2")){
			alert("未选择删除项");
			return;
		}
		if(confirm("是否删除？")){
		$("#form1").attr("action","dict!toDeleteItem");
        $("#form1").submit();
        } 
       
}
function toUpdateItem(){
	var checkedObj = $(".Off2:checked");
	var v = checkedObj.length == 1;
	if (!v) {
		alert("您只能选一项进行修改 ");
		return false;
	} else {
        var arguemnts = new Object();
      	arguemnts.window = window;
        window.showModalDialog('<%=path%>/dict!toUpdateItem?id='+checkedObj.val(),arguemnts,'dialogHeight:250Px;dialogWidth:400px;center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	}
}
function find(){
	$("#form1").attr("action","dict!find");
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
function checkAll2(){
	var v2 = $("#checkAll2").attr("checked");
	if (v2 == true) {
		$(".Off2").attr("checked", true);
	} else {
		$(".Off2").attr("checked", false);
	}
}
function myCheckAll2(){
	var v2 = $("#checkAll2").attr("checked");
	if (v2 == true) {
		$(".Off2").attr("checked", true);
	} else {
		$(".Off2").attr("checked", false);
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
				<tr bgcolor="#D5EAFB">
					<td height="30" align="left" colspan="2">
					<span><font color="blue" style="font-size:13">当前的字典名称为：${dict_sname}</font></span>
					
			 </td> 
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">字典项列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	            							<span class="STYLE1" style="white-space:nowrap;">
	            						<s:if test="#session.operList.get(\"010804\")!=null">
              								<a title="新增" href="#" onclick="toAddItem();">
              								<img src="<%=path%>/<s:property value="#session.operList.get(\"010804\").oper_simg"/>" width="10" height="10" border="0"/> 
              								<span class="STYLE1"><s:property value="#session.operList.get(\"010804\").oper_sname"/></span></a>&nbsp; 
              							</s:if>
              							<s:if test="#session.operList.get(\"010805\")!=null">
              								<a title="修改" href="#" onclick="toUpdateItem();">
              								<img src="<%=path%>/<s:property value="#session.operList.get(\"010805\").oper_simg"/>" width="10" height="10" border="0"/> 
              								<span class="STYLE1"><s:property value="#session.operList.get(\"010805\").oper_sname"/></span></a>&nbsp;
              							</s:if>
              							<s:if test="#session.operList.get(\"010806\")!=null">
              								<a title="删除" href="#" onclick="toDeleteItem();">
              								<img src="<%=path%>/<s:property value="#session.operList.get(\"010806\").oper_simg"/>" width="10" height="10" border="0"/> 
              								 <span class="STYLE1"><s:property value="#session.operList.get(\"010806\").oper_sname"/></span></a>&nbsp;&nbsp;
              							</s:if>
              								</span></td>
					</tr>
			</table>
    				 <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    				<table width="500" id="table1" class="table"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      					  <tr bgcolor="#CBE0FF">
        					<th width="40px" height="25"  class="STYLE10" onclick="myCheckAll2();">
        						<div align="center">
          						<input type="checkbox" id="checkAll2"  />
        						</div>
        					</th>
        					<th width="40px" height="20"  class="STYLE6" style="white-space:nowrap;"><div align="center"><span class="STYLE10">序号</span></div></th>
        					
        					<th width="100px" height="20"  class="STYLE6" style="white-space:nowrap;"><div align="center"><span class="STYLE10">字典项名称</span></div></th>
        					<th width="80px" height="20"  class="STYLE6" style="white-space:nowrap;"><div align="center"><span class="STYLE10">字典项值</span></div></th>
        					<th width="80px" height="20"  class="STYLE6" style="white-space:nowrap;"><div align="center"><span class="STYLE10">字典名称</span></div></th>
        					<th   height="20"  class="STYLE6" style="white-space:nowrap;"><div align="center"><span class="STYLE10">描述</span></div></th>
      					
      					</tr>
      					<s:iterator value="list1" var="dictItem" status="s">
	     				<tr bgcolor="#ffffff" align="center"" class="STYLE19">
	     	    			<td height="20">
	     	    				<input name="idcheckbox1"  type="checkbox"  class="Off2" value="${dictItem.ditem_nid}" />
	     	    			</td>
	     					<td >${s.index+1}</td>
	     					<td title="${dictItem.ditem_sname }">${dictItem.ditem_sname }</td>
							<td title="${dictItem.ditem_svalue }">${dictItem.ditem_svalue }</td>
							<td title="${dictItem.dict_sname }">${dictItem.dict_sname } </td>
	     					<td title="${dictItem.ditem_sdef1 }">${dictItem.ditem_sdef1 } </td>
	     				</tr>
	     				</s:iterator>
    				</table>
			</div>
  		</div>
		 
		</div>
		<input type="hidden" value="${form1.dict_sno}" name="form1.dict_sno" id="hidId"/><!-- id 字典项所显示的 -->
</form>
</body>
</html>
