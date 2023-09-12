package com.best.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.common.PageEntity;
import com.best.entity.Admin;
import com.best.mapper.AdminMapper;
import com.best.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员业务实现类
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
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
}
