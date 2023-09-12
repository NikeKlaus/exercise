package com.best.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coffeemao
 * @since 2023-06-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Commodity对象", description = "商品实体类")
@TableName("commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品唯一标识")
    @TableField("commodity_id")
    private String commodityId;


    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("图片")
    @TableField("img")
    private String img;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("评论数目")
    @TableField("comment")
    private String comment;

}
