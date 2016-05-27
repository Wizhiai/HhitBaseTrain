<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html  >
  <head>
    <title>编辑基地建设与管理状况信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/modifyBaseBuild.js"></script>
 	<script type="text/javascript">

 	</script>
 	
  </head>
  <body style="background:#dfe9f7;height:100%;width:100%">
     <div class="baseBuild" >
        <section class="baseCharacter column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">基地性质</h1>
                <div class="resultInfo">
                    <input type="checkbox" id="base_property1" value="1" name="base_property"/><span>培训单位/学校</span>
                    <input type="checkbox" id="base_property2" value="2" name="base_property"/><span>研发生产企业</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">基地资格</h1>
                <div class="resultInfo">
                    <input type="radio" id="base_qualification1" value="1" name="base_qualification"/><span>生产、营业执照和资质批文齐全</span><br/>
                    <input type="radio" id="base_qualification2" value="2" name="base_qualification"/><span>上述手续正在办理中</span>
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
                		<input type="radio" value="1" id="manage_institution1" name="manage_institution"/><span>管理机构完善</span>
                		<input type="radio" value="2" id="manage_institution2" name="manage_institution"/><span>有管理机构</span><br/>
                    <input type="radio" value="3" id="manage_institution3" name="manage_institution"/><span>无管理机构</span><br/>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">发展计划</h1>
                <div class="resultInfo">
                		<input type="radio" value="1" id="development_plan1" name="development_plan"/><span>建设发展计划完善</span>
                    <input type="radio" value="2" id="development_plan2" name="development_plan"/><span>有建设发展计划</span><br/>
                    <input type="radio" value="2" id="development_plan3" name="development_plan"/><span>无建设发展计划</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">建设经费</h1>
                <div class="resultInfo">
                    <span>总额</span>
                    <input type="text" id="construction_funds"/><span>千万</span><br/>
                    <span>经费状况</span><br/>
                    <input type="radio" value="1" id="financial_situation1" name="financial_situation"/><span>经费全部到位</span><br/>
                    <input type="radio" value="2" id="financial_situation2" name="financial_situation"/><span>经费大部分到位</span><br/>
                    <input type="radio" value="3" id="financial_situation3" name="financial_situation"/><span>经费大部分未到位</span>
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
        <input type="button" class="editBtn clearfix" id="update" value="保存" style='margin-top:-140px; margin-left:1080px;'>
    </div>
  </body>
</html>
