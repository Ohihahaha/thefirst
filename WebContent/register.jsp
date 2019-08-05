<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册新用户</title>
<style type="text/css">
	body{	
	    background-image: url('img/log.gif');
	    background-repeat: no-repeat;
	    background-size: 100%;
    }
    div{	    
	    border: 1px solid rgb(189, 195, 199);
	    width: 573px;
	    height: 300px;
	    margin-left:80px;
	    margin-top: 100px;
	    border-radius: 22px;
	    box-shadow: 2px 2px 2px #a7a7a9;
	    background:white; filter:alpha(opacity:30); opacity:0.8;-moz-opacity:0.3;-khtml-opacity: 0.3;
    }
    input{
	    line-height: 27px;
	    width: 100%;
	    margin-bottom: 40px;
    }
    form{    	
	    margin: 0 auto;
	    width: 50%;
	    margin-top: 46px;
	    filter:alpha(opacity:30); opacity:1;-moz-opacity:0.3;-khtml-opacity: 0.3;
    }
    .login_button{    	
	    height: 36px;
	    border-radius: 25px;
	    border: 0;
	    background-color:rgb(252, 214, 112);
	    box-shadow: 1px 1px 3px #cccccc;
	    border: 1px solid #999999;
	    color:rgb(46, 49, 49);
    }
    .inputAttr1{
    background: url('img/zhuce.png');
    background-position-x:8px;
    background-position-y:9px;
    background-size:6%;
    background-repeat:no-repeat;
    width: 265px;
    height: 35px;
    border-radius:5px;
    border: 1px solid #999999;
    box-shadow: 1px 1px 3px #cccccc;
    margin-right: 10px;
    padding-left: 32px;
    
}
.inputAttr2{
    background: url('img/mimasuo.png');
    background-position-x:5px;
    background-position-y:7px;
    background-size:8%;
    background-repeat:no-repeat;
    width: 265px;
    height: 35px;
    border-radius:5px;
    border: 1px solid #999999;
    box-shadow: 1px 1px 3px #cccccc;
    margin-right: 10px;
    padding-left: 32px;
    
}
</style>
</head>
<body>
<div>
<form action="Register" method="get">
<input type="text" class="inputAttr1" required="required" name="user1" placeholder="请输入新用户名"/>
<br/>
<input type="password" class="inputAttr2" required="required" name="pass1" placeholder="请输入密码"/>
<br/>
<input type="submit" class="login_button" value="注册"/>
</form>
</div>
</body>
</html>
