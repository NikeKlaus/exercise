package com.best.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdminVO {

    private Integer id;

    private String adminId;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;
}
