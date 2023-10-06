package com.best.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cctv14
 * @data 2023/10/5 22:25
 * @description
 */
public class CommodityVO {

    /**
     * 查询和修改共用一个 VO
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QueryCommodityVO {

        private String commodityId;

        private String title;

        private String img;

        private String price;

        private String comment;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InsertCommodityVO {

        private String title;

        private String img;

        private String price;

        private String comment;
    }
}
