jQuery(document).ready(function () {
	Cursor.parentChange("home_work");
	//NEW
	$.ajax({
		url: '/initial/user.tasks',
		global: false,
		type: 'POST',
		data: {state : "NEW"},
		async: false,
		success: function (data) {
			var currentTasksTable = $(".table.current_tasks");
			currentTasksTable.find(".active").remove();
			for (var i = 0; i < data.length; i++) {
				$(".table.current_tasks").append(getRowOnTable(i,data[i], "active"));
			}
		}
	});

	//IN_PROGRESS
	$.ajax({
		url: '/initial/user.tasks',
		global: false,
		type: 'POST',
		data: {state : "IN_PROGRESS"},
		async: false,
		success: function (data) {
			var currentTasksTable = $(".table.has_state");
			currentTasksTable.find(".warning").remove();
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				$(".table.has_state").append(getRowOnTable(i,data[i], "warning"));
			}
		}
	});

	//OVERDUE
	$.ajax({
		url: '/initial/user.tasks',
		global: false,
		type: 'POST',
		data: {state : "OVERDUE"},
		async: false,
		success: function (data) {
			var currentTasksTable = $(".table.has_state");
			currentTasksTable.find(".danger").remove();
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				$(".table.has_state").append(getRowOnTable(i,data[i], "danger"));
			}
		}
	});

	//DONE
	$.ajax({
		url: '/initial/user.tasks',
		global: false,
		type: 'POST',
		data: {state : "DONE"},
		async: false,
		success: function (data) {
			var currentTasksTable = $(".table.has_state");
			currentTasksTable.find(".info").remove();
			for (var i = 0; i < data.length; i++) {
				$(".table.has_state").append(getRowOnTable(i,data[i], "info"));
			}
		}
	});

	//CLOSE
	$.ajax({
		url: '/initial/user.tasks',
		global: false,
		type: 'POST',
		data: {state : "CLOSE"},
		async: false,
		success: function (data) {
			var currentTasksTable = $(".table.has_state");
			currentTasksTable.find(".success").remove();
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				$(".table.has_state").append(getRowOnTable(i,data[i], "success"));
			}
		}
	});

	$(".home_work").click(function () {
		//$.get("/home_work" + "?id=" + $(this).find(".id").text());
		window.location.replace("home_work" + "?id=" + $(this).find(".id").text());
	});

	function getRowOnTable(index,data,type){
		var table = "<tr class='" + type + " home_work'" +"'>";
		var tdId = "<td class='id'>" + data.homeWorkId + "</td>";
		var tdTrainingName = "<td class='training_name'>" + data.trainingName + "</td>";
		var tdName = "<td class='name'>" + data.homeWorkName + "</td>";
		var tdDateOfIssuance = "<td class='date_of_issuance'>" + data.dateOfIssuance + "</td>";
		var tdDateOfDelivery = "<td class='date_of_delivery'>" + data.dateOfDelivery + "</td>";
		var assessment;
		if(data.assessment == 0){
			assessment = "<td class='assessment'>" + "-/-/-" + "</td>";
		}else{
			assessment = "<td class='assessment'>" + data.assessment + "</td>";
		}

		var tableEnd = "</tr>";

		return table +
				tdId +
				tdTrainingName +
				tdName +
				tdDateOfIssuance +
				tdDateOfDelivery +
				assessment +
				tableEnd;
	}

});