<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	body{	
	    background-image: url(img/login13.jpg);
	    background-repeat: no-repeat;
	    background-size: 1500px 750px;
    }
    div{ 	    
	    border: 1px solid #0c0c0c;
	    width: 600px;
	    height: 600px;
	    margin-left: 0px;
	    margin-top: 7px;
	    border-radius: 22px;
	    box-shadow: 2px 2px 2px #a7a7a9;
    }
    input{
	    line-height: 20px;
	    width: 10%;
	    margin-bottom: 30px;
	    }
	     form{    	
	    margin: 0 auto;
	    width: 90%;
	    margin-top: 26px;
    }
    .login_button{    	
	    height:30px;
	    border-radius: 25px;
	    border: 0;
	    background-color:rgb(197, 239, 247);
	    box-shadow: 1px 1px 3px #cccccc;
	    border: 1px solid #999999;
	    </style>
</head>
<body>
	<input type="button" class="login_button" value="用户管理" onclick="window.open('userlist')"/>
	<input type="button" class="login_button" value="座位号管理" onclick="window.open('tablelist')"/>
	<input type="button" class="login_button" value="菜单管理" onclick="window.open('menulist')"/>
	<input type="button" class="login_button" value="订单查询" onclick="window.open('selectorder')"/>
	
	<div>
		<form action="placeorder" method="post" onSubmit="return check();">
			座位号：
				<select name="tableNum">
					<c:forEach items="${tableList }" var="table">
						<option value="${table.getTableNum() }">${table.getTableNum() }</option>
					</c:forEach>
				</select>
			人数：<input type="number" name="peopleNum"/>
			<br/>
			菜品：
				<c:forEach items="${menuList }" var="menu">
					<input type="checkbox" name="menu" value="${menu.getId() }"/>${menu.getDish() }(${menu.getPrice() })
				</c:forEach>
			<br/>
			<input type="submit" class="login_button" value="下单"/>
			
		</form>
	</div>

</body>
</html>