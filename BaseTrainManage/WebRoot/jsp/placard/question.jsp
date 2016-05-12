<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'question.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->	
		<script type="text/javascript">
			$(function(){
				var placard_no = getCookie("placard_no");
				$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/question/searchByPlacardNo.do",
					type:"post",
					data:{"placard_no":placard_no},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							$("#title").val(result.data.placard_title);
							$("#publish_time").val(result.data.publish_time);
							$("#base_name").val(result.data.base_name);
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
   	 公告标题：<input type="text" id="title" readonly="readonly"/><br/>
   	 发布时间：<input type="text" id="publish_time" readonly="readonly"/><br/>
   	 所属基地：<input type="text" id="base_name" readonly="readonly"/><br/>
		公告内容：<textarea id="content" readonly="readonly" style="overflow-y:auto; "></textarea>
		<input type="button" value="关闭" id="close"/>
  </body>
</html>
