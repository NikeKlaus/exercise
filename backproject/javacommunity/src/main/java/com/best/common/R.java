package com.best.common;

import lombok.Data;

/**
 * 提供统一返回接口的类
 */
@Data
public class R {

    private int code;

    private String message;

    private String type;

    private Boolean success;

    private Object data;

    public static R success(String message) {
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        r.setSuccess(true);
        r.setType("success");
        r.setData(null);
        return r;
    }

    public static R success(String message, Object data) {
        R r = success(message);
        r.setData(data);
        return r;
    }

    public static R warning(String message) {
        R r = error(message);
        r.setType("warning");
        return r;
    }

    public static R error(String message) {
        R r = success(message);
        r.setSuccess(false);
        r.setType("error");
        return r;
    }

    public static R fatal(String message) {
        R r = error(message);
        r.setCode(500);
        r.setType("Internal Server Error");
        return r;
    }
}