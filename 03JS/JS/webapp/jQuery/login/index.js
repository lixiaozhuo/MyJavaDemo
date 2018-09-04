function submit() {
	$.post("/login", {
		username : $("#username").val(),
		password : $("#password").val()
	}, function(data) {
	}, "json");
}