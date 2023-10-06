package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Auth;
import generator.service.AuthService;
import generator.mapper.AuthMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【auth】的数据库操作Service实现
* @createDate 2023-10-05 23:16:31
*/
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth>
    implements AuthService{

}




