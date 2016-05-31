<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学校教师浏览基地开课信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/traincourse/teacherskimCourseInfromList.js"></script>
  </head>
  <script type="text/javascript">
  	
  </script>
  <body>
  	<div class="list">
  		 <div class="topContent">
		   	<h1>查询条件</h1>
		  	<select id="baseName"></select>
  			<input type="button" id="search" value="查询" class="editBtn">
  	  </div>
	   <div id="courseInform">
	   	<table id="showInform">
    		<thead>
	    		<tr>
	    			<th>序号</th>
	    			<th>课程名</th>
	    			<th>花费</th>
	    			<th>学习时间</th>
	    			<th>开课基地</th>
	    		</tr>
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
	   </div>
   	</div>
  </body>
</html>
