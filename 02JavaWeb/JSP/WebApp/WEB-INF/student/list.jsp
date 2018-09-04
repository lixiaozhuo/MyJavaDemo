<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" import="com.lixiaozhuo.smis.domain.*"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> list = (List<Student>) request
				.getAttribute("LIST_IN_REQ");
	%>

	<table border="1" style="">
		<caption>学生信息表</caption>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>

		<%
			for (Student stu : list) {
		%>
		<tr>
			<td><%=stu.getId()%></td>
			<td><%=stu.getName()%></td>
			<td><%=stu.getAge()%></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>