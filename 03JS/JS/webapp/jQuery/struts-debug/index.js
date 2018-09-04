//模拟struts 的debug功能
// 传统方法
$(function() {
			var btn1 = document.getElementById("btn1");
			btn1.onclick = function() {
				var div1 = document.getElementById("div1");
				console.log(div1.style.display);
				if (!div1.style.display) {
					div1.style.display = "none";
				} else {
					div1.style.display = "";
				}
			}

		});
// jQuery方法
$(function() {
			var btn2 = $("#btn2");
			btn2[0].onclick = function() {
				console.log("aaa");
				var div1 = $("#div1");
				console.log(div1);
				div1.toggle(1000);
			}
		});