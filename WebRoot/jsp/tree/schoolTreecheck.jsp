<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	String sno=request.getParameter("sh_sno");
%>
   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="/common/util.jsp" />
<head>   
<base target="_self">
<title>校区查询</title>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/itemScreen.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/table.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/cdate.js"></script>
<script type="text/javascript" src="<%=path%>/js/valid.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/My97DatePicker4.7/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=path%>/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/css/alter.css"  type="text/css"/>
<script type="text/javascript">

function find(){
 document.getElementById("searchA1").value=document.getElementById("searchA").value;
 document.form1.action="<%=path%>/tree!findSchoolcheck";
 document.all.form1.submit();
}
  //保存
  function toAdd(){   
      var val1="";
      var val2="";
      $(".checkClass:checked").each(function(){
       val1=$(this).parent().parent().siblings().eq(1).text()+","+val1;
       val2=$(this).parent().parent().siblings().eq(2).text()+","+val2;  
      });
       
      val1= val1.substring(0,val1.length-1);
      val2= val2.substring(0,val2.length-1);
      
      if (window.opener != undefined) {
	       //for chrome
	    window.opener.returnValue = val1+"|"+val2;
	}
	else {
	    window.returnValue = val1+"|"+val2;
	}
	  window.close();	

}
  function clearVal(){
		if (window.opener != undefined) {
	       //for chrome
	   	 window.opener.returnValue = "";
		}
		else {
	    window.returnValue = "";
		}
		window.close();	
	}
//获得divwidth的宽度
	function getwidth(){
		document.getElementById("divwidth").style.width= document.body.offsetWidth-50;
			document.getElementById("divwidth").style.width= document.getElementById("idwidth").offsetWidth;
			if(document.getElementById("table1").offsetWidth>document.getElementById("divwidth").offsetWidth){
				document.getElementById("divwidth").style.paddingBottom = "17px";
			}else{
				document.getElementById("divwidth").style.paddingBottom = "0px";
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
    $(function(){
    	var sno = "<%=sno%>";
   
    	if(sno!=null||sno!=""){
    	 no= new Array();
    	 no=sno.split(",");
    
    	 for(var i=0 ;i<no.length;i++){
    		
    	 $("input[name='idcheckbox']").each(function(){
    		 var shno = $(this).val();
    		if(no[i]==shno){
    			$(this).attr("checked", true);
    		} 
    	 });
    	 
//    alert(no.length);
    	 }
    }
    });

</script>
</head>

<body onload="getwidth()"  onresize="getwidth()">  
<form id="form1" name="form1" action="<%=path %>/tree!findSchool" method="post"  >
 

<table width="100%"  border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="<%=path%>/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">校区信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="<%=path%>/images/mail_rightbg.gif"><img src="<%=path%>/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>

  <tr>
    <td valign="middle" background="<%=path%>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
      <tr >
        <td   valign="top">
        <table width="95%" border="0"  cellspacing="2" >
  <tr style="font-size:12px;" align="left">
    <td >
    <span  style="white-space:nowrap;">&nbsp;&nbsp;
           校区编号:<input type="text" size="6"  id="searchA" name="searchA" value="${form.searchA}"  />
   <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
    <input type="hidden" 	name="form.ud_sno" value="${form.ud_sno}"/>
    <input type="text" size="6"  id="searchB"  value="<%=sno %>"  />
    </span>
     
    <a href="#" onclick="find()" ><img src="<%=path%>/images/add_min.gif" width="10" height="10" border="0"/> <span  style="color:black;">查询</span></a>&nbsp;
	 
	<span class="STYLE1" style="color:red;">（校区可以选择多个）</span>
</td>
  </tr>
</table>
    	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">校区信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right">
            
	            	<span class="STYLE1">
						
						<a href="#" onclick="toAdd();" ><img src="<%=path %>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">提交</span></a>&nbsp;  
      					<a href="#" onclick="clearVal();"><img src="<%=path%>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">关闭</span></a>&nbsp;
	                </span>
	           
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
        <td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="850"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr>
		<td width="40" height="24" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">
		<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  />
		</span></div></td>
	      	<td width="40" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>序号</strong></div></td>
			<td width="150" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区编号</strong></div></td>
			<td width="150" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区名称</strong></div></td>
			<td width="150" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区简称</strong></div></td>
			<td width="" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区地址</strong></div></td>
			<td width="150" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>校区类型</strong></div></td>
        </tr>
<s:iterator value="treeList"  status="s" var="sh">
		<tr align="center" bgcolor="#FFFFFF" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;">
      
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="idcheckbox" onclick="checkOne();"  class="checkClass" value="${sh.sh_sno}" ondblclick="returnVal('<s:property value="#sh.sh_sno"/>','<s:property value="#sh.sh_sname"/>')"/>
        </div></td>
	   <td  bgcolor="#ffffff" class="STYLE19">${s.index+1 }</td>
	  <td align="center" bgcolor="#FFFFFF" class="STYLE19"><s:property value="#sh.sh_sno"/></td>
	  <td height="20" bgcolor="#ffffff" class="STYLE19"><s:property value="#sh.sh_sname"/></td>
	 	<td height="20" bgcolor="#ffffff" class="STYLE19"><s:property value="#sh.sh_ssname"/></td>
	 	<td height="20" bgcolor="#ffffff" class="STYLE19"><s:property value="#sh.sh_sadder"/></td>
	 	<td height="20" bgcolor="#ffffff" class="STYLE19">
	 	<s:if test="%{#sh.sh_stype==\"0\"}">主校区</s:if>
	 	<s:if test="%{#sh.sh_stype==\"1\"}">附校区</s:if>
	 	</td>
	</tr>
	</s:iterator>
</table>    </div></td>   
  <tr>
    <td height="30">
   	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="30">
    <div align="center"  >
    				<s:if test="%{treeList.size()!=0}">
    			
    			<page:page uri="/tree!findEmp"></page:page>
    				</s:if>
    				<s:elseif test="%{treeList.size()==0}">
    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
    				</s:elseif>
    			 </div></td></tr>
      
    </table>
    </td>
  </tr>
</table>
    	</td> 
    	</tr>
    </table>
    </td>
    <td background="<%=path%>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td  valign="bottom" background="<%=path%>/images/mail_leftbg.gif"><img src="<%=path%>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path%>/images/buttom_bgs.gif"><img src="<%=path%>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path%>/images/mail_rightbg.gif"><img src="<%=path%>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</form>
           	
</body>
</html>

