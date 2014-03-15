<%@ page language="java" import="java.util.*,java.text.*,com.rc.declare.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date now =new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
String cdate = sdf.format(now.getTime()); //当前日期 
NiNoticeInfo notice=(NiNoticeInfo)request.getAttribute("notice");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="refresh" content="60"/>
<title>welcome</title>
<link rel="stylesheet" href="<%=path %>/css/mian.css"  type="text/css"/>
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
	var indexMainCon_height=pageHeight();
	$(".indexMainCon").height(indexMainCon_height);
	$(".indexNews").height(indexMainCon_height/2-12);
	$(".indexNotice").height(indexMainCon_height/2-12);
$(window).resize(function(){
   $(".indexMainCon").height(pageHeight());
}); 

function pageHeight(){
    if($.browser.msie){
        return document.compatMode == "CSS1Compat"? document.documentElement.clientHeight :
        document.body.clientHeight;
    }else{
        return self.innerHeight;}
	}
	
});
function toAdd(obj){
//1&syear=2012&speriod=1
var syear = "";
var speriod = "";
	<%
		if(notice != null){
	%>
			syear = <%=notice.getNi_syear()%>;
			speriod = <%=notice.getNi_speriod()%>;
	<%
		}
	%>		
	window.location.href="<%=path %>/declare!toAdd?sblx="+obj+"&syear="+syear+"&speriod="+speriod;
}
function findNiNotice(){
	window.location.href="<%=path%>/declare!findNotice";
}
</script>
</head>


<body style="width:100%;">
<div class="indexMainCon">
                	<div class="indexNews">
                    	<h3><a href="javascript:void(0)" onclick="findNiNotice()">更多>></a><span>项目申报通知</span></h3>
                        <div class="indexNewsCon">
                        	<ul>
                              <!--  <li><span>[2012年6月8日]</span><a href="javascript:void(0)">公用房屋改造</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">房屋补贴</a></li>
								
                               
                            </ul>
                           <table> -->
  	<li>
  	<%
  	if(notice != null){
  	%>
  		<s:property value="notice.ni_syear"/>年度第<s:property value="notice.ni_speriod"/>次关于
  		&nbsp;
  	</li>
  	<li>
  		<% 
		if(notice.getNi_smoneycome().indexOf("0")!=-1){
	    	%>
  				<a href="javascript:void(0);" onclick="toAdd(0)" style="color: blue;">财政专项</a>
  			&nbsp;
	    	<% 
    	} if(notice.getNi_smoneycome().indexOf("1")!=-1){
    			%>
		  			<a href="javascript:void(0);" onclick="toAdd(1)" style="color: blue;">财政追加专项</a>
		  	&nbsp;
	    		<% 
    	} if(notice.getNi_smoneycome().indexOf("2")!=-1){
    			%>
		  			<a href="javascript:void(0);" onclick="toAdd(2)" style="color: blue;">中央财政支撑地方高校发展专项资金 </a>
		  	&nbsp;
		  		的申报通知。
	    		<% 
    	}else{
    			%>
		  			&nbsp;
		  		的申报通知。
    			<%
    	}
    		%>
    	</li>
  		<li>
  		通知显示时间:
  		<s:date name="notice.ni_sstime" format="yyyy-MM-dd"/> 至   <s:date name="notice.ni_setime" format="yyyy-MM-dd"/>
  	</li>
  		<li>
  		申报时间:
  		<s:date name="notice.ni_ddef1" format="yyyy-MM-dd"/> 至   <s:date name="notice.ni_ddef2" format="yyyy-MM-dd"/>
  	</li>
  		<li>
  		初审结束时间:
  		<s:date name="notice.ni_ddef3" format="yyyy-MM-dd"/>
  	</li>
  		<li>
  		归口单位审核结束:
  		<s:date name="notice.ni_ddef4" format="yyyy-MM-dd"/> </li>
  		<li>
  		上报结束时间:
  		<s:date name="notice.ni_ddef5" format="yyyy-MM-dd"/> 
  		</li>
  		<%}
  		else{
  			%>
  				<li>暂无通知</li>
  			<%
  		}
  		%>
  	</ul>
  <!--</table>
                        --></div>
                    </div>
                    <div class="indexNotice">
                    	<h3><a href="javascript:void(0)" >更多>></a><span>制度与帮助</span></h3>
                        <div class="indexNoticeCon">
                        	<ul>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">系统操作规范</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">大修业务流程查阅</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">巡检制度查阅</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">更新改造查阅</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">住宅专项制度查阅</a></li>
                                <li><span>[2012年6月8日]</span><a href="javascript:void(0)">系统操作手册下载</a></li>
                               
                            </ul>
                        </div>
                    </div>
                    <div class="indextrends indexNews">
                    <h3><a href="javascript:void(0)">更多>></a><span>我的表单</span></h3>
   	         <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
  <tr class="title">
    <td width="8%" height="24" align="center">序号</td>
    <td width="32%" align="center">单据名称</td>
    <td width="20%" align="center">单据类型</td>
    <td width="20%" align="center">提交日期</td>
    <td align="center">状态</td>
  </tr>
  <tr>
    <td height="24" align="center">1</td>
    <td align="center">名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月2日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">2</td>
    <td align="center">单据名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月10日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">3</td>
    <td align="center">名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月30日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">4</td>
    <td align="center">单据名称</td>
    <td align="center">类型</td>
    <td align="center">2012年9月6日</td>
    <td align="center">填写</td>
  </tr>
</table>

                       
                    </div>
                    <div class="indexNotice">
                    	<h3><a href="javascript:void(0)">更多>></a><span>审批单据</span></h3>
                         <table width="100%" border="0" cellspacing="0" style="border-color:#eeefff">
  <tr class="title">
    <td width="8%" height="24" align="center">序号</td>
    <td width="32%" align="center">单据名称</td>
    <td width="20%" align="center">单据类型</td>
    <td width="20%" align="center">提交日期</td>
    <td align="center">状态</td>
  </tr>
  <tr>
    <td height="24" align="center">1</td>
    <td align="center">名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月2日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">2</td>
    <td align="center">单据名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月10日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">3</td>
    <td align="center">名称</td>
    <td align="center">类型</td>
    <td align="center">2012年8月30日</td>
    <td align="center">填写</td>
  </tr>
  <tr>
    <td height="24" align="center">4</td>
    <td align="center">单据名称</td>
    <td align="center">类型</td>
    <td align="center">2012年9月6日</td>
    <td align="center">填写</td>
  </tr>
</table>

                    </div>
                </div>
</body>
</html>

