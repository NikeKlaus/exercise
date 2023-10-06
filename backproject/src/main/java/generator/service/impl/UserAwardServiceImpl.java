package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.UserAward;
import generator.service.UserAwardService;
import generator.mapper.UserAwardMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【user_award】的数据库操作Service实现
* @createDate 2023-10-05 23:16:32
*/
@Service
public class UserAwardServiceImpl extends ServiceImpl<UserAwardMapper, UserAward>
    implements UserAwardService{

}




