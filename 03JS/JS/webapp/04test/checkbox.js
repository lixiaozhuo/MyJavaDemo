function checkAll(flag){
	//所有兴趣集合
	var hobbys = document.getElementsByName("hobby");
	//遍历集合
	for(var index=0;index<hobbys.length;index++){
		hobbys[index].checked=flag;
	}
}
function checkUnAll(){
	//所有兴趣集合
	var hobbys = document.getElementsByName("hobby");
	//遍历集合
	for(var index=0;index<hobbys.length;index++){
		hobbys[index].checked=!hobbys[index].checked;
	}
}

function checkChange(element){
	checkAll(element.checked);
}