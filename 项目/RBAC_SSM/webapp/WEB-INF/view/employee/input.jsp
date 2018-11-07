<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="/style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/commonAll.js"></script>
<script type="text/javascript" src="/js/system/employee.js"></script>
</head>
<body>
	<form name="editForm" namespace="/" action="employee_save"
		method="post" id="editForm">
		<input type="hidden" name="id" value="${employee.id}" />
		<div id="container">
			<div id="nav_links">
				<span style="color: #1A5CC6;">用户编辑</span>
				<div id="page_close">
					<a>
						<img src="/images/common/page_close.png" width="20" height="20"
							style="vertical-align: text-top;" />
					</a>
				</div>
			</div>
			<div class="ui_content">
				<table cellspacing="0" cellpadding="0" width="100%" align="left"
					border="0">
					<tr>
						<td class="ui_text_rt" width="140">用户名</td>
						<td class="ui_text_lt">
							<input type="text" name="name" cssClass="ui_input_txt02"
								value='${employee.name}' />
						</td>
					</tr>
					<c:if test="${employee.id==null}">
						<tr>
							<td class="ui_text_rt" width="140">密码</td>
							<td class="ui_text_lt">
								<input type="password" name="password" id="password"
									cssClass="ui_input_txt02" value='${employee.password}' />
							</td>
						</tr>
						<tr>
							<td class="ui_text_rt" width="140">验证密码</td>
							<td class="ui_text_lt">
								<input type="password" name="repassword"
									cssClass="ui_input_txt02" />
							</td>
						</tr>
					</c:if>
					<tr>
						<td class="ui_text_rt" width="140">E-mail</td>
						<td class="ui_text_lt">
							<input type="text" name="email" cssClass="ui_input_txt02"
								value='${employee.email}' />
						</td>
					</tr>
					<tr>
						<td class="ui_text_rt" width="140">年龄</td>
						<td class="ui_text_lt">
							<input type="text" name="age" cssClass="ui_input_txt02"
								value='${employee.age}' />
						</td>
					</tr>
					<tr>
						<td class="ui_text_rt" width="140">所属部门</td>
						<td class="ui_text_lt">
							<select name="dept.id" class="ui_select01">
								<c:forEach items="${depts}" var="d">
									<option value="${d.id}"
										${employee.dept.id == d.id?'selected':''}>${d.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="ui_text_rt" width="140">超级管理员</td>
						<td class="ui_text_lt">
							<input type="checkbox" name="admin" 
								class="ui_checkbox01" ${employee.admin==true?'checked':''} />
						</td>
					</tr>
					<tr>
						<td class="ui_text_rt" width="140">角色</td>
						<td class="ui_text_lt">
							<table>
								<tr>
									<td>
										<form:select name="" path="roles" multiple="true"
											cssClass="ui_multiselect01 all_roles">
											<form:options items='${roles}' itemValue="id"
												itemLabel="name" />
										</form:select>
									</td>
									<td align="center">
										<input type="button" id="select" value="--->"
											class="left2right" />
										<br />
										<input type="button" id="selectAll" value="==>"
											class="left2right" />
										<br />
										<input type="button" id="deselect" value="<---"
											class="left2right" />
										<br />
										<input type="button" id="deselectAll" value="<=="
											class="left2right" />
									</td>
									<td>
										<form:select name="roleId" path="roles" multiple="true"
											cssClass="ui_multiselect01 selected_roles">
											<form:options items='${employee.roles}' itemValue="id"
												itemLabel="name" />
										</form:select>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td class="ui_text_lt">
							&nbsp;
							<input type="submit" value="保存编辑" class="ui_input_btn01" />
							&nbsp;
							<input type="reset" id="cancelbutton" value="重置"
								cssClass="ui_input_btn01" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>