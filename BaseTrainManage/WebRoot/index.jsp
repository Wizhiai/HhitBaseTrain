<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>淮海工学院计算机工程学院实训教务aaa11在线</title>
  	<link rel="stylesheet" href="css/index.css"/>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			
  			$("#adminLogin").click(function(){
  				window.location.href="jsp/adminLogin.jsp";
  			});
  			$("#baseAdminLogin").click(function(){
  				window.location.href="jsp/baseadminLogin.jsp";
  			});
  			$("#baseInformLogin").click(function(){
  				window.location.href="jsp/baseInformLogin.jsp";
  			});
  			$("#baseTrainLogin").click(function(){
  				window.location.href="jsp/baseTrainLogin.jsp";
  			});
  			$("#baseValueLogin").click(function(){
  				window.location.href="jsp/baseValueLogin.jsp";
  			});
  		})
  	</script>
  </head>
  <body>
    <!-- TOP:导航 -->
  	<div class="Index_nav">
  	<p>导航</p>
  	</div>
  	<br/>
  	<!-- 中间：内容 -->
  	<div class="Index_content">
  	 <table border="1 soliid black" cellspacing="20"> 
  	  <tr>
  	  <!-- 左半部份 -->
  	   <td class="left_content">
  		  <div>
  		   <p>特别提醒</p>
  		  </div>
  	   </td>	
  	  
  	  <!-- 中间:公告 -->
  	   <td class="middle_content">
  	    <div >
  		  <p>公告</p>
  	    </div>
  	   </td>	
  	  
  	  <!-- 右半部分 -->
  	   <td class="right_content">
  	    <div>
  	     <img alt="" src="">
  	     <button id="adminLogin">管理员</button>
  	     <button id="baseAdminLogin">基地管理员</button>
  	     <button id="baseInformLogin">基地信息系统</button>
  	     <button id="baseTrainLogin">实训教学监控系统</button>
  	     <button id="baseValueLogin">实训评估系统</button>
  		   <p>系统登录</p>
  		  </div>
  	   </td>		
  	  </tr>
  	</table>
  	
  	</div>
  	<br/>
  	<!-- 网页末尾 -->
  	<div class="Index_foot">
  	<p>网页末尾</p>
  	</div>
  	
  </body>
</html>
