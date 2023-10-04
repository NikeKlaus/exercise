package com.best.controller;

import com.best.common.PageEntity;
import com.best.common.ResponseData;
import com.best.entity.User;
import com.best.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    @GetMapping("/listPage")
    public ResponseData<PageEntity<User>> listPage(Integer pageNo, Integer pageSize, String username) {
//        ResponseData.success(BaseEnum.OK);
        return ResponseData.success("查询成功", iUserService.listPage(pageNo, pageSize, username));
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateAdmin(@RequestBody User user) {
        return ResponseData.success("修改成功", iUserService.updateById(user));
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeAdminById(@RequestParam("id") Integer id) {
        return ResponseData.success("删除成功", iUserService.removeById(id));
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveAdmin(@RequestBody User user) {
        user.setDeleted(0);
        return ResponseData.success("添加成功", iUserService.save(user));
    }
}
