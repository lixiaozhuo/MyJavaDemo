<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = 10;
		pageContext.setAttribute("num", num);
		pageContext.setAttribute("list", Arrays.asList("a", "b", "c"));
		pageContext.setAttribute("s1", new String("s"));
		pageContext.setAttribute("s2", new String("s"));
	%>
	<h3>if语句</h3>
	<c:if test="${num == 5}">
		等于5
	</c:if>
	<hr />
	<h3>if语句结果</h3>
	<c:if test="${num == 5}" var="test" scope="page" />
	对比结果:${pageScope.test}
	<hr />
	<h3>多重if语句</h3>
	<c:choose>
		<c:when test="${num < 5} }">
			小于5
		</c:when>
		<c:when test="${num > 5 }">
			大于5
		</c:when>
		<c:otherwise>
			等于5
		</c:otherwise>
	</c:choose>
	<hr />
	<h3>运算符</h3>
	对象是否为空:${!empty list} 
	<br/>
	等号:${s1 == s2 }
	<br/>
	eq:
	${s1 eq s2 }
</body>
</html>