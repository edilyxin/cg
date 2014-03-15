<%@ page language="java" import="java.util.*,com.rc.base.form.*,com.rc.base.vo.*"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ArrayList li=(ArrayList)request.getAttribute("udList"); // 一级部门
ArrayList li2=(ArrayList)request.getAttribute("treeList");//后来的部门
Integer levels=(Integer)request.getAttribute("levels");//部门层次
String switchs =(String)request.getAttribute("switchs");//开关控制
//清缓存  
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>

<script src="<%=path %>/js/prototype.lite.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.pack.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/js/glass_tree.js"></script>
<link  href="<%=path %>/css/left.css" rel="stylesheet" type="text/css" />
<link  href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var path="<%=path%>/";
//0不能选择，1能选择，必须是六位数
function returnVal(val1,val2){
<%=levels%>
var switch1 = "<%=switchs%>";
var q = switch1.substring(0,1);
var q1 = switch1.substring(1,2);
var q2 = switch1.substring(2,3);
var q3 = switch1.substring(3,4);
var q4 = switch1.substring(4,5);
var q5 = switch1.substring(5,6);
if(val1.indexOf("->")>-1){
	var a  = val1.split("->");
	var b  = val2.split("->");
	if(a.length==2&&q1=="0"){
		alert("第二层次的单位不能被选择");
		return;
	}	
	else if(a.length==3&&q2=="0"){
		alert("第三层次的单位不能被选择");
		return;
	}
	else if(a.length==4&&q3=="0"){
		alert("第四层次的单位不能被选择");
		return;
	}
	else if(a.length==5&&q4=="0"){
		alert("第五层次的单位不能被选择");
		return;
	}	
	else if(a.length==6&&q5==0){
		alert("第六层次的单位不能被选择");
		return;
	}
}else{
	if(q==0){
		alert("第一层次的单位不能被选择");
		return;
	}		
}
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
</script>

</head>
<body>
 <form  name="form1" method="post">
 	<input type="hidden" name="form.searchA" id="searchA" value="${form.searchA}"/>
 	<input type="hidden" name="form.ud_stype"  value="${form.ud_stype}"/>
 	<input type="hidden" name="ud_snos" id="ud_snos" value="${ud_snos}"/>
 	<input type="hidden" name="switchs" id="switchs" value="${switchs}"/>
 	<input type="hidden" name="form.ud_stype" id="ud_stype" value="${form.ud_stype}"/>
 	
 </form>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td nowrap valign="top" align="left"><!--菜单树开始--> 
                  			<script language="javascript"> 
                  			
						    if (document.getElementById)
							 {
							 var t0=new WebFXTree("<b>单位信息管理</b>","","");
						     //	var t0=new WebFXTree('<b>部门信息管理</b>','','');   //头
						     	//系统集合不为空  li2是一级部门即为ud_nnumber='1'
						     	<%
							     	if(li!=null){
							     		for(int j=0;j<li.size();j++){
							     			MngUnitDepart sys = (MngUnitDepart)li.get(j);//取一个系统getSysint_sno				     %>
							     	var node<%=sys.getUd_sno()%> = new WebFXTreeItem("<%=sys.getUd_sname()%>","<%=sys.getUd_sno()%>","<%=sys.getUd_sname()%>","<%=switchs%>");
							     	 t0.add(node<%=sys.getUd_sno()%>);
							     <%		//取一系统下所有功能sr是下一级部门
									     if(li2!=null){//System.out.println(li);
									    
									     String id = "";
									     		for(int i=0;i<li2.size();i++){	   			
									     			 MngUnitDepart sr=(MngUnitDepart)li2.get(i);	
									     			     			 //&&sr.getUd_nnumber().equals('2')
									     			 if(sr.getUd_stopno().equals(sys.getUd_sno())&&sr.getUd_nnumber().equals(Long.parseLong("2"))){//系统oneRIGHT_SPARENTNO//sys.getUd_sno().equals(sr.getUd_stopno())				     			 	
									     			 	id = sr.getUd_sno();
									     			 	%>
									     			 		var node<%=id%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");
									     			 		
									     			 	<%
									     			 	 	
									     			 }else{
									     			 //第三层及以下    取大功能下的小功能&&sr.getUd_nnumber().equals('3')//id.equals(sr.getUd_stopno())
									     			 for(Integer k=3;k<=levels;k++){
									     			  	if(sr.getUd_stopno()!=null&&!"".equals(id)&&sr.getUd_nnumber().equals(k.longValue())){
									     			  	
									     			  	if(k==3){
									     			  		
									     			  	
									     			 	%>
									     			 		var node<%=sr.getUd_sno()%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno2()%>-><%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname2()%>-><%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");	
									     			 		
									     			 	<%
									     			   }else if(k == 4){
									     			   	%>
									     			 		var node<%=sr.getUd_sno()%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno3()%>-><%=sr.getUd_sno2()%>-><%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname3()%>-><%=sr.getUd_sname2()%>-><%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");	
									     			 		
									     			 	<%
									     			   }
									     			   else if(k == 5){
									     			   	%>
									     			 		var node<%=sr.getUd_sno()%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno4()%>-><%=sr.getUd_sno3()%>-><%=sr.getUd_sno2()%>-><%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname4()%>-><%=sr.getUd_sname3()%>-><%=sr.getUd_sname2()%>-><%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");	
									     			 		
									     			 	<%
									     			   }else if(k == 6){
									     			   	%>
									     			 		var node<%=sr.getUd_sno()%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno5()%>-><%=sr.getUd_sno4()%>-><%=sr.getUd_sno3()%>-><%=sr.getUd_sno2()%>-><%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname5()%>-><%=sr.getUd_sname4()%>-><%=sr.getUd_sname3()%>-><%=sr.getUd_sname2()%>-><%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");	
									     			 		
									     			 	<%
									     			   }else{
									     			   	%>
									     			 		var node<%=sr.getUd_sno()%>= new WebFXTreeItem("<%=sr.getUd_sname() %>","<%=sr.getUd_sno5()%>-><%=sr.getUd_sno4()%>-><%=sr.getUd_sno3()%>-><%=sr.getUd_sno2()%>-><%=sr.getUd_sno1()%>-><%=sr.getUd_sno()%>","<%=sr.getUd_sname5()%>-><%=sr.getUd_sname4()%>-><%=sr.getUd_sname3()%>-><%=sr.getUd_sname2()%>-><%=sr.getUd_sname1()%>-><%=sr.getUd_sname()%>","<%=switchs%>");	
									     			 		
									     			 	<%
									     			   }
									     			  
									     			   }
									     			}
									     		}
									     		}}}	
									     		if(li2!=null){
									     		for(int i=0;i<li2.size();i++){	   			
									     			 MngUnitDepart sr=(MngUnitDepart)li2.get(i);	
									     		 %>
									     		 node<%=sr.getUd_stopno()%>.add(node<%=sr.getUd_sno()%>);
									     		<%
									     		}
									     		
									     	}
							     							     	
							     	}	
						    	%>
						     	
						     	
																															
								    document.write(t0);
								    t0.expand();
						     	}
								
								</script> 
								<input type="hidden" name="selText">
								<input type="hidden" name="iSize">
								<input type="hidden" name="selTreeID">
								<input type="hidden" name="selNodeID">
                  	<!--菜单树结束--> </td>
	</tr>
</table>


</body>
</html>
