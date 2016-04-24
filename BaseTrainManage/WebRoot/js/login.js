 $(function(){
	
      $("#login1").click(function(){
      //清空原来的消息
       $("#name_msg").html("");
       $("#password_msg").html("");
       
       //获取登录信息
    	var username=$("#username").val();
    	var password=$("#password").val();
    	var ok=true;
    	if(username == ""){
    		alert("用户名不能为空");
    		ok=false
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
			        }else if(result.status==1 && user.identity =="5"){
				    		var userId=user.username;
				    		
				    		addCookie("userId",userId,2);
				    		window.location.href="studentmain.html";
				    }else if(result.status==1 && user.identity =="2"){
				        
				    	var userId=user.username;
				    	
			    		var iden=user.identity;
			    		addCookie("userId",userId,2);
			    		addCookie("identity",iden,2);
			    		window.location.href="teachermain.html";
			    	}else if(result.status==1 && user.identity =="3"){
			    		var userId=user.username;
			    		var iden=user.identity;
			    		addCookie("userId",userId,2);
			    		addCookie("identity",iden,2);
			    		window.location.href="jdteachermain.html";
			    	}else{
			    		alert("你没有权限,请联系管理员!");
			    	}
			    }	
    			
    		});
    	}
    	});
    });