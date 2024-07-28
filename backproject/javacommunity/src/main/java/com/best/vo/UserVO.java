package com.best.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cctv14
 * @data 2023/10/5 20:47
 * @description
 */
@Data
public class UserVO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "ListUserVO", description = "查询用户列表VO")
    public static class ListUserVO {

        private String userId;

        private String username;

        private String password;

        private String userOfRole;

        private String avatar;

        private Integer age;

        private Integer gender;

        private String email;

        private String phone;

        private Date createTime;

        private Date updateTime;

        private Integer deleted;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "SaveUserVO", description = "添加用户VO")
    public static class SaveUserVO {
        private String username;

        private String password;

        private String userOfRole;

        private String avatar;

        private Integer age;

        private Integer gender;

        private String email;

        private String phone;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "UpdateUserVO", description = "修改用户VO")
    public static class UpdateUserVO {

        private String userId;

        private String username;

        // TODO password userOfRole 修改
        private String password;

        private String userOfRole;

        private String avatar;

        private Integer age;

        private Integer gender;

        private String email;

        private String phone;
    }
}
