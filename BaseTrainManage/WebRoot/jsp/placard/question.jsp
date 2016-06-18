<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>常见问题信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/placard/question.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	<div class="list">
	 	 <div class="modifyInfo questionInfo" >
	    	  <span>公告标题：<input type="text" id="title" readonly="readonly" class="placardTitle"/></span><br/>
		    	<span> 发布时间：<input type="text" id="publish_time" readonly="readonly" class="placardTitle"/></span><br/>
		    	<span> 所属基地：<input type="text" id="base_name" readonly="readonly" class="placardTitle"/></span><br/>
		    	<span style="vertical-align: top;">公告内容：</span><textarea id="content" readonly="readonly" style="overflow-y:auto; "></textarea><br/>
	    		<input type="button" value="关闭" id="close" class="editBtn"/>
	   </div>
  </div>
  </body>
</html>
