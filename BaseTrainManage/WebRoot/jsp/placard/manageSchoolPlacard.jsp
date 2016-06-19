<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'question.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			$(function(){
				showSchoolPlacard();
				$("#title").change(function(){
					$("#modify").removeAttr("disabled");
				});
				$("#publish_time").change(function(){
					$("#modify").removeAttr("disabled");
				});
				$("#content").change(function(){
					$("#modify").removeAttr("disabled");
				});
				$("#close").click(function(){
					closeCurrentWindow();
				});
			});
			function showSchoolPlacard(){
				var placard_no = getCookie("placard_no");
				$.ajax({
	  			url:"/BaseTrainManage/schoolPlacard/searchByPlacardNo.do",
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
			}
	  	function modifySchoolPlacard(){//修改数据
				var placard_no = getCookie("placard_no");
				$.ajax({
		  		url:"/BaseTrainManage/schoolPlacard/updateSchoolPlacardByNo.do",
					type:"post",
					data:{"placard_no":placard_no,"placard_title":placard_title,"placard_content":placard_content,"publish_author":publish_author},
					dataType:"json",
					success:function(result){
						if(result.status != 0){
								alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
	  	}
		</script>
  </head>
  
  <body>
   	 公告标题：<input type="text" id="title"/><br/>
   	 发布时间：<input type="text" id="publish_time"/><br/>
		公告内容：<textarea id="content" style="overflow-y:auto; "></textarea><br/>
		<input type="button" value="修改" id="modify" disabled="true"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="关闭" id="close"/>&nbsp;&nbsp;&nbsp;
  </body>
</html>
