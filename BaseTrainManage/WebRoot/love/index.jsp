<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信纸一张</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><!--

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
		  	--><script type="text/javascript" src="../js/jquery.min.js"></script>
<!-- //for-mobile-apps -->
<link href="css/styleI.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
$(function(){
	
	
		$("#confirm").click(function(){
		var bo = true;
		var yourName = $("#yourName").val();
		var herName = $("#herName").val();
		var meetTime = $("#meetTime").val();
		var bgmUrl = $("#bgmUrl").val();
		var email = $("#email").val();
		var textArea = $("#textarea").val();
		var str=bgmUrl;
		
		
		
if(meetTime == "" ){
		meetTime ="2012,9,5"; 
		}
		
//判断URL地址的正则表达式为:http(s)?://([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?
//下面的代码中应用了转义字符"\"输出一个字符"/"
var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
var objExp=new RegExp(Expression);
if(objExp.test(str)==true){

}else{

bgmUrl="";
}
		if(email.length>0)
            {
                if(email == null || email.length < 2){
                    alert('邮件格式不正确，请重新输入！');
                    bo = false;
                    return false;
                }
                //需出現'@@',且不是首字符.
                var aPos = email.indexOf("@" ,1) ;
                if(aPos < 0){
                    alert('邮件格式不正确，请重新输入！');
                    bo = false;
                    return false ;
                }
                // '@'後出現'.',且不緊跟其後.
                if(email.indexOf("." ,aPos+2) < 0){
                    alert('邮件格式不正确，请重新输入！');
                    bo = false;
                    return false ;
                }
                //判斷'.'是否爲最後一個字符
                if(email.indexOf('.')==email.length-1){
                    alert('邮件格式不正确，请重新输入！');
                    bo = false;
                    return false ;
                }
            }
		
		
		if(email == " " || herName == "她/他的名字"){
			alert("ta的名字或email不能为空");
			bo = false;
		}else{
$.ajax({
		
				url:"/BaseTrainManage/sendLove.do",
				type:"post",
				async:false,
				data:{
				"email":email,
				"toWho":herName,
				"yourName":yourName,
				"meetTime":meetTime,
					"content":textArea,
				"musicUrl":bgmUrl
				
				},
				dataType:"json",
				beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"../jsp/assess/loading2.gif\" alt=\"图片上传中中...\" />");
                  },
			success:function(result){
			
				if(result.status == 1){
					 $("#uploadresult").html("");
					
					  var results = confirm('发送成功！是否跳转到信纸页面？'+result.msg); 
					
					  var s = result.msg;
    if(results){  
    
       window.open(result.msg);
   
    }else{  
         
    }  
					}else{
						
								alert(result.msg);
						
					
					}
					
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });
		
		
		
	});	
		</script>
<!-- <link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'> -->
</head>
<body>
	<!-- main -->
		<div class="main">
			<h3>如想匿名可不填你的姓名，如不想写内容可不填直接套用模板，对方邮箱必填</h3>
		
			<div class="input_form">
				<form action ="">
					<input type="text" id = "yourName" value="你的名字(可不填即匿名)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '你的名字(可不填即匿名)';}" required="">
					<input type="text"  id = "herName" value="她/他的名字" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '她/他的名字';}" required="">
					<input type="text"  id = "meetTime" value="你们相遇的时间如(2012,9,5)英文逗号,最后日期5后面没有逗号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '你们相遇的时间如(2012,9,5)最后日期5后面没有逗号';}" required="">
						<input type="text"  id = "bgmUrl" value="bgm地址(可不填)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'bgm地址(可不填)';}" required="">
							<input type="text"  id = "email" value="对方的邮箱，很重要可通知他查看" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '对方的邮箱，很重要可通知他查看';}" required="email">
							<br/>
						<textarea type="text"  id = "textarea" placeholder="请写出你想对他说的话，如不填则显示我们的模板，但还需要你填上对方的姓名..." style="“text-align:center;width:100%;height:130px;overflow-x:visible;overflow-y:visible;"></textarea>
				</form>
			</div>
			<div class="ckeck-bg">
				<div class="checkbox-form">
					
					<div class="check-right">
						<form>
							<input id="confirm" type="submit" value="生成情书">
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="footer">
			<p>&copy 2016 91youzhi.com <a href="http://91youzhi.com">91youzhi.</a></p>
		</div>
	<!-- //main -->
</body>
</html>