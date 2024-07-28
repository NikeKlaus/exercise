package com.best.controller;

import com.best.common.ResponseData;
import com.best.entity.Auth;
import com.best.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2024/7/7 23:14
 * @description
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("list")
    public ResponseData<List<Auth>> list() {
        return ResponseData.success(authService.list());
    }

    @PostMapping("update")
    public ResponseData<String> update(@RequestBody Auth auth) {
        boolean b = authService.updateById(auth);
        if (b) {
            return ResponseData.success("查询全部成功");
        }
        return ResponseData.fail("查询全部失败");
    }
}
