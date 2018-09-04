window.onload = function() {
	var startBtn = document.getElementById("startBtn");
	var stopBtn = document.getElementById("stopBtn");
	startBtn.onclick = function() {
		if (flag == true) {
			flag = false;
		}
		startGame();
		this.disabled=true;
	}
	stopBtn.onclick = function() {
		flag = true;
	}
}
// 页面字母
var spanArr = [];
// 是否暂停
var flag = false;
// 开始游戏
function startGame() {
	// 定时器,每隔一段时间随机生成字母
	setInterval(createSpan, 500);
	// 定时器,每隔一段时间下降距离
	setInterval(function() {
				for (index in spanArr) {
					var spanEl = spanArr[index];
					var y = parseInt(spanEl.style.top) + 1;
					// 页面高度
					var height = parseInt(document.documentElement.clientHeight)
							- 25;
					if (y > height) {
						// 从页面中移除
						document.body.removeChild(spanEl);
						// 从数组中移除
						spanArr.splice(index, 1);
					}
					spanEl.style.top = y + "px";
				}

			}, 10);

	document.body.onkeydown = function(e) {
		// 获取按键
		var ch = String.fromCharCode(e.keyCode);
		for (index in spanArr) {
			var spanEl = spanArr[index];
			if (ch == spanEl.innerHTML) {
				// 从页面中移除
				document.body.removeChild(spanEl);
				// 从数组中移除
				spanArr.splice(index, 1);
				var scoreEl = document.getElementById("score");
				scoreEl.innerHTML = parseInt(scoreEl.innerHTML) + 10;
				return;
			}
		}
	}
}

// 随机生成字母
function createSpan() {
	var spanEl = document.createElement("span");
	spanEl.style.position = "absolute";
	spanEl.style.top = "60px";
	spanEl.style.backgroundColor = "red";
	spanEl.style.width = "20px";
	spanEl.style.textAlign = "center";
	spanEl.style.fontWeight = "bold";
	// 添加元素
	document.body.appendChild(spanEl);
	// 字母随机
	var ch = String.fromCharCode(parseInt(Math.random() * 26 + 65));
	spanEl.innerHTML = ch;
	// 位置随机
	var x = parseInt(Math.random()
			* (document.documentElement.clientWidth - 40));
	spanEl.style.left = x + "px";
	// 将字母块存储到数据中
	spanArr.push(spanEl);
}