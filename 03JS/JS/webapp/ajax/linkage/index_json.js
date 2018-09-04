// json数据方式
window.onload = function() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var empty = document.createElement("option");
	empty.value = "-1";
	empty.innerHTML = "请选择";
	var ajax = new XMLHttpRequest();
	ajax.open("GET", "linkageJson", true);
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			
			// 获取所有省市数据
			var datas = eval("(" + ajax.responseText + ")");
			// 添加省份数据到下拉框
			for (var i = 0; i < datas.length; i++) {
				console.log(datas);
				var op = document.createElement("option");
				op.value = datas[i].id;
				op.innerHTML = datas[i].name;
				console.log(op);
				province.appendChild(op);
			}
		}
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
		ajax.open("GET", "linkageJson_getCityById?pid=" + this.value, true);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				// 获取所有省市数据
				var datas = eval("(" + ajax.responseText + ")");
				// 添加省份数据到下拉框
				for (var i = 0; i < datas.length; i++) {
					var op = document.createElement("option");
					op.value = datas[i].id;
					op.innerHTML = datas[i].name;
					city.appendChild(op);
				}
			}
		}
		ajax.send();
	}
}