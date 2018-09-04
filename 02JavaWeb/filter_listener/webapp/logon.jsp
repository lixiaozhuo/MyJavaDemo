<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>欢迎登录</h1>
		<form action="/logon" method="post">
			账号:
			<input type="text" name="username" /><br/>
			密码:
			<input type="password" name="password" /><br/>
			<input type="submit" value="登录" />
		</form>
	</div>

</body>
</html>