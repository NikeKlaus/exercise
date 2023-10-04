package com.best.common;

import com.best.constants.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 提供统一返回接口的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> implements Serializable {

    private int code;

    private String message;

    private String type;

    private Boolean success;

    private Object data;

    private ResponseCodeEnum baseEnum;

    public ResponseData(ResponseCodeEnum baseEnum) {
        this.baseEnum = baseEnum;
    }

    public static <T> ResponseData<T> success(Object data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(200);
        responseData.setMessage("");
        responseData.setSuccess(true);
        responseData.setType("success");
        responseData.setData(data);
        return responseData;
    }

    public static <T> ResponseData<T> success(ResponseCodeEnum baseEnum) {
        return new ResponseData<>(baseEnum);
    }
    public static <T> ResponseData<T> success(String message, Object data) {
        ResponseData<T> responseData = success(data);
        responseData.setMessage(message);
        return responseData;
    }

    public static <T> ResponseData<T> success(int code, Object data) {
        ResponseData<T> responseData = success(data);
        responseData.setCode(code);
        return responseData;
    }

    public static <T> ResponseData<T> error(String message) {
        ResponseData<T> responseData = success(message);
        responseData.setCode(404);
        responseData.setSuccess(false);
        responseData.setType("Not Find");
        return responseData;
    }

    public static <T> ResponseData<T> fail(String message) {
        ResponseData<T> responseData = error(message);
        responseData.setCode(500);
        responseData.setSuccess(false);
        responseData.setType("Internal Server Error");
        return responseData;
    }
}
