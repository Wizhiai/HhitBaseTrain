<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/datouwang.css" rel="stylesheet" type="text/css">
 <!-- 引入 echarts.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assess/echarts.common.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assess/getScore.js"></script>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<style type="text/css">
.pp{
position:fixed;left:43%;top:30%;margin-left:width/3;margin-top:height/3; 
margin: 0 auto; 
position: absolute;  
z-index: 9999; 
}
.divSuit{width: 100%;height:600px;
}
@media screen and (max-height:900px){

.divSuit{width: 100%;height:600px;

}
@media screen and (max-height:800px){

.divSuit{width: 100%;height:500px;

}
@media screen and (max-height:1600px){

.divSuit{width: 100%;height:500px;

}
</style>
 <script type="text/javascript">
	//此处引用：鼠标滚轮mousewheel插件
	!function(a){"function"==typeof define&&define.amd?define(["jquery"],a):"object"==typeof exports?module.exports=a:a(jQuery)}(function(a){function b(b){var g=b||window.event,h=i.call(arguments,1),j=0,l=0,m=0,n=0,o=0,p=0;if(b=a.event.fix(g),b.type="mousewheel","detail"in g&&(m=-1*g.detail),"wheelDelta"in g&&(m=g.wheelDelta),"wheelDeltaY"in g&&(m=g.wheelDeltaY),"wheelDeltaX"in g&&(l=-1*g.wheelDeltaX),"axis"in g&&g.axis===g.HORIZONTAL_AXIS&&(l=-1*m,m=0),j=0===m?l:m,"deltaY"in g&&(m=-1*g.deltaY,j=m),"deltaX"in g&&(l=g.deltaX,0===m&&(j=-1*l)),0!==m||0!==l){if(1===g.deltaMode){var q=a.data(this,"mousewheel-line-height");j*=q,m*=q,l*=q}else if(2===g.deltaMode){var r=a.data(this,"mousewheel-page-height");j*=r,m*=r,l*=r}if(n=Math.max(Math.abs(m),Math.abs(l)),(!f||f>n)&&(f=n,d(g,n)&&(f/=40)),d(g,n)&&(j/=40,l/=40,m/=40),j=Math[j>=1?"floor":"ceil"](j/f),l=Math[l>=1?"floor":"ceil"](l/f),m=Math[m>=1?"floor":"ceil"](m/f),k.settings.normalizeOffset&&this.getBoundingClientRect){var s=this.getBoundingClientRect();o=b.clientX-s.left,p=b.clientY-s.top}return b.deltaX=l,b.deltaY=m,b.deltaFactor=f,b.offsetX=o,b.offsetY=p,b.deltaMode=0,h.unshift(b,j,l,m),e&&clearTimeout(e),e=setTimeout(c,200),(a.event.dispatch||a.event.handle).apply(this,h)}}function c(){f=null}function d(a,b){return k.settings.adjustOldDeltas&&"mousewheel"===a.type&&b%120===0}var e,f,g=["wheel","mousewheel","DOMMouseScroll","MozMousePixelScroll"],h="onwheel"in document||document.documentMode>=9?["wheel"]:["mousewheel","DomMouseScroll","MozMousePixelScroll"],i=Array.prototype.slice;if(a.event.fixHooks)for(var j=g.length;j;)a.event.fixHooks[g[--j]]=a.event.mouseHooks;var k=a.event.special.mousewheel={version:"3.1.12",setup:function(){if(this.addEventListener)for(var c=h.length;c;)this.addEventListener(h[--c],b,!1);else this.onmousewheel=b;a.data(this,"mousewheel-line-height",k.getLineHeight(this)),a.data(this,"mousewheel-page-height",k.getPageHeight(this))},teardown:function(){if(this.removeEventListener)for(var c=h.length;c;)this.removeEventListener(h[--c],b,!1);else this.onmousewheel=null;a.removeData(this,"mousewheel-line-height"),a.removeData(this,"mousewheel-page-height")},getLineHeight:function(b){var c=a(b),d=c["offsetParent"in a.fn?"offsetParent":"parent"]();return d.length||(d=a("body")),parseInt(d.css("fontSize"),10)||parseInt(c.css("fontSize"),10)||16},getPageHeight:function(b){return a(b).height()},settings:{adjustOldDeltas:!0,normalizeOffset:!0}};a.fn.extend({mousewheel:function(a){return a?this.bind("mousewheel",a):this.trigger("mousewheel")},unmousewheel:function(a){return this.unbind("mousewheel",a)}})});
	
				var myBase=new Array();
				var gb1 = ["实践性教学计划和方案制定系统完整性","实践性课程教学大纲编写和规范归档","实践教学的校企合作和产学结合规划"];
var gb2 =["设备投入","基地发展规划","建设制度","重点实验室规模","校外实践基地规模","名企合作","聘用协议的企业规模"];
var gb3 = ["教学师资","教师配置情况","教学过程","指导书配置","能力培养","实习文化素质"];
var gb4 = ["实践性教学制度","管理规范","教改项目数量","师资结构","实践教学改革项目和成果奖励力度"];
var gb5 = ["实训学生论文规范性","实训学生竞赛","实训学生项目质量","基地开放实验、创新实践项目规模","毕业生素质"];
var gb6 = ["实践教学内容和兴趣度","实践基地建设需求","教师能力","学生技能发展的自由度","工程实践能力","就业能力和创业意识"];
					var series=new Array();
					var group1=new Array();
					var group2=new Array();
					var group3=new Array();
					var group4=new Array();
					var group5=new Array();
					var group6=new Array();
					var tArray = new Array();  //先声明一维
for(var k=0;k<100;k++){    //一维长度为i,i为变量，可以根据实际情况改变

tArray[k]=new Array();  //声明二维，每一个一维数组里面的一个元素都是一个数组；

for(var j=0;j<39;j++){   //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；

tArray[k][j]="";    //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
 }
}
					
					var i=0;
					
			var $btn = $('.section-btn li');
			$(function(){
					var $btn = $('.section-btn li');
					var $wrap = $('.section-wrap');
		var $arrow = $('.arrow');

		
		/*当前页面赋值*/
		function up(){i++;if(i==$btn.length){i=0};}
		function down(){i--;if(i<0){i=$btn.length-1};}
		
		/*页面滑动*/
		function run(){
			$btn.eq(i).addClass('on').siblings().removeClass('on');	
			$wrap.attr("class","section-wrap").addClass(function() { return "put-section-"+i; }).find('.section').eq(i).find('.title').addClass('active');
		};
		
		/*右侧按钮点击*/
		$btn.each(function(index) {
			$(this).click(function(){
				i=index;
				run();
			})
		});
		
		/*翻页按钮点击*/
		$arrow.one('click',go);
		function go(){
			up();run();	
			setTimeout(function(){$arrow.one('click',go)},1000)
		};
		
		/*响应鼠标*/
		$wrap.one('mousewheel',mouse_);
		function mouse_(event){
			if(event.deltaY<0) {up()}
			else{down()}
			run();
			setTimeout(function(){$wrap.one('mousewheel',mouse_)},1000)
		};
		
		/*响应键盘上下键*/
		$(document).one('keydown',k);
		function k(event){
			var e=event||window.event;
			var key=e.keyCode||e.which||e.charCode;
			switch(key)	{
				case 38: down();run();	
				break;
				case 40: up();run();	
				break;
			};
			setTimeout(function(){$(document).one('keydown',k)},1000);
		}
			//
			
			
			
			getScore();
			
			//
				
				});
					
			</script>
</head>
<body>
<!-- 代码 开始 -->
<section class="section-wrap">
	<div class="section section-3">
	<p class="pp" id="uploadresult"></p>
		<div class="title active">
				<table align="center" bgcolor="#FFFFFF" style="width: 80%;height:60%;">
		<tr>
		<td>	 <div id="zhexian"  class="divSuit" align="center"></div></td>
	
		</tr>
		</table>

		</div>
	</div>
	<div class="section section-2">
		<div class="title">
		<table align="center" bgcolor="#FFFFFF" style="width: 80%;height:60%;">
		<tr>
		<td>	 <div id="section-3" style="width:100%;height:565px;" align="center"></div></td>
	
		</tr>
		</table>
		
	
		</div>
	</div>
	<div class="section section-3">
		<div class="title">
		<table align="center" bgcolor="#FFFFFF" style="width: 80%;height:60%;">
		<tr>
		<td>	 <div id="group" style="width: 100%;height:565px;" align="center"></div></td>
	
		</tr>
		</table>

		</div>
	</div>
	
</section>
<ul class="section-btn">
	<li class="on"></li>
	<li></li>
	<li></li>
	
</ul>
<div class="arrow">&laquo;</div>

<!-- 代码 结束 -->

<div style="display:none"><script src="http://www.datouwang.com/img/js/demo_tj.js"></script></div>

</body>
</html>
