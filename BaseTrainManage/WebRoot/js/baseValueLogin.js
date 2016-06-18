$(function(){
	
	
	
function isAssessExpert(username){

	$.ajax({
		url:"/BaseTrainManage/assess/findAssessExpertByName.do",
		type:"post",
		data:{"userName":username},
		dataType:"json",
		success:function(result){
			
				alert(isTrue);
		
			if(result.status == 1){
							  document.forms[0].method="post";
document.forms[0].action="/BaseTrainManage/jsp/asSystem.jsp?id="+username;
document.forms[0].submit();	
			
			}else{
					alert("非常抱歉，您没有权限进入此系统。");
			}
	
	
					
	
		},
		error:function(){
			alert("程序出错");
		}
	});
			
}

	
	
	
	
	
	
	var isTrue = false;
	$("#login").click(function(){
		
		var username = $("#id").val();
		var password = $("#pwd").val();
		var type = $("#type").val();
		
//		isAssessExpert(username);
//		alert(username+","+ password);
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
		}else{
$.ajax({
				
				url:"/BaseTrainManage/assess/assessLogin.do",
				type:"post",
				async:false,
				data:{"userName":username,"passWord":password},
				dataType:"json",
				beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
				if(result.status == 1){
					 $("#uploadresult").html("");
						alert("登陆成功！");
					if(result.msg == "专家委员会成员"){
							  document.forms[0].method="post";
document.forms[0].action="/BaseTrainManage/jsp/assess/AssessExpertJsp.jsp?id="+username;
document.forms[0].submit();	
					}else if(result.msg == "基地管理员"){
							  document.forms[0].method="post";
document.forms[0].action="/BaseTrainManage/jsp/assess/BaseManager.jsp?id="+username;
document.forms[0].submit();	
					}else{
							  document.forms[0].method="post";
document.forms[0].action="/BaseTrainManage/jsp/asSystem.jsp?id="+username;
document.forms[0].submit();	
					}
						
					}else{
						if(result.msg == "无权限"){
								alert("非常抱歉,您暂时没有权限进入此系统！")
						}else {
								alert(result.msg);
						}
					
					}
					
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });

});