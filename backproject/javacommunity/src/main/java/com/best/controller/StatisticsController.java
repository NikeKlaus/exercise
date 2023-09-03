package com.best.controller;

import com.best.common.R;
import com.best.service.JsoupWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: maowenxing
 * @date: 2023/6/11
 */
@RequestMapping("/")
@RestController
@CrossOrigin
public class StatisticsController {

    @Autowired
    private JsoupWeb jsoupWeb;

    @GetMapping("/")
    public R getRotation() {
        return R.success("解析成功",jsoupWeb.getRotationUrl());
    }
}
