package com.best.controller;

import com.best.common.ResponseData;
import com.best.entity.Commodity;
import com.best.service.CommodityService;
import org.apache.commons.collections4.CollectionUtils;
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
    private CommodityService commodityService;

    @GetMapping("/query")
    public ResponseData<List<Commodity>> query(@RequestParam("keywords") String keywords) {
        List<Commodity> list = commodityService.listByKeywords(keywords);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResponseData.success("查询成功", list);
        }
        return ResponseData.fail("查询失败");
    }

    @PostMapping("/insert")
    public ResponseData<Boolean> insert(@RequestBody Commodity commodity) {
        if (commodityService.save(commodity)) {
            return ResponseData.success("插入成功", true);
        }
        return ResponseData.fail("插入失败");
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateCommodity(@RequestBody Commodity commodity) {
        if (commodityService.updateById(commodity)) {
            return ResponseData.success("修改成功", true);
        }
        return ResponseData.fail("修改失败");
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeCommodity(String commodityId) {
        if (commodityService.removeById(commodityId)) {
            return ResponseData.success("删除成功", true);
        }
        return ResponseData.fail("删除失败");
    }
}
