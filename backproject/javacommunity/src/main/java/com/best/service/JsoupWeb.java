package com.best.service;

import com.best.entity.Commodity;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 解析网页业务接口
 */
public interface JsoupWeb {
    /**
     * 获取轮播图路径
     * @return List
     */
    List<String> getRotationUrl();

    /**
     * 获取解析到的实体类
     * @param keywords
     * @return List
     */
    List<Commodity> getParseCommodity(String keywords);
}
