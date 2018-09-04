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
	<s:a namespace="/download" action="download">进度.xlsx
		<s:param name="filename" value="%{'进度.xlsx'}"></s:param>
	</s:a>
</body>
</html>