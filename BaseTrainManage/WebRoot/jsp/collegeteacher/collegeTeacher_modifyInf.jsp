<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta content="">
    <title>My JSP 'admin_modifyInf.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="../css/index.css">-->
	<script type="text/javascript" src="../../js/collegeteacher/collegeTeacher_modifyInf.js"></script>
  </head>
  <body>
    	姓名：<input type="text" id="name"/>
    	&nbsp;&nbsp;&nbsp;
    	性别：<input type="text" id="sex"/>
    	出生日期：<input type="text" id="birthday"><br/>
    	所在学院：<input type="text" id="academy"><br/>
    	职称：<input type="text" id="profession"><br/>
    	联系方式：<input type="text" id="telephone"/>
    	<input class="modify" type="button" value="修改" id="modify">
    	<input class="back" type="button" value="返回" id="back">
  </body>
</html>
