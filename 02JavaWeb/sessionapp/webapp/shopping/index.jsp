<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/shopping?cmd=save" method="post">
		商品<select name="id">
			<option value="111">苹果电脑</option>
			<option value="222">Suface</option>
		</select>
		数量<input type="number" name="num" value="1"/><br/>
		<input type="submit" value="加入购物车"/>
	</form>
</body>
</html>