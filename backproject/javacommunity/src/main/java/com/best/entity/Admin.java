package com.best.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Data
@ApiModel(value = "Admin对象", description = "管理员实体类")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    @TableLogic
    private Integer deleted;
    @Override
    public String toString() {
        return "Admin{" +
            "id=" + id +
            ", name=" + name +
            ", password=" + password +
        "}";
    }
}
