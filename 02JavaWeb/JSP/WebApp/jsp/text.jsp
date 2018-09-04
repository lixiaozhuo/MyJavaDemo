<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--jsp注释,在页面上无法显示和查看 --%>
	<%--java脚本片段 --%>
	<%
		int i = 0;
		System.out.println(i);
	%>
	<%--脚本表达式 --%>
	北京时间<%=new java.util.Date()%>

	<%-- jsp声明--%>
	<%!private String name;

	public void doWork() {
	}%>
</body>
</html>