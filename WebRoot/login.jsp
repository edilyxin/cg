<%@ page language="java" import="com.rc.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<%
	//清缓存  
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	session = request.getSession(false);
	if (session!=null) {//session有效 
		session.setAttribute("mainList",null);//菜单栏信息
		session.setAttribute("userInfo",null);//用户信息
		session.setAttribute("operList",null);//操作权限
		session.setAttribute("login","1");//登录
	}
%>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" >
 nowpath = "<%=path %>/";
</script>
<script src="<%=path %>/js/valid.js" type=text/javascript></script>
<script type="text/javascript" src="<%=path%>/js/jquery.bgiframe.min.js"></script>
<link  href="<%=path%>/css/validate.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/x-icon" href="<%=path %>/images/favicon.ico" />
<title>采购管理系统</title> 
<style type="text/css">
<!--		
	 body
        {
        	text-align:center;
           	font-size: 12px;
            font-family: Arial;
            margin: 0 ;
            padding: 0;
            
        }
	 
        a, h1, h2, h3, h4, h5, h6, ul, li, ol, dl, dt, dd, p, img, span, input, form
        {
            margin: 0;
            padding: 0;
        }
        .zhengti
        {
			width: 1024px;            
            height: 724px;
            background: url(image/gs_bj1.jpg) no-repeat;
            padding: 232px 0 0 151px;
            margin:0 auto;
        }
        .zt_lm
        {
			width: 280px;
			height: 153px;
			padding-top: 138px;
			padding-right: 0;
			padding-bottom: 0;
			padding-left: 265px;
			float: left;
        }
        .wb_k
        {
            width: 200px;
            height: 63px;
        }
        .wb_k input
        {
            width: 150px;
            height: 20px; 
            background: #fff;
            margin-top: 2px;
            line-height: 18px;
        }
        .wb_k input.www
        {
            width: 150px;
            height: 20px;
            margin-top: 30px;
            _margin-top: 25px; #margin-top:25px;background:#fff;line-height:18px;}
        .an_k
        {
            width: 103px;
            height: 24px;
            margin: 20px 0 0 25px;
        }
        .an_k a
        {
            border: none;
        }
        .an_k img
        {   
            border: none;
        }
	.an_k1
        {
            width: 103px;
            height: 24px;
            margin: 24px 0 0 -98px;
        }
	-->
</style>

<script language="javascript">
<%--$(document).ready(function(){--%>
<%--	document.getElementById("username").focus();--%>
<%--	if("${message}"!=""){--%>
<%--		document.getElementById("${error}").innerHTML = "${message}" ;--%>
<%--	} --%>
<%--});--%>
function openDesk(){  

    if(validator()){ 
    	document.form1.action="<%=path%>/login";
    	document.form1.submit();
	}    
}    
    
//回车登录
document.onkeydown=function(e){
	var keyCode;
	if(window.event){
		keyCode=event.keyCode;
	}else{
		keyCode=e.which;
	}

	if(keyCode==13){
		openDesk();
	}
}; 

 /**
 * 回车换行
 */
 function enterTo(){
	var keyCode;
	if(window.event){
		keyCode=event.keyCode;
	}else{
		keyCode=e.which;
	}
	if(keyCode==13){
	
		event.keyCode=9 ;
	}
}
 
</script>
</head>
<body  onload="form1.us_sLoginName.focus();">
<form id="form1" name="form1" method="post">
    <div class="zhengti">
      <div class="zt_lm">
            <div class="wb_k"> 
			<input id="us_sLoginName"  name="loginForm.username"  width="142" value="" valid="required" errmsg="请输入用户名!"/>
              <input ID="us_sLoginPwd" class="www" name="loginForm.password"  Width="142"  type="Password" valid="required" errmsg="请输入密码!"/> 
        
        </div>
         <font class="an_k">
           <img src="image/an_tp1.gif" onClick="openDesk();" style="cursor:pointer;"  />
                
            </font>
            <div style="color:red;float:left"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %> </div>
     </div>
     </div>
</form>
</body>
</html>