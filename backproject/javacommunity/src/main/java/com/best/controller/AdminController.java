package com.best.controller;

import com.best.common.PageEntity;
import com.best.common.ResponseData;
import com.best.model.admin.AdminManager;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import lombok.extern.slf4j.Slf4j;
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
        return ResponseData.success("分页查询成功", adminManager.listPage(pageNo, pageSize, name));
    }

    @GetMapping("/listAll")
    public ResponseData<List<AdminVO.ListAdminVO>> listAll() {
        return ResponseData.success("查询全部成功", adminManager.adminList());
    }

    @PostMapping("/condition")
    public ResponseData<List<AdminVO.ListAdminVO>> selectAdminByCondition(@RequestBody ConditionVO conditionVO) {
        return ResponseData.success("条件查询成功", adminManager.selectAdminByCondition(conditionVO));
    }

    @PostMapping("/update")
    public ResponseData<Boolean> updateAdmin(@RequestBody AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        return ResponseData.success("修改成功", adminManager.updateById(updateAdminInfoVO));
    }

    @PostMapping("/save")
    public ResponseData<Boolean> saveAdmin(@RequestBody AdminVO.SaveAdminVO saveAdminVO) {
        return ResponseData.success("添加成功", adminManager.save(saveAdminVO));
    }

    @PostMapping("/remove")
    public ResponseData<Boolean> removeAdminById(@RequestParam("adminId") String adminId) {
        return ResponseData.success("删除成功", adminManager.removeById(adminId));
    }
}
