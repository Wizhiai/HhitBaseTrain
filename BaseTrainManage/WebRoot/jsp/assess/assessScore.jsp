<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教学质量评估</title>
<link href="css/datouwang.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
 <!-- 引入 echarts.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assess/echarts.common.min.js"></script>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
    
    

<!--<link type="text/css" rel="stylesheet" href="../../css/button.css" />

--><script type="text/javascript" src="....//js/asSystemmenu.js"></script>
<script type="text/javascript" src="../../js/js.js"></script>
<link type="text/css" rel="stylesheet" href="../../css/index.css" /><!--
图文栏引用
--><link rel="favicon" href="assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.useso.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen"> 
	<link rel="stylesheet" href="assets/css/style.css">
    <link rel='stylesheet' id='camera-css'  href='assets/css/camera.css' type='text/css' media='all'> 
      <link href="http://vjs.zencdn.net/5.8.8/video-js.css" rel="stylesheet">

  <!-- If you'd like to support IE8 -->
  <script src="http://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
<script type="text/javascript">
$(function(){

baseNameShow();
});
//基地评价名称显示
function baseNameShow(){

 var p = document.getElementById("baseName");
var strCookie=document.cookie; 
var arrCookie=strCookie.split("; "); 

for(var i=0;i<arrCookie.length;i++){ 
var arr=arrCookie[i].split("="); 



if(arr[0]=="base_no")

   
    
    
   	$.ajax({
				url:"/BaseTrainManage/base/searchByBaseNo.do",
				type:"post",
				data:{"base_no": arr[1]},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
					/*	$("#base_name").val(result.data.base_name);
						$("#base_address").val(result.data.base_address);
						$("#establish_time").val(result.data.establish_time);*/
						 p.innerHTML = result.data.base_name;
    
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});

} 
}
</script>

</head>
<body>
<style type="text/css">
 
    table{border-left: 1px solid #666; border-bottom: 1px solid #666;}
td{border-right:1px solid #666;border-top: 1px solid #666;}
 
    </style>
<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	margin-top: 0px;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}


<!-- 代码 开始 -->
<section class="section-wrap">
	<div class="section section-1">





  <video id="my-video" class="video-js" controls preload="auto" width="640" height="264"
  poster="MY_VIDEO_POSTER.jpg" data-setup="{}">
    <source src="MY_VIDEO.mp4" type='video/mp4'>
    <source src="MY_VIDEO.webm" type='video/webm'>
    <p class="vjs-no-js">
      To view this video please enable JavaScript, and consider upgrading to a web browser that
      <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
  </video>

  <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>


     
			
			
		</div>
	<div class="section section-2">
		<div class="title">


		</div>
	</div>
	<div class="section section-3">
	
	
	</div>
	<div class="section section-4">
		<div class="title">
		
		</div>
	</div>
	<div class="section section-5">
		<div class="title">
	
		</div>
	</div>

</div>
	<div class="section section-6">
		<div class="title">
	
		</div>
	</div>
	
	
	
</div>
	<div class="section section-7">
		<div class="title">
		
		</div>
	</div>
</section>
<ul class="section-btn">
	<li class="on"></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
</ul>
<div class="arrow">&laquo;</div>

<script type="text/javascript">
	//此处引用：鼠标滚轮mousewheel插件
	!function(a){"function"==typeof define&&define.amd?define(["jquery"],a):"object"==typeof exports?module.exports=a:a(jQuery)}(function(a){function b(b){var g=b||window.event,h=i.call(arguments,1),j=0,l=0,m=0,n=0,o=0,p=0;if(b=a.event.fix(g),b.type="mousewheel","detail"in g&&(m=-1*g.detail),"wheelDelta"in g&&(m=g.wheelDelta),"wheelDeltaY"in g&&(m=g.wheelDeltaY),"wheelDeltaX"in g&&(l=-1*g.wheelDeltaX),"axis"in g&&g.axis===g.HORIZONTAL_AXIS&&(l=-1*m,m=0),j=0===m?l:m,"deltaY"in g&&(m=-1*g.deltaY,j=m),"deltaX"in g&&(l=g.deltaX,0===m&&(j=-1*l)),0!==m||0!==l){if(1===g.deltaMode){var q=a.data(this,"mousewheel-line-height");j*=q,m*=q,l*=q}else if(2===g.deltaMode){var r=a.data(this,"mousewheel-page-height");j*=r,m*=r,l*=r}if(n=Math.max(Math.abs(m),Math.abs(l)),(!f||f>n)&&(f=n,d(g,n)&&(f/=40)),d(g,n)&&(j/=40,l/=40,m/=40),j=Math[j>=1?"floor":"ceil"](j/f),l=Math[l>=1?"floor":"ceil"](l/f),m=Math[m>=1?"floor":"ceil"](m/f),k.settings.normalizeOffset&&this.getBoundingClientRect){var s=this.getBoundingClientRect();o=b.clientX-s.left,p=b.clientY-s.top}return b.deltaX=l,b.deltaY=m,b.deltaFactor=f,b.offsetX=o,b.offsetY=p,b.deltaMode=0,h.unshift(b,j,l,m),e&&clearTimeout(e),e=setTimeout(c,200),(a.event.dispatch||a.event.handle).apply(this,h)}}function c(){f=null}function d(a,b){return k.settings.adjustOldDeltas&&"mousewheel"===a.type&&b%120===0}var e,f,g=["wheel","mousewheel","DOMMouseScroll","MozMousePixelScroll"],h="onwheel"in document||document.documentMode>=9?["wheel"]:["mousewheel","DomMouseScroll","MozMousePixelScroll"],i=Array.prototype.slice;if(a.event.fixHooks)for(var j=g.length;j;)a.event.fixHooks[g[--j]]=a.event.mouseHooks;var k=a.event.special.mousewheel={version:"3.1.12",setup:function(){if(this.addEventListener)for(var c=h.length;c;)this.addEventListener(h[--c],b,!1);else this.onmousewheel=b;a.data(this,"mousewheel-line-height",k.getLineHeight(this)),a.data(this,"mousewheel-page-height",k.getPageHeight(this))},teardown:function(){if(this.removeEventListener)for(var c=h.length;c;)this.removeEventListener(h[--c],b,!1);else this.onmousewheel=null;a.removeData(this,"mousewheel-line-height"),a.removeData(this,"mousewheel-page-height")},getLineHeight:function(b){var c=a(b),d=c["offsetParent"in a.fn?"offsetParent":"parent"]();return d.length||(d=a("body")),parseInt(d.css("fontSize"),10)||parseInt(c.css("fontSize"),10)||16},getPageHeight:function(b){return a(b).height()},settings:{adjustOldDeltas:!0,normalizeOffset:!0}};a.fn.extend({mousewheel:function(a){return a?this.bind("mousewheel",a):this.trigger("mousewheel")},unmousewheel:function(a){return this.unbind("mousewheel",a)}})});
	
	$(function(){
		var i=0;
		var $btn = $('.section-btn li'),
			$wrap = $('.section-wrap'),
			$arrow = $('.arrow');
		
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
	});
</script>
<!-- 代码 结束 -->

<div style="display:none"><script src="../../js/assess/gd.js"></script></div>

</body>
</html>
