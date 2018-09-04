function moveSelected(srcId, targetId) {	
	$("#" + srcId + " option:selected").appendTo($("#" + targetId));
}

function moveAll(srcId, targetId) {
	$("#" + srcId + " option").appendTo($("#" + targetId));
}