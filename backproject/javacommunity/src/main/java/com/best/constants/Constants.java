package com.best.constants;

public class Constants {
    /* 盐值加密算法 用于用户密码的加密
     *  DigestUtils.md5DigestAsHex((SALT + updatePasswordRequest.getPassword()).getBytes(StandardCharsets.UTF_8));
     * */
    public static String SALT = "coffeemao";

    public static String STATISTICSURL = "https://www.toopic.cn/";

    public static String COMMODITYURL = "https://search.jd.com/Search?keyword=";
}
