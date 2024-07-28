package com.best.model.commodity;

import com.best.entity.Commodity;
import com.best.service.convert.CommodityConvert;
import com.best.vo.CommodityVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T22:10:50+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class CommodityConvertImpl implements CommodityConvert {

    @Override
    public CommodityVO.QueryCommodityVO toQueryCommodityVO(Commodity commodity) {
        if ( commodity == null ) {
            return null;
        }

        CommodityVO.QueryCommodityVO queryCommodityVO = new CommodityVO.QueryCommodityVO();

        queryCommodityVO.setCommodityId( commodity.getCommodityId() );
        queryCommodityVO.setTitle( commodity.getTitle() );
        queryCommodityVO.setImg( commodity.getImg() );
        queryCommodityVO.setPrice( commodity.getPrice() );
        queryCommodityVO.setComment( commodity.getComment() );

        return queryCommodityVO;
    }

    @Override
    public List<CommodityVO.QueryCommodityVO> toQueryCommodityVOList(List<Commodity> commodityList) {
        if ( commodityList == null ) {
            return null;
        }

        List<CommodityVO.QueryCommodityVO> list = new ArrayList<CommodityVO.QueryCommodityVO>( commodityList.size() );
        for ( Commodity commodity : commodityList ) {
            list.add( toQueryCommodityVO( commodity ) );
        }

        return list;
    }

    @Override
    public Commodity toCommodity(CommodityVO.QueryCommodityVO queryCommodityVO) {
        if ( queryCommodityVO == null ) {
            return null;
        }

        Commodity commodity = new Commodity();

        commodity.setCommodityId( queryCommodityVO.getCommodityId() );
        commodity.setTitle( queryCommodityVO.getTitle() );
        commodity.setImg( queryCommodityVO.getImg() );
        commodity.setPrice( queryCommodityVO.getPrice() );
        commodity.setComment( queryCommodityVO.getComment() );

        return commodity;
    }

    @Override
    public Commodity toCommodity(CommodityVO.InsertCommodityVO insertCommodityVO) {
        if ( insertCommodityVO == null ) {
            return null;
        }

        Commodity commodity = new Commodity();

        commodity.setTitle( insertCommodityVO.getTitle() );
        commodity.setImg( insertCommodityVO.getImg() );
        commodity.setPrice( insertCommodityVO.getPrice() );
        commodity.setComment( insertCommodityVO.getComment() );

        return commodity;
    }
}
