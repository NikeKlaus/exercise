package com.best;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.best.entity.User;
import com.best.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/11/26 11:31
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        for (User user : users) {
            System.out.println(user.getUpdateTime());
        }
        System.out.println(users);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("ok");
        user.setPassword("123456");
        Date date = new Date();
        user.setUpdateTime(date);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
