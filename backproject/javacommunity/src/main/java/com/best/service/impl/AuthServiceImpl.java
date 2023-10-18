package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Auth;
import com.best.mapper.AuthMapper;
import com.best.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @author 86199
 * @description 针对表【auth】的数据库操作Service实现
 * @createDate 2023-10-18 22:40:08
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthService {

}




