package com.best.controller;

import com.best.service.impl.JsoupWebImpl;
/**
 * @author: maowenxing
 * @date: 2023/6/11
 */
public class Test01 {
    public static void main(String[] args) {
        JsoupWebImpl jsoupWeb = new JsoupWebImpl();
        System.out.println(jsoupWeb.getParseCommodity("java python").size());
    }
}
