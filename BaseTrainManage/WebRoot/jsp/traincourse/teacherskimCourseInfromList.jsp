<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'placardInfromList.jsp' starting page</title>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
  </head>
  <script type="text/javascript">
  	var pageSize = 1;
  	var resultdata = new Object();
  	$(function(){
  		showBase();//显示基地名
  		showAllCourse();//页面加载时显示所有基地开课信息
			$("#search").click(function(){//给按钮查詢绑定事件
				searchCourseByBaseNo();
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
  	function showBase(){//显示基地名供查看选择
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
		function showAllCourse(){
			$.ajax({
  			url:"/BaseTrainManage/traincourse/searchAllCourse.do",
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
  	
  	function gotoPage(pageSize,pageIndex,data){//页数跳转
			var tr = "";
			for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
				tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].cname+"</td><td>"+data[i].cost+"</td><td>"+data[i].term+"个月</td><td>"+data[i].base_name+"</td>";
				tr += "<td><input id='cno' type='text' hidden value ="+data[i].cno+"/><input id='base_no' type='text' hidden value ="+data[i].base_no+"/></td></tr>";
			}
			clearTableContent();
			addTableContent(tr);
		}
		function searchCourseByBaseNo(){
			var base_no = $("#baseName").val();
			alert(base_no);
			$.ajax({
				url:"/BaseTrainManage/traincourse/searchCourseInfByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
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
  </script>
  <body>
   <div class="searchRegion">
  	<select id="baseName">
  	</select>
  	<input type="button" id="search" value="查询">
   </div>
   <div id="courseInform">
    <table id="showInform" border="1" style="border:1px solid black;">
    	<thead>
    		<tr>
    			<th>序号</th>
    			<th>课程名</th>
    			<th>花费</th>
    			<th>学习时间</th>
    			<th>开课基地</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<!--<tr>
    			<td>1</td>
    			<td>中软</td>
    			<td>无锡</td>
    			<td>2012-12-3</td>
    			<td>
    			<input id="base_no" type="text" hidden>
    			<input type="button" value="浏览" onclick="">
    			</td>
    		</tr>
    	--></tbody>
    	
    	<tfoot align="center">
    		<tr>
    			<td></td>
    			<td>
    				<input type="button" id="firstPage" value = "首页">
    				<input type="button" id="prePage" value="上一页">&nbsp;&nbsp;
    			</td>
    			<td>	
    				第<label id="currentPage"></label>页/共<label id="totalPage"></label>页
    			</td>
    			<td>
    				<input type="button" id="nextPage" value="下一页">
    			</td>
    		</tr>
    	</tfoot>
    </table>
   </div>
  </body>
</html>
