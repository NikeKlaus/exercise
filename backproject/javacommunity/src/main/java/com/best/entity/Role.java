package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 角色实体
 * @since 2023-06-17
 */
@Data
@TableName(value = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private String roleId;

    @TableField("role_name")
    private String roleName;

    /**
     * 角色分配的权限
     */
    @TableField("authority")
    private Long authority;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;
}