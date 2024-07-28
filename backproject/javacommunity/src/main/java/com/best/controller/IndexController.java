package com.best.controller;

import com.best.common.ResponseData;
import com.best.utils.ParseWebUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 轮播图控制器
 */
@RequestMapping("/index")
@RestController
@CrossOrigin
public class IndexController {
    @GetMapping("/getRotation")
    public ResponseData<List<String>> getRotation() {
        List<String> urls = ParseWebUtil.getRotationUrl();
        if (CollectionUtils.isNotEmpty(urls)) {
            return ResponseData.success("解析图片成功", urls);
        }
        return ResponseData.fail("解析图片失败");
    }
}
