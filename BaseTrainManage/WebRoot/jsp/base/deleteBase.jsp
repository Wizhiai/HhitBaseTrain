<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除基地</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
    <script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/deleteBase.js"></script>
	 	<script type="text/javascript">
	 		
	 	</script>
 	
  </head>
  
  <body>
    <div class="list">
	  	<div class="topContent">
	  		<h1>请输入基地名</h1>
	  		<input type="text" id="base_name"/></span>
	   	 <input type="button" value="查询" id="search" class="editBtn"/>
	   	</div>
	   	<div id="baseInform">
		    <table id="showInform">
		    	<thead>
		    		<tr>
	    				<th>序号</th>
	    				<th>基地名称</th>
	    				<th>基地地址</th>
	    				<th>成立时间</th>
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
