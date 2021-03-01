var basePath = "http://127.0.0.1:8080/";
var menuApi = {
    findPerms: function () {
        $.ajax({
            type: "Post",
            url: basePath + "sysMenu/findPerms",
            data: "data",
            dataType: "dataType",
            success: function (result) {
                callback(result);
            }
        });
    }
}