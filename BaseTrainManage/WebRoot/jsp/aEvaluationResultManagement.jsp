<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'baseInfromation.jsp' starting page</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/page_util.js"></script>
		<script type="text/javascript" src="../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = 9;
			
			var resultdata=new Array()
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
			var cha =0;
				var resultdataTemp=new Array();
			  $.ajax({
	  			url:"/BaseTrainManage/assess/findAllExpert.do",
					type:"post",
					dataType:"json",
				beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
				
					 $("#uploadresult").html("");
						resultdata = result.data;
							
							if(result.status == 1){
							for(var i = 0; i <  resultdata.length; i++){
						
				
							switch(resultdata[i].expertType)
							{

								case "7":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "2":  	
								{ resultdata[i].expertType="学校教师";								
 									 break;
 									 }
                                case "6": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
 									 case "专家":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "学校教师":  	
								{ resultdata[i].expertType="学校教师";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
								default:
								{	
									resultdata.splice(i,1);
									i=0;
								
									break;	}
							
							
								}				
										
							
								}				
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
	resultdata = data;
				for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			

					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].username+"</td><td>"+
					data[i].expertType+"</td><td><input id='base_no"+i+"' type='hidden'value="+data[i].username+"><input type='button' value='删除' class='btn' onclick='deletetExpert("+i+");'></td><td><input type='button' value='添加到专家委员会' class='btn' onclick='insertAssessExpert("+i+");'></td></tr>";
					
				}
			
				clearTableContent();
				addTableContent(tr);
				
			}
				function insertAssessExpert(v){
				
				var userName =resultdata[v].username;
			
					switch(resultdata[v].expertType){
					 case "专家":
					{ resultdata[v].expertType="7";
  						break;}
					case "学校教师":  	
					{ resultdata[v].expertType="2";								
 						 break;	 }
                   case "实训完成学生": 	
                     {   resultdata[v].expertType="6";								
 					 break; }
 					 default:
 					 break;
 					 
 				
					
					
					}
					
						var expertType = resultdata[v].expertType;

				
	  	 $.ajax({
	  			url:"/BaseTrainManage/assess/inserttoAssessExpert.do",
					type:"post",
					data:{
    	 		"userName":userName,
    	 		"experType":expertType,
    	
     },
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							showAllBase();
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
				
				
				
				
			}
			function deletetExpert(v){
				
				var userName =resultdata[v].username;
	  	 $.ajax({
	  			url:"/BaseTrainManage/assess/deleteExpertByUsernName.do",
					type:"post",
					data:{
    	 		"userName":userName,
    	
     },
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							showAllBase();
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
				
				
				
				
			}
				function assessBase(){
				var base_no = $("#base_no").val();
					addCookie("base_no",base_no,2);
					var userIdString = document.getElementById("userId").value;
					addCookie("userId",userIdString,2)
				
				window.open("../aUserManage.jsp");
			}
			function search(){//关键字查询
				var searchKey = $("#searchkey").val();
				if(searchKey ==""){
					alert("请输入关键字");
				}else{
					var a=$("#searchType option:selected").val();
			
				if(a == 1){//基地名称搜索
					$.ajax({
						url:"/BaseTrainManage/assess/findByName.do",
						type:"post",
						data:{"no":searchKey},
						dataType:"json",
						beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
				if(result.status == 1){
					 $("#uploadresult").html("");
								resultdata = result.data;
							for(var i = 0; i <  resultdata.length; i++){
							switch(resultdata[i].identity)
							{

								case "7":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "2":  	
								{ resultdata[i].expertType="学校教师";								
 									 break;
 									 }
                                case "6": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
 									 case "专家":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "学校教师":  	
								{ resultdata[i].expertType="学校教师";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
								default:
								{	
									resultdata.splice(i,1);
									i=0;
								
									break;	}
							
							
								}							
							
								}
							
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
				var bool = true;
			
				switch(searchKey){
				
				
								 
								case "学校教师":  	
								{searchKey = "2";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   searchKey = "6";								
 									 break;
 									 }
								case "专家":
								{	
									searchKey = "7";
								
									break;	}
								default:{
								alert("请输入正确的类别，例如:专家,学校教师,实训完成学生");
								bool = false;
								break;
								}
			
				}
				
				if(bool){
					
					$.ajax({
						url:"/BaseTrainManage/assess/findByType.do",
						type:"post",
						data:{"type":searchKey},
						dataType:"json",
						beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
				if(result.status == 1){
					 $("#uploadresult").html("");
								resultdata = result.data;
								for(var i = 0; i <  resultdata.length; i++){
						
				
							switch(resultdata[i].identity)
							{

								case "7":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "2":  	
								{ resultdata[i].expertType="学校教师";								
 									 break;
 									 }
                                case "6": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
 									 case "专家":
								 { resultdata[i].expertType="专家";
  									break;
  									}
								case "学校教师":  	
								{ resultdata[i].identity="学校教师";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   resultdata[i].expertType="实训完成学生";								
 									 break;
 									 }
								default:
								{	
									resultdata.splice(i,1);
									i=0;
								
									break;	}
							
							
								}				
										
							
								}
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
				}
			
			}
		</script>
  </head>
  
  <body>
  	<div class="list">
	  	<div class="topContent">
	  	<p class="pp" id="uploadresult"></p>
	  		<h1>查询条件</h1>
	  		<select id="searchType">
	  			<option value="1" title="base name search,you best choice!" select="selected">ID</option>
	  			<option value="2" >类别</option>
	  			
	  			
	  		</select>
	  		<input type="text" id="searchkey">
	  		<input type="button" id="search" value="查询">
	  	</div>
	    <div id="baseInform">
	    	<table id="showInform">
	    		<thead>
	    			<tr>
	    				<th>序号</th>
	    				<th>ID</th>
	    				<th>类别</th>
	    	
	    				<th colspan="2">操作</th>
	
	    				<input type="hidden" id="userId"  value=<%=request.getParameter("userId")%>>
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
