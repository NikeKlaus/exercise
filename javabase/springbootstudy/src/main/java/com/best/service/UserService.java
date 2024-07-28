package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/15 22:15
 * @description
 */
public interface UserService extends IService<User> {
    List<User> list();
}
