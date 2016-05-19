<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'placardInfromList.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
  </head>
  <script type="text/javascript">
  	var pageSize = 1;
  	var resultdata = new Object();
  	$(function(){//页面加载时从数据库中取出有哪些基地可供学生搜索其相关问题，同时从数据库中加载初一些基地常见问题
  		showBase();//显示基地名供查询
  		showAllQuestion();//显示所有基地常见问题
			$("#search").click(function(){//给按钮查詢绑定事件
				searchBaseQuestion();
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
  	function showBase(){
  		$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/base/searchName.do",
				type:"post",
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						addSelectOption(result.data);
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
  	}
  	
  	function addSelectOption(data){//添加基地名供学生进行搜索
  		var tr = "";
  		for(var i=0;i<data.length;i++){
				tr += "<option value="+data[i].base_no+">"+data[i].base_name+"</option>";
			}
			$("#searchType").append($(tr));
  	}
  	function showAllQuestion(){
  		$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/question/searchAll.do",
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
				tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].placard_title+"</td><td>"+data[i].publish_time+"</td><td>"+data[i].base_name+"</td>";
				//tr += "<td><input id='placard_no' type='text' hidden value ="+data[i].placard_no+"><a href='question.jsp' onclick ='gotoQuestion'>浏览</a></td></tr>";
				tr += "<td><input id='placard_no' type='hidden'  value ="+data[i].placard_no+"/><input type='button' value='浏览' class='btn' onclick='gotoQuestion()'></td></tr>";
			}
			clearTableContent();
			addTableContent(tr);
		}
		function gotoQuestion(){
			var placard_no = $("#placard_no").val();
			addCookie("placard_no",placard_no,2);
			window.open("question.jsp");
		}
		
  	function searchBaseQuestion(){//根据学生选中的基地名查找常见问题
  	
  		var base_no = $("#searchType option:selected").val();
  		if(base_no ==""){
					alert("请输入关键字");
			}
			$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/question/searchByBaseNo.do",
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
  <body >
  <div class="list">
  	<div class="topContent">
  		<h1>查询条件</h1>
  		<select id="searchType"></select>
  		<input type="button" id="search" value="查询" class="editBtn"/>
  	</div>
  	<div class="questionInform">
	  	<table id="showInform" >
	    	<thead>
	    		<tr>
	    			<th>序号</th>
	    			<th>公告标题</th>
	    			<th>发布时间</th>
	    			<th>所属基地</th>
	    			<th>操作</th>
	    		</tr>
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
