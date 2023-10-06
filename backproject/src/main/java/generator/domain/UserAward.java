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
 * @TableName user_award
 */
@TableName(value ="user_award")
@Data
public class UserAward implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer userId;

    /**
     * 
     */
    @TableId
    private Integer awardId;

    /**
     * 
     */
    @TableId
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}