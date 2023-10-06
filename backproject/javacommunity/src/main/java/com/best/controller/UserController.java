package com.best.controller;

import com.best.common.ResponseData;
import com.best.model.user.UserManager;
import com.best.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 用户控制器
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserManager userManager;

    @GetMapping("/listAll")
    public ResponseData<List<UserVO.ListUserVO>> listAll() {
        return ResponseData.success("查询全部用户成功", userManager.listAll());
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveUser(@RequestBody UserVO.SaveUserVO saveUserVO) {
        return ResponseData.success("插入用户成功", userManager.saveUser(saveUserVO));
    }
    @PostMapping("/update")
    public ResponseData<Boolean> updateUser(@RequestBody UserVO.UpdateUserVO updateUserVO) {
        return ResponseData.success("修改用户成功", userManager.updateUser(updateUserVO));
    }
    @PostMapping("/remove")
    public ResponseData<Boolean> removeUserById(@RequestParam("userId") String userId) {
        return ResponseData.success("删除用户成功", userManager.removeUserById(userId));
    }
}
