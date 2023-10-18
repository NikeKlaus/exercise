package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author coffeemao
 * @description 书籍实体
 * @since 2023-10-18
 */
@Data
@TableName(value = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableId(value = "book_id", type = IdType.ASSIGN_ID)
    private String bookId;

    @TableField("book_name")
    private String bookName;

    @TableField("author")
    private String author;

    @TableField("desc")
    private String desc;

    @TableField("price")
    private BigDecimal price;

    @TableField("press")
    private String press;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}