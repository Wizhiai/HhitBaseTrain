<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta content="">
    <title>My JSP 'admin_modifyInf.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="../css/index.css">-->
		<script type="text/javascript" src="../../js/baseadmin/baseadmin_modifyInf.js"></script>
  </head>
  <body>
    	姓名：<input type="text" id="name"/>
    	联系方式：<input type="text" id="telephone"/>
    	<input class="modify" type="button" value="修改" id="modify">
    	<input class="back" type="button" value="返回" id="back">
  </body>
</html>
