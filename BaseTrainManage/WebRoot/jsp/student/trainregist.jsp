<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'trainregist.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			$(function(){
				showBase();
				$("#baseName").change(function(){
					clearCourseOption()
					showCourse();
				});
				$("#regist").click(function(){
					regist();
				});
				
			});
			function showBase(){
				$.ajax({
	  			url:"/BaseTrainManage/base/searchName.do",
					type:"post",
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							addBaseOption(result.data);
							
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}
			function addBaseOption(data){//将基地名添加至选项中
				var tr = "";
	  		for(var i=0;i<data.length;i++){
					tr += "<option value="+data[i].base_no+">"+data[i].base_name+"</option>";
				}
				$("#baseName").append($(tr));
			}
			function clearCourseOption(){//将课程名清空
				$("#courseName").empty();
			}
			function addCourseOption(data){//将课程名添加至选项中
				var tr = "";
	  		for(var i=0;i<data.length;i++){
					tr += "<option value="+data[i].cno+">"+data[i].cname+"</option>";
				}
				$("#courseName").append($(tr));
			}
			function showCourse(){//显示课程名
				var base_no = $("#baseName option:selected").val();//获取基地号
				$.ajax({
	  			url:"/BaseTrainManage/traincourse/searchCourseInfByBaseNo.do",
					type:"post",
					data:{"base_no":base_no},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							addCourseOption(result.data);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}
			function regist(){//报名
				var cno = $("#courseName option:selected").val();
				var base_no = $("#baseName option:selected").val();
				var stuno = getCookie("username");
				
				if(base_no == "empty"){
					alert("请选择报名基地！");
				}else if(cno == "" || cno == undefined){
					alert("请选择课程！");
				}else{
					$.ajax({
		  			url:"/BaseTrainManage/student/trainregist.do",
						type:"post",
						data:{"base_no":base_no,"cno":cno,"stuno":stuno},
						dataType:"json",
						success:function(result){
							if(result.status == 0){//报名失败
								alert(result.msg);
							}else{//报名成功
								alert(result.msg);
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
  	<div class="searchRegion">
  	 <select id="baseName">
  	 	<option value="empty" select="selected"></option>
  	 </select><br/>
     <select id="courseName"></select><br/>
   	 <input type="button" value="报名" id="regist"/>
   	</div>
  </body>
</html>
