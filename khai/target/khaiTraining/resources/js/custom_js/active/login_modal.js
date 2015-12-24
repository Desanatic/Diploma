jQuery( window ).load(function() {
	var role = $("#user").attr("role");

	if(role != "student" && role != "teacher"){
		$('#myModal').modal('show');
		$('div.modal-backdrop').unbind('click');
	}

	$('#loginBtn').click(function (e) {
		send();
	});

	document.onkeyup = function (e) {
		e = e || window.event;
		if (e.keyCode === 13) {
			send();
		}
	}

	function send(){
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
	}



});
