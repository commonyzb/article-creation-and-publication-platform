package com.yzb.site.common;

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

    public ResultResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //    public ResultResponse(BaseResponse baseResponse){
//        this.code = baseResponse.getCode();
//        this.message = baseResponse.getMessage();
//    }

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
