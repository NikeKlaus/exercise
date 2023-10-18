package com.best.model.commodity;

import com.best.entity.Commodity;
import com.best.service.CommodityService;
import com.best.utils.ParseWebUtil;
import com.best.vo.CommodityVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/5 22:24
 * @description
 */
@Component
public class CommodityManager {

    @Resource
    private CommodityService commodityService;

    public List<CommodityVO.QueryCommodityVO> query(String keywords) {
        List<Commodity> commodities = commodityService.selectByKeyWords(keywords);
        if (CollectionUtils.isEmpty(commodities)) {
            commodities = ParseWebUtil.getParseCommodity(keywords);
            commodityService.saveBatch(commodities);
        }
        return CommodityConvert.INSTANCE.toQueryCommodityVOList(commodities);
    }

    public boolean insert(CommodityVO.InsertCommodityVO insertCommodityVO) {
        Commodity commodity = CommodityConvert.INSTANCE.toCommodity(insertCommodityVO);
        return commodityService.save(commodity);
    }

    public boolean updateCommodity(CommodityVO.QueryCommodityVO queryCommodityVO) {
        List<Commodity> commodities = commodityService.listByIds(Collections.singletonList(queryCommodityVO.getCommodityId()));
        if (CollectionUtils.isEmpty(commodities)) {
            return false;
        }
        Commodity commodity = CommodityConvert.INSTANCE.toCommodity(queryCommodityVO);
        if ("".equals(commodity.getTitle())) {
            commodity.setTitle(null);
        }
        if ("".equals(commodity.getImg())) {
            commodity.setImg(null);
        }
        if ("".equals(commodity.getComment())) {
            commodity.setComment(null);
        }
        if ("".equals(commodity.getPrice())) {
            commodity.setPrice(null);
        }
        return commodityService.updateById(commodity);
    }

    public boolean removeCommodity(String commodityId) {
        return commodityService.removeById(commodityId);
    }
}
