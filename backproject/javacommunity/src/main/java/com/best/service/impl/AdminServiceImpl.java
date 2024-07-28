package com.best.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.mapper.AdminMapper;
import com.best.model.admin.AdminManager;
import com.best.service.AdminService;
import com.best.service.convert.AdminConvert;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员业务实现类
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminManager adminManager;

    @Override
    public PageEntity<AdminVO.AdminInfoVO> listPage(Integer pageNo, Integer pageSize, String name) {
        PageEntity<Admin> adminPageEntity = adminManager.listPage(pageNo, pageSize, name);
        return AdminConvert.INSTANCE.toAdminListVOList(adminPageEntity);
    }

    @Override
    public List<AdminVO.AdminInfoVO> adminList() {
        List<Admin> admins = adminManager.adminList();
        return AdminConvert.INSTANCE.toAdminListVOList(admins);
    }

    @Override
    public List<AdminVO.AdminInfoVO> selectAdminByCondition(ConditionVO conditionVO) {
        ConditionDTO conditionDTO = AdminConvert.INSTANCE.toConditionDTO(conditionVO);
        List<Admin> adminList = adminManager.selectAdminByCondition(conditionDTO);
        return AdminConvert.INSTANCE.toAdminListVOList(adminList);
    }

}
