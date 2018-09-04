<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE">
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
<title>员工管理-首页</title>
<script type="text/javascript">
	function goPage(num) {
		document.getElementById("currentPage").value = num;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<s:debug />
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#">欢迎<s:property value="#session.USER_IN_SESSION.username"/>登录</a>
				</li>
				<li>
					<a href="#">注册</a>
				</li>
				<li>
					<a href="#">注销</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="searchbar">
		<div class="searchbar_container">
			<div class="row">
				<div class="col-xs-3">
					<img alt="" src="imgs/logo.png">
				</div>
			</div>
		</div>
	</div>
	<div class="container index_content">
		<div class="col-xs-12 index_right">
			<div class="content-container">
				<div class="content-container-head">
					<h4>高级查询</h4>
				</div>
			</div>
			<s:form class="form-inline" role="form" namespace="/"
				action="employee" theme="simple">
				<s:hidden id="currentPage" name="qo.currentPage" />
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="姓名或邮箱" name="qo.keyword" />
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="开始日期" name="qo.beginDate" />
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="结束日期" name="qo.endDate" />
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</s:form>
			<div class="row" style="padding-top: 20px;">
				<table class="table table-hover">
					<tr>
						<th>编号</th>
						<th>用户名</th>
						<th>邮箱</th>
						<th>雇佣日期</th>
						<th>工资</th>
						<th>操&emsp;&emsp;作</th>
					</tr>
					<s:iterator value="#result.data">
						<tr>
							<td>
								<s:property value="id" />
							</td>
							<td>
								<s:property value="username" />
							</td>
							<td>
								<s:property value="email" />
							</td>
							<td>
								<s:property value="hiredate" />
							</td>
							<td>
								<s:property value="salary" />
							</td>
							<td>
								<s:a namespace="/" action="employee_input">编辑
									<s:param name="employee.id" value="id" />
								</s:a>
								|
								<s:a namespace="/" action="employee_delete">删除
									<s:param name="employee.id" value="id" />
								</s:a>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<nav>
			<ul class="pagination">
				<li>
					<a>
						共
						<s:property value="#result.totalCount" />
						条数据 当前页:
						<s:property value="#result.currentPage" />
						/
						<s:property value="#result.endPage" />
					</a>
				</li>
				<li>
					<a href="javascript:goPage(<s:property value="#result.firstPage"/>)">首页
					</a>
				</li>
				<li>
					<a href="javascript:goPage(<s:property value="#result.prvePage"/>)">上一页
					</a>
				</li>
				<li>
					<a href="javascript:goPage(<s:property value="#result.nextPage"/>)">下一页
					</a>
				</li>
				<li>
					<a href="javascript:goPage(<s:property value="#result.endPage"/>)">尾页
					</a>
				</li>
			</ul>
		</nav>
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