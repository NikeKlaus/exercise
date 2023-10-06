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
 * @TableName menu
 */
@TableName(value ="menu")
@Data
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 
     */
    private String menuId;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private String desc;

    /**
     * 
     */
    private String level;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String sort;

    /**
     * 隐藏，级别最高
     */
    private Integer hide;

    /**
     * 是否受控
     */
    private Integer ctrl;

    /**
     * 无受控之下权限是否隐藏，级别最低
     */
    private Integer authHide;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}