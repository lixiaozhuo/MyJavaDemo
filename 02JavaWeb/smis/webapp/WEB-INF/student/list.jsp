<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1" style="width: 70%">
			<caption>学生信息表</caption>
			<tr>
				<th align="center" colspan="4">
					<a href="/student?cmd=edit">添加</a>
				</th>
			</tr>
			<tr bgcolor="orange">
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:forEach var="stu" items="${list}" varStatus="num">
				<tr align="center" bgcolor="${num.count%2==0 ? 'gray' : ''}">
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.age}</td>
					<td>
						<a href="/student?cmd=delete&id=${stu.id}">删除</a>
						<a href="/student?cmd=edit&id=${stu.id}">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>