<%@page import="com.lixiaozhuo.el.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("user",new User());	
	%>
	
	<h3>取出共享在作用域中user对象</h3>
	User对象:${user}<br/>
	id:${user.id }<br/>
	name:${user.name }<br/>
	hobby:${user.hobby[2] }<br/>
	list:${user.list[3] }<br/>
	map:${user.map["com.lixiaozhuo"] }<br/>
</body>
</html>