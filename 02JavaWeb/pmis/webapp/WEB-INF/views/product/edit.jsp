<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/product?cmd=save" method="post">
			<input type="hidden" name="id" value="${obj.id}" />
			<h3>商品信息</h3>
			商品名称:
			<input name="productName" value="${obj.productName}" />
			<br /> 类别:<select name="dir_id">
				<option ${obj.dir_id == 2?'selected':''} value="2">无线鼠标</option>
				<option ${obj.dir_id == 3?'selected':''} value="3">有线鼠标</option>
				<option ${obj.dir_id == 4?'selected':''} value="4">游戏鼠标</option>
			</select><br /> 零售价:
			<input name="salePrice" value="${obj.salePrice}" />
			<br /> 供应商:
			<input name="supplier" value="${obj.supplier}" />
			<br /> 品牌:
			<input name="brand" value="${obj.brand}" />
			<br /> 折扣:
			<input name="cutoff" value="${obj.cutoff}" />
			<br /> 成本价:
			<input name="costPrice" value="${obj.costPrice}" />
			<br />
			<input type="submit" value="${empty objj.id?'保存':'更新'}" />
		</form>
	</div>
</body>
</html>