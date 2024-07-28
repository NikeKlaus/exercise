package com.best.mapper;

import com.best.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品 mapper
 */
public interface CommodityMapper extends BaseMapper<Commodity> {
    List<Commodity> selectByKeyWords(String keywords);
}
