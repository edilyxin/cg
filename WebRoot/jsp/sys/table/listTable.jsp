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
<title>数据库表管理</title> 

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

 function toUpdate(){
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
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？")) 
	 {
		document.form1.action="seq!toUpdate";
		document.form1.submit();
	 }
	
}

function toAdd(){
	$("#form1").attr("action","seq!toAdd");
	$("#form1").submit();
}
function del(){
	$("#form1").attr("action","seq!toDelete");
	$("#form1").submit();
}
function changeValid(){
	$("#form1").attr("action","seq!changeValid");
	$("#form1").submit();
}
function find(){
	$("#form1").attr("action","seq!table");
	$("#form1").submit();
}
 
</script>
</head>

<body  >
<form name="form1"  id="form1"  method="post"  >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>数据库表管理</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB">
					<td height="30" align="left">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;中文表名:<input type="text" name="form1.searchB" value="${form1.searchB}" /></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;英文表名:<input type="text" name="form1.searchC" value="${form1.searchC}" /></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
                	
			 
				
				</td>
			</tr>
        </table>
         
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1" style="white-space:nowrap;">数据库列表</span></td>
              </tr>
            </table></td>
            <td>
	            <div align="right">
	        <span class="STYLE1" style="white-space:nowrap;">    	
			<a href="#" onclick="toAdd()" ><img src="<%=path %>/images/add_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">下载模板</span></a>&nbsp; 
			<a href="#" onclick="toUpdate();"><img src="<%=path %>/images/edit_min.gif" width="10" height="10" border="0"/> <span class="STYLE1">导入</span></a>&nbsp;
			
	          </span>
	           </div>
           </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td id="idwidth">
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="100%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr >
	  	<td width="40px" height="20" bgcolor="d3eaef" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
	  	</td>
	  	<td width="40px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
	  	<td width="120px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">表ID</span></div></td>
	  	<td width="160px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">系统</span></div></td>
	  	<td width="160px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">中文名</span></div></td>
		<td width="120px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">英文名</span></div></td>
		<td width="120px"  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">主键的字段名</span></div></td>
		<td width="80px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">主键字段中文名</span></div></td>
		<td width="180px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">是否启用</span></div></td>
		<td width="180px" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></td>
		</tr>
		
		<s:iterator value="list" var="v" status="s">
      	<tr >
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="idcheckbox" value="${v.tbl_scode}" onclick="checkOne();"   />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">${s.index+1}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${v.tbl_scode}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${v.sysint_sname}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${v.tbl_sname}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${v.tbl_scode}</div></td> 
         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${v.tbl_skeyfldCode}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${v.tbl_skeyfldName}</div></td> 
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
         <s:if test="#v.tbl_sisstat==0">启用</s:if><s:else>停用</s:else>
         </div></td>
         <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"></div></td> 
      </tr>
      </s:iterator>
	  
    </table>
   </div>
   </td>
  </tr>

  <tr>
 
    <td height="30"> 
    
<!-- 分页标签BEGIN -->
			<s:if test="list.size()!=0">
				<page:page uri="/seq!table"></page:page>
			</s:if>
			<s:elseif test="list.size()==0">
				<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
			</s:elseif>
		 
<!-- 分页标签END -->

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
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
 
</table>

</form>
</body>
</html>
