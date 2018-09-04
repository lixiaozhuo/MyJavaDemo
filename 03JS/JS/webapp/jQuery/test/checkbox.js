function checkAll(flag) {
	$(":checkbox[name='hobby']").prop("checked", flag);
}
function checkUnAll() {
	$(":checkbox[name='hobby']").each(function() {
		this.checked = !this.checked;
	});
}

function checkChange(element) {
	checkAll($(element).prop("checked"));
}