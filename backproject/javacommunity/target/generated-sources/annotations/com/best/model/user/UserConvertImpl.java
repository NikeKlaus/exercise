package com.best.model.user;

import com.best.entity.User;
import com.best.service.convert.UserConvert;
import com.best.vo.UserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T22:10:49+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserVO.ListUserVO toListUserVO(User user) {
        if ( user == null ) {
            return null;
        }

        UserVO.ListUserVO listUserVO = new UserVO.ListUserVO();

        listUserVO.setUserId( user.getUserId() );
        listUserVO.setUsername( user.getUsername() );
        listUserVO.setPassword( user.getPassword() );
        listUserVO.setUserOfRole( user.getUserOfRole() );
        listUserVO.setAvatar( user.getAvatar() );
        listUserVO.setAge( user.getAge() );
        listUserVO.setGender( user.getGender() );
        listUserVO.setEmail( user.getEmail() );
        listUserVO.setPhone( user.getPhone() );
        listUserVO.setCreateTime( user.getCreateTime() );
        listUserVO.setUpdateTime( user.getUpdateTime() );
        listUserVO.setDeleted( user.getDeleted() );

        return listUserVO;
    }

    @Override
    public List<UserVO.ListUserVO> toListUserVOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserVO.ListUserVO> list = new ArrayList<UserVO.ListUserVO>( userList.size() );
        for ( User user : userList ) {
            list.add( toListUserVO( user ) );
        }

        return list;
    }

    @Override
    public User toUser(UserVO.SaveUserVO saveUserVO) {
        if ( saveUserVO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( saveUserVO.getUsername() );
        user.setPassword( saveUserVO.getPassword() );
        user.setUserOfRole( saveUserVO.getUserOfRole() );
        user.setAvatar( saveUserVO.getAvatar() );
        user.setAge( saveUserVO.getAge() );
        user.setGender( saveUserVO.getGender() );
        user.setEmail( saveUserVO.getEmail() );
        user.setPhone( saveUserVO.getPhone() );

        return user;
    }

    @Override
    public User toUser(UserVO.UpdateUserVO updateUserVO) {
        if ( updateUserVO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( updateUserVO.getUserId() );
        user.setUsername( updateUserVO.getUsername() );
        user.setPassword( updateUserVO.getPassword() );
        user.setUserOfRole( updateUserVO.getUserOfRole() );
        user.setAvatar( updateUserVO.getAvatar() );
        user.setAge( updateUserVO.getAge() );
        user.setGender( updateUserVO.getGender() );
        user.setEmail( updateUserVO.getEmail() );
        user.setPhone( updateUserVO.getPhone() );

        return user;
    }
}
