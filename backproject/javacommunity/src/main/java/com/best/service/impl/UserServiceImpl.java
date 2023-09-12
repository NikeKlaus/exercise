package com.best.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.common.PageEntity;
import com.best.entity.User;
import com.best.mapper.UserMapper;
import com.best.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户业务层实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public PageEntity<User> listPage(Integer pageNo, Integer pageSize, String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(User::getUsername, username);
        Page<User> page = new Page<>(pageNo, pageSize);
        Page<User> adminPage = userMapper.selectPage(page, queryWrapper);
        return new PageEntity<>(pageNo, pageSize, adminPage.getRecords(), adminPage.getTotal());
    }
}
