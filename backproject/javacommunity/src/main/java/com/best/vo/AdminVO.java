package com.best.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Data
public class AdminVO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    @ApiModel(value = "AdminInfoVO", description = "查询管理员列表VO")
    public static class AdminInfoVO {

        @ApiModelProperty("管理员唯一ID")
        private String adminId;

        private String name;

        private String password;

        private Date createTime;

        private Date updateTime;

        private Integer deleted;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "UpdateAdminInfoVO", description = "更新管理员信息VO")
    public static class UpdateAdminInfoVO {

        @ApiModelProperty("管理员唯一ID")
        private String adminId;

        private String name;

        private String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "SaveAdminVO", description = "新增管理员VO")
    public static class SaveAdminVO {

        private String name;

        private String password;
    }
}
