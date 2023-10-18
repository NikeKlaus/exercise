package com.best.model.admin;

import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.service.AdminService;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/29 16:53
 * @description
 */
@Component
public class AdminManager {

    @Resource
    private AdminService adminService;

    public PageEntity<AdminVO.ListAdminVO> listPage(Integer pageNo, Integer pageSize, String name) {
        PageEntity<Admin> adminPageEntity = adminService.listPage(pageNo, pageSize, name);
        return AdminConvert.INSTANCE.toAdminListVOList(adminPageEntity);
    }

    public List<AdminVO.ListAdminVO> adminList() {
        List<Admin> adminList = adminService.adminList();
        return AdminConvert.INSTANCE.toAdminListVOList(adminList);
    }

    public List<AdminVO.ListAdminVO> selectAdminByCondition(ConditionVO conditionVO) {
        ConditionDTO conditionDTO = AdminConvert.INSTANCE.toConditionDTO(conditionVO);
        List<Admin> adminList = adminService.selectAdminByCondition(conditionDTO);
        return AdminConvert.INSTANCE.toAdminListVOList(adminList);
    }

    public boolean updateById(AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        Admin admin = AdminConvert.INSTANCE.toAdmin(updateAdminInfoVO);
        if ("".equals(admin.getPassword())) {
            admin.setPassword(null);
        }
        return adminService.batchUpdateAdminById(Collections.singletonList(admin));
    }

    public boolean removeById(String adminId) {
        return adminService.batchDeleteAdminById(Collections.singletonList(adminId));
    }

    public boolean save(AdminVO.SaveAdminVO saveAdminVO) {
        Admin admin = AdminConvert.INSTANCE.toAdmin(saveAdminVO);
        return adminService.batchInsertByAdminList(Collections.singletonList(admin));
    }
}
