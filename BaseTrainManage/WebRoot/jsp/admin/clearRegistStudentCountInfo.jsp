<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'trainregist.jsp' starting page</title>
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
			  	url:"/BaseTrainManage/student/registCountInfo.do",
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
   <input type="button" value="关闭" id="close"/>
  </body>
</html>
