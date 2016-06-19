<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基地评估</title>

<link href="./css/datouwang.css" rel="stylesheet" type="text/css"/>
   <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- 可以替换为服务器上的bootstrap,也可以不替换 -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <link type="text/css" rel="stylesheet" href="../../css/button.css" />

<script type="text/javascript" src="../../js/asSystemmenu.js"></script>
<script type="text/javascript" src="../../js/js.js"></script>
<link type="text/css" rel="stylesheet" href="../../css/index.css" />
    
    <script type="text/javascript" src="./js/net.js"></script>
    <link rel="stylesheet" href="css/style.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/assess/echarts.common.min.js"></script>
    
    <style type="text/css">
    .pp{
position:fixed;left:43%;top:30%;margin-left:width/3;margin-top:height/3; 
margin: 0 auto; 
position: absolute;  
z-index: 9999; 
}
    </style>
    <!--
   
    //列表引入
-->

 <title>My JSP 'baseInfromation.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <link rel="stylesheet" href="../../css/assess.css"/>
  <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/page_util.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript">
			var pageSize = 4;
			var emotionData;
			var resultdata=new Array();
			$(function(){
			
				showAllBase();
				$("#search").click(function(){
					search();
				});
				$("#firstPage").click(function(){//首页
					firstPage(resultdata,pageSize);
					
				});
				$("#prePage").click(function(){//上一页
					prePage(resultdata,pageSize);
				
				});
				$("#nextPage").click(function(){//下一页
					nextPage(resultdata,pageSize);
				
				});
					
			});
		
			
			function showAllBase(){
			var cha =0;
				var resultdataTemp=new Array();
				
				var baseno = 0;
				
 var p = document.getElementById("baseName");
var strCookie=document.cookie; 
var arrCookie=strCookie.split("; "); 

for(var i=0;i<arrCookie.length;i++){ 
var arr=arrCookie[i].split("="); 



if(arr[0]=="base_no"){
baseno = arr[1];
			  $.ajax({
	  			url:"/BaseTrainManage/assess/findAllComment.do",
					type:"post",
					data:{"baseno":arr[1]},
					dataType:"json",
					beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./loading2.gif\" alt=\"图片上传中中...\" />");
                  },
					success:function(result){
				var dataArr1 = new Array();
				dataArr1[0] =0; 
				dataArr1[1] =0; 
				dataArr1[2] =0; 
				dataArr1[3] =0; 
				dataArr1[4] =0; 
				dataArr1[5] =0; 
				dataArr1[6] =0; 
				dataArr1[7] =0; 
						resultdata = result.data;
							
							if(result.status == 1){
							 $("#uploadresult").html("");
							for(var i = 0; i <  resultdata.length; i++){
						var emotionP = 0;
	switch(resultdata[i].emotion){
	case -3:{
	dataArr1[0]++;;
		break;
	}
	case -2:{
			dataArr1[1]++;;
		break;
	}
	case -1:{
			dataArr1[2]++;;
		break;
	}
	case 0:{
			dataArr1[3]++;
			break;
	}
	case 1:{
			dataArr1[4]++;
			break;
	}
	case 2:{
			dataArr1[5]++;
			break;
	}
	case 3:{
			dataArr1[6]++;
			break;
	}
	case 4:{
			dataArr1[7]++;
			break;
	}
	default:{
			
			break;
	}
	
	
	}
									
										
							
								}
							
		 var myChart = echarts.init(document.getElementById("group"));
							
					var		option = {
    title : {
        text: '基地评价倾向情绪',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['糟糕透顶','很差','不建议去','一般','比较好','很好','非常好',"强烈推荐"]
    },
    series : [
        {
            name: '评价倾向',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
            	{value:dataArr1[0], name:'糟糕透顶'},
                {value:dataArr1[1], name:'很差'},
                {value:dataArr1[2], name:'不建议去'},
                {value:dataArr1[3], name:'一般'},
                {value:dataArr1[4], name:'比较好'},
                {value:dataArr1[5], name:'很好'},
                {value:dataArr1[6], name:'非常好'},
                 {value:dataArr1[6], name:'强烈推荐'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
	   myChart.setOption(option);
					
					
					
					
myChart.on('click', function (optionz) {
    // 控制台打印数据的名称
	switch(optionz.name){
	case "糟糕透顶":{
	emotionP = -3;
		break;
	}
	case "很差":{
			emotionP = -2;
		break;
	}
	case "不建议去":{
			emotionP = -1;
		break;
	}
	case "一般":{
		emotionP = 0;
			break;
	}
	case "比较好":{
			emotionP = 1;
			break;
	}
	case "很好":{
		emotionP = 2;
			break;
	}
	case "非常好":{
			emotionP = 3;
			break;
	}
	case "强烈推荐":{
			emotionP = 4;
			break;
	}
	default:{
			
			break;
	}
	

	}
	
	
		$.ajax({
						url:"/BaseTrainManage/assess/findCommentByBasenoAndEmotion.do",
						type:"post",
						data:{"baseno":baseno,
							"emotion":emotionP
						},
						dataType:"json",
						beforeSend: function(XMLHttpRequest) {
		  var height = document.body.scrollWidth + "px";//滚动位置可能大于屏幕高度
	$('#uploadresult').css("display","block").css("height",height).css("text-align","center").html('<img style="padding-top:300px;" 	src="./loading.gif\" />');
                    $("#uploadresult").html("<img src=\"./loading2.gif\" alt=\"图片上传中中...\" />");
                  },
						success:function(result){
							if(result.status == 1){
								 $("#uploadresult").html("");
								resultdataT = result.data;
							
								pageCalculate(resultdataT,pageSize);
								firstPage(resultdataT,pageSize);//显示首页ss
								
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
					});
	
	
	
	
	
});
					
							
										
								pageCalculate(resultdata,pageSize);
							
								firstPage(resultdata,pageSize);//显示首页
							}else{
							resultdata=new Array();
								pageCalculate(resultdata,pageSize);
							
								firstPage(resultdata,pageSize);//显示首页
								alert(result.msg);
							}
						},
					error:function(){
							alert("程序出错");
					}
				});
	   	}}
			}
		
			function gotoPage(pageSize,pageIndex,data){//页数跳转
			
				var tr = "";
	resultdata = data;
				for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			

					tr += "<tr bgcolor ='#FFFFFF'><td>"+(i+1)+"</td><td align= 'left'>"+data[i].content+"<br>"+data[i].time+"</td><td>"+
					data[i].username+"</td></td></tr>";
					
				}
			
				clearTableContent();
				addTableContent(tr);
				
			}
			
				function assessBase(){
				var base_no = $("#base_no").val();
					addCookie("base_no",base_no,2);
					var userIdString = document.getElementById("userId").value;
					addCookie("userId",userIdString,2)
				
				window.open("../aUserManage.jsp");
			}
			function search(){//关键字查询
				var searchKey = $("#searchkey").val();
				if(searchKey ==""){
					alert("请输入关键字");
				}else{
					var a=$("#searchType option:selected").val();
			
				if(a == 1){//基地名称搜索
					$.ajax({
						url:"/BaseTrainManage/assess/findByName.do",
						type:"post",
						data:{"no":searchKey},
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								resultdata = result.data;
							for(var i = 0; i <  resultdata.length; i++){
							switch(resultdata[i].identity)
							{

								case "7":
								 { resultdata[i].identity="专家";
  									break;
  									}
								case "2":  	
								{ resultdata[i].identity="学校教师";								
 									 break;
 									 }
                                case "6": 	
                             {   resultdata[i].identity="实训完成学生";								
 									 break;
 									 }
 									 case "专家":
								 { resultdata[i].identity="专家";
  									break;
  									}
								case "学校教师":  	
								{ resultdata[i].identity="学校教师";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   resultdata[i].identity="实训完成学生";								
 									 break;
 									 }
								default:
								{	
									resultdata.splice(i,1);
									i=0;
								
									break;	}
							
							
								}							
							
								}
							
								pageCalculate(resultdata,pageSize);
								firstPage(resultdata,pageSize);//显示首页
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
					});
				}else if(a == 2){//基地地址
				var bool = true;
			
				switch(searchKey){
				
				
								 
								case "学校教师":  	
								{searchKey = "2";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   searchKey = "6";								
 									 break;
 									 }
								case "专家":
								{	
									searchKey = "7";
								
									break;	}
								default:{
								alert("请输入正确的类别，例如:专家,学校教师,实训完成学生");
								bool = false;
								break;
								}
			
				}
				
				if(bool){
					
					$.ajax({
						url:"/BaseTrainManage/assess/findByType.do",
						type:"post",
						data:{"type":searchKey},
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								resultdata = result.data;
								for(var i = 0; i <  resultdata.length; i++){
						
				
							switch(resultdata[i].identity)
							{

								case "7":
								 { resultdata[i].identity="专家";
  									break;
  									}
								case "2":  	
								{ resultdata[i].identity="学校教师";								
 									 break;
 									 }
                                case "6": 	
                             {   resultdata[i].identity="实训完成学生";								
 									 break;
 									 }
 									 case "专家":
								 { resultdata[i].identity="专家";
  									break;
  									}
								case "学校教师":  	
								{ resultdata[i].identity="学校教师";								
 									 break;
 									 }
                                case "实训完成学生": 	
                             {   resultdata[i].identity="实训完成学生";								
 									 break;
 									 }
								default:
								{	
									resultdata.splice(i,1);
									i=0;
								
									break;	}
							
							
								}				
										
							
								}
								pageCalculate(resultdata,pageSize);
								firstPage(resultdata,pageSize);//显示首页
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
				}
			
			}		
		</script>
		
		
		
		
		
		<script type="text/javascript">
$(function(){

baseNameShow();
});
//基地评价名称显示
function baseNameShow(){

 var p = document.getElementById("baseName");
var strCookie=document.cookie; 
var arrCookie=strCookie.split("; "); 

for(var i=0;i<arrCookie.length;i++){ 
var arr=arrCookie[i].split("="); 



if(arr[0]=="base_no")

   
    
    
   	$.ajax({
				url:"/BaseTrainManage/base/searchByBaseNo.do",
				type:"post",
				data:{"base_no": arr[1]},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
					/*	$("#base_name").val(result.data.base_name);
						$("#base_address").val(result.data.base_address);
						$("#establish_time").val(result.data.establish_time);*/
						 p.innerHTML = result.data.base_name;
    
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

<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	margin-top: 0px;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>

<!-- 代码 开始 -->
<section class="section-wrap">
	<div class="section section-1">
	
		<div class="title active">
		<p class="pp" id="uploadresult"></p>
			<p class="" id="titleText" >
			<h3 style="text-align:center;font-size:2em" >基地相关资源信息介绍,请结合实地考虑客观评估<br/></h3></p>

<div  style="left 50%; margin-left:auto; margin-right:auto; margin-top:30px">
<div class="container video-page">  
    <!-- 视频 -->  
            <video id="js-video" class="center-block" preload controls poster="">
                <source src="./videos/1.mp4" type="video/mp4">
                <!-- 浏览器不支持视频播放显示图片 ，需要替换一张图片-->
                <img src="" alt="Poster">
            </video>
</div>

</div>			
		</div>
	</div>
	<div class="section section-8">
		<div class="title">
	<div class="list">
	  	<div class="topContent">
	  		<p class="" id="titleText" ><h3 style="text-align:center;font-size:2em" >第三方对基地的评价</h3></p>
	
	  	<table align="center" bgcolor="#FFFFFF" style="width: 95%;height:60%;">
	  	<tr>
	
	  <td width="650">
	  		   <div id="baseInform">
	  		   
	    	<table id="showInform"   style="font-family:宋体;color:black;font-size:24px;">
	    	<input type="hidden" id="userId"  value=<%=request.getParameter("userId")%>>
	    		<thead>
	    			<!--<tr>
	    				<th>序号</th>
	    				<th>评价内容</th>
	    				<th >用户名</th>
	    				
	    				
	    				
	    			</tr>
	    		--></thead>
	    		<tbody></tbody>
	    	</table>
	    	<div class="pageInfo">
			   	<span>共计</span><span id="totalRecords"></span><span>条数据</span>
			   	<input type="button" id="firstPage" class="btn" value = "首页">
				 	<input type="button" id="prePage"  class="btn" value="上一页">
				 	<span>第</span><span id="currentPage"></span><span>页/共</span>
				 	<span id="totalPage"></span><span>页</span>
				 	<input type="button" id="nextPage" class="btn" value="下一页">
			  </div><!--
	    </div>
	  	--></td>  	
	  	<td width="400">
	  			<!--<table align="center" bgcolor="#FFFFFF" style="width: 80%;height:60%;">
		<tr>
		<td>	
		 --><div id="group" style="width: 100%;height:565px;" align="center"></div><!--
		 </td>
	
		</tr>
		</table>
	  	--></td>
	  	</tr>
	  	
	  	</table>  	

    </div>
		</div>
	</div>

		</div>
	</div>
	<div class="section section-3">
		<div calss = "title"></div>
		
<table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
<br/>
<br/>
<br/>
<br/>
</tr>
<tr>
<th nowrap><h4>被评单位: <a  href="#" id="baseName">最新公告</a></h4></th>
	<th colspan="7"><h4>实践性教学质量评估指标体系</h4></th>
</tr>

<td width="12.5%" rowspan="3">实践教学体系</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td nowrap>实践性教学计划和方案制定系统完整性</td>
	<td nowrap>实践性课程教学大纲编写和规范归档</td>
	<td nowrap>实践教学的校企合作和产学结合规划</td>
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td nowrap="nowrap" ><input id = "11" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "12" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "13" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
</tr>
</table>
<!--

实验室与实践基地建设-->
<table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<td width = "12.5%" rowspan="3">实验室与实践基地建设</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>实验室（基地）设备投入力度大小</td>
	<td>实验室（基地）建设发展规划科学明确性</td>
	<td>实验室建设制度建立健全、执行原则性</td>
		<td>省级重点和示范性、中央与地方共建、国家重点实验室建设数量和规模</td>
	<td>校外实践基地建设的数量、质量和规模，教学环境建设优美、安全、方便等</td>
	<td>世界著名企业IBM、MicroSoft、华为等公司的技术学院建设数量与规模</td>
		<td>签订定制专业人才培养和聘用协议的企业数量和规模</td>
	
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td width="12.5%"><input  id = "21" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td width="12.5%"><input  id = "22" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td width="12.5%"><input id = "23" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td width="12.5%"><input id = "24" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td width="12.5%"><input id = "25" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td width="12.5%"><input id = "26" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
				
		<td width="12.5%"><input id = "27" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
	
</tr>




</table><!--
实践教学过程监控
  -->
  <table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<td width = "12.5%" rowspan="3">实践教学过程监控</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>实践教学师资、课程、教材和场所、设备、环境等准备程度</td>
	<td>教师配置到位，随堂授课指导，课后及时答疑和辅导</td>
	<td>校内外实践教学过程严谨和完整，有详细记录和总结归档文档</td>
		<td>实践教学指导书、任务书、案例分析、报告文档的配置到位</td>
	<td>实践基地注重综合技能和工程研发能力培养过程</td>
	<td>强调校外企业顶岗实习和企业文化素质培养过程</td>
		
	
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td nowrap="nowrap"><input  id = "31" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input  id = "32" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "33" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "34" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "35" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "36" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
				
		
</tr>

</table><!--
  
  师资建设与管理制度
-->

  <table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<td width = "12.5%" rowspan="3">师资建设与管理制度</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>建立健全实践性教学制度，奖惩严明</td>
	<td>管理机构健全，管理规范、善于创新</td>
	<td>校级、省级和国家级教育教改项目数量</td>
	<td>职称、年龄、双师型师资结构的合理性</td>
		<td>实践教学改革项目和成果奖励力度</td>
	
	
		
	
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td nowrap="nowrap"><input  id = "41" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input  id = "42" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "43" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "44" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "45" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>		
</tr>

</table><!--


实践教学效果

-->
<table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<td width = "12.5%" rowspan="3">实践教学效果</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>实训学生论文论文（设计）规范性、学术性、技术主流性等</td>
	<td>实训学生挑战杯、建模、大奖赛、论文等数质量</td>
	<td>实训学生实践教学项目、参与研发项目数量质量</td>
	<td>基地开放实验、创新实践项目数量和质量</td>
		<td>用人单位对毕业生能力和素质的综评</td>
	
	
		
	
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td nowrap="nowrap"><input  id = "51" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input  id = "52" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "53" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "54" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "55" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>		
</tr>

</table><!--
毕业生评价
-->

 <table class="hovertable" width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<td width = "12.5%" rowspan="3">毕业生评价</td>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>学生对实践教学内容的满足和兴趣度</td>
	<td>基础实验室和实践基地等建设需求</td>
	<td>教师回答和解决实际问题整体能力</td>
	<td>学生自主思想和技能发展的自由度</td>
	<td>工程实践能力和企业素质培养认可度</td>
	<td>提升就业能力和创业意识培养满意度</td>
	
		
	
</tr>
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
		<td nowrap="nowrap"><input  id = "61" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input  id = "62" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "63" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "64" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>
		<td nowrap="nowrap"><input id = "65" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>	
			<td nowrap="nowrap"><input id = "66" min="0" max="100" step="1" value="" type="number" onblur="check(this.value)"> </td>			
</tr>
<tr ><td colspan="7" align="right"><input type="button" onclick="disp_confirm()"
value="提交评估"  class="button blue" align="right"/></td></tr>


</table>
		</div>
	</div>
		<div class="section section-4">
		<div class="title ">
		
		</div>
		</div>
		

	<div class="section section-5">
		<div class="title">
		
		</div>
	</div>
		<div class="section section-6">
		<div class="title">
	
		</div>
	</div>
		<div class="section section-7">
		<div class="title">
		
		</div>
	</div>

	
</section>
<ul class="section-btn">
	<li class="on"></li>
	<li></li>
	<li></li>
	
</ul>
<div class="arrow">&laquo;</div>

<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript">
	//此处引用：鼠标滚轮mousewheel插件
	!function(a){"function"==typeof define&&define.amd?define(["jquery"],a):"object"==typeof exports?module.exports=a:a(jQuery)}(function(a){function b(b){var g=b||window.event,h=i.call(arguments,1),j=0,l=0,m=0,n=0,o=0,p=0;if(b=a.event.fix(g),b.type="mousewheel","detail"in g&&(m=-1*g.detail),"wheelDelta"in g&&(m=g.wheelDelta),"wheelDeltaY"in g&&(m=g.wheelDeltaY),"wheelDeltaX"in g&&(l=-1*g.wheelDeltaX),"axis"in g&&g.axis===g.HORIZONTAL_AXIS&&(l=-1*m,m=0),j=0===m?l:m,"deltaY"in g&&(m=-1*g.deltaY,j=m),"deltaX"in g&&(l=g.deltaX,0===m&&(j=-1*l)),0!==m||0!==l){if(1===g.deltaMode){var q=a.data(this,"mousewheel-line-height");j*=q,m*=q,l*=q}else if(2===g.deltaMode){var r=a.data(this,"mousewheel-page-height");j*=r,m*=r,l*=r}if(n=Math.max(Math.abs(m),Math.abs(l)),(!f||f>n)&&(f=n,d(g,n)&&(f/=40)),d(g,n)&&(j/=40,l/=40,m/=40),j=Math[j>=1?"floor":"ceil"](j/f),l=Math[l>=1?"floor":"ceil"](l/f),m=Math[m>=1?"floor":"ceil"](m/f),k.settings.normalizeOffset&&this.getBoundingClientRect){var s=this.getBoundingClientRect();o=b.clientX-s.left,p=b.clientY-s.top}return b.deltaX=l,b.deltaY=m,b.deltaFactor=f,b.offsetX=o,b.offsetY=p,b.deltaMode=0,h.unshift(b,j,l,m),e&&clearTimeout(e),e=setTimeout(c,200),(a.event.dispatch||a.event.handle).apply(this,h)}}function c(){f=null}function d(a,b){return k.settings.adjustOldDeltas&&"mousewheel"===a.type&&b%120===0}var e,f,g=["wheel","mousewheel","DOMMouseScroll","MozMousePixelScroll"],h="onwheel"in document||document.documentMode>=9?["wheel"]:["mousewheel","DomMouseScroll","MozMousePixelScroll"],i=Array.prototype.slice;if(a.event.fixHooks)for(var j=g.length;j;)a.event.fixHooks[g[--j]]=a.event.mouseHooks;var k=a.event.special.mousewheel={version:"3.1.12",setup:function(){if(this.addEventListener)for(var c=h.length;c;)this.addEventListener(h[--c],b,!1);else this.onmousewheel=b;a.data(this,"mousewheel-line-height",k.getLineHeight(this)),a.data(this,"mousewheel-page-height",k.getPageHeight(this))},teardown:function(){if(this.removeEventListener)for(var c=h.length;c;)this.removeEventListener(h[--c],b,!1);else this.onmousewheel=null;a.removeData(this,"mousewheel-line-height"),a.removeData(this,"mousewheel-page-height")},getLineHeight:function(b){var c=a(b),d=c["offsetParent"in a.fn?"offsetParent":"parent"]();return d.length||(d=a("body")),parseInt(d.css("fontSize"),10)||parseInt(c.css("fontSize"),10)||16},getPageHeight:function(b){return a(b).height()},settings:{adjustOldDeltas:!0,normalizeOffset:!0}};a.fn.extend({mousewheel:function(a){return a?this.bind("mousewheel",a):this.trigger("mousewheel")},unmousewheel:function(a){return this.unbind("mousewheel",a)}})});
	
	$(function(){
		var i=0;
		var $btn = $('.section-btn li'),
			$wrap = $('.section-wrap'),
			$arrow = $('.arrow');
		
		/*当前页面赋值*/
		function up(){i++;if(i==$btn.length){i=0};}
		function down(){i--;if(i<0){i=$btn.length-1};}
		
		/*页面滑动*/
		function run(){
	
			$btn.eq(i).addClass('on').siblings().removeClass('on');	
			$wrap.attr("class","section-wrap").addClass(function() {
		
			 return "put-section-"+i; }).find('.section').eq(i).find('.title').addClass('active');
		};
		
		/*右侧按钮点击*/
		$btn.each(function(index) {
			$(this).click(function(){
				i=index;
				run();
			})
		});
		
		/*翻页按钮点击*/
		$arrow.one('click',go);
		function go(){
			up();alert(run());
			setTimeout(function(){$arrow.one('click',go)},1000)
		};
		
		/*响应鼠标*/
		$wrap.one('mousewheel',mouse_);
		function mouse_(event){
			if(event.deltaY<0) {up()}
			else{down()}
			run();
			setTimeout(function(){$wrap.one('mousewheel',mouse_)},1000)
		};
		
		/*响应键盘上下键*/
		$(document).one('keydown',k);
		function k(event){
			var e=event||window.event;
			var key=e.keyCode||e.which||e.charCode;
			switch(key)	{
				case 38: down();run();	
				break;
				case 40: up();run();	
				break;
			};
			setTimeout(function(){$(document).one('keydown',k)},1000);
		}
	});
</script>
<!-- 代码 结束 -->

<div style="display:none"><script src="../../js/assess/gd.js"></script></div>

</body>

</html>