window.onload = function() {
	document.getElementById("username").onblur = function() {
		var ajax = new XMLHttpRequest();
		// 新建请求
		ajax.open("GET", "/checkUsername?username=" + this.value , true);
		// 监听状态改变
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				document.getElementById("msg").innerHTML = ajax.responseText;
			}
		}
		// 发送请求
		ajax.send();
	}
}