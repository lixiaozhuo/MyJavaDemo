<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	function changeImg(ele){
		ele.src="/randomCode?" + new Date().getTime();
		console.log(ele);
	}
</script>
<body>
	<h3>登录</h3>
	<span style="color:red">${errorMsg}</span>
	<form action="/logon" method="POST">
		账号:
		<input type="text" name="username" required="required" />
		<br />
		密码:
		<input type="password" name="password" required="required" />
		<br />
		验证码<input type="text" name="randomCode" maxlength="5" size="10px" />
		<img src="/randomCode" title="刷新" onclick="changeImg(this)"/>
		<br/>
		<input type="submit" value="登录" />
	</form>
</body>
</html>