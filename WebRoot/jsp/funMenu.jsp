<%@ page language="java" import="java.util.* " isELIgnored="false" isELIgnored="false" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
%>
<script language='JavaScript'>
var headHeight = 22;
var bodyHeight = 202;
var objcount = 2;
var step = 10;
var moving = false;
function showme(obj1, obj2)
{
	if (moving)
		return;
	moving = true;
	for(i=0;i<document.all.tags('td').length;i++)
		if (document.all.tags('td')[i].className.indexOf('headtd') == 0)
			document.all.tags('td')[i].className = 'headtd1';
	obj2.className = 'headtd2';
	moveme(obj1);
}
function moveme(obj)
{
	idnumber = parseInt(obj.id.substr(4));
	objtop = headHeight * (idnumber - 1);
	objbuttom = bodyHeight + headHeight * (idnumber - 2);
	currenttop = parseInt(obj.style.top);
	if (currenttop >= objbuttom)
	{
		countid = 1;
		for(i=0;i<document.all.tags('div').length;i++)
			if (document.all.tags('div')[i].id == 'item'+countid+'body')
			{
				obj = document.all.tags('div')[i];
				objtop = headHeight * (countid - 1);
				if (countid == idnumber)
				{
					moveup(obj,objtop,false);
					break;
				}
				else
					moveup(obj,objtop,true);
				countid++;
			}
	}
	else if ((currenttop <= objtop) && (idnumber < objcount))
	{
		idnumber++;
		countid = objcount;
		for(i=document.all.tags('div').length-1;i>=0;i--)
			if (document.all.tags('div')[i].id == 'item'+countid+'body')
			{
				obj = document.all.tags('div')[i];
				objbuttom = bodyHeight + headHeight * (countid - 2);
				if (countid == idnumber)
				{
					movedown(obj,objbuttom,false);
					break;
				}
				else
					movedown(obj,objbuttom,true);
				countid--;
			}
	}
}
function moveup(obj,objtop,ismove)
{
	currenttop = parseInt(obj.style.top);
	if (currenttop > objtop)
	{
		obj.style.top = currenttop - step;
		setTimeout('moveup('+obj.id+','+objtop+','+ismove+')',1);
		return;
	}
	moving = ismove;
}
function movedown(obj,objbuttom,ismove)
{
	currenttop = parseInt(obj.style.top);
	if (currenttop < objbuttom)
	{
		obj.style.top = currenttop + step;
		setTimeout('movedown('+obj.id+','+objbuttom+','+ismove+')',1);
		return;
	}
	moving = ismove;
}
</script>
<style type='text/css'>
.headtd1 {  background: #00A4E1; border: 2px outset; border-color: #00BBFF #0077FF #0077FF #00BBFF; cursor: hand; font-size: 9pt}
.headtd2 {  background: #20C1FF; border: 2px outset; border-color: #60D3FF #0077FF #0077FF #60D3FF; cursor: hand; font-size: 9pt}
.bodytd  {  background: #99CCFF; border: 2px outset; border-color: #B0D8FF #0077FF #0077FF #B0D8FF; font-size: 9pt}
</style>

        <div class="left">
        	<div class="left_g"></div>
            <div class="left_g2">
            	<div class="left_kk"></div>
 				
<script language='JavaScript'>
   document.write("<ul >");
   
document.write("</ul >");
      </script>
            </div>
            <div class="left_gtt"></div>
        </div>

