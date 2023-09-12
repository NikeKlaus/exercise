package com.best.service.impl;

import com.best.entity.Commodity;
import com.best.mapper.CommodityMapper;
import com.best.service.ICommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 商品业务层实现类
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

}
