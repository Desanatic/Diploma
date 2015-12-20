function Cursor() {}

Cursor.change = function (className){
	$("html,body").mouseover(function (event) {
		if($(event.target).hasClass(className)){
			$('html,body').css('cursor','pointer');
		}else{
			$('html,body').css('cursor','default');
		}
	});
}
	
Cursor.parentChange = function (className){
	$("html,body").mouseover(function (event) {
		if($(event.target).parent().hasClass(className)){
			$('html,body').css('cursor','pointer');
		}else{
			$('html,body').css('cursor','default');
		}
	});
}

