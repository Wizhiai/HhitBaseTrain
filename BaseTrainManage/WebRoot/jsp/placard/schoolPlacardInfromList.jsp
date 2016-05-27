<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学校公告列表</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/placard/schoolPlacardInfromList.js"></script>
  </head>
  <script type="text/javascript">
		
  </script>
  <body>
  <div class="total">
  	<!--  头部-->
	  	<header></header>
	  	<!-- 主体内容 -->
	  	<div class="main">
	  		<div class="list" id="moreInfo" style="width:100%;height:auto;">
		  		<div class="topContent">
		  		<div id="placardInform">
			  		<table id="showInform">
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
	  	</div>
	  	<div class="list" id="placardContent" style="display:none">
  		<div class="topContent">
  			<div  class="modifyInfo" >
	    	<span>公告标题：<input type="text" id="manage_title" readonly="readonly" class="placardTitle"/></span><br/>
	   		<span> 发布时间：<input type="text" id="publish_time" readonly="readonly" class="placardTitle"/></span><br/>
				<span style="vertical-align: top;">公告内容：</span>
				<textarea id="content" style="overflow-y:auto; " readonly="readonly" style="overflow-y:auto; "></textarea><br/>
				<input type="button" value="关闭" id="close" class="editBtn"/>
   		</div>
  		</div>	
		</div>
  	</div>
  </div>
  </body>
</html>
