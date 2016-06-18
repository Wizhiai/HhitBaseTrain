<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>基地信息查询学校教师首页</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/collegeteacher/collegeTeacherIndex.js"></script>
		<script type="text/javascript">
			
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
	 		<li><a href="collegeTeacher_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
   		<li><a href="../pwdModify.jsp" target="businessfrm">修改密码</a></li>
	 	</ul>
	 	<div id="searchInfo" class="personInfo">信息查询</div>
	 	<ul class="secondMenu" style="height:120;">
	 		<li><a href="../base/baseInfromList.jsp" target="businessfrm">查询基地基本信息</a></li>
	 		<li><a href="../traincourse/teacherskimCourseInfromList.jsp" target="businessfrm">查询基地开课信息</a></li>
	 		<li><a href="../placard/questionInfromList.jsp" target="businessfrm">查询常见问题信息</a></li>
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
