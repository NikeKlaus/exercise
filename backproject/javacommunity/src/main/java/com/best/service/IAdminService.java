package com.best.service;

import com.best.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author coffeemao
 * @since 2023-06-05
 */
public interface IAdminService extends IService<Admin> {
    List<Admin> listPage(Integer page, Integer size, String name);
}
