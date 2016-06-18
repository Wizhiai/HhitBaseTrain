	var pageSize = 10;
			var resultdata = new Object();
			
				
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
					
			










function query(){
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	alert("11");
	   $.ajax({
	  			url:"/BaseTrainManage/assess/queryUser.do",
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
	   

}

function gotoPage(pageSize,pageIndex,data){//页数跳转
				var tr = "";
				for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
					tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
					tr += "<td><input id='base_no' type='hidden'value="+data[i].base_no+"><input type='button' value='浏览信息' class='btn' onclick='gotoBase();'></td><td><input id='base_no1' type='hidden'value="+data[i].base_no+"><input type='button' value='评价基地' class='btn' onclick='assessBase();'></td></tr>";
				}
				clearTableContent();
				addTableContent(tr);
			}
			
			function gotoBase(){
				var base_no = $("#base_no").val();
				addCookie("base_no",base_no,2);
				window.open("base.jsp");
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
			
			
