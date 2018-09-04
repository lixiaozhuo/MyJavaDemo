$(function() {
	$("#username").blur(function() {
		$.get("/checkUsername2", {
			username : $(this).val()
		}, function(data) {
			if (data.success) {
				$("#msg").css("color","green").html(data.data);
			} else {
				$("#msg").css("color","red").html(data.data);
			}
		}, "json")
	});
});