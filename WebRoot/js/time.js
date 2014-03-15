// JavaScript Document
$().ready(function(){
function showTime(){
var date=new Date();
year=date.getFullYear();
month=date.getMonth()+1;
day=date.getDate();
week=date.getDay();
hour=date.getHours();
minute=date.getMinutes();

second=date.getSeconds();
/*if(week==0){
	week="日"}else if(week==1){week="一"}
	else if(week==2){week="二"}
	else if(week==3){week="三"}
	else if(week==4){week="四"}
	else if(week==5){week="五"}
	else{week="六"}*/
	switch(week){
		case 1:week="一";break;
		case 2:week="二";break;
		case 3:week="三";break;
		case 4:week="四";break;
		case 5:week="五";break;
		case 6:week="六";break;
		default:week="日";
		}
//document.write(year+"年"+month+"月"+week+"日星期"+day+"<br />");
//document.write(hour+"时"+minute+"分"+second+"秒")
document.getElementById("timeBox").innerHTML="欢迎访问，今天是"+year+"年"+month+"月"+day+"日 "+hour+"时"+minute+"分"+second+"秒 星期"+week;
}
setInterval(showTime,1000);


for(i=0;i<document.getElementById("navMenu").getElementsByTagName("li").length;i++){
 document.getElementById("navMenu").getElementsByTagName("li")[i].onmouseover=function(){
	 if(this.getElementsByTagName("ul").length>0){//如果滑过当前的li里面有UL
	 this.className="has hover"
	 }
	 }
	 document.getElementById("navMenu").getElementsByTagName("li")[i].onmouseout=function(){
	 if(this.getElementsByTagName("ul").length>0){
	 this.className="has"
	 }
	 }
} 


})
