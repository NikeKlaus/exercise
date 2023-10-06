package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Role;
import generator.service.RoleService;
import generator.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-10-05 23:16:32
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




