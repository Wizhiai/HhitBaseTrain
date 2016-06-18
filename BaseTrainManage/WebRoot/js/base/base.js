/*选择日期*/
$(function(){
	var base_no = getCookie("base_no");
 			if(base_no =="" || base_no ==null){
 				alert("页面已失效，请重新登录！");
 			}else{
	 			showBaseBasicInfo();
	 			$("#baseManage").attr("src","basebuild.jsp");
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
						if(result.data.manager_name =="" || result.data.manager_name ==null){
							$("#manager_name").val("还未填写");
						}else{
							$("#manager_name").val(result.data.manager_name);
						}
						if(result.data.manager_phone =="" || result.data.manager_phone ==null){
							$("#telephone").val("还未填写");
						}else{
							$("#telephone").val(result.data.manager_phone);
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