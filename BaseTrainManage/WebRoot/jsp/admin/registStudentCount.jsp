<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'trainregist.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = 1;
			var resultdata = new Object();
			$(function(){
				$("#studnetRegistCountInform").css("display","none");
				$("#search").click(function(){
					Count();
				});
				$("#firstPage").click(function(){//首页
				firstPage(resultdata,pageSize);
				});
				$("#prePage").click(function(){//上一页
					prePage(resultdata,pageSize);
				});
				$("#nextPage").click(function(){//下一页
					nextPage(resultdata,pageSize);
				});
			});
			function Count(){
				var countType = $("#countType option:selected").val();
				if(countType == 1){
					var tr = "<th>序号</th><th>专业</th><th>报名人数</th><th>操作</th>";
					$("#showInform thead").empty();
					$("#showInform thead").append($(tr));
					$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/registCountByMajor.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								resultdata = result.data;
								pageCalculate(resultdata,pageSize);
								firstPage(resultdata,pageSize);//显示首页
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
					});
				}else if(countType == 2){
					var tr = "<th>序号</th><th>实训单位</th><th>报名人数</th><th>操作</th>";
					$("#showInform thead").empty();
					$("#showInform thead").append($(tr));
					$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/registCountByBase.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								resultdata = result.data;
								pageCalculate(resultdata,pageSize);
								firstPage(resultdata,pageSize);//显示首页
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
					});
				}else if(countType == 3){
					var tr = "<th>序号</th><th>专业</th><th>实训单位</th><th>报名人数</th><th>操作</th>";
					$("#showInform thead").empty();
					$("#showInform thead").append($(tr));
					$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/registCountByMajorAndBase.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								resultdata = result.data;
								pageCalculate(resultdata,pageSize);
								firstPage(resultdata,pageSize);//显示首页
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
					});
				}
				$("#studnetRegistCountInform").css("display","block");
			}
			function gotoPage(pageSize,pageIndex,data){
			
				var countType = $("#countType option:selected").val();
				var tr = "";
				if(countType ==1){//按专业划分页数跳转
					for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
						tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].major+"</td><td>"+data[i].num+"</td>";
						tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
					}
				}else if(countType ==2){//按实训单位划分页数跳转
					for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
						tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].num+"</td>";
						tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
					}
				}else if(countType ==3){//按专业和实训单位划分页数跳转
					for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
						tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].major+"</td><td>"+data[i].base_name+"</td><td>"+data[i].num+"</td>";
						tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
					}
				}
				
				clearTableContent();
				addTableContent(tr);
			}
			function clearCountInfo(){
				window.open("clearRegistStudentCountInfo.jsp");
			}
		</script>
  </head>
  
  <body>
  	<div class="list">
	  	<div class="topContent">
	  		<h1>统计方式条件</h1>
	  		<select id="countType">
	  	 	<option value="1" select="selected">专业划分统计</option>
	  	 	<option value="2">实训单位划分统计</option>
	  	 	<option value="3">按专业和实训单位划分统计</option>
	  	 </select>
	   	 <input type="button" value="统计" id="search"/>
	   	</div>
	   	<div id="studnetRegistCountInform">
		    <table id="showInform" >
		    	<thead>
		    	</thead>
		    	<tbody></tbody>
		     </table>
		     <div class="pageInfo">
					<span>共计</span><span id="totalRecords"></span><span>条数据</span>
					<input type="button" id="firstPage" class="btn" value = "首页">
					<input type="button" id="prePage"  class="btn" value="上一页">
					<span>第</span><span id="currentPage"></span><span>页/共</span>
					<span id="totalPage"></span><span>页</span>
					<input type="button" id="nextPage" class="btn" value="下一页">
				 </div>
   	</div>
   </div>
  </body>
</html>
