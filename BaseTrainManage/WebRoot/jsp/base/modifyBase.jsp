<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html style="overflow: scroll;">
  <head>
    <title>编辑基地信息</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/datepicker.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../../js/datepicker.js" ></script>
    <script type="text/javascript" src="../../js/datepicker.en.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
    <script type="text/javascript">
        /*选择日期*/
        $(function(){
        	var base_no = getCookie("base_no");
		 			if(base_no =="" || base_no ==null){
		 				alert("页面已失效，请重新打开页面！");
		 			}else{
		        showBaseBasicInfo();
		         /*修改按钮*/
		          $("#edit").click(function(){
		              $(" .baseInfo").removeAttr("disabled");
		              $(".baseInfo").css("border","1px solid #ccc");
		              $(".baseInfo").css("padding-left","10px");
		              $(".baseInfo").css("border-radius","10px");
		              $(".baseInfo").css("color","#555");
		              $("#datetime").datepicker({
		                  language: "en",
		                  dateFormat: "yy-mm-dd"
		              });
		          });
		        $("#base_build_manage").click(function(){
				 			$("#base_build_manage").attr("href","modifyBaseBuild.jsp");
				 			$("#base_build_manage").attr("target","baseManage");
				 		});
				 		$("#site_facility_condition").click(function(){
				 			$("#site_facility_condition").attr("href","modifyBaseField.jsp");
				 			$("#site_facility_condition").attr("target","baseManage");
				 		});
				 		$("#train_goal_content").click(function(){
				 			$("#train_goal_content").attr("href","modifyBaseContent.jsp");
				 			$("#train_goal_content").attr("target","baseManage");
				 		});
				 		$("#teacher_coach_staff").click(function(){
				 			$("#teacher_coach_staff").attr("href","modifyBaseCoach.jsp");
				 			$("#teacher_coach_staff").attr("target","baseManage");
				 		});
				 		$("#research_technical_activity").click(function(){
				 			$("#research_technical_activity").attr("href","modifyBaseResearch.jsp");
				 			$("#research_technical_activity").attr("target","baseManage");
				 		});
				 		$("#practice_effect_develop").click(function(){
				 			$("#practice_effect_develop").attr("href","modifyBaseEffect.jsp");
				 			$("#practice_effect_develop").attr("target","baseManage");
				 		});
				 		$("#enterprise_alliance").click(function(){
				 			$("#enterprise_alliance").attr("href","modifyBaseAlliance.jsp");
				 			$("#enterprise_alliance").attr("target","baseManage");
				 		});
				 		$("#base_character").click(function(){
				 			$("#base_character").attr("href","modifyBaseAdvantage.jsp");
				 			$("#base_character").attr("target","baseManage");
				 		});
				        /*给当前选中的a标签加样式*/
		        $(".researchInfo ul li").click(function(){
		            $(this).children("a").addClass("selected");
		            $(this).siblings().children("a").removeClass("selected");
		
		        });
		       }
        });
        function showBaseBasicInfo(){
		 			var base_no =  getCookie("base_no");
		 			$.ajax({
						url:"http://localhost:8080/BaseTrainManage/base/searchBaseBasicInfoByBaseNo.do",
						type:"post",
						data:{"base_no":base_no},
						dataType:"json",
						success:function(result){
							if(result.status == 1){//查询成功，显示基地基本信息
								$("#base_name").val(result.data.base_name);
								$("#base_address").val(result.data.base_address);
								if(result.data.establish_time =="" || result.data.establish_time ==null){
									$("#establish_time").val("还未填写");
								}else{
									$("#establish_time").val(result.data.establish_time);
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
 			function updateBaseBasicInfo(){
 				var ok = true;
 				var base_no = getCookie("base_no");
 				var base_name = $("#base_name").val();
 				var establish_time = $("#establish_time").val();
 				var base_address = $("#base_address").val();
 				
 				if(establish_time == ""){
 					ok = false;
 					alert("请输入基地成立时间！");
 					
 				}
 				if(base_address == ""){
 					ok = false;
 					alert("请输入基地地址！");
 				}
 				if(ok){
	 				$.ajax({
						url:"http://localhost:8080/BaseTrainManage/base/modifyBasicInfoByBaseNo.do",
						type:"post",
						data:{"base_no":base_no,"base_name":base_name,"establish_time":establish_time,
									"base_address":base_address},
						dataType:"json",
						success:function(result){
							if(result.status == 1){//修改成功
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
  
  <body style="background:#dfe9f7;height:100%;width:100%">
  	<section class="mainBody">
        <section class="showInfo">
            <span>基地名称:</span>
            <input type="text" id="base_name" class="baseInfo" disabled="disabled" style="width: 300px;"/>
            <span>成立时间:</span>
            <input type="text"  id="establish_time"  class="baseInfo" disabled="disabled">
            <input type="button" id="edit" value="修改"/><br/>
            <span class="baseAddr">基地地址:</span>
            <input type="text"  id="base_address"  class="baseInfo" >
        </section>
        <section class="researchInfo">
            <ul>
                <li><a id="base_build_manage" class="selected">基地建设与管理状况</a></li>
                <li><a id="site_facility_condition">场地与设施条件</a></li>
                <li><a id="train_goal_content">实训项目目标及内容</a></li>
                <li><a id="teacher_coach_staff">教师与辅导队伍</a></li>
                <li><a id="research_technical_activity">科研与技术活动</a></li>
                <li><a id="practice_effect_develop">实践效果与能力开发</a></li>
                <li><a id="enterprise_alliance">企业联盟</a></li>
                <li><a id="base_character">基地特色</a></li>
            </ul>
            <div class="researchResult">
                <iframe id="baseManage" src=""
                        frameborder="0" width="100%" height="100%" name="baseManage"  height="100%" border="1px solid #ccc" ></iframe>
            </div>
        </section>
    </section>
  </body>
</html>
