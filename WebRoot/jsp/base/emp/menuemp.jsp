<%@ page language="java" import="java.util.*,com.rc.base.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList udlist=(ArrayList)request.getAttribute("udlist");  //单位集合
 
Integer levels=(Integer)request.getAttribute("levels");//部门层次

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="main1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script src="<%=path %>/js/prototype.lite.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.js" type="text/javascript"></script>
<script src="<%=path %>/js/moo.fx.pack.js" type="text/javascript"></script>

<link  href="<%=path %>/css/left.css" rel="stylesheet" type="text/css" />
<link  href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var path="<%=path%>/";

</script>
<script src="<%=path %>/js/new_tree.js" type="text/javascript"></script>
</head>
<body>
  
 <form  name="form1" method="post">

 	<input type="hidden"  name="form.searchA" id="searchA" >
 	<input type="hidden"  name="form.searchB" id="searchB" >
 	 	<input type="hidden"  name="form.searchE" id="searchE" >
 	<input type="hidden"  name="form.ud_sname" id="ud_sname" >
 	<input type="hidden"  name="form.ud_sname1" id="ud_sname1" >
 	<input type="hidden"  name="form.ud_sname2" id="ud_sname2" >
 	
 	

 	<input type="hidden"  name="form.sh_sname" id="sh_sname" >
 	<input type="hidden"  name="menu" id="menu" >
<!-- 	<input type="hidden"  name="idcheckbox" id="idcheckbox" >-->
 </form>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td nowrap valign="top" align="left"><!--菜单树开始--> 
                  			<script language="javascript"> 
     								 if (document.getElementById){
     								 	var node0=new WebFXTree("<b>单位部门</b>","<%=path%>/emp!find","searchA=|searchB=|searchE=|menu=|ud_sname=|ud_sname1=|ud_sname2=");
     								 	
     								 <%	
     								 	if(udlist!=null){
     								 		for(int m = 0; m < udlist.size(); m++){
     								 			MngUnitDepart ud = (MngUnitDepart) udlist.get(m);
     								 			%>
     								 			var node<%=ud.getUd_sno()%> = new WebFXTreeItem("<%=ud.getUd_sname() %>","<%=path%>/emp!find","searchA=<%=ud.getUd_nnumber()==1?ud.getUd_sno():(ud.getUd_nnumber()==2?ud.getUd_stopno():(ud.getUd_nnumber()==3?ud.getUd_sno2():""))  %>|searchB=<%=ud.getUd_nnumber()==2?ud.getUd_sno():(ud.getUd_nnumber()==3?ud.getUd_stopno():"") %>|searchE=<%=ud.getUd_nnumber()==3?ud.getUd_sno():""%>|menu=0|ud_sname=<%=ud.getUd_nnumber()==1?ud.getUd_sname():(ud.getUd_nnumber()==2?ud.getUd_sname1():(ud.getUd_nnumber()==3?ud.getUd_sname2():"")) %>|ud_sname1=<%=ud.getUd_nnumber()==2?ud.getUd_sname():(ud.getUd_nnumber()==3?ud.getUd_sname1():"")%>|ud_sname2=<%=ud.getUd_nnumber()==3?ud.getUd_sname():""%>");
												node<%=ud.getUd_stopno()==null?"0":ud.getUd_stopno() %>.add(node<%=ud.getUd_sno()%>);
     								 		<%
     								 		}
     								 	}
     								 	
     								 %>	
     								 	document.write(node0);
								    	node0.expand();
     								 }
     								 
     								 
     								 
     								 
     			
							 
//							 		 if (document.getElementById)
//							 {
//						     	var t0=new WebFXTree("<b>单位信息</b>","<%=path%>/houseType!find","searchA=|menu=|ud_sname=");
//						     	var node0 = new WebFXTreeItem("校总医院1","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=校总医院1");
//						        t0.add(node0);
//								var node01 = new WebFXTreeItem("急症室1","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=急症室1");
//						        node0.add(node01);
//						        var node02 = new WebFXTreeItem("手术室1","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=手术室1");
//						        node0.add(node02);
//						        
//						        var node1 = new WebFXTreeItem("校分医院2","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=校分医院2");
//						        t0.add(node1);
//						        var node03 = new WebFXTreeItem("急症室2","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=急症室2");
//						        node1.add(node03);
//						        var node04 = new WebFXTreeItem("手术室2","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=手术室2");
//						        node1.add(node04);
//						         var node2 = new WebFXTreeItem("校分医院3","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=校分医院3");
//						        t0.add(node2);
//						        var node05 = new WebFXTreeItem("急症室3","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=急症室3");
//						        node2.add(node05);
//						        var node06 = new WebFXTreeItem("手术室3","<%=path%>/houseType!find","searchA=1|menu=0|ud_sname=手术室3");
//						        node2.add(node06);
//						        
//						        																				
//																											
//								    document.write(t0);
//								    t0.expand();
//						     	}
								
							 
							 
							 
							 
							 
							 
							 
							 
								 
							
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

