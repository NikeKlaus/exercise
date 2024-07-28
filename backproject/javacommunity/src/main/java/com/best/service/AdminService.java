package com.best.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.common.PageEntity;
import com.best.entity.Admin;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员业务接口
 */
public interface AdminService extends IService<Admin> {

    /**
     * @param pageNo 页号
     * @param pageSize 页尺寸
     * @param name 管理员姓名
     * @return 分页查询管理员基本信息
     */
    PageEntity<AdminVO.AdminInfoVO> listPage(Integer pageNo, Integer pageSize, String name);

    /**
     * @return 查询全部
     */
    List<AdminVO.AdminInfoVO> adminList();

    /**
     * @param conditionVO 条件
     * @return 根据条件查询
     */
    List<AdminVO.AdminInfoVO> selectAdminByCondition(ConditionVO conditionVO);
}
