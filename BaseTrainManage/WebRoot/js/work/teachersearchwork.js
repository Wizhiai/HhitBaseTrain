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
 		        url:url,
 			    type:"post",
 			    data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    			$("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
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
 			    		alert(result.msg);
 			    		
 			    	}
 			    }
 	});
 }
 function setPages(){
 		currentpage=parseInt($("#pages").val());
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:url,
 			    type:"post",
 			     data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	          $("#page a").remove();
 			    	          a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	          $a=$(a);
 			    	          $a.insertAfter("#number");
 			            }else if(1<currentpage && currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
			    	 
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if( currentpage>1 && currentpage==pagecounts){
 			        	for(var i=0;i<works.length;i++){
 			        		var markedFile=works[i].markedfile;
			    	    		var stuno=works[i].stuno;
			    	    		var stuname=works[i].stu_name;
			    	    		var cname=works[i].cname;
			    	    		var title=works[i].title;
			    	    		var result=works[i].result;
			    	    		var comment=works[i].comment;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	    tr+='<td>'+works[i].stuno+'</td>';
		    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	    tr+='  <td>'+works[i].result+'</td>';
			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
			    	 	    $tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 			//$("#lastpage").remove();
 			    	 }
 			    	 $("table tfoot td b").html(works.length);
 			    	 	$("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if(currentpage==1 && currentpage==pagecounts)	{
 			        	for(var i=0;i<works.length;i++){
 			        		var markedFile=works[i].markedfile;
			    	    		var stuno=works[i].stuno;
			    	    		var stuname=works[i].stu_name;
			    	    		var cname=works[i].cname;
			    	    		var title=works[i].title;
			    	    		var result=works[i].result;
			    	    		var comment=works[i].comment;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	    tr+='<td>'+works[i].stuno+'</td>';
		    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	    tr+='  <td>'+works[i].result+'</td>';
			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
			    	 	    $tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 			//$("#lastpage").remove();
 			    	 }
 			    	 $("table tfoot td b").html(works.length);
 			    	 	$("#page a").remove();
 			    	     a='<a id="head" class="dianji" onclick="toHomePage()">首页</a>';
 			    	     $a=$(a);
 			    	    $a.insertAfter("#number");
 			        }else if(currentpage>pagecounts){
 			        	alert("页数超过总页数，请重新输入");
 			        	
 			        }
 			    	}else{
 			    		alert(result.msg);
 			    		
 			    	}
 			    }
 	});
 	}
 function nextPage(){
 	    currentpage=currentpage+1;
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:url,
 			    type:"post",
 			     data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	        $("#page a").remove();
 			    	        a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	        $a=$(a);
 			    	        $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	  a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	  $a=$(a);
 			    	  $a.insertAfter("#number");
 			        }
 			    	}else{
 			    		alert(result.msg);
 			    		
 			    	}
 			    
 			    }
 	});
 	}
 function frontpage(){
 		currentpage=currentpage-1;
 		page=(currentpage-1)*pagesize;
 	    $.ajax({
 		        url:url,
 			    type:"post",
 			     data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			    			
 			            }else if(1<currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	  a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	  $a=$(a);
 			    	  $a.insertAfter("#number");
 			        }   		
 			    	} else{
 			    		alert(result.msg);
 			    		
 			    	}   
 			    }
 	});
 	}
 	
 function toHomePage(){
 		page=0;
 		currentpage=1;
 		//alert(1);
 		$.ajax({
 		        url:url,
 			    type:"post",
 			    data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
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
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
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
 			    		alert(result.msg);
 			    		$("table tbody").html("");
 			    		$("table tfoot td b").html(0);
 			    		
 			    		
 			    	}
 			    }
 	});
 	}
 function toEndpage(){
 	    
 		currentpage=pagecounts;
 		page=(currentpage-1)*pagesize;
 		$.ajax({
 		        url:url,
 			    type:"post",
 			    data:{"stuno":stuno,"page":page,"pageSize":pagesize,"base_no":base_no},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			            	for(var i=0;i<works.length;i++){
 			            		var markedFile=works[i].markedfile;
 			    	    		var stuno=works[i].stuno;
 			    	    		var stuname=works[i].stu_name;
 			    	    		var cname=works[i].cname;
 			    	    		var title=works[i].title;
 			    	    		var result=works[i].result;
 			    	    		var comment=works[i].comment;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].stuno+'</td>';
			    	 	    tr+='  <td>'+works[i].stu_name+'</td>'; 
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].result+'</td>';
 			    	 	    tr+='<td><a href="Teacher_searchWorkDeil.html?stuno='+stuno+'&stuname='+stuname+'&cname='+cname+'&title='+title+'&result='+result+'&comment='+comment+'&markedFile='+markedFile+'">详细信息</a></td></tr>';
 			    	 	    $tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(works.length);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" onclick="toHomePage()">首页</a><a id="nextpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}else{
 			    		alert(result.msg);
 			    		
 			    	}
 			    }
 	});
 	}