package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.common.PageEntity;
import com.best.entity.User;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户业务接口
 */
public interface IUserService extends IService<User> {
    /**
     * 分页查询用户
     *
     * @param pageNo   页号
     * @param pageSize 分页大小
     * @param username     查询姓名
     * @return PageEntity
     */
    PageEntity<User> listPage(Integer pageNo, Integer pageSize, String username);
}
