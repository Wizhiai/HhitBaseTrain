<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta content="">
    <title>学校教师修改个人信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
    <script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/datepicker.js" ></script>
    <script type="text/javascript" src="../../js/datepicker.en.js"></script>
		<script type="text/javascript" src="../../js/collegeteacher/collegeTeacher_modifyInf.js"></script>
  </head>
  <body>
   <div class="list">
	 	 <div class="modifyInfo collegeTeacherInfo" >
	    	<span>姓&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>性&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sex"/></span><br/>
	    	<span>所在学院：<input type="text" id="academy"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>联系方式：<input type="text" id="telephone"/></span><br/>
	    	<span>职&nbsp;&nbsp;&nbsp;称：&nbsp;&nbsp;&nbsp;<input type="text" id="profession"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<span>出生日期：<input type="text" id="birthday"></span><br/>
	    	<input type="button" value="修改" id="modify" class="editBtn">
	    	<input type="button" value="保存" id="update" class="editBtn"/>
	   </div>
  </div>
 </body>
</html>
