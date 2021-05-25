package com.study.day.dayservice.errormessage;
 
/**
 * Created by Tiger on 2018/10/9.
 */
public enum  ErrorCodeAndMsg {
 
    Person_does_not_exist("0001","实体不存在"),
    Network_error("9999","网络错误，待会重试"),
    ;
 
    private String code;
    private String msg;
 
    ErrorCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
 
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}