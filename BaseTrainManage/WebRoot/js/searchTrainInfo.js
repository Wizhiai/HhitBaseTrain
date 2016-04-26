function searchTrainInfo(){
	$("#query").click(function(){
 	$("#info tbody").html("");
 	
 	var st=$("#xuehao").val();
 	st='%'+st+'%';
 		$.ajax({
 		url:"http://localhost:8080/BaseTrainManage/trainstudent/loadTrainInfo.do",
 		type:"post",
 		data:{"stno":st,"stuno":stuno},
 		dataType:"json",
 		success:function(result){
 		if(result.status==0){
 			var infos=result.data;
 		    for(var i=0;i<infos.length;i++){
 		     var tr='<tr align="center" bgcolor="#FFFFFF" height="22" class="#">' ;   
	      tr+='<td>'+infos[i].stuno+'</td>';
	      tr+='<td>'+infos[i].stu_name+'</td>';
	      tr+='<td>'+infos[i].stu_class+'</td>';
	      tr+='<td>'+infos[i].major+'</td>';
	      tr+='<td>'+infos[i].base_name+'</td>';
	      tr+='<td>'+infos[i].base_class+'</td>';
	      tr+='<td>'+infos[i].cno+'</td>';
	      tr+='<td>'+infos[i].cname+'</td>';
	      tr+='<td>'+infos[i].term+'</td>';
	      tr+='<td>'+infos[i].t_name+'</td></tr>';
	      $tr=$(tr);
	      $("#info tbody").append($tr);    
 		 }
 		    $("#info tfoot td b").html(infos.length);
 		}
 		},
 		error:function(){
 		   alert("程序错误");
 		}		
 	});
 });
	
	
	
}

