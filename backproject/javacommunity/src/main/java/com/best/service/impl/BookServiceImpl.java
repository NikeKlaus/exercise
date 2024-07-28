package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Book;
import com.best.mapper.BookMapper;
import com.best.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 书籍业务实现类
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}




