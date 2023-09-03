package com.best.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Data
@ApiModel(value = "User对象", description = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别 0 女；1 男")
    private Integer gender;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty("版本信息")
    @Version
    private Integer version;

    @ApiModelProperty("逻辑删除 0 未删除；1删除")
    @TableLogic
    private Integer deleted;


    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", age=" + age +
            ", gender=" + gender +
            ", email=" + email +
            ", phone=" + phone +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", version=" + version +
            ", deleted=" + deleted +
        "}";
    }
}
