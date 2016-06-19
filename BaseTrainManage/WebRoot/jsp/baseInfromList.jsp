<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'baseInfromation.jsp' starting page</title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/page_util.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
		<script type="text/javascript">
			var pageSize = 1;
			var resultdata = new Object();
			$(function(){
				$.ajax({
						url:"/BaseTrainManage/base/searchAll.do",
						type:"post",
						dataType:"json",
						success:function(result){
							resultdata = result.data;
							if(result.status == 1){
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
			
			function gotoPage(pageSize,pageIndex,data){//页数跳转
				var tr = "";
				for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
					tr += "<td><input id='base_no' type='text' hidden><input type='button' value='浏览' onclick=''></td></tr>";
				}
				clearTableContent();
				addTableContent(tr);
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
  	<div class="searchRegion">
  		<select id="searchType">
  			<option value="1" title="base name search,you best choice!" select="selected">基地名称</option>
  			<option value="2" >基地地址</option>
  			<option value="3">基地课程</option>
  		</select>
  		<input type="text" id="searchkey">
  		<input type="button" id="search" value="查询">
  	</div>
    <div id="baseInforma">
    	<table id="showInform" border="1" style="border:1px solid black;">
    		<thead>
    			<tr>
    				<th>序号</th>
    				<th>基地名称</th>
    				<th>基地地址</th>
    				<th>成立时间</th>
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
