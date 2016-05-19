<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑场地与设施条件信息</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			var base_no = getCookie("base_no");
 			if(base_no =="" || base_no ==null){
 				alert("未获取到基地编号，请重新打开选择的页面");
 			}else{
 				showBaseFieldInfo();
	 			slide();
	 			$("#update").click(function(){
	 				updateField();
	 			});
 			}
 		});
 		function showBaseFieldInfo(){
 			var base_no = getCookie("base_no");
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/searchFieldByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
						dataManage(result.data);
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
 		}
 		function dataManage(data){
 			/* 实训场地 */
 			if(data.base_area != "" && data.base_area !=null){
 				$("#base_area").val(data.base_area);
 				
 			}else{
 				$("#base_area").val("未填写");
 			}
 			/*  硬件设备*/
 			if(data.handware != "" && data.handware !=null){
 				$("#handware").val(data.handware);
 				
 			}else{
 				$("#handware").val("未填写");
 			}
 			/* 设备使用状况 */
 			if(data.machine_situation != "" && data.machine_situation !=null){
 				if(data.machine_situation ==1){
 					$("#machine_situation1").attr("checked","true");
 				}else if(data.handware ==2){
 					$("#machine_situation2").attr("checked","true");
 				}else{
 					$("#machine_situation3").attr("checked","true");
 				}
 			}else{
 				$("#machine_situation3").attr("checked","true");
 			}
 			/* 软件先进度自我评价 */
 			if(data.software_selfevaluation != "" && data.software_selfevaluation !=null){
 				if(data.software_selfevaluation ==1){
 					$("#software_selfevaluation1").attr("checked","true");
 				}else if(data.software_selfevaluation ==2){
 					$("#software_selfevaluation2").attr("checked","true");
 				}else{
 					$("#software_selfevaluation3").attr("checked","true");
 				}
 			}else{
 				$("#software_selfevaluation3").attr("checked","true");
 			}
 			/* 软件实训需求情况 */
 			if(data.software_demand != "" && data.software_demand !=null){
 				if(data.software_demand ==1){
 					$("#software_demand1").attr("checked","true");
 				}else{
 					$("#software_demand2").attr("checked","true");
 				}
 			}else{
 				$("#software_demand2").attr("checked","true");
 			}
 			/* 食堂归属 */
 			if(data.canteen_belong != "" && data.canteen_belong !=null){
 				if(data.canteen_belong ==1){
 					$("#canteen_belong1").attr("checked","true");
 				}else if(data.handware ==2){
 					$("#canteen_belong2").attr("checked","true");
 				}else{
 					$("#canteen_belong3").attr("checked","true");
 				}
 			}else{
 				$("#canteen_belong3").attr("checked","true");
 			}
 			/*  宿舍归属 */
 			if(data.dormitory_belong != "" && data.dormitory_belong !=null){
 				if(data.dormitory_belong ==1){
 					$("#dormitory_belong1").attr("checked","true");
 				}else if(data.dormitory_belong ==2){
 					$("#dormitory_belong2").attr("checked","true");
 				}else{
 					$("#dormitory_belong3").attr("checked","true");
 				}
 			}else{
 				$("#dormitory_belong3").attr("checked","true");
 			}
 			/* 学生管理现状 */
 			if(data.student_manage != "" && data.student_manage !=null){
 				if(data.student_manage ==1){
 					$("#student_manage1").attr("checked","true");
 				}else if(data.student_manage ==2){
 					$("#student_manage2").attr("checked","true");
 				}else{
 					$("#student_manage3").attr("checked","true");
 				}
 			}else{
 				$("#student_manage3").attr("checked","true");
 			}
 			/* 清洁卫生  */
 			if(data.clean_manage != "" && data.clean_manage !=null){
 				if(data.clean_manage ==1){
 					$("#clean_manage1").attr("checked","true");
 				}else{
 					$("#clean_manage2").attr("checked","true");
 				}
 			}else{
 				$("#clean_manage2").attr("checked","true");
 			}
 			/* 环境状况 */
 			if(data.environment != "" && data.environment !=null){
 				$("#environment").val(data.environment);
 			}else{
 				$("#environment").val("未填写");
 			}
 			/* 安全状况  */
 			if(data.safety != "" && data.safety !=null){
 				$("#safety").val(data.safety);
 			}else{
 				$("#safety").val("未填写");
 			}
 		}
 		function updateField(){
 			var base_area = $("#base_area").val();//实训场地
 			var handware = $("#handware").val();//硬件设备
 			var machine_situation = $("input:radio[name='machine_situation']:checked").val();//设备使用状况
 			var software_selfevaluation = $("input:radio[name='software_selfevaluation']:checked").val();//软件先进度自我评价
 			var software_demand = $("input:radio[name='software_demand']:checked").val();//软件实训需求情况
 			var canteen_belong = $("input:radio[name='canteen_belong']:checked").val();//食堂归属
 			var dormitory_belong = $("input:radio[name='dormitory_belong']:checked").val();//宿舍归属
 			var student_manage = $("input:radio[name='student_manage']:checked").val();//学生管理现状
 			var clean_manage = $("input:radio[name='clean_manage']:checked").val();//清洁卫生
 			var environment = $("#environment").val();//环境状况
 			var safety = $("#safety").val();//安全状况
 			var base_no = getCookie("base_no");
 			
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/modifyFiledByBaseNo.do",
				type:"post",
				data:{"base_no":base_no,"base_area":base_area,"handware":handware,"machine_situation":machine_situation,
							"software_selfevaluation":software_selfevaluation,"software_demand":software_demand,
							"canteen_belong":canteen_belong,"dormitory_belong":dormitory_belong,
							"student_manage":student_manage,"clean_manage":clean_manage,"environment":environment,"safety":safety},
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
 	</script>
 	
  </head>
  
 <body style="background:#dfe9f7;height:100%;width:100%;">
		<div class="baseField">
		    <section class="baseCharacter column">
		        <div class="term">
		            <span class="imgBtn"></span><h1  class="resultTitle">实训场地</h1>
		            <div class="resultInfo">
		                <textarea class="editContent" id="base_area"></textarea>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1  class="resultTitle">硬件设备</h1>
		            <div class="resultInfo">
		                <textarea class="editContent" id="handware"></textarea>
		                <span>硬件设备状况:</span><br/>
		                <input type="radio" value="1" id="machine_situation1" name="machine_situation"/><span>良好(满足实习教学)</span>
               			<input type="radio" value="2" id="machine_situation2" name="machine_situation"/><span>较好(基本满足)</span><br/>
                		<input type="radio" value="3" id="machine_situation3" name="machine_situation"/><span>一般(能应付教学)</span>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">软件设施</h1>
		            <div class="resultInfo">
		                <span>软件先进程度自我评价:</span><br/>
		                <input type="radio" value="1" id="software_selfevaluation1" name="software_selfevaluation"/><span>业界主流、先进</span>
                		<input type="radio" value="2" id="software_selfevaluation2" name="software_selfevaluation"/><span>较好</span><br/>
                		<input type="radio" value="3" id="software_selfevaluation3" name="software_selfevaluation"/><span>一般</span><br/>
		                <span>软件实训需求情况:</span><br/>
		                <input type="radio" value="1" id="software_demand1" name="software_demand"/><span>足以支撑实训项目</span><br/>
                		<input type="radio" value="2" id="software_demand2" name="software_demand"/><span>基本能够支撑实训项目</span>
		            </div>
		        </div>
		    </section>
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">饮食住宿</h1>
		            <div class="resultInfo">
		                <span>食堂归属:</span><br/>
		                <input type="radio" value="1" id="canteen_belong1" name="canteen_belong"/><span>基地独有食堂</span>
                		<input type="radio" value="2" id="canteen_belong2" name="canteen_belong"/><span>园区共用食堂</span><br/>
                		<input type="radio" value="3" id="canteen_belong3" name="canteen_belong"/><span>借用其他单位食堂</span><br/>
		                <span>宿舍归属:</span><br/>
		                <input type="radio" value="1" id="dormitory_belong1" name="dormitory_belong"/><span>基地自建宿舍</span>
                		<input type="radio" value="2" id="dormitory_belong2" name="dormitory_belong"/><span>园区共用宿舍</span><br/>
                		<input type="radio" value="3" id="dormitory_belong3" name="dormitory_belong"/><span>租用其他单位</span>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">学生管理现状</h1>
		            <div class="resultInfo">
		                <input type="radio" value="1" id="student_manage1" name="student_manage"/><span>有专职管理人员、作息制度健全、管理严格 </span><br/>
                		<input type="radio" value="2" id="student_manage2" name="student_manage"/><span>非专职管理人员、有作息制度、但不太严格</span><br/>
                		<input type="radio" value="3" id="student_manage3" name="student_manage"/><span>学生自主(自行)管理</span>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">清洁卫生</h1>
		            <div class="resultInfo">
		                <input type="radio" value="1" id="clean_manage1" name="clean_manage"/><span>有专人打扫卫生 </span><br/>
                		<input type="radio" value="2" id="clean_manage2" name="clean_manage"/><span>学生自行打扫</span>
		            </div>
		        </div>
		    </section>
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">环境状况</h1>
		            <div class="resultInfo">
		                <textarea class="editContent" id="environment"></textarea>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">安全状况</h1>
		            <div class="resultInfo">
		                <textarea class="editContent" id="safety"></textarea>
		            </div>
		        </div>
		        <input type="button" class="editBtn" id="update" value="修改">
		    </section>
		</div>
	</body>
</html>
