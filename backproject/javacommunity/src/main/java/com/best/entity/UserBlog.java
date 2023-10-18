package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author coffeemao
 * @description 用户博客实体
 * @since 2023-06-05
 */
@Data
@TableName(value = "user_blog")
public class UserBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    @TableId(value = "blog_id", type = IdType.INPUT)
    private Integer blogId;
}