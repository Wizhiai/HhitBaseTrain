<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>场地与设施条件</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/basefield.js"></script>
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
		                <span>硬件设备状况:</span><p id="machine_situation" style="display:inline;margin-left: 5px;"></p><br/>
		                
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">软件设施</h1>
		            <div class="resultInfo">
		                <span>软件先进程度自我评价:</span><p id="software_selfevaluation" style="display:inline;margin-left: 5px;"></p><br/>
		                <span>软件实训需求情况:</span><p id="software_demand" style="display:inline;margin-left: 5px;"></p><br/>
		                
		            </div>
		        </div>
		    </section>
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">饮食住宿</h1>
		            <div class="resultInfo">
		                <span>食堂归属:</span><p id="canteen_belong" style="display:inline;margin-left: 5px;"></p><br/>
		                <span>宿舍归属:</span><p id="dormitory_belong" style="display:inline;margin-left:5px;"></p><br/>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">学生管理现状</h1>
		            <div class="resultInfo">
		                <p id="student_manage"></p>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">清洁卫生</h1>
		            <div class="resultInfo">
		                <p id="clean_manage"></p>
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
		</div>
	</body>
</html>
