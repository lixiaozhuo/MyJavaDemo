//html数据方式
window.onload = function() {
	var province = document.getElementById("province");
	var ajax = new XMLHttpRequest();
	ajax.open("GET", "linkage", true);
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			province.innerHTML = "<option value='-1'>请选择</option>"
					+ ajax.responseText;
		}
	}
	ajax.send();
	document.getElementById("city").innerHTML = "<option value='-1'>请选择</option>";
	// 省份下拉框改变时改变城市下拉框内容
	province.onchange = function() {
		if (this.value <= 0) {
			document.getElementById("city").innerHTML = "<option value='-1'>请选择</option>";
			return;
		}
		var ajax = new XMLHttpRequest();
		ajax.open("GET", "linkage_getCityById?pid=" + this.value, true);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				document.getElementById("city").innerHTML = ajax.responseText;
			}
		}
		ajax.send();
	}
}