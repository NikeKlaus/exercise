package com.best.controller;

import com.best.common.R;
import com.best.entity.Admin;
import com.best.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @GetMapping("/list")
    public R list(@RequestParam("page") Integer page, @RequestParam("size")Integer size, @RequestParam("name")String name){
        long count = iAdminService.count();
        HashMap<String, Object> map = new HashMap<>();
        map.put("count",count);
        map.put("data",iAdminService.listPage(page,size,name));
        return R.success("查询成功",map);
    }

    @PostMapping("/update")
    public R update(@RequestBody Admin admin){
        return R.success("修改成功",iAdminService.updateById(admin));
    }

    @PostMapping("/remove")
    public R remove(@RequestParam("id") Integer id){
        return R.success("删除成功",iAdminService.removeById(id));
    }

    @PostMapping("/save")
    public R save(@RequestBody Admin admin){
        admin.setDeleted(0);
        return R.success("添加成功",iAdminService.save(admin));
    }
}
