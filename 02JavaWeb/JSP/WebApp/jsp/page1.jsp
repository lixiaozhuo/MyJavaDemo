<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/jsp/errorPage.jsp"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	页面1
	<br />
	<%--静态包含另外一个页面 --%>
	<%@ include file="/jsp/page2.jsp"%>
	
	<%--错误代码 --%>
	<%=5/1 %>
</body>
</html>