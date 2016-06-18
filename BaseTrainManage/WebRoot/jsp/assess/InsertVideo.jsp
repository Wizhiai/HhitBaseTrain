<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
input{
	transition:all 0.30s ease-in-out;
	-webkit-transition: all 0.30s ease-in-out;
	-moz-transition: all 0.30s ease-in-out;
	
	border:#35a5e5 1px solid;
	border-radius:3px;
	outline:none;
}
input:focus{
	box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-webkit-box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-moz-box-shadow:0 0 5px rgba(81, 203, 238, 1);
}
a{
	text-decoration:none;
	background:rgba(81, 203, 238, 1);
	color:white;padding: 6px 25px 6px 25px;
	font:12px 'Î¢ÈíÑÅºÚ';
	border-radius:3px;
	
	-webkit-transition:all linear 0.30s;
	-moz-transition:all linear 0.30s;
	transition:all linear 0.30s;
}
a:hover{background:rgba(39, 154, 187, 1);}
</style>
<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function GetRequest() { 
var url = location.search; //获取url中"?"符后的字串 
var theRequest = new Object(); 
if (url.indexOf("?") != -1) { 
var str = url.substr(1); 
strs = str.split("&"); 
for(var i = 0; i < strs.length; i ++) { 
theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
} 
} 
return theRequest; 
} 

function insertVideoUrl(){
 var url =  document.getElementById('urlText').value;

  var Request = new Object(); 
Request = GetRequest(); 
var userName; 
userName = Request['userId']; 

  if(url==""){
  alert("请输入视频地址");
  }else{
   $.ajax({
	  			url:"/BaseTrainManage/assess/insertVideo.do",
					type:"post",
					data:{
    	 
    	 "userName":userName,
    
    	 "url":url,
    	
     },

					dataType:"json",
					success:function(result){
						if(result.status == 1){
							
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
  
  }

  
}
</script>
</head>

<body>

<div style="width:1020px;height:64px;margin:60px auto 0 auto;font-size:2em " align = "center" >
	<input type="text" placeholder="请输入视频链接地址."  style="height:45px" id="urlText"/>
	
	<a  style="font-size:16px;"  onclick="insertVideoUrl()">提交</a>
	
	
</div>
<input id='userId' type='hidden' value=<%=request.getParameter("userId")%>>


</body>
</html>