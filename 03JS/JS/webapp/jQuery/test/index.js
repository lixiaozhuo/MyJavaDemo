// 传统方法
$(function() {
			div1 = document.getElementById("div1");
			console.log("传统方法显示: " + div1.innerHTML);
			div1.innerHTML="传统方法改变";
			//dom对象转化为jQuery对象
			console.log($(div1));

		});
// jQuery方法
$(function() {
			var div2 = $("#div2");
			console.log("jQuery方法显示: " + div2.html());
			div2.html("jQuery方法改变");
			//jQuery转换为dom对象
			console.log(div2[0]);
			console.log(div2.get(0));
		});