package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.UserBlog;
import com.best.mapper.UserBlogMapper;
import com.best.service.UserBlogService;
import org.springframework.stereotype.Service;

/**
 * @author 86199
 * @description 针对表【user_blog】的数据库操作Service实现
 * @createDate 2023-10-18 22:40:08
 */
@Service
public class UserBlogServiceImpl extends ServiceImpl<UserBlogMapper, UserBlog> implements UserBlogService {

}




