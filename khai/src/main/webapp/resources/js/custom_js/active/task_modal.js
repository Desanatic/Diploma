jQuery( window ).load(function() {
    $(".close").click(function(){
        destroy();
        $('#task-modal').modal('toggle');
    });

    selectionTraining();

    function selectionTraining(){
        //Send Btn
        $("#sendResult").off( "click");

        setTitle("Выберите предмет");
        addToBody(selectorTrainingGenerator(getTrainingSelectors()));
        sendTrainingSelector();
        //Back Btn
        $("#back-btn").off( "click");
        $('#back-btn').prop('disabled', true);
    }

    function selectionHomework(){
        //Send Btn
        $("#sendResult").off( "click");

        setTitle("Выберите домашнюю работу");
        addToBody(selectorHomeworkGenerator(getHomeworkSelectors()));
        sendHomeworkSelector();

        //Back Btn
        $("#back-btn").off( "click");
        $('#back-btn').prop('disabled', false);
        $("#back-btn").click(function() {
            selectionTraining();
        });
    }

    function selectionUser(){
        //Send Btn
        $("#sendResult").off( "click");

        setTitle("Выберите студента");
        addToBody(selectorUserNameGenerator(getUserSelectors()));
        sendUserSelector();

        //Back Btn
        $("#back-btn").off( "click");
        $('#back-btn').prop('disabled', false);
        $("#back-btn").click(function() {
            selectionHomework();
        });
    }

    function selectorTrainingGenerator(data){
        var firstBlock = "<select class='form-control' id='training-selector'>";
        var endBlock = "</select>";
        var options = "";

        for(var i = 0; i < data.length; i++){
            options += getOption(data[i].id, data[i].trainingName)
        }

        return firstBlock + options + endBlock;

        function getOption(id, name){
            return "<option " + "value='" + id + "'>" + name + "</option>"
        }
    }

    function selectorHomeworkGenerator(data){
        var firstBlock = "<select class='form-control' id='homework-selector'>";
        var endBlock = "</select>";
        var options = "";

        for(var i = 0; i < data.length; i++){
            options += getOption(data[i].id, data[i].name)
        }

        return firstBlock + options + endBlock;

        function getOption(id, name){
            return "<option " + "value='" + id + "'>" + name + "</option>"
        }
    }

    function selectorUserNameGenerator(data){
        var firstBlock = "<select class='form-control' id='user-name-selector'>";
        var endBlock = "</select>";
        var options = "";

        for(var i = 0; i < data.length; i++){
            options += getOption(data[i].id, data[i].name + " " + data[i].surname);
        }

        return firstBlock + options + endBlock;

        function getOption(id, name){
            return "<option " + "value='" + id + "'>" + name + "</option>"
        }
    }

    function getHomeworkSelectors() {
        var result = "";
        $.ajax({
            url: '/homeWorkManager/getHomework',
            global: false,
            type: 'GET',
            async: false,
            success: function (data) {
                result = data;
            }
        });
        return result;
    }

    function getTrainingSelectors() {
        var result = "";
        $.ajax({
            url: '/homeWorkManager/getTraining',
            global: false,
            type: 'GET',
            async: false,
            success: function (data) {
                result = data;
            }
        });
        return result;
    }

    function getUserSelectors() {
        var result = "";
        $.ajax({
            url: '/homeWorkManager/getUsers',
            global: false,
            type: 'GET',
            async: false,
            success: function (data) {
                result = data;
            }
        });
        return result;
    }

    function addToBody(body){
        $("#task-modal-body").html("");
        $("#task-modal-body").html(body);
    }

    function setTitle(title){
        $("#title-box-in-task-modal").html("");
        $("#title-box-in-task-modal").html(title);
    }

    function sendHomeworkSelector(){
        var result = 0;
        $("#sendResult").click(function (){
            var homeworkId = $("#homework-selector").val();
            $.post(
                "/homeWorkManager/setHomework",
                {
                    id: homeworkId
                }
            ).success(function() {
                    selectionUser();
                }
            ).error(function() {
                    result = -1;
                }
            );
            return result;
        });
    }

    function sendTrainingSelector(){
        var result = 0;
        $("#sendResult").click(function (){
            var trainingId = $("#training-selector").val();
            $.post(
                "/homeWorkManager/setTraining",
                {
                    training_id: trainingId
                }
            ).success(function() {
                    selectionHomework();
                }
            ).error(function() {
                    result = -1;
                }
            );
            return result;
        });
    }

    function sendUserSelector(){
        var result = 0;
        $("#sendResult").click(function (){
            var userId = $("#user-name-selector").val();
            $.post(
                "/homeWorkManager/setUser",
                {
                    id: userId
                }
            ).success(function() {
                createTask();
                }
            ).error(function() {
                    result = -1;
                }
            );
            return result;
        });
    }

    function createTask(){
        $.post(
            "/homeWorkManager/create"
        ).success(function() {
                console.log("ok");
            }
        ).error(function() {
                result = -1;
            }
        );

    }

    function destroy(){
        $.post(
            "/homeWorkManager/destroy"
        );
    }
});
