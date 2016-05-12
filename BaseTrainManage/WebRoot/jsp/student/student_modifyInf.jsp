<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta content="">
    <title>My JSP 'admin_modifyInf.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="../css/index.css">-->
		<script type="text/javascript" src="../../js/student/student_modifyInf.js"></script>
  </head>
  <body>
    	姓名：<input type="text" id="name"/>
    	&nbsp;&nbsp;&nbsp;
    	性别：<input type="text" id="sex"/><br/>
    	出生日期：<input type="text" id="birthday">
    	&nbsp;&nbsp;&nbsp;
    	入学年份：<input type="text" id="enter_year"><br/>
    	专业：<input type="text" id="major">
    	&nbsp;&nbsp;&nbsp;
    	班级：<input type="text" id="class"><br/>
    	联系方式：<input type="text" id="telephone"/>
    	家庭地址：<input type="text" id="address"/><br/>
    	
    	<input class="modify" type="button" value="修改" id="modify">
    	<input class="back" type="button" value="返回" id="back">
  </body>
</html>
