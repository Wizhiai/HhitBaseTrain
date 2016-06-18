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
 			    data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	   
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    			$("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
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
 		        url:url,
 			    type:"post",
 			     data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    var works=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	          $("#page a").remove();
 			    	          a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	          $a=$(a);
 			    	          $a.insertAfter("#number");
 			            }else if(1<currentpage && currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if( currentpage>1 && currentpage==pagecounts){
 			        	for(var i=0;i<works.length;i++){
 			        		var title=works[i].title;
	 			    	    	var stuno=works[i].stuno;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	      tr+='<td>'+works[i].stuno+'</td>';
			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	   tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
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
 			        		var title=works[i].title;
	 			    	    	var stuno=works[i].stuno;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	      tr+='<td>'+works[i].stuno+'</td>';
			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	   tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
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
 		        url:url,
 			    type:"post",
 			     data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	        $("#page a").remove();
 			    	        a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	        $a=$(a);
 			    	        $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
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
 		        url:url,
 			    type:"post",
 			     data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    var works=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			    			
 			            }else if(1<currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
 			    	 	    $tr=$(tr);
 			    	 	  $tr.data("title",title);
 			    	 	  $tr.data("stuno",stuno);
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
 		//alert(1);
 		$.ajax({
 		        url:url,
 			    type:"post",
 			    data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    count=result.status;
 			    	    if(count%pagesize==0){
 		  	                 pagecounts=count/pagesize;
 		                 }else{
 		                 pagecounts=parseInt(count/pagesize)+1;
 		                 }
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='<td><a href="javascript:void(0);" onclick="tixing();">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
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
 		        url:url,
 			    type:"post",
 			    data:{"base_no":base_no,"base_class":base_class,"page":page,"pageSize":pagesize,"title":title},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    		$("table thead").html("");
 			    	    $("table tbody").html("");
 			    	    var th="<tr align='center' bgcolor='#E7FDFE' height='30' class='titleInfo'>";
                            th+=" <th width='10%'><b>学号</b></th>";
                            th+="<th width='10%'><b>姓名</b></th>"; 
	                        th+="<th width='10%'><b>课程号</b></th>" ;
	                        th+="<th width='10%'><b>课程名</b></th>";
	                        th+=" <th width='15%'><b>作业标题</b></th>";  
	                        th+=" <th width='15%'><b><a href='javascript:void(0);'>提醒</a></b></th></tr>";
 			    	   $("table thead").html($(th));
 			    	    var works=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			            	for(var i=0;i<works.length;i++){
 			            		var title=works[i].title;
 	 			    	    	var stuno=works[i].stuno;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	      tr+='<td>'+works[i].stuno+'</td>';
 			    	 	        tr+='<td>'+works[i].stu_name+'</td>';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	  tr+='  <td><a href="javascript:void(0);">提醒</a></td>';
			    	 	    $tr=$(tr);
			    	 	  $tr.data("title",title);
			    	 	  $tr.data("stuno",stuno);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(works.length);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" onclick="toHomePage()">首页</a><a id="nextpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}
 			    }
 	});
 	}
 
