<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>淮海工学院实训教务在线</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/admin/adminIndex.js"></script>
		<script type="text/javascript">
			
		</script>

  </head>
  
  <body style="min-width:1400px">
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
	  		<li><a href="admin_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
    		<li><a href="../pwdModify.jsp" target="businessfrm">修改密码</a></li>
	  	</ul>
	  	<div id="userInfo" class="personInfo">用户管理</div>
	  	<ul class="userManageMenu secondMenu">
	  		<li><a href="../user/addUser.jsp" target="businessfrm">添加用户</a></li>
	  		<li><a href="../user/deleteUser.jsp" target="businessfrm">删除用户</a></li>
	  		<li><a href="../user/userPwdReset.jsp" target="businessfrm">用户密码重置</a></li>
    	</ul> 
    	<div id="baseManage" class="personInfo">基地管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="../base/addBase.jsp" target="businessfrm">添加基地</a></li>
	  		<li><a href="../base/deleteBase.jsp" target="businessfrm">删除基地</a></li>
    	</ul>
    	<div id="searchInfo" class="personInfo">公告管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="../placard/addSchoolPlacard.jsp" target="businessfrm">发布公告信息</a></li>
	  		<li><a href="../placard/searchSchoolPlacard.jsp" target="businessfrm">编辑公告信息</a></li>
    	</ul> 
    	<ul id="registCount" class="personInfo">
    		<li>
    			<a id="trainregists" href="registStudentCount.jsp" target="businessfrm">学生实训统计</a>
    		</li>
    	</ul>
	  	<!--<ul id="userAccess" class="personInfo">
	  		<li>
    			<a id="trainregist" target="businessfrm">用户权限分配</a>
    		</li>
    	</ul>	
	  	--></section>
	  	<!-- 右边数据显示 -->
	  	<section class="rightContent">
	  	
	  		<iframe id="businessfrm" src=""
					frameborder="0" width="100%" height="100%" name="businessfrm"  height="100%"></iframe>
	  	</section>
	  </div>
  </body>
</html>
