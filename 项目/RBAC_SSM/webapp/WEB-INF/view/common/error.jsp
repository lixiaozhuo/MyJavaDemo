<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>PSS</title>
<link href="/style/error_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/system/login.js"></script>
</head>
<body>
	<div id="login_center">
		<div id="login_area">
			<div id="login_box">
				<div id="login_form">
					<H2>出错啦！</H2>
					<span>执行过程中发生了异常：</span>
					<span class="error">${exception.message}</span>
					<span>请联系管理员解决！</span>
					<span>联系电话：</span>
					<span>联系邮件：</span>
					<span>&copy;</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>