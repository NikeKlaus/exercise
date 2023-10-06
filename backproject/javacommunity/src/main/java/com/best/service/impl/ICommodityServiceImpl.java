package com.best.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Commodity;
import com.best.mapper.CommodityMapper;
import com.best.service.ICommodityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品业务层实现类
 */
@Service
public class ICommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Override
    public List<Commodity> selectByKeyWords(String keywords) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Commodity::getTitle, keywords);
        return list(queryWrapper);
    }
}
