 function setpageSize(){

 	      pagesize=parseInt($("#pagesizes").val());
 		  page=0;
 		  currentpage=1;
 		  if(count%pagesize==0){
 		  	pagecounts=count/pagesize;
 		  }else{
 		  	pagecounts=parseInt(count/pagesize)+1;
 		  }
 		$.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			    data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    id=grades[i].id;
 			    	 	     stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	   tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    			$("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}
 			    }
 	});
 }
 function setPages(){
 		currentpage=parseInt($("#pages").val());
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			     data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	    		id=grades[i].id;
 			    	    		 stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	   tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	          $("#page a").remove();
 			    	          a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	          $a=$(a);
 			    	          $a.insertAfter("#number");
 			            }else if(1<currentpage && currentpage<pagecounts){
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if( currentpage>1 && currentpage==pagecounts){
 			               for(var i=0;i<grades.length;i++){
 			            	   id=grades[i].id;
 			            	    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 			//$("#lastpage").remove();
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	 	$("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if(currentpage==1 && currentpage==pagecounts)	{
 			        	 for(var i=0;i<grades.length;i++){
 			        		 id=grades[i].id;
 			        		  stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 			//$("#lastpage").remove();
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	 	$("#page a").remove();
 			    	     a='<a id="head" class="dianji" onclick="toHomePage()">首页</a>';
 			    	     $a=$(a);
 			    	    $a.insertAfter("#number");
 			        }
 			    	}
 			    }
 	});
 	}
 function nextPage(){
 	    currentpage=currentpage+1;
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			     data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	    		id=grades[i].id;
 			    	    		 stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	        $("#page a").remove();
 			    	        a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	        $a=$(a);
 			    	        $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	  a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	  $a=$(a);
 			    	  $a.insertAfter("#number");
 			        }
 			    	}	
 			    
 			    }
 	});
 	}
 function frontpage(){
 		currentpage=currentpage-1;
 		page=(currentpage-1)*pagesize;
 	    $.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			     data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	    		id=grades[i].id;
 			    	    		 stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	         $("#page a").remove();
 			    	         a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			    			
 			            }else if(1<currentpage<pagecounts){
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	  a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	  $a=$(a);
 			    	  $a.insertAfter("#number");
 			        }   		
 			    	}    
 			    }
 	});
 	}
 	
 function toHomePage(){
 		page=0;
 		currentpage=1;
 		$.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			    data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    count=result.status;
 			    	    if(count%pagesize==0){
 		  	                 pagecounts=count/pagesize;
 		                 }else{
 		                 pagecounts=parseInt(count/pagesize)+1;
 		                 }
 			    	    var grades=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	    		id=grades[i].id;
 			    	    		 stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	         $("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}else{
 			    		$("table tbody").html("");
 			    		$("table tfoot td b").html(0);
 			    		alert(result.msg);
 			    		
 			    		
 			    	}
 			    }
 	});
 	}
 function toEndpage(){
 	    
 		currentpage=pagecounts;
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:"/BaseTrainManage/trainstudent/searchgradebyconditionPage.do",
 			    type:"post",
 			    data:{"cno":cno,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	    		id=grades[i].id;
 			    	    		 stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	   tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage3()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			        	   for(var i=0;i<grades.length;i++){
 			        		   id=grades[i].id;
 			        		    stu=grades[i].stuno;
 			    	 	     name=grades[i].stu_name;
 			    	 	     base_name=grades[i].base_name;
 			    	 	     month1=grades[i].month;
 			    	 	     week1=grades[i].week;
 			    	 	     grade=grades[i].grade;
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	  		tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    	tr+='  <td>'+grades[i].grade+'</td>';
 			    	 			tr+='<td><img alt="修改" src="../image/update.png"><a onclick="toNextPage();"> 修改</a><img alt="删除" src="../image/delete.png"><a onclick="deletegrade();"> 删除</a></td>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(grades.length);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" onclick="toHomePage()">首页</a><a id="nextpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}
 			    }
 	});
 	}
 function toNextPage(){
	 window.location.href="JDT_modifyGradeInfo.html?id="+id+"&stuno="+stu+"&name="+name+"&base_name="+base_name+"&month="+month1+"&week="+week1+"&grade="+grade; 
 }
 
 function deletegrade(){
	 alert(id);
	 $.ajax({
		 url:"/BaseTrainManage/baseteacher/deletegrade.do",
		 type:"post",
		 data:{"id":id},
		 dataType:"json",
		 success:function(result){
			 if(result.status>0){
				 alert(result.msg);
				 toHomePage();
			 }else{
				 alert(result.msg);	 
			 }
		 },
		 error:function(){
			 
		 }
		 
	 });
 }