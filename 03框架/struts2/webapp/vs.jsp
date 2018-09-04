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
	<h1>数据在root区域,直接用属性名称取</h1>
	<s:property value="[0]"/><br/>
	type1:<s:property value="[0].top"/><br/>
	type2:<s:property value="type2"/><br/>
	type3:<s:property value="type3"/><br/>
	
	<h1>数据在Context区域,用#+属性名称取</h1>
	list:<s:property value="#list"/><br/>
	list[0]:<s:property value="#list[0]"/><br/>
</body>
</html>