package com.best.service;

import com.best.entity.Commodity;

import java.util.List;

/**
 * @author: maowenxing
 * @date: 2023/6/17
 */
public interface JsoupWeb {
    List<String> getRotationUrl();

    List<Commodity> getParseCommodity(String keywords);
}
