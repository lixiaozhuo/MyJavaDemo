<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/student?cmd=save" method="post">
			<input type="hidden" name="id" value="${student.id}"/>
			姓名:
			<input type="text" name="username" required="required"
				value="${student.name}" />
			<br /> 年龄:
			<input type="number" name="age" required="required"
				value="${student.age}" />
			<br />
			<input type="submit" value="${ empty student.id ? '注册' : '保存'}" />
		</form>
	</div>
</body>
</html>