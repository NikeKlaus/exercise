package com.best.controller;

import com.best.common.R;
import com.best.service.JsoupWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author coffeemao
 * @since 2023-06-17
 */
@RestController
@RequestMapping("/commodity")
@CrossOrigin
public class CommodityController {
    @Autowired
    private JsoupWeb jsoupWeb;

    @GetMapping("/query")
    public R query(@RequestParam("keywords") String keywords){
        return R.success("查询成功",jsoupWeb.getParseCommodity(keywords));
    }
}
