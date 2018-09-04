// xml数据方式
window.onload = function() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var empty = document.createElement("option");
	empty.value = "-1";
	empty.innerHTML = "请选择";

	var ajax = new XMLHttpRequest();
	ajax.open("GET", "linkageXml", true);

	// 获取所有省市数据
	var nodes = ajax.responseXML.documentElement.childNodes;
	// 添加省份数据到下拉框
	for (var i = 0; i < nodes.length; i++) {
		var op = document.createElement("option");
		op.value = nodes[i].id;
		op.innerHTML = nodes[i].innerHTML;
		province.appendChild(op);
	}

	ajax.send();
	city.appendChild(empty);
	// 省份下拉框改变时改变城市下拉框内容
	province.onchange = function() {
		city.innerHTML = "";
		if (this.value <= 0) {
			city.appendChild(empty);
			return;
		}
		var ajax = new XMLHttpRequest();
		ajax.open("GET", "linkageXml_getCityById?pid=" + this.value, true);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				// 获取所有城市数据
				var nodes = ajax.responseXML.documentElement.childNodes;
				// 添加城市数据到下拉框
				for (var i = 0; i < nodes.length; i++) {
					var op = document.createElement("option");
					op.value = nodes[i].id;
					op.innerHTML = nodes[i].innerHTML;
					city.appendChild(op);
				}
			}
		}
		ajax.send();
	}
}