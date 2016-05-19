<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'trainregist.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = 1;
			var resultdata = new Object();
			$(function(){
				showCountInfo();
				$("#firstPage").click(function(){//首页
				firstPage(resultdata,pageSize);
				});
				$("#prePage").click(function(){//上一页
					prePage(resultdata,pageSize);
				});
				$("#nextPage").click(function(){//下一页
					nextPage(resultdata,pageSize);
				});
				$("#close").click(function(){
					closeCurrentWindow();
				});
			});
			function showCountInfo(){
				$.ajax({
			  	url:"http://localhost:8080/BaseTrainManage/student/registCountInfo.do",
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
			function gotoPage(pageSize,pageIndex,data){
				var tr = "";
				for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
				
					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].stu_name+"</td><td>"+data[i].stu_class+"</td>";
					tr += "<td>"+data[i].major+"</td><td>"+data[i].base_name+"</td><td>"+data[i].cname+"</td></tr>";
				}
				clearTableContent();
				addTableContent(tr);
			}
		</script>
  </head>
  
  <body>
  	<div class="list">
  	<div class="topContent">
	   	<div id="studnetRegistCountInform">
	    <table id="showInform" border="1" style="border:1px solid black;">
	    	<thead>
	    		<th>序号</th>
	    		<th>学生姓名</th>
	    		<th>班级</th>
	    		<th>专业</th>
	    		<th>基地名</th>
	    		<th>课程名</th>
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
		 <input type="button" value="关闭" id="close" class="editBtn" style="margin-left: 280px;margin-top:20px;"/>
	  </div>
   </div>
   </div>
  </body>
</html>
