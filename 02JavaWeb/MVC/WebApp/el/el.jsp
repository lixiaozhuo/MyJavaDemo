<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/el/user.jsp">user.jsp</a>
	
	<%
		pageContext.setAttribute("msg", "pageContext");
		request.setAttribute("msg", "request");
		session.setAttribute("msg", "session");
		application.setAttribute("msg", "application");
	%>
	
	<h3>取出作用域中的数据</h3>
	pageContext:<%=pageContext.getAttribute("msg")%><br />
	request:<%=request.getAttribute("msg")%><br />
	session:<%=session.getAttribute("msg")%><br />
	application:<%=application.getAttribute("msg")%><br />
	<hr />
	findAttribute:<%=pageContext.findAttribute("msg") == null ? ""
							: pageContext.findAttribute("msg")%>
	<hr />
	EL表达式: ${session.msg}
	<hr />
	<h3>取出指定作用域中的数据</h3>
	${requestScope.msg}
	<hr />
</body>
</html>