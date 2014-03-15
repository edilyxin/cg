<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
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
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base target="_self">
<title>员工查询</title>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/itemScreen.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/table.js"></script>
<script type="text/javascript" src="<%=path%>/common/js/cdate.js"></script>
<script type="text/javascript" src="<%=path%>/js/valid.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/My97DatePicker4.7/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=path%>/common/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/common/css/alter.css"  type="text/css"/>
<script type="text/javascript">

function find(){

 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("searchC1").value=document.getElementById("searchC").value;

 document.getElementById("searchE1").value=document.getElementById("searchE").value;
 document.all.frm.submit();
}
function returnVal(val1,val2,val3,val4,val5){
if (window.opener != undefined) {
       //for chrome
    window.opener.returnValue = val1+"|"+val2+"|"+val3+"|"+val4+"|"+val5;
}
else {
    window.returnValue = val1+"|"+val2+"|"+val3+"|"+val4+"|"+val5;
}
/**
alert(window.opener.dialogArguments[0]);
	//window.dialogArguments[0].value= val1;
	 window.opener.dialogArguments[0].value= val1;
	if(window.dialogArguments[1]!=undefined&&window.dialogArguments[1]!=null&&window.dialogArguments[1]!=""){
		window.dialogArguments[1].value= val2;
	}else{
		window.opener.dialogArguments[1].value= val1;
	}
	if(window.dialogArguments[2]!=undefined&&window.dialogArguments[2]!=null&&window.dialogArguments[2]!=""){
		window.dialogArguments[2].value= val3;
	}else{
		window.opener.dialogArguments[2].value= val1;
	}
	if(window.dialogArguments[3]!=undefined&&window.dialogArguments[3]!=null&&window.dialogArguments[3]!=""){
		window.dialogArguments[3].value= val4;
	}else{
		window.opener.dialogArguments[3].value= val1;
	}
	if(window.dialogArguments[4]!=undefined&&window.dialogArguments[4]!=null&&window.dialogArguments[4]!=""){
		window.dialogArguments[4].value= val5;
	}else{
		window.opener.window.dialogArguments[4].value= val1;
	}
	if(window.dialogArguments[5]!=undefined&&window.dialogArguments[5]!=null&&window.dialogArguments[5]!=""){
		window.dialogArguments[5].value= val6;
	}else{
		window.opener.window.dialogArguments[5].value= val1;
	}

**/
	
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
 

</script>
</head>

<body onload="getwidth()"  onresize="getwidth()">  
<form id="frm" name="frm" action="<%=path %>/tree!findEmp" method="post"  >
 <table width="100%" height="95%" border="0"  cellpadding="0" cellspacing="0" >
  <tr >
	    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=path %>/images/content-bg.gif">
	    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">职工信息</div></td>
	      </tr>
	    </table>
	    </td>
	    <td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>

  <tr>
    <td valign="middle" height="100%" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
     <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
        <tr style="font-size:12px;">
        <td   valign="top">
	<table width="100%" align="center"  border="0" class="STYLE10">
		<tr style="font-size:12px;">
	<td >
	
   <span  style="white-space:nowrap;">&nbsp;&nbsp;校区:
   <select   id="searchE" name="searchE">
   		<option value="">请选择</option>
   		<s:iterator value="udList" var="v">
   		<s:if test="%{#v.sh_sno==form.searchE}">
   			<option value="${v.sh_sno}" selected="selected">${v.sh_sname}-${v.sh_sno}</option>
   		</s:if>
   		<s:else>
   			<option value="${v.sh_sno}">${v.sh_sname}-${v.sh_sno}</option>
   		</s:else>
   		</s:iterator>
   </select>
     <span  style="white-space:nowrap;">&nbsp;&nbsp;
            学院:<input type="text" size="6"  id="searchB" name="searchB" value="${form.searchB}"  />		
   </span><span  style="white-space:nowrap;">&nbsp;&nbsp;系:
    <input type="text" size="6"  id="searchC" name="searchC" value="${form.searchC}"  />		
 	 </span>
    
   
    <input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}"/>
    <input type="hidden" id="searchC1" name="form.searchC" value="${form.searchC}"/>

    <input type="hidden" id="searchE1" name="form.searchE" value="${form.searchE}"/> 
    

   
    </span>
     <span  style="white-space:nowrap;">&nbsp;&nbsp;
                <a href="javaScript:void(0);"  style="cursor:hand" onclick="find();" >  <img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
      </span>
              	 <span  style="white-space:nowrap;">&nbsp;&nbsp;
              	 <a href="javaScript:void(0);"  style="cursor:hand" onclick="clearVal();" >  <img src="<%=path%>/images/pic3.jpg" width="15" height="15" border="0"/> 清空</a>
       </span>
</td>
					</tr>
		        </table>
         
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
				 <td height="24" bgcolor="#353c44">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
       
          <tr>
            <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 职工信息列表</span></td>
              </tr>
            </table>
            </td>
            
            <td>
            <div align="right">
           	<span class="STYLE1">
	         </span>
           	</div></td>
         
          </tr>
        </table>
        </td>
      </tr>
   
  <tr>
     <td id="idwidth">
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="100%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">	
     <tr>
		<td width="4%" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>序号</strong></div></td>
	      <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>工号</strong></div></td>
	      <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>姓名</strong></div></td>
	      <td width="4%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>性别</strong></div></td>
          <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>所属单位</strong></div></td>
          <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>所属学院</strong></div></td>
          <td width="14%"  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>所属系</strong></div></td>
          <td width="14%"  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><strong>所属校区</strong></div></td> </tr>
          <s:iterator value="treeList"  status="s" var="emp">
	
	<tr align="center" bgcolor="#FFFFFF" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#emp.emp_sno"/>','<s:property value="#emp.emp_sname"/>','${emp.emp_stele}','${emp.job_sname}','${emp.post_sname}')">
 
	   <td height="24"  >${s.index+1 }</td>
	  <td height="24" align="center"  title="<s:property value="#emp.emp_sno"/>"><s:property value="#emp.emp_sno"/></td>
	  <td height="24" ><s:property value="#emp.emp_sname"/></td>
	  <td height="24" >
	  <s:if test="#emp.emp_sgender==\"0\"">
	  		 女	
	  	</s:if>
	  	<s:elseif test="#emp.emp_sgender==\"1\"">
       		男
   		</s:elseif> 
   		</td>
   	  <td  title="${emp.ud_sname}">
									<s:if test="%{#emp.comp_sname.length() <= 15}">${emp.ud_sname}</s:if>
									<s:else><s:property value="%{#emp.ud_sname.substring(0,15) + '...'}"/></s:else>
								</td>
   	  <td  title="${emp.ud_sname1}">
									<s:if test="%{#emp.ud_sname.length() <= 10}">${emp.ud_sname1}</s:if>
									<s:else><s:property value="%{#emp.dep_sname.substring(0,10) + '...'}"/></s:else>
								</td>
   	  <td  title="${emp.ud_sname2}">
									<s:if test="%{#emp.ud_sname2.length() <= 10}">${emp.ud_sname2}</s:if>
									<s:else><s:property value="%{#emp.ud_sname2.substring(0,10) + '...'}"/></s:else>
								</td>
   	  <td  title="${emp.sh_sname}">
									<s:if test="%{#emp.sh_sno.length() <= 10}">${emp.sh_sname}</s:if>
									<s:else><s:property value="%{#emp.sh_sno.substring(0,10) + '...'}"/></s:else>
								</td>										 
	</tr>
	</s:iterator>
  			
          
    </table>
</div></td></tr>
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
       <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"/></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<!-- ud_sno,ud_sno1,ud_sno2,ud_sno3,sh_sno,job_sno,emp_sno -->
<input type="hidden" name="form.ud_sno" value="${form.ud_sno}"/>
<input type="hidden" name="form.ud_sno1" value="${form.ud_sno1}"/>
<input type="hidden" name="form.ud_sno2" value="${form.ud_sno2}"/>
<input type="hidden" name="form.ud_sno3" value="${form.ud_sno3}"/>
<input type="hidden" name="form.sh_sno" value="${form.sh_sno}"/>
<input type="hidden" name="form.job_sno" value="${form.job_sno}"/>
<input type="hidden" name="form.emp_sno" value="${form.emp_sno}"/>
<input type="hidden" id="searchG" name="form.searchG" value="${form.searchG}"/> 
<input type="hidden" id="searchF" name="form.searchF" value="${form.searchF}"/> 
</form>
  
</body>
</html>

