<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'StudentIndex.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="../css/index.css">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/menuchoose.js"></script>
		<script type="text/javascript" src="../js/cookie_util.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#tree li").children("ul").hide();
				promptName();
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
    							<li><a href="student_modifyInf.jsp" target="businessfrm">修改个人信息</a></li>
    							<li><a href="pwdModify.jsp" target="businessfrm">修改密码</a></li>
    						</ul>
    					</li>
    					<li class="up">
    					<a onclick=upDownMenu(this)>信息查询</a>
    						<ul>
    							<li><a href="baseInfromList.jsp" target="businessfrm">查询基地信息</a></li>
    							<li><a href="placardInfromList.jsp" target="businessfrm">查询常见问题信息</a></li>
    						</ul>
    					</li>
    					
    					<li class="up">
    					<a>实训报名</a>
    					</li>
    				</ul>
    			</td>
    			<!-- 内容选择区域 -->
    			<td class="content_display">
    				<div class="index_topright">
    					<div class="progress" style="float:left;"><lable id="progress"></lable></div>
    					<div class="inform_show" style="float:right;"><lable id="name_show"></lable></div>
    				</div>
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
