<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html style="overflow: scroll;">
  <head>
    <title>My JSP 'base.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
    <script type="text/javascript">
        /*选择日期*/
        $(function(){
        	showBaseBasicInfo();
        	$("#base_build_manage").click(function(){
		 				$("#base_build_manage").attr("href","basebuild.jsp");
		 				$("#base_build_manage").attr("target","baseManage");
		 			});
		 			$("#site_facility_condition").click(function(){
		 				$("#site_facility_condition").attr("href","basefield.jsp");
		 				$("#site_facility_condition").attr("target","baseManage");
		 			});
		 			$("#train_goal_content").click(function(){
		 				$("#train_goal_content").attr("href","basecontent.jsp");
		 				$("#train_goal_content").attr("target","baseManage");
		 			});
		 			$("#teacher_coach_staff").click(function(){
		 				$("#teacher_coach_staff").attr("href","basecoach.jsp");
		 				$("#teacher_coach_staff").attr("target","baseManage");
		 			});
		 			$("#research_technical_activity").click(function(){
		 				$("#research_technical_activity").attr("href","baseresearch.jsp");
		 				$("#research_technical_activity").attr("target","baseManage");
		 			});
		 			$("#practice_effect_develop").click(function(){
		 				$("#practice_effect_develop").attr("href","baseeffect.jsp");
		 				$("#practice_effect_develop").attr("target","baseManage");
		 			});
		 			$("#enterprise_alliance").click(function(){
		 				$("#enterprise_alliance").attr("href","basealliance.jsp");
		 				$("#enterprise_alliance").attr("target","baseManage");
		 			});
		 			$("#base_character").click(function(){
		 				$("#base_character").attr("href","baseadvantage.jsp");
		 				$("#base_character").attr("target","baseManage");
		 			});
		          /*给当前选中的a标签加样式*/
          $(".researchInfo ul li").click(function(){
              $(this).children("a").addClass("selected");
              $(this).siblings().children("a").removeClass("selected");

          });
        });
        function showBaseBasicInfo(){
		 			var base_no =  getCookie("base_no");
		 			alert(base_no);
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
								if(result.data.manager_name =="" || result.data.manager_name ==null){
									$("#manager_name").val("还未填写");
								}else{
									$("#manager_name").val(result.data.manager_name);
								}
								if(result.data.manager_phone =="" || result.data.manager_phone ==null){
									$("#telephone").val("还未填写");
								}else{
									$("#telephone").val(result.data.establish_time);
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
    </script>
  </head>
  
  <body>
  	<section class="mainBody">
        <section class="showInfo">
            <span>基地名称:</span>
            <input type="text" id="base_name" class="baseInfo" style="width:300px;" disabled="disabled"/>
            <span>成立时间:</span>
            <input type="text"  id="establish_time"  class="baseInfo" disabled="disabled">
            <span class="baseAddr" style="margin-top:0px;">基地地址:</span>
            <input type="text"  id="base_address"  class="baseInfo" ><br/>
            <span class="baseAddr">基地负责人:</span>
            <input type="text"  id="manager_name"  class="baseInfo" style="margin-top:30px;">
            <span class="baseAddr" style="margin-left:130px;">联系电话:</span>
            <input type="text"  id="telephone"  class="baseInfo" style="margin-top:30px;">
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
