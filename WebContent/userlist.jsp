<%@page import="java.util.List"%>
<%@page import="com.Tech.bean.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
<style type="text/css">
body{	
	    background-image: url('img/5.jpg');
	    background-repeat: no-repeat;
	    background-size: 100%;
    }
table {
    width:100%;
    background-color: #FFF;
    border: none;
    color: #565;
    font: 18px arial;
    text-align:center;
}

table caption {
    font-size: 38px;
    border-bottom: 3px solid #B3DE94;
    border-top: 3px solid #B3DE94;
}

table, td, th {
    margin: 0;
    margin-left:auto;
    margin-right:auto;
    margin-top:30px;
    padding: 0;
    vertical-align: middle;
    text-align:center;
}

tbody td, tbody th {
    background-color: #DFC;
    border-bottom: 2px solid #B3DE94;
    border-top: 3px solid #FFFFFF;
    padding: 9px;
}


tfoot td, tfoot th {
    font-weight: bold;
    padding: 4px 8px 6px 9px;
    text-align:center;
}

thead th {
    font-size: 14px;
    font-weight: bold;
    line-height: 19px;
    padding: 0 8px 2px;
    text-align:center;
}

td+td+td, /*第三个td以及之后的td元素*/
col.price{ /*类样式*/
    text-align:right;
}

tbody tr:hover td, tbody tr:hover th { /*tr也有hover样式*/
    background-color: #8b7;
    color:#fff;
}

div{	    
	    width: 573px;
	    height: 400px;
	    margin:0 auto;
	    margin-top: 50px;
	    
}
form{    	
	    margin: 0 auto;
	    width: 100%;
	    margin-top: 15px;
	    text-align:center;
    }
.login_button{   	
	    height: 28px;
	    margin:0 auto;
	    border-radius: 10px;
	    border: 0;
	    background-color: rgb(200, 247, 197);
	    font: 18px arial;
	    }
	    .login_button2{   	
	    height: 22px;
	    margin:0 auto;
	    border-radius: 10px;
	    border: 0;
	    background-color: rgb(200, 247, 197);
	    font: 14px arial;
	    }
</style>
</head>
<body>
<div>
<table border="1">
<caption>用户列表</caption>
<col></col><col></col><col></col><col class="price" align="right"></col><col></col>
<thead> 
      <tr>
                    <th >用户名</th>
                    <th >密码</th>
                    <th >操作</th>
                </tr>
    </thead>
    <tbody>
<c:forEach items ="${result }" var="abc">
<tr>
<td>${abc.getUserName() }</td>
<td>${abc.getPassWord() }</td>
<td style="text-align:center"><input type="button" class="login_button" value="delete" onclick="window.open('deleteuser?id=${abc.getId() }')" /></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>
