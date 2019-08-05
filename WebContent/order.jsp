<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <h1>展示所有的订单</h1>
 <table>
 	<tr>
 		<td>订单id</td>
 		<td>座位号</td>
 		<td>人数</td>
 		<td>实收金额</td>
 		<td>原本价格</td>
 		<td>差价金额</td>
 		<td>菜品</td>
 		<td>操作</td>
 	</tr>
 			<c:forEach items="${orderList}" var="order">
			<tr>
			<td>${order.getId() }</td>
 			<td>${order.getTableNum() }</td>
 			<td>${order.getRealPeople() }</td>
 			<td>${order.getSsPrice() }</td>
 			<td>${order.getTotalPrice() }</td>
 			<td>${order.getCjPrice()}</td>	
            <td>${order.getMenus() }</td>
		        <c:if test="${order.getSsPrice() == 0 }">
		        	<form action="pay" method="get">
		        <td> 实收金额：<input type="number"  name="ss"/></td> 
		        <td><input type="hidden" value="${order.getTotalPrice() }" name="totalPrice"/></td>
		        <td><input type="hidden" value="${order.getId() }" name="orderId"/> </td>
		        <td><input type="submit" value="结账"/></td>
		        	</form>
		       </c:if>
			</tr>
		</c:forEach>
 </table>
 
</body>
</html>