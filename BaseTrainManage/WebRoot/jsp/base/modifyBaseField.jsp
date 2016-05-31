<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑场地与设施条件信息</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/modifyBaseField.js"></script>
 	<script type="text/javascript">
 		
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
		        
		    </section>
		         <input type="button" class="editBtn" id="update" value="保存"  style='margin-top:-600px; margin-left:1040px;'>
		</div>
	</body>
</html>
