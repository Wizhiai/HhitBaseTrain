<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'placardInfromList.jsp' starting page</title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
  </head>
  <script type="text/javascript">
  	var pageSize = 10;
  	var resultdata = new Object();
  	$(function(){//页面加载时从数据库中取出有哪些基地可供学生搜索其相关问题，同时从数据库中加载初一些基地常见问题
  		$.ajax({
  			url:"/BaseTrainManage/base/searchName.do",
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
  	});
  	
  	function addSelectOption(data){
  		var tr = "";
  		for(var i=0;i<data.length;i++){
				tr += "<option value="+data[i].base_no+">"+data[i].base_name+"</option>";
			}
			$("#searchType").append($(tr));
  	}
  	
  	function searchBaseQuestion(){
  		
  	}
  </script>
  <body>
   <div class="searchRegion">
  	<select id="searchType">
  	</select>
  	<input type="button" id="search" value="查询">
   </div>
   <div id="placardInform">
    <table id="showInform" border="1" style="border:1px solid black;">
    	<thead>
    		<tr>
    			<th>序号</th>
    			<th>公告标题</th>
    			<th>发布时间</th>
    			<th>所属基地</th>
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
