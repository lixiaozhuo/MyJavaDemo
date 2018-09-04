<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/><br/>
	<h1>欢迎登录</h1>
	<s:form namespace="/vali" action="vali">
		<s:text name="username" />:<s:textfield name="username"/>
		<s:text name="password" />:<s:password name="password"/>
		<s:actionerror/>
		<s:submit value="登录"/>
	</s:form>
</body>
</html>