<%@ page language="java" import="java.util.*,com.rc.sys.form.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList li=(ArrayList)request.getAttribute("operList");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>角色管理</title>
<script language="javascript">
 function backPage(){
   document.all.roleFrm.action="<%=path %>/role!find";
   document.all.roleFrm.submit();
}
 
  //保存角色权限
 function saveRoleOper(){ 
     var checkedId = $("#checkedId").html();
	 $("#roleFrm").attr("action","<%=path %>/role!saveRoleOper?checkedId="+checkedId);
     $("#roleFrm").submit();
 }
 function chkAll()
 {
      var obj=document.all.checkid;
      var len=obj.length;
     if(document.all.chkok.checked==true)
     {
       for(var i=0;i<len;i++)
       {
          obj[i].checked=true;
        }
        $('.checkThis').attr("checked",true); 
     }else{
     
       for(var i=0;i<len;i++)
       {
          obj[i].checked=false;
       }
       $('.checkThis').attr("checked",false); 
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
    	var c = $(this).val().split(":")[0]; 
    	for(var j=0; j<t.length; j++){
    		if(c==t[j]){
    			$(this).attr("checked",true);
    		}	
    	}
    });
    
    
    $(".checkThis").click(function(){
    	var ok = $(this).attr("checked");
    	var is = $(this).parent().siblings().eq(4).children("span").children("input");
    	is.each(function(){
    		$(this).attr("checked",ok);
    	});
    });
});
 </script>
 </head>
 <body>
<form  method="post" name="roleFrm" id="roleFrm" >
 <div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span></h2>
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
                									<td width="94%" valign="bottom"><span class="STYLE1">操作权限分配</span></td>
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
					     				<td nowrap align="right" width="15%">角色编号:</td>
					    				<td nowrap width="15%" id="checkedId">${vo.role_sno}</td>
					    				<td nowrap align="right" width="15%" >角色名称:</td>
					    				<td nowrap width="15%">
					    					${vo.role_sname}
					    				</td>
					    				<td nowrap align="right" width="15%" >角色类型:</td>
					    				<td nowrap >
					    					 <s:if test="vo.role_stype==\"0\"">公共角色</s:if><s:if test="vo.role_stype==\"1\"">系统角色</s:if>
	 										 <input type="hidden" name="form.rro_sdef1" id="rro_sdef1" value="${vo.sysint_sno}"/>
					    				</td>
					    			</tr>
					   			</table>
							</td>
      					</tr>
    				</table>
    				<table width="100%"  id="table1"      border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
						<tr bgcolor="d3eaef" class="STYLE10">
	  						<td width="40px" align="center" height="20" >
								<input type="checkbox" name="chkok" id="chkok" onclick="javascript:chkAll();"/>
	  						</td>
	  						<td width="40px" align="center">序号</td>
	  						<td width="120px" align="center">系统</td>
	  						<td width="60px" align="center">功能编号</td>
	  						<td width="100px" align="center">功能名称</td>
	  						<td align="center">操作项</td> 
						</tr>
						
				<!-- 隐藏该角色拥有的操作权限 -->
						<s:iterator value="OneOperList" var="v">
							<input type="hidden" class="oneOper" value="${v.oper_sno}" />
						</s:iterator> 
						<% 
		     if(li!=null){
		       String funcSNo="";
		       int j=0;
		       int k=0;
		       for(int i=0;i<li.size();i++){
		           MngOperForm avo=(MngOperForm)li.get(i);
		           if (avo.getRight_sno().equals(funcSNo)){  %>
							  <span style="white-space:nowrap;"><input type="checkbox" class="checkClass" name="checkid" id="checkid" value="<%=avo.getOper_sno() %>:<%=avo.getRight_sno() %>:<%=avo.getSysint_sno() %>" ><%=avo.getOper_sno() %>:<%=avo.getOper_sname() %>&nbsp;&nbsp;&nbsp;&nbsp;</span>							 
						  <%  
		            }else{
		                funcSNo=avo.getRight_sno();
		                if(j>0)
		                {
		              
		     %>
                          
                      <%} 
                        j++;%>
				    <tr bgcolor="#ffffff" class="STYLE19">
						    <td align="center"><input type="checkbox" class="checkThis"/></td>
							<td align="center"><%=j %></td>
							<td align="center"><%=avo.getSysint_sname() %></td>
							<td align="center" class="right_sno"><%=avo.getRight_sno() %></td>
							<td align="center">
							<%=avo.getRight_sname() %>
							</td>
							<td align='left' >
							  <span style="white-space:nowrap;"><input type="checkbox" class="checkClass" name="checkid" id="checkid" value="<%=avo.getOper_sno() %>:<%=avo.getRight_sno() %>:<%=avo.getSysint_sno() %>"><%=avo.getOper_sno() %>:<%=avo.getOper_sname() %>&nbsp;&nbsp;&nbsp;&nbsp;</span>
							 <%  
						}
				 	}
				 	if(j>0){%>
				     </td>
	             	</tr>		
	    	<%      }
	    	   } %>
		 </table>
							 
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="saveRoleOper();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="window.location.reload();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="window.history.go(-1);"  />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    
  </form>
  </body>
</html>