<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'question.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/page_util.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = parseInt(1);
  		var resultdata = new Object();
			$(function(){
				showAllSchoolPlacard();//显示所有学校公告
				$("#firstPage").click(function(){//首页
					firstPage(resultdata,pageSize);
				});
				$("#prePage").click(function(){//上一页
					prePage(resultdata,pageSize);
				});
				$("#nextPage").click(function(){//下一页
					nextPage(resultdata,pageSize);
				});
				$("#search").click(function(){
					var title = $("#title").val();
					if(title == ""){
						alert("标题不能为空！");
					}else{
						searchSchoolPlacardByTitle();
					}
					$("#title").val("");
				});
			});
			function showAllSchoolPlacard(){
	  		$.ajax({
	  			url:"/BaseTrainManage/schoolPlacard/searchAll.do",
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
					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].placard_title+"</td><td>"+data[i].publish_time+"</td>";
					tr += "<td><input id='placard_no' type='hidden' value ="+data[i].placard_no+"><input type='button' value='浏览  ' class='btn' onclick='gotoManageSchoolPlacard();'>";
					tr += "<input type='button' value='修改  ' class='btn' onclick='gotoManageSchoolPlacard();'><input type='button' value='删除' class='btn' onclick='deleteSchoolPlacard();'></td></tr>";
				}
				clearTableContent();
				addTableContent(tr);
			}
			function searchSchoolPlacardByTitle(){
				var placard_title = $("#title").val();
				alert(placard_title);
				$.ajax({
		  			url:"/BaseTrainManage/schoolPlacard/searchSchoolPlacardByTitle.do",
						type:"post",
						data:{"placard_title":placard_title},
						dataType:"json",
						success:function(result){
							if(result.status != 0){
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
			function gotoManageSchoolPlacard(){
	  		var placard_no = $("#placard_no").val();
				addCookie("placard_no",placard_no,2);
				window.open("manageSchoolPlacard.jsp");
	  	}
	  	
	  	function deleteSchoolPlacard(){//删除数据
	  		if(confirm("确定删除？")){
					var placard_no = $("#placard_no").val();
					$.ajax({
		  			url:"/BaseTrainManage/schoolPlacard/deleteSchoolPlacardByNo.do",
						type:"post",
						data:{"placard_no":placard_no},
						dataType:"json",
						success:function(result){
							if(result.status != 0){
								showAllSchoolPlacard();
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
	  	<div class="topContent">
	  		<h1>请输入公告标题</h1>
	  		<input type="text" id="title"/>
				<input type="button" value="查询" id="search"/>
	  	</div>
	  	<div id="placardInform">
	    	<table id="showInform" border="1" style="border:1px solid black;">
		    	<thead>
		    		<tr>
		    			<th>序号</th>
		    			<th>公告标题</th>
		    			<th>发布时间</th>
		    			<th>操作</th>
		    		</tr>
		    	</thead>
		    	<tbody></tbody>
	    	</table>
	    	<div class="pageInfo">
		    	<span>共计</span><span id="totalRecords"></span><span>条数据</span>
		    	<input type="button" id="firstPage" class="btn" value = "首页"/>
			  	<input type="button" id="prePage"  class="btn" value="上一页"/>
			  	<span>第</span><span id="currentPage"></span><span>页/共</span>
			  	<span id="totalPage"></span><span>页</span>
			  	<input type="button" id="nextPage" class="btn" value="下一页"/>
	   		</div>
   </div>
  </body>
</html>
