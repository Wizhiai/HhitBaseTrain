  function toNextPage(){
        window.location.href="JDT_uploadexampper1.jsp?stuno="+stuno+"&name="+name+"&cno="+cno+"&week="+week+"&month="+month;
    }
    function download(){
       var fileName=null;
        $.ajax({
        	url:"/BaseTrainManage/gainExam.do",
        	type:"post",
        	data:{"stuno":stuno,"month":month,"week":week},
        	dataType:"json",
        	success:function(result){
        		if(result.status==1){
        			alert(1);
        			alert(week);
        			alert(month);
        			fileName=result.data;
        			 alert(fileName);
        			 window.location.href="../download.do?fileName="+fileName;
        		}else{
        			alert("还没有上传试卷，请上传试卷");
        			
        		}
        	}
        
        });
        
       
      
    
    }