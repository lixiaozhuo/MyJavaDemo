<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String token = UUID.randomUUID().toString();
	session.setAttribute("TOKEN_IN_SESSION",token);
%>
<body>
	<h3>转账</h3>
	<form action="/money" method="post">
		<input type="hidden" name="token" value="<%=token%>"/>
		输入转账金额<input type="text" name="money" />
		<input type="submit" value="转账"/>	
	</form>
</body>
</html>