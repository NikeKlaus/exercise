package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 学习路径实体
 * @since 2023-06-17
 */
@Data
@TableName(value = "route")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "route_id", type = IdType.ASSIGN_ID)
    private String routeId;

    @TableField("route_name")
    private String routeName;

    @TableField("level")
    private String level;

    @TableField("sort")
    private String sort;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;
}