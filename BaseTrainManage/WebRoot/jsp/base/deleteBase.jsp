<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
    <script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
	 	<script type="text/javascript">
	 		var pageSize = 1;
			var resultdata = new Object();
	 		$(function(){
	 			$("#baseInform").hide();
	 			$("#search").click(function(){
	 				searchBase();
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
	 		})
	 		function searchBase(){
	 			var baseName = $("#base_name").val();
	 			if(baseName == ""){
	 				alert("请输入基地名！");
	 			}else{
	 				$.ajax({
							url:"http://localhost:8080/BaseTrainManage/base/searchByName.do",
							type:"post",
							data:{"base_name":baseName},
							dataType:"json",
							success:function(result){
								if(result.status == 1){
									resultdata = result.data;
									pageCalculate(resultdata,pageSize);
									firstPage(resultdata,pageSize);//显示首页
									$("#baseInform").show();
								}else{
									alert(result.msg);
									$("#baseInform").hide();
								}
							},
							error:function(){
									alert("程序出错");
							}
					});
	 			}
	 		}
	 		function gotoPage(pageSize,pageIndex,data){//页数跳转
					var tr = "";
					for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
						tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
						tr += "<td><input id='base_no' type='hidden'value="+data[i].base_no+"><input type='button' value='删除' class='btn' onclick='deleteBase();'></td></tr>";
					}
					clearTableContent();
					addTableContent(tr);
			}
	 		function deleteBase(){
	 			if(confirm("确定删除该基地？")){
					var base_no = $("#base_no").val();
	 				alert(base_no);
	 				$.ajax({
						url:"http://localhost:8080/BaseTrainManage/base/deleteBase.do",
						type:"post",
						data:{"base_no":base_no},
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								alert("基地删除成功！");
								searchBase();
							}else{
								alert("基地删除失败！");
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
	  		<h1>请输入基地名</h1>
	  		<input type="text" id="base_name"/></span>
	   	 <input type="button" value="查询" id="search" class="editBtn"/>
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
