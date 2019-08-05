<%@page import="java.util.List"%>
<%@page import="com.Tech.bean.Table"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>座位号列表</title>
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
<table border=1>
<caption>座位列表</caption> <!-- caption 标签必须紧随 table 标签之后。您只能对每个表格定义一个标题。通常这个标题会被居中于表格之上。 -->
   <col></col><col></col><col></col><col class="price" align="right"></col><col></col>
    <thead> 
      <tr>
                    <th >座位号</th>
                    <th >可坐人数</th>
                    <th >操作</th>
                </tr>
    </thead>
    <tbody>
    <c:forEach items="${result}" var="table">
    <tr>
      <td>${table.getTableNum()}</td>
      <td>${table.getPeopleNum()}</td> 
      <td style="text-align:center"> <input type="button"  class="login_button" value="delete" onclick="window.open('deletetable?id=${table.getId() }')" /> </td>  
    </tr>
    </c:forEach> 
    </tbody>  
    </table>
    
    <form action = "addtable"  method="get">
    <input type="text"   placeholder="请输入新座位号" name="table" />
    <input type="text"   placeholder="请输入人数" name="people" />
    <input type="submit" class="login_button2"  value="添加座位" />
    </form>
    </div>
</body>
</html>