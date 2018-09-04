window.onload = function() {
	document.getElementById("username").onblur = function() {

	}
}
function submit() {
	var ajax = new XMLHttpRequest();
	// 新建请求
	ajax.open("POST", "/login", true);
	// 监听状态改变
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			//window.location.href = "main"
		}
	}
	// 发送请求
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var data = "username=" + username + "&password=" + password;
	console.log(data);
	ajax.send(data);
}