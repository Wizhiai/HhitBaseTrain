function loadTrainStudentSelfInfo(){
	 $.ajax({
 			url:"/BaseTrainManage/trainstudnet/load.do",
 			type:"post",
 			data:{"sno":stuno},
 			dataType:"json",
 			success:function(result){
 				if(result.status==1){
 					$("#stuname").val(result.data.stu_name);
 					$("#sex").val(result.data.stu_sex);
 					$("#age").val(result.data.birthday);
 					$("#major").val(result.data.major);
 					$("#class").val(result.data.stu_class);
 					$("#contact").val(result.data.phone);
 					$("#address").val(result.data.address);
 				
 				}
 			},
 			error:function(){
 				alert("程序错误");
 				
 			}
 		
 		});
	
}
function loadTrainStudentBaseName(){
	$.ajax({
 			url:"/BaseTrainManage/trainstudnet/loadBaseName.do",
 			type:"post",
 			data:{"sno":stuno},
 			dataType:"json",
 			success:function(result){
 				if(result.status==1){
 					$("#danwei").val(result.data);
 				
 				}
 			},
 			error:function(){
 				alert("程序错误");
 				
 			}
 		
 		});
	
}

