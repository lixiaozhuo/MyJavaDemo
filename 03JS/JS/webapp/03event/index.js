window.onload = function() {
	var div2 = document.getElementById("div2");
	//通过对象设置事件
	div2.onclick = function(e) {
		
		alert("div2");
		console.log(arguments);//函数执行实际参数列表
		console.log(this);//事件源
		console.log(e);//事件对象
		console.log("DIV2" + new Date().getTime());
	}
	
	var div3 = document.getElementById("div3");
	addListener(div3,"click",function(){
		alert("方式3-1");
	});
	addListener(div3,"click",function(){
		alert("方式3-2");
	});
}

// 通过标签绑定事件
function event1(element, e) {
	alert("div1");
	console.log(this);//window对象
	console.log(element);//事件源
	console.log(e);//事件对象
	console.log(element.innerText);
	console.log("DIV1" + new Date().getTime());
}

//通过方法绑定
/**
 * 
 * @param {} element 事件源
 * @param {} eventName 事件名称
 * @param {} eventFn 响应函数
 */
function addListener(element,eventName,eventFn){
	if(element.addEventListener){
		element.addEventListener(eventName,eventFn);
	}else{
		element.attachEvent("on" + eventName,eventFn);
	}
}