jQuery( window ).load(function() {
	var role = $("#user").attr("role");

	if(role != "student" && role != "teacher"){
		$('#myModal').modal('show');
		$('div.modal-backdrop').unbind('click');
	}

	$('#loginBtn').click(function(){
		var login = $('#inputEmail').val();
		var password = $('#inputPassword').val();
		$.post(
			"/sig_in",
			{
				login: login,
				password: password
			}
		).success(function() {
				$(".form-group").removeClass("has-error");
				$('#myModal').modal('hide');
			}
		).error(function() {
				$(".form-group").addClass("has-error");
			}
		);
	});
});
