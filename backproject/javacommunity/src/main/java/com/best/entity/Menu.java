package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 菜单实体
 * @since 2023-06-17
 */
@Data
@TableName(value = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private String menuId;

    @TableField("menu_name")
    private String menuName;

    @TableField("pid")
    private String pid;

    @TableField("desc")
    private String desc;

    @TableField("level")
    private String level;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("sort")
    private int sort;

    /**
     * 隐藏，级别最高
     */
    @TableField("hide")
    private boolean hide;

    /**
     * 是否受控
     */
    @TableField("ctrl")
    private boolean ctrl;

    /**
     * 无受控之下权限是否隐藏，级别最低
     */
    @TableField("auth_hide")
    private boolean authHide;
}