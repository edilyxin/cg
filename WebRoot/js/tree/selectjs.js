/* Create a new XMLHttpRequest object to talk to the Web server */
var xmlHttp = false;
/*@cc_on @*/
/*@if (@_jscript_version >= 5)
try {
xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
try {
xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
} catch (e2) {
xmlHttp = false;
}
}
@end @*/
if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
xmlHttp = new XMLHttpRequest();
}

/*
添加下拉菜单（path:相对路径 ，
actionName:数据来源 ，
idName：下拉菜单id ，
fieldName：下拉菜单name，
findName:数据查找名称，
 value：下拉菜单value,
 width:下拉菜单宽度，
 valid：验证 ）
 addSelect('','dict','showPostLevel','post_nLevel','post_nLevel','','','valid=required errmsg=请选择管理级别!');
*/
function addSelect(path,actionName,idName,fieldName,findName,value,width,valid)
{
if(width ==null||width =='' ||width==undefined){
width = '132';
}
if(valid ==null||valid==undefined){
valid = '';
}
	document.getElementById(idName).innerHTML = "<select name='"+fieldName+"' style='width:"+width+"' "+valid+"><option value=''>数据更新中…</option></select>";
	xmlHttp.open("POST",path+"/"+actionName+"!selectDict&id="+findName+"&value="+value,false);
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4 && xmlHttp.status==200)
		{
			document.getElementById(idName).innerHTML = "<select name='"+fieldName+"' style='width:"+width+"' "+valid+">"+xmlHttp.responseText+"</select>";
		}else if(xmlHttp.readyState==4 && xmlHttp.status!=200){
			document.getElementById(idName).innerHTML = "<select name='"+fieldName+"' style='width:"+width+"' "+valid+"><option style='color:red' value=''>数据错误！</option></select>";
		}
	};
	xmlHttp.send();
}
