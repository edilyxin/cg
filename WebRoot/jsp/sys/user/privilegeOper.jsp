<%@ page language="java" import="java.util.*,com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
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

  //选择所有操作权限
  function checkAllOPer(obj){
  	if($(obj).attr("flag")==undefined||$(obj).attr("flag")==0){	//全选状态
	  	$("input[name=operckb]").each(function(){
		  	$(this).attr("checked",true);
		  	$(obj).attr("flag",1);
		  	//按钮改变为全取消
		  	$('.right_sno').attr('checked',true);
		  	$(obj).val("全取消");
	  	});
	 }else{
	 	$("input[name=operckb]").each(function(){
		  	$(this).removeAttr("checked");
		 	 $(obj).attr("flag",0);
		  	//按钮改变为全选
		  	$('.right_sno').attr('checked',false);
		  	$(obj).val("全选");
	  	});
	 }
  }
 
 
  function chkAll()
 {
      var obj=document.all.operckb;
      var len=obj.length;
     if(document.all.chkok.checked==true)
     {
       for(var i=0;i<len;i++)
       {
          obj[i].checked=true;
        }
        $('.right_sno').attr("checked",true); 
     }else{
     
       for(var i=0;i<len;i++)
       {
          obj[i].checked=false;
       }
       $('.right_sno').attr("checked",false); 
     }

 }
  //开始 我的js    角色权限保存与显示角色原有权限checkClass
$(function(){
	var checkClass = $(".checkClass");
	var oneOper = $(".oneOper");
	var t=new Array();
    var i=0;
    
    oneOper.each(function(){   //迭代出用户所拥有权限
    	t[i]=$(this).val();
    	i++;	
    	});
    	
    checkClass.each(function(){
    	var c = $(this).val().split("-")[0]; 
    	for(var j=0; j<t.length; j++){
    		if(c==t[j]){
    			$(this).attr("checked",true);
    		}	
    	}
    });
    
     
    $("input[name=chekbx]").click(function(){
    	var ok = $(this).attr("checked");
    	var is = $(this).parent().siblings().eq(3).children("input");
    	is.each(function(){
    		$(this).attr("checked",ok);
    	});
    });
    
});

  //保存操作权限
 function saveUserOper(){
//     var checkClass = $(".checkClass:checked");
//     var outValue="";
//     var right_sno = $(".right_sno");
//	     checkClass.each(function(){
//		   	outValue = $(this).val() +'@'+outValue;
//		   });
	 document.form1.action="<%=path%>/user!saveUserOper";
	 document.form1.submit();
 }
 function back(){
 	var userId = $('#userId').val();
	window.location.href="<%=path%>/user!toPRight?userId="+userId;
}
</script>
</head>

<body>

<form name="form1" method="post"   id="form1">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/>


</span></h2>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">特权分配 &gt; 操作权限分配</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right">
            								<span class="STYLE1" >
												<a href="javascript:void(0);" onclick="saveUserOper();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">分配</span></a>&nbsp;
												<a href="javascript:void(0);" onclick="back();"><img src="<%=path %>/images/luck.gif" width="10" height="10" border="0"/> <span class="STYLE1">返回</span></a>&nbsp;
            								</span>
           							 		</div>
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
					     				<td nowrap align="right" width="10%">用户姓名:</td>
					     				<td  nowrap="nowrap"    id="username">${vo.firstname}${vo.lastname}</td> 
					    			</tr>
					   			</table>
							</td>
      					</tr>
    				</table>
    				 <!-- 隐藏该角色拥有的操作权限 -->
		<s:iterator value="OneOperList" var="v">
			<input class="oneOper" value="${v.oper_sno}" style="display:none"/>
		</s:iterator>
		<!-- 操作功能列表 -->
    				<table width="100%"  id="table1"      border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
						<tr bgcolor="d3eaef" class="STYLE10">
	  						<td width="40px" align="center" height="20" >
								<input type="checkbox" name="chkok" id="chkok" onclick="chkAll();"/>
	  						</td>
	  						<td width="40px" align="center">序号</td>
	  						<td width="120px" align="center">系统</td>
	  						<td width="60px" align="center">功能编号</td>
	  						<td width="100px" align="center">功能名称</td>
	  						<td align="center">操作项</td> 
						</tr>
						<c:set value="initNum" var="rno" scope="request"></c:set><!-- right_sno初始判断值 -->
		<c:set value="0" var="num" scope="request"></c:set><!-- 序号列表计数初始值 -->
		<c:forEach var="li" items="${operList}">
			<c:if test="${li.right_sno!=rno}">
				<c:set value="${num+1}" var="num" scope="request"></c:set>
				<tr bgcolor="#FFFFFF" align="center" >
				<td  ><input type="checkbox" id="chekbx" name="chekbx" class="right_sno" value="${li.right_sno}"/></td>
				<td  >${num}</td>
				<td  >${li.right_sno}</td>
				<td  >
					${li.right_sname}
				</td>
				<td align="left">
				<c:forEach var="lst" items="${operList}">
					<c:if test="${li.right_sno==lst.right_sno}">
					<input type="checkbox" class="checkClass" name="operckb" id="operckb" value="${lst.oper_sno}-${lst.right_sno}-${lst.sysint_sno}"/>${lst.oper_sno}-${lst.oper_sname}
					</c:if>
				</c:forEach>
				</td>
				</tr>
			</c:if>
		<c:set value="${li.right_sno}" var="rno" scope="request"></c:set>
		</c:forEach>
		 </table>
							 
    				 
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    <input type="hidden" id="userId" name="userId" value="${vo.userid}"/>
  </form>
  </body>
</html>

