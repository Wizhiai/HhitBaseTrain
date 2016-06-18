<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加基地课程信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/traincourse/addBaseCourse.js"></script>
	 	<script type="text/javascript">
	 		
	 	</script>
 	
  </head>
  
  <body>
    <div class="list">
	  	<div class="topContent">
	  		<h1>请输入课程名</h1>
	  		<input type="text" id="cname"/><span id="msg"></span>
	  		<h1>请输入课程花费</h1>
	  		<input type="text" id="cost"/>元<br/>
	  		<h1>请输入学习时间</h1>
	  		<input type="text" id="term"/>个月<br/>
	   	 <input type="button" value="添加" id="add" class="editBtn" style="margin-top: 30px;"/>
	   	</div>
    </div>
  </body>
</html>
