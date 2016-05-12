function modifySelfInfo(){
	$("#modify").click(function(){
 		var name=$("#stuname").val();
 		var phone=$("#contact").val();
 		var sex=$("#sex").val();
 		var age=$("#age").val();
 		var major=$("#major").val();
 		var stuclass=$("#class").val();
 		var address=$("#address").val();
 		$.ajax({
 			url:"http://localhost:8080/BaseTrainManage/student/modifySelfInfo.do",
 			type:"post",
 			data:{"stuno":stuno,"stu_name":name,"stu_sex":sex,"phone":phone,"birthday":age,
 		     "major":major,"stu_class":stuclass,"address":address},
 		    dataType:"json",
 		    success:function(result){
 		    	if(result.status==1){
 		    		alert("修改成功");
 		    	}
 		    },
 		    error:function(){
 		       alert("程序出错");
 		    }
 		});
 		
 		
 	
 	});
	
	
}
    
 