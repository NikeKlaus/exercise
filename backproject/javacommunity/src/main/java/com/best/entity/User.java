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
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("user_of_role")
    private String userOfRole;

    @TableField("avatar")
    private String avatar;

    @TableField("age")
    private Integer age;

    @TableField("gender")
    private Integer gender;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField("version")
    private Integer version;

    @TableField("deleted")
    private Integer deleted;
}
