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
     <h1>座位号：${tableNum }</h1>
 <h1>人数：${peopleNum }</h1>
 <table border="1px">
  <tr>
   <td>菜名</td>
   <td>价格</td>
  </tr>
  <c:forEach items="${menuList }" var="menu">
   <tr>
    <td>${menu.getDish() }</td>
    <td>${menu.getPrice() }</td>
   </tr>
  </c:forEach>
 </table>
 <form action="updateOrderPrice" method="get">
  <h1 id="real_total">总价:${totalPrice }</h1>
  <input type="hidden" value="${totalPrice }" name="totalPrice"/>
  <input type="hidden" value="${orderId }" name="orderId"/>
  <br/>
  实收金额：<input type="number" id="ss_total" name="ssPrice"/>
  <br/>
  <h1 type="hidden" id="cj"></h1>
  <input type="submit" value="返回"/> 
 </form>
 <input type="submit" onclick="myFunction()" value="找零" />
 <script>
function myFunction()
{
 var ssTotal =Number.parseFloat(document.getElementById("ss_total").value);
 var realTotal = Number.parseFloat(document.getElementById("real_total").innerText.substring(3));
 var cj = ssTotal-realTotal;
 document.getElementById("cj").innerText = cj;
 alert("应找回零钱:"+cj+"元");
}

</script>  
</body>
</html>