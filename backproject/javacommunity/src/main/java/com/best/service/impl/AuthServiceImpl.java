package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Auth;
import com.best.mapper.AuthMapper;
import com.best.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 权限业务实现类
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthService {

}




