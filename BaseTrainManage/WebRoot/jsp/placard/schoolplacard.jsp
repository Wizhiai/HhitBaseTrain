<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'question.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->	
		<script type="text/javascript">
			$(function(){
				var placard_no = getCookie("placard_no");
				$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchByPlacardNo.do",
					type:"post",
					data:{"placard_no":placard_no},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							$("#title").val(result.data.placard_title);
							$("#publish_time").val(result.data.publish_time);
							$("#content").val(result.data.placard_content);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
				$("#close").click(function(){
					closeCurrentWindow();
				});
			});
		</script>
  </head>
  
  <body>
  	<div class="list">
  		<div class="topContent">
  			<div  class="modifyInfo" >
	    	<span>公告标题：<input type="text" id="title" readonly="readonly" class="placardTitle"/></span><br/>
	   		<span> 发布时间：<input type="text" id="publish_time" readonly="readonly" class="placardTitle"/></span><br/>
				<span style="vertical-align: top;">公告内容：</span>
				<textarea id="content" style="overflow-y:auto; " readonly="readonly" style="overflow-y:auto; "></textarea><br/>
				<input type="button" value="关闭" id="close" class="editBtn"/>
   		</div>
  		</div>
  		
		</div>
  </body>
</html>
