package com.best.service;

import com.best.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品业务接口
 */
public interface ICommodityService extends IService<Commodity> {

    List<Commodity> selectByKeyWords(String keywords);
}
