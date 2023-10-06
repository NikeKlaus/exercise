package com.best.model.commodity;

import com.best.entity.Commodity;
import com.best.service.ICommodityService;
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
    private ICommodityService iCommodityService;

    public List<CommodityVO.QueryCommodityVO> query(String keywords) {
        List<Commodity> commodities = iCommodityService.selectByKeyWords(keywords);
        if (CollectionUtils.isEmpty(commodities)) {
            commodities = ParseWebUtil.getParseCommodity(keywords);
            iCommodityService.saveBatch(commodities);
        }
        return CommodityConvert.INSTANCE.toQueryCommodityVOList(commodities);
    }

    public Boolean insert(CommodityVO.InsertCommodityVO insertCommodityVO) {
        Commodity commodity = CommodityConvert.INSTANCE.toCommodity(insertCommodityVO);
        return iCommodityService.save(commodity);
    }

    public Boolean updateCommodity(CommodityVO.QueryCommodityVO queryCommodityVO) {
        List<Commodity> commodities = iCommodityService.listByIds(Collections.singletonList(queryCommodityVO.getCommodityId()));
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
        return iCommodityService.updateById(commodity);
    }

    public Boolean removeCommodity(String commodityId) {
        return iCommodityService.removeById(commodityId);
    }
}
