//传统页面加载
window.onload=function(){
	var msg = document.getElementById("msg");
	console.log(msg.innerHTML);
}

//jQuery页面加载
$(function() {
	var msg = $("#msg");
	console.log(msg.html());
});

	
