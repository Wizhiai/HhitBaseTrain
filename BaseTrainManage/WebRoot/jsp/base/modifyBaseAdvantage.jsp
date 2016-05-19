<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑基地特色信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			var base_no = getCookie("base_no");
		 	if(base_no =="" || base_no ==null){
		 		alert("页面已失效，请重新打开页面！");
		 	}else{
		 		showBaseAdvantageInfo();
	 			slide();
	 			$("#update").click(function(){
	 				updateBaseAdvantage();
	 			});
		 	}
 		});
 		function showBaseAdvantageInfo(){
 			var base_no = getCookie("base_no");
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/searchAdvantageByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
						if(result.data.base_advantage =="" || result.data.base_advantage ==null){
							$("#base_advantage").val("未填写");
						}else{
							$("#base_advantage").val(result.data.base_advantage);
						}
						
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
 		}
 		function updateBaseAdvantage(){
 			var base_no = getCookie("base_no");
 			var base_advantage = $("#base_advantage").val();
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/modifyAdvantageByBaseNo.do",
				type:"post",
				data:{"base_no":base_no,"base_advantage":base_advantage},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//修改成功
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
 	</script>
  </head>
  <body style="background:#dfe9f7;height:100%;width:100%">
    <section  class="baseAdvantage">
        <textarea class="baseEdit" id="base_advantage"></textarea>
        <input type="button" class="editBtn" id="update" value="修改">
    </section>
  </body>
</html>
