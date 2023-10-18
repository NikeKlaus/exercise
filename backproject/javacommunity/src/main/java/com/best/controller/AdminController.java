package com.best.controller;

import com.best.common.PageEntity;
import com.best.common.ResponseData;
import com.best.model.admin.AdminManager;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import org.apache.commons.collections4.CollectionUtils;
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
    private AdminManager adminManager;

    @GetMapping("/listPage")
    public ResponseData<PageEntity<AdminVO.ListAdminVO>> listPage(Integer pageNo, Integer pageSize, String name) {
        PageEntity<AdminVO.ListAdminVO> result = adminManager.listPage(pageNo, pageSize, name);
        if (CollectionUtils.isNotEmpty(result.getRecords())) {
            return ResponseData.success("分页查询成功", result);
        }
        return ResponseData.fail("分页查询失败");
    }

    @GetMapping("/listAll")
    public ResponseData<List<AdminVO.ListAdminVO>> listAll() {
        List<AdminVO.ListAdminVO> admins = adminManager.adminList();
        if (CollectionUtils.isNotEmpty(admins)) {
            return ResponseData.success("查询全部成功", admins);
        }
        return ResponseData.fail("查询全部失败");
    }

    @PostMapping("/condition")
    public ResponseData<List<AdminVO.ListAdminVO>> selectAdminByCondition(@RequestBody ConditionVO conditionVO) {
        List<AdminVO.ListAdminVO> admins = adminManager.selectAdminByCondition(conditionVO);
        if (CollectionUtils.isNotEmpty(admins)) {
            return ResponseData.success("条件查询成功", admins);
        }
        return ResponseData.fail("条件查询失败");
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateAdmin(@RequestBody AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        if (adminManager.updateById(updateAdminInfoVO)) {
            return ResponseData.success("修改成功", true);
        }
        return ResponseData.fail("修改失败");
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveAdmin(@RequestBody AdminVO.SaveAdminVO saveAdminVO) {
        if (adminManager.save(saveAdminVO)) {
            return ResponseData.success("添加成功", true);
        }
        return ResponseData.fail("添加失败");
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeAdminById(@RequestParam("adminId") String adminId) {
        if (adminManager.removeById(adminId)) {
            return ResponseData.success("删除成功", true);
        }
        return ResponseData.fail("删除失败");
    }
}
