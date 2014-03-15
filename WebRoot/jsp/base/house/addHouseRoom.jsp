<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
 
 
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="/BeiGS/css/style.css" />
	<!-- 样式 -->
	<style type="text/css">
		.tableClass td{width:70px;cursor:pointer}
		.btn {
		background-color:#C8D9F3
		}
		
	</style>
	<script type="text/javascript" src="/BeiGS/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="/BeiGS/js/newPopup.js"></script>
	<script type="text/javascript" src="js/jquery.easydrag.js"></script>
	<!-- 
	<script type="text/javascript" src="/BeiGS/common/dialog/artDialog.source.js?skin=blue"></script>
	<script type="text/javascript" src="/BeiGS/common/dialog/plugins/iframeTools.source.js"></script>
	 -->
	<script type="text/javascript">
	
	
	
	
	
		//新增房间
		function newHouse(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:510});
            pop.setContent("contentUrl","houseH!addRoomOpen?checkedId="+$("#hs_sno").val());
            pop.setContent("title","新增房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}		
		//修改房间
		function updateHouse(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:510});
            pop.setContent("contentUrl","houseH!updateRoomOpen?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","修改房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}		
		//修改房间性质
		function updateHouseType(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:510});
            pop.setContent("contentUrl","houseH!updateRoomType?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","修改房间性质");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//拆除房间
		function removeRoom(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:510});
            pop.setContent("contentUrl","houseH!removeRoom?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","拆除房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//核查房间
		function checkRoom(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:510});
            pop.setContent("contentUrl","houseH!checkRoom?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","核查房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//使用记录
		function useRecord(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:760,height:600});
            pop.setContent("contentUrl","houseH!useRecord?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","使用记录");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//拆除记录
		function removeRecord(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:760,height:600});
            pop.setContent("contentUrl","houseH!removeRecord?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","拆除记录");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//核查记录
		function checkRecord(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:760,height:600});
            pop.setContent("contentUrl","houseH!checkRecord?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","核查记录");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		// 拆分房间		
		function splitRoom(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:700,height:700});
            pop.setContent("contentUrl","houseH!splitRoom?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","拆分房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//合并房间		
		function mergeRoom(){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:800,height:600});
            pop.setContent("contentUrl","houseH!mergeRoom?checkedId="+$("#hs_sno").val()+"&checkeds="+$("#checkedRoom").val());
            pop.setContent("title","合并房间");
            pop.build();
            pop.show();
//			$("#divid").load("houseH!addRoomOpen");
//            art.dialog({
//			    title: '新增房间',
//			    width: 500,
//			    height: 500,
//			    content: $("#divid").get(0)
//			});
		}
		
		//选单元操作功能 
	     function unit(str){
			
		    $(".Off1").attr("href", "houseH!findHouse?hu_scode="+str+"&checkedId="+"35");
		}
			
		
		//房间详细
		function detailed(id){		
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:600,height:580});
            pop.setContent("contentUrl","houseH!detailed?checkedId="+id);
            pop.setContent("title","房间详细");
            pop.build();
            pop.show();
//            $("#divid").load("houseH!detailed?checkedId="+id);
//            art.dialog({
//			    title: '房间详细',
//			    content: 'hello world!',
//			    width: 580,
//			    height: 560,
//			    content: $("#divid").get(0)
//			});
            
		}
		//新增房间保存
		function addHouse(){
			alert("fd");
		}
		//0调位空房  1调定编 2预分配
		function setEmptyRoom(str){
		
//			alert("35");
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:800,height:580});
            pop.setContent("contentUrl","houseH!openSetEmptyRoom?checkeds="+$("#checkedRoom").val()+"&attribute="+str+"&checkedId="+"35");
            pop.setContent("title","房间设置");
            pop.build();
            pop.show();
		}
		
		//算面积
		function totalA(){
			var a1=0;
			var a2=0;
			var i = 0;
			$(".detailed").each(function(){
				if($(this).attr("axis") ==1){
					var v = ($(this).attr("headers")).split("-");
					a1 = a1+ parseInt(v[0]);
					a2 = a2+parseInt(v[1]);
					i++;
				} 
			});
			//alert(a1+"---"+a2);
			$("#shiyong").html(a1);
			$("#jianzhu").html(a2);
			$("#taoshu").html(i);  //算出面积结束
			//显示
			var t = document.getElementById("btnA").offsetTop; //jquery定位在此处 不精确
			var l = document.getElementById("btnA").offsetLeft;
			$("#manageBook").css("left",l);
			$("#manageBook").css("top",t+20);
			$("#manageBook").show();
		}
		$(function(){
			$("#btn2").click(function(){
				$("#manageBook").hide();
			});
			//图书管理 拖拽效果position:fixed;absolute
			$(".manageSpan").mouseover(function(){
				$(".divClass").css("overflow-y","hidden");
				$(".manageBook").easydrag();
				$(".bookModify").easydrag();
			}).mouseout(function(){
				$('.manageBook').unbind();
				$('.manageBook').css("cursor","default");
				$('.bookModify').unbind();
				$('.bookModify').css("cursor","default")
			});
		});
		
 
		$(function(){
			$(".roomCode").click(function(){
			
			//	alert($("#checkedRoom").val().length);
			
			});				
		});
		
		/*
		导出excel
		*/
		function getExcel(){
			document.all.form1.action="houseH!getExcel?checkedId="+"35";
			document.all.form1.submit();
		}
		
		//点击房间，对应详细的房间被选中 着色       axis=1  为选中，0 为没选中
 
		//点击房间，对应详细的房间被选中 着色       axis=1  为选中，0 为没选中--------------------------
 
		$(function(){
			initialize();
			$(".roomCode").click(function(){
				detailedCleared();  //清空下部分颜色
				var rmId = $(this).attr("name");
				var c = $(this).css("background");
				if(c==null){c="11111111";}//此处为兼容谷歌浏览器 读取出来的颜色是 rgb(2,2,255)形式，而ie为#3399ff
				if($(this).css("background")!='#3399ff'&&c.substring(c.length-4,c.length-1)!='255'){//第一次点击	
					$(this).css("background","#3399FF");//上
					$("#"+rmId).css("background","#3399FF");//下
					//$("#"+rmId).siblings().css("background","#3399FF");
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
				}else{//第二次点击
					var v = $(this).attr("headers");
					if(v == 1){//空房
						$(this).css("background","#90EE90");
					}else if(v == 0){//在用
						$(this).css("background","#ADD8E6");
					}else if(v == 2){//临时
						$(this).css("background","#FFFF00");
					}else{//预分配
						$(this).css("background","#FFA07A");
					}
					//$("#"+rmId).css("background","");//下
					$(this).attr("axis","0");
					$("#"+rmId).attr("axis","0");
				}
				//显示被选中的checkedRoom
				checkedRoom();
				checkedDetailed();	//显示下部分颜色
				if($(this).css("background")=='#3399ff'||$(this).css("background").substring(c.length-5,c.length-2)=='255'){//第一次点击	
					$("#"+rmId).css("background","#3399FF");//下
				}
				var v = document.getElementById(""+rmId+"").offsetTop; //jquery定位在此处 不精确
				document.getElementById("detailed").scrollTop = eval(v-140);// 滚动条定位
				clickBtn();//按钮
			});	
			
		});
		//选择 在用
		function useRoom(str){
			initialize();
			checkedCleared();
			$(".detailed").each(function(){
				$(this).attr("axis","0");
			});
			$(".roomCode").each(function(){
				var v = $(this).attr("headers");
				var rmId = $(this).attr("name");
				if(v == str){//空房
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
					$(this).css("background","#3399FF");
				}else if(v == str){//在用
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
					$(this).css("background","#3399FF");
				}else if(v == str){//临时
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
					$(this).css("background","#3399FF");
				}else if(v == str){//预分配
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
					$(this).css("background","#3399FF");
				}else if(4 == str){//全选
					$(this).attr("axis","1");
					$("#"+rmId).attr("axis","1");
					$(".roomCode").css("background","#3399FF");
					//throw new Error("error");
				}
			});		 
			checkedRoom();
			checkedDetailed();//显示啊
		}
		//初始化 颜色
		function initialize(){
			$(".roomCode").each(function(){
				var v = $(this).attr("headers");
				if(v == 1){//空房
					$(this).css("background","#90EE90");
				}else if(v == 0){//在用
					$(this).css("background","#ADD8E6");
				}else if(v == 2){//临时
					$(this).css("background","#FFFF00");
				}else{//预分配
					$(this).css("background","#FFA07A");
				}
			});		
		}
		//初始化  被选中 
		function checkedCleared(){ 
			$(".roomCode").each(function(){
				$(this).attr("axis","0");
			});
		}
		//显示被选中的
		function checkedRoom(){
			var checkedRoom = ""; 
				$(".roomCode").each(function(){		
					if($(this).attr("axis") == 1){
						checkedRoom = $(this).attr("name")+" "+checkedRoom;		
					}
					$("#checkedRoom").val(checkedRoom);
				
		 	});		
		}
				
		
		
		//清空 下部 详细信息的颜色
		function detailedCleared(){
			$(".detailed").each(function(){
				$(this).css("background","");
			});
		}
		//显示被选中的 详细信息的颜色
		function checkedDetailed(){
				$(".detailed").each(function(){	
					if($(this).attr("axis") == 1){
						$(this).css("background","#CDE2F3");
						$(this).parent().css("background","#CDE2F3");
						//alert(1);	
					}else{
						$(this).parent().css("background","");	
						$(this).css("background","");
					}
				});
		}
		//点击下面----------------------------------
		
		$(function(){			
			$(".upClass,.detailed").click(function(){
				var v = $(this).attr("name");
				var c = $("#"+v).css("background");
				if(c==null){c="11111111";}
				var c2 = c.substring(c.length-4,c.length-1);
				if(c!='#3399ff'&&c2!='243'&&c!='#cde2f3'&&c2!='255'){//第一次点击	
					//alert(c.substring(c.length-4,c.length-1));
					$("#"+v).attr("axis","1");//下
					$("#r"+v).attr("axis","1");//上
					$("#r"+v).css("background","#3399FF");
					checkedRoom();
					checkedDetailed();//显示啊
					$("#"+v).css("background","#3399FF");
				}else{
					$("#"+v).attr("axis","0");//下
					$("#r"+v).attr("axis","0");//上	
					checkedRoom();
					checkedDetailed();//显示啊
					var v1 = $("#r"+v).attr("headers");
					if(v1 == 1){//空房
						$("#r"+v).css("background","#90EE90");
					}else if(v1 == 0){//在用
						$("#r"+v).css("background","#ADD8E6");
					}else if(v1 == 2){//临时
						$("#r"+v).css("background","#FFFF00");
					}else{//预分配
						$("#r"+v).css("background","#FFA07A");
					}
				}
				clickBtn();
			});
		});
		
		//按钮
		$(function(){
			//clickBtn()
			resetBtn();
		})
		
		//初始化按钮
		function resetBtn(){
			$(".btn").attr("disabled",true);
			$("#btn5").attr("disabled",false);
			$("#btn18").attr("disabled",false);
		}
		function clickBtn(){
			$(".btn").attr("disabled",false);
			$("#btn11").attr("disabled",true);
			
			var v = $("#checkedRoom").val().split(" ");
			//alert(v.length)
			if(v.length>2){//如果选择的房间大于2间   合并房间显示
				$("#btn11").attr("disabled",false);
				$("#btn12").attr("disabled",true);
				
				$("#btn7").attr("disabled",true);
			}else if(v.length==2){
				
			}else{
				resetBtn();
			}
		}
	</script>
</head>
<body style="height:98%">
<!--<form id="form2" action="houseH!addRoom"></form>
<div id="divid"  style="display:none;"></div>
 
--><form name="form1" method="post">
	<div class="right">
			<p class="p">
				您现在的位置：主页>>公用房管理->按房屋管理->楼盘管理
			</p>
	</div>
	
	
 <div>
 <!-- 头部显示区 -->
		<table width="100%"   style="border-collapse:collapse;font-size:12px;background-color:#3E97B9">
		  <tr style="line-height:26px;">
		    <td>&nbsp;房屋坐落：<span id="SchoolyardName">鲁东校区 </span>&nbsp;<span id="HouseName"> 5号大楼</span></td>
		    <td> 单元：
			  <!--  <a href="#" onclick="unit(A)">A</a>
			    --><!--
			    <a onclick="unit(A)" style="cursor:pointer">A</a>
			    
			    <a href="javascript:void(0)" onclick="unit(B)">A</a>
			       <a onclick="unit('A')" style="cursor:pointer">A</a>-->
			       <a class="Off1" href="#"    onclick="unit('A')">A&nbsp;</a>
			       <a class="Off1" href="#"    onclick="unit('B')">B</a>
		    </td>
		    <td>
		    	批量选择：
		    	<a onclick="useRoom(0)" style="cursor:pointer">在用</a>
		    	<a onclick="useRoom(1)"style="cursor:pointer">空房</a> 
		    	<a onclick="useRoom(2)"style="cursor:pointer">临时用房</a> 
		    	<a onclick="useRoom(3)"style="cursor:pointer">预分配</a> 
		    	<a onclick="useRoom(4)"style="cursor:pointer">全选</a>
		    	<a onclick="useRoom(5)"style="cursor:pointer">清空</a>
		    </td>
		  </tr>
		  <tr style="line-height:26px;">
		    <td>&nbsp;状态示意：
		    	<span style="background-color:#ADD8E6;width:28px;line-height:16px;text-align:center;">在用</span> 
		    	<span style="background-color:#90EE90;width:28px;line-height:16px;text-align:center;">空房</span> 
		    	<span style="background-color:#FFFF00;width:28px;line-height:16px;text-align:center;">临时</span> 
		    	<span style="background-color:#FFA07A;width:44px;line-height:16px;text-align:center;">预分配</span>
		    </td>
		    <td>统计：在用12间 
		    	<a href="#">区统计</a>
		    	<a href="#">幢统计</a>
		    	<a href="#">幢明细</a>
		    </td>
		    <td>选中房间：<input type="text" name="textfield" value="" id="checkedRoom" style="width:440px;background-color:#D8D8D8"/></td>
		  </tr>
		</table>
	
	<!-- 楼盘表   中间显示区 -->	
	<div style="border:1px solid black;margin-bottom:5px;height:55%;width:80%;overflow:auto">
	  <!--<table class="tableClass" width="" border="" cellpadding="1" cellspacing="1"style="border-collapse:collapse;font-size:12px;">             
       -->
       <table class="tableClass"  cellpadding="1" cellspacing="1"style="border-collapse:collapse;font-size:12px;">                
          <tr style="background-color:#4682B4;line-height:30px;color:white;font-weight:bold;">
            <td align="center" width="70px">楼层</td>
            <td colspan="9" align="center">楼盘表</td>
          </tr>
    
          <!-- 外层 -->
          
	      		<tr style="line-height:26px;">
		            <td style="background-color:#4682B4;" align="center">2层</td>
		            <!-- 里层 -->
		            
		            	<!-- 绑定属性  axis 0表示没选中，1表示 选中，name存储id  -->
						<td align="center" class="roomCode" id="r219" name="219" axis="0" headers="0">
							219&nbsp;
						</td>
					
	            </tr>
		 
        </table>
	</div>
	
	<!-- 中间按钮区  -->
	<div>
		<input type="hidden" name="nameForm.hs_sno" value="35" id="hs_sno">
		<input id="btn1" class="btn" type="button" value="算面积"  onclick="totalA()"/>
		<input id="btn2" class="btn" type="button" value="调整定编" onclick="setEmptyRoom(1)"/>
		<input id="btn3" class="btn" type="button" value="调为空房" onclick="setEmptyRoom(0)"/>
		<input id="btn4" class="btn" type="button" value="预分配" onclick="setEmptyRoom(2)"/>
		<input id="btn5" class="btn" type="button" value="新增房间"  onclick="newHouse()"/>
		<input id="btn6" class="btn" type="hidden" value="新增门洞"/>
		<input id="btn7" class="btn" type="button" value="修改房间" onclick="updateHouse()"/>
		<input id="btn8" class="btn" type="button" value="修改性质" onclick="updateHouseType()"/>
		<input id="btn9" class="btn" type="button" value="拆除房间" onclick="removeRoom()"/>
		<input id="btn10" class="btn" type="button" value="核查房间" onclick="checkRoom()"/>
		<input id="btn11" class="btn" type="button" value="合并房间" onclick="mergeRoom()"/>
		<input id="btn12" class="btn" type="button" value="拆分房间" onclick="splitRoom()"/>
		<input id="btn13" class="btn" type="button" value="使用记录" onclick="useRecord()"/>
		<input id="btn14" class="btn" type="button" value="拆除记录" onclick="removeRecord()"/>
		<input id="btn15" class="btn" type="button" value="审核记录" onclick="checkRecord()"/>
		<input id="btn16" class="btn" type="button" value="导出Excel" onclick="getExcel();"/>	
		<input id="btn17" class="btn" type="hidden" value="GIS地图"/>		
		<input id="btn18" class="btn" type="button" value="刷新" onclick="window.location.reload()"/>
	</div>
	
	<!-- 下侧显示信息 -->
	<div  style="overflow:auto;border:0px solid black; ">
	<table width="100%" border="1" cellspacing="0" style="border-collapse:collapse;font-size:12px;">
          <tr style="line-height:22px;font-weight:bold;background-color:#4682B4;color:white;">
            <td width="4%" align="center">序号</td>
            <td width="14%" align="center">房屋名称 </td>
            <td width="5%" align="center">区号</td>
            <td width="7%" align="center">房号 </td>
            <td width="6%" align="center">门洞 </td>
            <td width="10%" align="center">使用面积 </td>
            <td width="8%" align="center">建筑面积 </td>
            <td width="9%" align="center">使用性质 </td>
            <td width="30%" align="center">利用信息 </td>
            <td width="5%" align="center">详细</td>
          </tr>
      </table>
    </div>
 
	<div  id="detailed" style="height:200px;overflow-y:scroll; border:0px solid black; ">
	  <table width="100%" border="1" cellspacing="0" style="border-collapse:collapse;font-size:12px;">      
          
	          <tr style="line-height:22px; cursor:pointer" >
	          	
	            <td name="219" class="upClass" width="4%" align="center">1</td>
	            <td name="219" class="upClass" width="14%" align="center">219&nbsp;</td>
	            <td name="219" class="upClass" width="5%" align="center">A&nbsp;</td>
	            <!-- 绑定属性  axis 0表示没选中，1表示 选中 -->
	            <td name="219"headers="0.0-33.0" width="7%" align="center" id="219" class="detailed" axis="0">219&nbsp;</td>
	            <td name="219" class="upClass" width="6%" align="center">16&nbsp;</td>
	            <td name="219" class="upClass" width="10%" align="center">0.0&nbsp;</td>
	            <td name="219" class="upClass" width="8%" align="center">33.0&nbsp;</td>
	            <td name="219" class="upClass" width="9%" align="center">&nbsp;</td>
	            <td name="219" class="upClass" width="30%" align="center">&nbsp;</td>
	            
	            <td width="4%" class="no"align="center"><a href="#" onclick="detailed('23')">详细</a></td>
	          </tr>
	       
      </table>
	</div>
	</div>
	
	
  </form>
  
 <!-- 计算面积 -->
	<div  class="manageBook"  id="manageBook"style="border-style:solid; position:absolute; width:200px; height:150px;  
 			background:#FBFBFB;  border-color:#006633;border-width:1px; display:none;" >
		<div class="manageSpan" id="manageSpan" style="width:200px; height:25px; background:#429FFD; line-height:2">
			<div style="float:left">选中集中统计</div>
			<input type="button" value="×"  style=" width:23px; height:23px; float:right" id="btn2"/> 				
		</div>
		<br />
		<div class="bookList" id="bookList" style="padding-left:30px;">
			<table border="1" cellspacing="0" style=" text-align:center;">
				<tr style="background:#808080;">
					<td>合计项目</td>
					<td>合计数值</td>
				<tr>
				<tr style="background:#DEEFF7;">
					<td>总套数</td>
					<td id="taoshu">&nbsp;</td>
				<tr>
				<tr style="background:#DEEFF7;">
					<td >建筑面积</td>
					<td id="jianzhu">&nbsp;</td>
				<tr>
				<tr style="background:#DEEFF7;">
					<td >使用面积</td>
					<td id="shiyong">&nbsp;</td>
				<tr>			
			</table>
		</div>
		<br/><br/>
	</div>
	
  </body>
  </html>

