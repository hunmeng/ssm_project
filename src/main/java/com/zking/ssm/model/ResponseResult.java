package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class ResponseResult<T> implements Serializable {

    //状态
    private Integer code;

    //状态信息
    private String  message;

    //状态数据
    private T date; 

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, T date) {
        this.code = code;
        this.date = date;
    }

    public ResponseResult() {
    }
}


