function Cursor() {}

Cursor.change = function (){
	$("html,body").mouseover(function (event) {
		if($(event.target).hasClass("checkCursor")){
			$('html,body').css('cursor','pointer');
		}else{
			$('html,body').css('cursor','default');
		}
	});
}
	
Cursor.parentChange = function (){
	$("html,body").mouseover(function (event) {
		if($(event.target).parent().hasClass("checkCursor")){
			$('html,body').css('cursor','pointer');
		}else{
			$('html,body').css('cursor','default');
		}
	});
}

