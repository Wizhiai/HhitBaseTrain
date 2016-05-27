<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta content="">
    <title>学生修改个人信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/student/student_modifyInf.js"></script>
  </head>
  <body>
  	<div class="list">
	 	 <div class="modifyInfo studentInfo" >
	    	<span>姓&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>性&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sex"/></span><br/>
	    	<span>专&nbsp;&nbsp;&nbsp;业：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="major"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>入学年份：<input type="text" id="enter_year"></span><br/>
	    	<span>班&nbsp;&nbsp;&nbsp;级：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="class"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>联系方式：<input type="tel" id="telephone"/></span><br/>
	    	<span>家庭地址：<input type="text" id="address"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>出生日期：<input type="text" id="birthday" required></span><br/>
	    	<input type="button" value="修改" id="modify" class="editBtn">
	    	<input type="button" value="保存" id="update" class="editBtn"/>
	  </div>
  </div>
  </body>
</html>
