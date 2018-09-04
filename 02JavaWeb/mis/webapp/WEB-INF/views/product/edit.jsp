<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎${sessionScope.USER_IN_SESSION.username}进入主页</h1>
	<h3><a href="/logout">注销</a></h3>
	<div align="center">
		<form action="/product?cmd=save" method="post">
			<h3>商品信息</h3>
			<input type="hidden" name=id value="${data.id}" />
			商品名称:
			<input type="text" name="productName" value="${data.productName}"
				required="required" />
			<br />
			类别:
			<select name="dir_id">
				<c:forEach var="dir" items="${dirItems}">
					<option ${data.dir_id == dir.id ? 'selected' : '' }
						value="${dir.id}">${dir.dirName}</option>
				</c:forEach>
			</select>
			<br />
			零售价:
			<input type="number" name="salePrice" value="${data.salePrice}"
				required="required" />
			<br />
			供应商:
			<input type="text" name="supplier" value="${data.supplier}"
				required="required" />
			<br />
			品牌:
			<input type="text" name="brand" value="${data.brand}"
				required="required" />
			<br />
			折扣:
			<input type="number" name="cutoff" value="${data.cutoff}"
				required="required" />
			<br />
			成本价:
			<input type="number" name="costPrice" value="${data.costPrice}"
				required="required" />
			<br />
			<input type="submit" value="保存" />
		</form>
	</div>
</body>
</html>