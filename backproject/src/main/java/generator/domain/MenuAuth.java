package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName menu_auth
 */
@TableName(value ="menu_auth")
@Data
public class MenuAuth implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer menuId;

    /**
     * 
     */
    @TableId
    private Integer authId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}