package com.best.controller;

import com.best.common.PageEntity;
import com.best.common.ResponseData;
import com.best.entity.Admin;
import com.best.service.AdminService;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    private AdminService adminService;

    @GetMapping("/listPage")
    public ResponseData<PageEntity<AdminVO.AdminInfoVO>> listPage(Integer pageNo, Integer pageSize, String name) {
        PageEntity<AdminVO.AdminInfoVO> result = adminService.listPage(pageNo, pageSize, name);
        if (CollectionUtils.isNotEmpty(result.getRecords())) {
            return ResponseData.success("分页查询成功", result);
        }
        return ResponseData.fail("分页查询失败");
    }

    @GetMapping("/listAll")
    public ResponseData<List<AdminVO.AdminInfoVO>> listAll() {
        List<AdminVO.AdminInfoVO> admins = adminService.adminList();
        if (CollectionUtils.isNotEmpty(admins)) {
            return ResponseData.success("查询全部成功", admins);
        }
        return ResponseData.fail("查询全部失败");
    }

    @PostMapping("/selectByCondition")
    public ResponseData<List<AdminVO.AdminInfoVO>> selectByCondition(@RequestBody ConditionVO conditionVO) {
        List<AdminVO.AdminInfoVO> admins = adminService.selectAdminByCondition(conditionVO);
        if (CollectionUtils.isNotEmpty(admins)) {
            return ResponseData.success("条件查询成功", admins);
        }
        return ResponseData.fail("条件查询失败");
    }

    @PostMapping("/update")
    public ResponseData<Boolean> update(@RequestBody AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(updateAdminInfoVO, admin);
        if (adminService.updateById(admin)) {
            return ResponseData.success("修改成功", true);
        }
        return ResponseData.fail("修改失败");
    }

    @PostMapping("/save")
    public ResponseData<Boolean> save(@RequestBody AdminVO.SaveAdminVO saveAdminVO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(saveAdminVO, admin);
        if (adminService.save(admin)) {
            return ResponseData.success("添加成功", true);
        }
        return ResponseData.fail("添加失败");
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> remove(@RequestParam("adminId") String adminId) {
        if (adminService.removeById(adminId)) {
            return ResponseData.success("删除成功", true);
        }
        return ResponseData.fail("删除失败");
    }
}
