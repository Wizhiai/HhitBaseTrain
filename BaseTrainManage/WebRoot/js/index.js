var placardLength = parseInt(5);
$(function(){
/*检测屏幕高度*/
Height=$(window).height();
mainHeight=Height-400;
$(".main").height(mainHeight);
	showSchoolPagePlacard();
	$("#getMore").click(function(){
		window.location.href="jsp/placard/schoolPlacardInfromList.jsp";
	
	});
	$("#adminLogin").click(function(){
		window.location.href="jsp/admin/adminLogin.jsp";
	});
	$("#baseAdminLogin").click(function(){
		window.location.href="jsp/baseadmin/baseadminLogin.jsp";
	});
	$("#baseInformLogin").click(function(){
		window.location.href="jsp/baseInformLogin.jsp";
	});
	$("#baseTrainLogin").click(function(){
		window.location.href="html/studentLogin1.jsp";
	});
	$("#baseValueLogin").click(function(){
		//window.location.href="jsp/baseValueLogin.jsp";
		window.location.href="http://120.27.112.49:8181/BaseTrainManage/jsp/baseValueLogin.jsp";
	});
})
function showSchoolPagePlacard(){//显示学校公告基本信息
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchAll.do",
				type:"post",
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						var data = result.data;
						for(var i = 0;i < placardLength && i<data.length;i++){
							var tr = "<li><a onclick='gotoSchoolPlacard(this);'><span class='titleOfannounce'>"+data[i].placard_title+"</span>";
							tr +="<span class='dateOfannounce'><input type='hidden' id='placard_no' value='"+data[i].placard_no+"'/>"+data[i].publish_time+"</span></a></li>";
							$("#schoolPlacard").append($(tr));
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
function gotoSchoolPlacard(obj){
	var placard_no = $(obj).children("span").find("input:hidden").val();
		addCookie("placard_no",placard_no,2);
		window.open("jsp/placard/schoolplacard.jsp");
}