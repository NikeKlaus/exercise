package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @since 2023-06-05
 * @description 管理员实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库主键自增 id
     */
    @TableField("id")
    private Integer id;

    /**
     * 唯一账号且不可修改
     */
    @TableId(value = "admin_id", type = IdType.ASSIGN_ID)
    private String adminId;

    /**
     * 管理员昵称
     */
    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;
}
