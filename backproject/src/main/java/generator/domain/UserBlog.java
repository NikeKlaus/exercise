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
 * @TableName user_blog
 */
@TableName(value ="user_blog")
@Data
public class UserBlog implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer userId;

    /**
     * 
     */
    @TableId
    private Integer blogId;

    /**
     * 
     */
    @TableId
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}