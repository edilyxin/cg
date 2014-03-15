<%@ page language="java" import="java.util.*,java.text.* " isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>

<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%
String path = request.getContextPath();
 %>
<HEAD>
<meta name="robots" content="none">
<title>高校“图文一体化”房产管理信息系统</title>
<link href="<%=path %>/css/left.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/right1.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/right2.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/text.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/top.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/line.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/js/tree/selectjs.js" type=text/javascript></script>
<script src="<%=path %>/js/valid.js" type=text/javascript></script>
<script src="<%=path %>/js/DatePicker/WdatePicker.js" type="text/javascript" ></script>
<style> 
.tableBorder7 { width:800; solid; 
background-color: #1F71A3; } 
TD { font-family: 宋体; font-size: 12px; line-height : 15px; } 
th { background-color: #f7f7f7; color: #000000; font-size: 12px; font-weight:bold; } 
th.th1 { background-color: #1F71A3; } 
td.TableBody7 { background-color: #FFFFFF; } 
</style>
<script type="text/javascript" src="<%=path%>/js/limit.js"></script>
<script language="javascript" src="<%=path%>/js/correctPNG.js"></script>
<script language="JavaScript" runat="server">
 today=new Date();
 function initArray(){
   this.length=initArray.arguments.length
   for(var i=0;i<this.length;i++)
   this[i+1]=initArray.arguments[i]  
 }
   var d=new initArray(
     "星期日",
     "星期一",
     "星期二",
     "星期三",
     "星期四",
     "星期五",
     "星期六");

function tick() {
var hours, minutes, seconds, xfile;
var intHours, intMinutes, intSeconds;
var today;
today = new Date();
intHours = today.getHours();
intMinutes = today.getMinutes();
intSeconds = today.getSeconds();
if (intHours == 0) {
hours = "12:";
xfile = "午夜";
} else if (intHours < 12) {
hours = intHours+":";
xfile = "上午";
} else if (intHours == 12) {
hours = "12:";
xfile = "正午";
} else {
intHours = intHours - 12
hours = intHours + ":";
xfile = "下午";
}
if (intMinutes < 10) {
minutes = "0"+intMinutes+":";
} else {
minutes = intMinutes+":";
}
if (intSeconds < 10) {
seconds = "0"+intSeconds+" ";
} else {
seconds = intSeconds+" ";
}
timeString = xfile+hours+minutes+seconds;
Clock.innerHTML = timeString;
window.setTimeout("tick();", 100);
}
window.onload = tick;

</script>

<script type="text/javascript">
var  highlightcolor='#d5f4fe';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
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
  //放大镜
function tree(text1,text2,path,Height,Width)
{
	if(Height==undefined)
	{
		Height = '600px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
	path="";
	}
	var returnValue = window.showModalDialog(path,'','dialogHeight='+Height+';dialogWidth='+Width+';');
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null)
	{
		document.all[text1].value = returnValue.split("|")[0];
		document.all[text2].value = returnValue.split("|")[1];
	}else
	{
		document.all[text1].value = "";
		document.all[text2].value = "";
	}
}
function closeTm(){
location = "<%=path%>/user.do?method=closePr";
var tmwindow =window.open("<%=path%>/chat/index.jsp","openChat", "status=no,resizable=no,scrollbars=no,toolbar=no,WIDTH=220,HEIGHT=600,left=800,top=100'");
tmwindow.close();
}
</script>
</HEAD>
<body onLoad="" onunLoad="">
<div class="text">
  <div class="top">
        	<div class="top_1">
            	<div class="top_a"><img src="<%=path%>/image/top_ren.jpg" class="top_ren"/> 当前用户：<span class="top_ad"> </span> 单位：<span class="top_ad"> </span> 
            	<a href="<%=path %>/login.jsp" onFocus="this.blur();" target="_parent" onClick="javascript:if(!confirm('您真的要退出吗？')){return false;}">
            	<span class="top_tc">[退出]</span></a>
            	</div>
              <div class="top_b" >
				<script language=JavaScript>
					document.write(
     					"<font > ",
     						today.getYear(),"年",
     						today.getMonth()+1,"月",
     						today.getDate(),"日 ",
     						d[today.getDay()+1],
     						"</font>" );
				</script>
       				<font id="Clock" ></font> 
				</div>
            </div>
  </div>
<div class="line">
        	<ul>
              <li><a href="<%=path %>/index.jsp"><img border="0" src="<%=path%>/image/xxpt.jpg" /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=01&top=系统管理" ><img border="0" src="<%=path%>/image/xtgl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=02&top=基础管理"><img border="0" src="<%=path%>/image/jcgl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=03&top=楼栋管理" ><img border="0" src="<%=path%>/image/tdgl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=04&top=土地管理" ><img border="0" src="<%=path%>/image/gyfgl.jpg" /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=05&top=公用房管理" ><img border="0" src="<%=path%>/image/zzfgl.jpg" /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=06&top=出租房管理" ><img border="0" src="<%=path%>/image/xsgl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=07&top=房补管理" ><img border="0" src="<%=path%>/image/gngl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=08&top=供暖管理" ><img border="0" src="<%=path%>/image/fbgl.jpg"  /></a></li>
              <li><a href="<%=path %>/user.do?method=findUserMenu&menu=09&top=系统管理" ><img border="0" src="<%=path%>/image/cxtjgl.jpg"/></a></li>
            </ul>
        </div>
        