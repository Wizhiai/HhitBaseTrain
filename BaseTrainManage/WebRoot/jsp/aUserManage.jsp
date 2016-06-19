<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link type="text/css" rel="stylesheet" href="../css/button.css" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/asSystemmenu.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<link type="text/css" rel="stylesheet" href="../css/index.css" />
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

<!-- Table goes in the document BODY -->

<table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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
<table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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
  <table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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

  <table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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
  <table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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

  <table class="hovertable" width="100%" border="0" cellspacing="0" cellpadding="0">
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
<table width="98%"><tr ><td align="right"><input type="button" onclick="disp_confirm()"
value="提交评估"  class="button blue"/></td></tr></table>


</table>

</body>




</html>
