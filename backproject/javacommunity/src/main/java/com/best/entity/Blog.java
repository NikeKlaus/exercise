package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @description 博客实体
 * @since 2023-10-18
 */
@Data
@TableName(value = "blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客主键
     */
    @TableField("id")
    private Integer id;

    /**
     * 博客ID
     */
    @TableId(value = "blog_id", type = IdType.ASSIGN_ID)
    private String blogId;

    /**
     * 博客标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 博文描述信息
     */
    @TableField(value = "desc")
    private String desc;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 点赞
     */
    @TableField(value = "like")
    private String like;

    /**
     * 评论
     */
    @TableField(value = "comment")
    private String comment;

    /**
     * 收藏
     */
    @TableField(value = "collect")
    private String collect;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}