package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @since 2023-06-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "commodity_id", type = IdType.ASSIGN_ID)
    private String commodityId;

    @TableField("title")
    private String title;

    @TableField("img")
    private String img;

    @TableField("price")
    private String price;

    @TableField("comment")
    private String comment;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("deleted")
    private Integer deleted;
}
