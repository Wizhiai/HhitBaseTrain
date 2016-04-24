<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>登录界面</title>
    <style type="text/css">
    body{
     margin:0px;
     padding:0px;
     font-size:15px;
     text-align:center;
     font-family:'微软雅黑','文泉驿正黑','黑体';
     background-color:#84c1ff;
    }
     #container{
      width:980px;
      position:relative;
      
      }  
    #login{
     position:absolute;
     top:50%;
     left:50%;
     width:539px;
     height:263px;
     background-image:url(../image/login.png);
     margin-top:200px;
    }
    form{
    margin-top:100px;
    margin-left:60px;
    color:#4169e1;
    }
    #input input{
      width:160px;
      height:25px;
      border:2px solid #00bfff;
    }
    
    #input2{
      margin-top:10px;
    
    }
    #btn{
      margin-top:15px;
      margin-left:20px;
    }
   #btn1{
       margin-right:30px;
    }
    #btn input{
      width:71px;
      height:26px;
      background-image:url("../image/btn_bg.png");
     color:#fff;
     border:0px;
     
    }
    </style>
    <script type="text/javascript" src="../js/cookie_util.js"></script>
     <script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="../js/login.js"> </script>
  </head>
  <body>
  <div id="container" align="center">
      <div id="login" align="center">
        <form>
          <div id="input">
            <div id="input1">
              <label for="username">用&nbsp;户&nbsp;名:&nbsp;</label>
              <input type="text" id="username"/><br/>
            </div>
            <div id="input2">
              <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</label>
              <input type="password" id="password"/><br/>
            </div>
          </div>
          <div id="btn">
            <span id="btn1">
              <input type="button" value="登录" id="login1">
            </span>
            <span id="btn2">
              <input type="button" value="退出" onclick="window.close();">
            </span>
          </div>
        </form>
       
      </div>
     
  </div>

  </body>
</html>
