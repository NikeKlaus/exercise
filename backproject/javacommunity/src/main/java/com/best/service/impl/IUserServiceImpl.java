package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.User;
import com.best.mapper.UserMapper;
import com.best.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户业务层实现类
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.selectList(null);
    }
}
