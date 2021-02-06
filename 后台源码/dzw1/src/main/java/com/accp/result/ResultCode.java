package com.accp.result;
import lombok.Getter;

/**
 * @author suruomo
 * @date 2020/8/7 16:10
 * @description: 响应码枚举
 */
@Getter
public enum ResultCode {

    //1000系列通用错误
    SUCCESS(1000, "操作成功"),
    FAILED(1001, "接口错误"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(1003, "未知错误"),
    OTHER_ERRORS(1004,"转换失败"),
    ID_NOT_NULL(1005,"ID参数不能为空"),
    File_UPLOAD_ERROR(1006,"文件上传失败"),
    Failure(1007,"操作失败"),

    //2000系列用户错误
    USER_NOT_EXIST(2000,"用户不存在"),
    USER_LOGIN_FAIL(2001,"用户名或密码错误"),
    USER_NOT_LOGIN(2002,"用户还未登录,请先登录"),
    NO_PERMISSION(2003,"权限不足,请联系管理员"),

    //操作错误
    PEY_EXIT(3000,"此数据已经存在"),
    File_TYPE_ERROR(3001,"文件类型错误"),
    File_SIZE_ERROR(3001,"超出可上传文件大小");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}