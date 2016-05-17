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
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			    data:{"page":page,"pageSize":pagesize,"stuno":stuno},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
 			    	 	    $tr=$(tr);
 			    	 	  $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    			$("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>";
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	   $tr.data("finishedfile",finishedfile);
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
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			     data:{"page":page,"pageSize":pagesize,"stuno":stuno},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==1 && currentpage<pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td><a href="">'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	          $("#page a").remove();
 			    	          a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	          $a=$(a);
 			    	          $a.insertAfter("#number");
 			            }else if(1<currentpage && currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname; 
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 			$("table tbody").append($tr);
 			    	 }
 			    	 $("table tfoot td b").html(pagesize);
 			    	  $("#page a").remove();
 			    	   a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	   $a=$(a);
 			    	   $a.insertAfter("#number");
 			        }else if( currentpage>1 && currentpage==pagecounts){
 			        	for(var i=0;i<works.length;i++){
 			        		file=works[i].file;
			    	    		wid=works[i].wid;
			    	    		var content=works[i].content;
			    	    		var title=works[i].title;
			    	    		var cno=works[i].cno;
			    	    		var cname=works[i].cname;
			    	    		var finishedfile=works[i].finishedfile;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
			    	 	   tr+='  <td>'+works[i].endDate+'</td>';
 			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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
 			        		file=works[i].file;
			    	    		wid=works[i].wid;
			    	    		var content=works[i].content;
			    	    		var title=works[i].title;
			    	    		var cno=works[i].cno;
			    	    		var cname=works[i].cname;
			    	    		var finishedfile=works[i].finishedfile;
			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
			    	 	    tr+='<td>'+works[i].cno+'</td>';
			    	 	    tr+='  <td>'+works[i].cname+'</td>';
			    	 	    tr+='  <td>'+works[i].title+'</td>';
			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
			    	 	   tr+='  <td>'+works[i].endDate+'</td>';
 			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			     data:{"page":page,"pageSize":pagesize,"stuno":stuno},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==pagecounts){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	        $("#page a").remove();
 			    	        a='<a id="head" onclick="toHomePage()">首页</a><a id="lastpage" onclick="frontpage()">上一页</a><a id="end" class="dianji" onclick="toEndpage()">尾页</a>';
 			    	        $a=$(a);
 			    	        $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			     data:{"page":page,"pageSize":pagesize,"stuno":stuno},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    	    if(currentpage==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
 			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a='<a id="head" class="dianji" onclick="toHomePage()">首页</a><a id="nextpage" onclick="nextPage()">下一页</a><a id="end" onclick="toEndpage()">尾页</a>';
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			    			
 			            }else if(1<currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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
 		alert(1);
 		$.ajax({
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			    data:{"page":page,"pageSize":pagesize,"stuno":stuno},
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
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	    $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         $("#page a").remove();
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else if(currentpage<pagecounts){
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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
 		        url:"http://localhost:8080/BaseTrainManage/work/showuploadwork.do",
 			    type:"post",
 			    data:{"page":page,"pageSize":pagesize,"stuno":stuno},
 			    dataType:"json",
 			    success:function(result){
 			    	if(result.status!=0){
 			    	    $("table tbody").html("");
 			    	    var works=result.data;
 			    		$("#page #head").addClass("dianji");
 			    	    if(pagecounts==1){
 			    	    	for(var i=0;i<works.length;i++){
 			    	    		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
 			    	 	     $("table tbody").append($tr);
 			    	      }
 			    	        $("table tfoot td b").html(works.length);
 			    	         a="<a id='head' class='dianji' onclick='toHomePage()'>首页</a>"
 			    	         $a=$(a);
 			    	         $a.insertAfter("#number");
 			            }else{
 			            	for(var i=0;i<works.length;i++){
 			            		file=works[i].file;
 			    	    		wid=works[i].wid;
 			    	    		var content=works[i].content;
 			    	    		var title=works[i].title;
 			    	    		var cno=works[i].cno;
 			    	    		var cname=works[i].cname;
 			    	    		var finishedfile=works[i].finishedfile;
 			    	 	    var tr='<tr align="center" bgcolor="#FFFFFF" height="22">';
 			    	 	    tr+='<td>'+works[i].cno+'</td>';
 			    	 	    tr+='  <td>'+works[i].cname+'</td>';
 			    	 	    tr+='  <td>'+works[i].title+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadDate+'</td>';
 			    	 	    tr+='  <td>'+works[i].uploadNo+'</td>';
 			    	 	  tr+='  <td>'+works[i].endDate+'</td>';
			    	 	   tr+='<td><a >重交作业</a>&nbsp;</td></tr>';
			    	 	    $tr=$(tr);
			    	 	   $tr.data("wid",wid);
			    	 	    $tr.data("cno",cno);
			    	 	   $tr.data("cname",cname);
			    	 	   $tr.data("file",file);
			    	 	  $tr.data("content",content);
			    	 	   $tr.data("title",title);
			    	 	  $tr.data("finishedfile",finishedfile);
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