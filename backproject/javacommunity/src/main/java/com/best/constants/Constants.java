package com.best.constants;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 常量类
 */
public class Constants {
    /**
     * 盐值加密算法 用于用户密码的加密
     * DigestUtils.md5DigestAsHex((SALT + updatePasswordRequest.getPassword()).getBytes(StandardCharsets.UTF_8));
     */
    public static String SALT = "www.cctv14.com";

    public static String STATISTICS_URL = "https://www.toopic.cn/";

    public static String COMMODITY_URL = "https://search.jd.com/Search?keyword=";
}
