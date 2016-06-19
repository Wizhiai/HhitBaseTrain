function loadCno(){
	$.ajax({
 		     url:"/BaseTrainManage/trainstudnet/load.do",	
 		     type:"post",
 		     data:{"sno":userId},
 		     dataType:"json",
 		     success:function(result){
 		     	if(result.status==1){
 		     	 	var student=result.data;
 		     	 	$("#sno").val(userId);
 		     	 	$("#cno").val(student.cno); 	
 		     	
 		     	}else{
 		     		alert(result.msg);
 		     	
 		     	}
 		     },
 		     error:function(){
 		     	alert("程序出错");
 		     }
 		});
}

