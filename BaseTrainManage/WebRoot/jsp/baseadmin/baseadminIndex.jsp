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
		<script type="text/javascript">
			$(function(){
				$("body").css("background","#dbecfb");
				$("body").css("height","100%");
				$("body").css("overflow","hidden");
				$(".secondMenu").css("display","none");
				/* 二级菜单的显示与隐藏  */
				$(".personInfo").click(function(){
					$(this).next(".secondMenu").slideToggle(1);
					$(this).siblings().next(".secondMenu").css("display","none");
				});
				promptName();
				$("#exit").click(function(){
					exitSystem();
				});
			})
		</script>

  </head>
  
  <body>
    <!--<div class="StudentIndex_nav">
    	导航
    </div>
     内容区域 
    <div class="StudentIndex_content">
    	<table border="1 soliid black" cellspacing="20" style="width:100%;">
    		<tr>
    			功能选择区域 
    			<td class="function" style="width:20%;">
    				<ul id="tree">
    					<li class="up">
    					<a onclick="upDownMenu(this)">个人信息管理</a>
    						<ul>
    							<li><a href="baseadmin_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
    							<li><a href="../pwdModify.jsp" target="businessfrm">修改密码</a></li>
    						</ul>
    					</li>
    					<li class="up">
    					<a onclick=upDownMenu(this)>基地信息管理</a>
    						<ul>
    							<li><a>修改基地信息</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a onclick=upDownMenu(this)>基地公告管理</a>
    						<ul>
    							<li><a>发布公告</a></li>
    							<li><a>修改公告</a></li>
    							<li><a>删除公告</a></li>
    							<li><a>查询公告</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a onclick=upDownMenu(this)>学生实训统计</a>
    						<ul>
    							<li><a>专业划分统计</a></li>
    							<li><a>实训课程统计</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a onclick=upDownMenu(this)>基地教师信息管理</a>
    						<ul>
    							<li><a>添加基地教师</a></li>
    							<li><a>修改教师信息</a></li>
    							<li><a>删除基地教师</a></li>
    							<li><a>查询基地教师</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a onclick=upDownMenu(this)>学生信息管理</a>
    						<ul>
    							<li><a>查询学生信息</a></li>
    							<li><a>修改学生信息</a></li>
    							<li><a>删除学生信息</a></li>
    							<li><a>添加学生信息</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a onclick=upDownMenu(this)>学生权限分配</a>
    					</li>
    					
    				</ul>
    			</td>
    			 内容选择区域 
    			<td class="content_display">
    				<div class="index_topright">
    					<div class="progress" style="float:left;"><lable id="progress"></lable></div>
    					<div class="inform_show" style="float:right;">
    						<lable id="name_show"></lable>
    						<a id="exit">【退出】</a>
    					</div>
    				</div>
    				<iframe id="businessfrm" src=""
						frameborder="0" width="100%" name="businessfrm" scrolling="no";height="510px";></iframe>
    			</td>
    		</tr>
    	</table>
    </div>
    
     网页末尾 
    <div class="StudentIndex_foot">
    网页末尾
    </div>
  -->
  <!--  头部-->
	  <header class="stuHeader"></header>
	  <div class="userLogin ">
	  	<div class="showUserName">
	  		<a id="exit">【退出】</a>
	  		<label id="name_show"></label>
	  	</div>
	  </div>
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
	  		<li><a href="" target="businessfrm">查询基地信息</a></li>
	  		<li><a href="" target="businessfrm">编辑基地信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">基地教师管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="" target="businessfrm">添加教师信息</a></li>
	  		<li><a href="" target="businessfrm">编辑教师信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">公告管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="" target="businessfrm">发布公告信息</a></li>
	  		<li><a href="" target="businessfrm">编辑公告信息</a></li>
    	</ul> 
    	<div id="searchInfo" class="personInfo">实训学生管理</div>
	  	<ul class="secondMenu">
	  		<li><a href="" target="businessfrm">添加实训学生</a></li>
	  		<li><a href="" target="businessfrm">编辑实训学生信息</a></li>
    	</ul> 
	  	<div id="signUp" class="personInfo">
    		<a id="trainregist" target="businessfrm">学生实训统计</a>
    	</div>	
	  	</section>
	  	<!-- 右边数据显示 -->
	  	<section class="rightContent">
	  		<iframe id="businessfrm" src=""
					frameborder="0" width="100%" height="100%" name="businessfrm" scrolling="no";></iframe>
	  	</section>
	  </div>
  </body>
</html>
