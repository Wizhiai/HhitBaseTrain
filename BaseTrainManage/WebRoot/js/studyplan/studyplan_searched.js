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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			    data:{"base_no":base_no,"page":page,"pageSize":pagesize},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var studyplans=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    			$("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	       var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	        tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	       tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	       tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	      tr+='<img  src="../image/look.png"/>';
 			    	 	       tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			     data:{"base_no":base_no,"page":page,"pageSize":pagesize},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var studyplans=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    	          $("#page a").remove();
 			    	          a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	          $a=$(a);
 			    	          $a.insertAfter("#number");
 			            }else if(1<currentpage && currentpage<pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if( currentpage>1 && currentpage==pagecounts){
			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			     data:{"base_no":base_no,"page":page,"pageSize":pagesize},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var studyplans=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    	        $("#page a").remove();
 			    	        a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	        $a=$(a);
 			    	        $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			     data:{"base_no":base_no,"page":page,"pageSize":pagesize},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var studyplans=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    	         $("#page a").remove();
 			    	         a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			    			
 			            }else if(1<currentpage<pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			    data:{"base_no":base_no,"page":page,"pageSize":pagesize},
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
 			    	    var studyplans=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    	         $("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
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
 		        url:"http://localhost:8080/BaseTrainManage/teaching/showstudyplan.do",
 			    type:"post",
 			    data:{"base_no":base_no,"page":page,"pageSize":pagesize},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var studyplans=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(studyplans.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			    	    	for(var i=0;i<studyplans.length;i++){
 			    	    		studyplan=studyplans[i].studyplan;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+studyplans[i].cno+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].cname+'</td>';
 			    	 	    tr+='  <td>'+studyplans[i].term+'</td>';
 			    	 	  tr+='<img  src="../image/look.png"/>';
 			    	 	   tr+='<td><a onclick="download();">查看学习计划</a>&nbsp;</td></tr>';
 			    	 			$tr=$(tr);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(studyplans.length);
 			    	 $("#page a").remove();
 			    	 a='<a id="head" onclick="toHomePage()">首页</a><a id="nextpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	 $a=$(a);
 			    	 $a.insertAfter("#number");
 			        }		
 			    	}
 			    }
 	});
 	}