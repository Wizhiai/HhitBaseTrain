// JavaScript Document


//导航菜单
function navList(id) {
    var $obj = $("#nav_dot"), $item = $("#J_nav_" + id);
    $item.addClass("on").parent().removeClass("none").parent().addClass("selected");
    $obj.find("h4").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $obj.find("p").hover(function () {
        if ($(this).hasClass("on")) { return; }
        $(this).addClass("hover");
    }, function () {
        if ($(this).hasClass("on")) { return; }
        $(this).removeClass("hover");
    });
    $obj.find("h4").click(function () {
        var $div = $(this).siblings(".list-item");
        if ($(this).parent().hasClass("selected")) {
            $div.slideUp(600);
            $(this).parent().removeClass("selected");
        }
        if ($div.is(":hidden")) {
            $("#nav_dot li").find(".list-item").slideUp(600);
            $("#nav_dot li").removeClass("selected");
            $(this).parent().addClass("selected");
            $div.slideDown(600);

        } else {
            $div.slideUp(600);
        }
    });
}

/****表格隔行高亮显示*****/
window.onload=function(){
	oTable=document.getElementById("tab");//找表格
	aTr=document.getElementsByTagName("tr");//找所有的行
	for(i=0;i<aTr.length;i++){
		if(i%2==0){
			aTr[i].style.background="#fff";	
		}else{
			aTr[i].style.background="#ccc";	
		};
	};
};
function changeSrcaUserManage(){

$("#frameBord").attr("src","http://localhost:8080/BaseTrainManage/jsp/baseInfromList.jsp");
 var p = document.getElementById("p");
    p.innerHTML =      document.getElementById('changeSrcaUserManage').value;;
}

function changeSrcaExpertManage(){
 var p = document.getElementById("p");
  p.innerHTML =      document.getElementById('changeSrcaExpertManage').value;;
$("#frameBord").attr("src","http://localhost:8080/BaseTrainManage/jsp/aExpertManage.jsp");

}

function changeSrcaEvaluationResultManagement(){

 var p = document.getElementById("p");
    p.innerHTML =      document.getElementById('changeSrcaEvaluationResultManagement').value;;

$("#frameBord").attr("src","http://localhost:8080/BaseTrainManage/jsp/aEvaluationResultManagement.jsp");

}
function changeSrcaExpertCommitteeManagement(){
 var p = document.getElementById("p");
    p.innerHTML =      document.getElementById('changeSrcaExpertCommitteeManagement').value;;
$("#frameBord").attr("src","http://localhost:8080/BaseTrainManage/jsp/aExpertCommitteeManagement.jsp");

}

function check(a)
{
if(parseInt(a)<=100&&parseInt(a)>=0&&parseInt(a)==a){

}else{
alert("请输入0-100的分数值！");}
}
function disp_confirm()
  {
  var r=confirm("确定提交？")
  if (r==true)
    {
	
   var inputs=document.getElementsByTagName("input");
   var i = 1;
     $("input[type=number]").each(function(){
    	
        if ($(this).val() == ""){
        	  alert("第 " + i + " 个指标没有评分。");
        	return false;
        }else{
        var s = $(this).val();
 
      	if(parseFloat(s)>100){
        		  alert("第 " + i + " 个指标评分大于100，请修改为0-100之间的数值。");
        		  return false;
        	}
        		if(parseFloat(s)<0){
        		  alert("第 " + i + " 个指标评分小于0，请修改为0-100之间的数值。");
        		  	  return false;
        	}
        }
         
     
       
          i++;
     });
     
     
     $.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/assess/insertAssessScore.do",
					type:"post",
					data:{
    	 
    	 "s11":parseFloat($("#11").val()),
    	 "s12":parseFloat($("#12").val()),
    	 "s13":parseFloat($("#13").val()),
    	 "s21":parseFloat($("#21").val()),
    	 "s22":parseFloat($("#22").val()),
    	 "s23":parseFloat($("#23").val()),
    	 "s24":parseFloat($("#24").val()),
    	 "s25":parseFloat($("#25").val()),
    	 "s26":parseFloat($("#26").val()),
    	 "s27":parseFloat($("#27").val()),
    	 "s31":parseFloat($("#31").val()),
    	 "s32":parseFloat($("#32").val()),
    	 "s33":parseFloat($("#33").val()),
    	 "s34":parseFloat($("#34").val()),
    	 "s35":parseFloat($("#35").val()),
    	 "s36":parseFloat($("#36").val()),
    	 "s41":parseFloat($("#41").val()),
    	 "s42":parseFloat($("#42").val()),
    	 "s43":parseFloat($("#43").val()),
    	 "s44":parseFloat($("#44").val()),
    	 "s45":parseFloat($("#45").val()),
    	 "s51":parseFloat($("#51").val()),
    	 "s52":parseFloat($("#52").val()),
    	 "s53":parseFloat($("#53").val()),
    	 "s54":parseFloat($("#54").val()),
    	 "s55":parseFloat($("#55").val()),
    	 "s61":parseFloat($("#61").val()),
    	 "s62":parseFloat($("#62").val()),
    	 "s63":parseFloat($("#63").val()),
    	 "s64":parseFloat($("#64").val()),
    	 "s65":parseFloat($("#65").val()),  
    	 "s66":parseFloat($("#66").val())
     },
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});

     
     
       alert("您已提交。");
     
     
     
  
    } else
    {
    	  alert("您取消了提交!");
    
    }
  }

