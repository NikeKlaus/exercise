package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.UserBlog;
import generator.service.UserBlogService;
import generator.mapper.UserBlogMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【user_blog】的数据库操作Service实现
* @createDate 2023-10-05 23:16:32
*/
@Service
public class UserBlogServiceImpl extends ServiceImpl<UserBlogMapper, UserBlog>
    implements UserBlogService{

}




