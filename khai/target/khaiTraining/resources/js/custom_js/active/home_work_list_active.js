jQuery(document).ready(function () {
	Cursor.parentChange("home_work");
	//NEW
	$.ajax({
		url: '/home_work_list.init',
		global: false,
		type: 'GET',
		async: false,
		success: function (data) {
			createTable("new",data["NEW"]);
			createTable("success",data["CLOSE"]);
			createTable("info",data["DONE"]);
			createTable("warning",data["IN_PROGRESS"]);
			createTable("danger",data["OVERDUE"]);
		}
	});

	function createTable(type, data){
		var tableType = ".table.has_state";
		if(type === "new"){
			tableType = ".table.current_tasks";
		}
		var currentTasksTable = $(tableType);
		currentTasksTable.find("." + type).remove();
		for (var i = 0; i < data.length; i++) {
			$(tableType).append(getRowOnTable(i,data[i], type));
		}
	}

	$(".home_work").click(function () {
		//$.get("/home_work" + "?id=" + $(this).find(".id").text());
		window.location.replace("home_work" + "?id=" + $(this).find(".id").text());
	});

	function getRowOnTable(index,data,type){
		var table = "<tr class='" + type + " home_work'" +"'>";
		var tdId = "<td class='id'>" + data.taskId + "</td>";
		var tdTrainingName = "<td class='training_name'>" + data.trainingName + "</td>";
		var tdName = "<td class='name'>" + data.homeWorkName + "</td>";
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
				tdDateOfDelivery +
				assessment +
				tableEnd;
	}

});