<%@ page language="java" import="java.util.*,com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList li=(ArrayList)request.getAttribute("dbOperList");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>角色管理</title>
<script language="javascript">
 function backPage(){
   document.all.roleFrm.action="role!find";
   document.all.roleFrm.submit();
}
 
  //保存角色权限
 function saveRoleOper(){
  if(validator()){
	if(confirm("是否保存？")){
	     $("#roleFrm").attr("action","role!saveRoledbOper");
	     $("#roleFrm").submit();
	 }
	}
 }
 function serachOper(){
 	$("#roleFrm").attr("action","role!todbOper");
 	$("#roleFrm").submit();
 }
 function chkAll()
 {
      var obj=document.all.checkid;
      var len=obj.length;
     if(document.all.chkok.value=="全选")
     {
       /*for(var i=0;i<len;i++)
       {
          obj[i].checked=true;
        }*/
        $('.checkThis').attr("checked",true);
        $('.checkClass').attr("checked",true);
        document.all.chkok.value="全取消";
     }else{
     
      /* for(var i=0;i<len;i++)
       {
          obj[i].checked=false;
       }*/
       $('.checkThis').attr("checked",false);
        $('.checkClass').attr("checked",false);
       document.all.chkok.value="全选";
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
    	var c = $(this).val(); 
    	for(var j=0; j<t.length; j++){
    		if(c==t[j]){
    			$(this).attr("checked",true);
    		}	
    	}
    });
    
    $(".checkThis").click(function(){
    	var ok = $(this).attr("checked");
    	var is = $(this).parent().siblings().eq(3).children("input");
    	is.each(function(){
    		$(this).attr("checked",ok);
    	});
    });
});
function sysintChange(){//更改系统
	document.roleFrm.action="<%=path %>/role!todbOper";
	document.roleFrm.submit();
}
function back(){
	document.roleFrm.action="<%=path%>/role!find";
	document.roleFrm.submit();
}
 </script>
 </head>
 <body>
<form   method="post" name="roleFrm"  id="roleFrm">
 <div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></div></td>
        </tr>
        </table>
    </td>
    <td width="16" valign="top" style="background: <%=path%>/images/mail_rightbg.gif">
    	<img src="<%=path%>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  </tr>
 <tr>
	<td valign="middle" style="background:<%=path%>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9" >
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#353c44">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="3%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="97%" valign="bottom"><span class="STYLE1"> 操作权限分配</span></td>
              									</tr>
            								</table>
            								</td></tr></table>
            								</td></tr></table>
            								</td></tr></table></td></tr></table>
 
<div id="div01" name="div01">
<div style="font-size:13px">
	<strong>角色编号:</strong>${vo.role_sno}&nbsp;&nbsp;
	<strong>角色名称:</strong>${vo.role_sname}&nbsp;&nbsp;
	<strong>角色类型 :</strong><s:if test="vo.role_stype==\"0\"">公共角色</s:if><s:if test="vo.role_stype==\"1\"">系统角色</s:if>&nbsp;&nbsp;
	<strong>所属系统：</strong>
	<select name="sysId" id="dict_sname" onchange="sysintChange(this)" valid="required" errmsg="请选择一个系统！">
    	<option value="">--请选择--</option>
	    <s:iterator value="list" var="v">
			<option value="${v.sysint_sno}" <s:if test="sysId==#v.sysint_sno">selected</s:if>>${v.sysint_sno}-${v.sysint_sname}</option>
		</s:iterator>
	</select>
	<!--<input type="button" name="" value="确定" onclick="serachOper();"/>
--></div>

<div style="background:#ffffff"> </div>
<table class="table" width="100%" border="0" cellpadding="0" cellspacing="0" >
	<tr  align="left">
			<td>
			<table border=1 cellpadding="0" cellspacing="0"  style="border-collapse:collapse">
			<tr style="height: 20" class="dictionary">	
				<td width="3%">选择</td>
				<td scope='col' class='listViewThS1' nowrap height="30" width="1%">
				<div style="white-space:nowrap;" align="center">序号 
				
				</div>
				</td>
				<td scope='col' class='listViewThS1' nowrap height="30" width="4%">
				<div style="white-space:nowrap;" align="center">功能编号 
				</div>
				</td>
				<td scope='col' class='listViewThS1' nowrap height="30" width="12%">
				<div style="white-space:nowrap;" align="center">功能名称
				</div>
				</td>
				<td scope='col' class='listViewThS1' nowrap height="30" >
				<div style="white-space:nowrap;" align="left">
				数据权限 
				 
				 <input type="button" name="chkok" id="chkok" value="全选" onclick="javascript:chkAll();" style="width:80px"/>
				
				</div>
				</td>
				<td>
					
				</td>
			</tr>
			
			<s:iterator var="v1" value="list3" status="s">
				<tr style="height: 20" class="dictionary">	
				<td  align='left' valign=top class='oddListRowS1' bgcolor='#ffffff' height="17" width="1%">
				<input type="checkbox" class="checkThis"/></td>
				<td  align='left' valign=top class='oddListRowS1' bgcolor='#ffffff' height="17" width="1%">
				<div style="white-space:nowrap;" align="center">${s.index+1 } 
				
				</div>
				</td>
				<td align='center' valign=top class="right_sno" bgcolor='#ffffff' height="17" width="10%">
				<div style="white-space:nowrap;" align="center">${v1.right_sno}
				</div>
				</td>
				<td  align='left' valign=top class='oddListRowS1' bgcolor='#ffffff' height="17" width="12%">
				<div style="white-space:nowrap;" align="center">${v1.right_sname }
				</div>
				</td>
				<td style="text-align:left;" align='left' valign=top class='oddListRowS1' bgcolor='#ffffff' height="17" >
				
				<s:iterator value="#v1.list" var="v2">		
				<input type="checkbox" class="checkClass" name="checkid" id="checkid" value="${v2.dboper_sno}:${v2.right_sno}"/>${v2.dboper_sname} &nbsp;
				</s:iterator>		
				
				</td>
			
			
			</tr>
			</s:iterator>
			
<!-- 隐藏该角色拥有的操作权限 -->
		<s:iterator value="oneDBOperList" var="v">
			<input class="oneOper" value="${v.dboper_sno}:${v.right_sno}" style="display:none"/>
		</s:iterator>


</table>
</td>
</tr>
</table>
 
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center">
			<input type="button" name="Submit" value="保存" class="button" onclick="saveRoleOper();"/>　
			<!-- window.history.go(-1); -->
			<input type="button" name="Submit2" value="返回" class="button" onclick="back();"/>
		</td>
        
      </tr>
    </table>
</div>
<input  type="hidden" name="checkedId" value="${vo.role_sno}"/>

</form>
</body>
</html>
