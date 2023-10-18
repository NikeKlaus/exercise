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

    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer awardId;
    /**
     * 获奖时间
     */
    @TableField(value = "create_time")
    private Date createTime;
}