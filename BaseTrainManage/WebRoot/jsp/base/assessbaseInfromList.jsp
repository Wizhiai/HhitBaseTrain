<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'baseInfromation.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = 10;
			var resultdata = new Object();
			$(function(){
				showAllBase();
				$("#search").click(function(){
					search();
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
			function showAllBase(){
				$.ajax({
						url:"/BaseTrainManage/base/searchAll.do",
						type:"post",
						dataType:"json",
						beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"../assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
						success:function(result){
							resultdata = result.data;
							if(result.status == 1){
								 $("#uploadresult").html("");
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
					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
					tr += "<td><input type='button' value='浏览信息' class='btn' onclick='gotoBase("+i+");'></td><td><input id='base_no1"+i+"' type='hidden'value="+data[i].base_no+"><input type='button' value='评价基地' class='btn' onclick='assessBase("+i+");'></td></tr>";
				}
				clearTableContent();
				addTableContent(tr);
			}
			
			function gotoBase(v){

				var base_no = $("#base_no1"+v).val();
				
				addCookie("base_no",base_no,2);
				window.open("base.jsp");
			}
				function assessBase(v){
				var base_no = $("#base_no1"+v).val();
					addCookie("base_no",base_no,2);
					var userIdString = document.getElementById("userId").value;
					addCookie("userId",userIdString,2)
				
				window.open("../assess/index.jsp");
			}
			function search(){//关键字查询
				var searchKey = $("#searchkey").val();
				if(searchKey ==""){
					alert("请输入关键字");
				}
				var a=$("#searchType option:selected").val();
				alert(a+searchKey);
				if(a == 1){//基地名称搜索
					$.ajax({
						url:"/BaseTrainManage/base/searchByName.do",
						type:"post",
						data:{"base_name":searchKey},
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
				}else if(a == 2){//基地地址
				
					$.ajax({
						url:"/BaseTrainManage/base/searchByAddress.do",
						type:"post",
						data:{"base_address":searchKey},
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
				
				}else if(a == 3){//基地课程
					$.ajax({
						url:"/BaseTrainManage/base/searchByCourse.do",
						type:"post",
						data:{"cname":searchKey},
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
			}
		</script>
  </head>
  
  <body>
  	<div class="list">
  	<p class="pp" id="uploadresult"></p>
	  	<div class="topContent">
	  		<h1>查询条件</h1>
	  		<select id="searchType">
	  			<option value="1" title="base name search,you best choice!" select="selected">基地名称</option>
	  			<option value="2" >基地地址</option>
	  			<option value="3">基地课程</option>
	  			
	  		</select>
	  		<input type="text" id="searchkey">
	  		<input type="button" id="search" value="查询">
	  	</div>
	    <div id="baseInform">
	    	<table id="showInform">
	    		<thead>
	    			<tr>
	    				<th>序号</th>
	    				<th>基地名称</th>
	    				<th>基地地址</th>
	    				<th>成立时间</th>
	    				<th>操作</th>
	    				<th>评估</th>
	    				<input type="hidden" id="userId"  value=<%=request.getParameter("userId") %>>
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
