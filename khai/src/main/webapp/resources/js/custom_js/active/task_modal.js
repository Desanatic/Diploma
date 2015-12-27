jQuery( window ).load(function() {
    selectionTraining();

    function selectionTraining(){
        setTitle("Выберите предмет");
        addToBody(selectorGenerator());
    }

    function selectorGenerator(){
        var firstBlock = "<select class='form-control'>";
        var endBlock = "</select>";
        var options = "";
        var data = getSelectors();

        for(var i = 0; i < data.length; i++){
            options += getOption(data[i].id, data[i].trainingName)
        }

        return firstBlock + options + endBlock;

        function getOption(id, value){
            return "<option " + "id='" + id + "'>" + value + "</option>"
        }

        function getSelectors() {
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
    }

    function addToBody(body){
        $("#task-modal-body").html("");
        $("#task-modal-body").html(body);
    }

    function setTitle(title){
        $("#title-box-in-task-modal").html("");
        $("#title-box-in-task-modal").html(title);
    }
});
