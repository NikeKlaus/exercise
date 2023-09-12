package com.best.controller;

import com.best.common.PageEntity;
import com.best.common.ResponseData;
import com.best.entity.Admin;
import com.best.service.IAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员控制器
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Resource
    private IAdminService iAdminService;

    @GetMapping("/listPage")
    public ResponseData<PageEntity<Admin>> listPage(Integer pageNo, Integer pageSize, String name) {
        return ResponseData.success("查询成功", iAdminService.listPage(pageNo, pageSize, name));
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateAdmin(@RequestBody Admin admin) {
        return ResponseData.success("修改成功", iAdminService.updateById(admin));
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeAdminById(@RequestParam("id") Integer id) {
        return ResponseData.success("删除成功", iAdminService.removeById(id));
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveAdmin(@RequestBody Admin admin) {
        admin.setDeleted(0);
        return ResponseData.success("添加成功", iAdminService.save(admin));
    }
}
