package com.best.service.convert;

import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T23:10:41+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AdminConvertImpl implements AdminConvert {

    @Override
    public PageEntity<AdminVO.AdminInfoVO> toAdminListVOList(PageEntity<Admin> adminList) {
        if ( adminList == null ) {
            return null;
        }

        PageEntity<AdminVO.AdminInfoVO> pageEntity = new PageEntity<AdminVO.AdminInfoVO>();

        pageEntity.setPageNo( adminList.getPageNo() );
        pageEntity.setPageSize( adminList.getPageSize() );
        pageEntity.setRecords( toAdminListVOList( adminList.getRecords() ) );
        pageEntity.setTotal( adminList.getTotal() );

        return pageEntity;
    }

    @Override
    public List<AdminVO.AdminInfoVO> toAdminListVOList(List<Admin> adminList) {
        if ( adminList == null ) {
            return null;
        }

        List<AdminVO.AdminInfoVO> list = new ArrayList<AdminVO.AdminInfoVO>( adminList.size() );
        for ( Admin admin : adminList ) {
            list.add( adminToAdminInfoVO( admin ) );
        }

        return list;
    }

    @Override
    public Admin toAdmin(AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        if ( updateAdminInfoVO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setAdminId( updateAdminInfoVO.getAdminId() );
        admin.setName( updateAdminInfoVO.getName() );
        admin.setPassword( updateAdminInfoVO.getPassword() );

        return admin;
    }

    @Override
    public Admin toAdmin(AdminVO.SaveAdminVO saveAdminVO) {
        if ( saveAdminVO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setName( saveAdminVO.getName() );
        admin.setPassword( saveAdminVO.getPassword() );

        return admin;
    }

    @Override
    public ConditionDTO toConditionDTO(ConditionVO conditionVO) {
        if ( conditionVO == null ) {
            return null;
        }

        ConditionDTO conditionDTO = new ConditionDTO();

        conditionDTO.setId( conditionVO.getId() );
        conditionDTO.setName( conditionVO.getName() );
        conditionDTO.setStartTime( conditionVO.getStartTime() );
        conditionDTO.setEndTime( conditionVO.getEndTime() );

        return conditionDTO;
    }

    protected AdminVO.AdminInfoVO adminToAdminInfoVO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminVO.AdminInfoVO adminInfoVO = new AdminVO.AdminInfoVO();

        adminInfoVO.setAdminId( admin.getAdminId() );
        adminInfoVO.setName( admin.getName() );
        adminInfoVO.setPassword( admin.getPassword() );
        adminInfoVO.setCreateTime( admin.getCreateTime() );
        adminInfoVO.setUpdateTime( admin.getUpdateTime() );
        adminInfoVO.setDeleted( admin.getDeleted() );

        return adminInfoVO;
    }
}
