<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/js/commonAll.js"></script>
<title>PSS-账户管理</title>
<style>
.alt td {
	background: black !important;
}
</style>
<script type="text/javascript">
	$(function() {
		$(".btn_input").click(function() {
			window.location.href = $(this).data("url");
		});
		//翻页
		$(".btn_page").click(
				function() {
					$(":input[name='currentPage']").val(
							$(this).data("page")
									|| $(":input[name='currentPage']").val()
									|| 1);
					$("#searchForm").submit();
				});
		//每页多少条数据
		$(":input[name='pageSize']").change(function() {
			$("#searchForm").submit();
		});
	});
</script>
</head>
<body>
	<form id="searchForm" action="/employee" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							姓名
							<input type="text" name="keyword" class="ui_input_txt02"
								value="${qo.keyword}" />
							所属部门
							<select name="deptId" class="ui_select01">
								<option value="-1">请选择</option>
								<c:forEach items="${depts}" var="d">
									<option value="${d.id}" ${qo.deptId == d.id?'selected':''}>${d.name}</option>
								</c:forEach>
							</select>
						</div>
						<div id="box_bottom">
							<input type="button" value="查询" class="ui_input_btn01 btn_page" />
							<input type="button" value="新增" class="ui_input_btn01 btn_input"
								data-url='/employee_input' />
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%"
						align="center" border="0">
						<tr>
							<th width="30">
								<input type="checkbox" id="all" />
							</th>
							<th>编号</th>
							<th>用户名</th>
							<th>EMAIL</th>
							<th>年龄</th>
							<th>所属部门</th>
							<th>角色</th>
							<th></th>
						</tr>
						<tbody>
							<c:forEach items="${pageResult.data}" var="data">
								<tr>
									<td>
										<input type="checkbox" name="IDCheck" class="acb" />
									</td>
									<td>${data.id}</td>
									<td>${data.name}</td>
									<td>${data.email}</td>
									<td>${data.age}</td>
									<td>${data.dept.name}</td>
									<td>${data.roleName}</td>
									<td>
										<a href="/employee_input?id=${data.id}">编辑</a>
										<a href="/employee_delete?id=${data.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04"> ${pageResult.totalCount} </span>
						条记录，当前第
						<span class="ui_txt_bold04"> ${pageResult.currentPage} /
							${pageResult.totalPage} </span>
						页
					</div>
					<div class="ui_frt">
						<input type="button" value="首页" class="ui_input_btn01 btn_page"
							data-page="1" />
						<input type="button" value="上一页" class="ui_input_btn01 btn_page"
							data-page='${pageResult.prevPage}' />
						<input type="button" value="下一页" class="ui_input_btn01 btn_page"
							data-page='${pageResult.nextPage}' />
						<input type="button" value="尾页" class="ui_input_btn01 btn_page"
							data-page='${pageResult.totalPage}' />
						<select name="pageSize" cssClass="ui_select02">
							<option value="5" ${pageResult.pageSize==5?'selected':''}>5</option>
							<option value="10" ${pageResult.pageSize==10?'selected':''}>10</option>
							<option value="20" ${pageResult.pageSize==20?'selected':''}>20</option>
						</select>
						转到第
						<input type="text" name="currentPage" cssClass="ui_input_txt01" />
						页
						<input type="button" class="ui_input_btn01 btn_page" value="跳转" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
