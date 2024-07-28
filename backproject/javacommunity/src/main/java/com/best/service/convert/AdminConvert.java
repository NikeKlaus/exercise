package com.best.service.convert;

import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author cctv14
 * @data 2023/9/29 16:36
 * @description 管理员类型转化
 */
@Mapper
public interface AdminConvert {

    AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);

    PageEntity<AdminVO.AdminInfoVO> toAdminListVOList(PageEntity<Admin> adminList);
    List<AdminVO.AdminInfoVO> toAdminListVOList(List<Admin> adminList);

    Admin toAdmin(AdminVO.UpdateAdminInfoVO updateAdminInfoVO);

    Admin toAdmin(AdminVO.SaveAdminVO saveAdminVO);

    ConditionDTO toConditionDTO(ConditionVO conditionVO);
}
