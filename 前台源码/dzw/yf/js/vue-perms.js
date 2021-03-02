Vue.directive("perms",{
	inserted:function(el,binding,vnode,oldnode){
		//获取整个系统中拥有的所有权限
		// alert(JSON.stringify(top));
		var perms = top.perms;
		console.log(perms);
		var verfiy = binding.value;//当前验证的权限
		var flag = perms.some(item=>item.perms==verfiy);
		if(!flag){
			el.remove();
		}
	},
})