<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.net.httpserver.HttpContext"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link type="text/css" rel="stylesheet" href="../css/asSystemstyle.css" />
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/asSystemmenu.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type="text/javascript">


</script>



</head>

<body>

<div class="top"></div>
<div id="header">
	<div class="logo">后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href=""><%=request.getParameter("id") %></a></li>
			<li><a href="../jsp/baseValueLogin.jsp">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li   class="select"  >      
          <h4 class="M1"><span></span><a onclick="changeSrcaUserManage()">实训基地评估</a></h4>       
        <div class="list-item none" />
        </li>       
        <li>  
         <h4 class="M1"><span></span><a onclick="changeSrcaExpertManage()">专家库管理</a></h4>
         
        </li>
        <li>
       <h4 class="M1"><span></span>系统公告</h4>
          <div class="list-item none"></div>
        </li>
            
				<li>
           <h4 class="M1"><span></span>系统公告</h4>
        </li>
			
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="../images/home.png"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								
								<li><a  href="#" id="p">最新公告</a></li>
						</ul>
			</div>
			
			<div class="main">
<iframe id="frameBord" name="frameBord" frameborder="0" width="100%" height="100%" marginwidth="10px" marginheight="10px" src="http://www.baidu.com" />
			
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2016 版权所有 淮海工学院  来源:<a href="http://www.mycodes.net/" target="_blank">YouZhi</a></p></div>
<script>navList(12);</script>
</body>
</html>
