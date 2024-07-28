package com.best.service.convert;

import com.best.entity.Commodity;
import com.best.vo.CommodityVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/5 22:33
 * @description
 */
@Mapper
public interface CommodityConvert {

    CommodityConvert INSTANCE = Mappers.getMapper(CommodityConvert.class);

    CommodityVO.QueryCommodityVO toQueryCommodityVO(Commodity commodity);

    List<CommodityVO.QueryCommodityVO> toQueryCommodityVOList(List<Commodity> commodityList);

    Commodity toCommodity(CommodityVO.QueryCommodityVO queryCommodityVO);

    Commodity toCommodity(CommodityVO.InsertCommodityVO insertCommodityVO);
}
