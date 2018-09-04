function showTime() {
	// 创建ajax对象
	var ajax = new XMLHttpRequest();
	/**
	 * method:请求的方法 url:请求的资源名称 asumc:是否异步
	 */
	ajax.open("GET", "http://localhost/getServerTime", true);
	// 监听响应状态
	ajax.onreadystatechange = function() {
		console.log(ajax.readyState);
		if (ajax.readyState == 4) {
			console.log(ajax.responseText);
			document.getElementById("time").innerHTML = ajax.responseText;
		}
	}
	// 发送请求
	ajax.send();
}