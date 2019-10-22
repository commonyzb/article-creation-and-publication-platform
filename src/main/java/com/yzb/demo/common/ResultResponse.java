package com.yzb.demo.common;

public class ResultResponse<T> {
    private Integer code;
    private String message;
    private T data;


    public ResultResponse() {
    }

    public ResultResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultResponse(CodeEnum codeEnum) {
        this.code = codeEnum.getcode();
        this.message = codeEnum.getMessage();
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
