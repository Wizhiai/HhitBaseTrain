<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>实践效果与能力开发</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			showBaseBuildInfo();
 			slide();
 		});
 		function showBaseBuildInfo(){
 			var base_no = getCookie("base_no");
 			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/searchEffectByBaseNo.do",
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
 			/* 实际使用的项目数 */
 			if(data.project_inuse !="" && data.project_inuse !=null){
 				$("#project_inuse").val(data.project_inuse);
 			}else{
 				$("#project_inuse").val(0);
 			}
 			/* 实训效果较好的项目数 */
 			if(data.good_project !="" && data.good_project !=null){
 				$("#good_project").val(data.good_project);
 			}else{
 				$("#good_project").val(0);
 			}
 			/*企业实际产品研发项目数 */
 			if(data.company_project !="" && data.company_project !=null){
 				$("#company_project").val(data.company_project);
 			}else{
 				$("#company_project").val(0);
 			}
 			/* 基地自主研发项目数 */
 			if(data.selfdevelop_project !="" && data.selfdevelop_project !=null){
 				$("#selfdevelop_project").val(data.selfdevelop_project);
 			}else{
 				$("#selfdevelop_project").val(0);
 			}
 			/* 研究生层次 */
 			if(data.postgraduate_proportion !="" && data.postgraduate_proportion !=null){
 				$("#postgraduate_proportion").val(data.selfdevelop_project);
 			}else{
 				$("#postgraduate_proportion").val(0);
 			}
 			/*  本科生层次 */
 			if(data.undergraduate_proportion !="" && data.undergraduate_proportion !=null){
 				$("#undergraduate_proportion").val(data.undergraduate_proportion);
 			}else{
 				$("#undergraduate_proportion").val(0);
 			}
 			/*专科生层次  */
 			if(data.specialist_proportion !="" && data.specialist_proportion !=null){
 				$("#specialist_proportion").val(data.specialist_proportion);
 			}else{
 				$("#specialist_proportion").val(0);
 			}
 			/* 学员来源：学校安排推荐 */
 			if(data.school_source !="" && data.school_source !=null){
 				$("#school_source").val(data.school_source);
 			}else{
 				$("#school_source").val(0);
 			}
 			/* 学员来源：零散报道 */
 			if(data.trainee_source !="" && data.trainee_source !=null){
 				$("#trainee_source").val(data.trainee_source);
 			}else{
 				$("#trainee_source").val(0);
 			}
 			/* 每年完成实训的人数 */
 			if(data.train_finish_num !="" && data.train_finish_num !=null){
 				$("#train_finish_num").val(data.train_finish_num);
 			}else{
 				$("#train_finish_num").val("未填写");
 			}
 			/* 顺利就业的学生人数 */
 			if(data.train_employed_num !="" && data.train_employed_num !=null){
 				$("#train_employed_num").val(data.train_employed_num);
 			}else{
 				$("#train_employed_num").val("未填写");
 			}
 			/* 就业范围：大型企业*/
 			if(data.large_enterprise !="" && data.large_enterprise !=null){
 				$("#large_enterprise").val(data.large_enterprise);
 			}else{
 				$("#large_enterprise").val(0);
 			}
 			/*就业范围：中型企业 */
 			if(data.middle_enterprise !="" && data.middle_enterprise !=null){
 				$("#middle_enterprise").val(data.middle_enterprise);
 			}else{
 				$("#middle_enterprise").val(0);
 			}
 			/* 就业范围：小型企业 */
 			if(data.small_enterprise !="" && data.small_enterprise !=null){
 				$("#small_enterprise").val(data.small_enterprise);
 			}else{
 				$("#small_enterprise").val(0);
 			}
 			/* 学生就业时起薪范围 */
 			if(data.salary_range !="" && data.salary_range !=null){
 				$("#salary_range").val(data.salary_range);
 			}else{
 				$("#salary_range").val("未填写");
 			}
 			/* 基地推荐就业 */
 			if(data.base_recommend !="" && data.base_recommend !=null){
 				$("#base_recommend").val(data.base_recommend);
 			}else{
 				$("#base_recommend").val(0);
 			}
 			/* 学员自找就业 */
 			if(data.student_selfask !="" && data.student_selfask !=null){
 				$("#student_selfask").val(data.student_selfask);
 			}else{
 				$("#student_selfask").val(0);
 			}
 			/* 实训管理与考评规范 */id="evaluation_rule4"
 			if(data.evaluation_rule !="" && data.evaluation_rule !=null){
 				var evaluation_rules = data.evaluation_rule.split(",");
	 			var evaluation_rule = "";
	 			for(var i = 0;i<evaluation_rules.length;i++){
	 				if(evaluation_rules[i]==1){
	 					$("#evaluation_rule1").attr("checked","true");
	 				}else if(evaluation_rules[i]==2){
	 					$("#evaluation_rule2").attr("checked","true");
	 				}else if(evaluation_rules[i]==3){
	 					$("#evaluation_rule3").attr("checked","true");
	 				}else if(evaluation_rules[i]==4){
	 					$("#evaluation_rule4").attr("checked","true");
	 				}else if(evaluation_rules[i]==5){
	 					$("#evaluation_rule5").attr("checked","true");
	 				}else if(evaluation_rules[i]==6){
	 					$("#evaluation_rule6").attr("checked","true");
	 				}else if(evaluation_rules[i]==7){
	 					$("#evaluation_rule7").attr("checked","true");
	 				}else if(evaluation_rules[i]==8){
	 					$("#evaluation_rule8").attr("checked","true");
	 				}else if(evaluation_rules[i]==9){
	 					$("#evaluation_rule9").attr("checked","true");
	 				}else if(evaluation_rules[i]==10){
	 					$("#evaluation_rule10").attr("checked","true");
	 				}else if(evaluation_rules[i]==11){
	 					$("#evaluation_rule11").attr("checked","true");
	 				}
	 			}
 			}
 			
 		}
 	</script>
 	
  </head>
  
<body style="background:#dfe9f7;height:100%;width:100%">
<div class="baseCoach">
    <section class="column">
        <div class="term baseEffect">
            <span class="imgBtn"></span><h1 class="resultTitle">实训项目分布</h1>
            <div class="resultInfo">
                <span>实际使用的项目数<input type="text" class="baseNeedInfo" id="project_inuse"/>项</span>
                <span class="blank" style="width:120px"></span>
                <span>实训效果较好的项目数<input type="text" class="baseNeedInfo" id="good_project"/>项</span><br/>
                <span>其中自于企业实际产品研发项目<input type="text" class="baseNeedInfo" id="company_project"/>项</span>
                <span class="blank" style="width:36px"></span>
                <span>基地自主研发项目数<input type="text" class="baseNeedInfo" id="selfdevelop_project"/>个</span>
            </div>
        </div>
    </section>
    <section class="column">
        <div class="term baseEffect">
            <span class="imgBtn"></span><h1 class="resultTitle">实训学员结构分析与创业就业现状分析(近三年)</h1>
            <div class="resultInfo">
                <span>学员层次:</span>
                <span>研究生占<input type="text" class="baseNeedInfo" id="postgraduate_proportion"/>%</span>
                <span class="blank"  style="width:106px"></span>
                <span>本科生占<input type="text" class="baseNeedInfo" id="undergraduate_proportion"/>%</span>
                <span class="blank"></span>
                <span>专科生占<input type="text" class="baseNeedInfo" id="specialist_proportion"/>%</span><br/>

                <span>就业范围:</span>
                <span>大型企业占<input type="text" class="baseNeedInfo" id="large_enterprise"/>%</span>
                <span class="blank" style="width:90px"></span>
                <span>中型企业占<input type="text" class="baseNeedInfo" id="middle_enterprise"/>%</span>
                <span class="blank" style="width:80px"></span>
                <span>小型企业占<input type="text" value="" class="baseNeedInfo" id="small_enterprise"/>%</span><br/>

                <span>学员来源:</span>
                <span>学校安排推荐占<input type="text" class="baseNeedInfo" id="school_source"/>%</span>
                <span class="blank" style="width:60px"></span>
                <span>学员零散报到参与占<input type="text" class="baseNeedInfo" id="trainee_source"/>%</span><br/>
                <span>每年完成实训的学生人数<input type="text" class="baseNeedInfo" id="train_finish_num" style="width:180px"/></span>
                <span class="blank" style="width:10px"></span>
                <span>其中顺利就业的学生人数<input type="text" class="baseNeedInfo" id="train_employed_num" style="width:200px"/></span><br/>

                <span>就业质量:</span>
                <span>基地推荐就业占<input type="text" class="baseNeedInfo" id="base_recommend"/>%</span>
                <span class="blank" style="width:60px"></span>
                <span>学员自找工作占<input type="text" class="baseNeedInfo" id="student_selfask"/>%</span><br/>
                <span>学生就业时起薪范围<input type="text" class="baseNeedInfo" id="salary_range" style="width:200px"/></span>

            </div>
        </div>
    </section>
    <section class="column ">
        <div class="term baseEffect">
            <span class="imgBtn"></span><h1 class="resultTitle">实训管理与考评规范</h1>
            <div class="resultInfo">
                <input type="checkbox" id="evaluation_rule1"/><span>精心安排宣传进行招生</span>
                <span class="blank"></span>
                <input type="checkbox" id="evaluation_rule2"/><span>新生入训时通过测试分班</span>
                <span class="blank"></span>
                <input type="checkbox" id="evaluation_rule3"/><span>每个班都有完整合理的实训计划</span><br/>

                <input type="checkbox" id="evaluation_rule4"/><span>学生实训后都提交总结</span>
                <span class="blank"></span>
                <input type="checkbox" id="evaluation_rule5"/><span>学生实训结果文档都有保存</span>
                <span class="blank" style="width:86px"></span>
                <input type="checkbox" id="evaluation_rule6"/><span>每个班都有专门的指导教师</span><br/>

                <input type="checkbox" id="evaluation_rule7"/><span>实训班级的平均人数 40人 </span>
                <span  class="blank" style="width:80px"></span>
                <input type="checkbox" id="evaluation_rule8"/><span>指导教师为每个学生做出评价</span><br/>

                <input type="checkbox" id="evaluation_rule9"/><span>及时向学校反馈意见，并提供材料 </span>
                <span  class="blank"  style="width:30px"></span>
                <input type="checkbox" id="evaluation_rule10"/><span>不合格学员免费接受新的实训 </span><br/>

                <input type="checkbox" id="evaluation_rule11"/><span>已完成的实训实习项目，能向校方提交能代表每个实训项
                目实际训练过程和水平的学生实际成果（包括阶段和最终成果，最好是纸质或电子文档）</span>
            </div>
        </div>
    </section>
</div>
</body>
</html>
