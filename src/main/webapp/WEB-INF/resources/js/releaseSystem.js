function getReleaseSystemlist(callback){
    waitingDialog.show('数据加载中');
    $.ajax({
        url:"/releaseSystemlist",
        data:{},
        success:function(data) {
            console.info(data)
            if(null != data && data.length>0){
                $.each(data,function () {
                    console.info(this);
                    $("#systemname option").remove();
                    $.each(data,function () {
                        $("#systemname").append("<option value=\'"+this.id+"\'>"+this.systemName+"</option>");
                    });
                });
                if(typeof(callback) != 'undefined'){
                    callback();
                }
            }
            waitingDialog.hide();
        }
    });
}