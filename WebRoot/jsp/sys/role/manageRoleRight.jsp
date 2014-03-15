<%@ page language="java" import="java.util.*,com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>

<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%
MngRole voi=(MngRole)request.getAttribute("r");
if(voi==null)
{
   voi=new MngRole();
}

String path = request.getContextPath();
ArrayList li=(ArrayList)request.getAttribute("list");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
 
    <title>修改功能权限</title>
<!--  <script src="<%=path %>/js/tree/selectjs.js" type=text/javascript></script> -->
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script type="text/javascript" src="<%=path %>/js/valid.js"></script>
<script type="text/javascript">
	function confirmForm() {  //确认选择框
  	if(confirm("您确定此操作吗?")) {
  		return true;
  	} else {
  		return false;
  	}
  }
	function deleteMulti_onClick(){  
    if(confirm("是否保存？"))
	 {
	document.form1.action="<%=path%>/role!addRight";
	document.form1.submit();
	}
   
  }
	function auType_onChange() {
		if(document.form1.select2.value=="1")
			location.href = "manageDataAuthorize.htm";
		else if(document.form1.select2.value=="2")
			location.href = "manageFuncAuthorize.htm";
		else if(document.form1.select2.value=="3")
			location.href = "manageRole.htm";
		else
		;
	}
</script>
<!-- <script type="text/javascript" src="common/js/jquery-1.4.2.min.js"></script> -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript">
var rootIcon       = "<%=path%>/images/tree_img/root_close.gif"; 	
var openRootIcon   = "<%=path%>/images/tree_img/root_open.gif"; 	
var folderIcon     = "<%=path%>/images/tree_img/folder_close.gif";	
var openFolderIcon = "<%=path%>/images/tree_img/folder_open.gif";	
var fileIcon       = "<%=path%>/images/tree_img/tree_linker.gif";	
var iIcon          = "<%=path%>/images/tree_img/i_line.gif";	
var lIcon          = "<%=path%>/images/tree_img/l_line.gif";	
var lMinusIcon     = "<%=path%>/images/tree_img/l_point_open.gif";
var lPlusIcon      = "<%=path%>/images/tree_img/l_point_close.gif";
var tIcon          = "<%=path%>/images/tree_img/t_line.gif";	
var tMinusIcon     = "<%=path%>/images/tree_img/t_point_open.gif";	
var tPlusIcon      = "<%=path%>/images/tree_img/t_point_close.gif";
var blankIcon      = "<%=path%>/images/tree_img/blank.gif";	

var defaultText    = "Tree Item";
var defaultAction  = "";
var targetStr="main";
var bgcolor_sel="#FFCC99";
var selectedObj = null;
var treeBkColor="F3F3F3";

var preID="-1";

var webFXTreeHandler = {
	idCounter : 0,
	idPrefix  : "webfx-tree-object-",
	all       : {},
	behavior  : "classic",
	getId     : function () { return this.idPrefix + this.idCounter++; },
	toggle    : function (oItem) { this.all[oItem.id.replace("-plus","")].toggle(); },
	select    : function (oItem) { this.all[oItem.id.replace("-icon","")].select(); },
	focus     : function (oItem) { this.all[oItem.id.replace("-anchor","")].focus(); },
	blur      : function (oItem) { this.all[oItem.id.replace("-anchor","")].blur(); }
};

function WebFXTree(sText, sAction, sBehavior) {
	this._subItems = [];
	this.id        = webFXTreeHandler.getId();
	this.text      = sText || defaultText;
	this.action    = sAction || defaultAction;
	this._wasLast  = false; 
	this.open      = (getCookie(this.id.substr(18,this.id.length - 18)) == "0")?false:true;
	this.icon      = rootIcon;
	this.openIcon  = openRootIcon;
	this.target	   = targetStr;
	webFXTreeHandler.behavior =  sBehavior || "classic";
	webFXTreeHandler.all[this.id] = this;
}

WebFXTree.prototype.setBehavior = function (sBehavior) {
	webFXTreeHandler.behavior =  sBehavior;
};
WebFXTree.prototype.getBehavior = function (sBehavior) {
	return webFXTreeHandler.behavior;
};

WebFXTree.prototype.add = function (treeItem) {
	treeItem.parent = this;
	this._subItems[this._subItems.length] = treeItem;
};

WebFXTree.prototype.toString = function () {
	var str = "<div id=\"" + this.id + "\" ondblclick=\"webFXTreeHandler.toggle(this);\" class=\"webfx-tree-item\">";
	str += "<table height=\"10\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"10\">";
	str += "<img id=\"" + this.id + "-icon\" src=\"" + ((webFXTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"change(this);\">";
	str += "</td><td valign=\"bottom\" nowrap>&nbsp; <onclick=\"treeitem_Click('" + this.id + "');\" onDblClick=\"treeitem_DblClick('" + this.action + "','"+this.text+"');\" id=\"" + this.id + "-anchor\" onfocus=\"webFXTreeHandler.focus(this);\">" + this.text + "</td></tr></table></div>";
	str += "<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
	for (var i = 0; i < this._subItems.length; i++) {
		str += this._subItems[i].toString(i,this._subItems.length);
	}
	str += "</div>";	
	return str;
};

WebFXTree.prototype.getSelected = function () {
	if (selectedObj) { return selectedObj.id; }
	else { return null; }
}

WebFXTree.prototype.toggle = function () {
	if (this.open) { this.collapse(); }
	else { this.expand(); }
}

WebFXTree.prototype.select = function () {
	document.getElementById(this.id + '-anchor').focus();
}

WebFXTree.prototype.focus = function () {
	if (selectedObj) { selectedObj.blur(); }
	selectedObj = this;
	if ((this.openIcon) && (webFXTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.openIcon; }
	document.getElementById(this.id + '-anchor').style.color = '#E77B39';
}

WebFXTree.prototype.blur = function () {
	if ((this.openIcon) && (webFXTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.icon; }
	document.getElementById(this.id + '-anchor').style.color = '#000000';
}

WebFXTree.prototype.expand = function () {
	if (webFXTreeHandler.behavior == 'classic') {
		document.getElementById(this.id + '-icon').src = this.openIcon;
	}
	document.getElementById(this.id + '-cont').style.display = 'block';
	this.open = true;
	setCookie(this.id.substr(18,this.id.length - 18), '1');
}

WebFXTree.prototype.collapse = function () {
	if (webFXTreeHandler.behavior == 'classic') {
		document.getElementById(this.id + '-icon').src = this.icon;
	}
	document.getElementById(this.id + '-cont').style.display = 'none';
	this.open = false;
	setCookie(this.id.substr(18,this.id.length - 18), '0');
}

WebFXTree.prototype.expandAll = function () {
	this.expandChildren();
	this.expand();
}

WebFXTree.prototype.expandChildren = function () {
	for (var i = 0; i < this._subItems.length; i++) {
		this._subItems[i].expandAll();
	}
}

WebFXTree.prototype.collapseAll = function () {
	this.collapse();
	this.collapseChildren();
}

WebFXTree.prototype.collapseChildren = function () {
	for (var i = 0; i < this._subItems.length; i++) {
		this._subItems[i].collapseAll();
	}
}
 function   change(obj)   
  {   
     var   objs=document.getElementsByName(obj.name);  
      
  
  for(var   i=0;   i<objs.length;   i++)   
  {   
      if(obj.checked   &&   obj.id.substr(0,objs[i].id.length)==objs[i].id)
       {
         objs[i].checked=true; 
        }
   }   
  for(var   i=0;   i<objs.length;   i++)   
  {   

     if(objs[i].id.substr(0,obj.id.length)==obj.id)
         objs[i].checked=obj.checked;   
  }  
  
  if(obj.checked)
  {
  	
  }else{
       var len=obj.id.length;   
       var stk=obj.id.substr(0,len-2);  
 
        for(var i=0;i<objs.length;i++)
        {  
           if(objs[i].id.length==len && objs[i].id.substr(0,len-2)==stk && objs[i].checked  && objs[i]!=obj)
           {
             return true; 
           }
        }
        for(var i=0;i<objs.length;i++)
        { 
           if(objs[i].id==stk )
           {
             objs[i].checked=false;
             change(objs[i]);
           }
        }
       
      
      
  }
    return true; 

  }   
function WebFXTreeItem(sText, sAction,selType,treeID,ifChecked,nodeId) {
	this._subItems  = [];
	this._wasLast   = false;
	this.text       = sText || defaultText;
	this.action     = sAction || defaultAction;
	this.id         = webFXTreeHandler.getId();
	this.open       = (getCookie(this.id.substr(18,this.id.length - 18)) == '1')?true:false;
	this.selType	= selType;
	this.treeID		= treeID;
	this.target		= targetStr;
	webFXTreeHandler.all[this.id] = this;
	this.ifChecked  = ifChecked;
	this.nodeId     = nodeId;
};

WebFXTreeItem.prototype.getTreeID = function () {
	return this.treeID;
};

WebFXTreeItem.prototype.add = function (treeItem) {
	treeItem.parent = this;
	this._subItems[this._subItems.length] = treeItem;
};

WebFXTreeItem.prototype.toggle = function () {
	if (this.open) { this.collapse(); }
	else { this.expand(); }
}

WebFXTreeItem.prototype.select = function () {
	document.getElementById(this.id + '-anchor').focus();
}

WebFXTreeItem.prototype.focus = function () {
	if (selectedObj) { selectedObj.blur(); }
	selectedObj = this;
	if ((this.openIcon) && (webFXTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.openIcon; }
	document.getElementById(this.id + '-anchor').style.color = '#E77B39';
}

WebFXTreeItem.prototype.blur = function () {
	if ((this.openIcon) && (webFXTreeHandler.behavior != 'classic')) { document.getElementById(this.id + '-icon').src = this.icon; }
	document.getElementById(this.id + '-anchor').style.color = 'menutext';
}

WebFXTreeItem.prototype.expand = function () {
	if (this._subItems.length > 0) { 
		document.getElementById(this.id + '-cont').style.display = 'block';
	}
	if (webFXTreeHandler.behavior == 'classic') {
		document.getElementById(this.id + '-icon').src = this.openIcon;
	}
	document.getElementById(this.id + '-plus').src = this.minusIcon;
	this.open = true;
	setCookie(this.id.substr(18,this.id.length - 18), '1');
}

WebFXTreeItem.prototype.collapse = function () {
	if (this._subItems.length > 0) {
		document.getElementById(this.id + '-cont').style.display = 'none';
	}
	if (webFXTreeHandler.behavior == 'classic') {
		document.getElementById(this.id + '-icon').src = this.icon;
	}
	document.getElementById(this.id + '-plus').src = this.plusIcon;
	this.open = false;
	setCookie(this.id.substr(18,this.id.length - 18), '0');
}

WebFXTreeItem.prototype.expandAll = function () {
	this.expandChildren();
	this.expand();
}

WebFXTreeItem.prototype.expandChildren = function () {
	for (var i = 0; i < this._subItems.length; i++) {
		this._subItems[i].expandAll();
	}
}

WebFXTreeItem.prototype.collapseAll = function () {
	this.collapse();
	this.collapseChildren();
}

WebFXTreeItem.prototype.collapseChildren = function () {
	for (var i = 0; i < this._subItems.length; i++) {
		this._subItems[i].collapseAll();
	}
}

WebFXTreeItem.prototype.toString = function (nItem,nItemCount) {
	var foo = this.parent;
	var st=new Array("checkbox","radio");
	var indent = '';
	if (nItem + 1 == nItemCount) { this.parent._wasLast = true; }
	while (foo.parent) {
		foo = foo.parent;
		indent = "<img src=\"" + ((foo._wasLast)?blankIcon:iIcon) + "\">" + indent;
	}
	if (this._subItems.length) { this.folder = 1;}
	
	if (this.folder) {
		if (!this.icon) { this.icon = folderIcon; }
		if (!this.openIcon) { this.openIcon = openFolderIcon; }
		var str = "<div id=\"" + this.id + "\" onclick=\"change(this);\" ondblclick=\"change(this);\" class=\"webfx-tree-item\">";
		str += "<table height=\"10\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"10\">";
		str += "<tr><td nowrap>"+indent;
		str += "<img id=\"" + this.id + "-plus\" src=\"" + ((this.open)?((this.parent._wasLast)?lMinusIcon:tMinusIcon):((this.parent._wasLast)?lPlusIcon:tPlusIcon)) + "\" onclick=\"webFXTreeHandler.toggle(this);\">"
		str += "<img id=\"" + this.id + "-icon\" src=\"" + ((webFXTreeHandler.behavior == 'classic' && this.open)?this.openIcon:this.icon) + "\" onclick=\"change(this);\"></td>";
		str += "<td nowrap valign=\"bottom\">&nbsp;";
        
        
		if (this.selType !=null && this.selType !="")
		//------------------------------外面选择框---------------------------------------------------------------------
			str +="<input class='outsideId' type="+st[parseInt(this.selType)]+" name=\"dept"+ this.nodeId +"\" id=\""+this.action+"\" value=\""+this.treeID+"\" onclick=\"change(this);\" "+ this.ifChecked +">";
		
	
		str +="<input type=\"hidden\" name=\"hid"+ this.nodeId +"\" value=\""+this.treeID+"\" >";
		
		str += "<onclick=\"treeitem_Click('" + this.id +  "','" + this.text + "','" + this.treeID + "','" + this.nodeId + "');\" onDblClick=\"change(this);\" id=\"" + this.id + "-anchor\" onfocus=\"webFXTreeHandler.focus(this);\" title=\""+this.text+"\">" + this.text;
		
		str +="</td></tr></table></div>";
		str += "<div id=\"" + this.id + "-cont\" class=\"webfx-tree-container\" style=\"display: " + ((this.open)?'block':'none') + ";\">";
		for (var i = 0; i < this._subItems.length; i++) {
			if (this._subItems[i].text !="@@@"){
				str += this._subItems[i].toString(i,this._subItems.length);
			}
		}
		str += "</div>";

	}
	else {
		if (!this.icon) {
			if (webFXTreeHandler.behavior == 'classic') {
				this.icon = fileIcon;
			}
			else {
				this.icon = folderIcon; 
				this.openIcon = openFolderIcon;
			}
		}
		var str = "<div id=\"" + this.id + "\" class=\"webfx-tree-item\">";
		str += "<table height=\"10\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"10\">";
		str += "<tr><td nowrap>"+indent;
		str += "<img id=\"" + this.id + "-plus\" src=\"" + ((this.parent._wasLast)?lIcon:tIcon) + "\">"
		str += "<img id=\"" + this.id + "-icon\" src=\"" + this.icon + "\" onclick=\"webFXTreeHandler.select(this);\"></td>";
		str += "<td nowrap valign=\"bottom\">&nbsp;";
				

		
		if (this.selType !=null && this.selType !="")
		//-------------------------------------------- 里层选择框---------------------------------------------------------
			str +="<input class='insideId' type="+st[parseInt(this.selType)]+" name=\"dept"+ this.nodeId +"\" id=\""+this.action+"\" value=\""+this.treeID+"\" onclick=\"change(this);\" "+ this.ifChecked +">";
		

		str +="<input type=\"hidden\" name=\"hid"+ this.nodeId +"\" value=\""+this.treeID+"\" >";
		
		str += "<onclick=\"treeitem_Click('" + this.id +  "','" + this.text + "','" + this.treeID + "','" + this.nodeId + "');\" onDblClick =\"treeitem_DblClick('"+this.action + "','"+this.text+"');\" id=\"" + this.id + "-anchor\" onfocus=\"webFXTreeHandler.focus(this);\" title=\""+this.text+"\">" + this.text;
	
		str +="</td></tr></table></div>";
	}
	this.plusIcon = ((this.parent._wasLast)?lPlusIcon:tPlusIcon);
	this.minusIcon = ((this.parent._wasLast)?lMinusIcon:tMinusIcon);
	return str;
}






function setCookie(key, value) {
	document.cookie = key + "=" + escape(value);
}

function getCookie(key)
 {

	if (document.cookie.length) 
	{
		var cookies = ' ' + document.cookie;
		var start = cookies.indexOf(' ' + key + '=');
		if (start == -1) { return null; }
		var end = cookies.indexOf(";", start);
		if (end == -1) { end = cookies.length; }
		end -= start;
		var cookie = cookies.substr(start,end);
		return unescape(cookie.substr(cookie.indexOf('=') + 1, cookie.length - cookie.indexOf('=') + 1));
	}
	else { return null; }
}

function checkAll()
{  

  	if(form.idcheckbox == null)
  		return;
  	var numRow = form.idcheckbox.length;
  	if(numRow == null) 
  	{
		form.idcheckbox.checked = form.myCheckAll.checked;	
  	}
  	if(form.myCheckAll.checked) 
  	{
		for (var i = 0; i < numRow; i++) 
		{
			form.idcheckbox[i].checked = true;
		}
	} else {
		for (var i = 0; i < numRow; i++) 
		{
			form.idcheckbox[i].checked = false;
		}
	}
  }
function backPage(){
   document.all.menuFrm.action="role!find";
   document.all.menuFrm.submit();
}
//  开始我的js，实现保存用户权限   显示用户原有权限
$(function(){
	var v = $(".checkedClass");
//	alert(v);
	var out = $(".outsideId:checked");
    var inV = $(".insideId,.outsideId");   //"
//    alert(inV.val());
//    $(".insideId").each(function(){
//    	alert($(this).val());
//    });
//    alert(inV);
    var t=new Array();  
    var i=0;
    v.each(function(){   //迭代出用户所拥有权限
    	t[i]=$(this).val();
    	i++;	
    	});
    	
    inV.each(function(){
    	var c = $(this).val();
    	
    	for(var j=0; j<t.length; j++){
    		if(c==t[j]){
    		
    			$(this).attr("checked",true);
    		}	
    	}
    });
    
	
});
//保存按钮  
function Multi_onClick(){  
   var out = $(".outsideId:checked");
   var inV = $(".insideId:checked"); //此处可以合并成一个.class 
   var checkedId = $("#checkedId").html();
  
   var outValue="";
   var inValue="";
   out.each(function(){
   	outValue = $(this).val() +':'+ outValue;
   });
  
   inV.each(function(){
   	inValue = $(this).val()  + ':' + inValue;
   	});
	
	
//	  if(str=='1')
//	  {
//         $(".menuFrmBtn").attr("action","role!saveRoleFunc?checkedId="+checkedId+"&checked="+inValue+outValue);
//		 $("#menuFrm").submit();
//	   }else{
//	     location="role!toOper?checkedId="+checkedId;
//	   }
	  document.all.form1.action="<%=path%>/role!saveRoleRight?checkedId="+checkedId+"&checked="+inValue+outValue;
	  document.form1.submit();

    }

</script>







</head>
<body >
<form name="form1" method="post">
  	<div class="bigBox"><!--外部大DIV，可以调整宽度-->
  		<h2><span><a href="javascript:void(0)">系统管理</a> &gt; <a href="javascript:void(0)">角色管理</a> &gt; 修改功能权限</span></h2> 
    </div>
    <div class="content"> 
  	<div class="right2_s">
  	<table height="32">
           <tr>
                <td width="20%" ><input name="submit22" type="button" class="button_02a" value="保存" onClick="Multi_onClick()">
                	</td>
					<td width="20%"><input name="Submit22" type="reset" class="button_02a" value="重置">
                	</td>
                	
                	<td width="20%"  ><input name="Submit22" type="button" class="button_02a" value="返回" onClick="javascript:history.back();"></td>
					</tr>
     </table>
  		
  	</div>
  <div class="right2_x" >
  	<div style="width:100%;height:490px;overflow:auto;">
  	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1"  bgcolor="#93B3CA">
	 
	<tr bgcolor="#FFFFFF"><td width="70" nowrap="nowrap">公司编号:</td><td width="100" nowrap>暂无</td>
	<td width="70" nowrap>角色编码:</td><td width="100" id="checkedId" nowrap><%= voi.getRole_sno() %></td>
	<TD width="70" nowrap>角色名称:</TD><td width="85" nowrap><%=voi.getRole_sname()%></td> 
	<td width="70" nowrap>角色类型:</td><td width="80" nowrap>
	<s:if test="%{role.role_stype==\"0\"}">超级管理员</s:if><s:if test="role.role_stype==\"1\"">系统管理员</s:if>
	<s:if test="role.role_stype==\"2\"">普通用户</s:if><s:if test="role.role_stype==\"3\"">一般用户</s:if>
	<input type="hidden" name="form.rolesno" id="rolesNo" value="<%=voi.getRole_sno()%>"/>   
	</td></tr>
    
	</table >
	
  	
  	
  	<div class="right2_x" >
	<s:iterator value="rightList" var="v">
			<input class="checkedClass"  value="${v.right_sno}" style="display:none"/>
		</s:iterator>

            <div id="ccParent1"> 
              <table class="div0" width="99%" border="0" cellspacing="0" cellpadding="0">
                <tr> 
                <td><img src="<%=path %>/images/icon/07-0.gif" width="16" height="16" align="middle" style="cursor:hand" onClick="javascript:hideshow('ccChild1',this,'');"/>授权</td>
                </tr>
				
              </table>
            </div>
           <div class="div1" id="ccChild1"> 
			<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" class="tabletext">
                      <tr bgcolor="#B8D5F5">
						<td>权限列表</td>
						
					  </tr>
                      <tr>
                        <td nowrap bgcolor="#FFFFFF" valign="top" align="left"><!--菜单树开始--> 
                  <!-- 		<script language="javascript" src="<%=path %>/js/checkbox_au_tree.js"></script> -->
                  			<script language="javascript"> 
                  			
							 if (document.getElementById)
							 {
							
						     	var t0=new WebFXTree('<b>角色信息管理</b>','0');
								var node0 = new WebFXTreeItem("角色权限分配","0","","","",0);
						        t0.add(node0);																									
								<%
								String flag="";
							        String parno="";
					                if(li!=null)
					                {
					                  System.out.println("li.size()=="+li.size());
				                       for(int i=0;i<li.size();i++)
				                       {
					                  
					                     MngRight sr=(MngRight)li.get(i);
					                    
					                     if(sr.getRight_sdef1()  ==null||sr.getRight_sdef1().equals(""))
					                     {
					                          flag="";
					                      }else
					                      {
					                           flag="checked";
					                       }
					                     if(sr.getRight_sparentno()==null)
					                     {
					                       parno="0";
					                     }else if(sr.getRight_sparentno().equals(""))
					                     {
					                      parno="0";
					                     }else{
					                       parno=sr.getRight_sparentno();
					                     } 
					              System.out.println("sr.getRight_sno()="+sr.getRight_sno()   +"sr.getRight_sname()="+sr.getRight_sname());     
								      %>		
							              var node<%=sr.getRight_sno()%>= new WebFXTreeItem("<%=sr.getRight_sname()%>","<%=sr.getRight_sno()%>","0","<%=sr.getRight_sno()%>","<%=flag%>","1");			
					                     node<%=parno %>.add(node<%=sr.getRight_sno() %>);
					                      
				                       <%}
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
            </div>
    </div>
  </div></div>
 </div>
  </form>

</body>
</html>

