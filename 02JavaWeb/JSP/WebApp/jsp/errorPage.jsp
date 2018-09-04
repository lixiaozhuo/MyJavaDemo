<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	功能出错,请重试
	<%--调用内置对象显示错误原因 --%>
	<%=exception.getMessage() %>
</body>
</html>