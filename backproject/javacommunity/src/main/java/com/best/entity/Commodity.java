package com.best.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author coffeemao
 * @since 2023-06-17
 */
@Data
@ApiModel(value = "Commodity对象", description = "")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品唯一编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("图片")
    private String img;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("评论数目")
    private String comment;

    @Override
    public String toString() {
        return "Commodity{" +
            "id=" + id +
            ", title=" + title +
            ", img=" + img +
            ", price=" + price +
            ", comment=" + comment +
        "}";
    }
}
