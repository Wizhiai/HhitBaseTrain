 $(function(){
 	var url=window.location;
     stuno=getUrlParam(url,"stuno");
     cno=getUrlParam(url,"cno");
     $("#stuno").val(stuno);
     $("#cno").val(cno);
     $("#agrade").click(function(){
     	month=$("#month option:selected").text();
     	$.ajax({
     		url:"http://localhost:8080/BaseTrainManage/trainstudent/searchgradebyno.do",
     		type:"post",
     		data:{"stuno":stuno,"week":week,"month":month},
     		dataType:"json",
     		success:function(result){
     			if(result.status!=0){
     				var grades=result.data;
     				var count=grades.length;
     				var sum=0;
     				for(var i=0;i<count;i++){
     					sum+=grades[i].grade;
     				}
     				var avg=sum/count;
     				
     				$("#avgresult").val(avg.toFixed(2));
     			}else{
     				alert("对不起，该学生无这个月的成绩!");
     			}
     		},
     		error:function(){
     			alert("程序错误");
     		}
     	
     	});
     });
      $("#mgrade").click(function(){
     	month=$("#month option:selected").text();
     	$.ajax({
     		url:"http://localhost:8080/BaseTrainManage/trainstudent/searchgradebyno.do",
     		type:"post",
     		data:{"stuno":stuno,"week":week,"month":month},
     		dataType:"json",
     		success:function(result){
     			if(result.status!=0){
     				var grades=result.data;
     				var count=grades.length;
     				var max=0;
     				for(var i=0;i<count;i++){
     					if(grades[i].grade>max){
     						max=grades[i].grade;
     					}
     				}
     				$("#maxresult").val(max);
     			}else{
     				alert("对不起，该学生无这个月的成绩!");
     			}
     		},
     		error:function(){
     			alert("程序错误");
     		}
     	
     	});
     });
      $("#mingrade").click(function(){
     	month=$("#month option:selected").text();
     	$.ajax({
     		url:"http://localhost:8080/BaseTrainManage/trainstudent/searchgradebyno.do",
     		type:"post",
     		data:{"stuno":stuno,"week":week,"month":month},
     		dataType:"json",
     		success:function(result){
     			if(result.status!=0){
     				var grades=result.data;
     				var count=grades.length;
     				var min;
     				min=grades[0].grade;
     				for(var i=0;i<count;i++){
     				    
     					if(grades[i].grade<min){
     						min=grades[i].grade;
     					}
     				}
     				$("#minresult").val(min);
     			}else{
     				alert("对不起，该学生无这个月的成绩!");
     			}
     		},
     		error:function(){
     			alert("程序错误");
     		}
     	
     	});
     });
      $("#passgrade").click(function(){
     	month=$("#month option:selected").text();
     	$.ajax({
     		url:"http://localhost:8080/BaseTrainManage/trainstudent/searchgradebyno.do",
     		type:"post",
     		data:{"stuno":stuno,"week":week,"month":month},
     		dataType:"json",
     		success:function(result){
     			if(result.status!=0){
     				var grades=result.data;
     				var count=grades.length;
     				var p=0
     				for(var i=0;i<count;i++){
     				    
     					if(grades[i].grade>=60){
     					p++;
     					}
     				}
     				var pass=p/count;
     				$("#passresult").val(pass.toFixed(2));
     			}else{
     				alert("对不起，该学生无这个月的成绩!");
     			}
     		},
     		error:function(){
     			alert("程序错误");
     		}
     	
     	});
     });
    
     
 });
 function getUrlParam(url,name){
        var pattern = new RegExp("[?&]" + name +"\=([^&]+)","g");
        var matcher = pattern.exec(url);
        var items = null;
        if(matcher != null){
            try{
                items = decodeURIComponent(decodeURIComponent(matcher[1]));    
            }catch(e){
                try{
                    items = decodeURIComponent(matcher[1]);
                }catch(e){
                    items = matcher[1];
                }
            }
        }
        return items;
    }