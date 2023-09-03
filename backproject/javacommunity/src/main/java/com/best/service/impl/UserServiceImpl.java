package com.best.service.impl;

import com.best.entity.User;
import com.best.mapper.UserMapper;
import com.best.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
