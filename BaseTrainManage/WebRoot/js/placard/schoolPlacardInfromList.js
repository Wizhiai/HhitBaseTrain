var pageSize = 8;
var resultdata = new Object();
$(function(){//页面加载时从数据库中学校公告
	showAllSchoolPlacard();//显示所有学校公告
		$("#firstPage").click(function(){//首页
			firstPage(resultdata,pageSize);
		});
		$("#prePage").click(function(){//上一页
			prePage(resultdata,pageSize);
		});
		$("#nextPage").click(function(){//下一页
			nextPage(resultdata,pageSize);
		});
		/*关闭当前页，回到上一页面*/
  	$("#close").click(function(){
  		$("#placardContent").hide();
			$("#moreInfo").show();
  	});
});
function showAllSchoolPlacard(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchAll.do",
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					resultdata = result.data;
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

function gotoPage(pageSize,pageIndex,data){//页数跳转
		var tr = "";
		for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].placard_title+"</td><td>"+data[i].publish_time+"</td>";
			tr += "<td><input id='placard_no' type='hidden' value ='"+data[i].placard_no+"'><input type='button' value='浏览' class ='btn'onclick='gotoSchoolPlacard(this);'></td></tr>";
		}
		clearTableContent();
		addTableContent(tr);
	}
	
	function gotoSchoolPlacard(obj){
	var placard_no = $(obj).parent("td").find("#placard_no").val();
		addCookie("placard_no",placard_no,2);
		$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchByPlacardNo.do",
			type:"post",
			data:{"placard_no":placard_no},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					$("#manage_title").val(result.data.placard_title);
					$("#publish_time").val(result.data.publish_time);
					$("#content").val(result.data.placard_content);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
		/*window.open("schoolplacard.jsp");*/
		$("#moreInfo").hide();
		$("#placardContent").show();
}