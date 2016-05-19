<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			$("#base_name").change(function(){
 				isBaseNameExit();
 			});
 			$("#add").click(function(){
 				addBase();
 			});
 		})
 		function addBase(){
 			var base_name = $("#base_name").val();
 			var base_address = $("#base_address").val();
 			
 			if(base_name == ""){
 				alert("基地名不能为空!");
 			}else if(base_address == ""){
 				alert("基地地址不能为空!");
 			}else if(base_name != "" & base_address != ""){
 				$.ajax({
					url:"http://localhost:8080/BaseTrainManage/base/addBase.do",
					type:"post",
					data:{"base_name":base_name,"base_address":base_address},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
 			}
 		}
 		function isBaseNameExit(){//判断基地名是否存在
 			var base_name = $("#base_name").val();
 			if(base_name == ""){
 				alert("请输入基地名！");
 			}else{
 				$.ajax({
					url:"http://localhost:8080/BaseTrainManage/base/isBaseExitByName.do",
					type:"post",
					data:{"base_name":base_name},
					dataType:"json",
					success:function(result){
						if(result.status == 0){
							$("#msg").text(result.msg).css("color","red");
							$("#add").attr("disabled");
							$("#add").addClass("btn_disabled");
						}else{
							$("#msg").text("");
							$("#add").removeAttr("disabled");
							$("#add").removeClass("btn_disabled");
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
 			}
 		}
 	</script>
 	
  </head>
  
  <body>
    <div class="list">
	  	<div class="topContent">
	  		<h1>请输入基地名</h1>
	  		<input type="text" id="base_name"/><span id="msg"></span>
	  		<h1>请输入基地地址</h1>
	  		<input type="text" id="base_address"/><br/>
	   	 <input type="button" value="添加" id="add" class="editBtn" style="margin-top: 30px;"/>
	   	</div>
    </div>
  </body>
</html>
