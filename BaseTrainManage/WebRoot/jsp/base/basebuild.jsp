<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html  >
  <head>
    <title>My JSP 'base.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/basebuild.js"></script>
 	<script type="text/javascript">
 		
 	</script>
 	
  </head>
  <body style="background:#dfe9f7;height:100%;width:100%">
     <div class="baseBuild" >
        <section class="baseCharacter column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">基地性质</h1>
                <div class="resultInfo">
                     <input type="checkbox" id="base_property1"/><span>培训单位/学校</span>
                     <input type="checkbox" id="base_property2"/><span>研发生产企业</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">基地资格</h1>
                <div class="resultInfo">
                    <p id="base_qualification"></p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">规章制度</h1>
                <div class="resultInfo">
                    <textarea class="editContent" id="main_rule"></textarea>
                </div>
            </div>
        </section>
        <section class="baseManage column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">管理机构</h1>
                <div class="resultInfo">
                    <p id="manage_institution">管理机构完善</p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">发展计划</h1>
                <div class="resultInfo">
                    <p id="development_plan"></p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">建设经费</h1>
                <div class="resultInfo">
                    <span>总额</span>
                    <input type="text" id="construction_funds"/><span>千万</span><br/><br/>
                    <span>经费状况：<span id="financial_situation"></span></span>
                </div>
            </div>
        </section>
        <section class="column unitPersonnel">
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">单位人员</h1>
                <div class="resultInfo personnel">
                    <span>教师人数:</span><input class="numBtn" type="number" id="teacher_num"/><br/>
                    <span>高级职称:</span><input class="numBtn"type="number" id="senior_num"/><br/>
                    <span>中级职称:</span><input class="numBtn"type="number" id="intermediate_num"/><br/>
                    <span>指导教师:</span><input class="numBtn"type="number" id="experienced_teacher"/><br/>
                    <span>管理人员数:</span><input class="numBtn lastNextNum" id="manager_num"/><br/>
                    <span>辅导人员数:</span><input class="numBtn lastNextNum" id="aid_num"/><br/>
                    <span>实训开发人员数:</span><input class="numBtn lastNum"type="number" id="developer_num"/><br/>
                </div>
            </div>
        </section>
    </div>
  </body>
</html>
