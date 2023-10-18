package com.best.controller;

import com.best.common.ResponseData;
import com.best.model.user.UserManager;
import com.best.vo.UserVO;
import org.apache.commons.collections4.CollectionUtils;
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
        List<UserVO.ListUserVO> users = userManager.listAll();
        if (CollectionUtils.isNotEmpty(users)) {
            return ResponseData.success("查询全部用户成功", users);
        }
        return ResponseData.fail("查询全部用户失败");
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveUser(@RequestBody UserVO.SaveUserVO saveUserVO) {
        if (userManager.saveUser(saveUserVO)) {
            return ResponseData.success("插入用户成功", true);
        }
        return ResponseData.fail("插入用户失败");
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateUser(@RequestBody UserVO.UpdateUserVO updateUserVO) {
        if (userManager.updateUser(updateUserVO)) {
            return ResponseData.success("修改用户成功", true);
        }
        return ResponseData.fail("修改用户失败");
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeUserById(@RequestParam("userId") String userId) {
        if (userManager.removeUserById(userId)) {
            return ResponseData.success("删除用户成功", true);
        }
        return ResponseData.fail("删除用户失败");
    }
}
