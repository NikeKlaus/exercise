package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author coffeemao
 * @description 用户城市实体
 * @since 2023-06-05
 */
@Data
@TableName(value = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("city_id")
    private Integer cityId;

    @TableField("pid")
    private Integer pid;

    @TableField("name")
    private String name;

    @TableField("code")
    private Integer code;
}