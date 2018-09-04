<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goPage(num) {
		var form = document.forms[0];
		form.currentPage.value = num;
		form.submit();
	}
</script>
</head>
<body>
	<h1>欢迎${sessionScope.USER_IN_SESSION.username}进入主页</h1>
	<h3><a href="/logout">注销</a></h3>
	<div align="center">
		<form action="/product" method="post">
			<table border="1">
				<caption>商品列表</caption>
				<thead>
					<tr>
						<th colspan="9">
							<a href="/product?cmd=edit">新建</a>
						</th>
					</tr>
					<tr>
						<td colspan="9">
							名称:
							<input type="text" name="name" value="${query.name}" />
							价格:
							<input type="number" name="minPrice" value="${query.minPrice}" />
							-
							<input type="number" name="maxPrice" value="${query.maxPrice}" />
							分类:
							<select name="dir_id">
								<option value="0">请选择</option>
								<c:forEach var="dir" items="${dirItems}">
									<option ${query.dir_id == dir.id ? 'selected' : '' }
										value="${dir.id}">${dir.dirName}</option>
								</c:forEach>
							</select>
							关键字:
							<input type="number" name="keyword" value="${query.keyword}" />
							<input type="submit" value="搜索" />
						</td>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td colspan="9">
							<c:choose>
								<c:when test="${result.currentPage-1 >= result.firstPage}">
									<a href="javascript:goPage(${result.firstPage})">首页</a>
									<a href="javascript:goPage(${result.prvePage})">上一页</a>
								</c:when>
								<c:otherwise>
									首页
									上一页
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${result.currentPage+1 <= result.endPage}">
									<a href="javascript:goPage(${result.nextPage})">下一页</a>
									<a href="javascript:goPage(${result.endPage})">尾页</a>
								</c:when>
								<c:otherwise>
									下一页
									尾页
								</c:otherwise>
							</c:choose>
							${result.currentPage}/${result.endPage}页 共${result.totalCount}条数据
							<input type="text" name="currentPage" />
							页
							<input type="submit" value="跳转" />
							<select name="pageSize" onchange="goPage(1)">
								<option value="3" ${result.pageSize == 3 ? 'selected' : ''}>3</option>
								<option value="5" ${result.pageSize == 5 ? 'selected' : ''}>5</option>
								<option value="10" ${result.pageSize == 10 ? 'selected' : ''}>10</option>
							</select>
						</td>
					</tr>
				</tfoot>
				<tbody>
					<tr>
						<th>编号</th>
						<th>商品名称</th>
						<th>分类</th>
						<th>零售价</th>
						<th>供应商</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>成本价</th>
						<th>操作</th>
					</tr>
					<c:forEach var="data" items="${result.data}">
						<tr>
							<td>${data.id}</td>
							<td>${data.productName}</td>
							<td>${data.dirName()}</td>
							<td>${data.salePrice}</td>
							<td>${data.supplier}</td>
							<td>${data.brand}</td>
							<td>${data.cutoff}</td>
							<td>${data.costPrice}</td>
							<td>
								<a href="/product?cmd=edit&id=${data.id}">编辑</a>
								<a href="/product?cmd=delete&id=${data.id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>