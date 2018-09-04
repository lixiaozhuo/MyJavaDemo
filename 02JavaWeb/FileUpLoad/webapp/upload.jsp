<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>注册</h3>
	${errorMsg}
	<form action="/upload" method="post" enctype="multipart/form-data" >
		姓名:<input type="text" name="name"/><br/>
		照片:<input type="file" name="headImg"/><br/>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>