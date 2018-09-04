// 页面加载完成后执行
window.onload = function() {
	// 页面超链接
	console.log(window.document.links);
	// 页面表单
	console.log(document.forms);
	// 页面标题
	console.log(document.title);
	// 整个页面
	console.log(document.documentElement);
	// body元素
	console.log(document.body);
	// 根据索引获取表单
	console.log(document.forms[0]);
	// 根据name获取表单
	console.log(document.form2);
	// 根据id获取表单元素
	console.log(document.getElementById("form3"));
}
/**
 * 浏览器相关信息navigator属性
 */
// 用户使用的浏览器
console.log("用户使用的浏览器" + window.navigator.userAgent)
/**
 * 浏览器窗口位置
 */
var x;
var y;
x = window.screenX || window.screenLeft || 0;
y = window.screenY || window.screenTop || 0;
if(screenY){
	alert("非ie");
}
if(screenLeft){
	alert("ie");
}
alert("浏览器位置 x=" + x + ", y=" + y);
/**
 * 定时器 周期性执行 callback:回调函数 delay:间隔时间
 */
setInterval(function() {
			var time = document.getElementById("time");
			time.innerText = time.innerText - 1;
			if (time.innerText == 0) {
				 window.location.href = "NewFile.html";
			}
		}, 1000)

/**
 * 定时器 执行一次
 */
setTimeout(function() {
			window.location.href = "NewFile.html";
		}, 100000)
console.log("============================================")