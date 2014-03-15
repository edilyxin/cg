<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$().ready(function(){ 
$("table tr").mouseover(function(){ 
$(this).addClass("over");}).mouseout(function(){
$(this).removeClass("over");}) 
});
</script>
</head>
<body>

<div class="right">
 <p class="p">您现在的位置：主页>>公用房管理>>公用房信息</p>
 <div class="mo">
  <h4>模块功能列表</h4>
  <form action="#" method="post">
   <select>
    <option>查找范围</option>
    <option>1</option>
    <option>1</option>
   </select>
   <input type="text" value="输入关键字" class="txt"/><input type="button" value="搜索" class="but"/>
  </form>
 </div>
 <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#FFFFFF">
  <tr bgcolor="#F5F5F5" >
    <td width="4%" >选定</td>
    <td width="6%" >ID</td>
    <td width="20%" >标题</td>
    <td width="13%" >审核状态</td>
    <td width="12%" >点击率</td>
    <td width="18%" >上传时间</td>
    <td colspan="2" >排序</td>
    <td colspan="3" >操作</td>
    </tr>
  <tr bgcolor="#F2F2F2">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td width="3%" ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td width="3%" ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td width="7%" ><a href="#">增加</a></td>
    <td width="7%" ><a href="#">删除</a></td>
    <td width="7%" ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F5F5F5">
    <td><input type="checkbox"></td>
    <td>545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F2F2F2" >
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F5F5F5" >
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F2F2F2">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F5F5F5">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F2F2F2">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F5F5F5">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F2F2F2">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F5F5F5">
    <td ><input type="checkbox"></td>
    <td >545</td>
    <td >舒康服务平台软</td>
    <td >生效</td>
    <td >397次</td>
    <td >2013-1.01</td>
    <td ><img src="image/jiant.jpg" width="11" height="17" /></td>
    <td ><img src="image/jianb.jpg" width="11" height="17" /></td>
    <td ><a href="#">增加</a></td>
    <td ><a href="#">删除</a></td>
    <td ><a href="#">修改</a></td>
  </tr>
  <tr bgcolor="#F2F2F2">
    <td ><input type="checkbox"></td>
    <td >全选</td>
    <td >删除</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
    <td >&nbsp;</td>
  </tr>
</table>
<p class="p_b">当前页码：1/1&nbsp;&nbsp;<a href="#">首页</a><a href="#">&nbsp;&nbsp;上一页</a><a href="#">&nbsp;&nbsp;下一页</a><a href="#">&nbsp;&nbsp;尾页</a>&nbsp;&nbsp;共1条&nbsp;&nbsp;跳转到第<select><option>1</option><option>1</option></select>&nbsp;页</p>
  
</div>
</body>
</html>
