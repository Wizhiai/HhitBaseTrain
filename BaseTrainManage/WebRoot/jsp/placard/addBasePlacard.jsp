<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加基地公告</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/placard/addBasePlacard.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	 <div class="list">
	 	 <div  class="modifyInfo topContent" >
	 	 		<span>公告类型：<select id="placard_type"></select></span>
				<br/><br>
	    	<span>公告标题：<input type="text" id="title" class="placardTitle"/></span><span id="msg"></span><br/>
				<span style="vertical-align: top;">公告内容：</span>
				<textarea id="content" class="placardContent"></textarea><br/>
				<input type="button"  class="editBtn" value="发布" id="add"/>
	   </div>
	  </div>
  </body>
</html>
