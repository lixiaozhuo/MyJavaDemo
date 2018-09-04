<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/>
	<s:form namespace="/upload" action="upload" enctype="multipart/form-data">
	上传文件<s:file name="headImg"/><br/>
	<s:submit value="提交"/>
	</s:form>
</body>
</html>