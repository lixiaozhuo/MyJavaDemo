<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		pageContext.setAttribute("list", Arrays.asList("a","b","c"));
		pageContext.setAttribute("date", new Date());
	%>
	<h3>日期</h3>
		<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	
	<hr/>
	<h3>循环输出1-5</h3>
	<%--
		forEach
		用法1:
		var 变量名称
		begin 初始值
		end 结束循环的条件
		step 步长
	 --%>
	<c:forEach var="i" begin="1" end="5" step="1">
		${pageScope.i }
	</c:forEach>
	<hr/>
	
	<h3>迭代List集合中的元素</h3>
	<%--
		forEach
		用法2:
		var 变量名称
		items 集合/数组
	 --%>
	 <c:forEach var="i" items="${list }">
	 	${i }
	 </c:forEach>
</body>
</html>