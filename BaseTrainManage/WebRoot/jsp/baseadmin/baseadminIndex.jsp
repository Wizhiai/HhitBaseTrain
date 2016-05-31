<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html >
  <head>
    <title>淮海工学院实训教务在线</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			$(function(){
				/*$("body").css("background","#dbecfb");
				$("body").css("height","100%");
				$("body").css("overflow","hidden");
				$(".secondMenu").css("display","none");
				 二级菜单的显示与隐藏  
				$(".personInfo").click(function(){
					$(this).next(".secondMenu").slideToggle(1);
					$(this).siblings().next(".secondMenu").css("display","none");
				});*/
				indexMenuManage();
				promptName();
				$("#exit").click(function(){
					exitSystem();
				});
			})
		</script>

  </head>
  
  <body>
  <!--  头部-->
	  <header class="stuHeader">
	  <div class="userLogin ">
	  	<div class="showUserName">
	  		<a id="exit">【退出】</a>
	  		<label id="name_show"></label>
	  	</div>
	  </div>
	  </header>
	  <!-- 主体内容 -->
	  <div class="CMSMain" >
	  <!-- 左侧菜单栏 -->
	  	<section class="userMenuLeft">
	  	<h1>功能菜单</h1>
	  	<div  id="personManage" class="personInfo">个人信息管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="baseadmin_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
    		<li><a href="../pwdModify.jsp" target="businessfrm">修改密码</a></li>
	  	</ul>
	  	<div id="searchInfo" class="personInfo">基地信息管理</div>
	  	<ul class="secondMenu">
	  		<li><a target="businessfrm">查询基地信息</a></li>
	  		<li><a href="" target="businessfrm">编辑基地信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">基地教师管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="../../html/JDTManager_addBaseTeacher.html" target="businessfrm">添加教师信息</a></li>
	  		<li><a href="../../html/JDTManager_updateBaseTeacherInfo.html" target="businessfrm">编辑教师信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">公告管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="#" target="businessfrm">发布公告信息</a></li>
	  		<li><a href="#" target="businessfrm">编辑公告信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">实训学生管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="../../html/JDTManager_addTrainStudentInfo.html" target="businessfrm">添加实训学生</a></li>
	  		<li><a href="" target="businessfrm">编辑实训学生信息</a></li>
    	</ul> 
	  	<ul id="signUp" class="personInfo">
	  		<li>
    			<a id="trainregist" href="../../html/JDTManager_tongjiTrainStudent.html" target="businessfrm" >学生实训统计</a>
    		</li>
    	</ul>	
	  	</section>
	  	<!-- 右边数据显示 -->
	  	<section class="rightContent">
	  		<iframe id="businessfrm" src=""
					frameborder="0" width="100%" height="100%" name="businessfrm" scrolling="no";></iframe>
	  	</section>
	  </div>
  </body>
</html>
