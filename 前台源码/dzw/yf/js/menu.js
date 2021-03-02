var basePath = "http://127.0.0.1:8080/";
var menuApi = {
	findMenuByUserId : function(callback){
		$.ajax({
			url:top.data.baseURL+"sysMenu",
			type:"get",
			xhrFields: {
				withCredentials: true
			},
			headers:{
				token:sessionStorage.getItem("token")
			},
			crossDomain: true,
			dataType:"json",
			success:function(result){
				callback(result);
			},error:function(error){
				console.log(error);
			}
		});
	},
	findPerms : function(callback){
		$.ajax({
			url:basePath+"sysMenu/findPerms",
			type:"post",
			xhrFields: {
				withCredentials: true
			},
			headers:{
				token:sessionStorage.getItem("token")
			},
			crossDomain: true,
			dataType:"json",
			success:function(result){
				callback(result);
			},error:function(error){
				console.log(error);
			}
		});
	}
}