<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>淮海工学院实训教务在线</title>
		<link rel="stylesheet" type="text/css" href="../css/index.css">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/menuchoose.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#tree li").children("ul").hide();
			})
		</script>

  </head>
  
  <body>
    <div class="StudentIndex_nav">
    	导航
    </div>
    <!-- 内容区域 -->
    <div class="StudentIndex_content">
    	<table border="1 soliid black" cellspacing="20" style="width:100%;">
    		<tr>
    			<!--功能选择区域 -->
    			<td class="function" style="width:20%;">
    				<ul id="tree">
    					<li class="up">
    					<a onclick="upDownMenu(this)">个人信息管理</a>
    						<ul>
    							<li><a href="admin_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
    							<li><a href="pwdmodify.jsp" target="businessfrm">修改密码</a></li>
    						</ul>
    					</li>
    					<li class="up">
    					<a onclick=upDownMenu(this)>用户管理</a>
    						<ul>
    							<li><a>添加用户</a></li>
    							<li><a>修改用户信息</a></li>
    							<li><a>删除用户</a></li>
    							<li><a>查询用户信息</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    						<a onclick=upDownMenu(this)>基地管理</a>
    						<ul>
    							<li><a>添加基地</a></li>
    							<li><a>删除基地</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    						<a onclick=upDownMenu(this)>学生实训统计</a>
    						<ul>
    							<li><a>专业划分统计</a></li>
    							<li><a>实训单位划分统计</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    						<a onclick=upDownMenu(this)>公告管理</a>
    						<ul>
    							<li><a>发布公告</a></li>
    							<li><a>修改公告</a></li>
    							<li><a>删除公告</a></li>
    							<li><a>查询公告</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    						<a>用户权限分配</a>
    					</li>
    				</ul>
    			</td>
    			<!-- 内容选择区域 -->
    			<td class="content_display">
    				<div class="index_topright"></div>
    				<iframe id="businessfrm" src=""
						frameborder="0" width="100%" name="businessfrm" scrolling="no";height="510px";></iframe>
    			</td>
    		</tr>
    	</table>
    </div>
    
    <!-- 网页末尾 -->
    <div class="StudentIndex_foot">
    网页末尾
    </div>
  </body>
</html>
