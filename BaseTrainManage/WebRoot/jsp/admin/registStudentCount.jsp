<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>实训学生报名统计</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/admin/registStudentCount.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	<div class="list">
	  	<div class="topContent">
	  		<h1>统计方式条件</h1>
	  		<select id="countType">
	  	 	<option value="1" select="selected">专业划分统计</option>
	  	 	<option value="2">实训单位划分统计</option>
	  	 	<option value="3">按专业和实训单位划分统计</option>
	  	 </select>
	   	 <input type="button" value="统计" id="search" class="editBtn"/>
	   	</div>
	   	<div id="studnetRegistCountInform">
		    <table id="showInform" >
		    	<thead>
		    	<tr>
		    		<th>序号</th>
	    			<th>公告标题</th>
	    			<th>发布时间</th>
	    			<th>操作</th>
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
