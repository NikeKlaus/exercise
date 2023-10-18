package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author coffeemao
 * @description 菜单权限实体
 * @since 2023-06-17
 */
@Data
@TableName(value = "menu_auth")
public class MenuAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.INPUT)
    private Integer menuId;

    @TableId(value = "auth_id", type = IdType.INPUT)
    private Integer authId;
}