package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.entity.Book;
import com.best.mapper.BookMapper;
import com.best.service.BookService;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-10-18 22:40:08
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}




