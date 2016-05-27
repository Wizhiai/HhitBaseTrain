<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生报名</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/student/trainregist.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	<div class="list">
  		<div class="topContent">
  			<h1>请选择基地</h1>
  			 <select id="baseName">
  	 			<option value="empty" select="selected"></option>
  			 </select><br>
  			 <h1 style="margin-top: 10px;">请选择课程</h1>
     		 <select id="courseName"></select><br/>
   	 		 <input type="button" value="报名" id="regist" class="editBtn"/>
  		</div>
  	</div>
  </body>
</html>
