<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>淮海工学院计算机工程学院实训教务在线</title>
  	<link rel="stylesheet" href="css/common.css"/>
  	<link rel="stylesheet" href="css/index.css"/>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<script type="text/javascript" src="js/cookie_util.js"></script>
  	<script type="text/javascript" src="js/index.js"></script>
  	<script type="text/javascript">
<<<<<<< HEAD
  	/*	var placardLength = parseInt(6);
  		$(function(){
  		/*检测屏幕高度，设置页脚位置*/
  		$Height=$(window).height();
  		mainHeight=$Height-390;
  		$(".main").height(mainHeight);
  			showSchoolPagePlacard();
  			$("#getMore").click(function(){
  				window.location.href="jsp/placard/schoolPlacardInfromList.jsp";
  			});
  			$("#adminLogin").click(function(){
  				window.location.href="jsp/admin/adminLogin.jsp";
  			});
  			$("#baseAdminLogin").click(function(){
  				window.location.href="jsp/baseadmin/baseadminLogin.jsp";
  			});
  			$("#baseInformLogin").click(function(){
  				window.location.href="jsp/baseInformLogin.jsp";
  			});
  			$("#baseTrainLogin").click(function(){
  				window.location.href="html/studentLogin1.jsp";
  			});
  			$("#baseValueLogin").click(function(){
  				window.location.href="jsp/baseValueLogin.jsp";
  			});
  		})
  		function showSchoolPagePlacard(){//显示学校公告基本信息
  				$.ajax({
  					url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchAll.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								var data = result.data;
								for(var i = 0;i < placardLength && i<data.length;i++){
									var tr = "<li><a onclick='gotoSchoolPlacard();'><span class='titleOfannounce'>"+data[i].placard_title+"</span>";
									tr +="<span class='dateOfannounce'><input type='hidden' id='placard_no' value="+data[i].placard_no+"/>"+data[i].publish_time+"</span></a></li>";
									$("#schoolPlacard").append($(tr));
								}
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
  				});
  		}
  		function gotoSchoolPlacard(){
  			var placard_no = $("#placard_no").val();
				addCookie("placard_no",placard_no,2);
				window.open("jsp/placard/schoolplacard.jsp");
  		}*/
=======
>>>>>>> 07e1430a0a14fdea4cd8affa8cccfb340dda983e
  	</script>
  </head>
  <body style="background:url(images/background.png) 100% 100%">
	  <div class="total">
	  <!--  头部-->
	  	<header></header>
	  	<!-- 主体内容 -->
	  	<div class="main">
	  	<!-- 公告内容 -->
	  	<section class="announcement ">
	  		<article id="placardInfo">
	  			<h1>公告通知</h1>
	  			<span id="getMore"><a>+More+</a></span>
	  			<ul id="schoolPlacard">
	  			</ul>
	  		</article>	
	  
	  	</section>
	  	<!-- 应用系统 -->
	  	<section class="program">
	  	<ul>
	  		<h1 class="loginTitle">系统登录</h1>
	  		<li id="adminLogin"><img alt="登录" src="images/index1.png"><span>超级管理员入口</span></li>
	  		<li id="baseAdminLogin"><img alt="登录" src="images/index2.png"><span>基地管理员入口</span></li>
	  		<li id="baseInformLogin"><img alt="登录" src="images/index3.png"><span>基地信息查询系统</span></li>
	  		<li id="baseTrainLogin"><img alt="登录" src="images/index4.png"><span>实训学生管理系统</span></li>
	  		<li id="baseValueLogin"><img alt="登录" src="images/index5.png"><span>实训教学评估系统</span> </li>
	  	</ul>
	  	</section>
	  	</div>
	  	<!-- 页脚 -->
	  	<footer class="clearfix">
	  		<div class="linkUrl">
	  			<span>友情链接：</span>
	  			<a href="http://jwc.hhit.edu.cn/">教务处首页</a>
	  			<a href="http://jsjxy.hhit.edu.cn/">计算机工程学院首页</a>
	  			<a href="http://sjweb.hhit.edu.cn//">凌风阁</a>
	  			<a href="http://lib.hhit.edu.cn//">图书馆</a>
	  		</div>
	  		<p>Copyright © 2016  All Rights Reserved</p>
	  	</footer>
	  </div>
	 
  </body>
</html>
