jQuery(document).ready(function() {
	$(".ok-edit-page").hide();
	$(".task-control").hide();
	$("textarea#myTextArea").hide();

	Cursor.change();
	
	$(".edit-page").click(function () {
		$("#editor").htmlcode($(".home-work-text").html());
		$(".home-work-text").html("");
		$("#myTextArea").show( "slow" );
		$(".task-control").show( "slow" );
		$(".edit-page").hide();
		$(".ok-edit-page").show();
		$(".wysibb-toolbar-btn wbb-chart");
		$(".wbb-chart").css("padding-top", "3%");

    });
	
	$(".ok-edit-page").click(function () {
		$(".home-work-text").html($("#editor").htmlcode());
		$("#myTextArea").hide();
		$(".task-control").hide();
		$(".edit-page").show();
		$(".ok-edit-page").hide();

		//SOLUTION
		saveValue(".home-work-text","#solution","/update/task.solution");
    });
	
	$("#add-chart").click(function(){
		// SOLUTION
		$("#solution").children(".col-sm-6").remove();
		console.log($("#chart-editor").val());
		CHART.create($("#chart-editor").val(),"solution");
    });

	$(".task-ok-edit-page").hide();
	$(".task-control").hide();
	$("textarea#task-myTextArea").hide();

	Cursor.change("task-edit-page");
	Cursor.change("task-ok-edit-page");

	$(".task-edit-page").click(function () {
		$("#task-editor").htmlcode($(".task-home-work-text").html());
		$(".task-home-work-text").html("");
		$("#task-myTextArea").show( "slow" );
		$(".task-control").show( "slow" );
		$(".task-edit-page").hide();
		$(".task-ok-edit-page").show();
		$(".wysibb-toolbar-btn wbb-chart");
		$(".wbb-chart").css("padding-top", "3%");
    });

	$(".task-ok-edit-page").click(function () {
		$(".task-home-work-text").html($("#task-editor").htmlcode());
		$("#task-myTextArea").hide();
		$(".task-control").hide();
		$(".task-edit-page").show();
		$(".task-ok-edit-page").hide();

		//TASK
		saveValue(".task-home-work-text","#task","/update/task");
    });

	$("#task-add-chart").click(function(){
		// TASK
		$("#task").children(".col-sm-6").remove();
		CHART.create($("#task-chart-editor").val(),"task");
    });

	$.urlParam = function(name){
		var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		if (results==null){
			return null;
		}
		else{
			return results[1] || 0;
		}
	}

	$.ajax({
		url: '/initial/user.task',
		global: false,
		type: 'POST',
		data: {id : $.urlParam("id")},
		async: false,
		success: function (data) {
			$(".task-home-work-text").html(data.task);
			$("#task").html(data.chart);
		}
	});

	$.ajax({
		url: '/initial/user.solution',
		global: false,
		type: 'POST',
		data: {id : $.urlParam("id")},
		async: false,
		success: function (data) {
			$(".home-work-text").html(data.decision);
			$("#solution").html(data.chart);
		}
	});

	function saveValue(nameTask,nameChart, url){
		var taskVal = $(nameTask).html();
		var chartVal = $(nameChart).html();
		$.ajax({
			url: url,
			global: false,
			type: 'POST',
			data: {
				valueTask : taskVal,
				valueChart : chartVal,
				id : $.urlParam("id")},
			async: false
		});
	}
});
