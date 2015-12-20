
$(function() {
$("#editor").wysibb();
$("#task-editor").wysibb();
$(".wbb-chart").click(function() {
	if($(this).closest(".task").hasClass( "task" )){
		$('#task-chartModal').modal();
		
		var value ="";
		var text ="";
		var charts = $("#task").children(".col-sm-6");
		for(var i = 0; i < charts.length; i++){
			console.log(charts[i]);
			text = $(charts[i]).html();
			text = text.substring(text.indexOf(" = ") + 2, text.indexOf("new Chartist.Line"));
			value = value + text;
		}
		$("#task-chart-editor").val(value);
		
	}else{
		$('#chartModal').modal();
		var value ="";
		var text ="";
		var charts = $("#solution").children(".col-sm-6");
		for(var i = 0; i < charts.length; i++){
			console.log(charts[i]);
			text = $(charts[i]).html();
			text = text.substring(text.indexOf(" = ") + 2, text.indexOf("new Chartist.Line"));
			value = value + text;
		}
		$("#chart-editor").val(value);
		
	}
});
})
