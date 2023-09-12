package com.best.controller;

import com.best.common.ResponseData;
import com.best.service.JsoupWeb;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 轮播图控制器
 */
@RequestMapping("/")
@RestController
@CrossOrigin
public class StatisticsController {

    @Resource
    private JsoupWeb jsoupWeb;

    @GetMapping("/")
    public ResponseData<List<String>> getRotation() {
        return ResponseData.success("解析成功",jsoupWeb.getRotationUrl());
    }
}
