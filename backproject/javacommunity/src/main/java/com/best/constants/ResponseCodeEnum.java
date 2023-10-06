package com.best.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author cctv14
 * @data 2023/9/16 23:34
 * @description 自定义枚举类
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseCodeEnum {

    /**
     * 成功响应
     */
    OK(200, "成功"),

    MOVED_PERMANENTLY(301, "永久重定向"),

    FOUND(302, "临时重定向"),

    /**
     * 错误枚举类
     */
    BAD_REQUEST(400, "请求无效"),

    UNAUTHORIZED(401, "未授权"),

    FORBIDDEN(403, "禁止访问"),

    NOT_FOUND(404, "服务器找不到请求的资源"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误");


    private Integer code;

    private String desc;
}
