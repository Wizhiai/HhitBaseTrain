<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>实训报名详情</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/admin/clearRegistStudentCountInfo.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	<div class="list">
  	<div class="topContent">
	   	<div id="studnetRegistCountInform">
	    <table id="showInform" border="1" style="border:1px solid black;">
	    	<thead>
	    		<th>序号</th>
	    		<th>学生姓名</th>
	    		<th>班级</th>
	    		<th>专业</th>
	    		<th>基地名</th>
	    		<th>课程名</th>
	    	</thead>
	    	<tbody></tbody>
	    </table>
	    <div class="pageInfo">
				<span>共计</span><span id="totalRecords"></span><span>条数据</span>
				<input type="button" id="firstPage" class="btn" value = "首页">
				<input type="button" id="prePage"  class="btn" value="上一页">
				<span>第</span><span id="currentPage"></span><span>页/共</span>
				<span id="totalPage"></span><span>页</span>
				<input type="button" id="nextPage" class="btn" value="下一页">
		 </div>
		 <input type="button" value="关闭" id="close" class="editBtn" style="margin-left: 280px;margin-top:20px;"/>
	  </div>
   </div>
   </div>
  </body>
</html>
