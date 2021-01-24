package com.monster.redsun.vo;

public class BaseResponse {

    public Integer code;
    public Object data;
    public Integer errorCode;

    public BaseResponse(){
        this.code = 200;
        this.errorCode = 0;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        code = code;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
