package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Menu;
import generator.service.MenuService;
import generator.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-10-05 23:16:31
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




