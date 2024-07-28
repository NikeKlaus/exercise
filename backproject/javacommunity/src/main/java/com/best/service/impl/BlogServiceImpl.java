package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Blog;
import com.best.mapper.BlogMapper;
import com.best.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 博文业务实现类
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}




