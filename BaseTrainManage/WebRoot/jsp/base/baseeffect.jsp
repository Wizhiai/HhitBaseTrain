<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>实践效果与能力开发</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/baseeffect.js"></script>
 	<script type="text/javascript">
 		
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
