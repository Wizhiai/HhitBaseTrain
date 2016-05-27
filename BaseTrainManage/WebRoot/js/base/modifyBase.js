/*选择日期*/
$(function(){
	var base_no = getCookie("base_no");
 			if(base_no =="" || base_no ==null){
 				alert("页面已失效，请重新登录！");
 			}else{
        showBaseBasicInfo();
        $("#establish_time").datepicker({
            language: "en",
            dateFormat: "yyyy-mm-dd"
        });
        /*修改按钮*/
         $("#update").click(function(){
            updateBaseBasicInfo();
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
	var ok = true;
		var base_no =  getCookie("base_no");
		if(base_no =="" || base_no ==null){
			alert("页面已失效，请重新登录！");
			ok = false;
		}
		if(ok){
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