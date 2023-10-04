package com.best.mapper;

import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/4 22:54
 * @description 管理员 mapper
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 查询全部管理员
     */
    List<Admin> aminList();

    /**
     * 按照条件查询
     */
    List<Admin> selectAdminByCondition(ConditionDTO condition);

    /**
     * 批量插入
     */
    boolean batchInsertByAdminList(List<Admin> adminList);

    /**
     * 批量修改
     */
    boolean batchUpdateAdminById(List<Admin> adminList);

    /**
     * 批量删除
     */
    boolean batchDeleteAdminById(List<Integer> idList);
}
