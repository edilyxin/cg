<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
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
  document.getElementById("searchB1").value=document.getElementById("searchB").value;
  document.getElementById("searchC1").value=document.getElementById("searchC").value;
  document.form1.action="<%=path%>/demo!find";
  document.all.form1.submit();
}
  //新增
  function toAdd(){
	document.form1.action="<%=path%>/demo!toAdd";
	document.form1.submit();

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
		document.form1.action="<%=path%>/demo!toUpdate";
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

	<a href="<%=path%>/approve!update">保存</a>
	</form>
</body>
</html>
