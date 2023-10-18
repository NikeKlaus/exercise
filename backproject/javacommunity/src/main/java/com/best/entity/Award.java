package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 荣誉实体
 * @since 2023-10-18
 */
@Data
@TableName(value = "award")
public class Award implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "award_id", type = IdType.ASSIGN_ID)
    private String awardId;

    @TableField("award_name")
    private String awardName;

    @TableField("title")
    private String title;

    @TableField("detail")
    private String detail;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
}