<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.w {
	width: 100px;
}
</style>
<script type="text/javascript">
	function goPage(num){
		var form = document.forms[0];
		form.currentPage.value = num;
		//提交表单
		form.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<form action="/product" method="post">
			<table border="1">
				<caption>商品列表</caption>
				<tr>
					<td colspan="9" align="center">
						名称:
						<input class="w" type="text" name="name"
							value="${queryObject.name}" />
						价格:
						<input class="w" type="number" name="minPrice"
							value="${queryObject.minPrice}" />
						-
						<input class="w" type="number" name="maxPrice"
							value="${queryObject.maxPrice}" />
						分类 :
						<select class="w" name="dir_id">
							<option value="0">====请选择===</option>
							<option value="2" ${queryObject.dir_id==2 ? 'selected' : ''}>无线鼠标</option>
							<option value="3" ${queryObject.dir_id==3 ? 'selected' : ''}>有线鼠标</option>
							<option value="4" ${queryObject.dir_id==4 ? 'selected' : ''}>游戏鼠标</option>
						</select>
						关键字:
						<input class="w" type="text" name="keyword"
							value="${queryObject.keyword}" />
						<input type="button" value="搜索" onclick="goPage(1)"/>

					</td>
				</tr>
				<tr>
					<td colspan="9" align="center">
						<a href="/product?cmd=edit">新增商品</a>
					</td>
				</tr>
				<tr style="background-color: orange;">
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
				<c:forEach items="${result.data}" var="product" varStatus="num">
					<tr align="center"
						style="background-color: ${num.count%2 == 0?'gray':''};">
						<td>${product.id}</td>
						<td>${product.productName}</td>
						<td>${product.dirName()}</td>
						<td>${product.salePrice}</td>
						<td>${product.supplier}</td>
						<td>${product.brand}</td>
						<td>${product.cutoff}</td>
						<td>${product.costPrice}</td>
						<td>
							<a href="/product?cmd=edit&id=${product.id}">编辑</a>
							<a href="/product?cmd=delete&id=${product.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="9" align="center">
						<c:choose>
							<c:when test="${result.currentPage > result.firstPage}">
								<a href="javascript:goPage(${result.firstPage});">首页</a>
								<a href="javascript:goPage(${result.prvePage});">上一页</a>
							</c:when>
							<c:otherwise>
						首页  上一页
						</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${result.currentPage < result.endPage}">
								<a href="javascript:goPage(${result.nextPage});">下一页</a>
								<a href="javascript:goPage(${result.endPage});"> 尾页</a>
							</c:when>
							<c:otherwise>
						下一页 尾页
						</c:otherwise>
						</c:choose>
						总共${result.totalCount}条记录
						当前是${result.currentPage}/${result.endPage}页 直达
						<input class="w" type="text" name="currentPage" value=""/>
						页
						<input type="submit" value="go" />
						<select name="pageSize" onchange="goPage(1)">
							<option value="3" ${result.pageSize==3 ? 'selected' : ''}>3</option>
							<option value="5" ${result.pageSize==5 ? 'selected' : ''}>5</option>
							<option value="8" ${result.pageSize==8 ? 'selected' : ''}>8</option>
							<option value="10" ${result.pageSize==10 ? 'selected' : ''}>10</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>