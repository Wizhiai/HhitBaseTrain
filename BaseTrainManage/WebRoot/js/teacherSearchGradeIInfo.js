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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	   var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	  var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	   var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
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
 			    	 	   var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	     	var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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
 		        url:"/BaseTrainManage/teacher/searchgrade.do",
 			    type:"post",
 			    data:{"stuclass":stuclass,"major":major,"page":page,"pageSize":pagesize,"month":month,"stuno":stuno,"week":week},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var grades=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<grades.length;i++){
 			    	 	   var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(grades.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			        	   for(var i=0;i<grades.length;i++){
 			    	 	   		var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+grades[i].stuno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].stu_class+'</td>';
 			    	 	    tr+='  <td>'+grades[i].major+'</td>';
 			    	 	    tr+='  <td>'+grades[i].base_name+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cno+'</td>';
 			    	 	    tr+='  <td>'+grades[i].cname+'</td>';
 			    	 	    tr+='  <td>'+grades[i].month+'</td>';
 			    	 	    tr+='  <td>'+grades[i].week+'</td>';
 			    	 	    tr+='  <td>'+grades[i].grade+'</td>';
 			    	 	    tr+='  <td><a href="">查看卷面</a></td></tr>';
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