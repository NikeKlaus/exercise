package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Blog;
import com.best.mapper.BlogMapper;
import com.best.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * @author 86199
 * @description 针对表【blog】的数据库操作Service实现
 * @createDate 2023-10-18 22:40:08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}




