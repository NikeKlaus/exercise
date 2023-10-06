package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员业务接口
 */
public interface IAdminService extends IService<Admin> {

    PageEntity<Admin> listPage(Integer pageNo, Integer pageSize, String name);

    List<Admin> adminList();

    List<Admin> selectAdminByCondition(ConditionDTO conditionDTO);

    boolean batchInsertByAdminList(List<Admin> adminList);

    boolean batchUpdateAdminById(List<Admin> adminList);

    boolean batchDeleteAdminById(List<String> idList);
}
