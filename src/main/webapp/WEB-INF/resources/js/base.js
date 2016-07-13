function showModal(content,modalOK,cancel){
    $("#myModal").remove();
    var modal =  "<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\""
        +"aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">"
        +"<div class=\"modal-dialog\">"
        +"<div class=\"modal-content\">"
        +"<div class=\"modal-header\">"
        +"<button type=\"button\" class=\"close\""
        +"data-dismiss=\"modal\" aria-hidden=\"true\">"
        +"</button>"
        +"</div>"
        +"<div class=\"modal-body text-center\">"
        +content
        +"</div>"
        +"<div class=\"modal-footer\">"
        +"<button type=\"button\" id=\"cancel\" class=\"btn btn-default\""
        +"data-dismiss=\"modal\">关闭"
        +"</button>"
        +"<button type=\"button\" class=\"btn btn-primary\" id=\"modalOK\" >"
        +"确认"
        +"</button>"
        +"</div>"
        +"</div>"
        +"</div>"
        +"</div>";
    $(modal).modal('show');
    $(window).on('shown.bs.modal', function (event) {
        $("#modalOK").off("click").on("click",(function () {
            if(typeof(modalOK)=="undefined"){
                $("#myModal").modal('hide');
            }else{
                modalOK();
                $("#myModal").modal('hide');
            }

        }));
        $("#cancel").off("click").on("click",(function () {
            if(typeof(cancel)=="undefined"){
                $("#myModal").modal('hide');
            }else{
                cancel();
                $("#myModal").modal('hide');
            }

        }));

    })

}