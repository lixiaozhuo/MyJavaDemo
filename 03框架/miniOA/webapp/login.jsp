<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="./plugins/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/style.css">
<script src="./plugins/jquery-1.11.2.min.js"></script>
<script src="./plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="./imgs/xiaomage.ico" type="image/x-icon">
<title>员工管理-登录</title>
</head>
<body>
	<s:debug />
	<div class="container">
		<div style="width: 800px; margin-left: auto; margin-right: auto;">
			<div class="row">
				<div class="col-xs-4 accont_logo"></div>
			</div>
			<div class="row">
				<div class="col-xs-8">
					<s:form id="account_register" name="account_register" namespace="/"
						action="login" cssClass="form-horizontal" theme="simple">
						<s:property value="actionErrors"/>
						<div class="form-group">
							<label for="account_register_account_username"
								class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-4">
								<s:textfield name="username"
									id="account_register_account_username" cssClass="form-control"
									placeholder="请输入用户名" />
							</div>
							<div class="col-sm-6"></div>
						</div>
						<div class="form-group">
							<label for="account.password" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-4">
								<s:password name="password"
									id="account_register_account_password" cssClass="form-control"
									placeholder="请输入密码" />
							</div>
							<div class="col-sm-6"></div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<input type="submit" id="account_register_0" value="登录"
									class="btn btn-success login_btn">
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<ul class="list-inline copy-right">
			<li>© 2015－2016</li>
			<li></li>
			<li></li>
			<li>地址：</li>
		</ul>
	</div>
</body>
</html>