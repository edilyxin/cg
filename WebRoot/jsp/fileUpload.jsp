<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base target="_self">
    
    <title><s:property value="pagename"/> </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="<%=path%>/js/CJL.0.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/ImagePreviewd.js"></script>
<script type="text/javascript" src="<%=path%>/js/JS_Pinyin.js"></script>
<script type="text/javascript" src="<%=path%>/js/city.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/js/kindeditor/kindeditor.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/js/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.progressbar.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	 //判断SESSION是否失效
	 	if("${session.userInfo}"==""){
	 		alert("连接超时，请重新登陆");
	 		window.close(); 
	 	}
});
	function uploadFile(){
		if ("" == $("#file").val()) {
			$('#show').append("<span style='color: red;'>请选择需导入的Excel文件！</span>");
			return;
		}
		$('#show').empty();
  		$('#show').append("文件导入中...");
  		$("#button").hide();
  		$(".frm").ajaxSubmit({
			type:"post",
			async:false,
			url:"<%=path%>/<%=request.getParameter("pathname") %>",
			//dataType:"json",
			success:function(data){
				$('#show').empty();
	      		$('#show').append(data);
	      		flag = true;
	      		$("#button").show();
			},
			error:function(){
				flag =  false;
				$('#show').append("文件导入异常！");
	      		$("#button").show();
			}
		});
<%--		$.ajax({--%>
<%--			async:false,//同步--%>
<%--			type:"post",//post方式提交--%>
<%--			url:"<%=path%>/<%=request.getParameter("pathname") %>",//提交地址--%>
<%--			dataType:"html",--%>
<%--			success:function(data){--%>
<%--				$('#show').empty();--%>
<%--	      		$('#show').append(data);--%>
<%--	      		flag = true;--%>
<%--	      		$("#button").show();--%>
<%--			},--%>
<%--			error:function(){--%>
<%--				flag =  false;--%>
<%--				$('#show').append("文件导入异常！");--%>
<%--	      		$("#button").show();--%>
<%--			}--%>
<%--		});--%>
		window.returnValue = true;
<%--		parent.window.close();--%>
	}
</script>
<script type="text/javascript">
       var intervalID = 0;
       var progressBar;
       var fileUpload;
       var form;       
       // 进度条      
       function pageLoad(){           
           $addHandler($get('upload'), 'click', onUploadClick);
           progressBar = $find('progress');
       }
       // 注册表单       
       function register(form, fileUpload){            
           this.form = form;
           this.fileUpload = fileUpload;
       }        
       //上传验证
       function onUploadClick() {        
           var vaild = fileUpload.value.length > 0;
           if(vaild){              
               $get('upload').disabled = 'disabled';             
               updateMessage('info', '初始化上传...');                
               //提交上传
               form.submit();                
               // 隐藏frame
               Sys.UI.DomElement.addCssClass($get('uploadFrame'), 'hidden');
               // 0开始显示进度条
               progressBar.set_percentage(0);
               progressBar.show();           
               // 上传过程
               intervalID = window.setInterval(function(){
                   PageMethods.GetUploadStatus(function(result){
                       if(result){
                           //  更新进度条为新值
                           progressBar.set_percentage(result.percentComplete);
                           //更新信息
                           updateMessage('info', result.message);
                           
                           if(result == 100){
                               // 自动消失
                               window.clearInterval(intervalID);                        
                           }
                       }
                   });
               }, 500);                
           }
           else{
               onComplete('error', '您必需选择一个文件');
           }
       }       
   
       function onComplete(type, msg){
           // 自动消失
           window.clearInterval(intervalID);
           // 显示消息
           updateMessage(type, msg);
           // 隐藏进度条
           progressBar.hide();
           progressBar.set_percentage(0);
           // 重新启用按钮
           $get('upload').disabled = '';
           //  显示frame
           Sys.UI.DomElement.removeCssClass($get('uploadFrame'), 'hidden');
       }        
       function updateMessage(type, value){
           var status = $get('status');
           status.innerHTML = value;
           // 移除样式
           status.className = '';
           Sys.UI.DomElement.addCssClass(status, type);
       }
   
   </script>
<script type="text/javascript">
$("#file").live("change",function(){   
	var filepath = $(this).val();
	if ("" == filepath) {
		$("#file\\.info").html("请选择模板Excel文件");
		return;
	}
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substr(extStart).toUpperCase();
	if (ext != ".XLS"&&ext != ".XLSX") {
		alert("请选择xls,xlsx类型的文件");
		var file = $("#file"); 
		file.after(file.clone(true).val("")); 
		file.remove();
	} else {
		$("#file\\.info").html("*");
	}
});

</script>
  </head>
  
  <body style="overflow:auto;">
  			<form class="frm" id="frm" name="frm" method="post" action="<%=path %>/<s:property value="pathname"/>" enctype="multipart/form-data" >
            <p>请选择需导入的Excel文件 :<input class="file" type="file" id="file" name="myfile" value="" /></p>
            <p><input type="button" id="button" onclick="uploadFile()" value="导入"/></p>
            <span id="show" style="color:blue;"></span>
            </form>
 
  </body>
</html>
