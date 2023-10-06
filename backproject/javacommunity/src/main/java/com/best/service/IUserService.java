package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.common.PageEntity;
import com.best.entity.User;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户业务接口
 */
public interface IUserService extends IService<User> {
    List<User> listAll();
}
