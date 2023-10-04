package com.best.controller;


import com.best.common.ResponseData;
import com.best.entity.User;
import com.best.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/15 21:06
 * @description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private DataSource dataSource;

    @GetMapping("/getDatabase")
    public String getDatabase() throws SQLException {
        Connection connection = dataSource.getConnection();
        // 其他数据源信息
        System.out.println(connection);
        return connection.getSchema();
    }

    @GetMapping("/list")
    public ResponseData<List<User>> list() {
        log.info("查询全部 >>>   {} ", userService.list());
        return ResponseData.success("成功", userService.list());
    }

    /**
     * 需要返回一个 JSON 型的对象
     */
    @ResponseBody
    @GetMapping("/list2")
    public List<User> list2() {
        System.out.println(userService.list());
        return userService.list();
    }

}
