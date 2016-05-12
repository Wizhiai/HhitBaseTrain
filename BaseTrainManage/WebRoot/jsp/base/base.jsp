<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base.jsp' starting page</title>
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->	
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			showBaseBasicInfo();
 			$("#base_build_manage").click(function(){
 				$("#base_build_manage").attr("href","basebuild.jsp");
 				$("#base_build_manage").attr("target","basefrm");
 			});
 			$("#site_facility_condition").click(function(){
 				$("#site_facility_condition").attr("href","basefield.jsp");
 				$("#site_facility_condition").attr("target","basefrm");
 			});
 			$("#train_goal_content").click(function(){
 				$("#train_goal_content").attr("href","basecontent.jsp");
 				$("#train_goal_content").attr("target","basefrm");
 			});
 			$("#teacher_coach_staff").click(function(){
 				$("#teacher_coach_staff").attr("href","basecoach.jsp");
 				$("#teacher_coach_staff").attr("target","basefrm");
 			});
 			$("#research_technical_activity").click(function(){
 				$("#research_technical_activity").attr("href","baseresearch.jsp");
 				$("#research_technical_activity").attr("target","basefrm");
 			});
 			$("#practice_effect_develop").click(function(){
 				$("#practice_effect_develop").attr("href","baseeffect.jsp");
 				$("#practice_effect_develop").attr("target","basefrm");
 			});
 			$("#enterprise_alliance").click(function(){
 				$("#enterprise_alliance").attr("href","basealliance.jsp");
 				$("#enterprise_alliance").attr("target","basefrm");
 			});
 			$("#base_character").click(function(){
 				$("#base_character").attr("href","baseadvantage.jsp");
 				$("#base_character").attr("target","basefrm");
 			});
 		});
 		function showBaseBasicInfo(){
 			var base_no =  getCookie("base_no");
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/searchByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
						$("#base_name").val(result.data.base_name);
						$("#base_address").val(result.data.base_address);
						$("#establish_time").val(result.data.establish_time);
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
 		}
 	</script>
 	
  </head>
  
  <body>
    <div id="basicBaseInfo">
    	基地名称：<input type="text" id="base_name" disabled="disabled"/>
    	地址：<input type="text" id="base_address" disabled="disabled"/>
    	成立时间：<input type="text" id="establish_time" disabled="disabled"/>
    </div>
    <div id="infChoose">
     <a id="base_build_manage">基地建设与管理状况</a>
     <a id="site_facility_condition">场地与设施条件</a>
     <a id="train_goal_content">实训项目目标及内容</a>
     <a id="teacher_coach_staff">教师与辅导队伍</a>
     <a id="research_technical_activity">科研与技术活动</a>
     <a id="practice_effect_develop">实践效果与能力开发</a>
     <a id="enterprise_alliance">企业联盟</a>
     <a id="base_character">基地特色</a>
    </div>
    <div>
    	<iframe id="basefrm" src=""
						frameborder="0" width="100%" name="businessfrm" scrolling="no";height="510px";></iframe>
    </div>
  </body>
</html>
