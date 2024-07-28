package com.best.model.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.mapper.AdminMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author cctv14
 * @data 2023/9/29 16:53
 * @description
 */
@Component
public class AdminManager {

    @Resource
    private AdminMapper adminMapper;

    public PageEntity<Admin> listPage(Integer pageNo, Integer pageSize, String name) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Objects.nonNull(name), Admin::getName, name);
        if (Objects.isNull(pageNo) || pageNo < 1) {
            pageNo = 1;
        }
        if (Objects.isNull(pageSize)) {
            pageSize = -1;
        }
        Page<Admin> page = new Page<>(pageNo, pageSize);
        Page<Admin> adminPage = adminMapper.selectPage(page, queryWrapper);
        List<Admin> records = adminPage.getRecords();
        return new PageEntity<>(pageNo, pageSize, records, (long) records.size());
    }

    public List<Admin> adminList() {
        return adminMapper.adminList();
    }

    public List<Admin> selectAdminByCondition(ConditionDTO conditionDTO) {
        return adminMapper.selectAdminByCondition(conditionDTO);
    }
}
