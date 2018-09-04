<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug />
	<h1>if标签</h1>
	<s:if test="#age>18">年龄大于18</s:if>
	<s:elseif test="#age<18">年龄小于18</s:elseif>
	<s:else>年龄等于18</s:else>
	<h1>iterator标签方式1</h1>
	<s:iterator value="#list" var="u" status="num">
		<s:property value="#num.count"/>
		<s:property value="#u.username"/>
		<s:property value="#u.age"/>
		<br/>
	</s:iterator>
	<h1>iterator标签方式2</h1>
	<s:iterator value="#list">
		<s:property value="username"/>
		<s:property value="age"/>
		<br/>
	</s:iterator>
	<h1>select标签</h1>
	<s:select list="#{'1':'1a','2':'2a','3':'3a'}"></s:select>
	<h1>checkboxList标签</h1>
	<s:checkboxlist list="#{'1':'1a','2':'2a','3':'3a'}" name="checkbox"/>
</body>
</html>