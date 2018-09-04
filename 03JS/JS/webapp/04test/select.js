function moveSelected(srcId,targetId){
	//源
	var src = document.getElementById(srcId);
	//目标
	var target = document.getElementById(targetId);
	//移动所选选项
	while(src.selectedOptions.length){
		target.appendChild(src.selectedOptions[0]);
	}
}

function moveAll(srcId,targetId){
	//源
	var src = document.getElementById(srcId);
	//目标
	var target = document.getElementById(targetId);
	//移动所有选项
	while(src.children.length){
		target.appendChild(src.children[0]);
	}
	
}