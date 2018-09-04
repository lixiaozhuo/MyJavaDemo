$(function() {
	// 添加数据
	$("#btn_submit").click(function() {
		var uid = new Date().getTime();
		var data = "<tr id=" + uid + ">" + 
		"<td>" + $("#username").val() + "</td>" +
		"<td>" + $("#email").val() + "</td>" +
		"<td>" + $("#tel").val() + "</td>" + 
		"<td><a href=\"javascript:delRow('" + uid  + "')\">删除</a></td>"+
		"</tr>";
		$("#userTbody").append(data);
	});

	$("#btn_removeAll").click(function() {
		$("#userTbody").empty();
	});
});
// 单条记录 删除
function delRow(id) {
	$("#" + id).remove();
}

