package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.common.PageEntity;
import com.best.entity.Admin;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员业务接口
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 分页查询管理员
     * @param pageNo 页号
     * @param pageSize 分页大小
     * @param name 查询姓名
     * @return PageEntity
     */
    PageEntity<Admin> listPage(Integer pageNo, Integer pageSize, String name);


}
