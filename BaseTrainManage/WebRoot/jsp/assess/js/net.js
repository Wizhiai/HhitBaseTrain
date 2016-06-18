var request;
function ajax(method,url,param,type){
	
    try{
        //非ie浏览器，用这种创建方法， 遇到 ie6,会出异常
        request = new XMLHttpRequest();
    }catch(notie){
        try{
            //如果出现异常，说明用的可能是ie，换ie特有方式创建
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }catch(other){
            // do nothing
        }
    }
    request.open(method,url,true);
    //如果请求方法是post,下面这名必须加
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var result;
    request.onreadystatechange = function(){
    	console.log(request);
        if(request.readyState == 4){
            if(request.status==200){
            	
                //做返回结果的处理
                if("json" == type){
                    result = eval("("+request.responseText+")");
                }else if("xml" == type){
                    result = request.responseXML;
                }else{
                    result = request.responseText;
                }
                alert(result);
            }
        }
    }
    request.send(param);//发送消息的主体
    return result;
}