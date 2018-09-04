<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>登录</h3>
	<form action="/parm/type" method="post">
		用户名:
		<input type="text" name="user.username" />
		<br />
		年龄
		<input type="text" name="user.age" />
		<br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>