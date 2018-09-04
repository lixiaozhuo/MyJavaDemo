<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>购物车</caption>
		<tr>
			<th>名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>小记</th>
			<th>操作</th>
		</tr>
		<c:forEach var="cartItem" items="${shoppingCart.list}">
			<tr>
				<td>${cartItem.name}</td>
				<td>${cartItem.price}</td>
				<td>${cartItem.num}</td>
				<td>${cartItem.totalPrice}</td>
				<td>
					<a href="/shopping?cmd=delete&id=${cartItem.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<a href="/shopping/index.jsp">继续加入商品</a>
				总价:${shoppingCart.totalPrice}			
			</td>
		</tr>

	</table>
</body>
</html>