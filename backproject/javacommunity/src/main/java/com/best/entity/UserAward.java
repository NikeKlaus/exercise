package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 用户获奖实体
 * @since 2023-06-05
 */
@TableName(value = "user_award")
@Data
public class UserAward implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Integer userId;

    @TableField("award_id")
    private Integer awardId;
    /**
     * 获奖时间
     */
    @TableField(value = "create_time")
    private Date createTime;
}