<%@ page language="java" import="java.util.*,net.sf.json.JSONArray" isELIgnored="false" pageEncoding="UTF-8"%>
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
<title>用户管理</title> 
 <link rel="stylesheet" type="text/css" href="<%=path%>/js/tree/ztree/css/zTreeStyle/zTreeStyle.css"/>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.core-3.4.js"></script>
  <script type="text/javascript" src="<%=path%>/js/tree/ztree/js/jquery.ztree.excheck-3.4.js"></script>

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

</script>

<script type="text/javascript">
	
		var setting = {
			check: {
				enable: false
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
  
  $(function (){
 
  $("#emp_snameby").click(function(){
   var empNO=$("#emp_sno").val();//代理人编号 
 	 empTree('emp_snoby','emp_snameby','','${userinfo.ud_sno}','','','','','','','','','','',empNO);
   		var empNO=$("#emp_sno").val();//代理人编号 
	  	var empNOBy=$("#emp_snoby").val();//被代理人编号
	  	var userId = $("#userid").val();
	  	if(empNOBy==""){
	  		$('#treeDemo').empty();
	  	}
		if(empNO!=""&&empNOBy!=""){
			$('#treeDemo').empty();
	  		$.ajax({  
				type: "POST",  
				url: "user!rightDlLook",  
				data: { 
					userId:userId,
					empNOBy:empNOBy
				},  
				datatype: "json",  
				success: function(data) {  
	      		    var msg = eval('(' + data + ')');//将字符串转换为json对象
					var zNodes =msg;//tree树形数据
					$(function(){
						//alert(msg);
						 var zNodes =msg;//tree树形数据
						//$.fn.zTree.init($("#treeDemo"),setting, zNodes);
						 for(var i =0 ;i< zNodes.length;i++){
								// alert(zNodes.length);
								 var treeObj;
								 if(i == 0){
										$.fn.zTree.init($("#treeDemo"), setting, zNodes[0]);
										treeObj  = $.fn.zTree.getZTreeObj("treeDemo");
								 }else{
									 	//alert(i);
										$('.ztree').eq($('.ztree').length-1).after("<ul id='treeDemo"+i+"' class='ztree'></ul>");
										$.fn.zTree.init($("#treeDemo"+i), setting, zNodes[i]);
										treeObj  = $.fn.zTree.getZTreeObj("treeDemo"+i);
								 }
						 }
					});		
					
					}
	    	});  
	 	}
  });
});
		
	
function back(){
	window.location.href="<%=path%>/user!find";
}
</script>


<script type="text/javascript">
	function coltogather(willcheck,colnum){ 
	var alltext = [],togotherNum = [],oldnum = [],id=1,lasttext=null,rmflag=1; 
	//逐列的数据进行扫描,得到里面的不重复的数据,以及各个数据的数目,然后将依据此结果进行设置rowspan属性
	willcheck.each(function(){
	      var _rmnum = this.getAttribute('rmnum');
		  if(!_rmnum)_rmnum=0;
	      var trdom= jQuery('td:eq('+(colnum-_rmnum)+')',this)
		  var text = jQuery(trdom).text();  
		  //如果上一行记录文本为空,说明是第一行
		  if(lasttext==null) {
			   lasttext = text;
		  }else {
			  //如果当前行和上一行记录一样,说明要进行合并,合并的单元格数目就加1
			  if(lasttext!=text){  
				   togotherNum.push(id);
				   lasttext = text;
				   id = 1;
			  } else{
			      id++;
			  }
		  }
		  
	 });   
	 togotherNum.push(id); 
	 //复制allnum数组中的数据到oldnum数组
	 jQuery.each(togotherNum, function(i, n){
         oldnum[i] =n;
     }); 
     var index = 0,len = togotherNum.length;
	 //逐行进行处理,设置指定列的rowspan属性,以及将要合并的单元格remove!
	 willcheck.each(function() {
				// 得到一个属性表示该行已经被移除了几个td
				var _rmnum = this.getAttribute('rmnum');
				if (!_rmnum)
					_rmnum = 0;
				var tddom = jQuery('td:eq(' + (colnum - _rmnum) + ')', this)
				if (togotherNum[index] == oldnum[index]) {
					tddom.attr('rowSpan', togotherNum[index]);
					if(togotherNum[index]>1)
					  togotherNum[index] = togotherNum[index] - 1;
					 else
					   index++;
				} else { 
					if (togotherNum[index] == 0) {
						index++;
					    tddom.attr('rowSpan', togotherNum[index]);
					} else {
				    	tddom.remove(); 
						if(--togotherNum[index]==0){
							index++;
						}
					}
					// 移除了td之后,要在tr里面添加一个属性标示已经移除的td的数目
					if (_rmnum == 0) {
						jQuery(this).attr('rmnum', 1);
					} else {
						jQuery(this).attr('rmnum', 1 + _rmnum * 1);
					}
				}
			});   
	 //清空数组
	 alltext = null;
	 togotherNum = null;
	 oldnum = null; 
}


function isinarr(arr,str){
  for(var i=arr.length-1;i>=0;i-- ){
    if(arr[i]==str)
	{return i;
	}
  }
  return -1;
}

function checktable(id){
  var tdnum=0;
  $('#'+id+' tr').each(function(){
	if(tdnum==0){
	   tdnum = $('td',this).size();
	}else{ 
	   if(tdnum!=$('td',this).size()){
	        tdnum = -1;
			return false;
	   }
	}
  });
  if(tdnum>0)
     return true;
  return false;
}

 function go() {  
	 if(!checktable('tb1')){ 
		return false;
	}else{
	   coltogather($('#tb1 tr'),0);   
	   coltogather($('#tb2 tr'),0);   
	}
}
</script>

</head>

<body onload="go();">

<form name="form1" method="post">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				 
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">权限代理查看</span></td>
              </tr>
            </table></td>
					<td align="right" >
            <span class="STYLE1" >
				<a href="#" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            </span>
            </td>
					</tr>
			</table>
			<div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    		<s:if test="role.emp_sno!=null">
   			<table class="table" width="500px" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
   			<tr  bgcolor="d3eaef">
   			
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">代理用户：</span></td>
	  			<td height="25"  nowrap="nowrap">
	  			 <input type="text"  id="screenname" name="screenname"  value="${role.screenname}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			<input type="hidden"  id="userid" name="form.userid"  value="${userId}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			 </td>
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">代理人：</span></td>
	  			<td height="25"  nowrap="nowrap">
	  			 <input type="text" id="emp_sname" name="emp_sname"  value="${role.emp_sname}" valid="required" errmsg="被代理人不能为空!" readonly/>
	  			<input type="hidden"   id="emp_sno" name="empNO"  value="${role.emp_sno}"/>
	  			</td>
		   		</tr><tr>
   				<td height="25" nowrap="nowrap"><span style="font-size:12px;font-weight:bold;">被代理人：</span></td>
	  			<td height="25" nowrap="nowrap" >
		   		 <input type="text"   id="emp_snameby"   value=""  />
    			 <input type="hidden" id="emp_snoby"  name="empNOBy" value=""/> 
		   		</td>
		   		<td title="选择一个被代理进行查看"  nowrap="nowrap" colspan="2">
		   		<div style="color: red">注意：	选择一个被代理人进行查看</div>
		   		</td>
	   		</tr>
   			</table>
   			</s:if>
		   		<s:else>
		   		<br/>
		   			<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，该用户还没有设置员工！</strong></span></div>
		   		</s:else>
		<div style="height:330;overflow-y:auto;">
   		<ul id="treeDemo" class="ztree"></ul>
   		
   		</div>
			</div>
  		</div>
		 
		</div>
</form>
</body>
</html>
			 
