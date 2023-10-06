package com.best.model.admin;

import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.service.IAdminService;
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
    private IAdminService iAdminService;

    public PageEntity<AdminVO.ListAdminVO> listPage(Integer pageNo, Integer pageSize, String name) {
        PageEntity<Admin> adminPageEntity = iAdminService.listPage(pageNo, pageSize, name);
        return AdminConvert.INSTANCE.toAdminListVOList(adminPageEntity);
    }

    public List<AdminVO.ListAdminVO> adminList() {
        List<Admin> adminList = iAdminService.adminList();
        return AdminConvert.INSTANCE.toAdminListVOList(adminList);
    }

    public List<AdminVO.ListAdminVO> selectAdminByCondition(ConditionVO conditionVO) {
        ConditionDTO conditionDTO = AdminConvert.INSTANCE.toConditionDTO(conditionVO);
        List<Admin> adminList = iAdminService.selectAdminByCondition(conditionDTO);
        return AdminConvert.INSTANCE.toAdminListVOList(adminList);
    }

    public Boolean updateById(AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        Admin admin = AdminConvert.INSTANCE.toAdmin(updateAdminInfoVO);
        if ("".equals(admin.getPassword())){
            admin.setPassword(null);
        }
        return iAdminService.batchUpdateAdminById(Collections.singletonList(admin));
    }

    public Boolean removeById(String adminId) {
        return iAdminService.batchDeleteAdminById(Collections.singletonList(adminId));
    }

    public Boolean save(AdminVO.SaveAdminVO saveAdminVO) {
        Admin admin = AdminConvert.INSTANCE.toAdmin(saveAdminVO);
        return iAdminService.batchInsertByAdminList(Collections.singletonList(admin));
    }
}
