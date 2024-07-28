package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.entity.Commodity;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品业务接口
 */
public interface CommodityService extends IService<Commodity> {
    List<Commodity> listByKeywords(String keywords);
}
