 $(function(){
      $("#login").click(function(){
      //清空原来的消息
       //获取登录信息
    	var username=$("#username").val();
    	var password=$("#password").val();
    	var ok=true;
    	if(username == ""){
    		alert("用户名不能为空");
    		ok=false;
    	}
    	if(password == ""){
    		alert("密码不能为空");
    		ok=false;
    	}
    	if(ok){
    		//发送ajax
    		$.ajax({
    			url:"http://localhost:8080/BaseTrainManage/login.do",
    			type:"post",
    			data:{"username":username,"password":password},
			    dataType:"json",
			    success:function(result){//回调函数
			        var user = result.data;
			        if(result.status==0){
			        	alert(result.msg);
			        }else if(result.status==1 && (user.identity =="5")){
				    		var userId=user.username;
				    		var iden=user.identity;
				    		addCookie("username",userId,2);
				    		addCookie("identity",iden,2);
				    		$.ajax({
				    			url:"http://localhost:8080/BaseTrainManage/work/gainremind.do",
				    			type:"post",
				    			data:{"stuno":userId},
				    			dataType:"json",
				    			success:function(result){
				    				if(result.status==1){
				    					var data=result.data;
				    					if(data.length==1){
				    						alert(data[0].t_no+"老师提醒你交"+data[0].title+"作业");
				    					}else if(data.length>1){
				    						alert("你有多份作业快到期，请赶紧交作业");
				    						
				    					}
				    					
				    				}
				    				
				    			},
				    			error:function(){
				    				alert("程序出错");
				    			}
				    			
				    		});
				    		window.location.href="studentmain.html";
				    }else if(result.status==1 && user.identity =="2"){
				        
				    	var userId=user.username;
				    	
			    		var iden=user.identity;
			    		addCookie("username",userId,2);
			    		addCookie("identity",iden,2);
			    		window.location.href="teachermain.html";
			    	}else if(result.status==1 && user.identity =="3"){
			    		var userId=user.username;
			    		var iden=user.identity;
			    		addCookie("username",userId,2);
			    		addCookie("identity",iden,2);
			    		window.location.href="jdteachermain.html";
			    	}else{
			    		alert("你没有权限,请联系管理员!");
			    	}
			    }	
    			
    		});
    	}
    	});
      
      $("#back").click(function(){
    	  window.location.href="../index.jsp";
      });
    });