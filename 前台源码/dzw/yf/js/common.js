/**
 * 显示错误信息
 * @param message：错误信息
 */
function showError(msg) {
    console.log(msg);
}

/**
 * 处理 ajax 请求结果
 * @param result：ajax 返回的结果
 * @param fn：成功的处理函数 ( 传入data: fn(result.data) )
 */
function handlerResult(result, fn) {
    // 成功执行操作，失败提示原因
    if (result.code === 1000) {
        fn();
    }else if(result.code === 1002){
    //参数校验失败
    }else if(result.code === 3000){
        //主键冲突
        peyExit();
    }else {
        showError(result.msg);
    }
}

/**
 * 主键编号已经存在
 */
function peyExit(){
   
}



/**
 * jQuery 全局异常处理, 处理 document 中的所有 ajax 的 error 事件.
 */
$(document).ajaxError(function(event, response){
    console.log("错误响应状态码: ",response.status);
    console.log("错误响应结果: ",response.responseJSON);
    showError(response.responseJSON.message);
});