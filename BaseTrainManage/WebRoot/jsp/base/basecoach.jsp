<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base.jsp' starting page</title>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->	
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			showBaseBuildInfo();
 		});
 		function showBaseBuildInfo(){
 			var base_no = getCookie("base_no");
 			$.ajax({
				url:"/BaseTrainManage/base/searchCoachByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
						alert(result.data.school_teacher);
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
  
  <body>
    <div id="basicBuildInfo">
    	<table border="1">
    		<tr>
    			<td>基地性质:</td>
    			<td><input id="baseproperty" type="text"/></td>
    		</tr>
    		<tr>
    			<td>基地管理:</td>
    			<td><div id="basemanage"></div></td>
    		</tr>
    		<tr>
    			<td>基地资格:</td>
    			<td><input id="basequalification" type="text"/></td>
    		</tr>
    		<tr>
    			<td>单位人数:</td>
    			<td><textarea id="basepersonnum"/></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
