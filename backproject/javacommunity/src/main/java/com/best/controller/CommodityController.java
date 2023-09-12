package com.best.controller;

import com.best.common.ResponseData;
import com.best.entity.Commodity;
import com.best.service.JsoupWeb;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品控制器
 */
@RestController
@RequestMapping("/commodity")
@CrossOrigin
public class CommodityController {
    @Resource
    private JsoupWeb jsoupWeb;

    @GetMapping("/query")
    public ResponseData<List<Commodity>> query(@RequestParam("keywords") String keywords) {
        return ResponseData.success("查询成功", jsoupWeb.getParseCommodity(keywords));
    }
}
