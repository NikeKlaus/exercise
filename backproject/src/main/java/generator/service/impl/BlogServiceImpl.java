package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Blog;
import generator.service.BlogService;
import generator.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【blog】的数据库操作Service实现
* @createDate 2023-10-05 23:16:31
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

}




