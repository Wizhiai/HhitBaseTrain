$(function(){
	var id=getCookie("username");
      var iden=getCookie("identity");
      $(function(){
      if(iden==3){
      	$.ajax({
   	   type:"post",
   	   url:"/BaseTrainManage/load.do",
   	   data:{"id":id},
   	   dataType:"json",
   	   success:function(result){//回调函数
   	   if(result.status==0){
   	   	var placards=result.data;
   	   	for(var i=0;i<placards.length;i++){
   	   		var placardsTitle=placards[i].placard_title;
   	   		var placardContent=placards[i].placard_content;
   	   		var li='<li class="card" href=><a>'+placardsTitle+'</a></li>';
   	   		$li=$(li);
   	   		$li.data("placardContent",placardContent);
   	   		$("#palard_list").append($li);
   	   	}
   	   }
   	   
   	   },
   	    error:function(){
   	   	alert("程序出错");
   	   }   
   	
   	});	
      
     }
     if(iden==2){
     	$.ajax({
   	   type:"post",
   	   url:"/BaseTrainManage/loadschoolPlacard.do",
   	   
   	   dataType:"json",
   	   success:function(result){//回调函数
   	   if(result.status==0){
   	   	var placards=result.data;
   	   	for(var i=0;i<=placards.length-1;i++){
   	   		var placardsTitle=placards[i].placard_title;
   	   		var placardContent=placards[i].placard_content;
   	   		var li='<li class="card" onclick="loadContent();">'+placardsTitle+'</li>';
   	   		$li=$(li);
   	   		$li.data("placardContent",placardContent);
   	   		$("#palard_list").append($li);
   	   	}
   	   }
   	   
   	   },
   	    error:function(){
   	   	alert("程序出错");
   	   }   
   	
   	});	
     }
  	if(iden==5){
  	 	$.ajax({
   	   type:"post",
   	   url:"/BaseTrainManage/loadstudentPlacard.do",
   	   data:{"id":id},
   	   dataType:"json",
   	   success:function(result){//回调函数
   	   if(result.status==0){
   	   	var placards=result.data;
   	   	for(var i=0;i<=placards.length-1;i++){
   	   		var placardsTitle=placards[i].placard_title;
   	   		var placardContent=placards[i].placard_content;
   	   		var li='<li class="card">'+placardsTitle+'</li>';
   	   		$li=$(li);
   	   		$li.data("placardContent",placardContent);
   	   		$("#palard_list").append($li);
   	   	}
   	   }
   	   
   	   },
   	    error:function(){
   	   	alert("程序出错");
   	   }   
   	
   	});	
  	}
   });
   $("#palard_list").on("click","li",function(){
	   var content=$(this).data("placardContent");
       alert(content);
	   
   });
   $("#palard_list").on("mouseover","li",function(){
	   $(this).css("color","red"); 
	    $(this).css("font-size","18px");
	   
   });
    $("#palard_list").on("mouseout","li",function(){
	   $(this).css("color","#000"); 
	   $(this).css("font-size","14px");
	   
   });
      
	
}) ;
	

