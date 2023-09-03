package com.best.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.best.entity.Admin;
import com.best.mapper.AdminMapper;
import com.best.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> listPage(Integer page, Integer size, String name) {
        page = page < 1 ? 1 : page;
        size = size < 5 ? 5 : size;
        System.out.println("page:"+page+"size:"+size);
        Page<Admin> pager = new Page<>((page - 1) * page, size);
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        return adminMapper.selectPage(pager, queryWrapper).getRecords();
    }
}
