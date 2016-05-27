<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>编辑学校公告信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			$(function(){
				showSchoolPlacard();
				$("#modify").attr("disabled","true");
				$("#modify").addClass("btn_disabled");
				$("#title").change(function(){
					$("#modify").removeAttr("disabled");
					$("#modify").removeClass("btn_disabled");
				});
				$("#publish_time").change(function(){
					$("#modify").removeAttr("disabled");
					$("#modify").removeClass("btn_disabled");
				});
				$("#content").change(function(){
					$("#modify").removeAttr("disabled");
					$("#modify").removeClass("btn_disabled");
				});
				$("#modify").click(function(){
					modifySchoolPlacard();
				});
				$("#close").click(function(){
					closeCurrentWindow();
				});
			});
			function showSchoolPlacard(){
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
			}
	  	function modifySchoolPlacard(){//修改数据
				var placard_no = getCookie("placard_no");
				var publish_author = getCookie("username");
				var placard_title = $("#title").val();
				var placard_content = $("#content").val();
				$.ajax({
		  		url:"http://localhost:8080/BaseTrainManage/schoolPlacard/updateSchoolPlacardByNo.do",
					type:"post",
					data:{"placard_no":placard_no,"placard_title":placard_title,"placard_content":placard_content,"publish_author":publish_author},
					dataType:"json",
					success:function(result){
					//	if(result.status != 0){
								alert(result.msg);
						//}
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
 	 <div  class="modifyInfo schoolPlacardInfo" >
    	<span>公告标题：<input type="text" id="title"/></span><br/>
   		<span> 发布时间：<input type="text" id="publish_time"/></span><br/>
			<span style="vertical-align: top;">公告内容：</span>
			<textarea id="content" style="overflow-y:auto; "></textarea><br/>
			<input type="button" class="editBtn" value="修改" id="modify"/>&nbsp;&nbsp;&nbsp;
			<input type="button" class="editBtn" value="关闭" id="close"/>&nbsp;&nbsp;&nbsp;
   </div>
  </div>
  </body>
</html>
