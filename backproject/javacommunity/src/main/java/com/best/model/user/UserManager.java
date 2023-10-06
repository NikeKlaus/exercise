package com.best.model.user;

import com.best.entity.User;
import com.best.service.IUserService;
import com.best.vo.UserVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/10/5 15:18
 * @description
 */
@Component
public class UserManager {
    @Resource
    private IUserService iUserService;

    public List<UserVO.ListUserVO> listAll() {
        List<User> userList = iUserService.listAll();
        return UserConvert.INSTANCT.toListUserVOList(userList);
    }

    public Boolean saveUser(UserVO.SaveUserVO saveUserVO) {
        User user = UserConvert.INSTANCT.toUser(saveUserVO);
        user.setDeleted(0);
        return iUserService.save(user);
    }

    public Boolean updateUser(UserVO.UpdateUserVO updateUserVO) {
        User user = UserConvert.INSTANCT.toUser(updateUserVO);
        if ("".equals(user.getPassword())) {
            user.setPassword(null);
        }
        return iUserService.updateById(user);
    }

    public Boolean removeUserById(String userId) {
        return iUserService.removeById(userId);
    }
}
