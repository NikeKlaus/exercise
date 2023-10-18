package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @author coffeemao
 * @since 2023-10-18
 * @description 权限实体
 */
@Data
@TableName(value ="auth")
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("auth_id")
    private Integer authId;

    @TableField("auth_name")
    private String authName;
}