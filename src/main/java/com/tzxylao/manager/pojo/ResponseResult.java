package com.tzxylao.manager.pojo;


import com.tzxylao.manager.enums.ExceptionEnum;

public class ResponseResult {

    private ExceptionEnum exceptionEnum;

    private Object data;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ResponseResult(ExceptionEnum exceptionEnum, String msg, Object data) {
        this.exceptionEnum = exceptionEnum;
        this.data = data;
        this.msg = msg;
    }
}