package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName blog
 */
@TableName(value ="blog")
@Data
public class Blog implements Serializable {
    /**
     * 博客主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 博客ID
     */
    private String blogId;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞
     */
    private String like;

    /**
     * 评论
     */
    private String comment;

    /**
     * 收藏
     */
    private String collect;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}