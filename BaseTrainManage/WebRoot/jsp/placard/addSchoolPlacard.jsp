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
		<script type="text/javascript">
			$(function(){
				$("#add").click(function(){
					var placard_title = $("#title").val();
					var placard_content = $("#content").val();
					if(placard_title =="" || placard_content == ""){
						alert("公告标题或公告内容不能为空！");
					}else if(placard_title !="" && placard_content != ""){
						addSchoolPlacard();
					}
				});
				$("#title").change(function(){
					isSchoolTitleExit();
				});
			});
			function isSchoolTitleExit(){
				var placard_title = $("#title").val();
				$.ajax({
		  			url:"/BaseTrainManage/schoolPlacard/findSchoolPlacardByTitle.do",
						type:"post",
						data:{"placard_title":placard_title},
						dataType:"json",
						success:function(result){
							if(result.status == 0){//有相同标题的学校公告
								$("#msg").text(result.msg).css("color","red");
								$("#add").attr("disabled","true");
								$("#add").addClass("btn_disabled");
							}else{
								$("#msg").text("").hide();
								$("#add").removeAttr("disabled");
								$("#add").removeClass("btn_disabled");
							}
						},
						error:function(){
								alert("程序出错");
						}
				});
			}
			function addSchoolPlacard(){
				var placard_title = $("#title").val();
				var placard_content = $("#content").val();
				var publish_author = getCookie("username");
				$.ajax({
		  			url:"/BaseTrainManage/schoolPlacard/addPlacard.do",
						type:"post",
						data:{"placard_title":placard_title,"placard_content":placard_content,"publish_author":publish_author},
						dataType:"json",
						success:function(result){
							alert(result.msg);
						},
						error:function(){
								alert("程序出错");
						}
				});
			}
		</script>
  </head>
  
  <body>
  	<div class="list">
   		公告标题：<input type="text" id="title"/><span id="msg"></span><br/>
			公告内容：<textarea id="content"></textarea><br/>
			<input type="button" value="发布" id="add"/>
		</div>
  </body>
</html>
