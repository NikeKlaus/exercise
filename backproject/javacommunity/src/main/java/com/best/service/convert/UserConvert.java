package com.best.service.convert;

import com.best.entity.User;
import com.best.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/29 16:36
 * @description 管理员类型转化
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCT = Mappers.getMapper(UserConvert.class);

    UserVO.ListUserVO toListUserVO(User user);

    List<UserVO.ListUserVO> toListUserVOList(List<User> userList);

    User toUser(UserVO.SaveUserVO saveUserVO);
    User toUser(UserVO.UpdateUserVO updateUserVO);
}
