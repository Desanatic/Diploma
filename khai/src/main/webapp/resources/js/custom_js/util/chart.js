	function CHART(){
		
	}
	
	CHART.add = function(name, index, script){
		$("#" + name).append("<div id='" + name + index + "' class='col-sm-6'><\/div>");
		$("#" + name + index).html("<script>" + script + "<\/script>");
	}	
	
	CHART.convert = function(index, script, name){
		var variable = "var data" + index + " = ";
		var createChart = "new Chartist.Line('#" + name + index + "\', data" + index + ");";
		return variable + script + "; " + createChart;
	}
	
	CHART.create = function(chartBox, name){
		var charts = chartBox.split(";");

		for(var i = 0; i < charts.length - 1; i++){
			CHART.add(name, i, CHART.convert(i, charts[i],name));
		}
	}