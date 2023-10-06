package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Award;
import generator.service.AwardService;
import generator.mapper.AwardMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【award】的数据库操作Service实现
* @createDate 2023-10-05 23:16:31
*/
@Service
public class AwardServiceImpl extends ServiceImpl<AwardMapper, Award>
    implements AwardService{

}




